package com.soCompany.entity;

import com.soCompany.entity.interfaces.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@NamedQuery(
        name = "Company.findByName",
        query = "SELECT c from Company c where lower(c.name) = lower(:name)"
)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "companies")
public class Company implements BaseEntity {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "industry")
    private String industry;

    @Column(name = "founded_date")
    private Date foundedDate;

    public Company(String name, String industry, Date foundedDate) {
        this.name = name;
        this.industry = industry;
        this.foundedDate = foundedDate;
    }
}
