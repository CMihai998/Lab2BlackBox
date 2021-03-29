package ro.ubb.racheta;

import ro.ubb.racheta.domain.Student;
import ro.ubb.racheta.repository.StudentFileRepository;
import ro.ubb.racheta.repository.StudentXMLRepo;
import ro.ubb.racheta.service.Service;
import ro.ubb.racheta.validation.StudentValidator;

public class TestBuilder {
    //student
    public static String DEFAULT_ID = "420";
    public static String DEFAULT_NAME = "nume";
    public static Integer DEFAULT_GROUP = 932;
    public static String DEFAULT_EMAIL = "racheta@as_manca_o_ciorba.gov";
    public static String EMPTY_STRING = "";
    public static String NULL_STRING = null;

    //files
    public static String DEFAULT_STUDENT_XML_FILE = "testData/testStudentXMLFile.xml";
    public static String DEFAULT_STUDENT_FILE = "testData/testStudentFile.txt";

    public Student getStudent() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithEmptyId() {
        return new Student(EMPTY_STRING, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithNullId() {
        return new Student(NULL_STRING, DEFAULT_NAME, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithNegativeGroup() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, -1, DEFAULT_EMAIL);
    }

    public Student getStudentWithEmptyName() {
        return new Student(DEFAULT_ID, EMPTY_STRING, DEFAULT_GROUP, DEFAULT_EMAIL);
    }
    public Student getStudentWithNullName() {
        return new Student(DEFAULT_ID, NULL_STRING, DEFAULT_GROUP, DEFAULT_EMAIL);
    }

    public Student getStudentWithEmptyEmail() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, DEFAULT_GROUP, EMPTY_STRING);
    }
    public Student getStudentWithNullEmail() {
        return new Student(DEFAULT_ID, DEFAULT_NAME, DEFAULT_GROUP, NULL_STRING);
    }

    public StudentValidator getStudentValidator() {
        return new StudentValidator();
    }

    public StudentXMLRepo getStudentXMLRepo() {
        return new StudentXMLRepo(DEFAULT_STUDENT_XML_FILE);
    }

    public StudentFileRepository getStudentFileRepo() {
        return new StudentFileRepository(DEFAULT_STUDENT_FILE);
    }

    public Service getService() {
        return new Service(getStudentXMLRepo(), getStudentValidator(), null,null,null,null);
    }
}
