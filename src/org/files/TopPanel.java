
package org.files;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopPanel extends JPanel
{
    JTextArea textArea = new JTextArea();
    Font myFont = new Font ("Times New Roman", Font.PLAIN, 22);
      
    JScrollPane scrollPane;
    
    public String IntroText =  "This program displays flags adopted by the U.S. government from 1777 through 1817 as well as our present-day flag."
            + " The top panel will contain a brief history of each flag and the lower panel will display it.\n\n"
            + "Prior to 1817, a stripe was added for each new state that entered the Union. By that year and with a total of twenty states,"
            + " the government realized it was no longer feasible to add a stripe for each new state. Thus with the 1817 flag, they adopted a proclamation"
            + " in which there would be thirteen red and white stripes representing the original colonies and a star to represent each state. Moving forward,"
            + " only stars were added as new states entered the Union. \n\n"
            + "Of these five flags, four have seven stripes alongside the blue canton. Only the Lewis and Clark flag differs with eight stripes. This design came about"
            + " as it is the only flag to have had more than thirteen stripes.";
    
    public String BetsyRossText = "Distinguished by its alternating red-and-white stripes and circular white stars on a blue canton, it"
            + " is one of the earliest recognized designs of the American flag. In use since 1777, the flag is named for Philadelphia upholsterer and flag maker"
            + " Elizabeth “Betsy” Ross, but its true origins remain up for debate. \n\n"
            + "According to Betsy’s grandson, William Canby, who first relayed the story to the Historical Society of Pennsylvania in 1870, she made the first American flag"
            + " in the spring of 1776 following a visit from General George Washington, Robert Morris, and her husband’s uncle, Colonel George Ross. During the visit,"
            + " the men allegedly showed Betsy a sketch of a flag containing thirteen red-and-white stripes and 6-pointed white stars, and asked if she could make it."
            + " Betsy accepted the offer, but suggested changing the 6-pointed star to the easier 5-pointed star and arranging them in a circle – the very same design that was"
            + " officially adopted by Congress as the national flag one year later on June 14, 1777.";
    
    String Original13StarText = "Like many of the Founding Fathers, Francis Hopkinson was a man of many talents. An artist, musician, poet, lawyer, businessman,"
            + " and politician, he seemed to do just about everything. Included in his skillset was a knack for artistic design. This led to his involvement in"
            + " a number of design projects for the United States.\n\n" 
            + "Hopkinson developed many seals and symbols during the US’s infancy, including the Grand Seal of the United States. However, there’s no doubt"
            + " that his most important project was the national flag. He designed it while serving on the Continental Marine Committee, in a position known today"
            + " as the Secretary of the Navy. As a part of his design he went with the more difficult six-pointed star. In 1777, the flag was adopted as the US’s official national flag,"
            + " and Hopkinson became creator of the Stars and Stripes.";

    String LewisAndClarkText = "On January 18, 1803, Thomas Jefferson sent a secret message to Congress asking for $2,500 to send an officer and"
            + " a dozen soldiers to explore the Missouri River, make diplomatic contact with Indians, expand the American fur trade, and locate"
            + " the Northwest Passage (the much-sought-after hypothetical northwestern water route to the Pacific Ocean). Jefferson asked his personal secretary,"
            + " Meriwether Lewis, to lead the expedition. As his co-commander Lewis selected William Clark, who had been his military superior during the government’s"
            + " battles with the Northwest Indian Federation in the early 1790s. \n\n"
            + "Seventeen states made up the Union at the time. Tennessee had been admitted in 1796 and Ohio in March of 1803 but no provisions had been made on how to change"
            + " the flag. So even though the country had seventeen states, Lewis & Clark carried a flag with fifteen stripes and fifteen stars. Because of this some still refer"
            + " to it as the Lewis & Clark flag. It is the only flag to have had more than 13 stripes (15) with eight of them alongside the blue canton. \n\n"
            + "This is also the flag immortalized by Francis Scott Key during the bombardment of Fort McHenry, Sept 13, 1814.";
         
    
    String TwentyStarAmericanText = "Five states were admitted to the Union between 1796 and 1817. By this time the government realized it could not continue to add a stripe"
            + " for each new state. So the Act of April 4th, 1818 set a new policy that provided for a constant on all American Flags of 13 stripes for the original colonies"
            + " and one star for each state. The act stated that the flag would be officially modified on the 4th of July following the admission of each new state. \n\n" 
            + "This edition of the flag added five new stars for the admission of the new states including: Tennessee (1796), Ohio (1803), Louisiana (1812), Indiana (1816),"
            + " and Mississippi (1817).";
    
    String PresentDayFlagText = "The last two states added to our Union occurred in 1959. On January 3rd of that year, President Eisenhower issued an Executive Order establishing"
            + " the design of the 49-star flag for the statehood of Alaska. On July 4, 1959, this flag was officially raised over Fort McHenry National Historic Site."
            + " The Committee formally submitted their designs for the 50-star flag on August 17, 1959. On August 21, 1959, President Eisenhower issued another Executive Order"
            + " establishing the design of the 50-star flag. This flag was first officially raised over Fort McHenry National Historic Site on July 4, 1960. So the 49-star flag"
            + " only lasted one year from July 4th, 1959 until July 4th, 1960.\n\n"
            + "The current span of 61 years (1960 - 2021) is the longest gap ever for our flag not to change. Prior to that the longest gap had been 47 years from 1912"
            + " (Arizona and New Mexico) until 1959 (Alaska). There has been talk of Washington DC or a U.S. territory being admitted as a state. This could result in a set"
            + " of three 9 - 8 staggered rows or possibly five rows of ten with a star set away to represent Washington DC.";
   
    public TopPanel (int width, int height) 
    {
        setLayout (new BorderLayout());
        setBackground(new Color(255, 255, 235));
        setOpaque(true);
        setPreferredSize(new Dimension(width, height));
        // inset TextArea by 15 pixels on each side
        setBorder(new EmptyBorder (15, 15, 15, 15));
        
        textArea = new JTextArea();
        // set text color to teal
        textArea.setForeground(new Color(0, 128 ,128));
        textArea.setFont(myFont);
        // TextArea will not be edited
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        Border insideBorder = BorderFactory.createLineBorder(Color.blue, 1, false);
        textArea.setBorder(BorderFactory.createCompoundBorder(insideBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        textArea.setText(IntroText);
        textArea.setCaretPosition(0);
        textArea.setVisible(true);
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(textArea);
        scrollPane.setVisible(true);
        add(scrollPane);
        
        setVisible(true);
    }
}
