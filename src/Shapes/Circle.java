package Shapes;

import java.awt.*;

public class Circle extends Shape {
    private final Point center;
    private int radius;

    public Circle(Circle c) {
       center = new Point(c.center);
       radius = c.radius;
    }

    public Circle(Point p1, Point p2) {
        center = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        radius = Math.min(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y)) / 2;
    }

    public void render(Graphics2D g) {
        super.render(g);
        g.drawOval(center.x - radius, center.y - radius, radius * 2, radius * 2);
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean fallsIn(Point p) {
        return Math.sqrt(Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2)) < radius;
    }

    @Override
    public void move(int dx, int dy) {
        center.x += dx;
        center.y += dy;
    }

    @Override
    public void zoomIn() {
        radius *= 0.8;
    }

    @Override
    public void zoomOut() {
        radius *= 1.2;
    }
}
