/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameopengl2;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class TheGame extends Application implements GLEventListener {

    public static GLWindow fram = null;
    static int hight = 600;
    static int width = 785;
    static Color[][] pixeles;
    static BufferedImage buffered;
    public static FPSAnimator anan;
    public static int delay = 0;
    static GL2 gl = null;
    public static int i = -25;
    public static int j = -270;
    static int playerWidth = 15;
    static int playerHight = 15;
    static Color[][] color;
    public static boolean t = true;
    static int time = 0;
    public static int widthTime = 750;
    static int timeFlag = 20;
    static boolean stant = true;

    public static void CallClass() throws IOException {

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        buffered = DrawTheMaze(System.getProperty("user.dir")+"\\src\\gameopengl2\\final00.png");

        fram = GLWindow.create(capabilities);
        fram.setSize(width, hight);
        fram.setRealized(true);
        fram.addGLEventListener(new TheGame());
        fram.addKeyListener(new KeyBordListinor());
        FPSAnimator anan = new FPSAnimator(fram, 40);
        anan.start();
        fram.setVisible(true);
        fram.setTitle("The Maze");
    }
    static Point[] theRandomStar = new Point[10];

    @Override
    public void init(GLAutoDrawable glad) {
        Point[] starArray = FillTheArray();

        for (int k = 0; k < 10; k++) {
            theRandomStar[k] = starArray[(int) Math.floor(Math.random() * 20)];
            System.out.println(theRandomStar[k].x + " , " + theRandomStar[k].y);
        }
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {

        gl = glad.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        color = ARGB(buffered);

        gl.glBegin(GL2.GL_POINTS);
        for (int j = 0; j < 775; j++) {
            for (int i = 0; i < 454; i++) {

                gl.glColor3d(color[j][i].getRed(), color[j][i].getGreen(), color[j][i].getBlue());
                gl.glVertex2d(j - 387, i - 270);
            }
        }
        gl.glEnd();

        if (t) {
            GraphWritePoly.DrowTheKeyDoor(-256, -18);
        }
        
        GraphWritePoly.DrowItThis(-380, 229, 20, widthTime);
        
        if (delay == 3) {
            widthTime--;
            delay=0;
        }
        delay++;
        for (int k = 0; k < 10; k++) {
            if (!KeyBordListinor.starTaken[k]) {
                GraphWritePoly.StarDraw((int) theRandomStar[k].getX(), (int) theRandomStar[k].getY());
            }
        }
        GraphWritePoly.DrowItThis(i, j, playerWidth, playerHight);

    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3
    ) {

        GL2 gl = glad.getGL().getGL2();
        width = fram.getWidth();
        hight = fram.getHeight();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-width / 2, width / 2, -hight / 2, hight / 2, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    public static Color[][] ARGB(BufferedImage image) {
        int r, g, b, a;
        Color[][] color = new Color[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                a = (image.getRGB(i, j) >> 24) & 0xff;
                r = (image.getRGB(i, j) >> 16) & 0xff;
                g = (image.getRGB(i, j) >> 8) & 0xff;
                b = (image.getRGB(i, j)) & 0xff;
                color[i][j] = new Color(r, g, b, a);
            }
        }
        return color;

    }

    Point[] FillTheArray() {

        Point[] arrayStars = new Point[20];

        arrayStars[0] = new Point(-292, 78);
        arrayStars[1] = new Point(-175, -5);
        arrayStars[2] = new Point(50, 55);
        arrayStars[3] = new Point(-214, -54);
        arrayStars[4] = new Point(-19, -12);
        arrayStars[5] = new Point(287, 81);
        arrayStars[6] = new Point(251, -189);
        arrayStars[7] = new Point(-250, 51);
        arrayStars[8] = new Point(56, -114);
        arrayStars[9] = new Point(-58, -114);
        arrayStars[10] = new Point(-289, -219);
        arrayStars[11] = new Point(251, 0);
        arrayStars[12] = new Point(-133, 24);
        arrayStars[13] = new Point(-97, 117);
        arrayStars[14] = new Point(95, -255);
        arrayStars[15] = new Point(-175, -114);
        arrayStars[16] = new Point(251, -144);
        arrayStars[17] = new Point(-331, -138);
        arrayStars[18] = new Point(134, -30);
        arrayStars[19] = new Point(134, -180);

        return arrayStars;

    }

    static BufferedImage DrawTheMaze(String path) throws IOException {
        BufferedImage Imagebb;
        File image2 = new File(path);
        Image image = ImageIO.read(image2);
        Imagebb = (BufferedImage) image;
        return Imagebb;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

