package edu.unh.cs.android.spin.action;

import com.badlogic.gdx.math.Vector2;

public class ActionThrow implements Action {

    private double angle;
    private Vector2 speed, endLoc, initLoc;
    private boolean state;

    public ActionThrow( ) {
        angle = 0.0;
        speed = endLoc = initLoc = null;
        state = false;
    }

    /** - - - - - - - - Setters - - - - - - - - **/

    /* records angle of ActionThrow */
    public void setAngle( double a ) { angle = a; }

    /* records Fling velocity */
    public void setSpeed( Vector2 sp ) { speed = sp; }

    /* records touchUp location */
    public void setEndLoc( Vector2 end ) { endLoc = end; }

    /* records touchDown location */
    public void setInitLoc( Vector2 init ) { initLoc = init; }

    /* sets the state of ActionThrow
    *  when its false actionThrow has not been used yet
    *  when its true render will use the data stored in
    *  this class then sets the state back to false
    **/
    public void setState( boolean bool ) { state = bool; }

    /** - - - - - - - - Getters - - - - - - - - **/

    /* get the angle of the ball */
    public double getAngle() { return angle; }

    /* gets the speed of the ball */
    public Vector2 getSpeed() { return speed; }

    /* gets touchdown location */
    public Vector2 getEndLoc( ) { return endLoc; }

    /* checks if actionThrow has been used or not */
    public boolean getState( ) { return state; }

    /* gets touchUp location */
    public Vector2 getInitLoc() { return initLoc; }
}
