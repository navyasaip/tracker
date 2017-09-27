package cartracker.api.repository;

import cartracker.api.entity.Alerts;
import cartracker.api.entity.Readings;
import cartracker.api.entity.Vehicle;

import java.util.List;

public interface AlertsRepository {
    List<Alerts> getAlerts();
    List<Alerts> getAlertsByVin(String vin);
    Alerts alertsCreate(Alerts alert);
}
