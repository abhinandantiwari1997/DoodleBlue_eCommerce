package com.doodleblue.productservice.service;
import java.util.*;

//import com.doodleblue.productservice.dto.UserOrderDetailsDto;
import com.doodleblue.productservice.dto.UserOrderDetails;
import com.doodleblue.productservice.entity.Order;
import com.doodleblue.productservice.entity.Product;

public interface ProductService {
List<UserOrderDetails> fetchAllOrderByUserId(long userID);
String saveOrder(Order orders);
Product checkStockByProductId(long productId);
}
