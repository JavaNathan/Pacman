import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Player {
    private final double MOVE_AMT = 0.2;
    private BufferedImage rightImg;
    private BufferedImage leftImg;
    private BufferedImage upImg;
    private BufferedImage downImg;
    private boolean facingRight;
    private boolean facingUp;
    private boolean facingDown;
    public double xCoord;
    public double yCoord;
    private int score;
    private int rounds;
    public int lives;
    public ArrayList<Ball> balls;
    public ArrayList<Ball> pinkBalls;

    public Player(String leftImg, String rightImg, int xCoord, int yCoord){
        rounds = 0;
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

    public Player(String leftImg, String rightImg, String upImg, String downImg){
        lives = 3;
        facingRight = true;
        facingUp = false;
        facingDown = false;
        xCoord = 70;
        yCoord = 70;
        score = 0;
        balls = new ArrayList<>();
        addBalls();
        try {
            this.leftImg = ImageIO.read(new File(leftImg));
            this.rightImg = ImageIO.read(new File(rightImg));
            this.upImg = ImageIO.read(new File(upImg));
            this.downImg = ImageIO.read(new File(downImg));

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
    public int getLives(){
        return lives;
    }

    public void increaseRounds(){
        rounds++;
    }
    public int getRounds(){
        return rounds;
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
        if (xCoord + MOVE_AMT <= 670 &&
        !(xCoord >= 195 && xCoord <= 205 && yCoord >= 544 && yCoord <= 642) &&
        !(xCoord >= 86 && xCoord <= 96 && yCoord >= 613 && yCoord <= 652) &&
        !(xCoord >= 130 && xCoord <= 140 && yCoord >= 498 && yCoord <= 584) &&
        !(xCoord >= 83 && xCoord <= 93 && yCoord >= 487 && yCoord <= 525) &&
        !(xCoord >= 204 && xCoord <= 214 && yCoord >= 493 && yCoord <= 518) &&
        !(xCoord >= 347 && xCoord <= 357 && yCoord >= 550 && yCoord <= 643) &&
        !(xCoord >= 276 && xCoord <= 286 && yCoord >= 550 && yCoord <= 587) &&
        !(xCoord >= 421 && xCoord <= 431 && yCoord >= 487 && yCoord <= 527) &&
        !(xCoord >= 501 && xCoord <= 511 && yCoord >= 554 && yCoord <= 653) &&
        !(xCoord >= 419 && xCoord <= 429 && yCoord >= 615 && yCoord <= 651) &&
        !(xCoord >= 634 && xCoord <= 644 && yCoord >= 550 && yCoord <= 596) &&
        !(xCoord >= 550 && xCoord <= 560 && yCoord >= 492 && yCoord <= 582) &&
        !(xCoord >= 552 && xCoord <= 570 && yCoord >= 366 && yCoord <= 458) &&
        !(xCoord >= 481 && xCoord <= 491 && yCoord >= 368 && yCoord <= 455) &&
        !(xCoord >= 195 && xCoord <= 205 && yCoord >= 368 && yCoord <= 462) &&
        !(xCoord >= 340 && xCoord <= 361 && yCoord >= 432 && yCoord <= 519) &&
        !(xCoord >= 267 && xCoord <= 277 && yCoord >= 415 && yCoord <= 470) &&
        !(xCoord >= 273 && xCoord <= 283 && yCoord >= 307 && yCoord <= 390) &&
        !(xCoord >= 559 && xCoord <= 579 && yCoord >= 244 && yCoord <= 326) &&
        !(xCoord >= 481 && xCoord <= 501 && yCoord >= 180 && yCoord <= 325) &&
        !(xCoord >= 410 && xCoord <= 430 && yCoord >= 236 && yCoord <= 264) &&
        !(xCoord >= 196 && xCoord <= 216 && yCoord >= 176 && yCoord <= 335) &&
        !(xCoord >= 270 && xCoord <= 280 && yCoord >= 173 && yCoord <= 208) &&
        !(xCoord >= 341 && xCoord <= 351 && yCoord >= 203 && yCoord <= 259) &&
        !(xCoord >= 341 && xCoord <= 351 && yCoord >= 30 && yCoord <= 140) &&
        !(xCoord >= 70 && xCoord <= 90 && yCoord >= 173 && yCoord <= 212) &&
        !(xCoord >= 70 && xCoord <= 90 && yCoord >= 83 && yCoord <= 147) &&
        !(xCoord >= 194 && xCoord <= 204 && yCoord >= 83 && yCoord <= 147) &&
        !(xCoord >= 554 && xCoord <= 564 && yCoord >= 168 && yCoord <= 213) &&
        !(xCoord >= 553 && xCoord <= 563 && yCoord >= 83 && yCoord <= 153) &&
        !(xCoord >= 413 && xCoord <= 423 && yCoord >= 80 && yCoord <= 154)){
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 70 &&
        !(xCoord <= 195 && xCoord >= 185 && yCoord >= 236 && yCoord <= 334) &&
        !(xCoord <= 189 && xCoord >= 179 && yCoord >= 360 && yCoord <= 465) &&
        !(xCoord <= 123 && xCoord >= 110 && yCoord <= 595 && yCoord >= 550) &&
        !(xCoord <= 329 && xCoord >= 319 && yCoord <= 654 && yCoord >= 613) &&
        !(xCoord <= 265 && xCoord >= 255 && yCoord <= 652 && yCoord >= 556) &&
        !(xCoord >= 174 && xCoord <= 184 && yCoord <= 579 && yCoord >= 494) &&
        !(xCoord >= 323 && xCoord <= 333 && yCoord >= 492 && yCoord <= 517) &&
        !(xCoord >= 390 && xCoord <= 400 && yCoord >= 550 && yCoord <= 643) &&
        !(xCoord >= 461 && xCoord <= 471 && yCoord >= 550 && yCoord <= 587) &&
        !(xCoord >= 536 && xCoord <= 546 && yCoord >= 487 && yCoord <= 527) &&
        !(xCoord >= 546 && xCoord <= 556 && yCoord >= 550 && yCoord <= 653) &&
        !(xCoord >= 659 && xCoord <= 669 && yCoord >= 614 && yCoord <= 649) &&
        !(xCoord >= 658 && xCoord <= 668 && yCoord >= 482 && yCoord <= 529) &&
        !(xCoord >= 620 && xCoord <= 630 && yCoord >= 485 && yCoord <= 583) &&
        !(xCoord >= 545 && xCoord <= 555 && yCoord >= 369 && yCoord <= 460) &&
        !(xCoord >= 257 && xCoord <= 267 && yCoord >= 369 && yCoord <= 454) &&
        !(xCoord >= 379 && xCoord <= 397 && yCoord >= 432 && yCoord <= 519) &&
        !(xCoord >= 472 && xCoord <= 482 && yCoord >= 415 && yCoord <= 470) &&
        !(xCoord >= 435 && xCoord <= 470 && yCoord >= 306 && yCoord <= 388) &&
        !(xCoord >= 530 && xCoord <= 540 && yCoord >= 176 && yCoord <= 331) &&
        !(xCoord >= 233 && xCoord <= 253 && yCoord >= 182 && yCoord <= 328) &&
        !(xCoord >= 315 && xCoord <= 325 && yCoord >= 237 && yCoord <= 265) &&
        !(xCoord >= 457 && xCoord <= 467 && yCoord >= 177 && yCoord <= 208) &&
        !(xCoord >= 390 && xCoord <= 400 && yCoord >= 203 && yCoord <= 265) &&
        !(xCoord >= 391 && xCoord <= 401 && yCoord >= 30 && yCoord <= 140) &&
        !(xCoord >= 171 && xCoord <= 181 && yCoord >= 165 && yCoord <= 214) &&
        !(xCoord >= 174 && xCoord <= 184 && yCoord >= 79 && yCoord <= 147) &&
        !(xCoord >= 322 && xCoord <= 332 && yCoord >= 77 && yCoord <= 152) &&
        !(xCoord >= 657 && xCoord <= 667 && yCoord >= 167 && yCoord <= 214) &&
        !(xCoord >= 659 && xCoord <= 669 && yCoord >= 83 && yCoord <= 153) &&
        !(xCoord >= 538 && xCoord <= 548 && yCoord >= 79 && yCoord <= 154)) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 70 &&
        !(yCoord <= 348 && yCoord >= 335 && xCoord >= 70 && xCoord <= 185) &&
        !(yCoord <= 477 && yCoord >= 467 && xCoord >= 70 && xCoord <= 180) &&
        !(yCoord <= 601 && yCoord >= 591 && xCoord >= 70 && xCoord <= 102) &&
        !(yCoord <= 662 && yCoord >= 652 && xCoord >= 92 && xCoord <= 319) &&
        !(yCoord <= 601 && yCoord >= 591 && xCoord >= 143 && xCoord <= 171) &&
        !(yCoord <= 529 && yCoord >= 519 && xCoord >= 96 && xCoord <= 157) &&
        !(yCoord <= 530 && yCoord >= 520 && xCoord >= 209 && xCoord <= 315) &&
        !(yCoord <= 595 && yCoord >= 585 && xCoord >= 283 && xCoord <= 394) &&
        !(yCoord <= 595 && yCoord >= 585 && xCoord >= 345 && xCoord <= 457) &&
        !(yCoord <= 660 && yCoord >= 650 && xCoord >= 353 && xCoord <= 392) &&
        !(yCoord <= 533 && yCoord >= 523 && xCoord >= 428 && xCoord <= 532) &&
        !(yCoord <= 663 && yCoord >= 653 && xCoord >= 430 && xCoord <= 655) &&
        !(yCoord >= 596 && yCoord <= 606 && xCoord >= 640 && xCoord <= 700) &&
        !(yCoord >= 594 && yCoord <= 604 && xCoord >= 565 && xCoord <= 610) &&
        !(yCoord >= 534 && yCoord <= 544 && xCoord >= 565 && xCoord <= 653) &&
        !(yCoord >= 450 && yCoord <= 472 && xCoord >= 570 && xCoord <= 700) &&
        !(yCoord >= 471 && yCoord <= 481 && xCoord >= 502 && xCoord <= 535) &&
        !(yCoord >= 470 && yCoord <= 475 && xCoord >= 205 && xCoord <= 254) &&
        !(yCoord >= 472 && yCoord <= 482 && xCoord >= 282 && xCoord <= 458) &&
        !(yCoord >= 531 && yCoord <= 541 && xCoord >= 352 && xCoord <= 391) &&
        !(yCoord >= 337 && yCoord <= 347 && xCoord >= 565 && xCoord <= 700) &&
        !(yCoord >= 350 && yCoord <= 405 && xCoord >= 283 && xCoord <= 459) &&
        !(yCoord >= 325 && yCoord <= 345 && xCoord >= 500 && xCoord <= 530) &&
        !(yCoord >= 260 && yCoord <= 280 && xCoord >= 431 && xCoord <= 501) &&
        !(yCoord >= 324 && yCoord <= 344 && xCoord >= 209 && xCoord <= 243) &&
        !(yCoord >= 269 && yCoord <= 279 && xCoord >= 237 && xCoord <= 312) &&
        !(yCoord >= 257 && yCoord <= 277 && xCoord >= 350 && xCoord <= 390) &&
        !(yCoord >= 203 && yCoord <= 213 && xCoord >= 288 && xCoord <= 456) &&
        !(yCoord >= 144 && yCoord <= 154 && xCoord >= 355 && xCoord <= 395) &&
        !(yCoord >= 208 && yCoord <= 218 && xCoord >= 84 && xCoord <= 181) &&
        !(yCoord >= 146 && yCoord <= 156 && xCoord >= 84 && xCoord <= 181) &&
        !(yCoord >= 146 && yCoord <= 156 && xCoord >= 207 && xCoord <= 321) &&
        !(yCoord >= 211 && yCoord <= 221 && xCoord >= 568 && xCoord <= 655) &&
        !(yCoord >= 150 && yCoord <= 160 && xCoord >= 560 && xCoord <= 659) &&
        !(yCoord >= 144 && yCoord <= 154 && xCoord >= 419 && xCoord <= 541)) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 670 &&
        !(xCoord >= 70 && xCoord <= 185 && yCoord >= 223 && yCoord <= 243) &&
        !(xCoord >= 70 && xCoord <= 180 && yCoord >= 346 && yCoord <= 360) &&
        !(xCoord >= 70 && xCoord <= 103 && yCoord >= 543 && yCoord <= 544) &&
        !(xCoord >= 96 && xCoord <= 209 && yCoord >= 600 && yCoord <= 610) &&
        !(xCoord >= 195 && xCoord <= 260 && yCoord >= 548 && yCoord <= 558) &&
        !(xCoord >= 197 && xCoord <= 315 && yCoord >= 606 && yCoord <= 616) &&
        !(xCoord >= 89 && xCoord <= 172 && yCoord >= 480 && yCoord <= 490) &&
        !(xCoord >= 208 && xCoord <= 312 && yCoord >= 484 && yCoord <= 494) &&
        !(xCoord >= 281 && xCoord <= 461 && yCoord >= 548 && yCoord <= 558) &&
        !(xCoord >= 428 && xCoord <= 532 && yCoord >= 484 && yCoord <= 494) &&
        !(xCoord >= 430 && xCoord <= 655 && yCoord >= 608 && yCoord <= 618) &&
        !(xCoord >= 494 && xCoord <= 550 && yCoord >= 553 && yCoord <= 563) &&
        !(xCoord >= 634 && xCoord <= 700 && yCoord >= 546 && yCoord <= 556) &&
        !(xCoord >= 568 && xCoord <= 653 && yCoord >= 480 && yCoord <= 490) &&
        !(xCoord >= 494 && xCoord <= 534 && yCoord >= 350 && yCoord <= 360) &&
        !(xCoord >= 201 && xCoord <= 254 && yCoord >= 360 && yCoord <= 370) &&
        !(xCoord >= 280 && xCoord <= 457 && yCoord >= 414 && yCoord <= 424) &&
        !(xCoord >= 565 && xCoord <= 700 && yCoord >= 353 && yCoord <= 370) &&
        !(xCoord >= 281 && xCoord <= 456 && yCoord >= 294 && yCoord <= 324) &&
        !(xCoord >= 577 && xCoord <= 700 && yCoord >= 220 && yCoord <= 250) &&
        !(xCoord >= 494 && xCoord <= 530 && yCoord >= 165 && yCoord <= 185) &&
        !(xCoord >= 432 && xCoord <= 509 && yCoord >= 226 && yCoord <= 250) &&
        !(xCoord >= 205 && xCoord <= 243 && yCoord >= 168 && yCoord <= 188) &&
        !(xCoord >= 225 && xCoord <= 308 && yCoord >= 222 && yCoord <= 232) &&
        !(xCoord >= 283 && xCoord <= 455 && yCoord >= 164 && yCoord <= 174) &&
        !(xCoord >= 87 && xCoord <= 181 && yCoord >= 159 && yCoord <= 169) &&
        !(xCoord >= 84 && xCoord <= 176 && yCoord >= 76 && yCoord <= 86) &&
        !(xCoord >= 204 && xCoord <= 314 && yCoord >= 70 && yCoord <= 80) &&
        !(xCoord >= 560 && xCoord <= 659 && yCoord >= 160 && yCoord <= 170) &&
        !(xCoord >= 560 && xCoord <= 659 && yCoord >= 70 && yCoord <= 90) &&
        !(xCoord >= 411 && xCoord <= 540 && yCoord >= 70 && yCoord <= 90)) {
            yCoord += MOVE_AMT;
        }
    }

    public void collectBall(){
        score++;
    }
    public BufferedImage getPlayerImage() {
        if (facingRight) {
            return rightImg;
        }
        else if (facingUp){
            return upImg;
        }
        else if (facingDown){
            return downImg;
        }
        else {
            return leftImg;
        }
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        return new Rectangle((int) xCoord , (int) yCoord, imageWidth, imageHeight);
    }

    public void addBalls(){
        Ball ball1 = new Ball(110,80, "src/yellowball.png");
        balls.add(ball1);
        Ball ball2 = new Ball(180,80, "src/yellowball.png");
        balls.add(ball2);
        Ball ball3 = new Ball(260,80, "src/yellowball.png");
        balls.add(ball3);
        Ball ball4 = new Ball(330,80, "src/yellowball.png");
        balls.add(ball4);
        Ball ball5 = new Ball(70,160, "src/yellowball.png");
        balls.add(ball5);
        Ball ball6 = new Ball(70, 230, "src/yellowball.png");
        balls.add(ball6);
        Ball ball7 = new Ball(180,160, "src/yellowball.png");
        balls.add(ball7);
        Ball ball8 = new Ball(180,230, "src/yellowball.png");
        balls.add(ball8);
        Ball ball9 = new Ball(280, 160, "src/yellowball.png");
        balls.add(ball9);
        Ball ball10 = new Ball(280,230, "src/yellowball.png");
        balls.add(ball10);
        Ball ball11 = new Ball(380,160, "src/yellowball.png");
        balls.add(ball11);
        Ball ball12 = new Ball(480,160, "src/yellowball.png");
        balls.add(ball12);
        Ball ball13 = new Ball(580,160, "src/yellowball.png");
        balls.add(ball13);
        Ball ball14 = new Ball(680,160, "src/yellowball.png");
        balls.add(ball14);
        Ball ball15 = new Ball(400,80, "src/yellowball.png");
        balls.add(ball15);
        Ball ball16 = new Ball(470, 80, "src/yellowball.png");
        balls.add(ball16);
        Ball ball17 = new Ball(540, 80, "src/yellowball.png");
        balls.add(ball17);
        Ball ball18 = new Ball(610, 80, "src/yellowball.png");
        balls.add(ball18);
        Ball ball19 = new Ball(680, 80, "src/yellowball.png");
        balls.add(ball19);
        Ball ball20 = new Ball(450,230, "src/yellowball.png");
        balls.add(ball20);
        Ball ball21 = new Ball(550, 230, "src/yellowball.png");
        balls.add(ball21);
        Ball ball22 = new Ball(660,230, "src/yellowball.png");
        balls.add(ball22);
        Ball ball23 = new Ball(180,300, "src/yellowball.png");
        balls.add(ball23);
        Ball ball24 = new Ball(180, 360, "src/yellowball.png");
        balls.add(ball24);
        Ball ball25 = new Ball(180,420, "src/yellowball.png");
        balls.add(ball25);
        Ball ball26 = new Ball(180,480, "src/yellowball.png");
        balls.add(ball26);
        Ball ball27 = new Ball(180,540, "src/yellowball.png");
        balls.add(ball27);
        Ball ball28 = new Ball(180,600, "src/yellowball.png");
        balls.add(ball28);
        Ball ball29 = new Ball(180,670, "src/yellowball.png");
        balls.add(ball29);
        Ball ball30 = new Ball(60,670, "src/yellowball.png");
        balls.add(ball30);
        Ball ball31 = new Ball(120,670, "src/yellowball.png");
        balls.add(ball31);
        Ball ball32 = new Ball(240,670, "src/yellowball.png");
        balls.add(ball32);
        Ball ball33 = new Ball(300,670, "src/yellowball.png");
        balls.add(ball33);
        Ball ball34 = new Ball(360,670, "src/yellowball.png");
        balls.add(ball34);
        Ball ball35 = new Ball(420,670, "src/yellowball.png");
        balls.add(ball35);
        Ball ball36 = new Ball(480,670, "src/yellowball.png");
        balls.add(ball36);
        Ball ball37 = new Ball(540,670, "src/yellowball.png");
        balls.add(ball37);
        Ball ball38 = new Ball(600,670, "src/yellowball.png");
        balls.add(ball38);
        Ball ball39 = new Ball(660,670, "src/yellowball.png");
        balls.add(ball39);
        Ball ball40 = new Ball(70,600, "src/yellowball.png");
        balls.add(ball40);
        Ball ball41 = new Ball(280,600, "src/yellowball.png");
        balls.add(ball41);
        Ball ball42 = new Ball(450,600, "src/yellowball.png");
        balls.add(ball42);
        Ball ball43 = new Ball(550,600, "src/yellowball.png");
        balls.add(ball43);
        Ball ball44 = new Ball(660,600, "src/yellowball.png");
        balls.add(ball44);
        Ball ball45 = new Ball(70,540, "src/yellowball.png");
        balls.add(ball45);
        Ball ball46 = new Ball(280,540, "src/yellowball.png");
        balls.add(ball46);
        Ball ball47 = new Ball(450,540, "src/yellowball.png");
        balls.add(ball47);
        Ball ball48 = new Ball(365,540, "src/yellowball.png");
        balls.add(ball48);
        Ball ball49 = new Ball(550,540, "src/yellowball.png");
        balls.add(ball49);
        Ball ball50 = new Ball(660,540, "src/yellowball.png");
        balls.add(ball50);
        Ball ball51 = new Ball(70,480, "src/yellowball.png");
        balls.add(ball51);
        Ball ball52 = new Ball(280,480, "src/yellowball.png");
        balls.add(ball52);
        Ball ball53 = new Ball(450,480, "src/yellowball.png");
        balls.add(ball53);
        Ball ball54 = new Ball(550,480, "src/yellowball.png");
        balls.add(ball54);
        Ball ball55 = new Ball(660,480, "src/yellowball.png");
        balls.add(ball55);
        Ball ball56 = new Ball(280,420, "src/yellowball.png");
        balls.add(ball56);
        Ball ball57 = new Ball(450,420, "src/yellowball.png");
        balls.add(ball57);
        Ball ball58 = new Ball(550,420, "src/yellowball.png");
        balls.add(ball58);
        Ball ball59 = new Ball(270,360, "src/yellowball.png");
        balls.add(ball59);
        Ball ball60 = new Ball(460,360, "src/yellowball.png");
        balls.add(ball60);
        Ball ball61 = new Ball(550,360, "src/yellowball.png");
        balls.add(ball61);
        Ball ball62 = new Ball(280,300, "src/yellowball.png");
        balls.add(ball62);
        Ball ball63 = new Ball(450,300, "src/yellowball.png");
        balls.add(ball63);
        Ball ball64 = new Ball(550,300, "src/yellowball.png");
        balls.add(ball64);
        Ball ball65 = new Ball(90,360, "src/yellowball.png");
        balls.add(ball65);
        Ball ball66 = new Ball(640,360, "src/yellowball.png");
        balls.add(ball66);
    }
}
