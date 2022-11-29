package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private Model model;
    private Control ctrl;
    private ShapePanel shape_panel;
    private OptionPanel option_panel;

    public void setModel(Model model) {
        this.model = model;
        shape_panel.setModel(model);
    }

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;
        shape_panel.setCtrl(ctrl);
    }

    public View() {
        setTitle("MiniCAD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5, 5));

        shape_panel = new ShapePanel();
        add(shape_panel, BorderLayout.WEST);

        option_panel = new OptionPanel();
        add(option_panel, BorderLayout.EAST);
    }

    public void update() {
        this.shape_panel.update();
    }
}