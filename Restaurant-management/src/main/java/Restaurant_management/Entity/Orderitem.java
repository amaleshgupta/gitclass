package Restaurant_management.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitem")
public class Orderitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "menu_item_id")
	private Menuitem menuitems;
	
	private Integer quantity;
	private Double subtotal;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="orders_id", referencedColumnName = "id")
	private Orders orders;
	
	
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Orderitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orderitem(int id, Menuitem menuitems, Integer quantity, Double subtotal) {
		super();
		this.id = id;
		this.menuitems = menuitems;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Menuitem getMenuitems() {
		return menuitems;
	}
	public void setMenuitems(Menuitem menuitems) {
		this.menuitems = menuitems;
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
