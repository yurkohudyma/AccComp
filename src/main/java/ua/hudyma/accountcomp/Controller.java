package ua.hudyma.accountcomp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class Controller {
    @FXML
    private Button compare_button;

    @FXML
    private TextField text1 = new TextField("acc1");

    @FXML
    private TextField text2 = new TextField("acc2");

    @FXML
    protected void onCommit_compareButtonClick(ActionEvent e) {
        var t1 = text1.getText();
        var t2 = text2.getText();
        String resDiff = "";
        if (t1 == null || t2 == null || "".equals(t1) || "".equals(t2)) {
            compare_button.setText("Відсутні дані");
        } else {
            var eq = Objects.equals(t1, t2);
            if (!eq) {
                int diff = getDifferenceIndex(t1, t2);
                compare_button.setLayoutX(150);
                resDiff = t1.length() == t2.length() ? "Символи різні на поз " + diff + " (" + t1.charAt(diff) + "/" + t2.charAt(diff) + ")" : "Довжина різна";
            }
            compare_button.setText(eq ? "Одинакові!" : resDiff);
        }
    }

    private int getDifferenceIndex(String t1, String t2) {
        for (int i = 0; i < Math.min(t1.length(), t2.length()); i++) {
            if (t1.charAt(i) != t2.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    @FXML
    protected void acc1(ActionEvent e) {
        text1.setText(e.getSource().toString());
    }

    @FXML
    protected void acc2(ActionEvent e) {
        text2.setText(e.getSource().toString());
    }
}