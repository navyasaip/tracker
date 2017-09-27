package cartracker.api.repository;

import cartracker.api.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository
{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> getVehicles() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findByVin(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle create(Vehicle v) {
        entityManager.persist(v);
        return v;
    }

    public Vehicle update(Vehicle v) {
        return entityManager.merge(v);
    }

    public void delete(Vehicle v) {
        entityManager.remove(v);
    }
}
