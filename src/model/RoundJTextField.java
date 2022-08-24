package model;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * @param JTextField arrotondato
 */
public class RoundJTextField extends BasicTextFieldUI {
    private int round       = 5;
    private int shadeWidth  = 2;
    private int textSpacing = 3;

    public void installUI(JComponent c) {
        super.installUI(c);

        c.setOpaque(false);

        int s = shadeWidth + 1 + textSpacing;
        c.setBorder(BorderFactory.createEmptyBorder(s, s, s, s));
    }

    protected void paintSafely(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Shape border = getBorderShape();

        Stroke os = g2d.getStroke();
        g2d.setStroke(new BasicStroke(shadeWidth * 2));
        g2d.setPaint(new Color(230, 230, 230));
        g2d.draw(border);
        g2d.setStroke(os);

        g2d.setPaint(Color.WHITE);
        g2d.fill(border);

        g2d.setPaint(Color.WHITE);
        g2d.draw(border);

        super.paintSafely(g);
    }

    private Shape getBorderShape() {
        JTextComponent component = getComponent();
        if (round > 0) {
            return new RoundRectangle2D.Double(shadeWidth, shadeWidth,
                    component.getWidth() - shadeWidth * 2 - 1,
                    component.getHeight() - shadeWidth * 2 - 1, round * 2, round * 2);
        } else {
            return new Rectangle2D.Double(shadeWidth, shadeWidth,
                    component.getWidth() - shadeWidth * 2 - 1,
                    component.getHeight() - shadeWidth * 2 - 1);
        }
    }
}
