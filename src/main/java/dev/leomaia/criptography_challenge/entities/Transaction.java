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

    public Transaction(Long id,String userDocument, String creditCardToken, Long value) {
        this.setId(id);
        this.userDocument = userDocument;
        this.creditCardToken = creditCardToken;
        this.value = value;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Transaction(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
