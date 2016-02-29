import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,MouseMotionListener, Runnable{

    //start
    Graphics seconds;
    Image image;
    //end

    BufferedImage background;
    BufferedImage PLANE1, PLANE4, DAN;

    int positionYD ;
    int speedDan = 5;
    int derictionDAN = 1 ; // tốc độ của viên đạn....

    Plane plane; // khai báo tham chiếu.. ( địa chỉ )
    Plane plane2;

    public GameWindow() throws IOException {

        plane = new Plane();
        plane2 = new Plane();

        positionYD = plane.positionY;

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
            plane.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
            plane2.sprite2 = ImageIO.read(new File("Resouces/PLANE4.png"));
            DAN = ImageIO.read(new File("Resouces/DAN.png"));

        }catch(IOException e){

        }
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
    }

    // ko can hieu (đỡ giật màn hình ..)
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    // end

    public void paint(Graphics g){
        g.drawImage(background, 0, 0, null);
        plane.draw(g);
        plane2.draw(g);
        g.drawImage(DAN, plane.positionX, positionYD, null);
        {
            //positionYD = plane2.positionY2 ;
            if(derictionDAN == 0){
                positionYD -= speedDan;
            }
            //
        }
       // positionYD = plane2.positionY2;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(" Nhap phím : "+ e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            derictionDAN = 0;
        }
        if(e.getKeyChar() == 'w'){
            plane.direction = 1;
        }
        if(e.getKeyChar() == 's'){
            plane.direction = 2;
        }
        if(e.getKeyChar() == 'a'){
            plane.direction = 3;
        }
        if(e.getKeyChar() == 'd'){
            plane.direction = 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.direction = 0 ;

    }

    @Override
    public void run() {
        while(true){
            plane.update();
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
        plane2.positionX2 = e.getX();
        plane2.positionY2 = e.getY();
        e.consume();
        BufferedImage cursorImg = new BufferedImage(plane2.positionX2, plane2.positionY2, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
    }
}
