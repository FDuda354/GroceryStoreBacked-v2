package com.example.demo.model.user;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name="ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name="name_of_role")
    @NonNull
    private String name;

}
