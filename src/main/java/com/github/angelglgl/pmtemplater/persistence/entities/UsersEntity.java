package com.github.angelglgl.pmtemplater.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UsersEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_firstname")
    private String userFirstname;
    @Column(name = "user_lastname")
    private String userLastname;
    @Column(name = "user_team")
    private String userTeam;
    @Column(name = "user_role")
    private String userRole;
    private String userEmail;
    private String userPassword;
}