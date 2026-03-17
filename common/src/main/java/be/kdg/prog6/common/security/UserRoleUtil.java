package be.kdg.prog6.common.security;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.Map;

public final class UserRoleUtil {
    private UserRoleUtil() {
        throw new AssertionError("Utility class");
    }

    /**
     * Extracts the user role from a JWT token and maps it to the UserRole enum
     * <b>(Assuming a user can only have one role within the Mineral Flow System).</b>
     *
     * @param jwt The JWT token.
     * @return The extracted UserRole. If no valid role is found, returns UserRole.UNKNOWN.
     */
    public static UserRole extractRole(final Jwt jwt) {
        final Map<String, Object> claims = jwt.getClaims();
        if (claims == null) {
            return UserRole.UNKNOWN;
        }
        final Object realmAccessObj = claims.get("realm_access");
        if (!(realmAccessObj instanceof Map<?, ?> accessMap)) {
            return UserRole.UNKNOWN;
        }
        final Object rolesObj = accessMap.get("roles");
        if (!(rolesObj instanceof List<?> rolesList) || rolesList.isEmpty()) {
            return UserRole.UNKNOWN;
        }
        return rolesList.stream()
            .filter(String.class::isInstance)
            .map(String.class::cast)
            .map(UserRole::fromString)
            .filter(role -> role != UserRole.UNKNOWN)
            .findFirst()
            .orElse(UserRole.UNKNOWN);
    }

    /**
     * Checks whether the authenticated user has the specified role.
     *
     * @param jwt  The JWT token.
     * @param role The role to check for.
     * @return {@code true} if the user has the specified role.
     */
    public static boolean hasRole(final Jwt jwt, final UserRole role) {
        return extractRole(jwt) == role;
    }

    public static boolean isAdmin(final Jwt jwt) {
        return hasRole(jwt, UserRole.ADMIN);
    }
}
