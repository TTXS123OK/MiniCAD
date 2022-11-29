package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapePanel extends JPanel {
    private Model model;
    private Control ctrl;
    private final ArrayList<JButton> shape_buttons = new ArrayList<>(){
        {
            add(new JButton("Line"));
            add(new JButton("Rectangle"));
            add(new JButton("Circle"));
            add(new JButton("Text"));
        }
    };

    public void setModel(Model model) {
        this.model = model;
    }

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;
        for (JButton btn :shape_buttons) {
            btn.addActionListener(ctrl.new ButtonActionListener());
        }
    }

    public ShapePanel() {
        setLayout(new GridLayout(0, 1));

        for (JButton btn : shape_buttons) {
            btn.setFocusPainted(false);
            add(btn);
        }
    }

    public void update() {
        for (JButton btn : shape_buttons) {
            if (btn.getText().equalsIgnoreCase(model.getUserAction())) {
                btn.setForeground(new Color(0x0000ff));
            }
            else {
                btn.setForeground(new Color(0x808080));
            }
        }

        repaint();
    }
}
