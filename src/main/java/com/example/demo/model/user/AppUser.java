package com.example.demo.model.user;

import com.example.demo.configuration.CustomAuthorityDeserializer;
import com.example.demo.model.basket.Basket;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;


@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="USERS")
public class AppUser implements UserDetails
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NonNull
    @Column(name="username")
    private String username;

    @NonNull
    @Column(name="password")
    private  String password;

    @NonNull
    @Column(name="email")
    private String email;


     @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "basket_id")
    private Basket basket=new Basket();


    @ManyToMany(fetch = EAGER)
    @JoinTable(name="USERS_ROLES",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    @Column(name="ROLES")
    private Set<Role> roles = new HashSet<>();

    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(roles.toString()));    }

    @Column(name="accountNonExpired")
    private  boolean accountNonExpired;

    @Column(name="accountNonLocked")
    private  boolean accountNonLocked;

    @Column(name="credentialsNonExpired")
    private  boolean credentialsNonExpired;

    @Column(name="enabled")
    private  boolean enabled;

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

    public Set<Role> getRoles() {
        return roles;
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

    //TODO: change to this role
    //    @NonNull
//    @Column(name="roles")
//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
//    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
//    private Set<UserRole> roles = new HashSet<>();
////
// @Column(name="role")
// private String role;
////

}
