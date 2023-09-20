public class InputValidationClass
{
  /*
   * This is the InputValidation class. It is used to validate input from the user primarily in the
   * creation of a new student. It enhances program stability by ensuring that the user enters valid
   * input. It also enhances the user experience by providing feedback to the user if the input is
   * invalid. It is also used to validate input from the user in the main menu.
   */

  public InputValidationClass()
  {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input entered by the user in the main menu. It ensures that
   * the user enters a number between 1 and 5. It returns true if the input is valid and false if
   * the input is invalid.
   */
  public boolean validateMainMenuInput(String input)
  {
    // try-catch block to catch a NumberFormatException if the user enters a non-numeric value.
    try
    {
      int selection = Integer.parseInt(input); // stores the user's selection.
      if (selection >= 1 && selection <= 5) // if the user's selection is between 1 and 5, the
                                            // selection is valid.
      {
        return true;
      }
    }
    catch (NumberFormatException e)
    {
    }
    System.out.println("Invalid selection. Please try again.");
    return false; // if the user's selection is not between 1 and 5, the selection is invalid.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input entered by the user in the student search menu. It
   * ensures that the user entered a non-null value. It returns true if the input is valid
   * and false if the input is invalid.
   */
  public boolean validateStudentID(String input)
  {
    if (input.isEmpty()) // if the user's input is empty, the input is invalid.
    {
      System.out.println("Invalid student ID. Please try again.");
      return false;
    }
    else
    {
      return true;
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the name entered by the user in the creation of a new student.
   * It ensures that the user enters a name between 3 and 50 characters in length. It returns true
   * if the input is valid and false if the input is invalid.
   */
  public boolean validateStudentName(String input)
  {
    if (input.length() < 3 || input.length() > 50) // if the user's input is less than 3 or greater
                                                   // than 50 characters in length, the input is
                                                   // invalid.
    {
      System.out.println("Invalid student name. Please try again.");
      return false;
    }
    else
    {
      return true;
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the age entered by the user in the creation of a new student.
   * It ensures that the user enters an age between 16 and 99. It returns true if the input is valid
   * and false if the input is invalid.
   */
  public boolean validateStudentAge(String input)
  {
    // try-catch block to catch a NumberFormatException if the user enters a non-numeric value.
    try
    {
      int age = Integer.parseInt(input); // stores the user's input.
      if (age >= 16 && age <= 99)
      {
        return true;
      }
    }
    catch (NumberFormatException e) // if the user's input is not a number, the input is
                                    // invalid.
    {
    }
    System.out.println("Invalid student age. Please try again.");
    return false;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the email entered by the user in the creation of a new student.
   * It ensures that the user enters an email between 8 and 320 characters in length and that the
   * email contains an @ and a . It returns true if the input is valid and false if the input is
   * invalid.
   */
  public boolean validateStudentEmail(String input)
  {
    if (input.contains("@") &&
        input.contains(".") &&
        input.length() >= 8 &&
        input.length() <= 320) // maximum length of an email address is 320 characters.
    {
      return true;
    }

    System.out.println("Invalid student email. Please try again.");
    return false;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the course entered by the user in the creation of a new
   * student. It ensures that the user enters a course between 3 and 50 characters in length. It
   * returns true if the input is valid and false if the input is invalid.
   */
  public boolean validateStudentCourse(String input)
  {
    if (input.length() >= 3 && input.length() <= 50)
    {
      return true;
    }

    System.out.println("Invalid student course. Please try again.");
    return false;
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//
