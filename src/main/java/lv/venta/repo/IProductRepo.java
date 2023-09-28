package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Product;

public interface IProductRepo extends CrudRepository<Product, Integer>{
	
	//select * from Product_table where price < variable;
	ArrayList<Product> findByPriceLessThan(float var);
	
	//atlasa pēc nosaukuma (Var būt vairāki vienādi nosaukumi)
	//select * from product_table where title ="var"
	ArrayList<Product> findByTitleIgnoreCase(String var);
	
	//atlasa tos produktus, kuru daudzums ir lielāks par desmit bet cena mazāk par 4 euro
	//select * from produt_table where quantity> varQ And price < varP
	ArrayList<Product> findByQuantityGreaterThanAndPriceLessThan(int vawQ, float varP);

	ArrayList<Product> findByQuantityLessThan(int quantity);
	
	//@Query(nativeQuery = countBy)
	//ArrayList<Product> funcNameDoesNotMatter();
	
	

}
