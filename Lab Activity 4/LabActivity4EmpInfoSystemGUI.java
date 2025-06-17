import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {

    TextField tfFirstName, tfLastName, tfAge, tfHoursWorked, tfHourlyRate;
    TextArea taOutput;
    Button btnSubmit;

    public LabActivity4EmpInfoSystemGUI() {
        setLayout(null);
        setTitle("Melo - Laboratory Activity 4");
        setSize(450, 550);

        // Labels
        Label lblFirstName = new Label("First Name :");
        lblFirstName.setBounds(20, 50, 100, 20);
        add(lblFirstName);

        Label lblLastName = new Label("Last Name :");
        lblLastName.setBounds(20, 80, 100, 20);
        add(lblLastName);

        Label lblAge = new Label("Age :");
        lblAge.setBounds(20, 110, 100, 20);
        add(lblAge);

        Label lblHoursWorked = new Label("Hours Worked :");
        lblHoursWorked.setBounds(20, 140, 100, 20);
        add(lblHoursWorked);

        Label lblHourlyRate = new Label("Hourly Rate :");
        lblHourlyRate.setBounds(20, 170, 100, 20);
        add(lblHourlyRate);

        // TextFields
        tfFirstName = new TextField();
        tfFirstName.setBounds(140, 50, 200, 20);
        add(tfFirstName);

        tfLastName = new TextField();
        tfLastName.setBounds(140, 80, 200, 20);
        add(tfLastName);

        tfAge = new TextField();
        tfAge.setBounds(140, 110, 200, 20);
        add(tfAge);

        tfHoursWorked = new TextField();
        tfHoursWorked.setBounds(140, 140, 200, 20);
        add(tfHoursWorked);

        tfHourlyRate = new TextField();
        tfHourlyRate.setBounds(140, 170, 200, 20);
        add(tfHourlyRate);

        // Submit Button
        btnSubmit = new Button("Submit");
        btnSubmit.setBounds(180, 210, 80, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        // Output TextArea
        taOutput = new TextArea("", 5, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        taOutput.setBounds(20, 260, 400, 200);
        taOutput.setEditable(false);
        add(taOutput);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        String ageStr = tfAge.getText().trim();
        String hoursStr = tfHoursWorked.getText().trim();
        String rateStr = tfHourlyRate.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || hoursStr.isEmpty() || rateStr.isEmpty()) {
            taOutput.setText("Error: All fields must be filled out.");
        } else {
            try {
                int age = Integer.parseInt(ageStr);
                double hoursWorked = Double.parseDouble(hoursStr);
                double hourlyRate = Double.parseDouble(rateStr);
                double salary = hoursWorked * hourlyRate;

                taOutput.setText("Output:\n" +
                        "Full Name: " + firstName + " " + lastName + "\n" +
                        "Age: " + age + "\n" +
                        "Salary: " + String.format("%.2f", salary));
            } catch (NumberFormatException e) {
                taOutput.setText("Error: Hours Worked and Hourly Rate must be valid numbers.");
            }
        }
    }

    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI();
    }
}
