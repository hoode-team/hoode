package vip.hoode.object.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mitu2
 */
@Data
public class CategoryView implements Serializable {

    private Long id;
    private String name;
    private String alias;
    private String path;
    private Date createTime;
    private Date updateTime;

}
