package za.ac.cput.service;
/* TutorSubjectServiceTest.java

     Subject POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Factory.TutorSubjectFactory;
import za.ac.cput.domain.TutorSubject;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(Methodorderer.MethodName.class)
class TutorSubjectServiceTest {
    private TutorSubjectService service;
    private TutorSubject tutor= TutorSubjectFactory.createTutorSubject("Degree",9.00);

    @Test
    void a_create() {
        TutorSubject created=service.create(tutor);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        TutorSubject read=service.read(tutor.getProficiencyLevel());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        TutorSubject update=new TutorSubject.TutorSubjectBuilder().copy(tutor).setSpesializedRate(8.5)
                .build();
        assertNotNull(update);
        System.out.println(update);

    }
    void e_getAll(){
        System.out.println(service.getAll());
    }


    }


