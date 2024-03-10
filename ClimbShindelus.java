/*
Date:11/14/2022
name: Rachel Shindelus
description: This program allows for a user to input the desired height of a mountain in which a person is to climb.
   This person is given a 50-50 chance of progressing forward or falling backwards in their attempt to reach the top.
   The program records the number of slips the person had on their way up to the top of the mountain as well as displays
   each of the iterations that has occured to show their progression. 
self grade: I beleive I should receive 100% for this assignment as I have completed all the required objectives and have
   created a properly running program. 

*/
import java.util.*;
public class ClimbShindelus  { /* No Code Given */ }
class RockClimb   {
   public static void main(String [] args)   {
      Scanner kb = new Scanner(System.in);         // Creates scanner object kb
      Random rand = new Random();                  // Creates random object rand
      description();
      execute(rand, kb);
   }
  /*this method calls the other methods to run the program. This method uses a while loop so that the program can run many times.*/
   public static void execute(Random rand, Scanner kb)   {
    boolean repeat = true;
    while (repeat) {
      int height = input(kb);                  // Stores return variable from input method as height. Also, runs input method
      int slipCount = climb(height, rand);     // Stores variable from climb method as slipCount. Also runs climb method
      System.out.println("While climbing up the mountain with the height " + height + ", you slipped down " + slipCount + " times.");    // display the number of the slips and height of mountain
    System.out.print("Another Run? ");         // ask the user if they want to run the program again
    String yesNo = kb.next();
    if (yesNo.equalsIgnoreCase("no"))     //if the user says “no” then repeat = false; 
      repeat = false;
     } 
      System.out.println("Good Bye");    
   }
  
  /* 
  This method asks the height of the mountain that a person will climb
  Data validation must be done to ensure that the highet is a positive integer
  while loop and do- while loop must be used.   
  */
   public static int input(Scanner kb)   {
      int height = 0;
     do {
         System.out.print("What is the height of the mountain: ");
         while(!kb.hasNextInt())   {   // As long as the user is not entering an integer it should keep prompting the user
            System.out.print("What is the height of the mountain: ");
            kb.next();
         }
         height = kb.nextInt();
      }   while (height < 0);
      return height;
   }
   
   /*This method gets the height of the mountain and a Random object as its parameters.   Do-while must be used
   Declare variables distance and slip before the do-while loop and set them to 0 
   */
   public static int climb(int h, Random rand)   {
      int steps = 0;
      int height = h;
      int distance = 0;
      int numOfSlips = 0;
      do   {
         int randomNumGen = 0;
         randomNumGen = rand.nextInt(2);                 // Generate a random number of 0 or 1
         if (randomNumGen == 1)  {                       // If random number was 1
            steps = rand.nextInt(11) + 20;               // Generate a random number between 20 and 30
            if (steps > height - distance)               // If the number of steps is greater than the distance to the top of the mountain
              steps = height - distance;                 // Make the steps the remaining distance to the top
            distance += steps;                           // Add steps to the distance variable
            System.out.println("You climbed up " + steps + " step(s) ");  // Display a message indicating the number of the steps that the person moved up 
         }
         else  {                                         // If random number was 0
            int fall = 0;
            fall = rand.nextInt(5) + 1;                  // Generate a random number between 1 and 5 indicating the number of the steps the person will slip down.
            if (fall > distance)
               fall = distance;
            distance -= fall;                            // Decrement the distance variable by the number of the steps the person slipped down
            System.out.println("Sorry, you slipped down " + fall + " step(s) ");     // Display a message indicating the number of the steps the person slipped. 
            numOfSlips++;                                // Increment the number of slips
            }  // end if
      } while (height > distance); //end of do-while 
      return numOfSlips;                                 // Return the number of slips
   }
   /*Displays the information about the program such as the number of steps moving up, number of the steps 
   slipping:
     */
   public static void description()   {   //displays a description of the program.
      System.out.println("This program simulates a person trying to climb up a mountain. "
                       + "\nBegining at the ground level of 0, the person may climb up the "
                       + "\nmountain any amount of steps between 20 and 30. However, the "
                       + "\nperson may also fall an amount of steps between 1 and 5 within " 
                       + "\neach iteration as well. There is a 50-50 chance of either "
                       + "\nmoving up oor slipping down during each iteration. The round "
                       + "\nends when the person reaches the top of the mountain (height "
                       + "\ndetermined by the users input).");
      System.out.println("      //\\\\\n"
                       + "     //  \\\\                //\\\\\n"
                       + "    //\\/\\/\\\\    //\\\\      //  \\\\\n"
                       + "   //      \\\\  //  \\\\    //\\/\\/\\\\\n"
                       + "  //        \\\\//\\/\\/\\\\  //      \\\\\n"
                       + " //          \\\\      \\\\//        \\\\\n"
                       + "//            \\\\      //          \\\\");
   }
}