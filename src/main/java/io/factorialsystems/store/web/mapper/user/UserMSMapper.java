package io.factorialsystems.store.web.mapper.user;


import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.web.model.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {RoleMSMapper.class})
public interface UserMSMapper {
    UserDto UserToUserDto(User user);
    User UserDtoToUser(UserDto userDto);
    List<UserDto> ListUserToUserDto(List<User> users);
    List<User> ListUserDtoToUser(List<UserDto> userDtos);
}
