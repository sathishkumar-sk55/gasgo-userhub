package com.frost.gasgo.userhub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "userhub")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String password;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;
}
