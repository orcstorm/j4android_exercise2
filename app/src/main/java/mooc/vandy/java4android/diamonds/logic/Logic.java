package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        final int height = size + 2;
        final int width = size * 2 + 2;

        int i = 0;
        while(i < height) {
            int j = 0;
            while(j < width) {
                if(i == 0 || i == height - 1) {
                    if(j == 0 || j == width - 1) {
                        mOut.print("+");
                    } else {
                        mOut.print("-");
                    }
                } else {
                    if(j == 0 || j == width -1) {
                        mOut.print("|");
                    } else {
                        if(i == height / 2) {
                            if(j == 1) {
                                mOut.print("<");
                            } else if (j == width - 2){
                                mOut.print(">");
                            } else {
                                if(i % 2 == 0) {
                                    mOut.print("-");
                                } else {
                                    mOut.print("=");
                                }
                            }
                        } else if(i < height / 2) {
                            int min = width / 2 - i;
                            int max = (width / 2 + i) - 1;
                            if(j == min) {
                                mOut.print("/");
                            } else if(j == max) {
                                mOut.print("\\");
                            } else if(j > min && j < max) {
                                if(i % 2 == 0) {
                                    mOut.print("-");
                                } else {
                                    mOut.print("=");
                                }
                            } else {
                                mOut.print(" ");
                            }
                        } else {
                            int min = ((width /2) - (width - i)) + 2 ;
                            int max = ((width / 2) + (width - i)) - 3;
                            if (j == min) {
                                mOut.print("\\");
                            } else if(j == max) {
                                mOut.print("/");
                            } else if(j > min && j < max) {
                                if(i % 2 == 0) {
                                    mOut.print("-");
                                } else {
                                    mOut.print("=");
                                }
                            } else {
                                mOut.print(" ");
                            }
                        }z
                    }
                }
                j++;
            }
            mOut.println();
            i++;
        }
        mOut.println();
    }

}
