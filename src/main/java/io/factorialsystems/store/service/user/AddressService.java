package io.factorialsystems.store.service.user;

import io.factorialsystems.store.domain.user.Address;
import io.factorialsystems.store.mapper.user.AddressMapper;
import io.factorialsystems.store.web.mapper.user.AddressMSMapper;
import io.factorialsystems.store.web.model.user.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressMapper addressMapper;
    private final AddressMSMapper addressMapStructMapper;

    public List<AddressDto> saveAddressReturnList(AddressDto addressDto) {
        saveUserAddress(addressDto);

        return getUserAddresses(addressDto.getUser_id());
    }

    public AddressDto saveUserAddress(AddressDto addressDto) {

        Address address = addressMapStructMapper.AddressDtoToAddress(addressDto);
        addressMapper.saveUserAddress(address);

        if (address != null && address.getId() > 0) {
            return addressMapStructMapper.AddressToAddressDto(address);
        }

        String message = "Error Saving Address";
        log.error(message);
        throw new RuntimeException(message);
    }

    public List<AddressDto> getUserAddresses(Integer userId) {
        log.info("loadUserAddresses");
        return addressMapStructMapper.ListAddressToAddressDto(addressMapper.getUserAddresses(userId));
    }

    public AddressDto getUserDefaultAddress(Integer userId) {
        return addressMapStructMapper.AddressToAddressDto(addressMapper.getUserDefaultAddress(userId));
    }

    public List<AddressDto> updateUserAddress(Integer addressId, AddressDto addressDto) {

        log.info("Update Address");
        addressMapper.updateUserAddress(addressId, addressMapStructMapper.AddressDtoToAddress(addressDto));
        return getUserAddresses(addressDto.getUser_id());
    }

    public void deleteById(Integer id) {
        addressMapper.deleteAddress(id);
    }
}
