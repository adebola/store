package io.factorialsystems.store.web.controller.user;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.user.AddressService;
import io.factorialsystems.store.web.model.user.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/store/address")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<List<AddressDto>> findByUserId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(addressService.getUserAddresses(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<AddressDto>> update(@PathVariable("id") Integer id, @Valid @RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(addressService.updateUserAddress(id, addressDto), HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<List<AddressDto>> save(@Valid @RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(addressService.saveAddressReturnList(addressDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable("id") Integer id) {
        addressService.deleteById(id);

        return new ResponseEntity<>(new MessageResponse("Address has been deleted successfully"), HttpStatus.OK);
    }

}
