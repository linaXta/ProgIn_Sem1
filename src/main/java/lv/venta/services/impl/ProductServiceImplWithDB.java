package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.models.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.services.ICRUDProductService;
import lv.venta.services.IFilteringProductService;

public class ProductServiceImplWithDB implements ICRUDProductService, IFilteringProductService {

	@Autowired
	private IProductRepo productRepo;
	
	@Override
	public ArrayList<Product> filterByPriceLess(float price) {
		return productRepo.findByPriceLessThan(price);
	}

	@Override
	public ArrayList<Product> retrieveAllProducts() {
		return (ArrayList<Product>) productRepo.findAll();
	}

	@Override
	public Product retrieveOneProductById(int id) throws Exception {
		if(productRepo.existsById(id)) {
			return productRepo.findById(id).get();
		}else {
			throw new Exception("Wrong id");
		}
		
	}

	@Override
	public ArrayList<Product> retrieveAllProductByTitle(String title) throws Exception{
		if(title != null) {
			ArrayList<Product> allProductsWithTitle = productRepo.findByTitleIgnoreCase(title);
			return allProductsWithTitle;
		
		}else {
			throw new Exception("wrong Title");
		}
		
	}

	@Override
	public Product insertProductByParams(String title, float price, String description, int quantity) {
		Product temp = productRepo.save(new Product(title, price,description,quantity));
		return temp;
	}

	@Override
	public Product updateProductByParams(int id, String title, float price, String description, int quantity)
			throws Exception {
		if(productRepo.existsById(id)) { //parbaidam vai existe tads produkts datu baze pec id
			Product updatePr = productRepo.findById(id).get();
			updatePr.setTitle(title);
			updatePr.setDescription(description);
			updatePr.setPrice(price);
			updatePr.setQuantity(quantity);
			return productRepo.save(updatePr);
		}else {
			throw new Exception("Wrong id");
		}
		
	}

	@Override
	public void deleteProductById(int id) throws Exception {
		if(productRepo.existsById(id)) {
			productRepo.deleteById(id);
		}else {
			throw new Exception("Wrong id");
		}
	}

}
