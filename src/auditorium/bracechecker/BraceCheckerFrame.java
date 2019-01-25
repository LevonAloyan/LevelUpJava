package auditorium.bracechecker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BraceCheckerFrame extends JFrame {

  private JTextArea textArea = new JTextArea();
  private JTextField messageField = new JTextField();
  private BraceChecker braceChecker;

  public BraceCheckerFrame() {
    JPanel controlPanel = new JPanel();
    JPanel messagePanel = new JPanel();
    JScrollPane scrollPane = new JScrollPane();
    JButton parseButton = new JButton("Parse");

    parseButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        parseActionPerformed(e);
      }
    });

    controlPanel.add(parseButton);
    messagePanel.setLayout(new GridLayout(1, 1));

    messageField.setFont(messageField.getFont().deriveFont(Font.BOLD, 14));
    messageField.setForeground(Color.BLUE);

    messagePanel.add(messageField);

    scrollPane.getViewport().add(textArea);
    add(controlPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
    add(messagePanel, BorderLayout.SOUTH);

    setLocation(700,300);
    setSize(500, 400);
    setVisible(true);
//        setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

  }

  private void parseActionPerformed(ActionEvent e) {

    if (braceChecker == null) {
      braceChecker = new BraceChecker();
    }
    braceChecker.parse(textArea.getText());
    String resultMessage = braceChecker.getResultMessage();

    if (!resultMessage.equals(BraceChecker.MESSAGE_NO_ERROR)) {
      messageField.setForeground(Color.RED);
    } else {
      messageField.setForeground(Color.BLUE);
    }
    messageField.setText(resultMessage);
  }

  public static void main(String[] args) {
    new BraceCheckerFrame();
  }

}
