package com.soCompany.entity;


import com.soCompany.entity.interfaces.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clients")
public class Client implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer id;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "name")
    private String name;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Client(Integer companyID, String name, String contactPerson, String email, String phoneNumber) {
        this.companyId = companyID;
        this.name = name;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
