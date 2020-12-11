package io.factorialsystems.store.mapper.user;


import io.factorialsystems.store.domain.user.WishList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WishListMapper {
    final String insertSQL = "insert into wishlist(user_id, sku_id) values (#{user_id}, #{sku_id})";
    final String selectSQL = "select w.id, w.user_id, w.sku_id, p.name, s.sku_description as description, s.price, s.discount, i.imagepath" +
            " from wishlist w, products p, sku_products s, sku_images si, images i" +
            " where w.status_id = 1 and w.user_id = #{userId} and w.sku_id = s.id and s.product_id = p.id and si.sku_id = s.id and si.image_id = i.id";
    final String updateSQL = "update wishlist set status_id = #{statusId}, lastModifiedAt = NOW() where id = #{id}";


    @Select(selectSQL)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "sku_id", column = "sku_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "imagepath", column = "imagepath"),
    })
    public List<WishList> findByUserId(Integer userId);

    @Insert(insertSQL)
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveWishList(WishList wishList);

    @Update(updateSQL)
    Integer updateWishList(Integer id, Integer statusId);
}
