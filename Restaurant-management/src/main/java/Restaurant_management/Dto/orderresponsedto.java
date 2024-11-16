package Restaurant_management.Dto;

import java.time.LocalDateTime;
import java.util.List;

import Restaurant_management.Entity.Orders;
import Restaurant_management.Entity.Orders.Status;

public class orderresponsedto {
	
	
	
	    private int id;
	    private Double totalAmount;
	    private Status status;
	    private LocalDateTime createdAt;
	    private List<orderitemdto> items;
	    private String customerName;
	    private String customerPhone;
	    	    
	    	    
		public orderresponsedto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public orderresponsedto(int id, Double totalAmount, Status status, LocalDateTime createdAt,
				List<orderitemdto> items, String customerName, String customerPhone) {
			super();
			this.id = id;
			this.totalAmount = totalAmount;
			this.status = status;
			this.createdAt = createdAt;
			this.items = items;
			this.customerName = customerName;
			this.customerPhone = customerPhone;
		}
		public int getId() {
			return id;
		}
		public void setId(int i) {
			this.id = i;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public List<orderitemdto> getItems() {
			return items;
		}
		public void setItems(List<orderitemdto> items) {
			this.items = items;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerPhone() {
			return customerPhone;
		}
		public void setCustomerPhone(String customerPhone) {
			this.customerPhone = customerPhone;
		}
	    
	    
	    

}
