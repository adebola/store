package io.factorialsystems.store.web.controller.user;

import io.factorialsystems.store.payload.request.EmailRequest;
import io.factorialsystems.store.payload.request.PasswordChangeRequest;
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

    @GetMapping({"/", ""})
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

    @PutMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> updateUserAdmin(@PathVariable("id") Integer id, @Valid @RequestBody UserDto userDto) {
        try {
            userService.updateUserAdmin(id, userDto);
            return new ResponseEntity<>(new MessageResponse("User updated Successfully"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/password/{id}")
    public ResponseEntity<MessageResponse> changePassword(@PathVariable("id") Integer id, @Valid @RequestBody PasswordChangeRequest passwordChangeRequest) {
        try {
            userService.changePassword(id, passwordChangeRequest);
            return new ResponseEntity<>(new MessageResponse("Password changed successfully"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> saveUser(@Valid @RequestBody UserDto userDto ) {
        try {
            userService.SaveUserAdmin(userDto);
            return new ResponseEntity<>(new MessageResponse("User Created Successfully"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

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

    @GetMapping("/send/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> sendActivationMessage(@PathVariable("id") Integer id) {
        try {
            userService.sendUserActivationMessage(id);
            return new ResponseEntity<>(new MessageResponse("Activation Mail sent successfully"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
