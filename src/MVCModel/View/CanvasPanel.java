package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {

    private Model model;
    private Control ctrl;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;
        Control.MouseActionListener mouse_action_listener = ctrl.new MouseActionListener();
        addMouseListener(mouse_action_listener);
        addMouseMotionListener(mouse_action_listener);
    }

    public CanvasPanel() {
        setBackground(Color.white);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Shape drawing_item = model.getDrawingItem();
        if (drawing_item != null) {
            drawing_item.render((Graphics2D) g);
        }
        for (Shape shape : model.getShapeList()) {
            shape.render((Graphics2D) g);
        }
    }

    public void update() {
        repaint();
    }
}
