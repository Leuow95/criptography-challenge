package dev.leomaia.criptography_challenge.entities;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "userDocument", nullable = false)
    private String userDocument;

    @Column(name = "creditCardToken", nullable = false)
    private String creditCardToken;

    @Column(name = "value", nullable = false)
    private Long value;


}
