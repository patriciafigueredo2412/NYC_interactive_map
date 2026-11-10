
import javax.swing.*;

/**
 * Project 2 code skeleton; shows how to add a background image.
 * 
 * @author Antonio Hernandez
 */
public class Project2Framework
{
    public static void main(String[] args)
    {
        new Project2Framework();
    }
    
    public Project2Framework()
    {        
        //Defining the geometric objects that represent the problem data
        GeometricObject[] g = new GeometricObject[0];
        
        ////////////////////////////////////////////////////////////////////////
        //populate g with geometric objects
        ////////////////////////////////////////////////////////////////////////        
        
        //graphing
        FrameDisplay frame = new FrameDisplay(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
