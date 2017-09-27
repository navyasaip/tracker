package cartracker.api.service;

import cartracker.api.entity.Alerts;
import cartracker.api.entity.Readings;
import cartracker.api.entity.Vehicle;
import cartracker.api.exceptions.ResourceNotFoundException;
import cartracker.api.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingsServiceImpl implements ReadingsService {

    @Autowired
    ReadingsRepository repository;


    @Transactional(readOnly = true)
    public List<Readings> getReadings() {
        return repository.getReadings();
    }

    @Transactional(readOnly = true)
    public List<Readings> readingByVin(String vin) {
        List<Readings> exist = repository.readingByVin(vin);
        if(exist.size() == 0){
            throw new ResourceNotFoundException("Reading with vin: "+vin+" does not exist");
        }
        return exist;
    }

    @Transactional
    public Readings readingCreate(Readings r) {
        /*Readings exist = repository.readingByVin(r.getVin());
        if(exist != null){
           return readingUpdate(r);
        }*/
        return repository.readingCreate(r);
    }

/*    @Transactional
    public Readings readingUpdate(Readings r) {
        Readings exist = repository.readingByVin(r.getVin());
        if(exist == null){
            throw new ResourceNotFoundException("Reading with vin: "+r.getVin()+" does not exist");
        }
        return repository.readingUpdate(r);
    }

    @Transactional
    public void readingDelete(Readings r) {
        Readings exist = repository.readingByVin(r.getVin());
        if(exist == null){
            throw new ResourceNotFoundException("Reading with vin: "+r.getVin()+" does not exist");
        }
        repository.readingDelete(exist);
    }*/
}
