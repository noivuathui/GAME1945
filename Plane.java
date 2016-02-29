import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by noivu on 2/28/2016.
 */
public class Plane {
    public int positionX = 100;
    public int positionY = 200;
    public int damage;
    public int speed = 3;
    public int heatth;
    public int planeType;
    public int direction;
    public BufferedImage sprite;

    public int positionX2 = 100;
    public int positionY2 = 350;
    public int damage2;
    public int speed2 = 3;
    public int heatth2;
    public int planeType2;
    public int direction2;
    public BufferedImage sprite2;

    void move(){
        if(direction == 1){
            this.positionY -= this.speed;
        }else if(direction == 2){
            this.positionY += this.speed;
        }else if(direction == 3){
            this.positionX -= this.speed;
        }else if(direction == 4){
            this.positionX += this.speed;
        }
    }

    void update(){
        move();
    }
    void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
        g.drawImage(this.sprite2, this.positionX2, this.positionY2, null);
    }
}
/*
bt : ẩn con chuột hidden cursor
      sửa class plane sao cho 1 con chạy bằng chuột, 1 con chay bang phim
    xem lại các thuộc tính, phương thức --> tạo access mdifier cho nó
làm bắn đạn.
*/