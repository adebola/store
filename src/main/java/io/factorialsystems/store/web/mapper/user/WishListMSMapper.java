package io.factorialsystems.store.web.mapper.user;

import io.factorialsystems.store.domain.user.WishList;
import io.factorialsystems.store.web.model.user.WishListDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WishListMSMapper {
    WishListDto WishListToWishListDto(WishList wishList);
    WishList WishListDtoToWishList(WishListDto wishListDto);
    List<WishListDto> ListWishListToWishListDto(List<WishList> wishListList);
    List<WishList> ListWishListDtoToWishList(List<WishListDto> wishListDtoList);
}
