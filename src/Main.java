import MVCModel.Control.Control;
import MVCModel.Model.Model;
import MVCModel.View.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Control ctrl = new Control();

        model.setView(view);
        view.setModel(model);
        view.setCtrl(ctrl);
        ctrl.setModel(model);

        view.update();
        view.setVisible(true);
    }
}