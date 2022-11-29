package Utils;

import java.awt.*;

public class Rectangle extends Shape {

    private final Point point;
    private int width;
    private int height;

    public Rectangle(Point p1, Point p2) {
        assert (p1.x < p2.x && p1.y < p2.y);
        this.point = p1;
        width = p2.x - p1.x;
        height = p2.y - p1.y;
    }

    public void render(Graphics2D g) {
        super.render(g);
        g.drawRect(point.x, point.y, width, height);
    }

    @Override
    public Shape clone() {
        return new Rectangle(new Point(point), new Point(point.x + width, point.y + height));
    }

    @Override
    public boolean fallsIn(Point p) {
        return point.x < p.x && p.x < point.x + width && point.y < p.y && p.y < point.y + height;
    }

    @Override
    public void move(int dx, int dy) {
        width += dx;
        height += dy;
    }

    @Override
    public void zoomIn() {
        width *= 0.8;
        height *= 0.8;
    }

    @Override
    public void zoomOut() {
        width *= 1.2;
        height *= 1.2;
    }
}
