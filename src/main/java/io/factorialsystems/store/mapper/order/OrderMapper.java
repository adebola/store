package io.factorialsystems.store.mapper.order;

import io.factorialsystems.store.domain.order.FulFillOrder;
import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.domain.order.OrderTotals;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    final String SelectSQLAllOrder = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, email, telephone, address, payment_ref, transaction_id, pin, tenant_id " +
                                     "from orders where tenant_id = #{tenantId}";

    final String SelectSQLAllOrderDelivery = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, email, telephone, address, payment_ref, transaction_id, pin, tenant_id " +
                                             "from orders where fulfill_date is not null and fulfill_date < #{date} and tenant_id = #{tenantId}";

    final String SelectSQLOrder = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, email, telephone, address, payment_ref, transaction_id, pin, fulfill_date, tenant_id " +
                                  "from orders where id = #{id} and tenant_id = #{tenantId}";

    final String SelectSQLOrderByUserId = "select id, user_id, order_date, order_amount, pickup, deliver, full_name, email, telephone, address, payment_ref, transaction_id, pin, tenant_id " +
                                          "from orders where user_id = #{userId} and tenant_id = #{tenantId}";

    final String SelectOrderItems = "select o.id, o.order_id, o.sku_id, p.name, o.quantity, o.unit_price, o.discount, o.total_price, o.vat_price, s.sku, pvo.name as uom, i.imagepath " +
                                    "from orderitems o, products p, sku_products s, images i, sku_images si, product_variant_options pvo, sku_product_variant_options spvo " +
                                    "where o.order_id = #{id} and o.sku_id = s.id and s.product_id = p.id and o.sku_id = si.sku_id and si.image_id = i.id and s.id = spvo.sku_id and spvo.product_variant_option_id = pvo.id";

    final String SelectOrderTotals = "select p.name, i.imagepath, sum(o.total_price) as totals from products p, orderitems o, sku_products sp, sku_images si, images i " +
                                     "where o.sku_id = sp.id and sp.product_id = p.id and si.sku_id = o.sku_id and si.image_id = i.id and sp.tenant_id = #{tenantId} " +
                                     "GROUP BY p.name, i.imagepath " +
                                     "ORDER BY sum(o.total_price) DESC";

    @Select(SelectSQLAllOrder)
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
    })
    public List<Order> findAll(String tenantId);

    @Select(SelectSQLOrder)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "orderedAt", column = "order_date"),
            @Result(property = "fulfilledAt", column = "fulfill_date"),
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
            "insert into orderitems(order_id, sku_id, quantity, unit_price, discount, total_price, vat_price) " +
            "values(#{order_id}, #{sku_id}, #{quantity}, #{unit_price}, #{discount}, #{total_price}, #{vat_price})"
    )
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveOrderItem(OrderItem orderItem);

    @Update("update orderitems set quantity=Greatest(0, quantity-#{quantity}) where id = #{id}")
    public Integer updateOrderItemStock(OrderItem orderItem);


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
            @Result(property = "vat_price", column = "vat_price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "total_price", column = "total_price")
    })
    public List<OrderItem> findOrderItemsById(Integer id);

    @Select(SelectOrderTotals)
    @Results(value = {
            @Result(property="name", column = "name"),
            @Result(property = "imagepath", column = "imagepath"),
            @Result(property = "totals", column = "totals"),
    })
    public List<OrderTotals> findOrderTotals(String tenantId);

    @Insert("update orders set fulfill_date = #{fulfill_date} where id=#{id}")
    Integer fulfillOrder(FulFillOrder fulFillOrder);

    @Select(SelectSQLAllOrderDelivery)
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
    })
    List<Order> findOrdersForDelivery(Date date, String tenantId);
}




