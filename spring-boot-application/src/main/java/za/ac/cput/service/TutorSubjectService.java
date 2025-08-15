package za.ac.cput.service;
/* Subject.java

     TutorSubjectSubject POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorSubject;

import java.util.List;
import java.util.Optional;

@Service
public class TutorSubjectService implements iTutorSubjectService {
    @Autowired
    public static TutorSubject service;
    private TutorSubjectService repository;

    public TutorSubject create(TutorSubject tutorSubject) {
        return repository.create(tutorSubject);
    }

    public TutorSubject read(String subjectCode) {
        return repository.read(subjectCode);

    }

    public TutorSubject update(TutorSubject subjectName) {
        repository.update(subjectName);
        return subjectName;
    }

    public boolean delete(String subjectCode) {
        this.repository.delete(subjectCode);
        return true;
    }

    public List<Subject> getAll() {
        return this.repository.getAll();
    }
    public Optional<Subject> getSubjectId(String subjectId) {
        return Optional.empty();
    }
}










