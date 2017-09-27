package cartracker.api.service;

import cartracker.api.entity.Readings;

import java.util.List;

public interface ReadingsService {
    List<Readings> getReadings();
    List<Readings> readingByVin(String vin);
    Readings readingCreate(Readings r);
}
