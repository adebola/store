package io.factorialsystems.store.web.mapper.user;


import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.web.model.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {RoleMSMapper.class})
public interface UserMSMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "telephone", target = "telephone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "organization", target = "organization"),
            @Mapping(source = "activated", target = "activated"),
            @Mapping(source = "roles", target = "roles")
    })
    UserDto UserToUserDto(User user);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "telephone", target = "telephone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "organization", target = "organization"),
            @Mapping(source = "activated", target = "activated"),
            @Mapping(source = "roles", target = "roles")
    })
    User UserDtoToUser(UserDto userDto);
    List<UserDto> ListUserToUserDto(List<User> users);
    List<User> ListUserDtoToUser(List<UserDto> userDtos);
}
