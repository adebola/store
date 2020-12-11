package io.factorialsystems.store.web.controller.user;

import io.factorialsystems.store.service.user.WishListService;
import io.factorialsystems.store.web.model.user.WishListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/store/wishlist")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class WishListController {
    private final WishListService wishListService;

    @GetMapping("/{id}")
    public ResponseEntity<List<WishListDto>> findByUserId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(wishListService.findWishListByUserId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<WishListDto>> update(@PathVariable("id") Integer id, @Valid @RequestBody WishListDto wishListDto) {
        return new ResponseEntity<>(wishListService.updateWishListStatus(id, wishListDto), HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<List<WishListDto>> save(@Valid @RequestBody WishListDto wishListDto) {
        return new ResponseEntity<>(wishListService.addWishList(wishListDto), HttpStatus.OK);
    }
}
