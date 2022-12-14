package MVCModel.Control;

import MVCModel.Model.Model;
import Shapes.*;
import Shapes.Rectangle;
import Shapes.Shape;
import Utils.UserAction;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Control {

    private Model model;
    private UserAction user_action;
    private final Point start_point;
    private final Point last_point;
    private String input_str;

    public Control() {
        user_action = UserAction.IDLE;
        start_point = new Point();
        last_point = new Point();
    }

    public void setModel(Model model) {
        this.model = model;
        model.setUserAction(user_action);
    }

    public class StateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Line" -> user_action = UserAction.LINE;
                case "Rectangle" -> user_action = UserAction.RECTANGLE;
                case "Circle" -> user_action = UserAction.CIRCLE;
                case "Text" -> {
                    user_action = UserAction.TEXT;
                    input_str = JOptionPane.showInputDialog("Enter new text:");
                }
                case "Select" -> user_action = UserAction.SELECT;
                case "Cancel Select" -> user_action = UserAction.IDLE;
            }
            if (model.getSelectedItem() != null) {
                model.setSelectedItem(null);
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
                model.setSelectedItem(null);
            }
        }
    }

    public class CopyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Shape selected = model.getSelectedItem();
            if (selected != null) {
                ArrayList<Shape> shapes = model.getShapeList();
                shapes.add(selected.clone());
                model.setShapeList(shapes);
            }
        }
    }

    public class ZoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Shape selected = model.getSelectedItem();
            if (selected != null) {
                if (e.getActionCommand().equals("Zoom Out")) {
                    selected.zoomOut();
                    model.setSelectedItem(selected);
                }
                else if (e.getActionCommand().equals("Zoom In")) {
                    selected.zoomIn();
                    model.setSelectedItem(selected);
                }
            }
        }
    }

    public class ColorConvertListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Shape selected = model.getSelectedItem();
            if (selected != null) {
                switch (e.getActionCommand()) {
                    case "Black" -> selected.setColor(Color.black);
                    case "Red" -> selected.setColor(Color.red);
                    case "Green" -> selected.setColor(Color.green);
                    case "Blue" -> selected.setColor(Color.blue);
                }
                model.setSelectedItem(selected);
            }
        }
    }

    public class MouseActionListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (user_action == UserAction.SELECT) {
                for (Shape shape : model.getShapeList()) {
                    Point click_point = new Point(e.getX(), e.getY());
                    if (shape.fallsIn(click_point)) {
                        model.setSelectedItem(shape);
                        break;
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            start_point.x = e.getX();
            start_point.y = e.getY();
            last_point.x = e.getX();
            last_point.y = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point cur_point = new Point(e.getX(), e.getY());
            ArrayList<Shape> shapes = model.getShapeList();
            switch (user_action) {
                case LINE -> {
                    Line new_line = new Line(new Point(start_point), cur_point);
                    shapes.add(new_line);
                }
                case RECTANGLE -> {
                    Rectangle new_rect = new Rectangle(new Point(start_point), cur_point);
                    shapes.add(new_rect);
                }
                case CIRCLE -> {
                    Circle new_circle = new Circle(new Point(start_point), cur_point);
                    shapes.add(new_circle);
                }
                case TEXT -> {
                    if (input_str == null || input_str.equals("")) {
                        return;
                    }
                    Text new_text = new Text(input_str, new Point(start_point), cur_point);
                    shapes.add(new_text);
                }
            }
            model.setShapeList(shapes);
            model.setDrawingItem(null);
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
                }
                case RECTANGLE -> {
                    Rectangle new_rect = new Rectangle(new Point(start_point), cur_point);
                    model.setDrawingItem(new_rect);
                }
                case CIRCLE -> {
                    Circle new_circle = new Circle(new Point(start_point), cur_point);
                    model.setDrawingItem(new_circle);
                }
                case TEXT -> {
                    if (input_str == null || input_str.equals("")) {
                        return;
                    }
                    Text new_text = new Text(input_str, new Point(start_point), cur_point);
                    model.setDrawingItem(new_text);
                }
                case SELECT -> {
                    Shape selected = model.getSelectedItem();
                    if (selected != null) {
                        selected.move(cur_point.x - last_point.x, cur_point.y - last_point.y);
                    }
                    model.setSelectedItem(selected);
                    last_point.x = cur_point.x;
                    last_point.y = cur_point.y;
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public class FileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser file_chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("miniCad file (*.cad)", "cad");
            file_chooser.setFileFilter(filter);
            switch (e.getActionCommand()) {
                case "Open" -> {
                    if (file_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        File file = file_chooser.getSelectedFile();
                        try {
                            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
                            ArrayList<Shape> shapes = new ArrayList<>();
                            while (true) {
                                try {
                                    Shape shape = (Shape) input.readObject();
                                    shapes.add(shape);
                                } catch (EOFException ex) {
                                    break;
                                }
                            }
                            model.setShapeList(shapes);
                            user_action = UserAction.IDLE;
                            model.setUserAction(user_action);
                            input.close();
                        } catch (IOException | ClassNotFoundException ex) {
                            System.out.println("Open file failed");
                        }
                    }
                }
                case "Save" -> {
                    if (file_chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        File file = new File(file_chooser.getSelectedFile().getAbsolutePath() + ".cad");
                        try {
                            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
                            for (Shape shape : model.getShapeList()) {
                                output.writeObject(shape);
                            }
                        } catch (IOException ex) {
                            System.out.println("Save file failed");
                        }
                    }
                }
                case "Clear" -> {
                    user_action = UserAction.IDLE;
                    model.setShapeList(new ArrayList<>());
                    model.setDrawingItem(null);
                    model.setSelectedItem(null);
                    model.setUserAction(UserAction.IDLE);
                }
            }
        }
    }
}
