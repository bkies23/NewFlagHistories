
package org.files;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlPanel extends JPanel
{
    JButton previousBtn = new JButton ("PREVIOUS");
    JButton nextBtn = new JButton ("NEXT");
    int forwardFlagTracker = 1;
    int backFlagTracker = 3;
    MainFrame mainFrame;
    String whichFlag;
    
    public ControlPanel (int width, int height, MainFrame mf)
    {
        setLayout(new FlowLayout());
        setPreferredSize (new Dimension (width, height));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
 
        previousBtn.setSize(85, 30);
        previousBtn.setVisible(true);
        // PREVIOUS button is disabled until User selects NEXT button
        previousBtn.setEnabled(false);
        add(previousBtn);
        
        nextBtn.setSize(85, 30);
        nextBtn.setVisible(true);
        nextBtn.setEnabled(true);
        add(nextBtn);
        
        nextBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                mf.setResizable(true); 
                mf.DRAWFLAG = true;
          
                if (forwardFlagTracker == 0)
                {
                    mf.bottomPanel.HideCoverLbl("Cover");
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.IntroText);
                    mf.topPanel.textArea.setVisible(true); 
                    previousBtn.setEnabled(false);
                    forwardFlagTracker++;
                }
                else if (forwardFlagTracker == 1)
                {
                    mf.bottomPanel.HideCoverLbl("Betsy Ross Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.BetsyRossText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    previousBtn.setEnabled(true);
                    backFlagTracker = forwardFlagTracker - 1;
                    forwardFlagTracker++;
                }
                else if (forwardFlagTracker == 2) 
                {
                    mf.bottomPanel.HideCoverLbl("Original 13 Star Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.Original13StarText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true);
                    backFlagTracker = forwardFlagTracker - 1;
                    forwardFlagTracker++;
                }
                else if (forwardFlagTracker == 3)
                {
                     mf.bottomPanel.HideCoverLbl("Lewis & Clark Flag");
                     mf.topPanel.scrollPane.setVisible(true);
                     mf.topPanel.textArea.setText(mf.topPanel.LewisAndClarkText);
                     mf.topPanel.textArea.setCaretPosition(0);
                     mf.topPanel.textArea.setVisible(true);
                     backFlagTracker = forwardFlagTracker - 1;
                     forwardFlagTracker++;
                }
                else if (forwardFlagTracker == 4)
                {
                    mf.bottomPanel.HideCoverLbl("20 Star American Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.TwentyStarAmericanText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    backFlagTracker = forwardFlagTracker - 1;
                    forwardFlagTracker++;
                }
                
                else if (forwardFlagTracker == 5)
                {
                    mf.bottomPanel.HideCoverLbl("Present Day Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.PresentDayFlagText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    nextBtn.setEnabled(false);
                    backFlagTracker = forwardFlagTracker - 1;
                }
            }
        });
        
        previousBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                mf.setResizable(true); 
                mf.DRAWFLAG = true;
                
                if (backFlagTracker == 5)
                {
                    mf.bottomPanel.HideCoverLbl("Present Day Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.PresentDayFlagText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    backFlagTracker--;
                //    forwardFlagTracker = backFlagTracker + 1;
                }
                if (backFlagTracker == 4)
                {
                    mf.bottomPanel.HideCoverLbl("20 Star American Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.TwentyStarAmericanText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    nextBtn.setEnabled(true);
                    forwardFlagTracker = backFlagTracker + 1;
                    backFlagTracker--;
                }
                else if (backFlagTracker == 3)
                {
                    mf.bottomPanel.HideCoverLbl("Lewis & Clark Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.LewisAndClarkText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true);
                    forwardFlagTracker = backFlagTracker + 1;
                    backFlagTracker--;
                }
                else if (backFlagTracker == 2)
                {
                    mf.bottomPanel.HideCoverLbl("Original 13 Star Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.Original13StarText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true);
                    forwardFlagTracker = backFlagTracker + 1;
                    backFlagTracker--;
                }
                else if (backFlagTracker == 1)
                {
                    mf.bottomPanel.HideCoverLbl("Betsy Ross Flag");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.BetsyRossText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    nextBtn.setEnabled(true);
                    forwardFlagTracker = backFlagTracker + 1;
                    backFlagTracker--;
                }
                else if (backFlagTracker == 0)
                {   
                    mf.bottomPanel.HideCoverLbl("Cover");
                    mf.topPanel.scrollPane.setVisible(true);
                    mf.topPanel.textArea.setText(mf.topPanel.IntroText);
                    mf.topPanel.textArea.setCaretPosition(0);
                    mf.topPanel.textArea.setVisible(true); 
                    previousBtn.setEnabled(false);
                    mf.bottomPanel.ShowCoverLbl( );
                    forwardFlagTracker = backFlagTracker + 1;
                }
            }
         });
    }         
}
