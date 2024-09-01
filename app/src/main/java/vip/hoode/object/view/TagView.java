package vip.hoode.object.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mitu2
 */
@Data
public class TagView implements Serializable {

    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;

}
