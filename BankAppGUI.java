import javax.swing.*;
import java.awt.event.*;

public class BankAppGUI {
    static double balance = 0.0;
    static String ownerName;
    static String accountNumber;

    public static void main(String[] args) {
        // گرفتن نام و شماره حساب
        ownerName = JOptionPane.showInputDialog("Enter your name:");
        accountNumber = JOptionPane.showInputDialog("Enter your account number:");
        String startBalance = JOptionPane.showInputDialog("Enter initial balance:");
        balance = Double.parseDouble(startBalance);

        // ساخت پنجره
        JFrame frame = new JFrame("Bank Account - " + ownerName);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // دکمه‌ها
        JButton checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.setBounds(50, 20, 200, 30);
        frame.add(checkBalanceBtn);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 60, 200, 30);
        frame.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(50, 100, 200, 30);
        frame.add(withdrawBtn);

        JButton infoBtn = new JButton("Account Info");
        infoBtn.setBounds(50, 140, 200, 30);
        frame.add(infoBtn);

        // عملکرد دکمه‌ها
        checkBalanceBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "Balance: " + balance)
        );

        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter amount to deposit:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                balance += amount;
                JOptionPane.showMessageDialog(frame, "Deposited: " + amount);
            }
        });

        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter amount to withdraw:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                if (amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(frame, "Withdrawn: " + amount);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                }
            }
        });

        infoBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(frame,
                "Account Info:\nName: " + ownerName +
                "\nAccount #: " + accountNumber +
                "\nBalance: " + balance)
        );

        frame.setVisible(true);
    }
}

