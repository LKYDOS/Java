/**
 * CSCI1130 Java Assignment 1 ShakeMe
 * Aim: Get acquaint with the JDK + NetBeans programming environment
 *      Learn the structure and formant of a Java program by example
 * 
 * Remark: Key in class names, variable names, method names, etc. AS IS
 *         You should type also ALL the comment lines (text in gray)
 * 
 * I declare that the assignment here submitted is original
 * except for the source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of University policy and 
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 * 
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/acadeichonesty
 * Faculty of Engineering Guidelines to AcademicHonesty:
 *   http://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 * 
 * Student Name: Lui Ka Yung
 * Student ID  : 1155160217
 * Date        : 20/9/2022
 */
package exercise;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

/**
 * ShakeMe Game
 * Java Assignment
 * @author Michael FUNG
 * @since 9 September 2022
 */
public class ShakeMe extends JFrame implements ActionListener  {
    
    /** Instance fields indicating size width x height. */
    protected int width, height;
    /** 2D array of JButton object references. */
    protected JButton buttons[][];
    /** Number of MAGENTA (turned-on) buttons. */
    protected int counter = 0;
    
    /** Default constructor. */
    public ShakeMe()
    {
        width = 20;
        height = 10;
        initDisplay();
    }
    /**
     * Constructor with given width and height of the ShakeMe object.
     * @param w is the number of boxes left-to-right
     * @param h is the number of boxed top-to-bottom
     */
   public ShakeMe(int w, int h)
   {
       width = w;
       height = 10;
       initDisplay();
   }
   /** Initialize the ShakeMe window. */
   public final void initDisplay() {
       try {
           UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
       } catch (ClassNotFoundException  |
                IllegalAccessException  |
                InstantiationException  |
                UnsupportedLookAndFeelException exceptionObject) {
   }
       setTitle("Java Shake Me");
       setLayout(new GridLayout(height, width));
       buttons = new JButton[height][width];
       for (int row = 0; row < height; row++)
           for (int col = 0; col < width; col++)
           {
               buttons[row][col] = new JButton(row + ", " + col);
               buttons[row][col].setMargin(new Insets(1, 1, 1, 1));
               buttons[row][col].addActionListener(this);
               add(buttons[row][col]);
               if (row == height - 1)
                   buttons[row][col].setForeground(Color.YELLOW);
           }
       setSize(width * 40, height * 40);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

/**
 * ActionPerformed on user clicking a target button, try to turn of the target.
 * on clearing all "MAGENTA" targets, shake and show Done and Bye
 */
@Override
public void actionPerformed(ActionEvent eventObject){
    JButton target = (JButton) (eventObject.getSource());
    target.setForeground(Color.BLUE);
    if (!turnOffButton (target))
        //wrong target, shake()!
        shake();
    else if (counter == 0) {
        shake();
        JOptionPane.showMessageDialog(null, "Done! Bye!");
        shake();
        System.exit(0);
    }
}

/** Slow down this process by sleeping this thread. */
private void delay(long sleepInMS) {
    try {
        TimeUnit.MILLISECONDS.sleep(sleepInMS);
    } catch (InterruptedException exceptionObject) {
        Thread.currentThread() .interrupt();
    }
}
/** Shake the window. */
private void shake() {
    Point windowLocation = getLocation();
    
    double round = 5, max_radius = 10, step = 100;
    
    double limit = 2 * Math.PI * round;
    double angle_increment = limit / step;
    double radius_increment = max_radius / step;
    
    for (double angle = 0,   radius = 0;
         angle < limit;
         angle += angle_increment,   radius += radius_increment)
    {
        setLocation((int) (Math.cos(angle) * radius) + windowLocation.x,
                    (int) (Math.sin(angle) * radius) + windowLocation.y);
        this.delay(6);
    }
    this.setLocation(windowLocation);
}
/**
 * Turn on a button and increase this counter, taking two coordinates.
 * @param h is the top-to-bottom coordinate (row index)
 * @param w is the left-to-right coordinate (column index)
 */
public void turnOnButton(int h, int w) {
    if (Color.MAGENTA != buttons[h][w].getBackground()) {
        buttons[h][w].setBackground(Color.MAGENTA);
        counter++;
    }
}

/**Turn off a button "object" and decrease the counter.
 * @param target is a JButton object reference
 * @return false if the target is NOT on; true after finishing the action
 */
public boolean turnOffButton(JButton target) {
    if (Color.MAGENTA != target.getBackground())
        return false;
    target.setBackground(null);
    counter--;
    return true;
}

/**
 * TO DO: students should customize this method
 * to show the last FIVE digits of your SID in MAGENTA in BIG Buttons; AND
 * to show first 10-char of your SURNAME 1-by-1 YELLOW-ON-MAGENTA on the bottom
 */
public void showMyInfo()
{
    //6
    turnOnButton(1, 4);
    turnOnButton(2, 1);
    turnOnButton(3, 1);
    turnOnButton(4, 1);
    turnOnButton(5, 1);
    turnOnButton(6, 1);
    turnOnButton(7, 1);
    turnOnButton(7, 2);
    turnOnButton(7, 3);
    turnOnButton(1, 1);
    turnOnButton(1, 2);
    turnOnButton(1, 3);
    turnOnButton(4, 2);
    turnOnButton(4, 3);
    turnOnButton(4, 4);
    turnOnButton(5, 4);
    turnOnButton(6, 4);
    turnOnButton(7, 4);
    //0
    turnOnButton(1, 6);
    turnOnButton(1, 7);    
    turnOnButton(1, 8);
    turnOnButton(1, 9);
    turnOnButton(2, 6);
    turnOnButton(3, 6);
    turnOnButton(4, 6);
    turnOnButton(5, 6);
    turnOnButton(6, 6);  
    turnOnButton(7, 6);
    turnOnButton(7, 7);
    turnOnButton(7, 8);
    turnOnButton(7, 9);
    turnOnButton(2, 9);
    turnOnButton(3, 9);
    turnOnButton(4, 9);
    turnOnButton(5, 9);
    turnOnButton(6, 9);
    //2
    turnOnButton(1, 11);
    turnOnButton(1, 12);
    turnOnButton(1, 13);
    turnOnButton(1, 14);
    turnOnButton(7, 11);
    turnOnButton(7, 12);
    turnOnButton(7, 13);
    turnOnButton(7, 14);
    turnOnButton(6, 11);
    turnOnButton(5, 12);
    turnOnButton(4, 13);
    turnOnButton(3, 14);
    turnOnButton(2, 14);
    turnOnButton(2, 11);
    //1
    turnOnButton(3, 16);
    turnOnButton(2, 17);
    turnOnButton(1, 18);
    turnOnButton(1, 18);
    turnOnButton(2, 18);
    turnOnButton(3, 18);
    turnOnButton(4, 18);
    turnOnButton(5, 18);
    turnOnButton(6, 18);
    turnOnButton(7, 18);
    turnOnButton(7, 16);
    turnOnButton(7, 17);
    turnOnButton(7, 19);
    //7
    turnOnButton(1, 20);
    turnOnButton(1, 21);
    turnOnButton(1, 22);
    turnOnButton(1, 23);
    turnOnButton(2, 20);
    turnOnButton(2, 23);
    turnOnButton(3, 23);
    turnOnButton(4, 23);
    turnOnButton(5, 23);
    turnOnButton(6, 23);
    turnOnButton(7, 23);
    
    /**
        Remarks: I do not know if this will lead to deductions of marks
               so i will just comment it
   
    //:]
    
    turnOnButton(1, 27);
    turnOnButton(1, 28);
    turnOnButton(4, 29);
    turnOnButton(1, 29);
    turnOnButton(2, 29);
    turnOnButton(3, 29);
    turnOnButton(4, 29);
    turnOnButton(5, 29);
    turnOnButton(6, 29);
    turnOnButton(7, 29);
    turnOnButton(7, 27);
    turnOnButton(7, 28);
    turnOnButton(3, 25);
    turnOnButton(3, 26);
    turnOnButton(5, 25);
    turnOnButton(5, 26);
    */
    
    
    
   
    
    
    
        
    
    
    //example surname with 4-char: N A M E
    int c = 0;
    buttons[height - 1][c].setText("N");
    turnOnButton(height - 1, c++);
    buttons[height - 1][c].setText("A");
    turnOnButton(height - 1, c++);
    buttons[height - 1][c].setText("M");
    turnOnButton(height - 1, c++);
    buttons[height - 1][c].setText("E");
    turnOnButton(height - 1, c++);
    //add mroe lines as you need here
    buttons[height - 1][c].setText("L");
    turnOnButton(height - 1, c++);
    buttons[height - 1][c].setText("U");
    turnOnButton(height - 1, c++);
    buttons[height - 1][c].setText("I");
    turnOnButton(height - 1, c++);
}

/**
 * main() method, starting point of the Java application.
 * @param args are command line argument in a String array
 */
    public static void main(String[] args) {
        ShakeMe myObj;
        //create a ShakeMe object of different size 30x10
        myObj = new ShakeMe(30,10);
        myObj.showMyInfo();
    }
}