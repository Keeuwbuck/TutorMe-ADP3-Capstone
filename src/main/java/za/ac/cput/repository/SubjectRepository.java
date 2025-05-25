package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Subject;
import za.ac.cput.service.SubjectService;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    static SubjectService getRepository() {
        return null;
    }
    Optional<Subject> findbysubjectName(String subjectName);
    Optional<Subject> findbyDepartment(String Department);
    Optional<Subject> findbysubjectCode(String subjectCode);
}
