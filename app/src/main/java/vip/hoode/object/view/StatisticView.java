package vip.hoode.object.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mitu2
 */
@Data
public class StatisticView implements Serializable {

    private Long id;
    private Integer likeQuantity;
    private Integer visitQuantity;
    private Date createTime;
    private Date updateTime;

}
