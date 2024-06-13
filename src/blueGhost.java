import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class blueGhost {
    public double moveAmt = 0.15;
    public double xCoord;
    public double yCoord;
    private BufferedImage leftImg;
    private BufferedImage rightImg;
    private BufferedImage scaredImg;
    public boolean scared;
    private boolean facingRight;
    private boolean moveX;
    private boolean moveY;

    public blueGhost(String leftImg, String rightImg, String scaredImg, int xCoord, int yCoord){
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
            xCoord += moveAmt;
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
        if (getyCoord() == 295 && getxCoord() != 408 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 408){
                moveX = false;
            }
        }
        if (getyCoord() == 295){
            moveY = true;
        }
        if (getxCoord() == 408 && getyCoord() != 220 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 220){
                moveY = false;
            }
        }
        if (getxCoord() == 408){
            moveX = true;
        }
        if (getyCoord() == 220 && getxCoord() != 476 && moveX){
            xCoord -= moveAmt;
            if (getxCoord() == 476){
                moveX = false;
            }
        }
        if (getyCoord() == 220){
            moveY = true;
        }
        if (getxCoord() == 476 && getyCoord() != 159 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 159){
                moveY = false;
            }
        }
        if (getxCoord() == 476){
            moveX = true;
        }
        if (getyCoord() == 159 && getxCoord() != 549 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 549){
                moveX = false;
            }
        }
        if (getyCoord() == 159){
            moveY = true;
        }
        if (getxCoord() == 549 && getyCoord() != 79 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 79){
                moveY = false;
            }
        }
        if (getxCoord() == 549){
            moveX = true;
        }
        if (getyCoord() == 79 && getxCoord() != 669 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 669){
                moveX = false;
            }
        }
        if (getyCoord() == 79){
            moveY = true;
        }
        if (getxCoord() == 669 && getyCoord() != 215 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 215){
                moveY = false;
            }
        }
        if (getxCoord() == 669){
            moveX = true;
        }
        if (getyCoord() == 215 && getxCoord() != 557 && moveX){
            faceLeft();
            xCoord -= moveAmt;
            if (getxCoord() == 557){
                moveX = false;
            }
        }
        if (getyCoord() == 215){
            moveY = true;
        }
        if (getxCoord() == 557 && getyCoord() != 346 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 346){
                moveY = false;
            }
        }
        if (getxCoord() == 557){
            moveX = true;
        }
        if (getyCoord() == 346 && getxCoord() != 659 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 659){
                xCoord = 70;
            }
        }
        if (getyCoord() == 346 && getxCoord() != 261 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 261){
                moveX = false;
            }
        }
        if (getyCoord() == 346){
            moveY = true;
        }
        if (getxCoord() == 261 && getyCoord() != 280 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 280){
                moveY = false;
            }
        }
        if (getxCoord() == 261){
            moveX = true;
        }
        if (getyCoord() == 280 && getxCoord() != 368 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 368){
                moveX = false;
            }
        }
    }
}