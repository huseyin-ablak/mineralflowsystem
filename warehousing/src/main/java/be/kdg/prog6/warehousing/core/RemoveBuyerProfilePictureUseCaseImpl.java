package be.kdg.prog6.warehousing.core;

import be.kdg.prog6.warehousing.core.policy.AccessMode;
import be.kdg.prog6.warehousing.core.policy.ResourceAccessPolicy;
import be.kdg.prog6.warehousing.domain.BuyerId;
import be.kdg.prog6.warehousing.port.in.usecase.RemoveBuyerProfilePictureUseCase;
import be.kdg.prog6.warehousing.port.out.BuyerProfilePicturePort;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class RemoveBuyerProfilePictureUseCaseImpl implements RemoveBuyerProfilePictureUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveBuyerProfilePictureUseCaseImpl.class);

    private final BuyerProfilePicturePort buyerProfilePicturePort;
    private final ResourceAccessPolicy resourceAccessPolicy;

    public RemoveBuyerProfilePictureUseCaseImpl(final BuyerProfilePicturePort buyerProfilePicturePort,
                                                final ResourceAccessPolicy resourceAccessPolicy) {
        this.buyerProfilePicturePort = buyerProfilePicturePort;
        this.resourceAccessPolicy = resourceAccessPolicy;
    }

    @Override
    @Transactional
    public void removeProfilePicture(final BuyerId buyerId, final Jwt jwt) {
        LOGGER.info("Removing Profile Picture for Buyer with ID {}", buyerId.id());
        resourceAccessPolicy.enforce(jwt, buyerId.id(), AccessMode.DELETE);
        buyerProfilePicturePort.removeProfilePicture(buyerId);
    }
}
