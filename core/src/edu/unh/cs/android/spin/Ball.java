package edu.unh.cs.android.spin;

/**
 * Created by Olva on 4/8/15.
 *
 * Create a random ball object. Still in progress.
 */


public class Ball {

    public enum Colors {
        /* use this format to add more colors */
        BLUE, RED, YELLOW, GREEN;

        public static Colors setColor( int num ) {
            switch( num ) {
                case 0: return BLUE;
                case 1: return RED;
                case 2: return YELLOW;
                case 3: return GREEN;
                default: return null;
            }
        }
    }

    private Colors color;
    private double speed = 1.0;

    /* Creates a specific ball or a random-colored ball */
    public Ball( int id ) {
        color = Colors.setColor( ( id % Colors.values().length ) );
    }

    /* Return the id of the ball */
    public Colors getColor( ) { return color; }

    /* change the speed value */
    public void setSpeed( double speed ) { this.speed = speed; }

    /* get the speed of the object */
    public double getSpeed( ) { return speed; }



    /**
     * Main method to test class
     */
    public static void main( String[] args ) {
        Ball b1 = new Ball( 0 );
        System.out.println( b1.color );
    }



}
