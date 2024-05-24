import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Player {
    private final double MOVE_AMT = 0.2;
    private BufferedImage right;
    private BufferedImage left;
    private BufferedImage up;
    private BufferedImage down;
    private boolean facingRight;
    private boolean facingUp;
    private boolean facingDown;
    public double xCoord;
    private double yCoord;
    private int score;

    public Player(String leftImg, String rightImg, String upImg, String downImg){
        facingRight = true;
        facingUp = false;
        facingDown = false;
        xCoord = 70;
        yCoord = 70;
        score = 0;
        try {
            left = ImageIO.read(new File(leftImg));
            right = ImageIO.read(new File(rightImg));
            up = ImageIO.read(new File(upImg));
            down = ImageIO.read(new File(downImg));

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord(){
        return (int) xCoord;
    }

    public int getyCoord(){
        return (int) yCoord;
    }

    public int getScore(){
        return score;
    }

    public void faceRight(){
        facingRight = true;
        facingUp = false;
        facingDown = false;
    }

    public void faceLeft(){
        facingRight = false;
        facingUp = false;
        facingDown = false;
    }
    public void faceUp(){
        facingUp = true;
        facingRight = false;
        facingDown = false;
    }

    public void faceDown(){
        facingDown = true;
        facingUp = false;
        facingRight = false;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 670) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 70 &&
        !(xCoord <= 179 && xCoord >= 183 && yCoord >= 246 && yCoord <= 322) &&
        !(xCoord <= 189 && xCoord >= 183 && yCoord >= 370 && yCoord <= 450)) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 70 &&
        !(yCoord <= 348 && yCoord >= 335 && xCoord >= 70 && xCoord <= 170) &&
        !(yCoord <= 472 && yCoord >= 467 && xCoord >= 70 && xCoord <= 170)) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 670 &&
        !(xCoord >= 70 && xCoord <= 160 && yCoord >= 223 && yCoord <= 256)) {
            yCoord += MOVE_AMT;
        }
    }

    public void collectBall(){
        score++;
    }
    public BufferedImage getPlayerImage() {
        if (facingRight) {
            return right;
        }
        else if (facingUp){
            return up;
        }
        else if (facingDown){
            return down;
        }
        else {
            return left;
        }
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
