package Pacman;

import java.util.Random;

public class Enemy{
private Point q;
static int count;
Enemy(){
    q = new Point(0,0);
    count+=1;
}
Point getLocation(){
    return this.q;
}

public int nextLoc(){
    Random r = new Random();
    int pos = ((r.nextInt(4))+1);
    return pos;
    }
    public void move(int pos){
            switch (pos) {
                case 1:{
                        q.addX();
                    break;}
                case 2:{
                        q.subX();
                    break;}
                case 3:{
                    q.subY();
                    break;}
                case 4:{
                    q.addY();
                    break;}
                default:{
                }}}}
