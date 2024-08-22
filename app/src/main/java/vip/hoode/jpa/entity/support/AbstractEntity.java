package vip.hoode.jpa.entity.support;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import vip.hoode.constant.DataState;

import java.io.Serializable;
import java.util.Date;


@Data
@MappedSuperclass
public abstract class AbstractEntity implements Persistable<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DataState isDeleted;

    @CreatedDate
    @Column(nullable = false)
    private Date createTime;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime;

    @Override
    public boolean isNew() {
        return id != null;
    }

}
