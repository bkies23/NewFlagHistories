
package org.files;

import java.awt.Color;
import java.awt.Graphics;

public class LewisAndClarkFlag extends Flag
{
    public LewisAndClarkFlag(int width, int height, Graphics g, int totalStripes, int stripesAdjacentCanton, int numOfStars) 
    {
        super(width, height, g, totalStripes, stripesAdjacentCanton, numOfStars);
    }
    
    public void DrawStars ()
    {
        int spaceBetweenCols = cantonDims.width / 3; // blueBoxWidthDivisor;
        int spaceBetweenRows = cantonDims.height / 5; //blueBoxHeightDivisor;
        int leftMargin = 15;
        int topMargin = 12;
        int spaceBetweenRowsDivisor = 5;
        int rowCount = 1;
       
        for (int j = topMargin; j < spaceBetweenRows * spaceBetweenRowsDivisor ; j += spaceBetweenRows)
        {
            // offset every other row
            if ( rowCount % 2 == 0)
            {
                // offset margin by half of space between stars
                leftMargin += spaceBetweenCols / 2;
                    
                for ( int i = leftMargin; i < spaceBetweenCols * 3; i += spaceBetweenCols)
                   //   graphics.drawImage(image, i, j, this);   
                    starImage.paintIcon(this, graphics, i, j);
            }  
            else
                for ( int i = leftMargin; i < spaceBetweenCols * 3; i += spaceBetweenCols)
                  //    graphics.drawImage(image, i, j, this);
                    starImage.paintIcon(this, graphics, i, j);
            leftMargin = 15;
            rowCount++;
        }          
    }
    
    public void DrawStripes (int stripeCount)
    {
        int whiteStripeWidth = cantonDims.height / stripeCount; 
       
        graphics.setColor(Color.white);
        int offset = 0;
        
          // draw first four white stripes adjacent to Canton 
        for ( int i = 2; i < stripeCount + 2; i++)   // i < 10 for L&C Flag
        {
            if ( i % 2  != 0)
            {
               graphics.fillRect(cantonDims.width, offset, flagWidth - cantonDims.width, whiteStripeWidth );
               offset += whiteStripeWidth;
            }
            else
                offset += whiteStripeWidth;
        }
        
        // draw remaining three white stripes entire width of flag
        for ( int i = 2; i < stripeCount; i++)
        {
            if (stripeCount == 8)
            {
                if ( i % 2  != 0) // != 0 for L&C Flag
                {
                    graphics.fillRect(0, offset, flagWidth, whiteStripeWidth );
                    offset += whiteStripeWidth;
                }
                else
                    offset += whiteStripeWidth;
            }
        }    
    }    
}
