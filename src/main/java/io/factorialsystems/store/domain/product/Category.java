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
import java.util.List;

@Data
public class Category {
    private Integer id;
    private String name;
    private String image_url;
    private Date createdDate;
    private Date lastModifiedDate;
    private String tenantId;
    private List<Category> subCategories;
}
