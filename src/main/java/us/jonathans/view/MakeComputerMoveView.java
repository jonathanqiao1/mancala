package us.jonathans.view;

import us.jonathans.interface_adapters.MakeComputerMoveController;
import us.jonathans.interface_adapters.MakeComputerMoveViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeComputerMoveView extends JFrame {
    private final JButton aiMoveButton; // Button to trigger AI move
    private final MakeComputerMoveController controller;

    public MakeComputerMoveView(MakeComputerMoveController controller) {
        this.controller = controller;

        // Create the "Make AI Move" button (will remove after this is implemented later)
        aiMoveButton = new JButton("Make AI Move");
        aiMoveButton.setBounds(125, 50, 150, 50);
        add(aiMoveButton);

        // Add button click listener
        aiMoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Trigger the AI move via the controller
                controller.execute();
            }
        });

        // Show the frame
        setVisible(true);
    }

    public void displayUpdatedBoard(MakeComputerMoveViewModel viewModel) {
    }

}
