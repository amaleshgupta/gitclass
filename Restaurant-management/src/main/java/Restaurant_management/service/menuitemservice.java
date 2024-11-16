package Restaurant_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant_management.Dto.menuitemDto;
import Restaurant_management.Entity.Menuitem;
import Restaurant_management.Entity.Menuitem.Category;
import Restaurant_management.Repository.Menuitemrepository;
import Restaurant_management.exception.InvalidDataException;

@Service
public class menuitemservice {
	
	@Autowired
	private Menuitemrepository menuitemrepository;
	
	public Menuitem addmenuitem (menuitemDto menuitemdto) {
		
		if (menuitemdto.getPrice() <= 0) {
            throw new InvalidDataException("Price must be positive");
        }
        Menuitem menuItem = new Menuitem();
        menuItem.setName(menuitemdto.getName());
        menuItem.setPrice(menuitemdto.getPrice());
        menuItem.setAvailablequantity(menuitemdto.getAvailableQuantity());
        menuItem.setCategory(menuitemdto.getCategory());

        return menuitemrepository.save(menuItem);
		
	}
	
	 public List<Menuitem> getMenuItems(Category category) {
	        if (category != null) {
	            return menuitemrepository.findByCategory(category);
	        } else {
	            return menuitemrepository.findAll();
	        }
	    }

}
