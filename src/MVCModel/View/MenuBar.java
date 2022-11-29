package MVCModel.View;

import MVCModel.Control.Control;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private Control ctrl;
    private final JMenuItem load_menu_item, save_menu_item;

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;

        Control.FileListener file_listener = ctrl.new FileListener();
        this.load_menu_item.addActionListener(file_listener);
        this.save_menu_item.addActionListener(file_listener);
    }

    public MenuBar() {
        JMenu file_menu = new JMenu("File");
        load_menu_item = new JMenuItem("Open");
        save_menu_item = new JMenuItem("Save");

        file_menu.add(load_menu_item);
        file_menu.add(save_menu_item);
        add(file_menu);
    }
}
