package be.kdg.prog6.landside.port.in.usecase.query;

import be.kdg.prog6.landside.port.in.usecase.query.readmodel.BookableTimeSlot;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface GetBookableTimeSlotsUseCase {
    List<BookableTimeSlot> getBookableTimeSlotsFor(LocalDate date);
}