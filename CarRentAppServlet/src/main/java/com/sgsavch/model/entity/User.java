package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusUser;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="email")
    String email;
    @Column(name="activation_code")
    String activationCode;
    @Column(name="password")
    String password;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    Set<Role> roles = new HashSet<>();
    @Enumerated(value = EnumType.STRING)
    StatusUser status;
    @Column(name = "resume")
    private String resume;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "lector",orphanRemoval = true)
    List<Lecture> lectures;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true)
    List<Ticket> tickets;

    public Boolean isAdmin(){
        return roles.contains("ADMIN");
    }
    public Boolean isSpeaker(){
        return roles.contains("SPEAKER");
    }
    public Boolean isVisitor(){
        return roles.contains("VISITOR");
    }
    public Boolean isUser(){
        return roles.contains("USER");
    }
    public Boolean isRole(Role role) { return roles.contains(role); }





}
