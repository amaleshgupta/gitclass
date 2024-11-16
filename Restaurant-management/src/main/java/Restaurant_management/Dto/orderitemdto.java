package Restaurant_management.Dto;

public class orderitemdto {
	
	
	 private int menuitems;
	 private Integer quantity;
	 private Double subtotal;
	 
	  
	 
	public orderitemdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderitemdto(int menuitems, Integer quantity, Double subtotal) {
		super();
		this.menuitems = menuitems;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public int getmenuitems() {
		return menuitems;
	}
	public void setMenuItemId(int i) {
		this.menuitems = i;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	 
	 

}
