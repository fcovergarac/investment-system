package com.portfolio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Portfolio Initialization Unit Tests")
public class PortfolioInitializationTest {
    @Test
    @DisplayName("Should initialize portfolio with zero balance and empty transaction list")
    public void testNewPortfolioShouldInitializeWithZeroBalanceAndEmptyTransactions() {
        // Arrange 
        NotificationService mockNotificationService = mock(NotificationService.class);
        Portfolio portfolio;

        // Act
        portfolio = new Portfolio(mockNotificationService);

        // Assert
        assertNotNull(portfolio.getTransactions(), "Transaction history should not be null upon initialization.");
        assertTrue(portfolio.getTransactions().isEmpty(), "A new portfolio must start with zero records.");
        assertEquals(0.0, portfolio.getTotalValue(), 0.001, "The initial balance of the investor must be 0.0.");
    }
}
