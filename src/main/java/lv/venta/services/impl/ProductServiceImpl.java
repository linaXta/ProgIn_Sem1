package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.models.Product;
import lv.venta.services.ICRUDProductService;
import lv.venta.services.IFilteringProductService;

//@Service
public class ProductServiceImpl implements ICRUDProductService, IFilteringProductService {

	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(new Product("Abols", 3.99f, "Sarkans", 3),
			new Product("BurkAns", 0.33f, "Oranzs", 2), new Product("Gurkis", 1.22f, "Zals", 6)

	));

	@Override
	public ArrayList<Product> retrieveAllProducts() {
		return allProducts;
	}

	@Override
	public Product retrieveOneProductById(int id) throws Exception {
		for (Product temp : allProducts) {
			if (temp.getId() == id) {
				return temp;
			}
		}
		throw new Exception("Wrong id");
	}

	@Override
	public ArrayList<Product> retrieveAllProductByTitle(String title) throws Exception {
		if(title != null) {
			ArrayList<Product> allProductsWithTitle = new ArrayList<>();
			for (Product temp : allProducts) {
				if (temp.getTitle().equals(title)) {
					allProductsWithTitle.add(temp);
				}
			}
			return allProductsWithTitle;
		}
		throw new Exception("Wrong title");
	}

	@Override
	public Product insertProductByParams(String title, float price, String description, int quantity) {
		for (Product temp : allProducts) {
			if (temp.getTitle().equals(title) && temp.getPrice() == price
					&& temp.getDescription().equals(description)) {
				temp.setQuantity(temp.getQuantity() + quantity);
				return temp;
			}
		}

		Product newProduct = new Product(title, price, description, quantity);
		allProducts.add(newProduct);
		return newProduct;
	}

	@Override
	public Product updateProductByParams(int id, String title, float price, String description, int quantity)
			throws Exception {
		for (Product temp : allProducts) {
			if (temp.getId() == id) {
				temp.setTitle(title);
				temp.setPrice(price);
				temp.setDescription(description);
				temp.setQuantity(quantity);
				return temp;
			}
		}
		throw new Exception("Wrong id");
	}

	@Override
	public void deleteProductById(int id) throws Exception {
		boolean isFound = false;
		for(Product temp : allProducts) {
				if (temp.getId() == id) {
					allProducts.remove(temp);
					isFound = true;
					break;
				}
		}
		if(!isFound){
			throw new Exception("Wrong id");
		}
	}

	@Override
	public ArrayList<Product> filterByPriceLess(float price) {
		if (price > 0) {

			ArrayList<Product> allProductsWithPriceLess = new ArrayList<>();
			for (Product temp : allProducts) {
				if (temp.getPrice() < price) {
					allProductsWithPriceLess.add(temp);
				}
			}
			return allProductsWithPriceLess;
		}
		return new ArrayList<>();

	}

	@Override
	public ArrayList<Product> filterByQuantityLess(int quantity) {
		// TODO izveidot, bet stradajot ar arraylistu nevis adtu bazi
		return null;
	}
}
