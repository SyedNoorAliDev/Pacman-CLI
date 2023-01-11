package Pacman;

public class Point {
    private int x;
    private int y;



    Point(){
    };
    Point(int x1,int y1){this.x=x1;this.y=y1;}
    public void copy(Point p1){
        this.setY(p1.getY());
        this.setX(p1.getX());
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public void setY(int yy) {y = yy;}
    public void setX(int xx) {x = xx;}
    public double distO() {double d = Math.sqrt(x * x + y * y);return d;}
    public String toString() {String p = "[" + x + "," + y + "]";return p;}
    void addX(){
        this.x+=1;
    }
    void addY(){
        this.y+=1;
    }
    void subX(){
        this.x-=1;
    }
    void subY(){
        this.y-=1;
    }
    boolean equals (Point extP){
        if ((extP.getX()==this.getX())&&(extP.getY()==this.getY())){
            return true;
        }
        return false;
    }
}
