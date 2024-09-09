package vip.hoode.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vip.hoode.jpa.entity.support.AbstractEntity;
import vip.hoode.jpa.repository.support.Queries;

import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
@SQLRestriction(Queries.CHECK_VALID_SQL)
public class UserEntity extends AbstractEntity implements UserDetails {

    @Column(length = 50)
    private String username;

    @Column
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // note: Design permission is not required for the time being
        return Collections.emptySet();
    }

}
