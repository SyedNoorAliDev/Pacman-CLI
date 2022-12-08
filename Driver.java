package Pacman;

import java.util.Scanner;

public class Driver {
    public static void main(String args[]){
        GameWorld g = new GameWorld();
        g.loadMaze();
        g.play();
        System.out.println("Total Score: ");
    }

}
