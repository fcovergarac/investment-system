package com.portfolio.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.portfolio.domain.exception.InvalidQuantityException;

@DisplayName("Transaction Quantity Validation Unit Tests")
public class QuantityValidationTest {
    
    @ParameterizedTest
    @ValueSource(ints = {0, -5, -100})
    @DisplayName("Should throw InvalidQuantityException for non-positive quantities")
    public void testPurchaseWithInvalidQuantityShouldThrowException(int invalidQuantity) {
        // Arrange
        TransactionValidator validator = new TransactionValidator();

        // Act
        InvalidQuantityException exception = assertThrows(InvalidQuantityException.class, () -> {
            validator.validatePurchaseQuantity(invalidQuantity);
        });

        // Assert
        assertEquals("The purchase quantity must be greater than zero.", exception.getMessage());
    }

    @Test
    @DisplayName("Should process purchase quantity successfully without exceptions when quantity is valid")
    public void testValidPurchaseQuantityShouldNotThrowException() {
        // Arrange 
        TransactionValidator validator = new TransactionValidator();
        int validQuantity = 50;

        // Act & Assert
        assertDoesNotThrow(() -> {
            validator.validatePurchaseQuantity(validQuantity);
        }, "A quantity strictly greater than zero must be accepted without errors.");
    }
}
