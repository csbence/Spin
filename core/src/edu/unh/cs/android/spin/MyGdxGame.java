package edu.unh.cs.android.spin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

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
    private final ArrayList<Ball> flyingBalls = new ArrayList<>();
    private Random rng;
    private static boolean debug = false; // use for flow control in render method

    @Override
    public void create() {
        batch = new SpriteBatch();
        rng = new Random();

        final InputProcessor inputProcessor = new GestureDetector(new InputGestureHandler(actionQueue));
        Gdx.input.setInputProcessor(inputProcessor);

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

        final ActionThrow action = actionQueue.poll();
        final Ball nextBall;

        /* purpose of debug is to make sure only 1 ball is created for testing purposes */
//        if( !debug ) {
//            Ball ball = new Ball(rng.nextInt(100));
//            ball.setLocation(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//            gameBalls.offer(ball);
//            debug = true;
//        }

        if (action != null) {
            // TODO: Execute action
            // Set the balls direction and starting location.

            int rand = rng.nextInt(100);
            Ball ball = new Ball(rand);
            ball.setLocation(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
            ball.setName( Integer.toString(rand));
            gameBalls.offer(ball);

            //TODO: Fix the direction at which ball moves
            double x = 100 * Math.sin(action.getAngle());
            double y = 100 * Math.cos(action.getAngle());
//            System.out.println( "Action angle: " + action.getAngle());
//            System.out.println( "Action x: " + x );
//            System.out.println( "Action y: " + y );

            /* Get the next ball in Sequence */
            nextBall = gameBalls.poll();
            if( nextBall != null ) {
                nextBall.setAdder(x, y);
                flyingBalls.add(nextBall);
            }

        }


        batch.begin();

        //TODO: remove balls when it enters the correct bin
        /* draw shit */

        for( Ball ball : flyingBalls ) {
            ball.update( );
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
