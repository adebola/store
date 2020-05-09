/*+----------------------------------------------------------------------
 ||
 ||  Class Role
 ||
 ||         Author:  Adebola Omoboya
 ||
 ||        Purpose:  Role Entity Class
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
 ||   Constructors:  None
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  None
 ||
 ++-----------------------------------------------------------------------*/
package io.factorialsystems.store.domain.user;

import lombok.Data;

@Data
public class Role {
    private Integer id;
    //private String name;
    private RoleType roleType;
    private String tenantId;
}
