package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.TutorSubject;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorSubjectRepository extends JpaRepository<TutorSubject, String> {
    Optional<TutorSubject> findbySubjectId(String subjectId);
    List<TutorSubject> getAll();

}
