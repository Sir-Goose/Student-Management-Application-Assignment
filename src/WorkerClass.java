import java.util.ArrayList;
/*
 * This is the worker class. It contains the control flow and logic of the program. It is
 * responsible for displaying the welcome and main menus. It then handles the logic of the main menu
 * by calling the appropriate methods from the StudentClass and UserInterfaceClass classes. It also
 * contains the ArrayList of StudentClass objects.
 */
public class WorkerClass
{

  private final UserInterfaceClass Ui = new UserInterfaceClass(); // used to call methods from the
                                                                  // UserInterfaceClass class.
  private final StudentClass Student = new StudentClass(); // used to call methods from the
                                                           // StudentClass class.
  private final ArrayList<StudentClass> Students = new ArrayList<>(); // stores all students
                                                                      // created by the user.


  WorkerClass()
  {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the start() method. It is called from the main method in Main.java. It is responsible
   * for displaying the welcome menu and calling the mainMenu() method from the UserInterfaceClass
   * class. It also calls the appropriate methods from the StudentClass class based on the user's
   * selection.
   */
  public void start()
  {
    int selection; // stores the user's selection from the main menu.

    if (Ui.welcome()) // if the user chooses to login, the main menu is displayed.
    {
      // do-while loop to keep displaying the main menu until the user chooses to exit.
      do
      {
        selection = Ui.mainMenu(); // calls the mainMenu() method from the UserInterfaceClass class
                                   // and stores the user's selection.
        switch (selection)
        {
          // if the user chooses to create a new student, the createStudent() method from the
          // StudentClass class is called.
          case 1 ->
          {
            StudentClass newStudent = Student.createStudent();
            Student.saveStudent(Students, newStudent);
          }
          // if the user chooses to search for a student, the searchStudent() method from the
          // StudentClass class is called.
          case 2 ->
          {
            String search = Ui.displayStudentSearchMenu();
            Student.searchStudent(Students, search);
          }
          // if the user chooses to delete a student, the deleteStudent() method from the
          // StudentClass class is called.
          case 3 ->
          {
            String search = Ui.displayStudentDeleteMenu();
            if (Student.preDeleteChecker(Students, search))
            {
              Student.deleteStudent(Students, search);
            }
          }
          // if the user chooses to print a student report, the studentReport() method from the
          // StudentClass class is called.
          case 4 -> Student.studentReport(Students);
          case 5 -> Student.exitStudentApplication(); // if the user chooses to exit, the
                                                     // exitStudentApplication() method from the
                                                     // StudentClass class is called.
          default -> System.out.println("Invalid selection. Please try again.");
        }
      }
      while (selection != 5); // Exit loop when user chooses to exit
    }
    Student.exitStudentApplication(); // if the user chooses not to login, the
                                      // exitStudentApplication() method from the StudentClass
                                      // class is called.
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//