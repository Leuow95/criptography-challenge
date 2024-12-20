package dev.leomaia.criptography_challenge.dtos;

public record TransactionRequestDTO(
        String userDocument,
        String creditCardToken,
        Long value
) {
}
