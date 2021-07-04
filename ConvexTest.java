package Выпуклая_оболочка;

class ConvexTest {
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        MyFrame frame = new MyFrame(convex);
        while(true){
            convex.add(new R2Point());

            System.out.println("S = " + convex.area()+ ", P = " + convex.perimeter());
            frame.paint(frame.getGraphics());
        }
    }
}
