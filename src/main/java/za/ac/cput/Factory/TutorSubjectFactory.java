package za.ac.cput.Factory;

import za.ac.cput.domain.TutorSubject;
import za.ac.cput.util.Helper;

public class TutorSubjectFactory {

    public static TutorSubject createTutorSubject(String proficiencyLevel,double spesializedRate){

        String studentSubjectId= Helper.generateId();

        return new TutorSubject.TutorSubjectBuilder()
                .setStudentSubjectId(studentSubjectId)
                .setProficiencyLevel(proficiencyLevel)
                .setSpesializedRate(spesializedRate)
                .build();







    }
}
