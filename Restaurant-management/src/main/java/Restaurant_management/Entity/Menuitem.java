package Restaurant_management.Entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="menuitem")
public class Menuitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Double price;
	@NotNull
	private Integer availablequantity;
	
	public Menuitem(int id, String name, Double price, Integer availablequantity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.availablequantity = availablequantity;
		this.category = category;
	}
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public enum Category {
	    APPETIZER, MAIN_COURSE, DESSERT
	}
	
	
	
	public Menuitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Integer getAvailablequantity() {
		return availablequantity;
	}
	public void setAvailablequantity(Integer availablequantity) {
		this.availablequantity = availablequantity;
	}
	
	
	

}

