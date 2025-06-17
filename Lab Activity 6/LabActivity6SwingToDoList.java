import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList{

    // Adding Frames and Components.
    JFrame frameToDoList; //
    JFrame frameAddTask; //
    JTextField tfTaskName; //
    JTextArea taTaskDesc; //
    JComboBox cbStatus; 
    JTable listTable; //
    JScrollPane displayList; //
    JButton buttonOpenForm; //
    JButton buttonAddItem;

    // Variables.
    String [] columnNames = {"Task Name", "Task Description", "Status"};
    String[] taskStatus = {"Not Started", "Ongoing", "Completed"};
    String[][] taskInfo = {}; // Multidimensional Array to store task information.
    int taskNum = 0;

    //Main Frame
    public LabActivity6SwingToDoList() {
        frameToDoList = new JFrame("To-Do List");
        frameToDoList.setSize(800, 600);
        frameToDoList.setLayout(null);
        frameToDoList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonOpenForm = new JButton("Open Form");
        buttonOpenForm.setBounds(350, 10, 100, 50);
        buttonOpenForm.addActionListener(e -> taskForm());
        frameToDoList.add(buttonOpenForm);

        listTable = new JTable(new DefaultTableModel(columnNames, 0));
        displayList = new JScrollPane(listTable);
        displayList.setBounds(0, 70, 800, 500);
        frameToDoList.add(displayList);

        frameToDoList.setResizable(false);
        frameToDoList.setVisible(true);
    }

    // Task Form
    private void taskForm(){
        frameAddTask = new JFrame();
        frameAddTask.setSize(600,500);
        frameAddTask.setLayout(null);
        frameAddTask.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAddTask.setLocationRelativeTo(frameToDoList);

        // Task Name
        JLabel labelTaskName = new JLabel("Task Name:");
        labelTaskName.setBounds(10, 20, 100, 20);
        tfTaskName = new JTextField();
        tfTaskName.setBounds(50, 50, 500, 20);
        
        //Task Description
        JLabel labelTaskDesc = new JLabel("Task Description");
        labelTaskDesc.setBounds(10, 70, 100, 20);
        taTaskDesc = new JTextArea(10, 10);
        taTaskDesc.setBounds(50, 100, 500, 40);
        
        // Task Status
        JLabel labelTaskStatus = new JLabel("Task Status");
        labelTaskStatus.setBounds(10, 150, 100, 20);
        cbStatus = new JComboBox<>(taskStatus);
        cbStatus.setBounds(50, 180, 100, 20);
        
        // Save Task
        buttonAddItem = new JButton("Save Task");
        buttonAddItem.setBounds(225, 240, 150, 30);

        // ActionListener for saving tasks
        buttonAddItem.addActionListener(e -> {
            String taskName = tfTaskName.getText();
            String taskDesc = taTaskDesc.getText();
            String taskStat = (String) cbStatus.getSelectedItem();

            if (taskName.isEmpty() || taskStat.isBlank()) {
                JOptionPane.showMessageDialog(frameAddTask, "Please fill in the Task Name and Status.", "Input Error", 0);
            } else {
            
                DefaultTableModel model = (DefaultTableModel) listTable.getModel();
                model.addRow(new Object[]{taskName, taskDesc, taskStat});

                // Clear the form fields
                tfTaskName.setText("");
                taTaskDesc.setText("");
                cbStatus.setSelectedIndex(0);

                frameAddTask.dispose();  // Close the form
                }
            });

        frameAddTask.add(labelTaskName);
        frameAddTask.add(tfTaskName);
        frameAddTask.add(labelTaskDesc);
        frameAddTask.add(taTaskDesc);
        frameAddTask.add(labelTaskStatus);
        frameAddTask.add(cbStatus);
        frameAddTask.add(buttonAddItem);

        frameAddTask.setResizable(false);
        frameAddTask.setVisible(true);
    }

    public static void main(String[] args) {
        new LabActivity6SwingToDoList();
    }
}
