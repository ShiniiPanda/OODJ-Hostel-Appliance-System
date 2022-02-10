import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ManagerMenu {
    private JPanel panel1;
    private JPanel titlePanel;
    private JPanel mainPanel;
    private JPanel statusPanel;
    private JLabel profilePic;
    private JPanel userPanel;
    private JPanel picPanel;
    private JPanel menuChoices;
    private JButton registerCustomerButton;
    private JButton manageUsersButton;
    private JButton registerAppointmentButton;
    private JLabel userName;
    private JLabel userLevel;
    private JLabel userEmail;
    private JLabel userDOB;
    private JLabel currentDate;

    // Default menu with no user set (not currently used)
    public ManagerMenu() {
        JFrame frame = new JFrame();
        $$$setupUI$$$();
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setVisible(true);
        setCurrentDate();
    }

    // Menu accessed through system login, will call setLoggedUser()
    public ManagerMenu(Manager user) {
        JFrame frame = new JFrame();
        $$$setupUI$$$();
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setVisible(true);
        this.setLoggedUser(user);
        registerCustomerButton.addActionListener(e -> {
            frame.dispose();
            new RegisterCustomer(user);
        });
        ImageIcon registerIcon = new ImageIcon("./Icons/Register.png");
        registerCustomerButton.setIcon(registerIcon);
        setCurrentDate();
        registerAppointmentButton.addActionListener(e -> {
            frame.dispose();
            new RegisterAppointment(user);
        });
    }

    private void setLoggedUser(Manager user) {
        userName.setText(user.getName());
        userLevel.setText(user.getRole());
        userEmail.setText(user.getEmail());
        userDOB.setText(user.getDOB());
    }

    private void setCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime date = LocalDateTime.now();
        currentDate.setText(formatter.format(date));
    }

//    profilePic = new JLabel();
//    ImageIcon defaultPic = new ImageIcon("./Icons/user.png");
//        profilePic.setIcon(defaultPic);
//        profilePic.setMinimumSize(new Dimension(64, 64));
//        profilePic.setVisible(true);
//    Border profilePicBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
//        profilePic.setBorder(profilePicBorder);

    private void createUIComponents() {
        // TODO: place custom component creation code here
        profilePic = new JLabel();
        ImageIcon defaultPic = new ImageIcon("./Icons/user.png");
        profilePic.setIcon(defaultPic);
        profilePic.setMinimumSize(new Dimension(64, 64));
        profilePic.setVisible(true);
        Border profilePicBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        profilePic.setBorder(profilePicBorder);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout(0, 0));
        titlePanel.setBackground(new Color(-3421237));
        titlePanel.setForeground(new Color(-1));
        titlePanel.setPreferredSize(new Dimension(0, 50));
        panel1.add(titlePanel, BorderLayout.NORTH);
        titlePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-4605511));
        Font label1Font = this.$$$getFont$$$("Serif", Font.BOLD, 28, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16777216));
        label1.setHorizontalAlignment(0);
        label1.setOpaque(false);
        label1.setText("Manager Menu");
        titlePanel.add(label1, BorderLayout.CENTER);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(-1));
        panel1.add(mainPanel, BorderLayout.CENTER);
        statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout(0, 0));
        statusPanel.setPreferredSize(new Dimension(0, 110));
        mainPanel.add(statusPanel, BorderLayout.NORTH);
        picPanel = new JPanel();
        picPanel.setLayout(new BorderLayout(0, 0));
        picPanel.setBackground(new Color(-1));
        picPanel.setPreferredSize(new Dimension(130, 0));
        statusPanel.add(picPanel, BorderLayout.WEST);
        profilePic.setBackground(new Color(-1));
        profilePic.setHorizontalAlignment(0);
        profilePic.setText("");
        picPanel.add(profilePic, BorderLayout.CENTER);
        userPanel = new JPanel();
        userPanel.setLayout(new GridBagLayout());
        userPanel.setBackground(new Color(-1));
        userPanel.setMinimumSize(new Dimension(200, 100));
        userPanel.setPreferredSize(new Dimension(370, 0));
        statusPanel.add(userPanel, BorderLayout.CENTER);
        userPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label2 = new JLabel();
        label2.setHorizontalAlignment(2);
        label2.setHorizontalTextPosition(11);
        label2.setPreferredSize(new Dimension(40, 16));
        label2.setText("Name:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
        userPanel.add(label2, gbc);
        userName = new JLabel();
        userName.setText("Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 10, 30);
        userPanel.add(userName, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Email:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 30, 10, 0);
        userPanel.add(label3, gbc);
        userEmail = new JLabel();
        userEmail.setPreferredSize(new Dimension(130, 16));
        userEmail.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 10, 0);
        userPanel.add(userEmail, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Level:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        userPanel.add(label4, gbc);
        userLevel = new JLabel();
        userLevel.setText("Manager");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 30);
        userPanel.add(userLevel, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("DOB:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 30, 0, 0);
        userPanel.add(label5, gbc);
        userDOB = new JLabel();
        userDOB.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 0);
        userPanel.add(userDOB, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panel2.setBackground(new Color(-4605511));
        panel2.setPreferredSize(new Dimension(0, 30));
        mainPanel.add(panel2, BorderLayout.SOUTH);
        final JLabel label6 = new JLabel();
        label6.setText("Date:");
        panel2.add(label6);
        currentDate = new JLabel();
        currentDate.setText("currentDate");
        panel2.add(currentDate);
        menuChoices = new JPanel();
        menuChoices.setLayout(new GridBagLayout());
        menuChoices.setBackground(new Color(-1));
        mainPanel.add(menuChoices, BorderLayout.CENTER);
        registerCustomerButton = new JButton();
        registerCustomerButton.setHorizontalTextPosition(0);
        registerCustomerButton.setPreferredSize(new Dimension(150, 100));
        registerCustomerButton.setText("Register Customer");
        registerCustomerButton.setVerticalTextPosition(3);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 15);
        menuChoices.add(registerCustomerButton, gbc);
        manageUsersButton = new JButton();
        manageUsersButton.setHorizontalTextPosition(0);
        manageUsersButton.setPreferredSize(new Dimension(101, 100));
        manageUsersButton.setText("Manage Users");
        manageUsersButton.setVerticalTextPosition(3);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 15, 0, 15);
        menuChoices.add(manageUsersButton, gbc);
        registerAppointmentButton = new JButton();
        registerAppointmentButton.setHorizontalTextPosition(0);
        registerAppointmentButton.setPreferredSize(new Dimension(160, 100));
        registerAppointmentButton.setText("Register Appointment");
        registerAppointmentButton.setVerticalTextPosition(3);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 15, 0, 0);
        menuChoices.add(registerAppointmentButton, gbc);
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
