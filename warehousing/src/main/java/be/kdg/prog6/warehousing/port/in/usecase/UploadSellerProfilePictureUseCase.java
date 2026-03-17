package be.kdg.prog6.warehousing.port.in.usecase;

import be.kdg.prog6.warehousing.domain.SellerId;
import org.springframework.security.oauth2.jwt.Jwt;

@FunctionalInterface
public interface UploadSellerProfilePictureUseCase {
    void uploadProfilePicture(SellerId sellerId, byte[] content, String contentType, Jwt jwt);
}