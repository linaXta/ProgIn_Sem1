package lv.venta.services.impl;

import java.util.ArrayList;

import lv.venta.models.Product;
import lv.venta.services.ICRUDProductService;
import lv.venta.services.IFilteringProductService;

public class ProductServiceImplWithDB implements ICRUDProductService, IFilteringProductService {

	@Override
	public ArrayList<Product> filterByPriceLess(float price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> retrieveAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product retrieveOneProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product retrieveOneProductByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product insertProductByParams(String title, float price, String description, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProductByParams(int id, String title, float price, String description, int quantity)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
