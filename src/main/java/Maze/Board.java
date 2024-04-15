package Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Map map;
    private Player p;
    private String message="";
    private Font font = new Font("Serif", Font.BOLD,48);
    private Boolean win=false;
    private JButton playAgainButton = new JButton("Play Again!");


    public Board (){
        map = new Map();
        p = new Player();
        addKeyListener(new ActionListener());

        // add the keyListener to the frame
        setFocusable(true);

        timer = new Timer(25,this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (map.getMap(p.getTileX(),p.getTileY()).equals("b")){
            map.removeBone(p.getTileX(),p.getTileY());

        }
        if (map.getMap(p.getTileX(),p.getTileY()).equals("h") && map.hasBonesRemaining()){
            message="Delicious!";
            win=true;

        }
        repaint();

    }

    public void paint(Graphics g){
        super.paint(g);
        if (win.equals(true)){
            g.drawImage(map.getCongrats(),0, 0,null);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString(message,125, 330);

            playAgainButton.setBounds(125, 385, 200, 50);

            add(playAgainButton);
            setLayout(null);
            if (playAgainButton.getModel().isPressed()){
                win=false;
                p.resetPosition();
                map.resetBone();
            }


        } else{
            for(int x=0;x<14 ;x++){
                for(int y=0;y<14;y++){

                    if (map.getMap(x,y).equals("g")){
                        g.drawImage(map.getGrass(),x*32,y*32,null);
                    }else if(map.getMap(x,y).equals("w")){
                        g.drawImage(map.getWall(),x*32,y*32,null);
                    }else if(map.getMap(x,y).equals("b")){
                        g.drawImage(map.getBone(),x*32,y*32,null);
                    }else if(map.getMap(x,y).equals("h")){
                        g.drawImage(map.getHome(),x*32,y*32,null);
                    }

                }
            }
            g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
        }


    }


    public class ActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP) {

                if (!map.getMap(p.getTileX(), p.getTileY() - 1).equals("w")) {
                    p.move(0, -1);
                }

            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (!map.getMap(p.getTileX(), p.getTileY() + 1).equals("w")) {
                    p.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!map.getMap(p.getTileX() + 1, p.getTileY()).equals("w")) {
                    p.move(1, 0);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!map.getMap(p.getTileX() - 1, p.getTileY()).equals("w")) {
                    p.move(-1, 0);
                }
            }

        }

        /*
        The keyReleased() function is called once every time a key is released.
        The key that was released will be stored in the key variable.
         */
        public void keyReleased(KeyEvent e){

        }
        /*
        Called once every time a key is pressed, but action keys such as Ctrl, Shift, and Alt are ignored
         */
        public void keyTyped(KeyEvent e){

        }

    }
}
