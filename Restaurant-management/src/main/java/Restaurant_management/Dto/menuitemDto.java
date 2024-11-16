package Restaurant_management.Dto;

import Restaurant_management.Entity.Menuitem.Category;

public class menuitemDto {
	
	
	private String name;
    private Double price;
    private int availableQuantity;
    private Category category;
    
    
    
	public menuitemDto() {
		super();
		
	}
	public menuitemDto(String name, Double price, int availableQuantity, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
    

}
