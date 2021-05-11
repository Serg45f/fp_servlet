package com.sgsavch.model.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
//@Table(name="users")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="email")
    String email;
    @Column(name="password")
    String password;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    /*
    @Enumerated(value = EnumType.STRING)
    @Column(name="role")
    Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    Status status;*/
}
