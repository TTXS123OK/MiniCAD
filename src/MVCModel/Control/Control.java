package MVCModel.Control;

import MVCModel.Model.Model;
import MVCModel.Utils.UserAction;
import MVCModel.View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {

    private Model model;

    private UserAction user_action;


    public void setModel(Model model) {
        this.model = model;
    }

    public String getUserAction() {
        return user_action.toString();
    }

    public class ButtonActionListener implements ActionListener {
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
}
