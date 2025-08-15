package za.ac.cput.service;
/*  UniversityServiceTest.java
    University Service test class
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Factory.UniversityFactory;
import za.ac.cput.domain.University;
import za.ac.cput.service.UniversityService;
import za.ac.cput.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(Methodorderer.MethodName.class)
public class UniversityServiceTest {
    private UniversityService service;
    private University university = UniversityFactory.createUniversity("CPUT", "Cape Town", "D6");
    @Test
    void a_create(){
        University created = service.create(university);
        assertNotNull(created);
        System.out.println(created);
    }
    @Test
    void b_read(){
        University read = service.read(university.getUniversityId());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void d_update(){
        University newUniversity = new University.UniversityBuilder().copy(university).domain("District Six").build();
        University updated = service.update(newUniversity);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    void e_getAll(){
        System.out.println(service.getAll());
    }
}
