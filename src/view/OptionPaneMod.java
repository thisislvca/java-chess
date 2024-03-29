package view;

import model.RoundJPasswordField;
import model.RoundJTextField;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

/**
 * @param Classe per la selezione
 */
public class OptionPaneMod extends JPanel {

    // --- attributi
    private JPanel         contentPane;
    private JTextField     txtFUsernameOptionPane;
    private JLabel         lblUsername;
    private JPasswordField passFOptionPane;
    private JLabel         lblPassword;

    /**
     * @param costruttore classe
     */
    public OptionPaneMod() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        txtFUsernameOptionPane = new JTextField(20);
        txtFUsernameOptionPane.setUI(new RoundJTextField());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 250;
        contentPane.add(txtFUsernameOptionPane, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer2, gbc);
        lblUsername = new JLabel();
        Font lblUsernameFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblUsername.getFont());
        if (lblUsernameFont != null) lblUsername.setFont(lblUsernameFont);
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Nuovo Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        lblPassword = new JLabel();
        Font lblPasswordFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblPassword.getFont());
        if (lblPasswordFont != null) lblPassword.setFont(lblPasswordFont);
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Nuova Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        passFOptionPane = new JPasswordField(20);
        passFOptionPane.setUI(new RoundJPasswordField());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFOptionPane, gbc);

        add(contentPane);
        setVisible(true);

    }



    // --- Getters
    // #################### JTEXTFIELD ####################
    public JTextField getTxtFUsernameOptionPane() {
        return txtFUsernameOptionPane;
    }

    // #################### JPASSWORDFIELD ####################
    public JPasswordField getPassFOptionPane() {
        return passFOptionPane;
    }

    // #################### METODO RESET CAMPI ####################
    public void emptyFields() {
        getTxtFUsernameOptionPane().setText("");
        getPassFOptionPane().setText("");
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
        txtFUsernameOptionPane = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 250;
        contentPane.add(txtFUsernameOptionPane, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer2, gbc);
        lblUsername = new JLabel();
        Font lblUsernameFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblUsername.getFont());
        if (lblUsernameFont != null) lblUsername.setFont(lblUsernameFont);
        lblUsername.setHorizontalAlignment(0);
        lblUsername.setText("Nuovo Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblUsername, gbc);
        lblPassword = new JLabel();
        Font lblPasswordFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblPassword.getFont());
        if (lblPasswordFont != null) lblPassword.setFont(lblPasswordFont);
        lblPassword.setHorizontalAlignment(0);
        lblPassword.setText("Nuova Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        contentPane.add(lblPassword, gbc);
        passFOptionPane = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(passFOptionPane, gbc);
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
