package snakey.snakey;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by hafiz on 1/29/2017.
 */

public class Food {
    float fX, fY, fW, fH;
    private ShapeRenderer shape;

    public Food(Vector2 vPos, float fW, float fH, ShapeRenderer shape) {
        fX = vPos.x;
        fY = vPos.y;
        this.fW = fW;
        this.fH = fH;
        this.shape = shape;
    }

    void display() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(fX, fY, fW, fH);
        shape.end();
        shape.end();
    }
}
