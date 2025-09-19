package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Subject;
import za.ac.cput.factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubjectControllerTest {

    private static Subject subject;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port+ "/TutorMe-ADP3-Capstone/spring-boot-application/subject";
    }
    @BeforeAll
    public static void setUp() {
        subject = SubjectFactory.createSubject(
                "1",
                "ADP",
                "Application Development",
                "IT",
                "5"
        );
    }

    @Test
    @Order(1)
    void createSubject() {
        String url=getBaseUrl()+"/create";
        ResponseEntity<String> response = restTemplate.postForEntity(url, subject, String.class);
        assertNotNull(response.getBody());
        assertEquals(subject.getSubjectCode(), response.getBody());
        System.out.println("Subject: "+response.getBody());
    }

    @Test
    @Order(2)
    void readSubject() {
        String url=getBaseUrl()+"/read"+subject.getSubjectCode();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertNotNull(response.getBody());
        assertEquals(subject.getSubjectCode(), response.getBody());
        System.out.println("Subject: "+response.getBody());


    }

    @Test
    @Order(3)
    void updateSubject() {
        Subject updatedSubject=new Subject.SubjectBuilder()
                .copy(subject)
                .setSubjectCode("ADP3")
                .build();

        String url=getBaseUrl()+"/update";
        ResponseEntity<Subject> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedSubject), Subject.class);
        assertNotNull(response.getBody());
        assertEquals(subject.getSubjectCode(), response.getBody());
        System.out.println("Updated Subject: "+response.getBody());



    }

    @Test
    @Order(4)
    void deleteSubject() {
        String url=getBaseUrl()+"/delete"+subject.getSubjectCode();
        restTemplate.delete(url);
        ResponseEntity<String> response = restTemplate.getForEntity(getBaseUrl()+"/read"+subject.getSubjectCode(), String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Delete_Subject:Status "+response.getStatusCode());
    }
}