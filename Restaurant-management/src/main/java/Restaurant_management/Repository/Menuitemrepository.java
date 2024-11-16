package Restaurant_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Restaurant_management.Entity.Menuitem;
import Restaurant_management.Entity.Menuitem.Category;


@Repository
public interface Menuitemrepository extends JpaRepository<Menuitem, Integer>{
	
	List<Menuitem> findByCategory(Category category);

}
