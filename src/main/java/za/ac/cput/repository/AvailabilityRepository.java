package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, String> {
}
