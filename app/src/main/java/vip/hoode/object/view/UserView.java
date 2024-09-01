package vip.hoode.object.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mitu2
 */
@Data
public class UserView implements Serializable {

    private Long id;
    private String username;
    private Date createTime;
    private Date updateTime;
}
