

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
//import java.awt.Toolkit;

/**
 * A class that provides methods for creating a byte array
 * for the maze from a picture file
 * 
 */
public class MazeFromImage
{
  //public BufferedImage buffImage;
  //possible idea: GUI or command line tool for creating and saving a maze to load
 // public static final byte W = 1,O = 0;
  /**
   * Attempts to load a picture from the file at the specified path
   * 
   * @param path the path of the picture file
   * 
   * @return a BufferedImage from the specified file
   */
  public static BufferedImage loadPicture(String path) throws IOException
  {
    BufferedImage returnImage = ImageIO.read(new File(path));
    return returnImage;
  }
  //Color a = new Color(buffImage.getRGB(int x, int y))
  //a.getRed(),a.getBlue(),a.getGreen();
  /**
   * 
   */
  public static byte[] mazeFromImage(String path, byte param1, byte param2) throws IOException
  {
    BufferedImage buffImage = loadPicture(path);
    Color c = null;
    byte[] maze = new byte[2500];
    int loc = 0;
    for(int y = 0; y < 50; y++)
    {
      for(int x = 0; x < 50; x++)
      {
        c = new Color(buffImage.getRGB(x,y));
        if(c.getRed() == 255 && c.getBlue() == 255 && c.getGreen() == 255)
        {
          maze[loc] = param1;
        }
        else
        {
          maze[loc] = param2;
        }
        loc++;
      }
    }
    return maze;
  }
  
  /**
   * 
   */
  public static byte[] mazeFromImage(BufferedImage img,  byte param1, byte param2)
  {
    Color c = null;
    byte[] maze = new byte[2500];
    int loc = 0;
    for(int y = 0; y < 50; y++)
    {
      for(int x = 0; x < 50; x++)
      {
        c = new Color(img.getRGB(x,y));
        if(c.getRed() == 255 && c.getBlue() == 255 && c.getGreen() == 255)
        {
          maze[loc] = param1;
        }
        else
        {
          maze[loc] = param2;
        }
        loc++;
      }
    }
    return maze;
  }
  
}
