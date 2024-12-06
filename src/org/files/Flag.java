
package org.files;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// base class for all flags
public class Flag extends JPanel
{
    int flagWidth;
    int flagHeight;
    Graphics graphics;
    Color oldGloryBlue = new Color (0, 35, 140);
    Dimension cantonDims;
    int totalNumOfStripes;
    int stripesAdjacentCanton;
    int numOfStars;
    final ImageIcon starImage, SixPointStar; 

    public Flag (int width, int height, Graphics g, int totalStripes, int stripesAdjacentCanton, int numOfStars)
    {
        setTotalNumOfStripes(totalStripes);
        setStripesAdjacentCanton(stripesAdjacentCanton);
        setNumOfStars(numOfStars);
        starImage = new ImageIcon(getClass().getResource("/org/resources/StarImage.png"));
        // Six point star is for Francis Hopkinson flag
        SixPointStar = new ImageIcon(getClass().getResource("/org/resources/SixPointStar.png"));
        setGraphics(g);
        flagWidth = width;
        flagHeight = height;
        setCantonDims(cantonDims);
    }
    
    public void setCantonDims(Dimension cantonDims) 
    {
        this.cantonDims = this.DrawCanton(graphics);
    }
    
    public Dimension getCantonDims() 
    {
        return this.DrawCanton(graphics);
    }
    
    public int getNumOfStars() 
    {
        return numOfStars;
    }

    public void setNumOfStars(int numOfStars) 
    {
        this.numOfStars = numOfStars;
    }
    
    public int getTotalNumOfStripes() 
    {
        return totalNumOfStripes;
    }

    public void setTotalNumOfStripes(int totalNumOfStripes) 
    {
        this.totalNumOfStripes = totalNumOfStripes;
    }

    public int getStripesAdjacentCanton() 
    {
        return stripesAdjacentCanton;
    }

    public void setStripesAdjacentCanton(int stripesAdjacentCanton) 
    {
        this.stripesAdjacentCanton = stripesAdjacentCanton;
    }
    
    public int getFlagWidth() 
    {
        return flagWidth;
    }

    public void setFlagWidth(int aFlagWidth) 
    {
        flagWidth = aFlagWidth;
    }

    public int getFlagHeight() 
    {
        return flagHeight;
    }

    public void setFlagHeight(int aFlagHeight) 
    {
        flagHeight = aFlagHeight;
    }
    
    public void setGraphics(Graphics aGraphics) 
    {
        graphics = aGraphics;
    }
    
    public Dimension DrawCanton (Graphics g)
    {
        int cantonWidth = flagWidth / 3 + ((flagWidth / 3) / 3);
        int cantonHeight = flagHeight / totalNumOfStripes * stripesAdjacentCanton;  
        g.setColor(oldGloryBlue);
        g.fillRect(0, 0, cantonWidth, cantonHeight);
       
        return new Dimension(cantonWidth, cantonHeight);   
    }
   
    public void DrawOldGloryStripes ()
    {
        // by drawing a white stripe every other stripe width, the red background takes care of the red stripes
        int whiteStripeWidth = cantonDims.height / stripesAdjacentCanton; 
        
        graphics.setColor(Color.white);
        int offset = 0;
        
        // draw first three white stripes adjacent canton 
        for ( int i = 2; i < stripesAdjacentCanton + 2; i++)  
        {
            if ( i % 2  != 0)
            {
               graphics.fillRect(cantonDims.width, offset, flagWidth - cantonDims.width, whiteStripeWidth); 
               offset += whiteStripeWidth;
            }
            else
                offset += whiteStripeWidth;
        }   
        // draw remaining three white stripes the width of flag
        for ( int i = 2; i < stripesAdjacentCanton; i++)
        {
            {
                if ( i % 2  == 0) 
                {
                    graphics.fillRect(0, offset, flagWidth, whiteStripeWidth);
                    offset += whiteStripeWidth;
                }
                else
                    offset += whiteStripeWidth;   
            }
        }       
    } 
}

