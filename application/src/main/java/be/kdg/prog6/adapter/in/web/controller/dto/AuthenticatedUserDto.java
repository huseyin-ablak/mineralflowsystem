package be.kdg.prog6.adapter.in.web.controller.dto;

import be.kdg.prog6.common.security.UserRole;

public record AuthenticatedUserDto(String id,
                                   String email,
                                   String firstName,
                                   String lastName,
                                   RoleDto role) {
    public static AuthenticatedUserDto from(final String id,
                                            final String email,
                                            final String firstName,
                                            final String lastName,
                                            final UserRole role) {
        return new AuthenticatedUserDto(id, email, firstName, lastName, RoleDto.of(role));
    }
}
