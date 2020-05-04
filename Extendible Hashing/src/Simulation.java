/*
 * @author kumar
 * @author lohia
 * @author pant
 * @author sukrit
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation extends javax.swing.JFrame
{
    private final JFrame parent;
    private int gd;
    private Vector<String> buckets;
    private final int bfr;
    private final GlassPane gp;
    private final Vector<Vector<Vector<JPanel>>> map;
    private int key;
    private String keyStr;
    private boolean flag;
    private String overflow;
    private final Vector<Integer> keys;
    private final Timer timer1;
    private final Timer timer2;
    private final Timer timer3;
    private final Timer timer4;
    private Vector<Vector<JPanel>> link;
    private final int DELAY = 500;
        
    public Simulation(int gd, Vector<String> buckets, int bfr, Vector<Integer> keys, JFrame parent)
    {
        this.setVisible(true);
        this.parent = parent;
        this.parent.dispose();
        this.gd = gd;
        this.buckets = buckets;
        this.bfr = bfr;
        this.map = new Vector<>();
        this.gp = new GlassPane();
        this.keys = keys;
        this.flag = false;
        this.overflow = null;
        this.timer4 = new Timer(DELAY, (ActionEvent e) -> {simulation4();});
        this.timer4.setRepeats(false);
        this.timer3 = new Timer(DELAY, (ActionEvent e) -> {
            if(simulation3())
            {
                timer4.start();
                if(flag)
                {
                    simulateNew();
                }
            }
        });
        this.timer3.setRepeats(false);
        this.timer2 = new Timer(DELAY, (ActionEvent e) -> {
            if(simulation2())
            {
                timer3.start();
            }
        });
        this.timer2.setRepeats(false);
        this.timer1 = new Timer(DELAY, (ActionEvent e) -> {
            if(simulation1())
            {
                timer2.start();
            }
        });
        this.timer1.setRepeats(false);
        initComponents();
        this.setGlassPane(gp);
        this.gp.setVisible(true);
        this.constructDirectories();
        this.constructBlocks();
        this.createMap();
        this.addKeys();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("ROG Fonts", 0, 30)); // NOI18N
        jLabel1.setText("EXTENDIBLE HASHING SIMULATION");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enter key");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Key entered:");
        jLabel2.setVisible(false);

        jButton2.setBackground(new java.awt.Color(0, 0, 51));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Simulate");
        jButton2.setVisible(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(412, 427));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setText("<HTML><U>Directories</U></HTML>");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel5.setLayout(new java.awt.GridLayout(0, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(412, 427));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel4.setText("<HTML><U>Data Buckets</U></HTML>");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel6.setLayout(new java.awt.GridLayout(0, bfr + 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void constructDirectories()
    {
        int maxgd = 1 << gd;
        Dimension size = jPanel5.getSize();
        size = new Dimension(size.width / 2, size.height / maxgd);
        for(int i = 0; i < maxgd; i++)
        {
            JPanel panel1 = new JPanel(new GridLayout(1, 1));
            RectangleText rect = new RectangleText(Utility.toBinary(i, gd), Color.RED, size);
            panel1.add(rect);
            JPanel panel2 = new JPanel(new GridLayout(1, 1));
            panel2.add(new RectangleText(size));
            jPanel5.add(panel1);
            jPanel5.add(panel2);
        }
    }
    
    private void constructBlocks()
    {
        int maxld = buckets.size();
        Dimension size = jPanel6.getSize();
        size = new Dimension(size.width / (bfr + 1), size.height / maxld);
        for(String bucketText : buckets)
        {
            JPanel panel1 = new JPanel(new GridLayout(1, 1));
            RectangleText rect = new RectangleText(bucketText, Color.RED, size);
            panel1.add(rect);
            jPanel6.add(panel1);
            for(int j = 0; j < bfr; j++)
            {
                JPanel panel2 = new JPanel(new GridLayout(1, 1));
                panel2.add(new RectangleText(size));
                jPanel6.add(panel2);
            }
        }
    }
    
    private void createMap()
    {
        int maxgd = 1 << gd;
        int maxld = buckets.size();
        for(int i = 0; i < maxgd; i++)
        {
            JPanel dir = (JPanel) jPanel5.getComponent(2 * i);
            RectangleText rect = (RectangleText) dir.getComponent(0);
            JPanel dir2 = (JPanel) jPanel5.getComponent(2 * i + 1);
            Vector<Vector<JPanel>> lnk = new Vector<>();
            Vector<JPanel> vd = new Vector<>();
            vd.add(dir);
            vd.add(dir2);
            lnk.add(vd);
            for(int j = 0; j < maxld; j++)
            {
                JPanel block = (JPanel) jPanel6.getComponent((bfr + 1) * j);
                RectangleText rt = (RectangleText) block.getComponent(0);
                if(rect.getString().endsWith(rt.getString()))
                {
                    gp.link(dir2, block);
                    Vector<JPanel> vb = new Vector<>();
                    vb.add(block);
                    for(int k = 1; k <= bfr; k++)
                    {
                        JPanel p = (JPanel) jPanel6.getComponent((bfr + 1) * j + k);
                        vb.add(p);
                    }
                    lnk.add(vb);
                }
            }
            map.add(lnk);
        }
    }
    
    private void addKeys()
    {
        for(int x : keys)
        {
            key = x;
            keyStr = Utility.toBinary(key, 4);
            simulation1();
            simulation2();
            simulation3();
            simulation4();
            if(flag)
            {
                break;
            }
        }
        if(flag)
        {
            simulateNew();
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            String str = JOptionPane.showInputDialog(null, "Enter key to add", "Add key", JOptionPane.QUESTION_MESSAGE);
            key = Integer.parseInt(str);
            int out = Utility.hash(key);
            keyStr = Utility.toBinary(out, 4);
            jLabel2.setText("Key entered: " + str + " (" + keyStr + ")");
            jLabel2.setVisible(true);
            jButton1.setText("Change Key");
            jButton2.setVisible(true);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric key", "Key error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        keys.add(key);
        timer1.start();
    }//GEN-LAST:event_jButton2ActionPerformed
       
    private boolean simulation1()
    {
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        for(Vector<Vector<JPanel>> lnk : map)
        {
            Vector<JPanel> dir = lnk.get(0);
            JPanel textPanel = dir.get(0);
            RectangleText rect = (RectangleText) textPanel.getComponent(0);
            if(keyStr.endsWith(rect.getString()))
            {
                link = lnk;
                break;
            }
        }
        Vector<JPanel> dir = link.get(0);
        JPanel linkPanel = dir.get(1);
        RectangleText rect = (RectangleText) linkPanel.getComponent(0);
        linkPanel.add(new RectangleText(String.valueOf(key), Color.BLUE, rect.getDimension()), 0);
        linkPanel.remove(1);
        return true;
    }
    
    public boolean simulation2()
    {
        Vector<JPanel> dir = link.get(0);
        JPanel linkPanel = dir.get(1);
        RectangleText rect = (RectangleText) linkPanel.getComponent(0);
        linkPanel.add(new RectangleText(rect.getDimension()), 0);
        linkPanel.remove(1);
        return true;
    }
    
    public boolean simulation3()
    {
        Vector<JPanel> blocks = link.get(1);
        for(JPanel block : blocks)
        {
            RectangleText rt = (RectangleText) block.getComponent(0);
            String str = rt.getString();
            if(str == null)
            {
                block.add(new RectangleText(String.valueOf(key), rt.getDimension()), 0);
                block.remove(1);
                flag = false;
                return true;
            }
        }
        JPanel block = blocks.get(0);
        RectangleText rt = (RectangleText) block.getComponent(0);
        overflow = rt.getString();
        flag = true;
        return true;
    }
        
    public void simulation4()
    {
        jButton1.setText("Enter key");
        jButton1.setVisible(true);
        jLabel2.setVisible(false);
    }
    
    public void simulateNew()
    {
        Vector<String> copy = (Vector<String>) buckets.clone();
        JOptionPane.showMessageDialog(null, "Overflow condition reached.\nSplitting bucket " + overflow, "Overflow", JOptionPane.INFORMATION_MESSAGE);
        int index = buckets.indexOf(overflow);
        if(index == -1)
        {
            simulation2();
            simulation4();
        }
        else
        {
            int longest = Utility.longest(buckets);
            if(longest <= 4)
            {
                buckets.remove(overflow);
                buckets.add(index, "1" + overflow);
                buckets.add(index, "0" + overflow);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Local depth greater than 4\nKey cannot be added.\n(Local depth = " + longest + ")", "Overflow", JOptionPane.INFORMATION_MESSAGE);
                keys.remove(keys.size() - 1);
                System.out.println(buckets);
                System.out.println(overflow);
                System.out.println(keys);
                return;
            }
            longest = Utility.longest(buckets);
            if(longest > 4)
            {
                JOptionPane.showMessageDialog(null, "Local depth greater than 4\nKey cannot be added.\n(Local depth = " + longest + ")", "Overflow", JOptionPane.INFORMATION_MESSAGE);
                buckets = copy;
                System.out.println(keys);
                keys.remove(keys.size() - 1);
                System.out.println(keys);
                System.out.println(buckets);
                System.out.println(overflow);
                simulation2();
                simulation4();
                return;
            }
            else if(longest > gd)
            {
                JOptionPane.showMessageDialog(null, "Local depth exceeded global depth.\nGlobal depth increased\n(Local depth = " + longest + ", Global depth = " + gd + ")", "Overflow", JOptionPane.INFORMATION_MESSAGE);
                gd = longest;
            }
            Simulation simulation = new Simulation(gd, buckets, bfr, keys, this);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}