package com.bull.plugin;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyToolWindowFactory implements ToolWindowFactory, DumbAware {

    private DefaultTableModel tableModel;

    @Override 
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        // Create the main panel 
        JPanel panel = new JPanel(new BorderLayout());

        // Create a table with initial data 
        String[] initialColumnNames = {"", "Column 2", "Column 3"};
        Object[][] initialData = {
                {"Data 1", "Data 2", "Data 3"},
                {"Data 4", "Data 5", "Data 6"},
                {"Data 7", "Data 8", "Data 9"}
        };
        tableModel = new DefaultTableModel(initialData, initialColumnNames);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Create a button to update the table data 
        JButton updateButton = new JButton("Update Table");
        panel.add(updateButton, BorderLayout.SOUTH);

        // Add an ActionListener to the button to update the table data 
        updateButton.addActionListener(event -> updateTableData());

        // Set the content of the tool window 
        toolWindow.getComponent().add(panel);
    }

    private void updateTableData() {
        // New data and column names 
        String[] newColumnNames = {"New Column 1", "New Column 2", "New Column 3", "New Column 4"};
        Object[][] newData = {
                {"New Data 1", "New Data 2", "New Data 3", "New Data 4"},
                {"New Data 5", "New Data 6", "New Data 7", "New Data 8"},
                {"New Data 9", "New Data 10", "New Data 11", "New Data 12"}
        };

        // Update the table model with new data and column names 
        tableModel.setDataVector(newData, newColumnNames);
    }
}
