package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.SubjectFactory;
import za.ac.cput.Factory.TutorSubjectFactory;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.Tutor;
import za.ac.cput.domain.TutorSubject;

import static org.junit.jupiter.api.Assertions.*;

class TutorSubjectFactoryTest {

    @Test
    void createTutorSubject() {
        TutorSubject tutorsubject= TutorSubjectFactory.createTutorSubject("Degree",
                4);
        assertEquals("Degree",tutorsubject.getProficiencyLevel() );
        assertEquals(9.00,tutorsubject.getSpesializedRate());
        System.out.println(tutorsubject);
    }
}