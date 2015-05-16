package edu.unh.cs.android.spin;

/**
 * Created by Olva on 5/16/15.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bucket {

    private Rectangle bounds;
    private Color bucketColor;
    private Vector2 bucketLocation;
    public static final int bucketSize = 100;

    public Bucket( Ball.Colors ballColor, Vector2 bucketLocation ) {
        this.bucketLocation = bucketLocation;
        bounds = new Rectangle( bucketLocation.x, bucketLocation.y, bucketSize, bucketSize );
        bucketColor = getBucketColor(ballColor);
    }


    /** - - - - - - - - Setters - - - - - - - - **/

    /** - - - - - - - - Getters - - - - - - - - **/

    /* returns the color of the ball */
    public Color getBucketColor( Ball.Colors ballColor ) {
        if( ballColor == Ball.Colors.BLUE ) {
            return Color.BLUE;
        } else if( ballColor == Ball.Colors.GREEN ) {
            return Color.GREEN;
        } else if( ballColor == Ball.Colors.RED ) {
            return Color.RED;
        } else if( ballColor == Ball.Colors.YELLOW ) {
            return Color.YELLOW;
        } else {
            System.err.println( "A Color is not recognized " + bucketColor +
                    " Please update getImage()" );
            return null;
        }
    }

    /* returns the location of the bucket */
    public Vector2 getLocation( ) { return bucketLocation; }

    /* returns the color of the bucket */
    public Color getColor( ) { return bucketColor; }

    /* returns the bounds of the bucket */
    public Rectangle getBounds( ) { return bounds; }
}
