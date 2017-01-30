package snakey.snakey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

import java.util.Random;

public class Main extends ApplicationAdapter implements InputProcessor {

    ShapeRenderer shape;
    Snake snake;
    ArrayList<Food> arFood = new ArrayList<Food>();
    float GridSize = 20;
    int nRows, nCols;
    Random ranGen;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        Gdx.input.setInputProcessor(this);
        ranGen = new Random();
        nRows = (int) (Gdx.graphics.getWidth() / GridSize);
        nCols = (int) (Gdx.graphics.getHeight() / GridSize);
        snake = new Snake(shape, 10, 10, GridSize, GridSize);
        snake.setDir(1, 0);
        arFood.add(new Food(randomPos(), GridSize, GridSize, shape));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(163f / 255f, 163f / 255f, 163f / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        snake.update();
        for (int i = arFood.size() - 1; i >= 0; i--) {
            if (isHitSnakeFood(snake, arFood.get(i))) {
                snake.bMove = false;
            }
        }
    }

    public Vector2 randomPos() {
        return new Vector2(ranGen.nextInt(nRows) * GridSize, ranGen.nextInt(nCols) * GridSize);
    }

    public boolean isHitSnakeFood(Snake snake, Food food) {
        if (snake.fX >= food.fX && snake.fX <= food.fX + food.fW) {
            return true;
        } else {
            return false;
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
