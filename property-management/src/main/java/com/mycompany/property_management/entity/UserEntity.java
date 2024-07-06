package com.mycompany.property_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //class can be mapped to a table
@Table(name="USER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //generating value for id column automatucally
    private Long id;
    // @Column(name="PROPERTY_TITLE", nullable = false)
    private String ownerName;
    private String email;
    private String phone;
    private String password;

}
