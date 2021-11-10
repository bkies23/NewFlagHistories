
package org.files;

import java.awt.Graphics;
 
public class OriginalThirteenStarFlag extends Flag
{

    public OriginalThirteenStarFlag(int width, int height, Graphics g, int totalStripes, int stripesAdjacentCanton, int numOfStars) 
    {
        super(width, height, g, totalStripes, stripesAdjacentCanton, numOfStars);
    }
    
    public void DrawStars ()
    {
    //    Image image;
    //    String imagePath = "C:\\Users\\Brian Kies\\NetBeansProjects\\NewFlagHistories\\src\\org\\resources\\StarImage.png";
    //    image = Toolkit.getDefaultToolkit().getImage(imagePath);
        graphics.setColor(oldGloryBlue);
        int rowCount = 1;
        int spaceBetweenRowsDivisor = 5;
        int topMargin = 20;
        
  
        
        int spaceBetweenCols = cantonDims.width / 3; // blueBoxWidthDivisor;
        int spaceBetweenRows = cantonDims.height / 5; //blueBoxHeightDivisor;
        
        int leftMargin = 55;
        
        for (int j = topMargin; j < spaceBetweenRows * spaceBetweenRowsDivisor ; j += spaceBetweenRows)
        {
                // offset every other row
                if ( rowCount % 2 == 0)
                {
                    // offset margin by half of space between stars
                    leftMargin += spaceBetweenCols / 2;
                    for ( int i = leftMargin; i < spaceBetweenCols * 2; i += spaceBetweenCols)
                      //  graphics.drawImage(image, i, j, this);
                        starImage.paintIcon(this, graphics, i, j);
                    leftMargin = 55;
                }
                else 
                    for ( int i = leftMargin; i < spaceBetweenCols * 3; i += spaceBetweenCols)
                    //    graphics.drawImage(image, i, j, this);
                        starImage.paintIcon(this, graphics, i, j);
                rowCount++;  
        }
    }
    
}
