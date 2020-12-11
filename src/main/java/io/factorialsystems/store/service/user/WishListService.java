package io.factorialsystems.store.service.user;

import io.factorialsystems.store.mapper.user.WishListMapper;
import io.factorialsystems.store.web.mapper.user.WishListMSMapper;
import io.factorialsystems.store.web.model.user.WishListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListMapper wishListMapper;
    private final WishListMSMapper wishListMSMapper;

    public List<WishListDto> findWishListByUserId(Integer userId) {
        return wishListMSMapper.ListWishListToWishListDto(wishListMapper.findByUserId(userId));
    }

    public List<WishListDto> addWishList(WishListDto wishListDto) {
        wishListMapper.saveWishList(wishListMSMapper.WishListDtoToWishList(wishListDto));

        return wishListMSMapper.ListWishListToWishListDto(wishListMapper.findByUserId(wishListDto.getUser_id()));
    }

    public List<WishListDto> updateWishListStatus(Integer wishListId, WishListDto wishListDto) {
        wishListMapper.updateWishList(wishListId, wishListDto.getStatus_id());

        return wishListMSMapper.ListWishListToWishListDto(wishListMapper.findByUserId(wishListDto.getUser_id()));
    }
}
