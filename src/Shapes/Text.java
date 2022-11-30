package Shapes;

import java.awt.*;

public class Text extends Shape {
    private final String str;
    private final Point point;
    private int width, height;

    public Text(Text t) {
        point = new Point(t.point);
        width = t.width;
        height = t.height;
        str = t.str;
        color = t.color;
    }

    public Text(String str, Point p1, Point p2) {
        point = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
        width = Math.abs(p1.x - p2.x);
        height = Math.abs(p1.y - p2.y);
        this.str = str;
    }

    public void render(Graphics2D g) {
        super.render(g);

        if (str == null) {
            return;
        }

        Font font = new Font("Californian FB", is_selected ? Font.BOLD : Font.PLAIN, height);
        g.setFont(font);
        g.drawString(str, point.x, point.y + height);

        // update with from canvas
        width = g.getFontMetrics().stringWidth(str);
    }

    @Override
    public Text clone() {
        return new Text(this);
    }

    @Override
    public boolean fallsIn(Point p) {
        return point.x < p.x && p.x < point.x + width && point.y < p.y && p.y < point.y + height;
    }

    @Override
    public void move(int dx, int dy) {
        point.x += dx;
        point.y += dy;
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
