package dev.leomaia.criptography_challenge.services;

import dev.leomaia.criptography_challenge.dtos.TransactionRequestDTO;
import dev.leomaia.criptography_challenge.dtos.TransactionResponseDTO;
import dev.leomaia.criptography_challenge.entities.Transaction;
import dev.leomaia.criptography_challenge.exceptions.TransactionNotFoundException;
import dev.leomaia.criptography_challenge.repositories.TransactionRepository;
import dev.leomaia.criptography_challenge.utils.CryptographyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final CryptographyHandler cryptographyHandler;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, CryptographyHandler cryptographyHandler) {
        this.transactionRepository = transactionRepository;
        this.cryptographyHandler = cryptographyHandler;
    }

    
    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) throws Exception {
        Transaction entity = new Transaction();

        entity.setUserDocument(cryptographyHandler.encrypt(transactionRequestDTO.userDocument()));
        entity.setCreditCardToken(cryptographyHandler.encrypt(transactionRequestDTO.creditCardToken()));
        entity.setValue(transactionRequestDTO.value());

        var newTransaction = transactionRepository.save(entity);

        return TransactionResponseDTO.fromEntity(newTransaction);
    }

    @Override
    public TransactionResponseDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.getReferenceById(id);

        return TransactionResponseDTO.fromEntity(transaction);
    }

    @Override
    public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO transactionRequestDTO) throws Exception {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));

        transaction.setUserDocument(cryptographyHandler.encrypt(transactionRequestDTO.userDocument()));
        transaction.setCreditCardToken(cryptographyHandler.encrypt(transactionRequestDTO.creditCardToken()));
        transaction.setValue(transactionRequestDTO.value());

        var updatedTransaction = transactionRepository.save(transaction);

        return TransactionResponseDTO.fromEntity(updatedTransaction);

    }

    @Override
    public void deleteTransaction(Long id) throws Exception {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));

        transactionRepository.delete(transaction);

    }

    @Override
    public Page<TransactionResponseDTO> getTransactions(Pageable pageable) {
        var transactionsPage = transactionRepository.findAll(pageable);

        return transactionsPage.map(TransactionResponseDTO::fromEntity);
    }
}
