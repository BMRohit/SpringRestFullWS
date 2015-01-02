/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.ErrorMessage;
import com.example.model.Product;
import com.example.service.ProductService;

/**
 * @author Rohit
 *
 */


@RestController
@RequestMapping(value = "/product")
public class RestFullController {
	
	@Autowired
	private ProductService productService;
	private static final Logger logger = Logger.getLogger(RestFullController.class);
	ErrorMessage serverErrMess = new ErrorMessage("Server Error.Contact Adminstrator");
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private ResponseEntity<Object> test() {
		return new ResponseEntity<Object>("Hello Spring Rest World!",HttpStatus.OK);
	}

	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	private ResponseEntity<Object> addProduct(@RequestBody Product product) {
		logger.info("Adding new product.....");
		try{
			productService.insertProduct(product);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/getproduct", method=RequestMethod.GET)
	private ResponseEntity<Object> getProduct(@RequestParam(value="id")long id) {
		logger.info("Getting product of id ....."+id);
		try{
			return new ResponseEntity<Object>(productService.getProduct(id), HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/getproducts",method=RequestMethod.GET)
	private  ResponseEntity<Object> getListOfProducts()
	{
		logger.info("Fetching all the Products...");
		try{
			List<Product> products = productService.getProducts();
			return new ResponseEntity<Object>(products, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/updateproduct",method=RequestMethod.PUT)
	private ResponseEntity<Object> updateProduct(@RequestBody Product product)
	{
		logger.info("Updating product of id....."+product.getProductID());
		try{
			productService.insertProduct(product);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/deleteproduct", method=RequestMethod.DELETE)
	private ResponseEntity<Object> deleteProduct(@RequestParam(value="id")long id) {
		logger.info("Getting product of id ....."+id);
		try{
			productService.deleteProduct(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/postimage", method=RequestMethod.POST)
	private ResponseEntity<Object> postProductImage(@RequestParam(value="file") MultipartFile file,
			@RequestParam(value="id")long id) {
		logger.info("Posting image of product with id ....."+id);
		try{
			productService.setProductImage(id, IOUtils.toByteArray(file.getInputStream()));
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/getimage", method=RequestMethod.GET,  produces = MediaType.IMAGE_PNG_VALUE)
	private ResponseEntity<Object> getProductImage(@RequestParam(value="id")long id) {
		logger.info("Getting image of product with id ....."+id);
		try{
			byte[] imageInBytes = productService.getProductImage(id);
			return new ResponseEntity<Object>(imageInBytes,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<Object>(serverErrMess,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
