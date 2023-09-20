import java.util.Scanner;

public class UserInterfaceClass
{
  /*
   * This is the user interface class. It is responsible for every interaction with the user. Every
   * user facing output is contained here in order to achieve complete separation of the user
   * interface and the business logic. This helps to make the program more maintainable and
   * easier to test. It uses the InputValidationClass to validate the input entered by the user.
   */
  private final Scanner Scanner = new Scanner(System.in); // used to get user input.
  private final InputValidationClass InputValidation = new InputValidationClass(); // used to
                                                                                   // validate user
                                                                                   // input.

  public UserInterfaceClass()
  {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//
  /* This method is used to display the welcome menu. */
  public boolean welcome()
  {
    System.out.println("""
        STUDENT MANAGEMENT APPLICATION
        --------------------------------------------------------------------------------------------
        Enter (1) to launch menu or any other key to exit:\s""");
    return Scanner.nextLine().equals("1"); // returns true if the user chooses to login.
  }
  //----------------------------------------------------------------------------------------------//
  /* This method is used to display the main menu.
   * It uses a do-while loop to keep displaying the main menu until the user chooses to exit.
   */
  public int mainMenu()
  {
    do
    { // displays the main menu using a text block.
      System.out.println("""
          ------------------------------------------------------------------------------------------
          Please select one of the following menu items:
          (1) Capture a new student.
          (2) Search for a student.
          (3) Delete a student.
          (4) Print student report.
          (5) Exit Application.
          Enter your selection:
          """);

      String input = Scanner.nextLine();

      if (InputValidation.validateMainMenuInput(input)) // validates the user's selection.
      {
        return Integer.parseInt(input);
      }
    }
    while (true); // loop until user enters a valid selection.
  }
  //----------------------------------------------------------------------------------------------//
  /* This method is used to display the heading when a user choose to capture student details */
  public void displayCaptureStudentMenu()
  {
    System.out.println("""
        --------------------------------------------------------------------------------------------
        CAPTURE STUDENT DETAILS
        """);
  }
  //----------------------------------------------------------------------------------------------//
  /* This method is used to get the studentID from a user as part of the student creation process.
   * It uses a do-while loop to keep asking for a studentID until a valid studentID is entered.
   */
  public String captureStudentID()
  {
    do {
      System.out.println("-------------------------------------------------------------------------"
          + "-------------------\n" + "Enter student ID:");
      String input = Scanner.nextLine(); // stores the studentID entered by the user.
      if (InputValidation.validateStudentID(input)) // validates the studentID.
      {
        return input;
      }
    }
    while (true); // loop until user enters a valid studentID.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to get the student name from a user as part of the student creation process.
   * It uses a do-while loop to keep asking for a student name until a valid student name is
   * entered.
   */
  public String captureStudentName()
  {
    do {
      System.out.println("Enter student name:");
      String input = Scanner.nextLine(); // stores the student name entered by the user.
      if (InputValidation.validateStudentName(input)) // validates the student name.
      {
        return input;
      }
    }
    while (true); // loop until user enters a valid student name.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to get the student age from a user as part of the student creation process.
   * It uses a do-while loop to keep asking for a student age until a valid student age is entered.
   */
  public String captureStudentAge()
  {
    do
    {
      System.out.println("Enter student age:");
      String input = Scanner.nextLine(); // stores the student age entered by the user.
      if (InputValidation.validateStudentAge(input)) // validates the student age.
      {
        return input;
      }
    }
    while (true); // loop until user enters a valid student age.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to get the student email from a user as part of the student creation
   * process. It uses a do-while loop to keep asking for a student email until a valid student email
   * is entered.
   */
  public String captureStudentEmail()
  {
    do
    {
      System.out.println("Enter student email:");
      String input = Scanner.nextLine(); // stores the student email entered by the user.
      if (InputValidation.validateStudentEmail(input)) // validates the student email.
      {
        return input;
      }
    }
    while (true); // loop until user enters a valid student email.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to get the student course from a user as part of the student creation
   * process. It uses a do-while loop to keep asking for a student course until a valid student
   * course is entered.
   */
  public String captureStudentCourse()
  {
    do
    {
      System.out.println("Enter student course:");
      String input = Scanner.nextLine(); // stores the student course entered by the user.
      if (InputValidation.validateStudentCourse(input)) // validates the student course.
      {
        return input;
      }
    }
    while (true); // loop until user enters a valid student course.
  }
  //----------------------------------------------------------------------------------------------//
  /* Provides feedback to the user when a new student has been saved */
  public void displayStudentSavedMsg()
  {
    System.out.println("Student saved successfully.");
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to display the heading when a user choose to search for a student.
   * It also takes in the studentID entered by the user and returns it.
   */
  public String displayStudentSearchMenu()
  {
    printDivider();
    System.out.println("Enter student ID to search: ");
    return Scanner.nextLine(); // returns the studentID entered by the user.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * Informs the user that the student with the specified studentID was not found. This method is
   * used by other methods whenever a student needs to be searched for and cannot be found in the
   * list.
   */
  public void displayStudentNotFoundMsg(String search)
  {
    System.out.println("Student with ID " + search + " not found."); // displays a message to the
                                                                     // user.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method asks the user for the ID of the student they want to delete and then returns
   * the studentID entered by the user.
   */
  public String displayStudentDeleteMenu()
  {
    printDivider();
    System.out.println("Enter student ID to delete: ");
    return Scanner.nextLine(); // returns the studentID entered by the user.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to display a warning message to the user when they choose to delete a
   * student. It then returns the user's response.
   */
  public String displayStudentDeletedWarningMsg(String search)
  {
    System.out.println("Are you sure you want to delete student with ID " + search + "? (Y/N)");
    return Scanner.nextLine(); // returns the user's response.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to display a message to the user when a student has been deleted.
   * It takes in the studentID of the student that was deleted in order to make the message
   * specific to the student that was deleted.
   */
  public void displayStudentDeletedMsg(String search)
  {
    System.out.println("Student with ID " + search + " deleted successfully.");
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to display a message to the user when a student has failed to be deleted.
   * It takes in the studentID of the student that was not deleted in order to make the message
   * specific.
   */
  public void displayStudentNotDeletedMsg(String search)
  {
    System.out.println("Student with ID " + search + " not deleted.");
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used by other methods whenever a student needs to be searched for but there
   * student list is completely empty. It displays a message to the user informing them that there
   * are no students in the list.
   */
  public void displayNoStudentsFoundMsg()
  {
    System.out.println("No students found.");
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used by the studentReport() method in the StudentClass class. It is used to
   * display the details of each student in the student list. It also displays the number that
   * each student is in the list.
   */
  public void printStudent(StudentClass student, int count)
  {
    System.out.println("Student " + count + ":"); // displays the number of the student in the list.
    System.out.println(student.toString()); // displays the details of the student.
  }
  //----------------------------------------------------------------------------------------------//
  /* Displays a message informing the user that the application is about to exit */
  public void displayExitingMsg()
  {
    System.out.println("Exiting application...");
  }
  //----------------------------------------------------------------------------------------------//
  /* This method is used to display a divider between sections of the application. */
  public void printDivider()
  {
    System.out.println("---------------------------------------------------------------------------"
        + "-----------------");
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to display a message to the user when a student has been found. It takes
   * in the student object that was found and displays the details of the student.
   */
  public void displayStudentFoundMsg(StudentClass student)
  {
    System.out.println("Student found:");
    System.out.println(student.toString());
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//
