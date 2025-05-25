package za.ac.cput.service;

import za.ac.cput.domain.Subject;

import java.util.List;

public interface iSubjectService {
   List<Subject> getAll();
   List<Subject> getByName(String subjectName);

}
