package MVCModel.Utils;

import java.awt.*;

public class Line extends Shape {
    private final Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void render(Graphics2D g) {
        super.render(g);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    @Override
    public Line clone() {
        Point new_p1 = new Point(p1.x + 5, p1.y + 5);
        Point new_p2 = new Point(p2.x + 5, p2.y + 5);
        return new Line(new_p1, new_p2);
    }

    @Override
    public boolean fallsIn(Point p) {
        return Math.min(p1.x, p2.x) < p.x && p.x < Math.max(p1.x, p2.x)
                && Math.min(p1.y, p2.y) < p.y && p.y < Math.max(p1.y, p2.y);
    }

    @Override
    void move(int dx, int dy) {
        p1.x += dx;
        p2.x += dx;
        p1.y += dy;
        p2.y += dy;
    }

    @Override
    public void zoomIn() {
        int delta_x = p2.x - p1.x;
        int delta_y = p2.y - p1.y;
        p1.x += (int) (0.1 * delta_x);
        p2.x -= (int) (0.1 * delta_x);
        p1.y += (int) (0.1 * delta_y);
        p1.y -= (int) (0.1 * delta_y);
    }

    @Override
    public void zoomOut() {
        int delta_x = p2.x - p1.x;
        int delta_y = p2.y - p1.y;
        p1.x -= (int) (0.1 * delta_x);
        p2.x += (int) (0.1 * delta_x);
        p1.y -= (int) (0.1 * delta_y);
        p1.y += (int) (0.1 * delta_y);
    }
}