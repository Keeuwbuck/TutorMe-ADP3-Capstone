package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorSubject;

import java.util.List;
@Service
public class TutorSubjectService implements iTutorSubjectService {
    public static TutorSubject service;
    private TutorSubjectService repository;

    public TutorSubjectService create(TutorSubject tutorSubject) {
        return repository.create(tutorSubject);
    }

    public TutorSubject read(String subjectCode) {
        return repository.read(subjectCode);

    }

    public void update(TutorSubject subjectName) {
        repository.update(subjectName);
    }

    public boolean delete(String subjectCode) {
        this.repository.delete(subjectCode);
        return true;
    }

    public List<TutorSubject> getAll() {
        return this.repository.getAll();


    }
}










