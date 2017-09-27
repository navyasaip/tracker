package cartracker.api.service;

import cartracker.api.entity.Vehicle;
import cartracker.api.exceptions.BadRequestException;
import cartracker.api.exceptions.ResourceNotFoundException;
import cartracker.api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles() {
        return repository.getVehicles();
    }

    @Transactional(readOnly = true)
    public Vehicle findByVin(String vin) {
        Vehicle existing = repository.findByVin(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle v) {
        Vehicle existing = repository.findByVin(v.getVin());
        if (existing != null) {
           return update(v.getVin(),v);
        }
        return repository.create(v);
    }

    @Transactional
    public Vehicle update(String vin, Vehicle v) {
        Vehicle existing = repository.findByVin(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
        return repository.update(v);
    }

    @Transactional
    public void delete(String vin) {
        Vehicle existing = repository.findByVin(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
        repository.delete(existing);
    }
}