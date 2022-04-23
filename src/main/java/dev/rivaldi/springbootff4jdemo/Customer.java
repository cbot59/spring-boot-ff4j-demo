package dev.rivaldi.springbootff4jdemo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = -4001300514398910307L;

    @Id
    private String id;

    private String name;

    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
