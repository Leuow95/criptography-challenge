package dev.leomaia.criptography_challenge.controllers;

import dev.leomaia.criptography_challenge.dtos.TransactionRequestDTO;
import dev.leomaia.criptography_challenge.dtos.TransactionResponseDTO;
import dev.leomaia.criptography_challenge.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;


    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO)
            throws Exception {
        TransactionResponseDTO response = transactionService.createTransaction(transactionRequestDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable Long id) throws Exception {
        TransactionResponseDTO response = transactionService.getTransactionById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponseDTO>> getTransactions(Pageable pageable) {
        Page<TransactionResponseDTO> response = transactionService.getTransactions(pageable);
        return ResponseEntity.ok().body(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> updateTransaction(@PathVariable Long id, @RequestBody TransactionRequestDTO transactionRequestDTO) throws Exception {
        TransactionResponseDTO response = transactionService.updateTransaction(id, transactionRequestDTO);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) throws Exception {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
