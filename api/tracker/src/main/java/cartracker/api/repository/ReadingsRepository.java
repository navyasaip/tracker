package cartracker.api.repository;

import cartracker.api.entity.Readings;

import java.util.List;

public interface ReadingsRepository {
    List<Readings> getReadings();
    List<Readings> readingByVin(String vin);
    Readings readingCreate(Readings r);
    Readings readingUpdate(Readings r);
    void readingDelete(Readings r);
}
