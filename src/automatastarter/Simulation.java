package automatastarter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.Timer;
import utils.CardSwitcher;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author brand
 */
public class Simulation extends javax.swing.JPanel implements ActionListener {
    
    public static final String CARD_NAME = "simulation";
    CardSwitcher switcher = null;
    /**
     * Creates new form Simulation
     */
    
    private boolean start = false;
    private int tickSpeed = 50;
    private Color color;
    private Timer t;
    private boolean showVirus;

    private GameOfLife simulation = new GameOfLife(0, 0, 600, 1200, 10);

    public Simulation(CardSwitcher p) {
        initComponents();
        t = new Timer(tickSpeed, this);
        t.start();
        switcher = p;
 
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        simulation.drawGrid(g, color);
        //simulation.drawGridLines(g);
        drawVirus(g);
        drawBorder(g);
    }
    
    public void drawVirus(Graphics g) {
        if (showVirus)
            simulation.drawVirusGrid(g);
    }
    public void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 1200, 0);
        g.drawLine(0, 600, 1200, 600);
        g.drawLine(0, 0, 0, 600);
        g.drawLine(1200, 0, 1200, 600);
    }
    
    public void update() {
        if (start)
            simulation.update();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startStopButton = new javax.swing.JToggleButton();
        changeDayButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        tickSpeedSlider = new javax.swing.JSlider();
        tickSpeedLabel = new javax.swing.JLabel();
        colorButton = new javax.swing.JButton();
        enableVirusButton = new javax.swing.JToggleButton();
        showVirusButton = new javax.swing.JToggleButton();
        Random1 = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        startStopButton.setText("Start");
        startStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopButtonActionPerformed(evt);
            }
        });

        changeDayButton.setText("Update Once");
        changeDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDayButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        tickSpeedSlider.setMajorTickSpacing(1);
        tickSpeedSlider.setMaximum(1000);
        tickSpeedSlider.setMinimum(1);
        tickSpeedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tickSpeedSliderStateChanged(evt);
            }
        });

        tickSpeedLabel.setText("Tick Speed: 50ms");

        colorButton.setText("Color");
        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });

        enableVirusButton.setText("Enable Virus");
        enableVirusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableVirusButtonActionPerformed(evt);
            }
        });

        showVirusButton.setText("Show Virus");
        showVirusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showVirusButtonActionPerformed(evt);
            }
        });

        Random1.setText("Random");
        Random1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Random1ActionPerformed(evt);
            }
        });

        infoButton.setText("Info");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(infoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(26, 26, 26)
                .addComponent(showVirusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Random1)
                .addGap(29, 29, 29)
                .addComponent(changeDayButton)
                .addGap(18, 18, 18)
                .addComponent(startStopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enableVirusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tickSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(tickSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addComponent(colorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(528, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Clear)
                        .addComponent(backButton)
                        .addComponent(changeDayButton)
                        .addComponent(enableVirusButton)
                        .addComponent(showVirusButton)
                        .addComponent(Random1)
                        .addComponent(infoButton)
                        .addComponent(startStopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tickSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tickSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        int mouseX = evt.getX();
        int mouseY = evt.getY();
        if (!start) {
            simulation.updateIndividualCell(mouseX, mouseY);
        }
    }//GEN-LAST:event_formMouseClicked

    private void startStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStopButtonActionPerformed
        // TODO add your handling code here:
        if (!start) {
            start = true;
            startStopButton.setText("Stop");
        }
        else if (start) {
            start = false;
            startStopButton.setText("Start");
        }
    }//GEN-LAST:event_startStopButtonActionPerformed

    private void changeDayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDayButtonActionPerformed
        // TODO add your handling code here:
        simulation.update();
    }//GEN-LAST:event_changeDayButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        switcher.switchToCard(IntroPanel.CARD_NAME);
    }//GEN-LAST:event_backButtonActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        simulation.clearGrid();
    }//GEN-LAST:event_ClearActionPerformed

    private void tickSpeedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tickSpeedSliderStateChanged
        // TODO add your handling code here:
        tickSpeed = tickSpeedSlider.getValue(); 
        tickSpeedLabel.setText("Tick Speed: " + tickSpeed + "ms");
        t.setDelay(tickSpeed);
    }//GEN-LAST:event_tickSpeedSliderStateChanged

    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButtonActionPerformed
        // TODO add your handling code here:
        
        color = Color.BLACK;
        
        color = JColorChooser.showDialog(this, "Select A colour", color);
        
        // If no color is selected
        if (color==null) {
            color = Color.BLACK;
        }
        
        colorButton.setBackground(color);
        
    }//GEN-LAST:event_colorButtonActionPerformed

    private void enableVirusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableVirusButtonActionPerformed
        // TODO add your handling code here:
        if (simulation.isUpdateWithVirus())  {
            simulation.setUpdateWithVirus(false);
            enableVirusButton.setText("Enable Virus");
        }
        else {
            simulation.setUpdateWithVirus(true);
            enableVirusButton.setText("Disable Virus");
        }

    }//GEN-LAST:event_enableVirusButtonActionPerformed

    private void showVirusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showVirusButtonActionPerformed
        // TODO add your handling code here:
        if (showVirus) {
            showVirus = false;
            showVirusButton.setText("Show Virus");
        }
        else {
            showVirus = true;
            showVirusButton.setText("Hide Virus");
        }
        
    }//GEN-LAST:event_showVirusButtonActionPerformed

    private void Random1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Random1ActionPerformed
        // TODO add your handling code here:
        simulation.clearVirus();
        simulation.createGrid();
    }//GEN-LAST:event_Random1ActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        // TODO add your handling code here:
        switcher.switchToCard(InfoPanel.CARD_NAME);
    }//GEN-LAST:event_infoButtonActionPerformed

    public void actionPerformed(ActionEvent e) {
        repaint();
        update();
    }
    public boolean isStart() {
        return start;
    }
    public void setStart(boolean start) {
        this.start = start;
    }
    public GameOfLife getSimulation() {
        return simulation;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Random1;
    private javax.swing.JButton backButton;
    private javax.swing.JButton changeDayButton;
    private javax.swing.JButton colorButton;
    private javax.swing.JToggleButton enableVirusButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JToggleButton showVirusButton;
    private javax.swing.JToggleButton startStopButton;
    private javax.swing.JLabel tickSpeedLabel;
    private javax.swing.JSlider tickSpeedSlider;
    // End of variables declaration//GEN-END:variables
}
