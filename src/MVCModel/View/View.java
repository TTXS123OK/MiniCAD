package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private final MenuBar menu_bar;
    private final ShapePanel shape_panel;
    private final CanvasPanel canvas_panel;
    private final OptionPanel option_panel;

    public void setModel(Model model) {
        shape_panel.setModel(model);
        canvas_panel.setModel(model);
        option_panel.setModel(model);
    }

    public void setCtrl(Control ctrl) {
        menu_bar.setCtrl(ctrl);
        shape_panel.setCtrl(ctrl);
        canvas_panel.setCtrl(ctrl);
        option_panel.setCtrl(ctrl);
    }

    public View() {
        setTitle("MiniCAD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5, 5));

        shape_panel = new ShapePanel();
        add(shape_panel, BorderLayout.WEST);

        canvas_panel = new CanvasPanel();
        add(canvas_panel, BorderLayout.CENTER);

        option_panel = new OptionPanel();
        add(option_panel, BorderLayout.EAST);

        menu_bar = new MenuBar();
        setJMenuBar(menu_bar);
    }

    public void update() {
        this.shape_panel.update();
        this.canvas_panel.update();
        this.option_panel.update();
    }
}