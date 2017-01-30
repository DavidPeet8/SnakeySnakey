/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakey.snakey;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * @author peetd0837
 */
public class Snake {
    ShapeRenderer shape;
    float fX, fY, fW, fH;
    float fDx, fDy;
    boolean bMove = true;

    public Snake(float fX, float fY, float fW, float fH, ShapeRenderer shape) {
        this.shape = shape;
        this.fX = fX;
        this.fY = fY;
        this.fW = fW;
        this.fH = fH;
    }

    void update() {
        display();
        move();
    }

    void display() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(fX, fY, fW, fH);
        shape.end();
    }

    void move() {
        fX += (fDx * fW);
        fY += (fDy * fH);
    }

    void setDir(float fDx, float fDy) {
        if (bMove) {
            this.fDx = fDx;
            this.fDy = fDy;
        }
    }
}
