package dev.leomaia.criptography_challenge.services;

import dev.leomaia.criptography_challenge.dtos.TransactionRequestDTO;
import dev.leomaia.criptography_challenge.dtos.TransactionResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {
    TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) throws Exception;
    TransactionResponseDTO getTransactionById(Long id);
    TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO transactionRequestDTO) throws Exception;
    void deleteTransaction(Long id) throws Exception;
    List<TransactionResponseDTO> getTransactions(Pageable pageable);
}
