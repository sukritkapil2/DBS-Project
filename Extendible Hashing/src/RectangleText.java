/*
 * @author kumar
 * @author lohia
 * @author pant
 * @author sukrit
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class RectangleText extends javax.swing.JComponent
{
    private final String str;
    private final Color clr;
    private final Dimension parentDim;
    
    public RectangleText(Dimension dim)
    {
        str = null;
        clr = Color.BLACK;
        parentDim = dim;
    }
    
    public RectangleText(String s, Dimension dim)
    {
        str = s;
        clr = Color.BLACK;
        parentDim = dim;
    }
    
    public RectangleText(Color c, Dimension dim)
    {
        str = null;
        clr = c;
        parentDim = dim;
    }
    
    public RectangleText(String s, Color c, Dimension dim)
    {
        str = s;
        clr = c;
        parentDim = dim;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int xmargin = (parentDim.width - 94) / 2;
        int ymargin = (parentDim.height - 29) / 2;
        g.setColor(clr);
        g.drawRect(xmargin, ymargin, 94, 29);
        if(str != null)
        {
            g.drawString(str, xmargin + 5, ymargin + 20);
        }
    }
    
    public String getString()
    {
        return str;
    }
}