package Выпуклая_оболочка;
import java.awt.*;


class Polygon extends Deq implements Figure {
    private double s, p;

    public Polygon(R2Point a, R2Point b, R2Point c){
        pushFront(b);

        if (b.light(a, c)){
            pushFront(a);
            pushBack(c);
        }
        else{
            pushFront(c);
            pushBack(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c)+ R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t){
        int i;
        for(i = length(); i>0 && !t.light(back(), front()); i--)
            pushBack(popFront());

        if (i>0){
            R2Point x;
            grow(back(), front(), t);

            for(x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t);
            pushFront(x);

            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);

            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }

        return this;
    }

    @Override
    public void draw(Graphics g) {
            g.setColor(Color.BLACK);
            R2Point p1 = popFront();
            pushBack(p1);
            R2Point p2;
            for(int i = length(); i > 0; i--) {
                if(i == length()) g.fillOval(p1.getx() - 2, -p1.gety() - 2, 4, 4);
                else{
                    p2 = popFront();
                    pushBack(p2);
                    g.fillOval(p2.getx() - 2, -p2.gety() - 2, 4, 4);
                    g.drawLine(p1.getx(), -p1.gety(), p2.gety(), -p2.gety());
                    p1 = p2;
                }
            }
            g.drawLine(front().getx(), -front().gety(), back().gety(), -back().gety());
    }
}
