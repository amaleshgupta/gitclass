package Restaurant_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Restaurant_management.Dto.orderrequestdto;
import Restaurant_management.Dto.orderresponsedto;
import Restaurant_management.service.OrderService;

@RestController
@RequestMapping("/order")
public class ordercontroller {
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/post")
	public ResponseEntity<orderresponsedto> createorder(@RequestBody orderrequestdto orderrequestdto ){
		
		orderresponsedto createorder	=orderservice.createOrder(orderrequestdto);
		return new ResponseEntity<orderresponsedto>(createorder,HttpStatus.CREATED);
		
		
	}
    @GetMapping("/getbyid/{id}")
	public  ResponseEntity<orderresponsedto> getorderbyid(@PathVariable int id) {
		
		orderresponsedto orderresponse	=orderservice.getOrderById(id);
		return new ResponseEntity<orderresponsedto>(orderresponse,HttpStatus.OK);
		
		
	}
	

}
