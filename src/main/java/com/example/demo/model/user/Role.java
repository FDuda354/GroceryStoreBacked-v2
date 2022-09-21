package com.example.demo.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

}
