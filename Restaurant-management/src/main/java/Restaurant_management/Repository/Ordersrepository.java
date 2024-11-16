package Restaurant_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Restaurant_management.Entity.Orders;




@Repository
public interface Ordersrepository extends JpaRepository<Orders, Integer>{

	//public Orders findById(int id);
}
