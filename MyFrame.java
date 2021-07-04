package Выпуклая_оболочка;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static final int width = 600;
    private static final int height = 600;

    private Convex convex;

    public MyFrame(Convex convex) {
        this.convex = convex;
        this.setSize(width, height);
        this.setTitle("Rect");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0, 0, 1000, 1000);
        g.translate(MyFrame.width/2, MyFrame.height/2);
        g.drawLine(0, MyFrame.height/2, 0, -MyFrame.height);
        g.drawLine(-MyFrame.width/2, 0, MyFrame.width/2, 0);
        convex.draw(g);
    }

}
