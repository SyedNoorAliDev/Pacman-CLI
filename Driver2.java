package Pacman;

import java.util.Scanner;

public class Driver2 {
    public static void main(String args[]){
        Game2 g = new Game2();
        g.loadMaze();
        g.play();
    }
}
