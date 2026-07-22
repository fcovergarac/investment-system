package com.portfolio.domain;

import com.portfolio.domain.exception.InvalidPriceException;
import com.portfolio.domain.exception.InvalidQuantityException;

public class TransactionValidator {
    public void validatePurchasePrice(double price) {
        if (price <= 0) {
            throw new InvalidPriceException("The purchase price must be greater than zero.");
        }
    }

    public void validatePurchaseQuantity(int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("The purchase quantity must be greater than zero.");
        }
    }
    
}
