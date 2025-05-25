package za.ac.cput.service;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.User;

import java.util.List;

public interface iSubjectService {
   Subject create(Subject Subject);
   Subject read(String id);
   Subject update(Subject Subject);
   List<Subject> getAll();
   List<Subject> getByName(String subjectName);

}
