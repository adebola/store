/*+----------------------------------------------------------------------
 ||
 ||  Class User
 ||
 ||         Author:  Adebola Omoboya
 ||
 ||        Purpose:  User Entity Class
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  User(String username, String email, String password)
 ||                  Default NoArgsConstructor
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  None
 ||
 ++-----------------------------------------------------------------------*/
package io.factorialsystems.store.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String telephone;
    private String address;
    private String password;
    private List<Role> roles;
    private String tenantId;

    public User(String username, String email, String fullName,
                String telephone, String address, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;

        if (telephone != null) {
            this.telephone = telephone;
        }

        if (address != null) {
            this.address = address;
        }
    }
}
