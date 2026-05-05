package controller;

import model.Customer;
import service.QueueManager;

import java.awt.*;

public class TokenController {

    public TextField nameField;
    public TextField ageField;
    public Label resultLabel;

    public void handleGenerate() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());

        Customer c = QueueManager.getInstance().generateToken(name, age);

        resultLabel.setText("Token: " + c.tokenNumber);
    }
}