package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OptionPanel extends JPanel {

    private Model model;
    private Control ctrl;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;
    }

    public OptionPanel() {
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        JPanel select_panel = new JPanel();
        JPanel operate_panel = new JPanel();
        JPanel color_panel = new JPanel();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        add(select_panel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 2;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        add(operate_panel, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 2;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        add(color_panel, c);

        select_panel.setLayout(new GridLayout(0, 1));
        select_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        select_panel.add(new JLabel("Selector", SwingConstants.CENTER));
        JButton select_button = new JButton("Select");
        select_button.setFocusPainted(false);
        select_panel.add(select_button);
        JButton remove_select_button = new JButton("Remove Select");
        remove_select_button.setFocusPainted(false);
        select_panel.add(remove_select_button);

        operate_panel.setLayout(new GridLayout(0, 1));
        operate_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        operate_panel.add(new JLabel("Operator", SwingConstants.CENTER));
        ArrayList<JButton> operate_buttons = new ArrayList<>() {
            {
                add(new JButton("Delete"));
                add(new JButton("Copy"));
                add(new JButton("Zoom Out"));
                add(new JButton("Zoom In"));
            }
        };
        for (JButton btn : operate_buttons) {
            btn.setFocusPainted(false);
            operate_panel.add(btn);
        }

        color_panel.setLayout(new GridLayout(0, 1));
        color_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        color_panel.add(new JLabel("    ColorConvertor    ", SwingConstants.CENTER));
        ArrayList<JButton> color_buttons = new ArrayList<>() {
            {
                add(new JButton("Black"));
                add(new JButton("Red"));
                add(new JButton("Green"));
                add(new JButton("Blue"));
            }
        };
        for (JButton btn : color_buttons) {
            switch (btn.getText()) {
                case "Black" -> {
                    btn.setBackground(Color.black);
                    btn.setForeground(Color.white);
                }
                case "Red" -> {
                    btn.setBackground(Color.red);
                    btn.setForeground(Color.cyan);
                }
                case "Green" -> {
                    btn.setBackground(Color.green);
                    btn.setForeground(Color.magenta);
                }
                case "Blue" -> {
                    btn.setBackground(Color.blue);
                    btn.setForeground(Color.yellow);
                }
            }
            btn.setFocusPainted(false);
            color_panel.add(btn);
        }
    }
}
