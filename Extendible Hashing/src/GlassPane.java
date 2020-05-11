/*
 * @author kumar
 * @author lohia
 * @author pant
 * @author sukrit
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JRootPane;

public class GlassPane extends javax.swing.JComponent
{
    private final HashMap<JComponent, JComponent> linked;

    public GlassPane()
    {
        super();
        linked = new HashMap<>();
    }
    
    public void link(JComponent c1, JComponent c2)
    {
        linked.put(c1, c2);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.BLACK);
        for(JComponent c1 : linked.keySet())
        {
            Point p1 = getRectCenter(getBoundsInWindow(c1));
            Point p2 = getRectCenter(getBoundsInWindow(linked.get(c1)));
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    
    private Point getRectCenter(Rectangle rect)
    {
        return new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
    }
    
    private Rectangle getBoundsInWindow(Component component)
    {
        return getRelativeBounds(component, getRootPaneAncestor(component));
    }
    
    private Rectangle getRelativeBounds(Component component, Component relativeTo)
    {
        return new Rectangle(getRelativeLocation(component, relativeTo), component.getSize());
    }

    private Point getRelativeLocation(Component component, Component relativeTo)
    {
        Point los = component.getLocationOnScreen();
        Point rt = relativeTo.getLocationOnScreen();
        return new Point(los.x - rt.x, los.y - rt.y);
    }
    
    private JRootPane getRootPaneAncestor(Component c)
    {
        for(Container p = c.getParent(); p != null; p = p.getParent())
        {
            if(p instanceof JRootPane)
            {
                return (JRootPane) p;
            }
        }
        return null;
    }
}