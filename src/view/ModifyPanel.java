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
 * @param Finestra per la modifica dell'account
 */
public class ModifyPanel extends JPanel {

    // --- attributi
    private JPanel         contentPane;
    private JLabel         lblTitolo;
    private JLabel         lblUsername;
    private JTextField     txtFUsernameModProfile;
    private JLabel         lblPassword;
    private JButton        BtnModify;
    private JButton        BtnBack;
    private JPasswordField passFModProfile;
    private JLabel         lblMsgUsername;
    private JLabel         lblMsgPassword;
    private JLabel         lblMsgModify;

    /**
     * @param costruttore classe
     */
    public ModifyPanel() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        lblTitolo = new JLabel();
        Font lblTitoloFont = this.$$$getFont$$$(null, -1, 36, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Modifica Account");
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
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer2, gbc);
        lblUsername = new JLabel();
        Font lblUsernameFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblUsername.getFont());
        if (lblUsernameFont != null) lblUsername.setFont(lblUsernameFont);
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Vecchio Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        txtFUsernameModProfile = new JTextField(20);
        txtFUsernameModProfile.setUI(new RoundJTextField());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtFUsernameModProfile, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer3, gbc);
        lblPassword = new JLabel();
        Font lblPasswordFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblPassword.getFont());
        if (lblPasswordFont != null) lblPassword.setFont(lblPasswordFont);
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Vecchia Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer4, gbc);
        BtnModify = new JButton();
        Font BtnModifyFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnModify.getFont());
        if (BtnModifyFont != null) BtnModify.setFont(BtnModifyFont);
        BtnModify.setText("MODIFICA");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnModify, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 40;
        contentPane.add(spacer5, gbc);
        passFModProfile = new JPasswordField(20);
        passFModProfile.setUI(new RoundJPasswordField());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFModProfile, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        contentPane.add(spacer6, gbc);
        lblMsgUsername = new JLabel();
        lblMsgUsername.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgUsername, gbc);
        lblMsgPassword = new JLabel();
        lblMsgPassword.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgPassword, gbc);
        BtnBack = new JButton();
        Font BtnBackFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnBack.getFont());
        if (BtnBackFont != null) BtnBack.setFont(BtnBackFont);
        BtnBack.setText("INDIETRO");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnBack, gbc);
        lblMsgModify = new JLabel();
        lblMsgModify.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        contentPane.add(lblMsgModify, gbc);

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

    public JLabel getLblMsgModify() {
        return lblMsgModify;
    }

    // #################### JTEXTFIELD ####################
    public JTextField getTxtFUsernameModProfile() {
        return txtFUsernameModProfile;
    }

    // #################### JPASSWORDFIELD ####################
    public JPasswordField getPassFModProfile() {
        return passFModProfile;
    }

    // #################### JBUTTONS ####################
    public JButton getBtnModify() {
        return BtnModify;
    }

    public JButton getBtnBack() {
        return BtnBack;
    }

    // #################### METODI RESET CAMPI ####################
    public void emptyFields() {
        getTxtFUsernameModProfile().setText("");
        getPassFModProfile().setText("");
    }

    public void emptyMsg() {
        getLblMsgUsername().setText("");
        getLblMsgPassword().setText("");
        getLblMsgModify().setText("");
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
                getLblMsgModify().setForeground(new Color(208, 1, 1));
                getLblMsgModify().setText(frase);
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
                getLblMsgModify().setForeground(new Color(1, 178, 16));
                getLblMsgModify().setText(frase);
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
                getLblMsgModify().setForeground(new Color(208, 150, 1));
                getLblMsgModify().setText(frase);
            }
        }
    }

    // #################### METODO LISTENER ####################
    public void listener(ActionListener e) {
        getBtnModify().addActionListener(e);
        getBtnBack().addActionListener(e);
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
        Font lblTitoloFont = this.$$$getFont$$$(null, -1, 36, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Modifica Account");
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
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer2, gbc);
        lblUsername = new JLabel();
        Font lblUsernameFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblUsername.getFont());
        if (lblUsernameFont != null) lblUsername.setFont(lblUsernameFont);
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Vecchio Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        txtFUsernameModProfile = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtFUsernameModProfile, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer3, gbc);
        lblPassword = new JLabel();
        Font lblPasswordFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblPassword.getFont());
        if (lblPasswordFont != null) lblPassword.setFont(lblPasswordFont);
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Vecchio Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer4, gbc);
        BtnModify = new JButton();
        Font BtnModifyFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnModify.getFont());
        if (BtnModifyFont != null) BtnModify.setFont(BtnModifyFont);
        BtnModify.setText("MODIFICA");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnModify, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 40;
        contentPane.add(spacer5, gbc);
        passFModProfile = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFModProfile, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        contentPane.add(spacer6, gbc);
        lblMsgUsername = new JLabel();
        lblMsgUsername.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgUsername, gbc);
        lblMsgPassword = new JLabel();
        lblMsgPassword.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 20;
        contentPane.add(lblMsgPassword, gbc);
        BtnBack = new JButton();
        Font BtnBackFont = this.$$$getFont$$$(null, Font.BOLD, 16, BtnBack.getFont());
        if (BtnBackFont != null) BtnBack.setFont(BtnBackFont);
        BtnBack.setText("INDIETRO");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 25;
        contentPane.add(BtnBack, gbc);
        lblMsgModify = new JLabel();
        lblMsgModify.setHorizontalAlignment(0);
        lblMsgModify.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        contentPane.add(lblMsgModify, gbc);
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
