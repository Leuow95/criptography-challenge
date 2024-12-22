package dev.leomaia.criptography_challenge.exceptions;

public class TransactionNotFoundException extends Exception{
    public TransactionNotFoundException(Long id) {
        super("Transaction " + id + " not found");
    }
}
