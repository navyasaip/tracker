package cartracker.api.repository;

import cartracker.api.entity.Readings;
import cartracker.api.entity.Tires;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Readings> getReadings() {
        TypedQuery<Readings> query = em.createNamedQuery("Readings.findAll",Readings.class);
        return query.getResultList();
    }

    public List<Readings> readingByVin(String vin) {
        TypedQuery<Readings> query = em.createNamedQuery("Readings.findByVIN",Readings.class);
        query.setParameter("paramVin",vin);
        return query.getResultList();
    }

    public Readings readingCreate(Readings r) {
        em.persist(r);
        return r;
    }

    public Readings readingUpdate(Readings r) {
        return em.merge(r);
    }

    public void readingDelete(Readings r) {
        em.remove(r);
    }
}
