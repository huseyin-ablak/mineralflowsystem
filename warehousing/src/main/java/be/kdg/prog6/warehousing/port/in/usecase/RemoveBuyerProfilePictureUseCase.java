package be.kdg.prog6.warehousing.port.in.usecase;

import be.kdg.prog6.warehousing.domain.BuyerId;
import org.springframework.security.oauth2.jwt.Jwt;

@FunctionalInterface
public interface RemoveBuyerProfilePictureUseCase {
    void removeProfilePicture(BuyerId buyerId, Jwt jwt);
}
