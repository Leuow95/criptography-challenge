package dev.leomaia.criptography_challenge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CryptographyHandlerTest {

    CryptographyHandler cryptographyHandler = new CryptographyHandler();

    @Test
    @DisplayName("Should return a encrypted value")
    void encrypt() throws Exception{
        //ARRANGE
        String testValue = "valorTeste";

        //ACT
        String encryptedValue = cryptographyHandler.encrypt(testValue);

        //ASSERT
        assertNotEquals(testValue, encryptedValue);


    }

    @Test
    @DisplayName("Should return a decrypted value")
    void decrypt() throws Exception{
        //ARRANGE
        String testValue = "valorTeste";

        //ACT
        String encryptedValue = this.cryptographyHandler.encrypt(testValue);
        String decryptedValue = this.cryptographyHandler.decrypt(encryptedValue);

        //ASSERT
        assertEquals(testValue, decryptedValue);
    }
}