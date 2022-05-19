import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener{
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    public static void main(String args[]){
        JFrame frame = new JFrame("Autenticazione");
        JPanel panel = new JPanel();
        JLabel userLabel = new JLabel("Username");

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50,80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Accedi");
        button.setBounds(10, 80, 80, 25);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        button.addActionListener(new Login());
        panel.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        if(user.equals("salvatorevigano9@gmail.com") && password.equals("Marlboro1924!"))
            System.out.println("Login avvenuto con successo");
        else
            System.out.println("Errore, riprova");
    }
}