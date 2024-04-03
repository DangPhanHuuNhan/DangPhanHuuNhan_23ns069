package main;

import controller.textEditorController;
import model.textEditorModel;
import view.textEditorView;

public class main {
    public static void main(String[] args) {
        textEditorModel model = new textEditorModel();
        textEditorView view = new textEditorView();
        textEditorController controller = new textEditorController(view, model);
        view.setVisible(true);
    }
}
