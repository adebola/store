package io.factorialsystems.store.mapper.order;

import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    final String SelectSQLOrder = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, email, telephone, address, payment_ref, transaction_id, pin, tenant_id " +
                            "from orders where id = #{id} and tenant_id = #{tenantId}";

    final String SelectSQLOrderByUserId = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, email, telephone, address, payment_ref, transaction_id, pin, tenant_id " +
            "from orders where user_id = #{userId} and tenant_id = #{tenantId}";

    final String SelectOrderItems = "select o.id, o.order_id, o.sku_id, p.name, o.quantity, o.unit_price, o.discount, o.total_price, s.sku, pvo.name as uom, i.imagepath " +
                                    "from orderitems o, products p, sku_products s, images i, sku_images si, product_variant_options pvo, sku_product_variant_options spvo " +
                                    "where o.order_id = #{id} and o.sku_id = s.id and s.product_id = p.id and o.sku_id = si.sku_id and si.image_id = i.id and s.id = spvo.sku_id and spvo.product_variant_option_id = pvo.id";

    @Select(SelectSQLOrder)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "orderedAt", column = "order_date"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "deliver", column = "deliver"),
            @Result(property = "pickup", column = "pickup"),
            @Result(property = "full_name", column = "full_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "paymentRef", column = "payment_ref"),
            @Result(property = "transaction_id", column = "transaction_id"),
            @Result(property = "tenant_id", column = "tenant_id"),
            @Result(property = "orderItems", column = "id", javaType = List.class, many=@Many(select="findOrderItemsById"))
    })
    public Order findOrderById(Integer id, String tenantId);

    @Select(SelectSQLOrderByUserId)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "orderedAt", column = "order_date"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "deliver", column = "deliver"),
            @Result(property = "pickup", column = "pickup"),
            @Result(property = "full_name", column = "full_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "paymentRef", column = "payment_ref"),
            @Result(property = "transaction_id", column = "transaction_id"),
            @Result(property = "tenant_id", column = "tenant_id")
    })
    public List<Order> findOrderByUserId(Integer userId, String tenantId);

    @Insert(
            "insert into orders(user_id, order_amount, payment_ref, transaction_id, pin, pickup, deliver, full_name, email, telephone, address, tenant_id) " +
            "values(#{user_id}, #{orderAmount}, #{paymentRef}, #{transaction_id}, #{pin}, #{pickup}, #{deliver}, #{full_name}, #{email}, #{telephone}, #{address}, #{tenant_id})"
    )
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveOrder(Order order);


    @Insert(
            "insert into orderitems(order_id, sku_id, quantity, unit_price, discount, total_price) " +
            "values(#{order_id}, #{sku_id}, #{quantity}, #{unit_price}, #{discount}, #{total_price})"
    )
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveOrderItem(OrderItem orderItem);


    //s.sku, pvo.name
    @Select(SelectOrderItems)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "order_id", column = "order_id"),
            @Result(property = "sku_id", column = "sku_id"),
            @Result(property = "item_code", column = "sku"),
            @Result(property = "uom", column = "uom"),
            @Result(property = "image_path", column = "imagepath"),
            @Result(property = "product_name", column = "name"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "unit_price", column = "unit_price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "total_price", column = "total_price")
    })
    public List<OrderItem> findOrderItemsById(Integer id);
}




