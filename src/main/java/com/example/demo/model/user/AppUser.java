package com.example.demo.model.user;

import com.example.demo.configuration.CustomAuthorityDeserializer;
import com.example.demo.model.basket.Basket;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;


@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="APPUSERS")
public class AppUser implements UserDetails
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NonNull
    @JoinColumn(name="username")
    private String username;

    @NonNull
    @JoinColumn(name="password")
    private  String password;

    @NonNull
    @JoinColumn(name="email")
    private String email;

     @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "basket_id")
    private Basket basket=new Basket();


    @JoinColumn(name="ROLE")
    private String role;

//    @Column(name="accountNonExpired")
//    private  boolean accountNonExpired;
//
//    @Column(name="accountNonLocked")
//    private  boolean accountNonLocked;
//
//    @Column(name="credentialsNonExpired")
//    private  boolean credentialsNonExpired;
//
//    @Column(name="enabled")
//    private  boolean enabled;

    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppUser appUser = (AppUser) o;
        return id != null && Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
