package com.example.internetbanking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table
@Getter
@Setter
public class UserTransactions {

    @Id
    @Column
    private int id;

    @Column
    private Date transactionDate;

    @Column
    private String vendor;

    @Column
    private String type;

    @Column
    private double amount;

    @Column
    private String category;

}
