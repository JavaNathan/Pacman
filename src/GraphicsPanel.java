import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class GraphicsPanel extends JPanel implements KeyListener, MouseListener{
    private BufferedImage background;
    private Player player;
    private boolean[] pressedKeys;
    private ArrayList<Ball> balls;

    public GraphicsPanel(){
        try {
            background = ImageIO.read(new File("src/PacmanStage.png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        player = new Player("src/pacmanleft.png","src/pacmanright.png","src/pacmanup.png","src/pacmandown.png");
        balls = new ArrayList<>();
        Ball ball1 = new Ball(110,80);
        balls.add(ball1);
        Ball ball2 = new Ball(180,80);
        balls.add(ball2);
        Ball ball3 = new Ball(260,80);
        balls.add(ball3);
        Ball ball4 = new Ball(330,80);
        balls.add(ball4);
        Ball ball5 = new Ball(70,160);
        balls.add(ball5);
        Ball ball6 = new Ball(70, 230);
        balls.add(ball6);
        Ball ball7 = new Ball(180,160);
        balls.add(ball7);
        Ball ball8 = new Ball(180,230);
        balls.add(ball8);
        Ball ball9 = new Ball(280, 160);
        balls.add(ball9);
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,40,50,null);
        g.drawImage(player.getPlayerImage(),player.getxCoord(),player.getyCoord(),null);
        for (int i = 0; i < balls.size(); i++){
            Ball ball = balls.get(i);
            g.drawImage(ball.getImage(),ball.getxCoord(),ball.getyCoord(),null);
            if (player.playerRect().intersects(ball.ballRect())){
                player.collectBall();
                balls.remove(i);
                i--;
            }
        }

        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Score: " + player.getScore(), 20, 30);

        if (pressedKeys[87]){ //Up (W Key)
            player.faceUp();
            player.moveUp();
        }

        if (pressedKeys[65]){  //Left (A Key)
            player.faceLeft();
            player.moveLeft();
        }

        if (pressedKeys[83]){ //Right (S Key)
            player.faceDown();
            player.moveDown();
        }
        if (pressedKeys[68]){  //Down (D Key)
            player.faceRight();
            player.moveRight();
        }
    }

    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        // A = 65, D = 68, S = 83, W = 87, left = 37, up = 38, right = 39, down = 40, space = 32, enter = 10
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented; if you move your mouse while clicking,
    // this method isn't called, so mouseReleased is best

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            Point mouseClickLocation = e.getPoint();
            Ball ball = new Ball(mouseClickLocation.x, mouseClickLocation.y);
            balls.add(ball);
        }
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

}
