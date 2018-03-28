// Cole Petty
//APCS
//solving a maze, working with recursion

public class Maze
{
  public static int ROWS = 10;
  public static int COLUMNS = 25;
    
  private final char TRIED = 'T';
  private final char PATH = '7';
  public static double PercentOfSuccessfulMovement = 50;
  // 1 == clear, 0 == blocked
  public static char[][] grid = new char[ROWS][COLUMNS];
    /*
  {
    {1,1,1,0,1,1,0,0,0,1,1,1,1},//1
    {1,0,1,1,1,0,1,1,1,1,0,0,1},//2
    {0,0,0,0,1,0,1,0,1,0,1,0,0},//3
    {1,1,1,0,1,1,1,0,1,0,1,1,1},//4
    {1,0,1,0,0,0,0,1,1,1,0,0,1},//5
    {1,0,1,1,1,1,1,1,0,1,1,1,1},//6
    {1,1,1,1,1,1,1,1,1,1,1,1,1}//7
  };
  
{
{ ' ', ' ', ' ', '|', ' ', ' ', '|', '|', '|', '|', ' ', ' ', ' '},//1
{ ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', '|', ' '},//2
{ '|', '|', '|', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', '|'},//3
{ ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' ', ' ', ' '},//4
{ ' ', '|', ' ', '|', '|', '|', '|', ' ', ' ', ' ', '|', '|', ' '},//5
{ ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' '},//6
{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}//7
}; */
  //create a tecursive method to solve the maze
  //insert charcters for locations " tried" and "path"
  public boolean traverse(int row, int column)
  {
    boolean done = false;
      if(valid(row, column))
      {
        grid[row][column] = TRIED;
        
        if(row == grid.length-1 && column == grid[0].length-1)
        {
          done = true; //reached teh end of the maze 
        }
        else
          {
            done = traverse(row + 1, column); // down
            if(!done)
            {
              done = traverse(row, column + 1); // right
            }
            if(!done)
            {
              done = traverse(row-1, column); // up
            }
            if(!done)
            {
              done = traverse(row, column-1); // left
            }
          }
          /*if(done)
          {
            //grid[row][column] = PATH;
          }*/
        }
            if(done)
          {
            grid[row][column] = PATH;
          }
      return done;
      }
  
  //helper method to check whether a location is valid
  private boolean valid(int row, int col)
  {
    boolean result = false;
    //check if cell is int the bound of the matrix
    if(row >= 0 && row < grid.length && col >=0 && col < grid[row].length)
    {
      if(grid[row][col] == '1' || grid[row][col] == ' ' )
        result = true;
    }
    return result;
  }
  
  public String toString()
  {
    String result = "";
    for(char[] intRow: grid)
    {
      for(char there: intRow)
      {
        result += "" + there + ' ';
      }
      result += "\n";
    }
    return result;
  }
  
  public static void RandomizeTheMaze()
  {   //13x7
    for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[i].length; j++) {
      int temp1 = (int)(Math.random()*100);
      if(temp1 <=PercentOfSuccessfulMovement)
      {grid[i][j] = ' ';}
      else//(temp1 == 1)
      {grid[i][j] = '|';}
      grid[0][0] = ' ';
      grid[grid.length-1][grid[i].length-1] = ' ';
    }
}
}
  public static void setROWS(double n)
  {
    ROWS = (int)(n);
  }
  
  public static void setCOLUMNS(double n)
  {
    COLUMNS = (int)(n);
  }
}









