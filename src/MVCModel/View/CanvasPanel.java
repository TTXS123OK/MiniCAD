package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;

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
    }

    public CanvasPanel() {
        setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
