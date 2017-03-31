package jh3_jdpollac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;

class GBar
{
    String text;
    int value;
    GBar(String t, int v)
    {
        text=t;
        value =v;
    }
}

public class GraphAssign extends JFrame{
	
	StringTokenizer parseCommand = null;
	
    ArrayList<GBar> gbarArr = new ArrayList<GBar>();
    

    GraphAssign(ArrayList<GBar> garr, String title)
    {
    	
        super();
        setTitle(title);
        gbarArr = garr;
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Find the maximum width of the strings in pixels
    int getMaxTextWidth(ArrayList<GBar> garr, FontMetrics fm)
    {
        int maxValue=0;
        for (int i=0; i < garr.size(); i++)
        {
            int width = fm.stringWidth(garr.get(i).text);
            if (width > maxValue)
                maxValue = width;
        }
        return maxValue;            
    }

    // Find the maximum value in the ArrayList
    int getMaxBarWidth(ArrayList<GBar> garr)
    {
        int maxValue=0;
        for (int i=0; i < garr.size(); i++)
        {
            int value = garr.get(i).value;
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;            
    }
    
   
    public void processFile()
    {
    	
    }
    
    

    public void paint(Graphics g)
    {
        super.paint(g);
        Dimension dimen = getSize();
        Insets insets = getInsets();
        int top = insets.top;
        int left = insets.left;
        int right = insets.right;
        int bottom = insets.bottom;
        int myBorder = 10;
        Dimension d = getSize();
        
        g.setColor(Color.red); 
        g.fillRect(dimen.width - right - myBorder, top, 10, dimen.height);
        g.fillRect(left, top, d.width-left -right , 10);
        g.fillRect(left, dimen.width-right-myBorder, d.width-left -right, 10);
        g.fillRect(8, 10, 10, d.width - right - myBorder);
        
        Font font = g.getFont();
        FontMetrics fm = getFontMetrics(font);
        int fontHeight = fm.getHeight();
        int maxAscent = fm.getMaxAscent();
        int strMaxWidth = left + getMaxTextWidth( gbarArr, fm);
        int x_bar_start =  strMaxWidth +1/* a little white space pad*/; 
        int barMaxValue = getMaxBarWidth(gbarArr);
        double scale = (dimen.width -x_bar_start - right) / (double) barMaxValue;
        int y_start = top+10;
        int bar_height = fontHeight;

        for (int i=0; i < gbarArr.size(); i++)
        {
        	String text = gbarArr.get(i).text;
            int strWidth = fm.stringWidth(text);
            int value =gbarArr.get(i).value;
            int scaledValue = (int)(value * scale); 
            g.setColor(Color.black);
            g.drawString(text, strMaxWidth - strWidth+10, y_start + maxAscent);
            g.setColor(Color.green);
            g.fillRect(x_bar_start+10, y_start, scaledValue-30, bar_height);
            
            y_start += fontHeight + 10/*  a little space between rows */;
        }
        g.drawLine(strMaxWidth+10, top+10, strMaxWidth+10, dimen.height-20);

    }

    public static void main(String[] args) {
        
    	ArrayList<GBar> garr = new ArrayList<GBar>();

    	Scanner scanner = null;
    	String title= null;
    	try
		{
			FileInputStream fi = new FileInputStream("graphing.txt");
			scanner = new Scanner(fi);
			title = (scanner.nextLine());
		}
		catch (FileNotFoundException e)
		{
			System.out.println("error: "+e);
		}
		while (scanner.hasNext())
		{
			String s = scanner.useDelimiter(";").next();
			scanner.reset();
			scanner.next();
			int num = scanner.nextInt();
			GBar g = new GBar(s, num);
			garr.add(g);
	        //System.out.printf(s + "%n" + num);  //testing the file read
		}
		if (scanner != null)
			scanner.close();

        
        GraphAssign gb= new GraphAssign(garr, title);
        

        
    }

}