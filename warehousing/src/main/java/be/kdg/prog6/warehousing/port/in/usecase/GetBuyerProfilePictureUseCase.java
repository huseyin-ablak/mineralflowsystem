package be.kdg.prog6.warehousing.port.in.usecase;

import be.kdg.prog6.warehousing.domain.BuyerId;
import be.kdg.prog6.warehousing.port.out.ProfilePicture;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;

@FunctionalInterface
public interface GetBuyerProfilePictureUseCase {
    Optional<ProfilePicture> getProfilePicture(BuyerId buyerId, Jwt jwt);
}
