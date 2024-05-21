import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

public class MainGUI {
    private static UserManager userManager = new UserManager();
    private static ScheduleManager scheduleManager = new ScheduleManager();
    private static NotificationManager notificationManager = new NotificationManager();
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainGUI window = new MainGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

        JPanel welcomePanel = new JPanel();
        frame.getContentPane().add(welcomePanel, "name_116379432744800");
        welcomePanel.setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to the Student Assistant System!");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(10, 11, 414, 14);
        welcomePanel.add(lblWelcome);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(10, 36, 414, 23);
        welcomePanel.add(btnRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 70, 414, 23);
        welcomePanel.add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(10, 104, 414, 23);
        welcomePanel.add(btnExit);

        JPanel registerPanel = new JPanel();
        frame.getContentPane().add(registerPanel, "name_116379527517400");
        registerPanel.setLayout(null);

        JLabel lblRegister = new JLabel("User Registration");
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setBounds(10, 11, 414, 14);
        registerPanel.add(lblRegister);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(147, 36, 277, 20);
        registerPanel.add(txtUsername);
        txtUsername.setColumns(10);

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(147, 67, 277, 20);
        registerPanel.add(txtPassword);
        txtPassword.setColumns(10);

        JTextField txtFullName = new JTextField();
        txtFullName.setBounds(147, 98, 277, 20);
        registerPanel.add(txtFullName);
        txtFullName.setColumns(10);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(147, 129, 277, 20);
        registerPanel.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 39, 127, 14);
        registerPanel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 70, 127, 14);
        registerPanel.add(lblPassword);

        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(10, 101, 127, 14);
        registerPanel.add(lblFullName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 132, 127, 14);
        registerPanel.add(lblEmail);

        JButton btnSubmitRegister = new JButton("Submit");
        btnSubmitRegister.setBounds(147, 160, 277, 23);
        registerPanel.add(btnSubmitRegister);

        JButton btnBackRegister = new JButton("Back");
        btnBackRegister.setBounds(10, 160, 127, 23);
        registerPanel.add(btnBackRegister);

        JPanel loginPanel = new JPanel();
        frame.getContentPane().add(loginPanel, "name_116379571821700");
        loginPanel.setLayout(null);

        JLabel lblLogin = new JLabel("User Login");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBounds(10, 11, 414, 14);
        loginPanel.add(lblLogin);

        JTextField txtLoginUsername = new JTextField();
        txtLoginUsername.setBounds(147, 36, 277, 20);
        loginPanel.add(txtLoginUsername);
        txtLoginUsername.setColumns(10);

        JTextField txtLoginPassword = new JTextField();
        txtLoginPassword.setBounds(147, 67, 277, 20);
        loginPanel.add(txtLoginPassword);
        txtLoginPassword.setColumns(10);

        JLabel lblLoginUsername = new JLabel("Username:");
        lblLoginUsername.setBounds(10, 39, 127, 14);
        loginPanel.add(lblLoginUsername);

        JLabel lblLoginPassword = new JLabel("Password:");
        lblLoginPassword.setBounds(10, 70, 127, 14);
        loginPanel.add(lblLoginPassword);

        JButton btnSubmitLogin = new JButton("Submit");
        btnSubmitLogin.setBounds(147, 98, 277, 23);
        loginPanel.add(btnSubmitLogin);

        JButton btnBackLogin = new JButton("Back");
        btnBackLogin.setBounds(10, 98, 127, 23);
        loginPanel.add(btnBackLogin);

        JPanel schedulePanel = new JPanel();
        frame.getContentPane().add(schedulePanel, "name_116379615401600");
        schedulePanel.setLayout(null);

        JLabel lblSchedule = new JLabel("Schedule Management");
        lblSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        lblSchedule.setBounds(10, 11, 414, 14);
        schedulePanel.add(lblSchedule);

        JButton btnAddScheduleItem = new JButton("Add Schedule Item");
        btnAddScheduleItem.setBounds(10, 36, 414, 23);
        schedulePanel.add(btnAddScheduleItem);

        JButton btnViewSchedule = new JButton("View Schedule");
        btnViewSchedule.setBounds(10, 70, 414, 23);
        schedulePanel.add(btnViewSchedule);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(10, 104, 414, 23);
        schedulePanel.add(btnLogout);

        JPanel addSchedulePanel = new JPanel();
        frame.getContentPane().add(addSchedulePanel, "name_116379658372500");
        addSchedulePanel.setLayout(null);

        JLabel lblAddSchedule = new JLabel("Add Schedule Item");
        lblAddSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddSchedule.setBounds(10, 11, 414, 14);
        addSchedulePanel.add(lblAddSchedule);

        JTextField txtTitle = new JTextField();
        txtTitle.setBounds(147, 36, 277, 20);
        addSchedulePanel.add(txtTitle);
        txtTitle.setColumns(10);

        JTextField txtDateTime = new JTextField();
        txtDateTime.setBounds(147, 67, 277, 20);
        addSchedulePanel.add(txtDateTime);
        txtDateTime.setColumns(10);

        JTextField txtDescription = new JTextField();
        txtDescription.setBounds(147, 98, 277, 20);
        addSchedulePanel.add(txtDescription);
        txtDescription.setColumns(10);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setBounds(10, 39, 127, 14);
        addSchedulePanel.add(lblTitle);

        JLabel lblDateTime = new JLabel("Date & Time (yyyy-MM-dd HH:mm):");
        lblDateTime.setBounds(10, 70, 127, 14);
        addSchedulePanel.add(lblDateTime);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(10, 101, 127, 14);
        addSchedulePanel.add(lblDescription);

        JButton btnSubmitSchedule = new JButton("Submit");
        btnSubmitSchedule.setBounds(147, 129, 277, 23);
        addSchedulePanel.add(btnSubmitSchedule);

        JButton btnBackSchedule = new JButton("Back");
        btnBackSchedule.setBounds(10, 129, 127, 23);
        addSchedulePanel.add(btnBackSchedule);

        JPanel viewSchedulePanel = new JPanel();
        frame.getContentPane().add(viewSchedulePanel, "name_116379702029500");
        viewSchedulePanel.setLayout(new BorderLayout(0, 0));

        JLabel lblViewSchedule = new JLabel("View Schedule");
        lblViewSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        viewSchedulePanel.add(lblViewSchedule, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        viewSchedulePanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnBackViewSchedule = new JButton("Back");
        viewSchedulePanel.add(btnBackViewSchedule, BorderLayout.SOUTH);

        // Action Listeners
        btnRegister.addActionListener(e -> switchPanel(registerPanel));
        btnLogin.addActionListener(e -> switchPanel(loginPanel));
        btnExit.addActionListener(e -> System.exit(0));

        btnBackRegister.addActionListener(e -> switchPanel(welcomePanel));
        btnSubmitRegister.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String fullName = txtFullName.getText();
            String email = txtEmail.getText();
            User user = new User(username, password, fullName, email);
            boolean success = userManager.registerUser(user);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Registration successful!");
                switchPanel(welcomePanel);
            } else {
                JOptionPane.showMessageDialog(frame, "Username already exists. Please choose another username.");
            }
        });

        btnBackLogin.addActionListener(e -> switchPanel(welcomePanel));
        btnSubmitLogin.addActionListener(e -> {
            String username = txtLoginUsername.getText();
            String password = txtLoginPassword.getText();
            User user = userManager.loginUser(username, password);
            if (user != null) {
                JOptionPane.showMessageDialog(frame, "Login successful! Welcome, " + user.getFullName() + "!");
                switchPanel(schedulePanel);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.");
            }
        });

        btnAddScheduleItem.addActionListener(e -> switchPanel(addSchedulePanel));
        btnViewSchedule.addActionListener(e -> {
            textArea.setText("");
            List<ScheduleItem> items = scheduleManager.getScheduleItems();
            for (ScheduleItem item : items) {
                textArea.append(item.getTitle() + "\t"
                        + item.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\t"
                        + item.getDescription() + "\n");
            }
            switchPanel(viewSchedulePanel);
        });
        btnLogout.addActionListener(e -> switchPanel(welcomePanel));

        btnBackSchedule.addActionListener(e -> switchPanel(schedulePanel));
        btnSubmitSchedule.addActionListener(e -> {
            String title = txtTitle.getText();
            String dateTimeStr = txtDateTime.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            String description = txtDescription.getText();
            ScheduleItem item = new ScheduleItem(title, dateTime, description);
            scheduleManager.addScheduleItem(item);
            JOptionPane.showMessageDialog(frame, "Schedule item added successfully!");
            switchPanel(schedulePanel);
        });

        btnBackViewSchedule.addActionListener(e -> switchPanel(schedulePanel));
    }

    private void switchPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    // Method to display notification message
    public void displayNotification(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    // Method to set alarm
    // Method to set alarm
    public void setAlarm(LocalDateTime dateTime) {
        notificationManager.setAlarm(dateTime);
    }

}
