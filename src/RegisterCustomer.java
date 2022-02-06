import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

public class RegisterCustomer {
    private JPanel panel1;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField roomField;
    private JButton addCustomerButton;
    private JButton viewAllCustomersButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField dayTextField;
    private JTextField monthTextField;
    private JTextField yearTextField;
    private JComboBox roomComboBox;
    private JFrame frame;
    private ButtonGroup buttonGroup;

    public RegisterCustomer(Manager user) {
        frame = new JFrame();
        $$$setupUI$$$();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setVisible(true);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);
        addCustomerButton.addActionListener(e -> {
            if (validateInput() == 0) {
                JOptionPane.showMessageDialog(null, "Customer has been registered successfully!", "Registration Complete", JOptionPane.PLAIN_MESSAGE);
                addNewCustomer(compileNewData());
            }
        });
    }

    private void addNewCustomer(Customer c) {
        String record = "" + c.getId() + "//" + c.getName() + "//" + c.getRole() + "//" + c.getGender() + "//" +
                c.getEmail() + "//" + c.getDOB() + "//" + c.getRoomNumber() + "\n";
        try {
            FileWriter fileWriter = new FileWriter("./TextFiles/Customers.txt", true);
            BufferedWriter file = new BufferedWriter(fileWriter);
            file.write(record);
            file.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Customer compileNewData() {
        int unqiueID = Customer.fetchCustomerCount() + 1001;
        String DOB = yearTextField.getText() + "/" + monthTextField.getText() + "/" + dayTextField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        return new Customer(Integer.toString(unqiueID),
                nameField.getText(),
                "Customer",
                emailField.getText(),
                DOB,
                gender,
                Integer.parseInt((String) Objects.requireNonNull(roomComboBox.getSelectedItem())));
    }

    private int validateInput() {
        if (nameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input a name!", "Registration Failure", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        if (emailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input an email address!", "Registration Failure", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select customer gender!", "Registration Failure", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        if (dayTextField.getText().equals("") || monthTextField.getText().equals("") || yearTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input correct date of birth!", "Registration Failure", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        return 0;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel2.setBackground(new Color(-4605511));
        panel2.setPreferredSize(new Dimension(0, 50));
        panel1.add(panel2, BorderLayout.NORTH);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Serif", Font.BOLD, 28, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16777216));
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("Customer Registration");
        panel2.add(label1, BorderLayout.CENTER);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel3.setBackground(new Color(-1));
        panel1.add(panel3, BorderLayout.CENTER);
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Arial", Font.PLAIN, 12, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-16777216));
        label2.setText("Name");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 10, 10);
        panel3.add(label2, gbc);
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Arial", Font.PLAIN, 12, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-16777216));
        label3.setText("Email");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        panel3.add(label3, gbc);
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Arial", Font.PLAIN, 12, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-16777216));
        label4.setText("Gender");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        panel3.add(label4, gbc);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 25));
        nameField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 10, 0);
        panel3.add(nameField, gbc);
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(49, 25));
        emailField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 0);
        panel3.add(emailField, gbc);
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Arial", Font.PLAIN, 12, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-16777216));
        label5.setText("Room");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        panel3.add(label5, gbc);
        maleRadioButton = new JRadioButton();
        maleRadioButton.setForeground(new Color(-16777216));
        maleRadioButton.setHideActionText(false);
        maleRadioButton.setText("Male");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel3.add(maleRadioButton, gbc);
        femaleRadioButton = new JRadioButton();
        femaleRadioButton.setForeground(new Color(-16777216));
        femaleRadioButton.setHideActionText(false);
        femaleRadioButton.setText("Female");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 0);
        panel3.add(femaleRadioButton, gbc);
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Arial", Font.PLAIN, 12, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-16777216));
        label6.setText("DOB");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 5, 0);
        panel3.add(label6, gbc);
        dayTextField = new JTextField();
        dayTextField.setForeground(new Color(-16777216));
        dayTextField.setHorizontalAlignment(0);
        dayTextField.setMinimumSize(new Dimension(20, 26));
        dayTextField.setPreferredSize(new Dimension(70, 26));
        dayTextField.setText("Day");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 5, 10);
        panel3.add(dayTextField, gbc);
        monthTextField = new JTextField();
        monthTextField.setForeground(new Color(-16777216));
        monthTextField.setHorizontalAlignment(0);
        monthTextField.setMinimumSize(new Dimension(20, 26));
        monthTextField.setPreferredSize(new Dimension(70, 26));
        monthTextField.setText("Month");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 5, 10);
        panel3.add(monthTextField, gbc);
        yearTextField = new JTextField();
        yearTextField.setForeground(new Color(-16777216));
        yearTextField.setHorizontalAlignment(0);
        yearTextField.setMinimumSize(new Dimension(25, 26));
        yearTextField.setPreferredSize(new Dimension(70, 26));
        yearTextField.setText("Year");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 5, 0);
        panel3.add(yearTextField, gbc);
        roomComboBox = new JComboBox();
        roomComboBox.setMinimumSize(new Dimension(81, 38));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("1");
        defaultComboBoxModel1.addElement("2");
        defaultComboBoxModel1.addElement("3");
        defaultComboBoxModel1.addElement("4");
        defaultComboBoxModel1.addElement("5");
        defaultComboBoxModel1.addElement("6");
        defaultComboBoxModel1.addElement("7");
        defaultComboBoxModel1.addElement("8");
        defaultComboBoxModel1.addElement("9");
        defaultComboBoxModel1.addElement("10");
        defaultComboBoxModel1.addElement("11");
        defaultComboBoxModel1.addElement("12");
        defaultComboBoxModel1.addElement("13");
        defaultComboBoxModel1.addElement("14");
        defaultComboBoxModel1.addElement("15");
        defaultComboBoxModel1.addElement("16");
        defaultComboBoxModel1.addElement("17");
        defaultComboBoxModel1.addElement("18");
        defaultComboBoxModel1.addElement("19");
        defaultComboBoxModel1.addElement("20");
        roomComboBox.setModel(defaultComboBoxModel1);
        roomComboBox.setPreferredSize(new Dimension(76, 25));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 0);
        panel3.add(roomComboBox, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panel4.setBackground(new Color(-1));
        panel4.setPreferredSize(new Dimension(0, 90));
        panel1.add(panel4, BorderLayout.SOUTH);
        viewAllCustomersButton = new JButton();
        viewAllCustomersButton.setForeground(new Color(-16777216));
        viewAllCustomersButton.setText("View All Customers");
        panel4.add(viewAllCustomersButton);
        addCustomerButton = new JButton();
        addCustomerButton.setForeground(new Color(-16777216));
        addCustomerButton.setText("Add Customer");
        panel4.add(addCustomerButton);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}