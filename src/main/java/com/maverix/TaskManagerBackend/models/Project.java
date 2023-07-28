package com.maverix.TaskManagerBackend.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "project", uniqueConstraints = { @UniqueConstraint(columnNames = { "p_name" }), })
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long p_id = (long) 0;

    @Column(name = "p_name")
    private String p_name;

    @Column(name = "p_desc")
    private String p_desc;

    @Column(name = "p_deadline")
    private Date p_deadline;

    @OneToOne 
    @JoinColumn(name = "u_id") 
    private User user;
}
