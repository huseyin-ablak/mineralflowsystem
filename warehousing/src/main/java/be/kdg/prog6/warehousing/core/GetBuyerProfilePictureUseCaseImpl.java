package be.kdg.prog6.warehousing.core;

import be.kdg.prog6.warehousing.core.policy.AccessMode;
import be.kdg.prog6.warehousing.core.policy.ResourceAccessPolicy;
import be.kdg.prog6.warehousing.domain.BuyerId;
import be.kdg.prog6.warehousing.port.in.usecase.GetBuyerProfilePictureUseCase;
import be.kdg.prog6.warehousing.port.out.BuyerProfilePicturePort;
import be.kdg.prog6.warehousing.port.out.ProfilePicture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetBuyerProfilePictureUseCaseImpl implements GetBuyerProfilePictureUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetBuyerProfilePictureUseCaseImpl.class);

    private final BuyerProfilePicturePort buyerProfilePicturePort;
    private final ResourceAccessPolicy resourceAccessPolicy;

    public GetBuyerProfilePictureUseCaseImpl(final BuyerProfilePicturePort buyerProfilePicturePort,
                                             final ResourceAccessPolicy resourceAccessPolicy) {
        this.buyerProfilePicturePort = buyerProfilePicturePort;
        this.resourceAccessPolicy = resourceAccessPolicy;
    }

    @Override
    public Optional<ProfilePicture> getProfilePicture(final BuyerId buyerId, final Jwt jwt) {
        LOGGER.info("Getting Profile Picture for Buyer with ID {}", buyerId.id());
        resourceAccessPolicy.enforce(jwt, buyerId.id(), AccessMode.READ);
        return buyerProfilePicturePort.loadProfilePicture(buyerId);
    }
}
