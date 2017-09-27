package cartracker.api.service;

import cartracker.api.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getVehicles();
    Vehicle findByVin(String vin);
    Vehicle create(Vehicle v);
    Vehicle update(String vin, Vehicle v);
    void delete(String vin);
}
