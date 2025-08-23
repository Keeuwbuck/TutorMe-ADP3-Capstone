package za.ac.cput.service;

import za.ac.cput.domain.Availability;

import java.util.List;

public interface IAvailabilityService {
    Availability create(Availability availability);

    Availability read(String id);

    Availability update(Availability availability);

    boolean delete(String id);

    List<Availability> getAll();
}
