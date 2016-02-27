import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;

/**
 * Created by noivu on 2/27/2016.
 */
public class GameWindown extends Frame implements KeyListener,MouseMotionListener, Runnable{
    BufferedImage background;
    BufferedImage PLANE1, PLANE4;
    int planeX, planeY;
    int planeX2, planeY2;
    int directinon = 0;
    int x,y;

    public GameWindown() throws IOException {
        planeX = 150;
        planeY = 320;
        planeX2 = 50;
        planeY2 = 100;
        this.setTitle("1945");
        this.setSize(400,640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        try{
            background = ImageIO.read(new File("Resouces/Background.png"));
            PLANE1 = ImageIO.read(new File("Resouces/PLANE1.png"));
            PLANE4 = ImageIO.read(new File("Resouces/PLANE4.png"));
        }catch(IOException e){

        }
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        repaint();
    }
    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        g.drawImage(PLANE1,planeX,planeY,null);
        g.drawImage(PLANE4,planeX2,planeY2,null);
        //g.drawLine(0,0,100,100);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(" Ok ba by "+ e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            directinon = 1;
            repaint(1);
        }
        if(e.getKeyChar() == 's'){
            directinon = 2;
            repaint(1);
        }
        if(e.getKeyChar() == 'a'){
            directinon = 3;
            repaint(1);
        }
        if(e.getKeyChar() == 'd'){
            directinon = 4;
            repaint(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        directinon = 0;
    }

    @Override
    public void run() {
        while(true){
            if(directinon == 0){

            }else if(directinon == 1){
                planeY -= 5;
            }else if(directinon == 2){
                planeY += 5;
            }else if(directinon == 3){
                planeX -= 5;
            }else if(directinon == 4){
                planeX += 5;
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        planeX2 = e.getX();
        planeY2 = e.getY();
        //repaint();
        e.consume();
    }

}
