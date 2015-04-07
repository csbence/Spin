package edu.unh.cs.android.spin.action;

public class ActionThrow implements Action {

    private final double angle;

    public ActionThrow(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

}
