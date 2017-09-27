package cartracker.api.controller;


import cartracker.api.entity.Alerts;
import cartracker.api.entity.Readings;
import cartracker.api.entity.Vehicle;
import cartracker.api.entity.VehicleList;
import cartracker.api.service.AlertsService;
import cartracker.api.service.ReadingsService;
import cartracker.api.service.VehicleService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/readings")
public class ReadingsController {
    
    @Autowired
    ReadingsService readingsService;

    @Autowired
    AlertsService alertsService;

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET   , value="/display",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> getReadings(){
        return readingsService.getReadings();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> readingByVin(@PathVariable("id") String vin) {
        return readingsService.readingByVin(vin);
    }

    @RequestMapping(method = RequestMethod.POST, value="/post", consumes = {"application/json"},
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings r) {
        Vehicle v = vehicleService.findByVin(r.getVin());
        Alerts alerts = alertsService.checkAlerts(r,v);
        alertsService.alertsCreate(alerts);
        return readingsService.readingCreate(r);

    }
/*
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public void delete(@RequestBody Readings r) {
        readingsService.readingDelete(r);
    }*/
}
