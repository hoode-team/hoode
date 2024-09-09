package vip.hoode.jpa.entity.support;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;
import vip.hoode.object.type.DataState;

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
    @ColumnDefault("'" + DataState.VALID_STATE + "'")
    private DataState isDeleted = DataState.VALID;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateTime;

    @Transient
    @Override
    public boolean isNew() {
        return id != null;
    }

}
