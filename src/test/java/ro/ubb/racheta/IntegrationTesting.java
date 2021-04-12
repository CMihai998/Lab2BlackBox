package ro.ubb.racheta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ubb.racheta.domain.Nota;
import ro.ubb.racheta.domain.Student;
import ro.ubb.racheta.domain.Tema;
import ro.ubb.racheta.service.Service;

import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;

public class IntegrationTesting {
    TestBuilder testBuilder;
    Service service;

    @Before
    public void before() {
        testBuilder = new TestBuilder();
        service = testBuilder.getService();
    }

    @Test
    public void addStudent() {
        Student student = testBuilder.getStudent();

        service.addStudent(student);

        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));
    }

    @Test
    public void addAssignment() {

        Tema tema = testBuilder.getTema();

        service.addTema(tema);

        assertTrue(service.findTema(tema.getID()).getID()
                .equals(tema.getID()));
    }

    @Test
    public void addNota() {
        Nota nota = testBuilder.getNota();

        try {
            service.addNota(nota, TestBuilder.DEFAULT_FEEDBACK);
        } catch (Exception exception) {
            assertTrue(StreamSupport.stream(service.getAllNote().spliterator(), false)
                    .count() == 0);
        }
    }


    @Test
    public void testIntegration() {
        Student student = testBuilder.getStudent();
        Tema tema = testBuilder.getTema();
        Nota nota = testBuilder.getNota();

        service.addStudent(student);
        service.addTema(tema);
        service.addNota(nota, TestBuilder.DEFAULT_FEEDBACK);

        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));
        assertTrue(service.findTema(tema.getID()).getID()
                .equals(tema.getID()));
        assertTrue(StreamSupport.stream(service.getAllNote().spliterator(), false)
                .count() == 1);
    }

    @After
    public void afterTest(){
        service.deleteNota(TestBuilder.DEFAULT_NOTA_ID);
        service.deleteStudent(testBuilder.DEFAULT_STUDENT_ID);
        service.deleteTema(TestBuilder.DEFAULT_TEMA_ID);
    }
}
