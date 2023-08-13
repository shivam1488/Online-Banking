import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankingSystem implements ActionListener {
  private JFrame mainFrame;
  private JTextField inputField;
  private JLabel balanceLabel;
  private int balance = 0;
private static BankingSystem bankingSystem;

  public BankingSystem() {

    mainFrame = new JFrame("Simple Bank Application");
    mainFrame.setVisible(true);
    mainFrame.setSize(400, 400);
    mainFrame.setFont(new Font("Arial",Font.BOLD,18));
    mainFrame.setLayout(new FlowLayout());

    inputField = new JTextField(10);
    balanceLabel = new JLabel("Current balance: " + balance);
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");

    mainFrame.add(inputField);
    mainFrame.add(depositButton);
    mainFrame.add(withdrawButton);
    mainFrame.add(balanceLabel);

    depositButton.addActionListener(this);
    withdrawButton.addActionListener(this);

    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int amount = Integer.parseInt(inputField.getText());
    if (e.getActionCommand().equals("Deposit")) {
      balance += amount;
    } else {
      balance -= amount;
    }
    balanceLabel.setText("Current balance: " + balance);
    inputField.setText("");
  }

  /**
 * @param args
 */
public static void main(String[] args) {
    bankingSystem = new BankingSystem();
  }

public JFrame getMainFrame() {
    return mainFrame;
}

public void setMainFrame(JFrame mainFrame) {
    this.mainFrame = mainFrame;
}

public JTextField getInputField() {
    return inputField;
}

public void setInputField(JTextField inputField) {
    this.inputField = inputField;
}

public JLabel getBalanceLabel() {
    return balanceLabel;
}

public void setBalanceLabel(JLabel balanceLabel) {
    this.balanceLabel = balanceLabel;
}

public int getBalance() {
    return balance;
}

public void setBalance(int balance) {
    this.balance = balance;
}

public static BankingSystem getBankingSystem() {
    return bankingSystem;
}

public static void setBankingSystem(BankingSystem bankingSystem) {
    BankingSystem.bankingSystem = bankingSystem;
}
}