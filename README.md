# NewFlagHistories
This program lets the user step through the history of five American flags from Betsy Ross to our current day American flag. It uses an upper JPanel to display the history of each flag and a lower panel JPanel to display the flag.
I have written a separate class for each flag (Betsy Ross, Francis Hopkinson, Lewis & Clark, etc.) and each extends a Flag base class. The base class sets width, height, colors, dimensions of stripes and cantons, and has methods for drawing both the stripes and cantons with stars. Only white stripes are drawn as the red background provides for the red stripes. The Lewis & Clark flag has its own method for drawing stripes since it is the only flag to have had more than thirteen stripes. Each flag has its own method for drawing stars as the star pattern differs for each flag. The Hopkinson flag uses a six-point star for its image icon; all others use the five-point star as Betsy Ross had suggested. In addition, for the Betsy Ross flag (the only circle pattern), I used Math.Pi, Math.Sin, and Math.Cos functions to draw the stars in a circle.
The main lesson learned here was working with 
