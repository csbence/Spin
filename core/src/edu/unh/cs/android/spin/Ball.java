package edu.unh.cs.android.spin;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Olva on 4/8/15.
 *
 * Create a random ball object. Still in progress.
 */


public class Ball {

    public enum Colors {
        /* use this format to add more colors */
        BLUE, RED, YELLOW, GREEN;

        /* change image of ball later */
        public static Colors initBall( int num ) {
            switch( num ) {
                case 0:
                    img = new Texture("magic_ball_64.png");
                    return BLUE;
                case 1:
                    img = new Texture("magic_ball_64.png");
                    return RED;
                case 2:
                    img = new Texture("magic_ball_64.png");
                    return YELLOW;
                case 3:
                    img = new Texture("magic_ball_64.png");
                    return GREEN;
                default: return null;
            }
        }

    }
    /* Global Variables */
    private Colors color;
    private String name;
    private double speed = 1.0;
    private double addX, addY;
    private Vector2 location;
    private static Texture img;
    /* Creates a specific ball or a random-colored ball */
    public Ball( int id ) {
        location = new Vector2();
        color = Colors.initBall( ( id % Colors.values().length ) );
        location.x = 0; addX = 0;
        location.y = 0; addY = 0;
    }

    /* Set name of Ball */

    public void setName( String name ) { this.name = name; }

    public String getName( ) { return name; }

    /* Return the id of the ball */
    public Colors getColor( ) { return color; }

    /* change the speed value */
    public void setSpeed( double speed ) { this.speed = speed; }

    /* get the speed of the object */
    public double getSpeed( ) { return speed; }

    /* set location of ball object */
    public void setLocation( int x, int y ) {
        location.x = x;
        location.y = y;
    }

    /* return the location of the ball object */
    public Vector2 getLocation( ) {
        return location;
    }

    /* return the ball image */
    public Texture getImage( ){
        return img;
    }

    /* Update the location of the Ball */
    public void update() {

        location.x += addX;
        location.y += addY;
    }

    /* Update addX and addY field */
    public void setAdder(double x, double y) {
        addX = x / 10;
        addY = y / 10;
    }


    /**
     * Main method to test class
     */
    public static void main( String[] args ) {
        Ball b1 = new Ball( 0 ); // put a random value here
        System.out.println( b1.color );
    }



}
