package MVCModel.Control;

import MVCModel.Model.Model;
import MVCModel.Utils.Line;
import MVCModel.Utils.Shape;
import MVCModel.Utils.UserAction;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Control {

    private Model model;

    private UserAction user_action;
    private final Point start_point;
    private String input_str;

    public Control() {
        this.user_action = UserAction.IDLE;
        this.start_point = new Point();
    }


    public void setModel(Model model) {
        this.model = model;
    }

    public String getUserAction() {
        return user_action.toString();
    }

    public class StateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Line" -> user_action = UserAction.LINE;
                case "Rectangle" -> user_action = UserAction.RECTANGLE;
                case "Circle" -> user_action = UserAction.CIRCLE;
                case "Text" -> user_action = UserAction.TEXT;
            }
            model.setUserAction(user_action);
        }
    }

    public class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Shape selected = model.getSelectedItem();
            if (selected != null) {
                ArrayList<Shape> shapes = model.getShapeList();
                shapes.remove(selected);
                model.setShapeList(shapes);
            }
        }
    }

    public class MouseActionListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            start_point.x = e.getX();
            start_point.y = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point cur_point = new Point(e.getX(), e.getY());
            switch (user_action) {
                case LINE -> {
                    Line new_line = new Line(new Point(start_point), cur_point);
                    ArrayList<Shape> shapes = model.getShapeList();
                    shapes.add(new_line);
                    model.setShapeList(shapes);
                    model.setDrawingItem(null);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point cur_point = new Point(e.getX(), e.getY());
            switch (user_action) {
                case LINE -> {
                    Line new_line = new Line(start_point, cur_point);
                    model.setDrawingItem(new_line);
                    System.out.println("drawing item was set " + new_line);
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
