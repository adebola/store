/*+----------------------------------------------------------------------
 ||
 ||  Class Category
 ||
 ||         Author:  Adebola Omoboya
 ||
 ||        Purpose:  Category Entity Class
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

package io.factorialsystems.store.domain.product;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    Integer id;
    String name;
    Date createdDate;
    Date lastModifiedDate;
    String tenantId;
}
