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
public class GraphicsPanel extends JPanel implements KeyListener{
    private BufferedImage background0;
    private BufferedImage background;
    private Player player;
    private final orangeGhost orangeGhost1;
    private final blueGhost blueGhost1;
    private final pinkGhost pinkGhost1;
    private final redGhost redGhost1;
    private boolean[] pressedKeys;
    private boolean wakaPlaying;
    private boolean deathPlaying;
    private boolean fruitPlaying;
    private boolean ghost1Playing;
    private boolean ghost2Playing;
    private boolean powerUpPlaying;
    private Clip wakaSound;
    private Clip deathSound;
    private Clip fruitSound;
    private Clip ghostSound1;
    private Clip ghostSound2;
    private Clip powerUp;
    private Clip eaten;
    private boolean move;
    private boolean gamePaused;
    private int count;

    public GraphicsPanel(){
        try {
            background0 = ImageIO.read(new File("src/background0.png"));
            background = ImageIO.read(new File("src/PacmanStage.png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        count = 1;
        powerUpPlaying = false;
        ghost1Playing = false;
        ghost2Playing = false;
        gamePaused = false;
        move = true;
        player = new Player("src/pacmanleft.png","src/pacmanright.png","src/pacmanup.png","src/pacmandown.png");
        orangeGhost1 = new orangeGhost("src/orangeghostleft.png","src/orangeghostright.png","src/scaredghost.png",322,340);
        blueGhost1 = new blueGhost("src/blueghostleft.png","src/blueghostright.png","src/scaredghost.png",347,340);
        pinkGhost1 = new pinkGhost("src/pinkghostleft.png","src/pinkghostright.png","src/scaredghost.png",389,340);
        redGhost1 = new redGhost("src/redghostleft.png","src/redghostright.png","src/scaredghost.png",430,340);
        deathPlaying = false;
        wakaPlaying = false;
        fruitPlaying = false;
        pressedKeys = new boolean[128];
        addKeyListener(this);
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

    private void playDeath(){
        if (deathPlaying){
            return;
        }
        try {
            AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File("src/Death.wav").getAbsoluteFile());
            deathSound = AudioSystem.getClip();
            deathSound.open(audioinputstream);
            deathSound.start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void playFruit(){
        if (fruitPlaying){
            return;
        }
        try {
            AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File("src/Fruit.wav").getAbsoluteFile());
            fruitSound = AudioSystem.getClip();
            fruitSound.open(audioinputstream);
            fruitSound.start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void playGhostSound(){
        if (ghost1Playing && player.balls.size() > 33 || ghost2Playing && player.balls.size() <= 33){
            return;
        }
        if (orangeGhost1.scared || blueGhost1.scared || pinkGhost1.scared || redGhost1.scared || powerUpPlaying){
            if (ghost1Playing){
                ghost1Playing = false;
                ghostSound1.stop();
            }
            else if (ghost2Playing){
                ghost2Playing = false;
                ghostSound2.stop();
            }
        }
        if (player.balls.size() > 33) {
            ghost2Playing = false;
            if (player.getRounds() > 0 ){
                ghostSound2.stop();
            }
            redGhost1.moveAmt = 0.175;
            orangeGhost1.moveAmt = 0.175;
            blueGhost1.moveAmt = 0.15;
            pinkGhost1.moveAmt = 0.15;
            ghost1Playing = true;
            try {
                AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File("src/Ghost1.wav").getAbsoluteFile());
                ghostSound1 = AudioSystem.getClip();
                ghostSound1.open(audioinputstream);
                ghostSound1.start();
                ghostSound1.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else {
            redGhost1.moveAmt = 0.2;
            orangeGhost1.moveAmt = 0.175;
            blueGhost1.moveAmt = 0.15;
            pinkGhost1.moveAmt = 0.15;
            ghost1Playing = false;
            ghost2Playing = true;
            ghostSound1.stop();
            try {
                AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File("src/Ghost2.wav").getAbsoluteFile());
                ghostSound2 = AudioSystem.getClip();
                ghostSound2.open(audioinputstream);
                ghostSound2.start();
                ghostSound2.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void playPowerUp(){
        if (powerUpPlaying){
            return;
        }
        if (orangeGhost1.scared || pinkGhost1.scared || blueGhost1.scared || redGhost1.scared){
            powerUpPlaying = true;
            try {
                AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File("src/Powerup.wav").getAbsoluteFile());
                powerUp = AudioSystem.getClip();
                powerUp.open(audioinputstream);
                powerUp.start();
                powerUp.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        playGhostSound();
        if (player.getLives() == 0){
            playDeath();
            deathPlaying = true;
            gamePaused = true;
            move = false;
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER!",350,440);;
        }
        if (player.balls.isEmpty()){
            player.increaseRounds();
            player.addBalls();
            player.addPinkBalls();
            player.xCoord = 70;
            player.yCoord = 70;
        }
        g.drawImage(background0,0,0,null);
        g.drawImage(background,40,50,null);
        g.drawImage(player.getPlayerImage(),player.getxCoord(),player.getyCoord(),null);
        g.drawImage(orangeGhost1.getEnemyImage(),orangeGhost1.getxCoord(),orangeGhost1.getyCoord(),null);
        g.drawImage(blueGhost1.getEnemyImage(),blueGhost1.getxCoord(),blueGhost1.getyCoord(),null);
        g.drawImage(pinkGhost1.getEnemyImage(),pinkGhost1.getxCoord(),pinkGhost1.getyCoord(),null);
        g.drawImage(redGhost1.getEnemyImage(),redGhost1.getxCoord(),redGhost1.getyCoord(),null);
        if (orangeGhost1.enemyRect().intersects(player.playerRect()) && !(orangeGhost1.scared)||
        blueGhost1.enemyRect().intersects(player.playerRect()) && !(blueGhost1.scared)||
        pinkGhost1.enemyRect().intersects(player.playerRect()) && !(pinkGhost1.scared)||
        redGhost1.enemyRect().intersects(player.playerRect()) && !(redGhost1.scared)){
            player.xCoord = 70;
            player.yCoord = 70;
            player.lives--;
        }
        if (orangeGhost1.enemyRect().intersects(player.playerRect()) && orangeGhost1.scared){
            player.collectGhost();
            orangeGhost1.scared = false;
            orangeGhost1.xCoord = 322;
            orangeGhost1.yCoord = 340;
        }
        if (blueGhost1.enemyRect().intersects(player.playerRect()) && blueGhost1.scared){
            player.collectGhost();
            blueGhost1.scared = false;
            blueGhost1.xCoord = 347;
            blueGhost1.yCoord = 340;
        }
        if (pinkGhost1.enemyRect().intersects(player.playerRect()) && pinkGhost1.scared){
            player.collectGhost();
            pinkGhost1.scared = false;
            pinkGhost1.xCoord = 389;
            pinkGhost1.yCoord = 340;
        }
        if (redGhost1.enemyRect().intersects(player.playerRect()) && redGhost1.scared){
            player.collectGhost();
            redGhost1.scared = false;
            redGhost1.xCoord = 430;
            redGhost1.yCoord = 340;
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
                playFruit();
                player.collectBall();
                player.balls.remove(i);
                i--;
            }
        }
        for (int i = 0; i < player.pinkBalls.size(); i++){
            Ball pinkBall = player.pinkBalls.get(i);
            g.drawImage(pinkBall.getImage(),pinkBall.getxCoord(),pinkBall.getyCoord(),null);
            if (player.playerRect().intersects(pinkBall.ballRect())){
                orangeGhost1.scared = true;
                pinkGhost1.scared = true;
                blueGhost1.scared = true;
                redGhost1.scared = true;
                player.collectBall();
                player.pinkBalls.remove(i);
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
        if (move && !gamePaused){
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
                gamePaused = false;
                move = true;
                count++;
            }
            if (pressedKeys[32] && count % 2 != 0){
                gamePaused = true;
                move = false;
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("PAUSED", 350, 440);
                count++;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        // A = 65, D = 68, S = 83, W = 87, left = 37, up = 38, right = 39, down = 40, space = 32, enter = 10
        if (move || pressedKeys[32]){
            int key = e.getKeyCode();
            pressedKeys[key] = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (move){
            int key = e.getKeyCode();
            pressedKeys[key] = false;
            wakaSound.close();
            wakaPlaying = false;
        }
    }
    public void keyTyped(KeyEvent e) {} // unimplemented
}
