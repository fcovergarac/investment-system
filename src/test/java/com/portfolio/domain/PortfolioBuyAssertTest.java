package com.portfolio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Portfolio Buy Asset Unit Tests")
public class PortfolioBuyAssertTest {
    
    @Test
    @DisplayName("Should increase portfolio total value and trigger notification alert on asset purchase")
    public void testBuyAssetShouldIncreaseTotalValueAndSendNotification() {
        // Arrange 
        NotificationService mockNotificationService = mock(NotificationService.class);
        Portfolio portfolio = new Portfolio(mockNotificationService);

        String assetTicker = "AAPL";
        double unitPrice = 150.0;
        int unitQuantity = 10;
        double expectedTotalValue = 1500.0;
        String expectedAlertMessage = "Successful purchase: 10 units of AAPL";

        // Act
        portfolio.buyAsset(assetTicker, unitPrice, unitQuantity);

        // Assert
        assertEquals(expectedTotalValue, portfolio.getTotalValue(), 0.001, "El valor del portafolio debe reflejar el costo total.");
        verify(mockNotificationService, times(1)).sendTransactionAlert(expectedAlertMessage);

        assertFalse(portfolio.getTransactions().isEmpty(), "Transaction list should not be empty after a purchase.");
        Transaction recordedTransaction = portfolio.getTransactions().get(0);
        
        assertEquals(assetTicker, recordedTransaction.getAssetTicker(), "Asset ticker must match.");
        assertEquals(unitPrice, recordedTransaction.getUnitPrice(), 0.001, "Unit price must match.");
        assertEquals(unitQuantity, recordedTransaction.getQuantity(), "Quantity must match.");
        assertEquals(expectedAlertMessage, recordedTransaction.getDescription(), "Description must match.");
    }
}
