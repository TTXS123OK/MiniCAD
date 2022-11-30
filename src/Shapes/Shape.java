package Shapes;

import java.awt.*;
import java.io.Serializable;

abstract public class Shape implements Serializable, Cloneable {

    protected Color color = Color.BLACK;

    protected boolean is_selected = false;

    abstract public Shape clone();

    abstract public boolean fallsIn(Point p);

    abstract public void move(int dx, int dy);

    abstract public void zoomIn();

    abstract public void zoomOut();

    public void render(Graphics2D g) {
        float stroke = 2.0f;
        float selected_stroke = 4.0f;
        g.setStroke(is_selected ? new BasicStroke(selected_stroke) : new BasicStroke(stroke));
        g.setColor(this.color);
    }

    public void setSelected(boolean b) {
        is_selected = b;
    }

    public void setColor(Color c) {
        this.color = c;
    }
}
