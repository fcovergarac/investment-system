package com.portfolio.domain;

public class Transaction {
    private final String assetTicker;
    private final double unitPrice;
    private final int quantity;
    private final String description;

    public Transaction(String assetTicker, double unitPrice, int quantity, String description) {
        this.assetTicker = assetTicker;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.description = description;
    }

    public String getAssetTicker() {
        return assetTicker;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}
