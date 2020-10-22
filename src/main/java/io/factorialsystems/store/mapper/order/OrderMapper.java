package io.factorialsystems.store.mapper.order;

import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    String SelectSQLOrder = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, telephone, address, payment_ref, transaction_id, tenant_id " +
                            "from orders where id = #{id} and tenant_id = #{tenantId}";

    String SelectOrderItems = "select o.id, o.order_id, o.sku_id, p.name, o.quantity, o.unit_price, o.discount, o.total_price, i.imagepath " +
                              "from orderitems o, products p, sku_products s, images i, sku_images si " +
                              "where o.order_id = #{id} and o.sku_id = s.id and s.product_id = p.id and o.sku_id = si.sku_id and si.image_id = i.id";

    @Select(SelectSQLOrder)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "orderedAt", column = "order_date"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "deliver", column = "deliver"),
            @Result(property = "pickup", column = "pickup"),
            @Result(property = "full_name", column = "full_name"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "paymentRef", column = "payment_ref"),
            @Result(property = "transaction_id", column = "transaction_id"),
            @Result(property = "tenant_id", column = "tenant_id"),
            @Result(property = "orderItems", column = "id", javaType = List.class, many=@Many(select="selectOrderItems"))
    })
    public Order findOrderById(Integer id, String tenantId);

    @Insert(
            "insert into orders(user_id, order_amount, payment_ref, transaction_id, pickup, deliver, full_name, telephone, address, tenant_id) " +
            "values(#{user_id}, #{orderAmount}, #{paymentRef}, #{transaction_id}, #{pickup}, #{deliver}, #{full_name}, #{telephone}, #{address}, #{tenant_id})"
    )
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveOrder(Order order);


    @Insert(
            "insert into orderitems(order_id, sku_id, quantity, unit_price, discount, total_price) " +
            "values(#{order_id}, #{sku_id}, #{quantity}, #{unit_price}, #{discount}, #{total_price})"
    )
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveOrderItem(OrderItem orderItem);


    @Select(SelectOrderItems)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "order_id", column = "order_id"),
            @Result(property = "sku_id", column = "sku_id"),
            @Result(property = "image_path", column = "imagepath"),
            @Result(property = "product_name", column = "name"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "unit_price", column = "unit_price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "total_price", column = "total_price")
    })
    public List<OrderItem> selectOrderItems(Integer id);
}




