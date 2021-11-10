
package org.files;

import java.awt.Color;
import java.awt.Graphics;

public class TwentyStarFlag extends Flag
{

    public TwentyStarFlag(int width, int height, Graphics g, int totalStripes, int stripesAdjacentCanton, int numOfStars) 
    {
        super(width, height, g, totalStripes, stripesAdjacentCanton, numOfStars);
    }
    
    public void DrawStars ()
    {
        int rowCount = 1;
        int leftMargin = 35;
        int topMargin = 47;
        int numOfRows = 4;
        int blueBoxWidthDivisor = 5;
        int blueBoxHeightDivisor = 5;
        
     //   Image image;
     //   String imagePath = "C:\\Users\\Brian Kies\\NetBeansProjects\\NewFlagHistories\\src\\org\\resources\\StarImage.png";
     //   image = Toolkit.getDefaultToolkit().getImage(imagePath);
        
        graphics.setColor(Color.white);
        // set size of stars
        int spaceBetweenCols = cantonDims.width / blueBoxWidthDivisor;
        int spaceBetweenRows = cantonDims.height / blueBoxHeightDivisor;
        
        for (int j = topMargin; j < spaceBetweenRows * numOfRows ; j += spaceBetweenRows)
        {
            for ( int i = leftMargin; i < spaceBetweenCols * 5; i += spaceBetweenCols)
                //  graphics.drawImage(image, i, j, this); 
                starImage.paintIcon(this, graphics, i, j);
            rowCount++;
        }
    }
    
}
