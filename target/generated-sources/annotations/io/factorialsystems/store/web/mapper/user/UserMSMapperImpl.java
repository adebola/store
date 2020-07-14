package io.factorialsystems.store.web.mapper.user;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.web.model.user.UserDto;
import io.factorialsystems.store.web.model.user.UserDto.UserDtoBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-14T17:32:58+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class UserMSMapperImpl implements UserMSMapper {

    @Autowired
    private RoleMSMapper roleMSMapper;

    @Override
    public UserDto UserToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.username( user.getUsername() );
        userDto.email( user.getEmail() );
        userDto.fullName( user.getFullName() );
        userDto.telephone( user.getTelephone() );
        userDto.address( user.getAddress() );
        userDto.roles( roleListToStringSet( user.getRoles() ) );

        return userDto.build();
    }

    @Override
    public User UserDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setEmail( userDto.getEmail() );
        user.setFullName( userDto.getFullName() );
        user.setTelephone( userDto.getTelephone() );
        user.setAddress( userDto.getAddress() );
        user.setRoles( stringSetToRoleList( userDto.getRoles() ) );

        return user;
    }

    @Override
    public List<UserDto> ListUserToUserDto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( UserToUserDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> ListUserDtoToUser(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( UserDtoToUser( userDto ) );
        }

        return list;
    }

    protected Set<String> roleListToStringSet(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Role role : list ) {
            set.add( roleMSMapper.asString( role ) );
        }

        return set;
    }

    protected List<Role> stringSetToRoleList(Set<String> set) {
        if ( set == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( set.size() );
        for ( String string : set ) {
            list.add( roleMSMapper.asRole( string ) );
        }

        return list;
    }
}
