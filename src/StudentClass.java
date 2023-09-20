import java.util.ArrayList;

public class StudentClass
{
  /*
   * This is the student class. It contains all the methods that are used to create, search, delete
   * and display students. It also contains the getters and setters for the student's ID, name, age,
   * email, and course. It also contains an override toString() method which is used to display the
   * student information to the user.
   */
  UserInterfaceClass Ui = new UserInterfaceClass(); // used to call methods from the
                                                    // UserInterfaceClass class.
  private String ID = ""; // stores the student's ID.
  private String Name = ""; // stores the student's name.
  private int Age = 0; // stores the student's age.
  private String Email = ""; // stores the student's email.
  private String Course = ""; // stores the student's course.

  StudentClass()
  {
    // default constructor
  }

  //----------------------------------------------------------------------------------------------//

  // getters
  /* This method is used to get the student's ID. */
  public String getID()
  {
    return ID;
  }
  /* This method is used to get the student's name. */
  public String getName()
  {
    return Name;
  }
  /* This method is used to get the student's age. */
  public int getAge()
  {
    return Age;
  }
  /* This method is used to get the student's email. */
  public String getEmail()
  {
    return Email;
  }
  /* This method is used to get the student's course. */
  public String getCourse()
  {
    return Course;
  }

  // setters
  /* This method is used to set the student's ID. */
  public void setID(String ID)
  {
    this.ID = ID;
  }
  /* This method is used to set the student's name. */
  public void setName(String Name)
  {
    this.Name = Name;
  }
  /* This method is used to set the student's age. */
  public void setAge(String Age)
  {
    this.Age = Integer.parseInt(Age);
  }
  /* This method is used to set the student's email. */
  public void setEmail(String Email)
  {
    this.Email = Email;
  }
  /* This method is used to set the student's course. */
  public void setCourse(String Course)
  {
    this.Course = Course;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to display the student's ID, name, age, email, and course to the user.
   * It overrides the default object class toString() method.
   */

  @Override
  public String toString()
  {
    return
        "STUDENT ID: " + getID() + "\n" +
        "STUDENT NAME: " + getName() + "\n" +
        "STUDENT AGE: " + getAge() + "\n" +
        "STUDENT EMAIL: " + getEmail() + "\n" +
        "STUDENT COURSE: " + getCourse() + "\n";
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to save a student. It takes in an array list of students and a student
   * object. It adds the student object to the array list of students. It then returns the last
   * student in the student array as a string in order to verify that the student was saved
   * correctly.
   */
  public String saveStudent(ArrayList<StudentClass> students, StudentClass student)
  {
    students.add(student);
    return students.get(students.size() - 1).toString();  // return value is ignored except for
                                                          // testing
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to search for a student. It takes in an array list of students and a
   * string to search for. It uses a for loop to iterate through the array list of students. If
   * the student is found, it displays the student to the user and returns the student. If the
   * student is not found, it displays a message to the user and returns null.
   * In both cases the return is used to verify whether the student was found.
   */
  public StudentClass searchStudent(ArrayList<StudentClass> students, String search)
  {
    if (students.isEmpty())  // check whether the array list is empty
    {

      Ui.displayStudentNotFoundMsg(search);
      return null;
    }

    for (StudentClass student : students) // iterate through the array list of students
    {
      if (student.ID.equals(search)) // check whether the student is found
      {
        Ui.displayStudentFoundMsg(student);
        return student;
      }
    }

    Ui.displayStudentNotFoundMsg(search); // display message to user if student is not found
    return null;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to verify that a student exists before deleting it. It takes in an array
   * list of students and a string to search for. It uses a for loop to iterate through the array
   * list of students. If the student is found, it calls the confirmStudentDeletion() method to get
   * confirmation from the user. If the user confirms the deletion, it returns true. If the user
   * does not confirm the deletion, it returns false. If the student is not found, it displays a
   * message to the user and returns false.
   */
  public boolean preDeleteChecker(ArrayList<StudentClass> students, String search)
  {
    if (students.isEmpty())
    {
      Ui.displayStudentNotFoundMsg(search); // display message to user if array list is empty
      return false;
    }

    for (StudentClass student : students) // iterate through the array list of students
    {
      if (student.ID.equals(search)) // check whether the student is found
      {
        if (confirmStudentDeletion(search)) // get confirmation from the user
        {
          return true;
        } else
        {
          Ui.displayStudentNotDeletedMsg(search); // display message to user if student is not
                                                  // deleted
          return false;
        }
      }
    }

    Ui.displayStudentNotFoundMsg(search); // display message to user if student is not found
    return false;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to get confirmation from the user before deleting a student. It takes in
   * the student ID so that the confirmation message can be specific to the student being deleted.
   */
  private boolean confirmStudentDeletion(String studentId)
  {
    String userChoice = Ui.displayStudentDeletedWarningMsg(studentId);
    return userChoice.equalsIgnoreCase("Y"); // case insensitively check whether the
                                              // user entered Y or y and return true.
                                              // if not, return false.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to delete a student. It takes in an array list of students and a string
   * to search for. It uses a for loop to iterate through the array list of students until it finds
   * any student with a matching student ID. It then removes the student from the array list of
   * students and displays a message to the user. It then returns the student that was deleted.
   * If the student is not found, it returns null.
   */
  public StudentClass deleteStudent(ArrayList<StudentClass> students, String search)
  {
      for (StudentClass student : students)
      {
        if (student.ID.equals(search))
        {
            // remove the student from the array list of students
            students.remove(student);
            Ui.displayStudentDeletedMsg(search);
            return student;
        }
      }
      return null; // return null if the student is not found. Mainly used for testing.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the studentReport() method. It is called from the mainMenu() method in the
   * UserInterfaceClass class. It is responsible for displaying all the students in the array list
   * of students. It uses a for loop to iterate through the array list of students and display the
   * information about each student using the printStudent() method.
   */
  public void studentReport(ArrayList<StudentClass> students)
  {
    int count = 1; // used to keep track of the number of students displayed

    if (students.isEmpty())
    {
      Ui.displayNoStudentsFoundMsg();
    } else
    {
      for (StudentClass student : students)
      {
        // display the student information to the user
        Ui.printDivider();
        Ui.printStudent(student, count);
        Ui.printDivider();
        count++;
      }
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the exitStudentApplication() method. It is called from the mainMenu() method in the
   * UserInterfaceClass class. It is responsible for exiting the application. It displays a message
   * to the user, halts for 1 second and then exits the application.
   */
  public void exitStudentApplication()
  {
    Ui.displayExitingMsg(); // display message to user
    try
    {
      Thread.sleep(1000); // halt for 1 second
    }
    catch (InterruptedException e)
    {
      e.printStackTrace(); // print the stack trace if an error occurs
      System.exit(1);
    }
    System.exit(0); // exit the application
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the createStudent() method. It is called from the mainMenu() method in the
   * UserInterfaceClass class. It is responsible for creating a new student. It uses the
   * captureStudentID(), captureStudentName(), captureStudentAge(), captureStudentEmail(), and
   * captureStudentCourse() methods from the UserInterfaceClass class to get the student's ID,
   * name, age, email, and course from the user. It then creates a new student object and sets the
   * student's ID, name, age, email, and course using the setters. It then displays a message to
   * the user and returns the student object.
   */
  public StudentClass createStudent()
  {
    StudentClass student = new StudentClass(); // create a new student object

    Ui.displayCaptureStudentMenu();
    // set the student's ID, name, age, email, and course using the setters
    student.setID(Ui.captureStudentID());
    student.setName(Ui.captureStudentName());
    student.setAge(Ui.captureStudentAge());
    student.setEmail(Ui.captureStudentEmail());
    student.setCourse(Ui.captureStudentCourse());
    Ui.displayStudentSavedMsg();

    return student;
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//
