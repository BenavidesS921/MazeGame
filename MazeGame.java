import java.io.*;
public class MazeGame 
{
  public static void main(String[] args)
  {
    //read maze.dat file
    try{ 
        BufferedReader br = new BufferedReader(new FileReader("maze.dat"));
        while(true)
          {
            String[] block = new String[20];
            //read 20 lines
            int counter = 0;
            while(counter < 20)
              {
                String line = br.readLine();
                if(line == null)
                {
                  return;
                }
                if(line.isEmpty())
                {
                  continue;
                }
                block[counter++] = line;
              }
            Maze m = new Maze(block); //creates maze object
            System.out.println(m.printBlock()); //prints maze
            System.out.println(m.toString(0,0)); //prints Maze:YES or Maze:NO
            System.out.println();
          }
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}
