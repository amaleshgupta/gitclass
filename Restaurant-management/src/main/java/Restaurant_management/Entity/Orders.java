package Restaurant_management.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orders")
	//@JoinColumn(name="orders_id" ,referencedColumnName = "id")
	private List<Orderitem> items =new ArrayList<>();
	
	private Double totalamount;
	private String customername;
	private LocalDateTime createdat;
	private String customernum;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public enum Status{
		
		RECEIVED, PREPARING, READY, DELIVERED
	}
	
	
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Orders(int id, List<Orderitem> items, Double totalamount, String customername, LocalDateTime createdat,
			String customernum, Status status) {
		super();
		this.id = id;
		this.items = items;
		this.totalamount = totalamount;
		this.customername = customername;
		this.createdat = createdat;
		this.customernum = customernum;
		this.status = status;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public List<Orderitem> getItems() {
		return items;
	}





	public void setItems(List<Orderitem> items) {
		this.items = items;
	}





	public Double getTotalamount() {
		return totalamount;
	}





	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}





	public String getCustomername() {
		return customername;
	}





	public void setCustomername(String customername) {
		this.customername = customername;
	}





	public LocalDateTime getCreatedat() {
		return createdat;
	}





	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}





	public String getCustomernum() {
		return customernum;
	}





	public void setCustomernum(String customernum) {
		this.customernum = customernum;
	}





	public Status getStatus() {
		return status;
	}





	public void setStatus(Status status) {
		this.status = status;
	}

}

