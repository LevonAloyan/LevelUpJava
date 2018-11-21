package homework16.IV_16.emma_abgaryan;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Emma on 4/13/2016.
 */
public class Notepad extends JFrame {
    private String fileName;
    private final String DEFAULT_NAME = "untitled";
    private boolean isChanged = false;
    private File currentFile;
    private Reader reader;
    private Writer writer;
    private JTextArea textArea;

    public Notepad() {

        fileName = DEFAULT_NAME;
        textArea = new JTextArea();

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem New = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open...");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As...");
        JMenuItem exit = new JMenuItem("Exit");
        JScrollPane scroll = new JScrollPane(textArea);

        file.add(New);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(exit);
        menuBar.add(file);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scroll);
        add(menuBar, BorderLayout.NORTH);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isChanged = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isChanged = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isChanged = true;
            }
        });

        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newActionPerformed(e);
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openActionPerformed(e);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveActionPerformed(e);
            }
        });

        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsActionPerformed(e);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitActionPerformed(e);
            }
        });

        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        changeTitle();


    }

    private void newActionPerformed(ActionEvent e) {
        if (checkForSave()) {
            int selecteOption = JOptionPane.showConfirmDialog(
                    this,
                    "Do You want to save changes '" + fileName + "'");
            if (selecteOption == JOptionPane.NO_OPTION) {
                textArea.setText("");
            } else if (selecteOption == JOptionPane.YES_OPTION) {
                saveAsActionPerformed(e);
                realiseNewOptions();
            }
        } else {
            realiseNewOptions();
        }
    }

    private void realiseNewOptions(){
        currentFile = null;
        fileName = DEFAULT_NAME;
        textArea.setText("");
        isChanged = false;
        changeTitle();
    }

    private void openActionPerformed(ActionEvent e) {
        if (checkForSave() || isChanged) {
            int selecteOption = JOptionPane.showConfirmDialog(
                    this,
                    "Do You want to save changes '" + fileName + "'");
            if (selecteOption == JOptionPane.NO_OPTION) {
                openWindowActions();
            } else if (selecteOption == JOptionPane.YES_OPTION) {
                saveAsActionPerformed(e);
            }
        } else {
            openWindowActions();
        }

    }

    private void openWindowActions(){
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            textArea.setText(reader(currentFile));
            fileName = currentFile.getName();
            isChanged = false;
            changeTitle();
        }
    }

    private void saveActionPerformed(ActionEvent e) {
        if (currentFile == null) {
            saveAsActionPerformed(e);
        } else {
            try {
                writer = new FileWriter(currentFile);
                BufferedWriter buff = new BufferedWriter(writer);
                buff.write(textArea.getText());
                buff.close();
                isChanged = false;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void saveAsActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showSaveDialog(this);
        if (choice == JFileChooser.CANCEL_OPTION) {
        } else if (choice == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            saveActionPerformed(e);
            fileName = currentFile.getName();
            changeTitle();
        }
    }

    private void exitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private boolean checkForSave() {
        return fileName.equals(DEFAULT_NAME) && textArea.getText().length() > 0;
    }

    private void changeTitle() {
        setTitle(fileName + " - Notepad");
    }

    private String reader(File currentFile) {
        this.currentFile = currentFile;
        String tmp;
        String res = "";
        try {
            reader = new FileReader(this.currentFile);
            BufferedReader br = new BufferedReader(reader);
            while ((tmp = br.readLine()) != null) {
                res += tmp;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    public static void main(String[] args) {
        new Notepad();
    }
}
