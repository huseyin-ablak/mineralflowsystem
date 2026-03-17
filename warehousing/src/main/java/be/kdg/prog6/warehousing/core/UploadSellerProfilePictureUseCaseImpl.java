package be.kdg.prog6.warehousing.core;

import be.kdg.prog6.warehousing.core.policy.AccessMode;
import be.kdg.prog6.warehousing.core.policy.ResourceAccessPolicy;
import be.kdg.prog6.warehousing.domain.SellerId;
import be.kdg.prog6.warehousing.port.in.usecase.UploadSellerProfilePictureUseCase;
import be.kdg.prog6.warehousing.port.out.SellerProfilePicturePort;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UploadSellerProfilePictureUseCaseImpl implements UploadSellerProfilePictureUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadSellerProfilePictureUseCaseImpl.class);

    private final SellerProfilePicturePort sellerProfilePicturePort;
    private final ResourceAccessPolicy resourceAccessPolicy;

    public UploadSellerProfilePictureUseCaseImpl(final SellerProfilePicturePort sellerProfilePicturePort,
                                                 final ResourceAccessPolicy resourceAccessPolicy) {
        this.sellerProfilePicturePort = sellerProfilePicturePort;
        this.resourceAccessPolicy = resourceAccessPolicy;
    }

    @Override
    @Transactional
    public void uploadProfilePicture(final SellerId sellerId, final byte[] content, final String contentType, final Jwt jwt) {
        LOGGER.info("Uploading Profile Picture for Seller with ID {}", sellerId.id());
        resourceAccessPolicy.enforce(jwt, sellerId.id(), AccessMode.WRITE);
        sellerProfilePicturePort.saveProfilePicture(sellerId, content, contentType);
    }
}
