package cartracker.api.controller;

import cartracker.api.entity.Vehicle;
import cartracker.api.entity.VehicleList;
import cartracker.api.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET   , value="/display",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getVehicles(){

        return service.getVehicles();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findByVin(@PathVariable("id") String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/put", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleList create(@RequestBody VehicleList vehicles) {
        VehicleList vehicles1 = new VehicleList();
        for(Vehicle v : vehicles){
            vehicles1.add(service.create(v));
        }
        return vehicles1;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/readings",
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Vehicle update(@RequestBody Vehicle v) {
//        return service.update(v.getVin(),v);
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String vin) {
        service.delete(vin);
    }
}

