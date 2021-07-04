package Выпуклая_оболочка;
import java.awt.*;

interface Figure {
    double perimeter();
    double area();
    Figure add(R2Point p);

    void draw(Graphics g);
}
