import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StudentClassTest {

  StudentClass student;
  StudentClass student2;

  @BeforeEach
  void setUp() {
    student = new StudentClass();
    student2 = new StudentClass();
  }

  @Test
  void testSaveStudent() {
    ArrayList<StudentClass> Students = new ArrayList<>();

    String expectedOutput =
        """
            STUDENT ID: ID01
            STUDENT NAME: John Doe
            STUDENT AGE: 20
            STUDENT EMAIL: example@gmail.com
            STUDENT COURSE: Computer Science
            """;

    student.setID("ID01");
    student.setName("John Doe");
    student.setAge("20");
    student.setEmail("example@gmail.com");
    student.setCourse("Computer Science");

    String actualOutput = student.saveStudent(Students, student);

    Assertions.assertEquals(expectedOutput, actualOutput);
  }

  @Test
  void testSearchStudent() {

    ArrayList<StudentClass> Students = new ArrayList<>();

    student.setID("ID01");
    student2.setID("ID02");

    Students.add(student);
    Students.add(student2);

    StudentClass actualOutput = student.searchStudent(Students, "ID02");

    Assertions.assertEquals(student2, actualOutput);
  }

  @Test
  void testSearchStudent_StudentNotFound() {
    ArrayList<StudentClass> Students = new ArrayList<>();

    student.setID("ID01");
    student2.setID("ID02");

    Students.add(student);
    Students.add(student2);

    StudentClass actualOutput = student.searchStudent(Students, "ID03");

    Assertions.assertNull(actualOutput);
  }

  @Test
  void testDeleteStudent() {
    ArrayList<StudentClass> Students = new ArrayList<>();

    student.setID("ID01");
    student2.setID("ID02");

    Students.add(student);
    Students.add(student2);

    StudentClass actualOutput = student.deleteStudent(Students, "ID02");

    Assertions.assertEquals(student2, actualOutput);
  }

  @Test
  void testDeleteStudent_StudentNotFound() {
    StudentClass student = new StudentClass();
    StudentClass student2 = new StudentClass();
    ArrayList<StudentClass> Students = new ArrayList<>();

    student.setID("ID01");
    student2.setID("ID02");

    Students.add(student);
    Students.add(student2);

    StudentClass actualOutput = student.deleteStudent(Students, "ID03");

    Assertions.assertNull(actualOutput);
  }

  @Test
  void testStudentValid() {
    InputValidationClass mockValidator = new InputValidationClass();
    Assertions.assertTrue(mockValidator.validateStudentAge("20"));
  }

  @Test
  void testStudentAgeInvalid() {
    InputValidationClass mockValidator = new InputValidationClass();
    Assertions.assertFalse(mockValidator.validateStudentAge("12"));
    Assertions.assertFalse(mockValidator.validateStudentAge("121"));
    Assertions.assertFalse(mockValidator.validateStudentAge("0"));
    Assertions.assertFalse(mockValidator.validateStudentAge("-1"));
    Assertions.assertFalse(mockValidator.validateStudentAge("20.5"));
  }

  @Test
  void testStudentAgeInvalidCharacter() {
    InputValidationClass mockValidator = new InputValidationClass();
    Assertions.assertFalse(mockValidator.validateStudentAge("a"));
    Assertions.assertFalse(mockValidator.validateStudentAge("*"));
    Assertions.assertFalse(mockValidator.validateStudentAge("/"));
    Assertions.assertFalse(mockValidator.validateStudentAge("+"));
  }
}
