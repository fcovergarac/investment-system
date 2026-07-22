package com.portfolio.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.portfolio.domain.exception.InvalidPriceException;

@DisplayName("Transaction Price Validation Unit Tests")
public class PriceValidationTest {
    
    @Test
    @DisplayName("Should throw InvalidPriceException when purchase price is zero or negative")
    public void testPurchaseWithZeroOrNegativePriceShouldThrowException() {
        // Arrange
        TransactionValidator validator = new TransactionValidator();
        double invalidUnitPrice = 0.0;

        // Act & Assert
        assertThrows(InvalidPriceException.class, () -> {
            validator.validatePurchasePrice(invalidUnitPrice);
        }, "Registering an asset with a price less than or equal to zero must throw an InvalidPriceException.");
    }

    @Test
    @DisplayName("Should process purchase price successfully without exceptions when price is valid")
    public void testValidPurchasePriceShouldNotThrowException() {
        // Arrange
        TransactionValidator validator = new TransactionValidator();
        double validUnitPrice = 150.50;

        // Act & Assert 
        assertDoesNotThrow(() -> {
            validator.validatePurchasePrice(validUnitPrice);
        }, "A valid positive price must be processed seamlessly without exceptions.");
    }
}
