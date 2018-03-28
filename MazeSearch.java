//Cole Petty
//APCS
//Driver Class for Maze

public class MazeSearch
{
  public static int WWW = 0;
  public static void main(String[] args)
  {
    Maze labyrinth = new Maze();
    Maze.RandomizeTheMaze();
    if(labyrinth.traverse(0,0))
      System.out.println("The maze was successfully solved");
    else
      TryAgain(labyrinth);
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
      System.out.println("The maze was successfully solved");
      System.out.println(labyrinth);
      WWW++;
    }
    else
    {
      Maze.RandomizeTheMaze();
      System.out.println("There is no possible path/solution!");
    }
      
      //System.out.println(labyrinth);
  }
    }
    
}

