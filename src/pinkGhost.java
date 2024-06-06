import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class pinkGhost {
    private final double MOVE_AMT = 0.2;
    public double xCoord;
    public double yCoord;
    private BufferedImage leftImg;
    private BufferedImage rightImg;
    private boolean facingRight;
    private boolean moveX;
    private boolean moveY;

    public pinkGhost(String leftImg, String rightImg, int xCoord, int yCoord){
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
        if (getxCoord() != 368 && getyCoord() == 340 && moveX){
            xCoord -= MOVE_AMT;
            if (getxCoord() == 368){
                moveX = false;
            }
        }
        if (getyCoord() == 340){
            moveY = true;
        }
        if (getxCoord() == 368 && getyCoord() != 295 && moveY){
            yCoord -= MOVE_AMT;
            if (getyCoord() == 295){
                moveY = false;
            }
        }
        if (getxCoord() == 368){
            moveX = true;
        }
        if (getyCoord() == 295 && getxCoord() != 332 && moveX){
            faceLeft();
            xCoord -= MOVE_AMT;
            if (getxCoord() == 332){
                moveX = false;
            }
        }
        if (getyCoord() == 295){
            moveY = true;
        }
        if (getxCoord() == 332 && getyCoord() != 220 && moveY){
            yCoord -= MOVE_AMT;
            if (getyCoord() == 220){
                moveY = false;
            }
        }
        if (getxCoord() == 332){
            moveX = true;
        }
        if (getyCoord() == 220 && getxCoord() != 263 && moveX){
            xCoord -= MOVE_AMT;
            if (getxCoord() == 263){
                moveX = false;
            }
        }
        if (getyCoord() == 220){
            moveY = true;
        }
        if (getxCoord() == 263 && getyCoord() != 159 && moveY){
            yCoord -= MOVE_AMT;
            if (getyCoord() == 159){
                moveY = false;
            }
        }
        if (getxCoord() == 263){
            moveX = true;
        }
        if (getyCoord() == 159 && getxCoord() != 191 && moveX){
            xCoord -= MOVE_AMT;
            if (getxCoord() == 191){
                moveX = false;
            }
        }
        if (getyCoord() == 159){
            moveY = true;
        }
        if (getxCoord() == 191 && getyCoord() != 79 && moveY){
            yCoord -= MOVE_AMT;
            if (getyCoord() == 79){
                moveY = false;
            }
        }
        if (getxCoord() == 191){
            moveX = true;
        }
        if (getyCoord() == 79 && getxCoord() != 71 && moveX){
            xCoord -= MOVE_AMT;
            if (getxCoord() == 71){
                moveX = false;
            }
        }
        if (getyCoord() == 79){
            moveY = true;
        }
        if (getxCoord() == 71 && getyCoord() != 215 && moveY){
            yCoord += MOVE_AMT;
            if (getyCoord() == 215){
                moveY = false;
            }
        }
        if (getxCoord() == 71){
            moveX = true;
        }
        if (getyCoord() == 215 && getxCoord() != 185 && moveX){
            faceRight();
            xCoord += MOVE_AMT;
            if (getxCoord() == 185){
                moveX = false;
            }
        }
        if (getyCoord() == 215){
            moveY = true;
        }
        if (getxCoord() == 185 && getyCoord() != 346 && moveY){
            yCoord += MOVE_AMT;
            if (getyCoord() == 346){
                moveY = false;
            }
        }
        if (getxCoord() == 185){
            moveX = true;
        }
        if (getyCoord() == 346 && getxCoord() != 70 && moveX){
            xCoord -= MOVE_AMT;
        }
        if (getxCoord() == 70){
            xCoord = 659;
        }
        if (getyCoord() == 346 && getxCoord() != 484 && moveX){
            xCoord -= MOVE_AMT;
            if (getxCoord() == 484){
                moveX = false;
            }
        }
        if (getyCoord() == 346){
            moveY = true;
        }
        if (getxCoord() == 484 && getyCoord() != 280 && moveY){
            yCoord -= MOVE_AMT;
            if (getyCoord() == 280){
                moveY = false;
            }
        }
        if (getxCoord() == 484){
            moveX = true;
        }
        if (getyCoord() == 280 && getxCoord() != 368 && moveX){
            xCoord -= MOVE_AMT;
            if (getxCoord() == 368){
                moveX = false;
            }
        }
    }
}