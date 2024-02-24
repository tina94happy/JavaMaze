package Maze;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;


public class Map {
    private Image grass;
    private Image wall;
    private Scanner map_file;
    private String Map_array [] = new String[14];

    public Map(){
        ImageIcon img = new ImageIcon("pictures/grass.png");
        grass = img.getImage();
        img = new ImageIcon("pictures/wall.png");
        wall = img.getImage();
        openFile();
        readFile();
        closeFile();
    }

    public void openFile(){
        File file = new File("Map/map1.txt");
        if (file.isFile()){
            try {
                map_file = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public String getMap(int x, int y){
        return Map_array[y].substring(x,x+1);
    }

    public Image getGrass(){
        return grass;
    }
    public Image getWall(){
        return wall;
    }
    public void readFile(){
        while (map_file.hasNext()){
            for (int i=0; i<14;i++){
                Map_array[i] = map_file.next();
            }
        }

    }
    public void closeFile(){
        map_file.close();
    }

    public static void main(String[] args) {
        Map map = new Map();
        map.openFile();

    }

}
