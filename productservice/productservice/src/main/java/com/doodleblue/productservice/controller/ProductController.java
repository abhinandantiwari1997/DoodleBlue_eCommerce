package com.doodleblue.productservice.controller;
import java.util.*;

import com.doodleblue.productservice.dto.UserOrderDetails;
import com.doodleblue.productservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.doodleblue.productservice.dto.UserOrderDetailsDto;
import com.doodleblue.productservice.entity.Product;
import com.doodleblue.productservice.service.ProductService;

@RestController
public class ProductController {
@Autowired
ProductService productService;

@GetMapping("/allorders")
public ResponseEntity<?> fetchAllOrderByUserId(@RequestParam long userId) {
	List<UserOrderDetails> result= productService.fetchAllOrderByUserId(userId);
	return new ResponseEntity<>(result,HttpStatus.OK);
}
@GetMapping("/product")
public Product checkStockByProductId(@RequestParam long productId)
{
	return productService.checkStockByProductId(productId);
	
}
@GetMapping("/saveorder")
	public String orderByUser(@RequestParam Order order)
{
	return  productService.saveOrder(order);
}
}
