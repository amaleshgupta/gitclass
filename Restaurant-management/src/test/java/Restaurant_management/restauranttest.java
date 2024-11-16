package Restaurant_management;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Restaurant_management.Entity.Menuitem;
import Restaurant_management.Entity.Menuitem.Category;
import Restaurant_management.Entity.Orderitem;
import Restaurant_management.Entity.Orders;
import Restaurant_management.Entity.Orders.Status;
import Restaurant_management.Repository.Ordersrepository;
import jakarta.persistence.EnumType;

@SpringBootTest
public class restauranttest {
	
	@Autowired
	private Ordersrepository ordersrepository;
	@Autowired(required =true)
	private Menuitem menuitems;
	
	
	public void saveorders() {
		
		
		Orders od1=new Orders();
		od1.setCustomername("amalesh");
		od1.setCustomernum("9600683826");
		od1.setCreatedat(LocalDateTime.now());
		//od1.setStatus(Status.READY);
		
		
		Orderitem ordered= new Orderitem();
		ordered.setQuantity(2);
		ordered.setSubtotal(1.0);
		ordered.setMenuitems(menuitems);
		
		
		Menuitem menuitems=new Menuitem();
		menuitems.setName("dinner");
		menuitems.setPrice(.10);
		menuitems.setAvailablequantity(10);
		
		
		od1.getItems().add(ordered);
		
		ordersrepository.save(od1);
		
		
		
		
	}

}
