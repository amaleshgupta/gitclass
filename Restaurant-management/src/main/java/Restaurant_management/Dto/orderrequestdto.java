package Restaurant_management.Dto;

import java.util.List;

public class orderrequestdto {
	
	 private String customerName;
	 private String customerPhone;
	 private List<orderitemdto> items;
	 
	 
 
	public orderrequestdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderrequestdto(String customerName, String customerPhone, List<orderitemdto> items) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
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
	public List<orderitemdto> getItems() {
		return items;
	}
	public void setItems(List<orderitemdto> items) {
		this.items = items;
	}
	 
	 

}
