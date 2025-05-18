package za.ac.cput.Factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    public static Subject createSubject(String subjectCode,String subjectName,String subjectDescription
            ,String department,String difficultyLevel){



        return new Subject.SubjectBuilder()
                .setSubjectCode(subjectCode)
                .setSubjectName(subjectName)
                .setSubjectDescription(subjectDescription)
                .setDepartment(department)
                .setDifficultyLevel(difficultyLevel)
                .build();


    }
}
