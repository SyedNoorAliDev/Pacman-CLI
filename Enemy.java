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
public boolean checkObstacle(String array[][],int pos){
    Point pq = new Point();
    pq.copy(this.getLocation());
    if ((pos <= 4)&&(pos >0)) {
        switch (pos) {
            case 1:{
                pq.addX();
                break;}
            case 2:{
                pq.subX();
                break;}
            case 3:{
                pq.subY();
                break;}
            case 4:{
                pq.addY();
                break;}
            default:{
            }

        }
    }

    return (((array[pq.getY()][pq.getX()]).compareTo("#"))==0);
}
    public void move(String arrray[][]){
        Random r = new Random();
        int pos = (r.nextInt(4));
        if (!(checkObstacle(arrray,pos))) {
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
                }

            }
    }



    }
}
