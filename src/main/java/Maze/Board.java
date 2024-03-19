package Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    public Board (){
        timer = new Timer(25,this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        Map map = new Map();
        for(int x=0;x<14 ;x++){
            for(int y=0;y<14;y++){

                if (map.getMap(x,y).equals("g")){
                    g.drawImage(map.getGrass(),x*32,y*32,null);
                }else if(map.getMap(x,y).equals("w")){
                    g.drawImage(map.getWall(),x*32,y*32,null);
                }else if(map.getMap(x,y).equals("b")){
                    g.drawImage(map.getBone(),x*32,y*32,null);
                }
            }
        }
        g.setColor(Color.blue);
        g.fillRect(45,60,32,32);
    }
}
