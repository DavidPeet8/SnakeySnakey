/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakey.snakey;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author peetd0837
 */
public class Snake {
    ShapeRenderer shape;
    float fX, fY, GridSize;
    float fDx, fDy;
    public Snake (ShapeRenderer shape, float fX, float fY, float GridSize) {
        this.shape = shape;
        this.fX = fX;
        this.fY = fY;
        this.GridSize = GridSize;
    }
    void display () {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(fX, fY, GridSize, GridSize);
        shape.end();
        move();
//        System.out.println(fDx);
//        System.out.println(fDy);
//        System.out.println();
    }
    
    void move () {
        fX += (fDx * GridSize);
        fY += (fDy * GridSize);
    }
    
    void setDir (float fDx, float fDy) {
        this.fDx = fDx;
        this.fDy = fDy;
    }
}
