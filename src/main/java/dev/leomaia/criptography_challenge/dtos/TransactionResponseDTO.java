package dev.leomaia.criptography_challenge.dtos;

import dev.leomaia.criptography_challenge.entities.Transaction;

public record TransactionResponseDTO(
        Long id,
        String userDocument,
        String creditCardToken,
        Long value
) {
    public static TransactionResponseDTO fromEntity(Transaction transaction){
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getUserDocument(),
                transaction.getCreditCardToken(),
                transaction.getValue()

        );
    }
}
