import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class GraphicsPanel extends JPanel implements KeyListener, MouseListener{
    private final double MOVE_AMT = 0.1;
    private BufferedImage background;
    private Player player;
    private orangeGhost orangeGhost1;
    private blueGhost blueGhost1;
    private pinkGhost pinkGhost1;
    private redGhost redGhost1;
    private boolean[] pressedKeys;
    private boolean wakaPlaying;
    private ArrayList<Ball> balls;
    private Clip wakaSound;
    private boolean moveX;
    private boolean moveY;

    public GraphicsPanel(){
        try {
            background = ImageIO.read(new File("src/PacmanStage.png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        moveX = true;
        moveY = false;
        player = new Player("src/pacmanleft.png","src/pacmanright.png","src/pacmanup.png","src/pacmandown.png");
        orangeGhost1 = new orangeGhost("src/orangeghostleft.png","src/orangeghostright.png",322,340);
        blueGhost1 = new blueGhost("src/blueghostleft.png","src/blueghostright.png",347,340);
        pinkGhost1 = new pinkGhost("src/pinkghostleft.png","src/pinkghostright.png",389,340);
        redGhost1 = new redGhost("src/redghostleft.png","src/redghostright.png",430,340);
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
        Ball ball10 = new Ball(280,230);
        balls.add(ball10);
        Ball ball11 = new Ball(380,160);
        balls.add(ball11);
        Ball ball12 = new Ball(480,160);
        balls.add(ball12);
        Ball ball13 = new Ball(580,160);
        balls.add(ball13);
        Ball ball14 = new Ball(680,160);
        balls.add(ball14);
        Ball ball15 = new Ball(400,80);
        balls.add(ball15);
        Ball ball16 = new Ball(470, 80);
        balls.add(ball16);
        Ball ball17 = new Ball(540, 80);
        balls.add(ball17);
        Ball ball18 = new Ball(610, 80);
        balls.add(ball18);
        Ball ball19 = new Ball(680, 80);
        balls.add(ball19);
        Ball ball20 = new Ball(450,230);
        balls.add(ball20);
        Ball ball21 = new Ball(550, 230);
        balls.add(ball21);
        Ball ball22 = new Ball(660,230);
        balls.add(ball22);
        Ball ball23 = new Ball(180,300);
        balls.add(ball23);
        Ball ball24 = new Ball(180, 360);
        balls.add(ball24);
        Ball ball25 = new Ball(180,420);
        balls.add(ball25);
        Ball ball26 = new Ball(180,480);
        balls.add(ball26);
        Ball ball27 = new Ball(180,540);
        balls.add(ball27);
        Ball ball28 = new Ball(180,600);
        balls.add(ball28);
        Ball ball29 = new Ball(180,670);
        balls.add(ball29);
        Ball ball30 = new Ball(60,670);
        balls.add(ball30);
        Ball ball31 = new Ball(120,670);
        balls.add(ball31);
        Ball ball32 = new Ball(240,670);
        balls.add(ball32);
        Ball ball33 = new Ball(300,670);
        balls.add(ball33);
        Ball ball34 = new Ball(360,670);
        balls.add(ball34);
        Ball ball35 = new Ball(420,670);
        balls.add(ball35);
        Ball ball36 = new Ball(480,670);
        balls.add(ball36);
        Ball ball37 = new Ball(540,670);
        balls.add(ball37);
        Ball ball38 = new Ball(600,670);
        balls.add(ball38);
        Ball ball39 = new Ball(660,670);
        balls.add(ball39);
        Ball ball40 = new Ball(70,600);
        balls.add(ball40);
        Ball ball41 = new Ball(280,600);
        balls.add(ball41);
        Ball ball42 = new Ball(450,600);
        balls.add(ball42);
        Ball ball43 = new Ball(550,600);
        balls.add(ball43);
        Ball ball44 = new Ball(660,600);
        balls.add(ball44);
        Ball ball45 = new Ball(70,540);
        balls.add(ball45);
        Ball ball46 = new Ball(280,540);
        balls.add(ball46);
        Ball ball47 = new Ball(450,540);
        balls.add(ball47);
        Ball ball48 = new Ball(365,540);
        balls.add(ball48);
        Ball ball49 = new Ball(550,540);
        balls.add(ball49);
        Ball ball50 = new Ball(660,540);
        balls.add(ball50);
        Ball ball51 = new Ball(70,480);
        balls.add(ball51);
        Ball ball52 = new Ball(280,480);
        balls.add(ball52);
        Ball ball53 = new Ball(450,480);
        balls.add(ball53);
        Ball ball54 = new Ball(550,480);
        balls.add(ball54);
        Ball ball55 = new Ball(660,480);
        balls.add(ball55);
        Ball ball56 = new Ball(280,420);
        balls.add(ball56);
        Ball ball57 = new Ball(450,420);
        balls.add(ball57);
        Ball ball58 = new Ball(550,420);
        balls.add(ball58);
        Ball ball59 = new Ball(270,360);
        balls.add(ball59);
        Ball ball60 = new Ball(460,360);
        balls.add(ball60);
        Ball ball61 = new Ball(550,360);
        balls.add(ball61);
        Ball ball62 = new Ball(280,300);
        balls.add(ball62);
        Ball ball63 = new Ball(450,300);
        balls.add(ball63);
        Ball ball64 = new Ball(550,300);
        balls.add(ball64);
        Ball ball65 = new Ball(90,360);
        balls.add(ball65);
        Ball ball66 = new Ball(640,360);
        balls.add(ball66);
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
        super.paintComponent(g);
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
        if (orangeGhost1.getxCoord() != 368) {
            orangeGhost1.xCoord += MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 368 && orangeGhost1.getyCoord() != 300){
            orangeGhost1.yCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 300 && orangeGhost1.getxCoord() != 332){
            orangeGhost1.faceLeft();
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 332 && orangeGhost1.getyCoord() != 220){
            orangeGhost1.yCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 220 && orangeGhost1.getxCoord() != 263){
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 263 && orangeGhost1.getyCoord() != 159){
            orangeGhost1.yCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 159 && orangeGhost1.getxCoord() != 191){
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 191 && orangeGhost1.getyCoord() != 79){
            orangeGhost1.yCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 79 && orangeGhost1.getxCoord() != 71){
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 71 && orangeGhost1.getyCoord() != 215){
            orangeGhost1.yCoord += MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 215 && orangeGhost1.getxCoord() != 185){
            orangeGhost1.faceRight();
            orangeGhost1.xCoord += MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 185 && orangeGhost1.getyCoord() != 346){
            orangeGhost1.yCoord += MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 346 && orangeGhost1.getxCoord() != 70){
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 70){
            orangeGhost1.xCoord = 659;
        }
        if (orangeGhost1.getxCoord() == 659 && orangeGhost1.getxCoord() != 484){
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getxCoord() == 484 && orangeGhost1.getyCoord() != 280){
            orangeGhost1.yCoord -= MOVE_AMT;
        }
        if (orangeGhost1.getyCoord() == 280 && orangeGhost1.getxCoord() != 368){
            orangeGhost1.xCoord -= MOVE_AMT;
        }
        if (player.getyCoord() >= 340 && player.getyCoord() <= 370 && player.getxCoord() <= 70){
            player.xCoord = 660;
        }
        if (player.getyCoord() >= 340 && player.getyCoord() <= 370 && player.getxCoord() >= 665){
            player.xCoord = 80;
        }
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
        g.drawString("X-Coordinates: " + player.getxCoord(), 300, 30);
        g.drawString("Y-Coordinates: " + player.getyCoord(), 550,30);
        g.drawString("Lives: " + player.getLives(), 150, 30);

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
        wakaSound.stop();
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
