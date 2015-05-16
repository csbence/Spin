package edu.unh.cs.android.spin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import edu.unh.cs.android.spin.action.Action;
import edu.unh.cs.android.spin.action.ActionThrow;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private final Queue<ActionThrow> actionQueue = new LinkedBlockingQueue<>();
    private final Queue<Ball> gameBalls = new LinkedBlockingQueue<>();
    private final Queue<SpawnPoint> spawnPoints = new LinkedBlockingQueue<>();
    private final ArrayList<Ball> flyingBalls = new ArrayList<>();
    private Random rng;

    @Override
    public void create() {
        batch = new SpriteBatch();
        rng = new Random();

        ActionThrow initActionThrow = new ActionThrow();
        actionQueue.offer(initActionThrow);

        /* Spawn Point -- Can be changed later */
        spawnPoints.offer(new SpawnPoint(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2)));

        InputMultiplexer multiplexer = new InputMultiplexer();
        final InputProcessor inputGesture = new GestureDetector(new InputGestureHandler(actionQueue));
        final InputProcessor inputEvent = new InputEventHandler( actionQueue );

        multiplexer.addProcessor(inputEvent);
        multiplexer.addProcessor(inputGesture);

        Gdx.input.setInputProcessor(multiplexer);

        // TODO Create an object store to keep track of the object on the field (e.g. flying balls)
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        /* clear the screen */
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if( gameBalls.isEmpty() ) {
            int rand = rng.nextInt(100);
            Ball ball = new Ball(rand);
            /* Potentially change to poll() after
             * to simulate multiple spawn points */
            ball.setLocation( spawnPoints.peek().getSpawnPoint() );
            ball.setName(Integer.toString(rand));
            gameBalls.offer(ball);
        } else {
            batch.draw( gameBalls.peek().getImage(),
                        gameBalls.peek().getLocation().x,
                        gameBalls.peek().getLocation().y);
        }

        /* If actionThrow has been modified and is ready to be used */
        if ( actionQueue.peek().getState() ) {

            Ball ball = gameBalls.poll();
            ball.setSpeed(actionQueue.peek().getSpeed());
            //TODO: Fix the direction at which ball moves


            /** IMPORTANT REFACTOR THIS SHIT **/
            double initX = spawnPoints.peek().getSpawnPoint().x;
            double initY = spawnPoints.peek().getSpawnPoint().y;
            double endX = actionQueue.peek().getEndLoc().x;
            double endY = actionQueue.peek().getEndLoc().y;

            double diffX = endX - initX;
            double diffY = endY - initY;

            System.out.println( "InitX: " + initX + " InitY: " + initY );
            System.out.println( "EndX: " + endX + " EndY: " + endY );
            System.out.println( "DiffX: " + diffX + " DiffY: " + diffY );


            /* Get the next ball in Sequence */
            if( ball != null ) {
                ball.setAddXY( diffX, -diffY );
                flyingBalls.add(ball);
            }

            /* actionThrow has been used and is not ready */
            actionQueue.peek().setState(false);
        }

        //TODO: remove balls when it enters the correct bin
        /* draw shit */

        for( Ball ball : flyingBalls ) {
            ball.update( );
//            System.out.println( ball.getName() );
            batch.draw(ball.getImage(), ball.getLocation().x, ball.getLocation().y);
        }

        batch.end();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
