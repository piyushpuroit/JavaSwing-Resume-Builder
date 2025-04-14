import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeBuilder extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JTextArea educationArea, skillsArea, experienceArea;
    private JButton generateButton;
    private JTabbedPane tabbedPane;
    private JTextArea outputArea;

    public ResumeBuilder() {
        setTitle("Resume Builder");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        JPanel outputPanel = new JPanel(new BorderLayout());

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Education:"));
        educationArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(educationArea));

        inputPanel.add(new JLabel("Skills:"));
        skillsArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(skillsArea));

        inputPanel.add(new JLabel("Experience:"));
        experienceArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(experienceArea));

        generateButton = new JButton("Generate Resume");
        inputPanel.add(generateButton);
        inputPanel.add(new JLabel());

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        tabbedPane.addTab("Input", inputPanel);
        tabbedPane.addTab("Resume", outputPanel);
        add(tabbedPane);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateResume();
                tabbedPane.setSelectedIndex(1);
            }
        });
    }

    private void generateResume() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String education = educationArea.getText();
        String skills = skillsArea.getText();
        String experience = experienceArea.getText();

        String resume = "Resume:\n" +
                "-------------------------------\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n\n" +
                "Education:\n" + education + "\n\n" +
                "Skills:\n" + skills + "\n\n" +
                "Experience:\n" + experience + "\n";

        outputArea.setText(resume);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResumeBuilder frame = new ResumeBuilder();
            frame.setVisible(true);
        });
    }
}