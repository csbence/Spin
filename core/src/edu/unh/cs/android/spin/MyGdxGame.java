package edu.unh.cs.android.spin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.unh.cs.android.spin.action.Action;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;
    private final Queue<Action> actionQueue = new LinkedBlockingQueue<>();

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("magic_ball_64.png");

        final InputProcessor inputProcessor = new GestureDetector(new InputGestureHandler(actionQueue));
        Gdx.input.setInputProcessor(inputProcessor);

        // TODO Create an object store to keep track of the object on the field (e.g. flying balls)
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        final Action action = actionQueue.poll();

        if (action != null) {
            // TODO: Execute action
            // Create a new ball and add itt to the object store
            // Set the balls direction and starting location.
        }

        batch.begin();

        // TODO move the balls on the field

        batch.draw(img, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
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
