package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService implements iSubjectService {
    public static iSubjectService service;
    private SubjectService repository;


    public static iSubjectService getService() {
        if (service == null) {
            service = new SubjectService();
        }
        return service;
    }

    private SubjectService() {
        repository = SubjectRepository.getRepository();
    }
    public Subject create (Subject subject) {
        return repository.create(subject);

    }
    public Subject read(String subjectCode){
        return this.repository.read(subjectCode);
    }
    public Subject update(Subject subject){
        return this.repository.update(subject);
    }

   @Override
    public List<Subject> getAll() {
        return this.repository.getAll();
    }
    public boolean delete(Subject subject){
        return false;
    }

    @Override
    public List<Subject> getByName(String subjectName) {
        return null;
    }
}