package edu.unh.cs.android.spin;

import com.badlogic.gdx.InputProcessor;

import java.util.Queue;

import edu.unh.cs.android.spin.action.Action;

/**
 * @author Bence Cserna (csbence@gmail.com)
 */
public class InputEventHandler implements InputProcessor {
    private final Queue<Action> actionQueue;

    public InputEventHandler(Queue<Action> actionQueue) {
        this.actionQueue = actionQueue;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
