package za.ac.cput.service;
/* Subject.java

     TutorSubjectSubject POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.repository.TutorSubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TutorSubjectService implements ITutorSubjectService {

    @Autowired
    public static TutorSubject service;
    private TutorSubjectRepository repository;

    public TutorSubject create(TutorSubject tutorSubject) {
        return repository.save(tutorSubject);
    }

    public TutorSubject read(String subjectCode) {
        return repository.findById(subjectCode).orElse(null);
    }

    public TutorSubject update(TutorSubject subjectName) {
        repository.save(subjectName);
        return subjectName;
    }

    public boolean delete(String subjectCode) {
        this.repository.deleteById(subjectCode);
        return true;
    }

    public List<TutorSubject> getAll() {
        return this.repository.findAll();
    }
    public Optional<Subject> getSubjectId(String subjectId) {
        return Optional.empty();
    }
}










