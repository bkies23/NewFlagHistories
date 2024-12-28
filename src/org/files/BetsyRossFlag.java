
package org.files;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class BetsyRossFlag extends Flag
{
    public BetsyRossFlag (int width, int height, Graphics g, int totalStripes, int stripesAdjacentCanton, int numOfStars)
    {
        super (width, height, g, totalStripes, stripesAdjacentCanton, numOfStars);
    }
    
    public void DrawStars ( )
    {
        Point [] points = new Point [numOfStars];
        double radius;
  
        Graphics2D g2 = (Graphics2D) graphics;
        double leftX = 0;
        double topY = 0;
        
        radius = (cantonDims.width / 2) - (cantonDims.width / 3);
        
        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, cantonDims.width, cantonDims.height);
       
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        
    //    int angle = -28;
        int angle = -360 / numOfStars;
        for (int i = 0; i < numOfStars; i++)
        {
           angle += 28;
           // convert degrees to radians
           double angleInRadians = (angle * Math.PI) / 180;
           // store the 13 points in points array
           points [i] = new Point ((int) (centerX - (starImage.getIconWidth()/2) + radius * Math.cos(angleInRadians)), 
                                   (int) (centerY - (starImage.getIconHeight()/2) +  radius * Math.sin(angleInRadians)));
        }
        
        // draw 13 stars in circle 
        for (int i = 0; i < 13; i ++)
       {
            starImage.paintIcon(this, g2, points[i].x, points[i].y);
       }  
    }
    
}
