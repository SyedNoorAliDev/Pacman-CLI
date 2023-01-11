package Pacman;
import java.util.*;
public class  Pacman{
   private Point p;
   Pacman(){
       p= new Point(0,0);
   }
   Point getLocation(){
       return this.p;
   }

    public void move(int input) {
        if ((input <= 4)&&(input >0)) {
            switch (input) {
                case 1:{
                        p.addX();
                    break;}
                case 2:{
                        p.subX();
                    break;}
                case 3:{
                    p.subY();
                    break;}
                case 4:{
                    p.addY();
                    break;}
                default:{
                }

            }
        }
    }
}





