package MVCModel.View;

import MVCModel.Control.Control;
import MVCModel.Model.Model;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private Model model;
    private Control ctrl;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;
    }

    public MenuBar() {
        JMenu file_menu = new JMenu("File");
        JMenuItem load_item = new JMenuItem("Open");
        JMenuItem save_item = new JMenuItem("Save");

        file_menu.add(load_item);
        file_menu.add(save_item);
        add(file_menu);
    }
}
