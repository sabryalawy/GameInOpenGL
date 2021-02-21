/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameopengl2;

import Interfaces.cont;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KeyBordListinor implements KeyListener {

    GL2 gl = TheGame.gl;
    static boolean[] starTaken = new boolean[10];

    @Override
    public void keyPressed(KeyEvent ke) {
        // go up
        if (ke.getKeyCode() == 150 && Up()) {
            TheGame.j += 3;
            UpForTheStar();
            if ((TheGame.i < 17 && TheGame.i + 15 > 17) && (TheGame.j < 147 && TheGame.j + 15 > 147)) {
                Interfaces.cont.g = true;
            }
            // go Down
        } else if (ke.getKeyCode() == 152 && Down()) {
            TheGame.j -= 3;
            UpForTheStar();
            if ((TheGame.i < 17 && TheGame.i + 15 > 17) && (TheGame.j < 147 && TheGame.j + 15 > 147)) {
                Interfaces.cont.g = true;
            }
            // go Right
        } else if (ke.getKeyCode() == 151 && Right()) {
            TheGame.i += 3;
            UpForTheStar();
            // for the key
            if ((TheGame.i >= -256 - 15 && TheGame.i < -216) && (TheGame.j + 15 > -18 && TheGame.j + 15 < -3 + 15&& TheGame.t)) {
                Interfaces.cont.show = true;
                TheGame.t = false;
                TheGame.widthTime += 30;

            }
            // go Left
        } else if (ke.getKeyCode() == 149 && Left()) {
            TheGame.i -= 3;
            UpForTheStar();

        }
        Interfaces.cont.g = (TheGame.i < 17 && TheGame.i + 15 > 17) && (TheGame.j < 147 && TheGame.j + 15 > 147);
        boolean test = Interfaces.cont.show;
        System.out.println(TheGame.i + "   " + TheGame.j + "     this is ascII = " + ke.getKeyCode() + "         " + test);

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean Up() {

        int xStart = TheGame.i + 387;
        int xEnd = TheGame.i + 387 + 15;
        int yStart = TheGame.j + 270 + 15;
        int yEnd = TheGame.j + 270 + 15 + 3;
        for (int j = xStart; j <= xEnd; j++) {
            if (TheGame.color[j][yStart + 1].getRGB() == -16777216) {
                return false;
            } else if (TheGame.color[j][yStart + 2].getRGB() == -16777216) {
                return false;
            } else if (TheGame.color[j][yStart + 3].getRGB() == -16777216) {
                return false;
            }
        }
        return true;
    }

    void UpForTheStar() {

        for (int k = 0; k < TheGame.theRandomStar.length; k++) {
            if ((TheGame.i < TheGame.theRandomStar[k].x && TheGame.i + 15 > TheGame.theRandomStar[k].x) && (TheGame.j < TheGame.theRandomStar[k].y && TheGame.j + 15 > TheGame.theRandomStar[k].y) && !starTaken[k]) {
                starTaken[k] = true;
                TheGame.widthTime += 25;
                for (int i = 0; i < TheGame.theRandomStar.length; i++) {
                    if (TheGame.theRandomStar[k].x == TheGame.theRandomStar[i].x && TheGame.theRandomStar[k].y == TheGame.theRandomStar[i].y && !starTaken[i]) {
                        starTaken[i] = true;
                    }
                }
            }
        }

    }

    boolean Down() {

        int xStart = TheGame.i + 387;
        int xEnd = TheGame.i + 387 + 15;
        int yStart = TheGame.j + 270;
        int yEnd = TheGame.j + 270 + 3;
        try {
            for (int j = xStart; j <= xEnd; j++) {
                if (TheGame.color[j][yStart - 1].getRGB() == -16777216) {
                    return false;
                } else if (TheGame.color[j][yStart - 2].getRGB() == -16777216) {
                    return false;
                } else if (TheGame.color[j][yStart - 3].getRGB() == -16777216) {
                    return false;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    boolean Right() {

        int xStart = TheGame.i + 387 + 15;
        int xEnd = TheGame.i + 387 + 15 + 3;
        int yStart = TheGame.j + 270;
        int yEnd = TheGame.j + 270 + 15;
        try {
            for (int j = yStart; j <= yEnd; j++) {
                if (TheGame.color[xStart + 1][j].getRGB() == -16777216) {
                    return false;
                } else if (TheGame.color[xStart + 2][j].getRGB() == -16777216) {
                    return false;
                } else if (TheGame.color[xStart + 3][j].getRGB() == -16777216) {
                    return false;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    boolean Left() {

        int xStart = TheGame.i + 387;
        int xEnd = TheGame.i + 387 + 3;
        int yStart = TheGame.j + 270;
        int yEnd = TheGame.j + 270 + 15;
        try {
            for (int j = yStart; j <= yEnd; j++) {
                if (TheGame.color[xStart - 1][j].getRGB() == -16777216) {
                    return false;
                } else if (TheGame.color[xStart - 2][j].getRGB() == -16777216) {
                    return false;
                } else if (TheGame.color[xStart - 3][j].getRGB() == -16777216) {
                    return false;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
