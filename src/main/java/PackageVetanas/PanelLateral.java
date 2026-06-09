package PackageVetanas;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class PanelLateral extends JPanel {

    private int curvaturaDerecha = 60; 

    public PanelLateral() {
        setOpaque(false); 
        setBackground(new Color(102, 0, 51)); 
    }

    // ========================================================
    // MAGIA PARA NETBEANS: Getter y Setter
    // ========================================================
    
    public int getCurvaturaDerecha() {
        return curvaturaDerecha;
    }

    public void setCurvaturaDerecha(int curvaturaDerecha) {
        this.curvaturaDerecha = curvaturaDerecha;
        repaint(); // ¡Muy importante! Obliga al panel a redibujarse al instante con la nueva curva
    }
    
    // ========================================================

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        RoundRectangle2D.Double panelCurvo = new RoundRectangle2D.Double(0, 0, ancho, alto, curvaturaDerecha, curvaturaDerecha);
        Area formaFinal = new Area(panelCurvo);

        Rectangle2D.Double ladoIzquierdoCuadrado = new Rectangle2D.Double(0, 0, curvaturaDerecha, alto);
        Area parche = new Area(ladoIzquierdoCuadrado);

        formaFinal.add(parche);

        g2.setColor(getBackground());
        g2.fill(formaFinal);

        g2.dispose();
    }
}