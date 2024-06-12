import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Ball {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Ball(int x, int y, String image){
        xCoord = x;
        yCoord = y;
        try {
            this.image = ImageIO.read(new File(image));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord(){
        return xCoord;
    }

    public int getyCoord(){
        return yCoord;
    }

    public BufferedImage getImage(){
        return image;
    }

    public Rectangle ballRect(){
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
