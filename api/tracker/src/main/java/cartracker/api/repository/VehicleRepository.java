package cartracker.api.repository;

import cartracker.api.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> getVehicles();
    Vehicle findByVin(String vin);
    Vehicle create(Vehicle v);
    Vehicle update(Vehicle v);
    void delete(Vehicle v);
}
