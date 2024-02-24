package Maze;

import javax.swing.*;

public class Maze {
    public static void main(String[] args) {
        Maze maze = new Maze();
    }

    public Maze(){
        JFrame frame = new JFrame();
        frame.setTitle("迷宮遊戲");

        frame.setSize(800, 500);
        frame.add(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
