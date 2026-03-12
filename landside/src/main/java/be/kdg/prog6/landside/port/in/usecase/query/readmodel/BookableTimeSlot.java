package be.kdg.prog6.landside.port.in.usecase.query.readmodel;

import be.kdg.prog6.landside.domain.TimeSlot;

import java.time.LocalDateTime;

/// To be used in the frontend app to display bookable time slots
public record BookableTimeSlot(
    LocalDateTime startTime,
    LocalDateTime endTime,
    int remainingSpots
) {
    public static BookableTimeSlot fromDomain(final TimeSlot slot) {
        return new BookableTimeSlot(
            slot.getStartTime(),
            slot.getEndTime(),
            slot.getNumberOfRemainingSpots()
        );
    }
}