
package org.files;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BottomPanel extends JPanel
{
    int flagWidth, flagHeight;
    JLabel coverLbl;
    Dimension cantonDims;
    Color oldGloryBlue = new Color (0, 35, 140);
    MainFrame mainFrame;
    ImageIcon icon, scaledIcon;
    Image img, imgScale;
    BottomPanel bp;
    String WhichFlag; // will hold which flag to display
   
    public BottomPanel (int width, int height)
    {
        mainFrame = new MainFrame();
        flagWidth = width;
        flagHeight = height;
    
        setLayout (new BorderLayout());
        setBackground(Color.RED);
        setOpaque(true);
        coverLbl = new JLabel();
        // a picture of Betsy Ross and three other ladies working on flag provides the cover
        icon = new ImageIcon(getClass().getResource("/org/resources/BetsyRoss.png"));
        img = icon.getImage();
        imgScale = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        scaledIcon = new ImageIcon(imgScale);
        coverLbl.setIcon(scaledIcon);
        coverLbl.setVisible(true);
        add(coverLbl);  
      
        addComponentListener(new ComponentAdapter() 
        {
            public void componentResized(ComponentEvent e) 
            {
                imgScale = img.getScaledInstance(coverLbl.getWidth(), coverLbl.getHeight(), Image.SCALE_DEFAULT);
                scaledIcon = new ImageIcon(imgScale);
                coverLbl.setIcon(scaledIcon);
            }
        });
    }
    
    public BottomPanel (int width, int height, MainFrame mf)
    {
        flagWidth = width;
        flagHeight = height;
        mainFrame = mf;
       
        setLayout (new BorderLayout());
        setBackground(Color.RED);
        setOpaque(true);
        coverLbl = new JLabel();
        // a picture of Betsy Ross working on flag with three friends provides a cover
        icon = new ImageIcon(getClass().getResource("/org/resources/BetsyRoss.png"));
        img = icon.getImage();
        imgScale = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        scaledIcon = new ImageIcon(imgScale);
        coverLbl.setIcon(scaledIcon);
        coverLbl.setVisible(true);
        add(coverLbl);  
      
        addComponentListener(new ComponentAdapter() 
        {
            public void componentResized(ComponentEvent e) 
            {
                imgScale = img.getScaledInstance(coverLbl.getWidth(), coverLbl.getHeight(), Image.SCALE_DEFAULT);
                scaledIcon = new ImageIcon(imgScale);
                coverLbl.setIcon(scaledIcon);
            }
            
            @Override
            public void componentMoved(ComponentEvent e) 
            {
                System.out.println("Moved to " + e.getComponent().getLocation());
            }
        });
    }
    
    public void HideCoverLbl ()
    {
        coverLbl.setVisible(false);
    }
   
    public String HideCoverLbl (String whichFlag)
    {
        coverLbl.setVisible(false);
        WhichFlag = whichFlag;
        
        return WhichFlag;
   }
    
   public void ShowCoverLbl()
    {
        imgScale = img.getScaledInstance(flagWidth, flagHeight, Image.SCALE_DEFAULT);
        scaledIcon = new ImageIcon(imgScale);
        coverLbl.setIcon(scaledIcon);
        coverLbl.setVisible(true); 
   }
    
    public void DrawCoverLbl ( )
    {   
        imgScale = img.getScaledInstance(coverLbl.getWidth(), coverLbl.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        coverLbl.setIcon(scaledIcon);  
        coverLbl.setVisible(true);
    }             
    
    public void DrawBetsyRossFlag (int flagWidth, int flagHeight, Graphics g) throws IOException
    {
        int totalNumOfStripes = 13;
        int stripesAdjacentCanton = 7;
        int numOfStars = 13;
        
        BetsyRossFlag betsyRossFlag = new BetsyRossFlag(flagWidth, flagHeight, g, totalNumOfStripes, stripesAdjacentCanton, numOfStars);
        
        betsyRossFlag.DrawStars();
        betsyRossFlag.DrawOldGloryStripes();
    }
    
    public void DrawOriginalStarFlag (int flagWidth, int flagHeight, Graphics g)
    {
        int totalNumOfStripes = 13;
        int stripesAdjacentCanton = 7;
        int numOfStars = 13;
        
        OriginalThirteenStarFlag originalThirteenStarFlag = new OriginalThirteenStarFlag(flagWidth, flagHeight, g, totalNumOfStripes, stripesAdjacentCanton, numOfStars);
        
        originalThirteenStarFlag.DrawStars();
        originalThirteenStarFlag.DrawOldGloryStripes();
    }
    
    public void DrawLewisAndClarkFlag (int flagWidth, int flagHeight, Graphics g)
    {
        int totalNumOfStripes = 15;
        int stripesAdjacentCanton = 8;
        int numOfStars = 15;
        
        LewisAndClarkFlag lewisAndClarkFlag = new LewisAndClarkFlag(flagWidth, flagHeight, g, totalNumOfStripes, stripesAdjacentCanton, numOfStars);
        
        lewisAndClarkFlag.DrawStars();
        lewisAndClarkFlag.DrawStripes(stripesAdjacentCanton);   
    }
    
    public void DrawTwentyStarFlag (int flagWidth, int flagHeight, Graphics g)
    {
        int totalNumOfStripes = 13;
        int stripesAdjacentCanton = 7;
        int numOfStars = 20;
        
        TwentyStarFlag twentyStarFlag = new TwentyStarFlag(flagWidth, flagHeight, g, totalNumOfStripes, stripesAdjacentCanton, numOfStars);
        
        twentyStarFlag.DrawStars();
        twentyStarFlag.DrawOldGloryStripes( );
    }
    
    public void DrawPresentDayFlag(int flagWidth, int flagHeight, Graphics g)
    {
        int totalNumOfStripes = 13;
        int stripesAdjacentCanton = 7;
        int numOfStars = 50;
        
        PresentDayFlag presentDayFlag = new PresentDayFlag(flagWidth, flagHeight, g, totalNumOfStripes, stripesAdjacentCanton, numOfStars);
        
        presentDayFlag.DrawStars();
        presentDayFlag.DrawOldGloryStripes();  
    }
    
    protected void paintComponent (Graphics g)
    {
        super.paintComponent(g);
  
        flagWidth = getWidth();
        flagHeight = getHeight();
        coverLbl.setDoubleBuffered(true);
        
        try 
        {
            if (mainFrame.DRAWFLAG)
                
            switch (WhichFlag)
            {
                case "Cover":
                    mainFrame.controlPanel.previousBtn.setEnabled(false);
                    break;
                    
                case "Betsy Ross Flag":
                    DrawBetsyRossFlag(flagWidth, flagHeight, g);
                    mainFrame.controlPanel.previousBtn.setEnabled(true);
                    break;
                    
                case "Original 13 Star Flag":
                    DrawOriginalStarFlag(flagWidth, flagHeight, g);
                    break;
                    
                case "Lewis & Clark Flag":
                    DrawLewisAndClarkFlag(flagWidth, flagHeight, g);
                    break;
                    
                case "20 Star American Flag":
                    DrawTwentyStarFlag(flagWidth, flagHeight, g);
                    break;  
                    
                case "Present Day Flag":
                    DrawPresentDayFlag(flagWidth, flagHeight, g); 
                    mainFrame.controlPanel.nextBtn.setEnabled(false);
                    break;
            }      
        }                          
        catch (IOException ex) 
        {
           Logger.getLogger(BottomPanel.class.getName()).log(Level.SEVERE, null, ex);
        }                             
    }   
}
