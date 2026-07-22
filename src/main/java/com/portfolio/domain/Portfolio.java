package com.portfolio.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Portfolio {
    private double totalValue;
    private final List<Transaction> transactions;
    private final NotificationService notificationService;
    private final TransactionValidator validator;

    public Portfolio(NotificationService notificationService) {
        this.totalValue = 0.0;
        this.transactions = new ArrayList<>();
        this.notificationService = notificationService;
        this.validator = new TransactionValidator();
    }
    public void buyAsset(String assetName, double unitPrice, int quantity) {
        validator.validatePurchasePrice(unitPrice);
        validator.validatePurchaseQuantity(quantity);
        
        double totalCost = unitPrice * quantity;
        this.totalValue += totalCost;

        String alertMessage = "Successful purchase: " + quantity + " units of " + assetName;
        Transaction transaction = new Transaction(assetName, unitPrice, quantity, alertMessage);
        transactions.add(transaction);
        
        notificationService.sendTransactionAlert(alertMessage);
    }
    public double getTotalValue() {
        return totalValue;
    }
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
