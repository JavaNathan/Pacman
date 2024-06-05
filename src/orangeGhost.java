import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class orangeGhost {
    public double xCoord;
    public double yCoord;
    private BufferedImage leftImg;
    private BufferedImage rightImg;
    private boolean facingRight;
    private final double MOVE_AMT = 0.15;
    private boolean moveX;
    private boolean moveY;

    public orangeGhost(String leftImg, String rightImg, int xCoord, int yCoord){
        moveX = true;
        moveY = false;
        facingRight = true;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        try {
            this.leftImg = ImageIO.read(new File(leftImg));
            this.rightImg = ImageIO.read(new File(rightImg));
        } catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public BufferedImage getEnemyImage(){
        if (facingRight){
            return rightImg;
        }
        else{
            return leftImg;
        }
    }

    public Rectangle enemyRect(){
        int imageHeight = getEnemyImage().getHeight();
        int imageWidth = getEnemyImage().getWidth();
        return new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
    }

    public void faceRight(){
        facingRight = true;
    }

    public void faceLeft(){
        facingRight = false;
    }

    public int getxCoord(){
        return (int) xCoord;
    }

    public int getyCoord(){
        return (int) yCoord;
    }

    public void move(){
        if (getxCoord() != 368 && getyCoord() != 300) {
            xCoord += MOVE_AMT;
        }
        if (getxCoord() == 368 && getyCoord() != 300){
            yCoord -= MOVE_AMT;
        }
        if (getyCoord() == 300 && getxCoord() != 332){
            faceLeft();
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 332 && getyCoord() != 220){
            yCoord -= MOVE_AMT;
        }
        if (getyCoord() == 220 && getxCoord() != 263){
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 263 && getyCoord() != 159){
            yCoord -= MOVE_AMT;
        }
        if (getyCoord() == 159 && getxCoord() != 191){
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 191 && getyCoord() != 79){
            yCoord -= MOVE_AMT;
        }
        if (getyCoord() == 79 && getxCoord() != 71){
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 71 && getyCoord() != 215){
            yCoord += MOVE_AMT;
        }
        if (getyCoord() == 215 && getxCoord() != 185){
            faceRight();
            xCoord += MOVE_AMT;
        }
        if (getxCoord() == 185 && getyCoord() != 346){
            yCoord += MOVE_AMT;
        }
        if (getyCoord() == 346 && getxCoord() != 70){
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 70){
            xCoord = 659;
        }
        if (getxCoord() == 659 && getxCoord() != 484){
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 484 && getyCoord() != 280){
            yCoord -= MOVE_AMT;
        }
        if (getyCoord() == 280 && getxCoord() != 368){
            xCoord -= MOVE_AMT;
        }
    }
}