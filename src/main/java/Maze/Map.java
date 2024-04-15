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
    private Image bone;
    private Image congrats;
    private Image home;
    private Scanner map_file;
    private String Map_array [] = new String[14];

    public Map(){
        ImageIcon img = new ImageIcon("pictures/grass.png");
        grass = img.getImage();
        img = new ImageIcon("pictures/wall.png");
        wall = img.getImage();
        img = new ImageIcon("pictures/bone.png");
        bone = img.getImage();
        img = new ImageIcon("pictures/win.png");
        congrats = img.getImage();
        img = new ImageIcon("pictures/home.png");
        home = img.getImage();
        openFile();
        readFile();
        closeFile();
    }
    public void removeBone(int x, int y) {
        StringBuilder sb = new StringBuilder(Map_array[y]);
        sb.setCharAt(x, 'g'); // 將指定位置的地圖值設置為空字符
        Map_array[y] = sb.toString();
    }
    public void resetBone() {
        // 重新讀取地圖文件以獲取初始狀態的 "bone" 位置
        openFile();
        readFile();
        closeFile();
    }
    public boolean hasBonesRemaining() {
        for (String row : Map_array) {
            if (row.contains("b")) {
                return true; // 如果還有骨頭存在，返回 true
            }
        }
        return false; // 如果所有行中都沒有骨頭，返回 false
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
    public Image getBone(){
        return bone;
    }
    public Image getHome() {return home;}

    public Image getCongrats(){
        return congrats;
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
