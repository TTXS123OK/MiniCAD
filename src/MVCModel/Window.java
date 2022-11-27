package MVCModel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private View view;
    private Control ctrl;

    public Window() {
        // set window configuration
        setTitle("MiniCAD");
        setSize(800, 600);
        setLocationRelativeTo(null); // center the window in screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel shape_panel = new JPanel();
        add(shape_panel, BorderLayout.WEST);
        shape_panel.setLayout(new GridLayout(0, 1));
        JButton[] shape_buttons = {
          new JButton("Line"),
          new JButton("Rectangle"),
          new JButton("Circle"),
          new JButton("Text"),
        };
        for (JButton btn : shape_buttons) {
            shape_panel.add(btn);
        }

        // initialize content view
        Model model = new Model();
        view = new View(model);
        ctrl = new Control(model);
        model.setView(view);
    }
}
