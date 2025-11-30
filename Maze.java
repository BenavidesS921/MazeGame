public class Maze
{
  //create 2D array
  private char[][] mazes = new char [20][20];
  //constructor houses array
  public Maze (String[] lines)
  {
    for(int row = 0; row < 20; row++)
      {
        for(int col = 0; col < 20; col++)
          {
            mazes[row][col] = lines[row].charAt(col);
          }
      }
  }
  //prints maze line by line on new line
  public String printBlock()
  {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 20; i++)
      {
        sb.append(new String (mazes[i]));
        sb.append("\n");
      }
    return sb.toString();
  }
  //toString method prints Maze:YES or Maze:NO
  public toString(int startRow, int startCol)
  {
    boolean [][] visited = new boolean[20][20];
    int row = startRow;
    int col = startCol;
    //find start
    for(int i = 0; i < 20; i++)
      {
        for(int j = 0; j < 20; j++)
          {
            if(mazes[i][j] == 'S')
            {
              row = i;
              col = j;
            }
          }
      }
    if(isSolvable(row, col, visited))
      {
        return "Maze: YES"; //solvable
      }
    else
    {
      return "Maze: NO"; //not solvable
    }
  }
  //boolean refering if maze is solvable
  private boolean isSolvable(int row, int col, boolean[][] visited)
  {
    //bound check
    if(row < 0 || row >=20 || col < 0 || col >=20)
    {
      return false;
    }
    //cell is wall
    if(mazes[row][col] == '#')
    {
      return false;
    }
    //cell has been visited
    if(visited[row][col])
    {
      return false;
    }
    //cell is the end
    if(mazes[row][col] == 'E')
    {
      return true;
    }
    //mark cell as visited
    visited[row][col] = true;
    //check up,down,right,left
    if(isSolvable(row -1, col, visited))
    {
      return true;
    } else if(isSolvable(row + 1, col, visited)){
      return true;
    } else if(isSolvable(row, col -1, visited)){
      return true;
    } else if(isSolvable(row, col + 1, visited)){
      return true;
    } else {
      return false;
    }
  }
}
