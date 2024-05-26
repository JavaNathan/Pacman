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
        if (xCoord + MOVE_AMT <= 670 &&
        !(xCoord >= 195 && xCoord <= 200 && yCoord >= 544 && yCoord <= 642) &&
        !(xCoord >= 86 && xCoord <= 87 && yCoord >= 613 && yCoord <= 652) &&
        !(xCoord >= 130 && xCoord <= 131 && yCoord >= 498 && yCoord <= 584) &&
        !(xCoord >= 83 && xCoord <= 84 && yCoord >= 487 && yCoord <= 525) &&
        !(xCoord >= 204 && xCoord <= 205 && yCoord >= 493 && yCoord <= 518) &&
        !(xCoord >= 347 && xCoord <= 348 && yCoord >= 550 && yCoord <= 643) &&
        !(xCoord >= 276 && xCoord <= 277 && yCoord >= 550 && yCoord <= 587) &&
        !(xCoord >= 421 && xCoord <= 422 && yCoord >= 487 && yCoord <= 527) &&
        !(xCoord >= 501 && xCoord <= 502 && yCoord >= 554 && yCoord <= 653) &&
        !(xCoord >= 419 && xCoord <= 420 && yCoord >= 615 && yCoord <= 651) &&
        !(xCoord >= 634 && xCoord <= 635 && yCoord >= 541 && yCoord <= 596) &&
        !(xCoord >= 550 && xCoord <= 551 && yCoord >= 492 && yCoord <= 582) &&
        !(xCoord >= 552 && xCoord <= 570 && yCoord >= 366 && yCoord <= 458) &&
        !(xCoord >= 481 && xCoord <= 482 && yCoord >= 368 && yCoord <= 455) &&
        !(xCoord >= 195 && xCoord <= 196 && yCoord >= 368 && yCoord <= 462) &&
        !(xCoord >= 340 && xCoord <= 361 && yCoord >= 432 && yCoord <= 519) &&
        !(xCoord >= 267 && xCoord <= 269 && yCoord >= 427 && yCoord <= 462) &&
        !(xCoord >= 273 && xCoord <= 280 && yCoord >= 307 && yCoord <= 390) &&
        !(xCoord >= 559 && xCoord <= 579 && yCoord >= 244 && yCoord <= 326) &&
        !(xCoord >= 481 && xCoord <= 501 && yCoord >= 180 && yCoord <= 325) &&
        !(xCoord >= 410 && xCoord <= 430 && yCoord >= 236 && yCoord <= 264) &&
        !(xCoord >= 196 && xCoord <= 216 && yCoord >= 176 && yCoord <= 335) &&
        !(xCoord >= 270 && xCoord <= 280 && yCoord >= 173 && yCoord <= 208) &&
        !(xCoord >= 341 && xCoord <= 351 && yCoord >= 203 && yCoord <= 259)){
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 70 &&
        !(xCoord <= 190 && xCoord >= 189 && yCoord >= 246 && yCoord <= 322) &&
        !(xCoord <= 189 && xCoord >= 183 && yCoord >= 370 && yCoord <= 450) &&
        !(xCoord <= 114 && xCoord >= 113 && yCoord <= 585 && yCoord >= 556) &&
        !(xCoord <= 320 && xCoord >= 319 && yCoord <= 654 && yCoord >= 613) &&
        !(xCoord <= 256 && xCoord >= 255 && yCoord <= 652 && yCoord >= 556) &&
        !(xCoord >= 174 && xCoord <= 175 && yCoord <= 579 && yCoord >= 494) &&
        !(xCoord >= 323 && xCoord <= 324 && yCoord >= 492 && yCoord <= 517) &&
        !(xCoord >= 390 && xCoord <= 391 && yCoord >= 550 && yCoord <= 643) &&
        !(xCoord >= 461 && xCoord <= 462 && yCoord >= 550 && yCoord <= 587) &&
        !(xCoord >= 536 && xCoord <= 537 && yCoord >= 487 && yCoord <= 527) &&
        !(xCoord >= 546 && xCoord <= 547 && yCoord >= 550 && yCoord <= 653) &&
        !(xCoord >= 659 && xCoord <= 660 && yCoord >= 614 && yCoord <= 649) &&
        !(xCoord >= 658 && xCoord <= 659 && yCoord >= 482 && yCoord <= 529) &&
        !(xCoord >= 620 && xCoord <= 621 && yCoord >= 485 && yCoord <= 583) &&
        !(xCoord >= 545 && xCoord <= 546 && yCoord >= 369 && yCoord <= 460) &&
        !(xCoord >= 257 && xCoord <= 258 && yCoord >= 369 && yCoord <= 454) &&
        !(xCoord >= 379 && xCoord <= 397 && yCoord >= 432 && yCoord <= 519) &&
        !(xCoord >= 472 && xCoord <= 474 && yCoord >= 427 && yCoord <= 464) &&
        !(xCoord >= 435 && xCoord <= 470 && yCoord >= 306 && yCoord <= 388) &&
        !(xCoord >= 530 && xCoord <= 538 && yCoord >= 176 && yCoord <= 331) &&
        !(xCoord >= 233 && xCoord <= 253 && yCoord >= 182 && yCoord <= 328) &&
        !(xCoord >= 315 && xCoord <= 325 && yCoord >= 237 && yCoord <= 265) &&
        !(xCoord >= 457 && xCoord <= 467 && yCoord >= 177 && yCoord <= 208) &&
        !(xCoord >= 390 && xCoord <= 400 && yCoord >= 203 && yCoord <= 265)) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 70 &&
        !(yCoord <= 348 && yCoord >= 335 && xCoord >= 70 && xCoord <= 181) &&
        !(yCoord <= 472 && yCoord >= 467 && xCoord >= 70 && xCoord <= 170) &&
        !(yCoord <= 592 && yCoord >= 591 && xCoord >= 70 && xCoord <= 102) &&
        !(yCoord <= 653 && yCoord >= 652 && xCoord >= 92 && xCoord <= 319) &&
        !(yCoord <= 592 && yCoord >= 591 && xCoord >= 143 && xCoord <= 171) &&
        !(yCoord <= 520 && yCoord >= 519 && xCoord >= 96 && xCoord <= 157) &&
        !(yCoord <= 521 && yCoord >= 520 && xCoord >= 209 && xCoord <= 315) &&
        !(yCoord <= 586 && yCoord >= 585 && xCoord >= 283 && xCoord <= 394) &&
        !(yCoord <= 586 && yCoord >= 585 && xCoord >= 345 && xCoord <= 457) &&
        !(yCoord <= 651 && yCoord >= 650 && xCoord >= 353 && xCoord <= 392) &&
        !(yCoord <= 524 && yCoord >= 523 && xCoord >= 428 && xCoord <= 532) &&
        !(yCoord <= 654 && yCoord >= 653 && xCoord >= 430 && xCoord <= 655) &&
        !(yCoord >= 596 && yCoord <= 597 && xCoord >= 640 && xCoord <= 700) &&
        !(yCoord >= 594 && yCoord <= 595 && xCoord >= 565 && xCoord <= 610) &&
        !(yCoord >= 534 && yCoord <= 535 && xCoord >= 555 && xCoord <= 653) &&
        !(yCoord >= 450 && yCoord <= 472 && xCoord >= 570 && xCoord <= 700) &&
        !(yCoord >= 471 && yCoord <= 472 && xCoord >= 502 && xCoord <= 535) &&
        !(yCoord >= 470 && yCoord <= 471 && xCoord >= 206 && xCoord <= 246) &&
        !(yCoord >= 472 && yCoord <= 473 && xCoord >= 282 && xCoord <= 458) &&
        !(yCoord >= 531 && yCoord <= 532 && xCoord >= 352 && xCoord <= 391) &&
        !(yCoord >= 337 && yCoord <= 339 && xCoord >= 565 && xCoord <= 700) &&
        !(yCoord >= 350 && yCoord <= 405 && xCoord >= 283 && xCoord <= 459) &&
        !(yCoord >= 325 && yCoord <= 345 && xCoord >= 500 && xCoord <= 530) &&
        !(yCoord >= 260 && yCoord <= 280 && xCoord >= 431 && xCoord <= 501) &&
        !(yCoord >= 324 && yCoord <= 344 && xCoord >= 209 && xCoord <= 243) &&
        !(yCoord >= 269 && yCoord <= 279 && xCoord >= 237 && xCoord <= 312) &&
        !(yCoord >= 257 && yCoord <= 277 && xCoord >= 350 && xCoord <= 390) &&
        !(yCoord >= 203 && yCoord <= 213 && xCoord >= 288 && xCoord <= 456)) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 670 &&
        !(xCoord >= 70 && xCoord <= 160 && yCoord >= 223 && yCoord <= 224) &&
        !(xCoord >= 70 && xCoord <= 165 && yCoord >= 346 && yCoord <= 360) &&
        !(xCoord >= 70 && xCoord <= 103 && yCoord >= 543 && yCoord <= 544) &&
        !(xCoord >= 96 && xCoord <= 209 && yCoord >= 600 && yCoord <= 601) &&
        !(xCoord >= 207 && xCoord <= 248 && yCoord >= 548 && yCoord <= 549) &&
        !(xCoord >= 197 && xCoord <= 315 && yCoord >= 606 && yCoord <= 607) &&
        !(xCoord >= 89 && xCoord <= 172 && yCoord >= 480 && yCoord <= 481) &&
        !(xCoord >= 208 && xCoord <= 312 && yCoord >= 484 && yCoord <= 485) &&
        !(xCoord >= 281 && xCoord <= 461 && yCoord >= 548 && yCoord <= 549) &&
        !(xCoord >= 428 && xCoord <= 532 && yCoord >= 484 && yCoord <= 485) &&
        !(xCoord >= 430 && xCoord <= 655 && yCoord >= 608 && yCoord <= 609) &&
        !(xCoord >= 494 && xCoord <= 534 && yCoord >= 553 && yCoord <= 554) &&
        !(xCoord >= 634 && xCoord <= 700 && yCoord >= 546 && yCoord <= 547) &&
        !(xCoord >= 568 && xCoord <= 653 && yCoord >= 480 && yCoord <= 481) &&
        !(xCoord >= 494 && xCoord <= 534 && yCoord >= 350 && yCoord <= 351) &&
        !(xCoord >= 201 && xCoord <= 248 && yCoord >= 360 && yCoord <= 361) &&
        !(xCoord >= 280 && xCoord <= 457 && yCoord >= 414 && yCoord <= 416) &&
        !(xCoord >= 565 && xCoord <= 700 && yCoord >= 353 && yCoord <= 370) &&
        !(xCoord >= 281 && xCoord <= 456 && yCoord >= 294 && yCoord <= 324) &&
        !(xCoord >= 577 && xCoord <= 700 && yCoord >= 220 && yCoord <= 250) &&
        !(xCoord >= 494 && xCoord <= 530 && yCoord >= 165 && yCoord <= 185) &&
        !(xCoord >= 432 && xCoord <= 509 && yCoord >= 226 && yCoord <= 250) &&
        !(xCoord >= 205 && xCoord <= 243 && yCoord >= 168 && yCoord <= 188) &&
        !(xCoord >= 225 && xCoord <= 308 && yCoord >= 222 && yCoord <= 232) &&
        !(xCoord >= 283 && xCoord <= 455 && yCoord >= 164 && yCoord <= 174)) {
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
