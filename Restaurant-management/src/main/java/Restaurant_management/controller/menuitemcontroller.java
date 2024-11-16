package Restaurant_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Restaurant_management.Dto.menuitemDto;
import Restaurant_management.Entity.Menuitem;
import Restaurant_management.Entity.Menuitem.Category;
import Restaurant_management.service.menuitemservice;

@RestController
@RequestMapping("/api/menu-items")
public class menuitemcontroller {
	
	@Autowired
	private menuitemservice menuitemservice;
	
	@PostMapping("/post")
	public ResponseEntity<Menuitem> addmenuitem(@RequestBody  menuitemDto menuitemdto){
		
	Menuitem newmenuitem	=menuitemservice.addmenuitem(menuitemdto);
	return new ResponseEntity<>(newmenuitem ,HttpStatus.CREATED);	
		
	}
	
	@GetMapping("/getallitems")
	public ResponseEntity<List<Menuitem>> getMenuItems(@RequestParam(value = "Category", required =false) Category category ){
		
	List<Menuitem> allitems	=menuitemservice.getMenuItems(category);
	return ResponseEntity.ok(allitems);
		
	}
	
	
}
