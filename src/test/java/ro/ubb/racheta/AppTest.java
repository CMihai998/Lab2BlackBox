package ro.ubb.racheta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ubb.racheta.domain.Student;
import ro.ubb.racheta.service.Service;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertTrue;

public class AppTest {
    TestBuilder testBuilder;
    Service service;

    @Before
    public void before() {
        testBuilder = new TestBuilder();
        service = testBuilder.getService();
    }

    @Test
    public void test1() {
        Student student = testBuilder.getStudent();

        service.addStudent(student);

        assertTrue(service.findStudent(student.getID()).getID()
                .equals(student.getID()));
    }

    @Test
    public void test2() {
        Student student = testBuilder.getStudent();
        Student studentClone = testBuilder.getStudent();

        service.addStudent(student);
        service.addStudent(studentClone);

        assertTrue(getStudentsCount().equals(1));
    }

    @Test
    public void test3() {
        testStudentWithNullId();
        testStudentWithEmptyId();
        testStudentWithNullName();
        testStudentWithEmptyName();
        testStudentWithNullEmail();
        testStudentWithEmptyEmail();
        testStudentWithNegativeGroup();
    }

    private void testStudentWithNullId() {
        try {
            service.addStudent(testBuilder.getStudentWithNullId());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    private void testStudentWithEmptyId() {
        try {
            service.addStudent(testBuilder.getStudentWithEmptyId());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    private void testStudentWithNullName() {
        try {
            service.addStudent(testBuilder.getStudentWithNullName());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    private void testStudentWithEmptyName() {
        try {
            service.addStudent(testBuilder.getStudentWithEmptyName());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    private void testStudentWithNullEmail() {
        try {
            service.addStudent(testBuilder.getStudentWithNullEmail());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    private void testStudentWithEmptyEmail() {
        try {
            service.addStudent(testBuilder.getStudentWithEmptyEmail());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    private void testStudentWithNegativeGroup() {
        try {
            service.addStudent(testBuilder.getStudentWithNegativeGroup());
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }


    @After
    public void afterTest(){
        service.deleteStudent(testBuilder.DEFAULT_STUDENT_ID);
    }

    private Integer getStudentsCount() {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        service.getAllStudenti().forEach(stud -> {
            count.getAndSet(count.get() + 1);
        });

        return count.get();
    }
}
