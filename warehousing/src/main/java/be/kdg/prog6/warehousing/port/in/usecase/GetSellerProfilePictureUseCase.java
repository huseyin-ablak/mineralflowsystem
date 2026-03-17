package be.kdg.prog6.warehousing.port.in.usecase;

import be.kdg.prog6.warehousing.domain.SellerId;
import be.kdg.prog6.warehousing.port.out.ProfilePicture;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;

@FunctionalInterface
public interface GetSellerProfilePictureUseCase {
    Optional<ProfilePicture> getProfilePicture(SellerId sellerId, Jwt jwt);
}
