package com.example.demo.security.mail;

import com.example.demo.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "verification_tokens")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String value;

    @OneToOne
    private AppUser user;

    public VerificationToken(String value, AppUser appUser) {
        this.value = value;
        this.user = appUser;
    }
}
