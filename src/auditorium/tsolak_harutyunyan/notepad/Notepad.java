package auditorium.tsolak_harutyunyan.notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import auditorium.bracechecker.BraceChecker;

public class Notepad extends JFrame {

    private static final String DEFAULT_NAME = "Notepad";
    private JTextArea textArea;
    private JTextField resultMessageFile;
    private JFileChooser jFileChooser;
    private BraceChecker braceChecker;
    private File file;

    private JMenuItem newFile;
    private JMenuItem openFile;
    private JMenuItem saveFile;
    private JMenuItem savaAsFile;
//    private JMenuItem searchFile;
    private JMenuItem exitFile;

    public Notepad() {
        super(DEFAULT_NAME);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        jFileChooser = new JFileChooser();
        textArea = new JTextArea();
        resultMessageFile = new JTextField();
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(1, 1);
        jPanel.setLayout(layout);
        jPanel.add(resultMessageFile);
        add(textArea, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);

        // Add MenuBar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //Add Menu
        JMenu mFile = new JMenu("File");
        JMenu mLang = new JMenu("Language");

        //Language menu items
        JMenuItem mItemEn = new JMenuItem(LanguageType.EN.getLabel());
        JMenuItem mItemAm = new JMenuItem(LanguageType.AM.getLabel());
        JMenuItem mItemRu = new JMenuItem(LanguageType.RU.getLabel());

        mLang.add(mItemEn);
        mLang.add(mItemAm);
        mLang.add(mItemRu);

        //Add MenuItem

        initMenuItems(LanguageType.EN);

        mFile.add(newFile);
        mFile.add(openFile);
        mFile.add(saveFile);
        mFile.add(savaAsFile);
 //       mFile.add(searchFile);
        mFile.add(exitFile);

        menuBar.add(mFile);
        menuBar.add(mLang);

        // Add ActionListener
        mItemEn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMenusLabels(LanguageType.EN);

            }
        });

        mItemAm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMenusLabels(LanguageType.AM);
            }
        });

        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newAction(e);
            }
        });
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAction(e);
            }
        });

        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAction(e);
            }
        });

        savaAsFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savaAsFileAction(e);
            }
        });

        exitFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExitAction();
            }
        });

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleDocumentUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleDocumentUpdate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleDocumentUpdate();
            }
        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(100, 100);
        setVisible(true);
    }


    private Properties getMenuLabels(LanguageType languageType) {
        String posix = languageType == LanguageType.AM
                ? "_" + LanguageType.AM.getLabel()
                : languageType == LanguageType.RU
                ? "_" + LanguageType.RU.getLabel()
                : "";

        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("i18n/labels" + posix + ".properties");

        Properties labels = new Properties();
        try {
            labels.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return labels;
    }

    private void initMenuItems(LanguageType languageType) {
        newFile = new JMenuItem();
        openFile = new JMenuItem();
        saveFile = new JMenuItem();
        savaAsFile = new JMenuItem();
        exitFile = new JMenuItem();
        loadMenusLabels(languageType);
    }

    private void loadMenusLabels(LanguageType languageType) {
        Properties labels = getMenuLabels(languageType);
        loadMenusLabels(labels);
    }

    private void loadMenusLabels(Properties labels) {
        newFile.setText(labels.getProperty(LabelKey.NEW.getName()));
        openFile.setText("Open");
        saveFile.setText(labels.getProperty(LabelKey.SAVE.getName()));
        savaAsFile.setText("Save as");
        exitFile.setText("Exit");
    }


    private void handleDocumentUpdate() {
        braceChecker = new BraceChecker();
        if (!braceChecker.parse(textArea.getText())) {
            resultMessageFile.setForeground(Color.red);
            resultMessageFile.setText(braceChecker.getMessage());
        } else {
            resultMessageFile.setForeground(Color.darkGray);
            resultMessageFile.setText("No Error");
        }
    }

    private void handleExitAction() {
        if (isChanged() && !handleSaveConfirmDialog(ActionType.EXIT)) {
            return;
        }
        exit();
    }

    private void searchFileAction(ActionEvent e) {
        //SearchFrame searchFrame = new SearchFrame();
    }

    private void savaAsFileAction(ActionEvent e) {
        saveAs();
    }

    private void saveAction(ActionEvent e) {
        save();
    }

    private void openAction(ActionEvent e) {
        if (isChanged()) {
            if (!handleSaveConfirmDialog(ActionType.OPEN)) {
                return;
            }
        }
        open();
    }

    /**
     * Opens a confirm dialog window to ask
     * save or no the content of TextArea or cancel the action.
     * if save is chosen then the content save,  otherwise if selected no nothing is saved.
     *
     * @return false if selected cancel option, otherwise true.
     */
    private boolean handleSaveConfirmDialog(ActionType actionType) {
        switch (askSave()) {
            case JOptionPane.CANCEL_OPTION:
                return false;
            case JOptionPane.YES_OPTION:
                if ((ActionType.SAVE_AS == actionType) || isNewMode()) {
                    saveAs();
                } else {
                    save();
                }
        }

        return true;
    }

    private void newAction(ActionEvent e) {
        if (isChanged() && !handleSaveConfirmDialog(ActionType.NEW)) {
            return;
        }
        newFile();
    }

    public void exit() {
        System.exit(0);
    }

    public void save() {
        if (file != null) {
            write(file, textArea.getText());
        } else {
            saveAs();
        }
    }

    public void saveAs() {
        int choice = jFileChooser.showSaveDialog(textArea);
        if (choice == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            write(jFileChooser.getSelectedFile());
            setTitle(file.getName());
        }
    }

    public void newFile() {
        setTitle(DEFAULT_NAME);
        textArea.setText("");
        file = null;
    }

    public void open() {
        if (jFileChooser.showOpenDialog(jFileChooser) == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            textArea.setText(read(file));
            setTitle(file.getName());
        }
    }


    public void write(File file ) {
        write(file, textArea.getText());
    }

    public void write(File file, String text) {
        String path;
        if (!file.getName().contains(".txt")) {
            path = file.getAbsolutePath() + ".txt";
        } else {
            path = file.getAbsolutePath();
        }
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            outputStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(File file) {
        byte[] b = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }

    private boolean isTextChenged (File file) {
        if (file == null) {
            return false;
        }
        return !textArea.getText().equals(read(file));
    }

    private int askSave() {
        int returnVal = JOptionPane.showConfirmDialog(null, "Do you want save file");
        return returnVal;
    }

    private boolean isNewMode() {
        return file == null;
    }

    private boolean isChanged() {
        if (isNewMode() && textArea.getText().length() > 0) {
            return true;
        } else if (!isNewMode() && isTextChenged(file)) {
            return true;
        }
        return false;
    }

    private enum ActionType {NEW, SAVE, SAVE_AS, OPEN, EXIT}


    public static void main(String[] args) {
        new Notepad();
    }


}

enum LabelKey {
    NEW("new"),
    SAVE("save"),
    SAVE_AS("saveas"),
    OPEN("open"),
    EXIT("exit");

    LabelKey(String val) {
        this.name = val;
    }

    public String getName() {
        return name;
    }

    public static LabelKey getByName (String name) {
        LabelKey lk = null;

        switch (lk){
            case NEW:
            case OPEN:
                //DO something

        }

        LabelKey[] labels = values();
        for (LabelKey labelKey : labels) {
            if(labelKey.getName().equals(name) ){
                return labelKey;
            }
        }
        return null;
    }

    private final String name;
}

class LanguageType {
    static final LanguageType AM = new LanguageType(1, "hy", "Armenian");
    static final LanguageType EN = new LanguageType(2, "en", "English");
    static final LanguageType RU = new LanguageType(3, "ru", "Russian");

    private LanguageType(int value, String label, String description) {
        this.value = value;
        this.label = label;
        this.description = description;
    }

    String getLabel() {
        return label;
    }

    private final int value;
    private final String label;
    private final String description;

}