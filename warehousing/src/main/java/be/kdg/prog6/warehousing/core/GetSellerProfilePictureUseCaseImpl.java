package be.kdg.prog6.warehousing.core;

import be.kdg.prog6.warehousing.core.policy.AccessMode;
import be.kdg.prog6.warehousing.core.policy.ResourceAccessPolicy;
import be.kdg.prog6.warehousing.domain.SellerId;
import be.kdg.prog6.warehousing.port.in.usecase.GetSellerProfilePictureUseCase;
import be.kdg.prog6.warehousing.port.out.ProfilePicture;
import be.kdg.prog6.warehousing.port.out.SellerProfilePicturePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSellerProfilePictureUseCaseImpl implements GetSellerProfilePictureUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetSellerProfilePictureUseCaseImpl.class);

    private final SellerProfilePicturePort sellerProfilePicturePort;
    private final ResourceAccessPolicy resourceAccessPolicy;

    public GetSellerProfilePictureUseCaseImpl(final SellerProfilePicturePort sellerProfilePicturePort,
                                              final ResourceAccessPolicy resourceAccessPolicy) {
        this.sellerProfilePicturePort = sellerProfilePicturePort;
        this.resourceAccessPolicy = resourceAccessPolicy;
    }

    @Override
    public Optional<ProfilePicture> getProfilePicture(final SellerId sellerId, final Jwt jwt) {
        LOGGER.info("Getting Profile Picture for Seller with ID {}", sellerId.id());
        resourceAccessPolicy.enforce(jwt, sellerId.id(), AccessMode.READ);
        return sellerProfilePicturePort.loadProfilePicture(sellerId);
    }
}
