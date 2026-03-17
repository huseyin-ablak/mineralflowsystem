package be.kdg.prog6.warehousing.port.out;

import be.kdg.prog6.warehousing.domain.SellerId;

import java.util.Optional;

public interface SellerProfilePicturePort {
    Optional<ProfilePicture> loadProfilePicture(SellerId sellerId);

    void saveProfilePicture(SellerId sellerId, byte[] content, String contentType);

    void removeProfilePicture(SellerId sellerId);
}
