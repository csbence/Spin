package edu.unh.cs.android.spin;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Olva on 5/15/15.
 */
public class SpawnPoint {

    private Vector2 spawn;

    public SpawnPoint( Vector2 spawn ) {
        this.spawn = spawn;
    }

    /** - - - - - - - - Setters - - - - - - - - **/

    public void setSpawnPoint( Vector2 s ) { this.spawn = s; }

    /** - - - - - - - - Getters - - - - - - - - **/

    public Vector2 getSpawnPoint( ) { return spawn; };

}
