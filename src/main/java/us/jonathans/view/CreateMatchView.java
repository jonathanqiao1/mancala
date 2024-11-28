package us.jonathans.view;

import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreateMatchView extends JPanel {
    private final static String viewName = "Create Match";

    public CreateMatchView(
            StartGameController startGameController,
            StartGameViewModel startGameViewModel
    ) {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;


        JLabel usernameInputLabel = new JLabel("Username");
        JTextField usernameInputField = new JTextField(12);

        add(usernameInputLabel, gbc1);
        add(usernameInputField, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 2;
        gbc3.gridy = 1;
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 3;
        gbc4.gridy = 1;
        JLabel phoneInputLabel = new JLabel("Phone");
        JTextField phoneInputField = new JTextField(12);

        add(phoneInputLabel, gbc3);
        add(phoneInputField, gbc4);


        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 3;
        gbc6.gridy = 0;
        JCheckBox usePhoneCheckbox = new JCheckBox("Send SMS");
        add(usePhoneCheckbox, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 1;
        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 1;
        gbc8.gridy = 1;
        JLabel selectEngineLabel = new JLabel("Engine");
        JComboBox<String> selectEngineDropdown = new JComboBox<>(
                new String[]{"Randomizer3000", "MiniMax"}
        );

        add(selectEngineLabel, gbc7);
        add(selectEngineDropdown, gbc8);

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridy = 2;
        gbc9.fill = GridBagConstraints.HORIZONTAL;
        gbc9.gridwidth = 4;

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        JButton startMatchButton = new JButton("Start");
        JButton cancelMatchButton = new JButton("Cancel");

        buttons.add(cancelMatchButton);
        buttons.add(startMatchButton);

        add(buttons, gbc9);

        phoneInputField.setEnabled(false);
        usePhoneCheckbox.addItemListener(e -> {
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            phoneInputField.setEnabled(checked);
        });

        startMatchButton.addActionListener(e -> {
            startGameController.execute("1", "1", "1");
        });
    }
}
