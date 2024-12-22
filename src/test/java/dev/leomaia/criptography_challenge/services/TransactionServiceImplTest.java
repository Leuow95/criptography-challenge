package dev.leomaia.criptography_challenge.services;

import dev.leomaia.criptography_challenge.dtos.TransactionRequestDTO;
import dev.leomaia.criptography_challenge.dtos.TransactionResponseDTO;
import dev.leomaia.criptography_challenge.entities.Transaction;
import dev.leomaia.criptography_challenge.repositories.TransactionRepository;
import dev.leomaia.criptography_challenge.utils.CryptographyHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CryptographyHandler cryptographyHandler;

    private TransactionRequestDTO transactionRequestDTO;
    private AutoCloseable closeable;


    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        transactionRequestDTO = new TransactionRequestDTO("123456789", "token123", 1000L);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testCreateTransaction() throws Exception {
        // Arrange
        String encryptedDocument = "encryptedDocument";
        String creditCardToken = "creditCardToken";

        when(cryptographyHandler.encrypt(transactionRequestDTO.userDocument())).thenReturn(encryptedDocument);
        when(cryptographyHandler.encrypt(transactionRequestDTO.creditCardToken())).thenReturn(creditCardToken);

        Transaction transactionToSave = new Transaction();
        transactionToSave.setUserDocument(encryptedDocument);
        transactionToSave.setCreditCardToken(creditCardToken);
        transactionToSave.setValue(transactionRequestDTO.value());

        when(transactionRepository.save(any(Transaction.class))).thenReturn(transactionToSave);

        // Act
        TransactionResponseDTO responseDTO = transactionService.createTransaction(transactionRequestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(encryptedDocument, responseDTO.userDocument());
        assertEquals(creditCardToken, responseDTO.creditCardToken());
        assertEquals(transactionRequestDTO.value(), responseDTO.value());

        // Verify
        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    public void testGetTransactionById() {
        // Arrange
//        Transaction transaction = new Transaction(1L, "encryptedDocument", "encryptedToken", 1000L);
//        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
//
//        // Act
//        TransactionResponseDTO responseDTO = transactionService.getTransactionById(1L);
//
//        // Assert
//        assertNotNull(responseDTO);
//        assertEquals(transaction.getId(), responseDTO.id());
//        assertEquals(transaction.getUserDocument(), responseDTO.userDocument());
    }

    @Test
    public void testUpdateTransaction() throws Exception {
        // Arrange
//        Transaction existingTransaction = new Transaction(1L, "encryptedDocument", "encryptedToken", 1000L);
//        when(transactionRepository.findById(1L)).thenReturn(Optional.of(existingTransaction));
//        when(cryptographyHandler.encrypt(transactionRequestDTO.userDocument())).thenReturn("newEncryptedDocument");
//        when(cryptographyHandler.encrypt(transactionRequestDTO.creditCardToken())).thenReturn("newEncryptedToken");
//
//        // Act
//        TransactionResponseDTO responseDTO = transactionService.updateTransaction(1L, transactionRequestDTO);
//
//        // Assert
//        assertNotNull(responseDTO);
//        assertEquals("newEncryptedDocument", responseDTO.userDocument());
//        assertEquals("newEncryptedToken", responseDTO.creditCardToken());
//
//        // Verify
//        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    public void testDeleteTransaction() {
        return;
    }
        // Arrange


    @Test
    public void testGetTransactions() {
        return;
    }
}
