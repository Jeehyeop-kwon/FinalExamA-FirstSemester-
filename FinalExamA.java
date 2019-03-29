package all_code;

//Put your name and today's date under @author and @version
/**
* This program creates and populates a 2D array of integers. It then finds the product of all the numbers
* in each column. Finally it displays the numbers in the array and the column products
*
* @author Jeehyuep Kwon
* @version December 10, 2018
*/
import java.util.*;

public class FinalExamA
{
  //constants
  static final int MINIMUM_DIMENSION = 2; //the minimum value for number of rows/columns
  static final int MAXIMUM_DIMENSION = 5; //the maximum value for number of rows/columns
  //class variables - no other variables to be declared at class level
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args)
  {
      // 1. declare all local variables of correct type
	  int rows = 0;
	  int columns = 0;
	  int[][] numbers;
	  int[] columnProduct;

      //display the purpose of the program
      displayPurpose();

      //2. you need to write the code for the method getDimension() where it says in code below
      //call method to get the number of rows in the 2D array
      rows = getDimension("rows");
      
      //call the same method to get the number of columns in the 2D array
      columns = getDimension("columns");
      
      numbers = new int [rows][columns];
      //3. call the method populateWithNumbers(already coded below)to populate the 2D array with numbers
      populateWithNumbers(numbers, rows, columns);

      //4. you need to write the code and complete the JavaDoc comments for the method findColumnProducts
      //where it says in code below; all communication with the method is via parameters and return statement
      
      //5. call the method findColumnProducts to get the product of all numbers in each column
      columnProduct = findColumnProducts(numbers, rows, columns);
      
      //6a - modify the displayOutput method(already coded below)
      //currently it just displays the numbers in the 2D array, additionally display the product below each column
      //6b - modify the JavaDoc comments of the method for description and new parameter - correct, complete and clear
      //6c - modify the call to displayOutput method now
      displayOutput(columnProduct, numbers, rows, columns);

  }//of main
  /**
   * This method displays the purpose of the program
   *
   */
  private static void displayPurpose()
  {

      System.out.println("*************************************************************************************");
      System.out.println("This program creates a 2D numeric array of a ceratin size-number of rows and columns");
      System.out.println("provided by the user; displays the numbers and the product of numbers in each column" );
      System.out.println("*************************************************************************************");

  }
  /**
   * This method getDimension prompts the user for a number MINIMUM_DIMENSION through MAXIMUM_DIMENSION, inclusive
   * and returns this number
   * @param dimension to specify the dimension (rows or columns)
   * @return the number entered by the user
   *
   */
  //code solution 2 here
  //no magic numbers in the code.
  //Prompt and error messages should be grammatically correct, clear and complete, showing valid values
  //and dimension(rows or columns)expected of the user
  //Hint: use the parameter to prompt with 'rows' or 'columns' in the messages
  public static int getDimension(String rowsOrColumns) {
	  
	  int numberFromUser = 0;
	  
	  do {
	  
    	  System.out.printf("Please, input the number of %s you want to store ( 2 <= length <= 5)  : ", rowsOrColumns);
    	  numberFromUser = input.nextInt();
    	  
    	  if(numberFromUser < MINIMUM_DIMENSION || numberFromUser > MAXIMUM_DIMENSION) {
    		  System.out.println("Invalid number!! Try again!!");
    	  }
	  } while(numberFromUser < MINIMUM_DIMENSION || numberFromUser > MAXIMUM_DIMENSION);
	  
	  return numberFromUser;
	  
  }

  /**
   * This method takes numbers from the user and populates the 2D array with numbers
   *
   * @param numbers the 2D array to be populated with numbers
   * @param rows the number of rows in the array
   * @param columns the number of columns in the array
   *
   */
  private static void populateWithNumbers(int[][] numbers, int rows , int columns)
  {
      System.out.printf("Enter %d numbers to create the 2D array with %d rows and %d columns%n", rows*columns, rows, columns);
      // for each row
      for(int i = 0; i < rows; i++)
      {
          // prompt the user for  numbers
          for(int j = 0; j < columns; j++){
              System.out.printf("Enter number at [%d][%d]: %n",i,j);
              numbers[i][j] = input.nextInt();
          }//for columns
      }//for rows

  }//populateWithNumbers

  /**
   * This method finds the product of the all numbers in each column and return all column products
   * 
   * @param numbers the 2D array to be populated with numbers
   * @param rows the number of rows in the array
   * @param columns the number of columns in the array
   * @return columnProducts the multiplication of each column
   * 
   */
  //code solution 4 here - should be an independent method that communicates with the
  //calling method via parameters and returns the result
  //complete the JavaDoc comments specifying the parameters and return value
  //Hint: Save all the column products in a data structure and return it
  
  public static int[] findColumnProducts(int[][] numbers, int rows, int columns){
	  
	  int[] columnProducts = new int[MAXIMUM_DIMENSION];
	  int multiplication = 1;
	  int count = 0;
	  
		  for(int i = 0; i < columns; i++) {
			  multiplication = 1;
				for(int j = 0; j < rows; j++) {
					
					multiplication *= numbers[j][i];
					
				}
				columnProducts[count++] = multiplication;
			}
	  
	  
	  return columnProducts;
  }

  /**
   * This method displays the numbers in the 2D array and the multiplication of each column
   * @param columnProducts the multiplication of each column
   * @param numbers the two dimensional array containing the numbers
   * @param rows the number of rows in the array
   * @param columns the number of columns in the array
   */

  private static void displayOutput(int[] columnProduct, int[][] numbers, int rows, int columns)
  {
      System.out.println("-----------------Numbers and Column Products-------------------------");
      //for each row
      for(int i=0; i <rows; i++)
      {
          //display all elements in the row
          for(int j=0; j < columns ; j++)
          {
              System.out.printf("%6d     ",numbers[i][j]);
          }//for j

          //start display of new row on different line
          System.out.println();
      }//for i
      System.out.println("--------------------------------------------------------------------");
      
      for(int i = 0; i < columns; i++) {
    	  System.out.printf("%6d     ",columnProduct[i]);
      }
   

  }//displayOutput
}//class