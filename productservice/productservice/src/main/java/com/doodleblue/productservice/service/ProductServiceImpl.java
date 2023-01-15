package com.doodleblue.productservice.service;

import java.util.List;
import java.util.Optional;

import com.doodleblue.productservice.dto.UserOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.doodleblue.productservice.dto.UserOrderDetailsDto;
import com.doodleblue.productservice.entity.Order;
//import com.doodleblue.productservice.entity.Order;
import com.doodleblue.productservice.entity.Product;
import com.doodleblue.productservice.repository.OrderRepository;
import com.doodleblue.productservice.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<UserOrderDetails> fetchAllOrderByUserId(long userID) {
		List<UserOrderDetails> orders=orderRepository.getOrderDetailsByUserId(userID);
		
		return orders;
		
	}

	@Override
	public String saveOrder(Order orders) {
			String message=" Order Failed";
			long stock=orders.getQuantity();
			Optional<Product> optional=productRepository.findById(orders.getProduct().getProductId());
			
			if(optional!=null)
			{
				Product product=optional.get();
				if(product.getQuantity()>=stock)
				{
					product.setQuantity((product.getQuantity()-stock));
					productRepository.save(product);
					orderRepository.save(orders);
					message="Order Successfull";
				}
				else
					message="Quantity is not available";
				
			}
			else
				message="Product Not Found";
			return message;
	}

	@Override
	public Product checkStockByProductId(long productId) {
		
		Optional<Product> product=productRepository.findById(productId);
		if(product!=null)
			return product.get();
		else 
			return null;
	}

}
