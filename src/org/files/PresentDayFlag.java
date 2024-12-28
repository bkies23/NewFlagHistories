
package org.files;

import java.awt.Graphics;

public class PresentDayFlag extends Flag
{
    public PresentDayFlag(int width, int height, Graphics g, int totalStripes, int stripesAdjacentCanton, int numOfStars) 
    {
        super(width, height, g, totalStripes, stripesAdjacentCanton, numOfStars);
    }
    
    public void DrawStars ()
    {
      
        int leftMargin = 30;
        int topMargin = 12;
        int spaceBetweenRowsDivisor = 5;
        int rowCount = 1;
    
        int spaceBetweenCols = cantonDims.width / 7 + (cantonDims.width / 50); // blueBoxWidthDivisor;
        int spaceBetweenRows = cantonDims.height / 10; //blueBoxHeightDivisor;
        
        for (int j = topMargin; j < spaceBetweenRows * 9; j += spaceBetweenRows)
        {
            // offset every other row
            if ( rowCount % 2 == 0)
            {
                // offset margin by half of space between stars
                leftMargin += spaceBetweenCols / 2;
                    
                for ( int i = leftMargin; i < spaceBetweenCols * 5; i += spaceBetweenCols)
                    //  graphics.drawImage(image, i, j, this);  
                    starImage.paintIcon(this, graphics, i, j);
            }  
            else
                for ( int i = leftMargin; i < spaceBetweenCols * 6; i += spaceBetweenCols)
                   //   graphics.drawImage(image, i, j, this);
                    starImage.paintIcon(this, graphics, i, j);
            leftMargin = 28;
            rowCount++;
        }              
    }   
}
