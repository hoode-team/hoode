package vip.hoode.object.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mitu2
 */
@Data
public class StatisticModel implements Serializable {
    private Long id;
    private Integer likeQuantity;
    private Integer visitQuantity;
}
