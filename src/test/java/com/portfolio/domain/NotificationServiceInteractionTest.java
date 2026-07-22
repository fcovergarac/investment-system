package com.portfolio.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Notification Service Interaction Unit Tests")
public class NotificationServiceInteractionTest {

    private static class StubNotificationService implements NotificationService {
        @Override 
        public void sendTransactionAlert(String message) {
        }
    }

    @Test
    @DisplayName("Should allow portfolio creation using a manual stub implementation")
    public void testManualStubImplementationShouldAllowPortfolioCreation() {
        // Arrange
        NotificationService stubService = new StubNotificationService();

        // Act
        Portfolio portfolio = new Portfolio(stubService);

        // Assert
        assertNotNull(portfolio, "The portfolio was successfully injected using a manual Stub.");
    }

    @Test
    @DisplayName("Should verify transaction alert invocation on mock service")
    public void testMockitoVerificationForAlertService() {
        // Arrange
        NotificationService mockService = mock(NotificationService.class);
        String testAlertMessage = "Infrastructure test alert";

        // Act
        mockService.sendTransactionAlert(testAlertMessage);

        // Assert
        verify(mockService).sendTransactionAlert(testAlertMessage);
    }
}
