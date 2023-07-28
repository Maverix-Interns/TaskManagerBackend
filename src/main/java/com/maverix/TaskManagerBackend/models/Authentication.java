package com.maverix.TaskManagerBackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "authentication", uniqueConstraints = { @UniqueConstraint(columnNames = { "u_name" }), })
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long u_id = (long) 0;

    @Column(name = "u_name")
    private String u_name;

    @Column(name = "email_id")
    private String email_id;

    @Column(name = "password")
    private String password;

}
