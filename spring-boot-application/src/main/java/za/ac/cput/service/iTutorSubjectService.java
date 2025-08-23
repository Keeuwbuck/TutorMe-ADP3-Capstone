package za.ac.cput.service;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorSubject;

import java.util.List;
import java.util.Optional;

public interface iTutorSubjectService {
    List<Subject> getAll();

    Optional<Subject> getSubjectId(String subjectId);

}
