import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class GraphicsPanel extends JPanel implements KeyListener, MouseListener{
    private BufferedImage background0;
    private BufferedImage background;
    private Player player;
    private final orangeGhost orangeGhost1;
    private final blueGhost blueGhost1;
    private final pinkGhost pinkGhost1;
    private final redGhost redGhost1;
    private boolean[] pressedKeys;
    private boolean wakaPlaying;
    private Clip wakaSound;
    private boolean move;

    public GraphicsPanel(){
        try {
            background0 = ImageIO.read(new File("src/background0.png"));
            background = ImageIO.read(new File("src/PacmanStage.png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        move = true;
        player = new Player("src/pacmanleft.png","src/pacmanright.png","src/pacmanup.png","src/pacmandown.png");
        orangeGhost1 = new orangeGhost("src/orangeghostleft.png","src/orangeghostright.png",322,340);
        blueGhost1 = new blueGhost("src/blueghostleft.png","src/blueghostright.png",347,340);
        pinkGhost1 = new pinkGhost("src/pinkghostleft.png","src/pinkghostright.png",389,340);
        redGhost1 = new redGhost("src/redghostleft.png","src/redghostright.png",430,340);
        wakaPlaying = false;
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    private void playWaka(){
        if (wakaPlaying){
            return;
        }
        try {
            AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File("src/Waka.wav").getAbsoluteFile());
            wakaSound = AudioSystem.getClip();
            wakaSound.open(audioinputstream);
            wakaSound.loop(Clip.LOOP_CONTINUOUSLY);
            wakaSound.start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void paintComponent(Graphics g){
        if (player.balls.isEmpty()){
            player.increaseRounds();
            player.addBalls();
            player.xCoord = 70;
            player.yCoord = 70;
        }
        super.paintComponent(g);
        g.drawImage(background0,0,0,null);
        g.drawImage(background,40,50,null);
        g.drawImage(player.getPlayerImage(),player.getxCoord(),player.getyCoord(),null);
        g.drawImage(orangeGhost1.getEnemyImage(),orangeGhost1.getxCoord(),orangeGhost1.getyCoord(),null);
        g.drawImage(blueGhost1.getEnemyImage(),blueGhost1.getxCoord(),blueGhost1.getyCoord(),null);
        g.drawImage(pinkGhost1.getEnemyImage(),pinkGhost1.getxCoord(),pinkGhost1.getyCoord(),null);
        g.drawImage(redGhost1.getEnemyImage(),redGhost1.getxCoord(),redGhost1.getyCoord(),null);
        if (orangeGhost1.enemyRect().intersects(player.playerRect()) ||
        blueGhost1.enemyRect().intersects(player.playerRect()) ||
        pinkGhost1.enemyRect().intersects(player.playerRect()) ||
        redGhost1.enemyRect().intersects(player.playerRect())){
            player.xCoord = 70;
            player.yCoord = 70;
            player.lives--;
        }
        if (player.getyCoord() >= 340 && player.getyCoord() <= 370 && player.getxCoord() <= 70){
            player.xCoord = 660;
        }
        if (player.getyCoord() >= 340 && player.getyCoord() <= 370 && player.getxCoord() >= 665){
            player.xCoord = 80;
        }
        for (int i = 0; i < player.balls.size(); i++){
            Ball ball = player.balls.get(i);
            g.drawImage(ball.getImage(),ball.getxCoord(),ball.getyCoord(),null);
            if (player.playerRect().intersects(ball.ballRect())){
                player.collectBall();
                player.balls.remove(i);
                i--;
            }
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Score: " + player.getScore(), 20, 30);
        g.drawString("X: " + player.getxCoord(), 550, 30);
        g.drawString("Y: " + player.getyCoord(), 650,30);
        g.drawString("Lives: " + player.getLives(), 150, 30);
        g.drawString("Rounds: " + player.getRounds(), 300,30);
        if (move){
            orangeGhost1.move();
            blueGhost1.move();
            pinkGhost1.move();
            redGhost1.move();
            if (pressedKeys[87]){ //Up (W Key)
                player.faceUp();
                player.moveUp();
                playWaka();
                wakaPlaying = true;
            }

            if (pressedKeys[65]){  //Left (A Key)
                player.faceLeft();
                player.moveLeft();
                playWaka();
                wakaPlaying = true;
            }

            if (pressedKeys[83]){ //Right (S Key)
                player.faceDown();
                player.moveDown();
                playWaka();
                wakaPlaying = true;

            }
            if (pressedKeys[68]){  //Down (D Key)
                player.faceRight();
                player.moveRight();
                playWaka();
                wakaPlaying = true;
            }
            if (pressedKeys[32] && !move){
                move = true;
            }
            if (pressedKeys[32]){
                move = false;
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("PAUSED", 350, 440);
            }
        }
    }

    public void keyTyped(KeyEvent e) {} // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        // A = 65, D = 68, S = 83, W = 87, left = 37, up = 38, right = 39, down = 40, space = 32, enter = 10
        if (move){
            int key = e.getKeyCode();
            pressedKeys[key] = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 32){
            return;
        }
        pressedKeys[key] = false;
        wakaSound.close();
        wakaPlaying = false;
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented; if you move your mouse while clicking,
    // this method isn't called, so mouseReleased is best

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
       // if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
       //     Point mouseClickLocation = e.getPoint();
       //     Ball ball = new Ball(mouseClickLocation.x, mouseClickLocation.y);
       //     balls.add(ball);
       // }
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

}
