package Pacman;

import java.util.Scanner;

public class GameWorld {
    public static String[][] maze;
    int score;
    GameWorld(){
        maze = new String[20][30];
        score=0;
    }
    void loadMaze(){
        for (int i=0;i<20;i++){
            for (int j=0;j<30;j++){
                if (i==0 || i==19 || j==0 || j==29){
                    maze[i][j] = "#";
                } else if ((i==3 || i==16) && j>5 && j<25){
                    maze[i][j] = "#";
                } else if ((j==2 || j==27)&& i>3 && i<16){
                    maze[i][j] ="#";
                } else if ((i==2 || i==17) && (j==6||j==24)){
                    maze[i][j]= "#";
                }else if ((j==5 || j==24)&&(i>5 && i<14)){
                    maze[i][j]= "#";
                }else if((i==14)&&((j>6 && j<10) || (j>16 && j<23) )) {
                    maze[i][j]= "#";}
                 else if (j==7 && (i>8 && i<13)){
                    maze[i][j]= "#";
                }else if (j==10 && (i>6 && i<12)){
                    maze[i][j]= "#";
                }else if (j==17 && (i>7 && i<14)){
                    maze[i][j]= "#";
                }
                else if (i==6 && (j>19 && j<25)){
                    maze[i][j]= "#";
                } else if (i==5 && (j>14 && j<21)){
                    maze[i][j]= "#";
                }
                else if (i==8 && (j>12 && j<19)){
                    maze[i][j]= "#";
                }
                else if (i==11 && (j>9 && j<15)){
                    maze[i][j]= "#";
                }
                else if ((i==18 && j==3)||(i==14 && j==9)){
                    maze[i][j]= "#";
                }
                else if (i==6 &&(j>6 && j<11)){
                    maze[i][j]= "#";
                }
                else if (j==22 && (i>8 && i<12)){
                    maze[i][j]= "#";
                }
                else if (i==11 && (j>18 && j<23)){
                    maze[i][j]= "#";
                }
                else if (i==12 && j==19){
                    maze[i][j]= "#";
                }
                else {
                    maze[i][j] = ".";
                }
            }
        }
    }
    public static boolean samePosition(Pacman pc, Enemy e1,Enemy e2){
        return (pc.getLocation()).equals(e1.getLocation()) || (pc.getLocation()).equals(e2.getLocation());
    }
    public boolean checkObstacle(Pacman ps,int inp){
        Point pq = new Point();
        pq.copy(ps.getLocation());
        if ((inp <= 4)&&(inp >0)) {
            switch (inp) {
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
        return ((maze[pq.getY()][pq.getX()]).compareTo("#"))==0;
    }
    public boolean checkEatable(Pacman ps,int inp){
        Point pq = new Point();
        pq.copy(ps.getLocation());
        if ((inp <= 4)&&(inp >0)) {
            switch (inp) {
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
        return ((maze[pq.getY()][pq.getX()]).compareTo("."))==0;
    }

    public boolean checkObstacle(Enemy e){
        return (((maze[e.getLocation().getY()][e.getLocation().getX()]).compareTo("#"))==0);
    }
    public void play(){
        System.out.println("<<<<<<<<-------PACMAN GAME-------->>>>>>>>>>");
        Pacman p = new Pacman();
        Point prevLoc = new Point(15,10);
        Point prevLoc1= new Point(22,15);
        Point prevLoc2 = new Point(5,4);
        p.getLocation().setX(15);
        p.getLocation().setY(10);
        System.out.println("Initial Position of Pacman: "+p.getLocation());
        Enemy E1 = new Enemy();
        Enemy E2 = new Enemy();
        E1.getLocation().setX(22);
        E1.getLocation().setY(15);
        E2.getLocation().setX(5);
        E2.getLocation().setY(4);
        maze[E1.getLocation().getY()][E1.getLocation().getX()] = "E";
        maze[E2.getLocation().getY()][E2.getLocation().getX()] = "E";
        maze[p.getLocation().getY()][p.getLocation().getX()]="P";
        print(maze);
        for(int i=0;i<50;i++) {
            System.out.println("1-Right\n2-Left\n3-Up\n4-Down");
            System.out.println("Enter the position of packman here:");
            Scanner sc = new Scanner(System.in);
            int inp = sc.nextInt();
            if (!(checkObstacle(E1))){
                maze[prevLoc1.getY()][prevLoc1.getX()]=".";
                E1.move(maze);
                maze[E1.getLocation().getY()][E1.getLocation().getX()] = "E";
                prevLoc1 = E1.getLocation();
            }
            if (!(checkObstacle(E2))){
                maze[prevLoc2.getY()][prevLoc2.getX()]=".";
                E2.move(maze);
                maze[E2.getLocation().getY()][E2.getLocation().getX()] = "E";
                prevLoc2 = E2.getLocation();
            }
            if (!(checkObstacle(p,inp))) {
                if (checkEatable(p,inp)){
                    ++score;
                }
                maze[prevLoc.getY()][prevLoc.getX()]=" ";
                p.move(inp);
                maze[p.getLocation().getY()][p.getLocation().getX()]="P";
                prevLoc = p.getLocation();
                if (samePosition(p,E1,E2)){
                    System.out.println("Out");
                    System.out.println("Pacman encountered Enemy at: "+p.getLocation());
                    maze[p.getLocation().getY()][p.getLocation().getX()]="X";
                    break;
                }
            }
            System.out.println("Current position of Pacman is: "+p.getLocation());
            System.out.println("Current position of Enemy 1"+ " is: " +E1.getLocation());
            System.out.println("Current position of Enemy 2"+ " is: " +E2.getLocation());
            System.out.println("----------------------------------------------------");
            print(maze);
            System.out.println("Current Score: "+score);

        }
    }
    public void print(String b[][]){
        for (int i=0;i<20;i++){
            for (int j=0;j<30;j++){
                System.out.print((b[i][j]) + "");
            }
            System.out.println("\n");
        }
    }

}
