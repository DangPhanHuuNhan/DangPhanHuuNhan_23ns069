package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class textEditorView extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;
    private JFileChooser fileChooser;

    public textEditorView() {
        initComponents();
        setupUI();
    }

    private void initComponents() {
        textArea = new JTextArea(20, 40);
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        fileChooser = new JFileChooser();
    }

    private void setupUI() {
        setTitle("Text Editor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saveButton.addActionListener(e -> {
            if (saveListener != null) {
                saveListener.actionPerformed(e);
            }
        });

        loadButton.addActionListener(e -> {
            if (loadListener != null) {
                loadListener.actionPerformed(e);
            }
        });

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public File getFileToSave() {
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File getFileToLoad() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    private ActionListener saveListener;
    private ActionListener loadListener;

    public void setSaveButtonListener(ActionListener listener) {
        this.saveListener = listener;
    }

    public void setLoadButtonListener(ActionListener listener) {
        this.loadListener = listener;
    }
}
