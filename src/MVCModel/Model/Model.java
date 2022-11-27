package MVCModel.Model;

import MVCModel.Utils.UserAction;
import MVCModel.View.View;

public class Model {

    private View view;

    private UserAction user_action;

    public Model() {
        user_action = UserAction.IDLE;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getUserAction() {
        return user_action.toString();
    }

    public void setUserAction(UserAction user_action) {
        this.user_action = user_action;
        view.update();
    }
}
