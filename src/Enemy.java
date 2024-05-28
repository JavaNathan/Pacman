import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Enemy {
    private final double MOVE_AMT = 0.2;
    private double xCoord;
    private double yCoord;
    private BufferedImage leftImg;
    private BufferedImage rightImg;
    private boolean facingRight;

    public Enemy(String leftImg, String rightImg, int xCoord, int yCoord){
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

    public BufferedImage getEnemyImage(){
        if (facingRight){
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
        !(xCoord <= 189 && xCoord >= 179 && yCoord >= 360 && yCoord <= 450) &&
        !(xCoord <= 123 && xCoord >= 113 && yCoord <= 585 && yCoord >= 556) &&
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
        !(yCoord >= 470 && yCoord <= 480 && xCoord >= 206 && xCoord <= 246) &&
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
        !(xCoord >= 201 && xCoord <= 248 && yCoord >= 360 && yCoord <= 370) &&
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
}