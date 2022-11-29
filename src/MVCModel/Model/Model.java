package MVCModel.Model;

import Shapes.Shape;
import Utils.UserAction;
import MVCModel.View.View;

import java.util.ArrayList;

public class Model {

    private View view;

    private UserAction user_action;
    private Shape selected_item;
    private Shape current_drawing_item;
    private ArrayList<Shape> shapes;

    public Model() {
        user_action = UserAction.IDLE;
        shapes = new ArrayList<>();
    }

    public String getUserAction() {
        return user_action.toString();
    }

    public Shape getSelectedItem() {
        return selected_item;
    }

    public Shape getDrawingItem() {
        return current_drawing_item;
    }

    public ArrayList<Shape> getShapeList() {
        return shapes;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setUserAction(UserAction user_action) {
        this.user_action = user_action;
        view.update();
    }

    public void setDrawingItem(Shape item) {
        current_drawing_item = item;
        view.update();
    }

    public void setSelectedItem(Shape item) {
        if (selected_item != null) {
            selected_item.setSelected(false);
        }
        selected_item = item;
        view.update();
    }

    public void setShapeList(ArrayList<Shape> shapes) {
        this.shapes = shapes;
        view.update();
    }
}
