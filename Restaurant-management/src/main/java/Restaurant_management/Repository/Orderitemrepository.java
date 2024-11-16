package Restaurant_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Restaurant_management.Entity.Orderitem;


@Repository
public interface Orderitemrepository extends JpaRepository<Orderitem , Integer>{

}
