package io.factorialsystems.store.web.controller.store;

import io.factorialsystems.store.service.user.UserService;
import io.factorialsystems.store.web.model.user.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store/users")
public class StoreUserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<List<AddressDto>> findUserAddresses(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.getUserAddresses(id), HttpStatus.OK);
    }
}
