package Restaurant_management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant_management.Dto.orderitemdto;
import Restaurant_management.Dto.orderrequestdto;
import Restaurant_management.Dto.orderresponsedto;
import Restaurant_management.Entity.Menuitem;
import Restaurant_management.Entity.Orderitem;
import Restaurant_management.Entity.Orders;
import Restaurant_management.Entity.Orders.Status;
import Restaurant_management.Repository.Menuitemrepository;
import Restaurant_management.Repository.Ordersrepository;
import Restaurant_management.exception.InvalidDataException;
import Restaurant_management.exception.resourcenotfounfexception;

@Service
public class OrderService {
	
	 @Autowired
	 private Ordersrepository orderRepository;

	 @Autowired
	 private Menuitemrepository menuItemRepository;

	public orderresponsedto createOrder(orderrequestdto orderRequestDTO) {
	        validateOrderRequest(orderRequestDTO);

	        Orders order = new Orders();
	        order.setCustomername(orderRequestDTO.getCustomerName());
	        order.setCustomernum(orderRequestDTO.getCustomerPhone());
	        order.setCreatedat(LocalDateTime.now());
	        order.setStatus(Status.RECEIVED);

	        double totalAmount = 0.0;

	        for (orderitemdto itemDTO : orderRequestDTO.getItems()) {
	            Menuitem menuItem = menuItemRepository.findById(itemDTO.getmenuitems())
	                    .orElseThrow(() -> new resourcenotfounfexception("MenuItem not found"));

	            if (itemDTO.getQuantity() > menuItem.getAvailablequantity()) {
	                throw new InvalidDataException("Insufficient quantity for item: " + menuItem.getName());
	            }

	            Orderitem orderItem = new Orderitem();
	            orderItem.setMenuitems(menuItem);
	            orderItem.setQuantity(itemDTO.getQuantity());
	            double subtotal = itemDTO.getQuantity() * menuItem.getPrice();
	            orderItem.setSubtotal(subtotal);

	            order.getItems().add(orderItem);
	            totalAmount += subtotal;

	            // Update inventory
	            menuItem.setAvailablequantity(menuItem.getAvailablequantity() - itemDTO.getQuantity());
	            menuItemRepository.save(menuItem);
	        }

	        order.setTotalamount(totalAmount);
	        Orders savedOrder = orderRepository.save(order);

	        // Return Order Response DTO
	        return convertToResponseDTO(savedOrder);
	    }

	    private void validateOrderRequest(orderrequestdto orderRequestDTO) {
	        if (orderRequestDTO.getItems().isEmpty()) {
	            throw new InvalidDataException("Order must have at least one item");
	        }
	        if (orderRequestDTO.getCustomerName().isEmpty() || orderRequestDTO.getCustomerPhone().isEmpty()) {
	            throw new InvalidDataException("Customer name and phone number are required");
	        }
	    }
//GETORDER BY ID
	    public orderresponsedto getOrderById(int id) {
	        Orders order = orderRepository.findById(id)
	                .orElseThrow(() -> new resourcenotfounfexception("Order not found"));

	        return convertToResponseDTO(order);
	    }

	    private orderresponsedto convertToResponseDTO(Orders order) {
	    	orderresponsedto responseDTO = new orderresponsedto();
	        responseDTO.setId(order.getId());
	        responseDTO.setCustomerName(order.getCustomername());
	        responseDTO.setCustomerPhone(order.getCustomernum());
	        responseDTO.setCreatedAt(order.getCreatedat());
	        responseDTO.setTotalAmount(order.getTotalamount());
	        responseDTO.setStatus(Status.RECEIVED);

	        List<orderitemdto> items = order.getItems().stream()
	                .map(item -> {
	                	orderitemdto itemDTO = new orderitemdto();
	                    itemDTO.setMenuItemId(item.getMenuitems().getId());
	                    itemDTO.setQuantity(item.getQuantity());
	                    return itemDTO;
	                })
	                .collect(Collectors.toList());

	        responseDTO.setItems(items);

	        return responseDTO;
	    }

}
