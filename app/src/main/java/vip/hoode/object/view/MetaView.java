package vip.hoode.object.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mitu2
 */
@Data
public class MetaView implements Serializable {

    private Long id;
    private String route;
    private String title;
    private String description;
    private UserView author;
    private String keywords;
    private Date createTime;
    private Date updateTime;

}
