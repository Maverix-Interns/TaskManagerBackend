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
@Table(name = "task", uniqueConstraints = { @UniqueConstraint(columnNames = { "t_name" }), })
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long t_id = (long) 0;

    @Column(name = "t_name")
    private String t_name;

    @Column(name = "t_desc")
    private String t_desc;

    @Column(name = "t_deadline")
    private Date t_deadline;

    @OneToOne
    @JoinColumn(name = "u_id") // Name of the foreign key column in the User table
    private User user;

    @Column(name = "taskassigned")
    private int task_assigned;

    @Column(name = "taskacompleted")
    private int task_completed;

    @Column(name = "status")
    private String status;
}
