package dev.leomaia.criptography_challenge.dtos;

public record TransactionResponseDTO(
        Long id,
        String userDocument,
        String creditCardToken,
        Long value
) {
}
