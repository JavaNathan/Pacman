import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class pinkGhost {
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

    public pinkGhost(String leftImg, String rightImg, String scaredImg, int xCoord, int yCoord){
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
        if (getyCoord() == 295 && getxCoord() != 265 && moveX){
            faceLeft();
            xCoord -= moveAmt;
            if (getxCoord() == 265){
                moveX = false;
            }
        }
        if (getyCoord() == 295){
            moveY = true;
        }
        if (getxCoord() == 265 && getyCoord() != 346 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 346){
                moveY = false;
            }
        }
        if (getxCoord() == 265){
            moveX = true;
        }
        if (getyCoord() == 346 && getxCoord() != 70 && moveX){
            xCoord -= moveAmt;
        }
        if (getxCoord() == 70){
            xCoord = 659;
        }
        if (getyCoord() == 346 && getxCoord() != 554 && moveX){
            xCoord -= moveAmt;
            if (getxCoord() == 554){
                moveX = false;
            }
        }
        if (getyCoord() == 346){
            moveY = true;
        }
        if (getxCoord() == 554 && getyCoord() != 594 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 594){
                moveY = false;
            }
        }
        if (getxCoord() == 554){
            moveX = true;
        }
        if (getyCoord() == 594 && getxCoord() != 669 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 669){
                moveX = false;
            }
        }
        if (getyCoord() == 594){
            moveY = true;
        }
        if (getxCoord() == 669 && getyCoord() != 661 && moveY){
            yCoord += moveAmt;
            if (getyCoord() == 661){
                moveY = false;
            }
        }
        if (getxCoord() == 669){
            moveX = true;
        }
        if (getyCoord() == 661 && getxCoord() != 409 && moveX){
            xCoord -= moveAmt;
            if (getxCoord() == 409){
                moveX = false;
            }
        }
        if (getyCoord() == 661){
            moveY = true;
        }
        if (getxCoord() == 409 && getyCoord() != 600 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 600){
                moveY = false;
            }
        }
        if (getxCoord() == 409){
            moveX = true;
        }
        if (getyCoord() == 600 && getxCoord() != 479 && moveX){
            faceRight();
            xCoord += moveAmt;
            if (getxCoord() == 479){
                moveX = false;
            }
        }
        if (getyCoord() == 600){
            moveY = true;
        }
        if (getxCoord() == 479 && getyCoord() != 538 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 538){
                moveY = false;
            }
        }
        if (getxCoord() == 479){
            moveX = true;
        }
        if (getyCoord() == 538 && getxCoord() != 407 && moveX){
            xCoord -= moveAmt;
            if (xCoord == 407){
                moveX = false;
            }
        }
        if (getyCoord() == 538){
            moveY = true;
        }
        if (getyCoord() != 481 && getxCoord() == 407 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 481){
                moveY = false;
            }
        }
        if (getxCoord() == 407){
            moveX = true;
        }
        if (getxCoord() != 480 && getyCoord() == 481 && moveX){
            xCoord += moveAmt;
            if (getxCoord() == 480){
                moveX = false;
            }
        }
        if (getyCoord() == 481){
            moveY = true;
        }
        if (getyCoord() != 295 && getxCoord() == 480 && moveY){
            yCoord -= moveAmt;
            if (getyCoord() == 295){
                moveY = false;
            }
        }
        if (getxCoord() == 480){
            moveX = true;
        }
        if (getxCoord() != 265 && getyCoord() == 295 && moveX){
            xCoord -= moveAmt;
            if (getxCoord() == 265){
                moveX = false;
            }
        }
    }
}