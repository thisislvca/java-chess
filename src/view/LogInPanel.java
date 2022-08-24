package view;

import model.RoundJPasswordField;
import model.RoundJTextField;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * @param Finestra per il login
 */
public class LogInPanel extends JPanel {

    // --- attributi
    private JPanel         contentPane;
    private JLabel         lblTitolo;
    private JTextField     txtFUsernameLogIn;
    private JPasswordField passFLogIn;
    private JButton        BtnLogIn;
    private JLabel         lblUsername;
    private JLabel         lblPassword;
    private JLabel         lblMsgUsername;
    private JLabel         lblMsgPassword;
    private JLabel         lblMsgLogIn;
    private JButton        BtnRegister;

    /**
     * @param costruttore
     */
    public LogInPanel() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        lblTitolo = new JLabel();
        Font lblTitoloFont = this.$$$getFont$$$(null, Font.BOLD, 48, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Log-In");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        gbc.ipady = 20;
        contentPane.add(lblTitolo, gbc);
        txtFUsernameLogIn = new JTextField(20);
        txtFUsernameLogIn.setUI(new RoundJTextField());
        txtFUsernameLogIn.setName("Username");
        txtFUsernameLogIn.setToolTipText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 400;
        contentPane.add(txtFUsernameLogIn, gbc);
        passFLogIn = new JPasswordField(20);
        passFLogIn.setUI(new RoundJPasswordField());
        passFLogIn.setName("Password");
        passFLogIn.setText("");
        passFLogIn.setToolTipText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFLogIn, gbc);
        lblUsername = new JLabel();
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        lblPassword = new JLabel();
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 30;
        contentPane.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer4, gbc);
        BtnLogIn = new JButton();
        Font BtnLogInFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnLogIn.getFont());
        if (BtnLogInFont != null) BtnLogIn.setFont(BtnLogInFont);
        BtnLogIn.setText("ACCEDI");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnLogIn, gbc);
        lblMsgUsername = new JLabel();
        lblMsgUsername.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        contentPane.add(lblMsgUsername, gbc);
        lblMsgPassword = new JLabel();
        lblMsgPassword.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgPassword, gbc);
        lblMsgLogIn = new JLabel();
        lblMsgLogIn.setHorizontalAlignment(0);
        lblMsgLogIn.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        contentPane.add(lblMsgLogIn, gbc);
        BtnRegister = new JButton();
        Font BtnRegisterFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnRegister.getFont());
        if (BtnRegisterFont != null) BtnRegister.setFont(BtnRegisterFont);
        BtnRegister.setText("REGISTRATI");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnRegister, gbc);

        add(contentPane);
        setVisible(true);

    }

    // --- Getters
    // #################### JLABELS ####################
    public JLabel getLblMsgUsername() {
        return lblMsgUsername;
    }

    public JLabel getLblMsgPassword() {
        return lblMsgPassword;
    }

    public JLabel getLblMsgLogIn() {
        return lblMsgLogIn;
    }

    // #################### JTEXTFIELD ####################
    public JTextField getTxtFUsernameLogIn() {
        return txtFUsernameLogIn;
    }

    // #################### JPASSWORDFIELD ####################
    public JPasswordField getPassFLogIn() {
        return passFLogIn;
    }

    // #################### JBUTTONS ####################
    public JButton getBtnLogIn() {
        return BtnLogIn;
    }

    public JButton getBtnRegister() {
        return BtnRegister;
    }

    // #################### METODI RESET CAMPI ####################
    public void emptyFields() {
        getTxtFUsernameLogIn().setText("");
        getPassFLogIn().setText("");
    }

    public void emptyMsg() {
        getLblMsgLogIn().setText("");
        getLblMsgUsername().setText("");
        getLblMsgPassword().setText("");
    }

    // #################### METODI MESSAGGI ####################
    public void errorMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsgUsername().setForeground(new Color(208, 1, 1));
                getLblMsgUsername().setText(frase);
            }
            case 1 -> {
                getLblMsgPassword().setForeground(new Color(208, 1, 1));
                getLblMsgPassword().setText(frase);
            }
            case 2 -> {
                getLblMsgLogIn().setForeground(new Color(208, 1, 1));
                getLblMsgLogIn().setText(frase);
            }

        }
    }

    public void successMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsgUsername().setForeground(new Color(1, 178, 16));
                getLblMsgUsername().setText(frase);
            }
            case 1 -> {
                getLblMsgPassword().setForeground(new Color(1, 178, 16));
                getLblMsgPassword().setText(frase);
            }
            case 2 -> {
                getLblMsgLogIn().setForeground(new Color(1, 178, 16));
                getLblMsgLogIn().setText(frase);
            }
        }
    }

    public void warningMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsgUsername().setForeground(new Color(208, 150, 1));
                getLblMsgUsername().setText(frase);
            }
            case 1 -> {
                getLblMsgPassword().setForeground(new Color(208, 150, 1));
                getLblMsgPassword().setText(frase);
            }
            case 2 -> {
                getLblMsgLogIn().setForeground(new Color(208, 150, 1));
                getLblMsgLogIn().setText(frase);
            }
        }
    }

    // #################### METODO LISTENER ####################
    public void listener(ActionListener e) {
        getBtnLogIn().addActionListener(e);
        getBtnRegister().addActionListener(e);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        lblTitolo = new JLabel();
        Font lblTitoloFont = this.$$$getFont$$$(null, Font.BOLD, 48, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Log-In");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        gbc.ipady = 20;
        contentPane.add(lblTitolo, gbc);
        txtFUsernameLogIn = new JTextField();
        txtFUsernameLogIn.setName("Username");
        txtFUsernameLogIn.setToolTipText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 400;
        contentPane.add(txtFUsernameLogIn, gbc);
        passFLogIn = new JPasswordField();
        passFLogIn.setName("Password");
        passFLogIn.setText("");
        passFLogIn.setToolTipText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFLogIn, gbc);
        lblUsername = new JLabel();
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        lblPassword = new JLabel();
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 30;
        contentPane.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer4, gbc);
        BtnLogIn = new JButton();
        Font BtnLogInFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnLogIn.getFont());
        if (BtnLogInFont != null) BtnLogIn.setFont(BtnLogInFont);
        BtnLogIn.setText("ACCEDI");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnLogIn, gbc);
        lblMsgUsername = new JLabel();
        lblMsgUsername.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        contentPane.add(lblMsgUsername, gbc);
        lblMsgPassword = new JLabel();
        lblMsgPassword.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgPassword, gbc);
        lblMsgLogIn = new JLabel();
        lblMsgLogIn.setHorizontalAlignment(0);
        lblMsgLogIn.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        contentPane.add(lblMsgLogIn, gbc);
        BtnRegister = new JButton();
        Font BtnRegisterFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnRegister.getFont());
        if (BtnRegisterFont != null) BtnRegister.setFont(BtnRegisterFont);
        BtnRegister.setText("REGISTRATI");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnRegister, gbc);
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
        return contentPane;
    }

}
