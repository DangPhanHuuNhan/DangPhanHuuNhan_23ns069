package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.textEditorModel;
import view.textEditorView;

public class textEditorController {
    private textEditorModel model;
    private textEditorView view;

    public textEditorController(textEditorView view, textEditorModel model) {
        this.view = view;
        this.model = model;

        view.setSaveButtonListener(this::handleSave);
        view.setLoadButtonListener(this::handleLoad);
    }

    public void handleSave(ActionEvent e) {
        String text = view.getText();
        List<String> lines = Stream.of(text.split("\n")).collect(Collectors.toList());
        File file = view.getFileToSave();
        if (file != null) {
            model.saveToFile(lines, file);
        }
    }

    public void handleLoad(ActionEvent e) {
        File file = view.getFileToLoad();
        if (file != null) {
            List<String> lines = model.loadFromFile(file);
            String text = String.join("\n", lines);
            view.setText(text);
        }
    }
}
