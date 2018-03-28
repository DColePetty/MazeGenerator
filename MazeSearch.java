//Cole Petty
//APCS
//Driver Class for Maze
import java.util.Scanner;
public class MazeSearch
{
  public static int WWW = 0;
  public static int WWZ = 0;
  public static void main(String[] args)
  {
    Scanner whatNow = new Scanner(System.in);
    System.out.println("Input the % chance of a space spawning as a wall");
    double first = (100 - whatNow.nextDouble());
    Maze.PercentOfSuccessfulMovement = (int)first;
    //System.out.println("Input the # of rows");
    //double second = whatNow.nextInt();
    //Maze.ROWS = (int)second;
    
    
    Maze labyrinth = new Maze();
    Maze.RandomizeTheMaze();
    if(labyrinth.traverse(0,0))
    {
      System.out.println("\nThe maze was successfully solved" + " each space in the maze has a " + (100-Maze.PercentOfSuccessfulMovement)  + "% chance to spawn a wall");
      System.out.println(labyrinth);
    }
    else
    {
      TryAgain(labyrinth);
    }
      /*
      Maze.RandomizeTheMaze();
      System.out.println("There is no possible path/solution!");
      
      System.out.println(labyrinth);
      */
  }
  
    public static void TryAgain(Maze labyrinth)
  {
      while(WWW ==0){
    if(labyrinth.traverse(0,0))
    {
      System.out.println("\nThe maze was successfully solved" + " where each space in the maze has a " + (100-Maze.PercentOfSuccessfulMovement)  + "% chance to spawn a wall");
      System.out.println(labyrinth);
      WWW++;
    }
    else
    {
      if(WWZ == 0)
      {
      Maze.RandomizeTheMaze();
      System.out.println("This iteration found no possible path... trying again!");
      WWZ++;
      }
      if(WWZ !=0 && WWZ % 10 !=0)
      {
      Maze.RandomizeTheMaze();
      System.out.print(" ... ");
      WWZ++;
      }
      if(WWZ !=0 && WWZ % 10 ==0)
      {
      Maze.RandomizeTheMaze();
      System.out.println(" ... ");
      WWZ++;
      }
    }
      
      //System.out.println(labyrinth);
  }
    }
    
}

