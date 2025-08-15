package za.ac.cput.service;

/*  AvailabilityService.java
    Availability Service class
    Author: Hope  - 221174109
    Date: 25 May 2025
 */

import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;
import java.util.List;

public class AvailabilityService implements IAvailabilityService {

    private static IAvailabilityService service;
    private AvailabilityRepository repository;

    //@Override
    public Availability create(Availability availability) {
        return this.repository.save(availability);
    }

    //@Override
    public Availability read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    //@Override
    public Availability update(Availability availability) {
        return this.repository.save(availability);
    }

    //@Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    //@Override
    public List<Availability> getAll() {
        return this.repository.findAll();
    }
}

