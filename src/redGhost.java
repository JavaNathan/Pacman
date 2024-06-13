import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class redGhost {
    public double moveAmt = 0.175;
    public double xCoord;
    public double yCoord;
    private BufferedImage leftImg;
    private BufferedImage rightImg;
    private BufferedImage scaredImg;
    public boolean scared;
    private boolean facingRight;
    private boolean moveX;
    private boolean moveY;

    public redGhost(String leftImg, String rightImg, String scaredImg, int xCoord, int yCoord){
        scared = false;
        moveX = true;
        moveY = false;
        facingRight = true;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        try {
            this.scaredImg = ImageIO.read(new File(scaredImg));
            this.leftImg = ImageIO.read(new File(leftImg));
            this.rightImg = ImageIO.read(new File(rightImg));
        } catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public BufferedImage getEnemyImage(){
        if (scared){
            return scaredImg;
        }
        else if (facingRight){
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
            xCoord -= moveAmt;
            if (getxCoord() == 368){
                moveX = false;
            }
        }
        if (getyCoord() == 340){
            moveY = true;
        }
        if (getxCoord() == 368 && getyCoord() != 295 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 295){
                moveY = false;
            }
        }
        if (getxCoord() == 368){
            moveX = true;
        }
        if (getyCoord() == 295 && getxCoord() != 476 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 476){
                moveX = false;
            }
        }
        if (getyCoord() == 295){
            moveY = true;
        }
        if (getxCoord() == 476 && getyCoord() != 348 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 348){
                moveY = false;
            }
        }
        if (getxCoord() == 476){
            moveX = true;
        }
        if (getyCoord() == 348 && getxCoord() != 659 && moveX){
            xCoord += moveAmt;
        }
        if (getxCoord() == 659){
            xCoord = 70;
        }
        if (getxCoord() != 187 && getyCoord() == 348 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 187){
                moveX = false;
            }
        }
        if (getyCoord() == 348){
            moveY = true;
        }
        if (getyCoord() != 534 && getxCoord() == 187 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 534){
                moveY = false;
            }
        }
        if (getxCoord() == 187){
            moveX = true;
        }
        if (getxCoord() != 336 && getyCoord() == 534 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 336){
                moveX = false;
            }
        }
        if (getyCoord() == 534){
            moveY = true;
        }
        if (getyCoord() != 481 && getxCoord() == 336 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 481){
                moveY = false;
            }
        }
        if (getxCoord() == 336){
            moveX = true;
        }
        if (getxCoord() != 263 && getyCoord() == 481 && moveX){
            faceLeft();
            xCoord -= moveAmt;
            if (getxCoord() == 263){
                moveX = false;
            }
        }
        if (getyCoord() == 481){
            moveY = true;
        }
        if (getyCoord() != 295 && getxCoord() == 263 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 295){
                moveY = false;
            }
        }
        if (getxCoord() == 263){
            moveX = true;
        }
        if (getxCoord() != 476 && getyCoord() == 295 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 476){
                moveX = false;
            }
        }
    }
}