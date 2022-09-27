package com.example.demo.model.user;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

public enum Role {

    ADMIN, USER;

}
