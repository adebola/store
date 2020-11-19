package io.factorialsystems.store.web.mapper.user;

import io.factorialsystems.store.domain.user.Address;
import io.factorialsystems.store.web.model.user.AddressDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AddressMSMapper {
    AddressDto AddressToAddressDto(Address address);
    Address AddressDtoToAddress(AddressDto addressDto);
    List<AddressDto> ListAddressToAddressDto(List<Address> addressList);
    List<Address> ListAddressDtoToAddress(List<AddressDto> addressDtoList);
}
