/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameopengl2;

import com.jogamp.opengl.GL2;


public class GraphWritePoly {

    public static void DrowItThis(int x, int y, int hight, int width) {
        GL2 gl = TheGame.gl;
        gl.glColor3d(0, 1, 0);

        gl.glBegin(GL2.GL_QUADS);

        gl.glVertex2d(x, y);
        gl.glVertex2d(x + width, y);
        gl.glVertex2d(x + width, y + hight);
        gl.glVertex2d(x, y + hight);

        gl.glEnd();
    }

    public static void DrowTheKeyDoor(int posx, int posy) {
        GL2 gl = TheGame.gl;
        gl.glColor3d(0.192,0.192,0.192);

        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2d(posx, posy);
        gl.glVertex2d(posx, posy + 15);
        gl.glVertex2d(posx + 15, posy + 15);
        gl.glVertex2d(posx + 15, posy);
        gl.glVertex2d(posx, posy);
        gl.glEnd();

        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2d(posx + 15, posy + 15);
        gl.glVertex2d(posx + 40, posy + 15);
        gl.glVertex2d(posx + 40, posy + 8);
        gl.glVertex2d(posx + 15, posy + 8);
        gl.glVertex2d(posx, posy);
        gl.glEnd();

        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2d(posx + 25, posy + 8);
        gl.glVertex2d(posx + 25, posy + 4);
        gl.glVertex2d(posx + 27, posy + 4);
        gl.glVertex2d(posx + 27, posy + 8);
        gl.glEnd();

        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2d(posx + 35, posy + 8);
        gl.glVertex2d(posx + 35, posy + 4);
        gl.glVertex2d(posx + 37, posy + 4);
        gl.glVertex2d(posx + 37, posy + 8);
        gl.glEnd();

    }

    public static void StarDraw(int posx, int posy) {
        GL2 gl = TheGame.gl;

        gl.glColor3d(1, 0, 0);




        gl.glBegin(GL2.GL_QUADS);

        gl.glVertex2d(posx+5,posy); // <--- -0.60 instead of -0.68
        gl.glVertex2d(posx+5,posy+5); // <--- -0.68 instead of -0.60
        gl.glVertex2d(posx,posy+5 );
        gl.glVertex2d(posx-5, posy+5);
        gl.glVertex2d(posx-5,posy); // <--- -0.60 instead of -0.68
        gl.glVertex2d(posx-5,posy-5); // <--- -0.68 instead of -0.60
        gl.glVertex2d(posx,posy-5 );
        gl.glVertex2d(posx+5, posy-5);
        gl.glEnd();
    }

}
