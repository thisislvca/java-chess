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
 * @param Finestra di registrazione
 */
public class RegisterPanel extends JPanel {

    // --- attributi
    private JPanel         contentPane;
    private JLabel         lblTitolo;
    private JTextField     txtFCognomeSignUp;
    private JTextField     txtFNomeSignUp;
    private JTextField     txtFUsernameSignUp;
    private JPasswordField passFRegisterSignUp;
    private JButton        BtnRegistrazione;
    private JLabel         lblCognome;
    private JLabel         lblNome;
    private JLabel         lblUsername;
    private JLabel         lblPassword;
    private JLabel         lblMsgCognome;
    private JLabel         lblMsgNome;
    private JLabel         lblMsgUsername;
    private JLabel         lblMsgPassword;
    private JLabel         lblMsgSignUp;
    private JButton        BtnLogIn;

    /**
     * @param costruttore classe
     */
    public RegisterPanel() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        lblTitolo = new JLabel();
        Font lblTitoloFont = this.$$$getFont$$$(null, Font.BOLD, 48, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Sign-Up");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        contentPane.add(lblTitolo, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer2, gbc);
        txtFCognomeSignUp = new JTextField(20);
        txtFCognomeSignUp.setUI(new RoundJTextField());
        txtFCognomeSignUp.setToolTipText("Cognome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.ipadx = 400;
        contentPane.add(txtFCognomeSignUp, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer3, gbc);
        txtFNomeSignUp = new JTextField(20);
        txtFNomeSignUp.setUI(new RoundJTextField());
        txtFNomeSignUp.setToolTipText("Nome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtFNomeSignUp, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer4, gbc);
        txtFUsernameSignUp = new JTextField(20);
        txtFUsernameSignUp.setUI(new RoundJTextField());
        txtFUsernameSignUp.setToolTipText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtFUsernameSignUp, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer5, gbc);
        passFRegisterSignUp = new JPasswordField(20);
        passFRegisterSignUp.setUI(new RoundJPasswordField());
        passFRegisterSignUp.setToolTipText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFRegisterSignUp, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 35;
        contentPane.add(spacer6, gbc);
        BtnRegistrazione = new JButton();
        Font BtnRegistrazioneFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnRegistrazione.getFont());
        if (BtnRegistrazioneFont != null) BtnRegistrazione.setFont(BtnRegistrazioneFont);
        BtnRegistrazione.setText("REGISTRATI");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnRegistrazione, gbc);
        lblCognome = new JLabel();
        lblCognome.setHorizontalAlignment(0);
        lblCognome.setText("Cognome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblCognome, gbc);
        lblNome = new JLabel();
        lblNome.setHorizontalAlignment(0);
        lblNome.setText("Nome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblNome, gbc);
        lblUsername = new JLabel();
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        lblPassword = new JLabel();
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer7, gbc);
        lblMsgCognome = new JLabel();
        lblMsgCognome.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgCognome, gbc);
        lblMsgNome = new JLabel();
        lblMsgNome.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgNome, gbc);
        lblMsgUsername = new JLabel();
        lblMsgUsername.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgUsername, gbc);
        lblMsgPassword = new JLabel();
        lblMsgPassword.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgPassword, gbc);
        lblMsgSignUp = new JLabel();
        lblMsgSignUp.setHorizontalAlignment(0);
        lblMsgSignUp.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        contentPane.add(lblMsgSignUp, gbc);
        BtnLogIn = new JButton();
        Font BtnLogInFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnLogIn.getFont());
        if (BtnLogInFont != null) BtnLogIn.setFont(BtnLogInFont);
        BtnLogIn.setText("ACCEDI");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 15;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnLogIn, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 90;
        contentPane.add(spacer8, gbc);
        add(contentPane);
        setVisible(true);

    }

    // --- Getters
    // #################### JLABELS ####################
    public JLabel getLblMsgCognome() {
        return lblMsgCognome;
    }

    public JLabel getLblMsgNome() {
        return lblMsgNome;
    }

    public JLabel getLblMsgUsername() {
        return lblMsgUsername;
    }

    public JLabel getLblMsgPassword() {
        return lblMsgPassword;
    }

    public JLabel getLblMsgSignUp() {
        return lblMsgSignUp;
    }

    // #################### JTEXTFIELDS ####################
    public JTextField getTxtFCognomeSignUp() {
        return txtFCognomeSignUp;
    }

    public JTextField getTxtFNomeSignUp() {
        return txtFNomeSignUp;
    }

    public JTextField getTxtFUsernameSignUp() {
        return txtFUsernameSignUp;
    }

    // #################### JPASSWORDFIELD ####################
    public JPasswordField getPassFRegisterSignUp() {
        return passFRegisterSignUp;
    }

    // #################### JBUTTONS ####################
    public JButton getBtnRegistrazione() {
        return BtnRegistrazione;
    }

    public JButton getBtnLogIn() {
        return BtnLogIn;
    }

    // #################### METODI RESET CAMPI ####################
    public void emptyFields() {
        getTxtFCognomeSignUp().setText("");
        getTxtFNomeSignUp().setText("");
        getTxtFUsernameSignUp().setText("");
        getPassFRegisterSignUp().setText("");
    }

    public void emptyMsg() {
        getLblMsgCognome().setText("");
        getLblMsgNome().setText("");
        getLblMsgUsername().setText("");
        getLblMsgPassword().setText("");
        getLblMsgSignUp().setText("");
    }

    // #################### METODI MESSAGGI ####################
    public void errorMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsgCognome().setForeground(new Color(208, 1, 1));
                getLblMsgCognome().setText(frase);
            }
            case 1 -> {
                getLblMsgNome().setForeground(new Color(208, 1, 1));
                getLblMsgNome().setText(frase);
            }
            case 2 -> {
                getLblMsgUsername().setForeground(new Color(208, 1, 1));
                getLblMsgUsername().setText(frase);
            }
            case 3 -> {
                getLblMsgPassword().setForeground(new Color(208, 1, 1));
                getLblMsgPassword().setText(frase);
            }
            case 4 -> {
                getLblMsgSignUp().setForeground(new Color(208, 1, 1));
                getLblMsgSignUp().setText(frase);
            }
        }
    }

    public void successMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsgCognome().setForeground(new Color(1, 178, 16));
                getLblMsgCognome().setText(frase);
            }
            case 1 -> {
                getLblMsgNome().setForeground(new Color(1, 178, 16));
                getLblMsgNome().setText(frase);
            }
            case 2 -> {
                getLblMsgUsername().setForeground(new Color(1, 178, 16));
                getLblMsgUsername().setText(frase);
            }
            case 3 -> {
                getLblMsgPassword().setForeground(new Color(1, 178, 16));
                getLblMsgPassword().setText(frase);
            }
            case 4 -> {
                getLblMsgSignUp().setForeground(new Color(1, 178, 16));
                getLblMsgSignUp().setText(frase);
            }
        }
    }

    public void warningMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsgCognome().setForeground(new Color(208, 150, 1));
                getLblMsgCognome().setText(frase);
            }
            case 1 -> {
                getLblMsgNome().setForeground(new Color(208, 150, 1));
                getLblMsgNome().setText(frase);
            }
            case 2 -> {
                getLblMsgUsername().setForeground(new Color(208, 150, 1));
                getLblMsgUsername().setText(frase);
            }
            case 3 -> {
                getLblMsgPassword().setForeground(new Color(208, 150, 1));
                getLblMsgPassword().setText(frase);
            }
            case 4 -> {
                getLblMsgSignUp().setForeground(new Color(208, 150, 1));
                getLblMsgSignUp().setText(frase);
            }
        }
    }

    // #################### METODO LISTENER ####################
    public void listener(ActionListener e) {
        getBtnRegistrazione().addActionListener(e);
        getBtnLogIn().addActionListener(e);
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
        lblTitolo.setText("Sign-Up");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        contentPane.add(lblTitolo, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer2, gbc);
        txtFCognomeSignUp = new JTextField();
        txtFCognomeSignUp.setToolTipText("Cognome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.ipadx = 400;
        contentPane.add(txtFCognomeSignUp, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer3, gbc);
        txtFNomeSignUp = new JTextField();
        txtFNomeSignUp.setToolTipText("Nome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtFNomeSignUp, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer4, gbc);
        txtFUsernameSignUp = new JTextField();
        txtFUsernameSignUp.setToolTipText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtFUsernameSignUp, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer5, gbc);
        passFRegisterSignUp = new JPasswordField();
        passFRegisterSignUp.setToolTipText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFRegisterSignUp, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 35;
        contentPane.add(spacer6, gbc);
        BtnRegistrazione = new JButton();
        Font BtnRegistrazioneFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnRegistrazione.getFont());
        if (BtnRegistrazioneFont != null) BtnRegistrazione.setFont(BtnRegistrazioneFont);
        BtnRegistrazione.setText("REGISTRATI");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnRegistrazione, gbc);
        lblCognome = new JLabel();
        lblCognome.setHorizontalAlignment(0);
        lblCognome.setText("Cognome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblCognome, gbc);
        lblNome = new JLabel();
        lblNome.setHorizontalAlignment(0);
        lblNome.setText("Nome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblNome, gbc);
        lblUsername = new JLabel();
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        lblPassword = new JLabel();
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer7, gbc);
        lblMsgCognome = new JLabel();
        lblMsgCognome.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgCognome, gbc);
        lblMsgNome = new JLabel();
        lblMsgNome.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgNome, gbc);
        lblMsgUsername = new JLabel();
        lblMsgUsername.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgUsername, gbc);
        lblMsgPassword = new JLabel();
        lblMsgPassword.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgPassword, gbc);
        lblMsgSignUp = new JLabel();
        lblMsgSignUp.setHorizontalAlignment(0);
        lblMsgSignUp.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        contentPane.add(lblMsgSignUp, gbc);
        BtnLogIn = new JButton();
        Font BtnLogInFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnLogIn.getFont());
        if (BtnLogInFont != null) BtnLogIn.setFont(BtnLogInFont);
        BtnLogIn.setText("ACCEDI");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 15;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnLogIn, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 90;
        contentPane.add(spacer8, gbc);
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
