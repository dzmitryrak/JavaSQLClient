package models;

import lombok.Data;

import javax.persistence.*;

@Entity (name = "students")
@Table(name = "students")
@Data
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(name = "group_id")
    int groupId;
}
