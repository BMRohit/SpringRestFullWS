/**
 * 
 */
package com.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import com.example.model.Product;

/**
 * 
 * @author Rohit
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private static List<Product> products = new ArrayList<Product>();
	
	static{
		products.add(new Product(1,"Iphone4s",18000.0,getImageInBytes("/iphone_4s.png")));
		products.add(new Product(2,"Iphone6",28000.0,getImageInBytes("/iphone6.jpg")));
		products.add(new Product(3,"Motog",12000.0,getImageInBytes("/motog.jpg")));
		products.add(new Product(4,"Motoe",7000.0,getImageInBytes("/motoe.jpeg")));
		products.add(new Product(5,"Sony-Xperia-Z",23000.0,getImageInBytes("/sonyz.jpg")));
	}
	
	@Override
	public void insertProduct(Product product) {
		products.add(product);
	}

	@Override
	public Product getProduct(long productID) {
		for(Product product : products)
		{
			if(product.getProductID() == productID)
				return product;
		}
		return null;	
	}

	@Override
	public void updateProduct(Product product) {
		products.set((int)product.getProductID()-1,product);
	}

	@Override
	public void deleteProduct(long productID) {
		products.remove(getProduct(productID));
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public byte[] getProductImage(long productID) {
		for(Product product : products)
		{
			if(product.getProductID() == productID)
				return product.getImage();
		}
		return null;
	}

	
	private static  byte[] getImageInBytes(String imageName){
		byte[] imageInBytes = null;
		InputStream in = ProductServiceImpl.class.getResourceAsStream(imageName);
		try {
			imageInBytes = IOUtils.toByteArray(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageInBytes;
	}

	@Override
	public void setProductImage(long productID, byte[] imageInBytes) {
		
		for(Product product : products)
		{
			if(product.getProductID() == productID)
				product.setImage(imageInBytes);
		}
	}
	
	
}
