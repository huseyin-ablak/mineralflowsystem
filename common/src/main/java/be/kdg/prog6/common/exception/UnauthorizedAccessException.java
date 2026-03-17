package be.kdg.prog6.common.exception;

import java.util.UUID;

public class UnauthorizedAccessException extends RuntimeException {
    private UnauthorizedAccessException(final String message) {
        super(message);
    }

    public static UnauthorizedAccessException byUser(final UUID authenticatedUserId, final UUID resourceOwnerId) {
        return new UnauthorizedAccessException(
            "User %s is not authorized to access resource owned by %s".formatted(authenticatedUserId, resourceOwnerId)
        );
    }
}
