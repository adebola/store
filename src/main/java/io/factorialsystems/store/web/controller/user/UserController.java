package io.factorialsystems.store.web.controller.user;

import io.factorialsystems.store.payload.request.EmailRequest;
import io.factorialsystems.store.payload.request.PasswordRequest;
import io.factorialsystems.store.payload.request.UsernameRequest;
import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.user.UserService;
import io.factorialsystems.store.web.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody UserDto userDto) {

        try {
            return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/byuser/{username}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<UserDto> findByUsername(@PathVariable("username") String username) {
//        return new ResponseEntity<UserDto>(userService.findByUsername(username), HttpStatus.OK);
//    }

//    @GetMapping("/byemail/{email}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<UserDto> findByEmail(@PathVariable("email") String email) {
//        return new ResponseEntity<UserDto>(userService.findByEmail(email), HttpStatus.OK);
//    }

    @PutMapping("/username/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<MessageResponse> changeUsername(@PathVariable("id") Integer userId,
                                                          @Valid @RequestBody UsernameRequest request) {
        if (userService.changeUsername(userId, request.getUsername())) {
            return new ResponseEntity<MessageResponse>(new MessageResponse("Username changed successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<MessageResponse>(new MessageResponse("Username was not changed, you must be logged in and trying to change your own credentials ONLY or the username has been taken"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/email/{id}")
    @PreAuthorize("hasRole('USER')")
    public  ResponseEntity<MessageResponse> changeEmail(@PathVariable("id") Integer userId,
                                                        @Valid @RequestBody EmailRequest request) {
        if (userService.changeEmail(userId, request.getEmail())) {
            return new ResponseEntity<MessageResponse>(new MessageResponse("Email changed successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<MessageResponse>(new MessageResponse("Email was not changed, you must be logged in and trying to change your own credentials ONLY or the email has been taken"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/password/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<MessageResponse>  changePassword(@PathVariable("id") Integer userId,
                                                           @Valid @RequestBody PasswordRequest request) {
        if (userService.changePassword(userId, request.getPassword())) {
            return new ResponseEntity<MessageResponse>(new MessageResponse("Password changed successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<MessageResponse>(new MessageResponse("Password was not changed, you must be logged in and trying to change your own credentials ONLY"), HttpStatus.BAD_REQUEST);
        }
    }
}
