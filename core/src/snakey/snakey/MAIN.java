package snakey.snakey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.Random;

public class MAIN extends ApplicationAdapter implements InputProcessor {

    ShapeRenderer shape;
    Snake snake;
    float GridSize = 10;
    float fX, fY, fW, fH;
    int nRows, nCols;
    Random ranGen;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        snake = new Snake(shape, 10, 10, GridSize);
        snake.setDir(1, 0);
        Gdx.input.setInputProcessor(this);
        ranGen = new Random();
        nRows = (int) (Gdx.graphics.getWidth() / GridSize);
        nCols = (int) (Gdx.graphics.getHeight() / GridSize);
        fX = ranGen.nextInt(nRows) * GridSize;
        fY = ranGen.nextInt(nCols) * GridSize;
        fW = GridSize;
        fH = GridSize;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(163f / 255f, 163f / 255f, 163f / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        snake.display();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(fX, fY, fW, fH);
        shape.end();
        
        if (snake.fX >= fX && snake.fX <= fX + fW) {
            System.out.println("TEST");
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            snake.setDir(-1, 0);
        } else if (keycode == Input.Keys.RIGHT) {
            snake.setDir(1, 0);
        } else if (keycode == Input.Keys.UP) {
            snake.setDir(0, 1);
        } else if (keycode == Input.Keys.DOWN) {
            snake.setDir(0, -1);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return true;
    }
}
