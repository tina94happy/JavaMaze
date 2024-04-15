package Maze;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int tilex,tiley;
    private Image player;
    public Player(){
        ImageIcon img = new ImageIcon("C:\\side_project\\UCB_java\\Final Project\\JavaMaze\\pictures\\pug.png");
        player = img.getImage();

        tilex=1;
        tiley=1;
    }

    public Image getPlayer() {
        return player;
    }

    public int getTileX() {
        return tilex;
    }
    public int getTileY() {
        return tiley;
    }


    public void move(int dx, int dy){
        tilex+=dx;
        tiley+=dy;
    }

    public void resetPosition() {
        tilex = 1;
        tiley = 1;
    }
}
