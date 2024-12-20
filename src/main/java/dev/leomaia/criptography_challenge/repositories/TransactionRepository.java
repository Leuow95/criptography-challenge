package dev.leomaia.criptography_challenge.repositories;

import dev.leomaia.criptography_challenge.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
