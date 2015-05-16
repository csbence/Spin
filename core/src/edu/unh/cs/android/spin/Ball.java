package edu.unh.cs.android.spin;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Olva on 4/8/15.
 *
 * Create a random ball object. Still in progress.
 */


public class Ball {

    /* Global Variables */
    private Colors color;
    private String name;
    private double addX, addY;
    private double speedMult = 0.1;
    private Vector2 location, speed;
    private static Texture img;

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
    public void setSpeed( Vector2 speed ) { this.speed = speed; }

    /* get the speed of the object */
    public Vector2 getSpeed( ) { return speed; }

    /* set location of ball object */
    public void setLocation( Vector2 loc ) {
        location.x = loc.x;
        location.y = loc.y;
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
    public void setAddXY(double x, double y) {
        addX = x * speedMult;
        addY = y * speedMult;
    }


    /**
     * Main method to test class
     */
    public static void main( String[] args ) {
        Ball b1 = new Ball( 0 ); // put a random value here
        System.out.println( b1.color );
    }



}
