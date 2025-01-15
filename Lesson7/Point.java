public class Point {
    private double _x;
    private double _y;
 
    public Point(double x, double y) {
       this._x = x;
       this._y = y;
    }
 
    public Point(Point other) {
       this._x = other.getX();
       this._y = other.getY();
    }
 
    public double getX() {
       return this._x;
    }
 
    public double getY() {
       return this._y;
    }
 
    public void setX(double x) {
       this._x = x;
    }
 
    public void setY(double y) {
       this._y = y;
    }
 
    public String toString() {
       return "(" + this._x + "," + this._y + ")";
    }
 
    public boolean equals(Point other) {
       return other != null && this._x == other.getX() && this._y == other.getY();
    }
 
    public boolean isAbove(Point other) {
       return this._y > other.getY();
    }
 
    public boolean isUnder(Point other) {
       return other.isAbove(this);
    }
 
    public boolean isLeft(Point other) {
       return this._x < other.getX();
    }
 
    public boolean isRight(Point other) {
       return other.isLeft(this);
    }
 
    public double distance(Point p) {
       return Math.sqrt((this._x - p.getX()) * (this._x - p.getX()) + (this._y - p.getY()) * (this._y - p.getY()));
    }
 
    public void move(int dX, int dY) {
       double x = this.getX() + (double)dX;
       double y = this.getY() + (double)dY;
       if (x >= 0.0 && y >= 0.0) {
          this._x += (double)dX;
          this._y += (double)dY;
       }
 
    }
 }
 