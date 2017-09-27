package cartracker.api.repository;

import cartracker.api.entity.Alerts;
import cartracker.api.entity.Readings;
import cartracker.api.entity.Tires;
import cartracker.api.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertsRepositoryImpl implements AlertsRepository {


    @PersistenceContext
    private EntityManager enMan;

    public List<Alerts> getAlerts() {
        TypedQuery<Alerts> query = enMan.createNamedQuery("Alerts.findAll",Alerts.class);
        return query.getResultList();
    }

    public List<Alerts> getAlertsByVin(String vin) {
        TypedQuery<Alerts> query = enMan.createNamedQuery("Alerts.findByVIN",Alerts.class);
        query.setParameter("paramVin",vin);
        return query.getResultList();
    }

    public Alerts alertsCreate(Alerts alert) {
        enMan.persist(alert);
        return alert;
    }

}
