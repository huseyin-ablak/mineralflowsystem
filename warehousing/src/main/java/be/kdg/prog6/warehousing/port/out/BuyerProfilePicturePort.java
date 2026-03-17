package be.kdg.prog6.warehousing.port.out;

import be.kdg.prog6.warehousing.domain.BuyerId;

import java.util.Optional;

public interface BuyerProfilePicturePort {
    Optional<ProfilePicture> loadProfilePicture(BuyerId buyerId);

    void saveProfilePicture(BuyerId buyerId, byte[] content, String contentType);

    void removeProfilePicture(BuyerId buyerId);
}