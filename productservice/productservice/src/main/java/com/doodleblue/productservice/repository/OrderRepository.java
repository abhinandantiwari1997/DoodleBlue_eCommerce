package com.doodleblue.productservice.repository;
import java.util.List;

//import org.springframework.beans.factory.annotation.Qualifier;
import com.doodleblue.productservice.dto.UserOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.doodleblue.productservice.dto.UserOrderDetailsDto;
import com.doodleblue.productservice.entity.Order;
//import com.doodleblue.productservice.entity.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value="select o.user_id as userId,p.product_name as productName,o.product_id as productId,o.quantity as quantity from order_table o,product p where o.product_id=p.product_id and o.user_id=?1",nativeQuery = true)
    public List<UserOrderDetails> getOrderDetailsByUserId(long userId);
}
