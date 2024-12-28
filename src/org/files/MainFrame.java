
package org.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* Designer and Programmer Brian Kies */

public class MainFrame extends JFrame 
{
    // initial width and height of JFrame
    private int width = 1000;
    private int height = 825;
    private String whichFlag = " "; // whichFlag will hold current flag for Switch Case statement
    boolean DRAWFLAG = false;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem cover, flag1, flag2, flag3, flag4, flag5, exit;
    
    // Program is divided into three sections: TopPanel, BottomPanel, and ControlPanel
    
    // TopPanel dispays text of flag history
    TopPanel topPanel;
    
    // BottomPanel displays flag
    BottomPanel bottomPanel;
    
    // ControlPanel allows User to move forward or backward through flags
    ControlPanel controlPanel;
    
    // This contructor has to be called by Control Panel so it can have access to Mainframe
    public MainFrame ( )
    {  
    }
    
    public MainFrame (String title)
    {
        setTitle(title); 
    }
    
    public void CreateMainFrame ()
    {
        setPreferredSize(new Dimension(width, height));
        topPanel = new TopPanel(width, height / 3); 
        bottomPanel = new BottomPanel (width, height - (height / 3) - height / 25, this);
        controlPanel = new ControlPanel (width, height / 25, this);
        
        // User will have option to navigate by menu
        CreateMenu(150, 50);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 235));
        pack();    
        //center main screen
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        // add the three panels
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH); 
    }
 
    public void CreateMenu (int width, int height)
    {
        menuBar = new JMenuBar();
        menu = new JMenu("Flags");
        cover = new JMenuItem ("Cover");
        flag1 = new JMenuItem ("Betsy Ross Flag");
        flag2 = new JMenuItem ("Original 13 Star Flag");
        flag3 = new JMenuItem ("Lewis & Clark Flag");
        flag4 = new JMenuItem ("20 Star American Flag");
        flag5 = new JMenuItem ("Present Day Flag");
        exit = new JMenuItem ("Exit");
        
        // Cover has picture of Betsy Ross with friends working on flag
        cover.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {  
                DRAWFLAG = true;
                whichFlag = "Cover";
                topPanel.scrollPane.setVisible(true);
                topPanel.textArea.setText(topPanel.IntroText);
                topPanel.textArea.setVisible(true); 
                topPanel.textArea.setCaretPosition(0);
                bottomPanel.DrawCoverLbl();
                controlPanel.previousBtn.setEnabled(false);
                controlPanel.nextBtn.setEnabled(true);
                controlPanel.forwardFlagTracker = 1;
                controlPanel.backFlagTracker = 0;
                setResizable(true);
            }
        });
        
        flag1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {   
                DRAWFLAG = true;
                whichFlag = "Betsy Ross Flag";
                topPanel.scrollPane.setVisible(true);
                topPanel.textArea.setText(topPanel.BetsyRossText);
                topPanel.textArea.setVisible(true);
                topPanel.textArea.setCaretPosition(0);
                bottomPanel.HideCoverLbl(whichFlag);
                controlPanel.previousBtn.setEnabled(true);
                controlPanel.forwardFlagTracker = 2;
                controlPanel.backFlagTracker = 0;
                setResizable(true);
            }
        });
        
        flag2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {   
                DRAWFLAG = true;
                whichFlag = "Original 13 Star Flag";
                topPanel.scrollPane.setVisible(true);
                topPanel.textArea.setText(topPanel.Original13StarText);
                topPanel.textArea.setVisible(true);
                topPanel.textArea.setCaretPosition(0);
                bottomPanel.HideCoverLbl(whichFlag);
                controlPanel.previousBtn.setEnabled(true);
                controlPanel.forwardFlagTracker = 3;
                controlPanel.backFlagTracker = 1;
                setResizable(true);
            }
        });
        
        flag3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {   
                DRAWFLAG = true;
                whichFlag = "Lewis & Clark Flag";
                topPanel.scrollPane.setVisible(true);
                topPanel.textArea.setText(topPanel.LewisAndClarkText);
                topPanel.textArea.setVisible(true); 
                topPanel.textArea.setCaretPosition(0);
                bottomPanel.HideCoverLbl(whichFlag);
                controlPanel.previousBtn.setEnabled(true);
                controlPanel.forwardFlagTracker = 4;
                controlPanel.backFlagTracker = 2;
                setResizable(true);
            }
        });
        
        flag4.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {   
                DRAWFLAG = true;
                whichFlag = "20 Star American Flag";
                topPanel.scrollPane.setVisible(true);
                topPanel.textArea.setText(topPanel.TwentyStarAmericanText);
                topPanel.textArea.setVisible(true);
                topPanel.textArea.setCaretPosition(0);
                bottomPanel.HideCoverLbl(whichFlag);
                controlPanel.previousBtn.setEnabled(true);
                controlPanel.nextBtn.setEnabled(true);
                controlPanel.forwardFlagTracker = 5;
                controlPanel.backFlagTracker = 3;
                setResizable(true);
            }
        });
        
        flag5.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {   
                DRAWFLAG = true;
                whichFlag = "Present Day Flag";
                topPanel.scrollPane.setVisible(true);
                topPanel.textArea.setText(topPanel.PresentDayFlagText);
                topPanel.textArea.setVisible(true);
                topPanel.textArea.setCaretPosition(0);
                bottomPanel.HideCoverLbl(whichFlag);
                controlPanel.previousBtn.setEnabled(true);
                controlPanel.nextBtn.setEnabled(false);
                controlPanel.forwardFlagTracker = 0;
                controlPanel.backFlagTracker = 4;
                setResizable(true);
            }
        });
        
        exit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {   
                System.exit(0);
            }
        });
        
        menuBar.setOpaque(true);
        menuBar.setBackground(new Color(255, 255, 235));
        menuBar.setPreferredSize(new Dimension(width, 20));
        menu.add(cover);
        menu.addSeparator();
        menu.add(flag1);
        menu.addSeparator();
        menu.add(flag2);
        menu.addSeparator();
        menu.add(flag3);
        menu.addSeparator(); 
        menu.add(flag4);
        menu.addSeparator(); 
        menu.add(flag5);
        menu.addSeparator();
        menu.add(exit);
        menu.setVisible(true);
        menuBar.add(menu);
        menuBar.setVisible(true);
        setJMenuBar(menuBar);  
    }
    
    public static void main(String[] args) 
    {
        MainFrame mainFrame = new MainFrame("History Of U.S. Flags");
      
        mainFrame.CreateMainFrame();
    }   
}
