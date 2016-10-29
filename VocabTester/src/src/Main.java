package src;

import static java.lang.System.out;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	private final static int SCHEIGHT = 768, SCWIDTH = 1024;

	public static void main(String args[]) throws IOException {

		welcomePage.main(null);
		new Windows(); // Make a window
	}

}

class Windows extends JFrame implements KeyListener {

	private final static int SCHEIGHT = 675, SCWIDTH = 1024;
	final boolean[] key = new boolean[100];
	int delay = 350;
	boolean gameNotOver = true;
	private Image myScreen;
	
	
	private Image Floor = ((ImageIcon) new ImageIcon(getClass().getResource("/HotelFloor.png"))).getImage();
	private Image SingleDoor =((ImageIcon) new ImageIcon(getClass().getResource("/1Door.png"))).getImage();
	private Image ClosedDoor =((ImageIcon) new ImageIcon(getClass().getResource("/ClosedDoor.png"))).getImage();
	private Image IncorrectDoor = ((ImageIcon) new ImageIcon(getClass().getResource("/IncorrectDoor.png"))).getImage();
	
	
	private ArrayList<String> Terms = new ArrayList<String>();
	private ArrayList<String> Definitions = new ArrayList<String>();
	private ArrayList<String> UntestedArr = new ArrayList<String>();
	private ArrayList<String> correctAns = new ArrayList<String>();
	private int untestedNum;
	boolean StillOnSameQuestion;
	public int doorAns;
	public int door1;
	public int door2;
	public int door3;
	public int outof3;
	private InputStream in;
	BufferedReader reader;
	
	private ArrayList<Integer> MultipleKeys = new ArrayList<Integer>();
	
	private int HighScore = 0;
	private int oneUseInt = 0;
	
	public Windows() throws IOException 
	{	
		
		//Scans Term and Definitions
		in = getClass().getResourceAsStream("/Terms.CHEM");
		reader = new BufferedReader(new InputStreamReader(in));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String temp = "";
		StillOnSameQuestion = false;
		
		
		while((temp = reader.readLine()) != null)
		{
				Terms.add(temp);
		}
		reader.close();
		in = getClass().getResourceAsStream("/Definitions.CHEM");
		reader = new BufferedReader(new InputStreamReader(in));
		while((temp = reader.readLine()) != null)
		{
				reader.readLine();
				Definitions.add(temp);
		}
		untestedNum = Terms.size();
		UntestedArr = Terms;
		
		//Game Workings
		gameNotOver = true;
		setSize(SCWIDTH, SCHEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.addKeyListener(this);
		do {

				if (welcomePage.runmp4) {
					this.setVisible(true);
				}
	
				else {
					this.setVisible(false);
				}
			
			
			this.repaint();
			pause(delay);

		} 
		while (gameNotOver);
	}

	public void paint(Graphics pen) // Draws the window
	{
		myScreen = createImage(getSize().width, getSize().height);
		Graphics o = myScreen.getGraphics();
		doubleBuffer(o);
		pen.drawImage(myScreen, 0, 0, null);
	}

	/*  
	    
	*/
	public void doubleBuffer(Graphics g) // Draws the window
	{
		g.setColor(SystemColor.activeCaption);
		g.fillRect(0,0,SCWIDTH, SCHEIGHT);
		g.setColor(Color.BLACK);
		g.drawImage(Floor, 0, SCHEIGHT/2+50, SCWIDTH, SCHEIGHT/2+50, null);
		drawDoors(g);
		Calcs(g);
		
	}
	public void Calcs(Graphics g)
	{
		controlKeyInput(outof3,g);
	
		if(StillOnSameQuestion)
		{
			DisplayText(g);
		}
		else if(StillOnSameQuestion == false)
		{	
			
	
		door1 = (int)(Math.random()*UntestedArr.size());
		door2 = (int)(Math.random()*UntestedArr.size());
		door3 = (int)(Math.random()*UntestedArr.size());
		
		outof3 = (int)(Math.random()*3);
		
		while(door2 == door1)
		{
			 door2 = (int)(Math.random()*UntestedArr.size());
		}
		while(door3 == door1 || door3 == door2)
		{
			 door3 = (int)(Math.random()*UntestedArr.size());
		}
	
		doorAns = 0;
		if(outof3 == 0)
		{
			doorAns = door1;
		}
		else
			if(outof3 == 1)
			{
				doorAns = door2;
			}
			else
				if(outof3 == 2)
				{
					doorAns = door3;
				}
				
		
		
			DisplayText(g);
			StillOnSameQuestion = true;
		}
	}
	public void DisplayText(Graphics g)
	{
		
		g.setColor(Color.BLACK);
		Font myFont = new Font("Serif", Font.BOLD, 20);
		g.setFont(myFont);
		
			g.drawString(UntestedArr.get(door1), 100, 125);
			g.drawString(UntestedArr.get(door2), 440, 125);
			g.drawString(UntestedArr.get(door3), 760, 125);
		
			String s = Definitions.get(doorAns);
			drawStringMultiLine(g, s, 775, SCWIDTH/2-SCWIDTH/2/2-135, SCHEIGHT/2+SCHEIGHT/2/2);
			g.drawString("High Score: " + HighScore, SCWIDTH-300, SCHEIGHT-20);
			
	}
	public void controlKeyInput(int CorrectDoorNum,Graphics g)
	{
		
		if(key[KeyEvent.VK_1])
		{
			
			g.drawImage(IncorrectDoor, 20, 40, 300,SCHEIGHT/2+10, null);
			if(CorrectDoorNum+1 == 1)
			{
				HighScore++;
				g.drawImage(ClosedDoor, 20, 40, 300,SCHEIGHT/2+10, null);
				StillOnSameQuestion =false;
			}
		}
		else
		if(key[KeyEvent.VK_2])
		{
			g.drawImage(IncorrectDoor, 360, 40, 300,SCHEIGHT/2+10, null);
			if(CorrectDoorNum+1 == 2)
			{
				HighScore++;
				g.drawImage(ClosedDoor, 360, 40, 300,SCHEIGHT/2+10, null);
				StillOnSameQuestion =false;
			}
		}
		else
		if(key[KeyEvent.VK_3])
		{
			g.drawImage(IncorrectDoor, 680, 40, 300,SCHEIGHT/2+10, null);
			if(CorrectDoorNum+1 == 3)
			{
				HighScore++;
				g.drawImage(ClosedDoor, 680, 40, 300,SCHEIGHT/2+10, null);
				StillOnSameQuestion =false;
			}
		}
		else
		if(MultipleKeys.size()!=1)
		{
			boolean test = false;
			for(int x = 0; x<MultipleKeys.size();x++)
			{
				
				try{
					if(MultipleKeys.get(x) == KeyEvent.VK_B)
					{
					
						HighScore+=20;
					}
					else
					{
						HighScore+=0;
					}
					
				}catch(IndexOutOfBoundsException e)
				{
					break;
				}
			}
			MultipleKeys = new ArrayList<Integer>();
			
		}
	}
	
	public void drawString1(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
	public static void drawStringMultiLine(Graphics g, String text, int lineWidth, int x, int y) {
	    FontMetrics m = g.getFontMetrics();
	    if(m.stringWidth(text) < lineWidth) {
	        g.drawString(text, x, y);
	    } else {
	        String[] words = text.split(" ");
	        String currentLine = words[0];
	        for(int i = 1; i < words.length; i++) {
	            if(m.stringWidth(currentLine+words[i]) < lineWidth) {
	                currentLine += " "+words[i];
	            } else {
	                g.drawString(currentLine, x, y);
	                y += m.getHeight();
	                currentLine = words[i];
	            }
	        }
	        if(currentLine.trim().length() > 0) {
	            g.drawString(currentLine, x, y);
	        }
	    }
	}
	
	public void drawDoors(Graphics g)
	{
		g.drawImage(SingleDoor, 20, 40, 300,SCHEIGHT/2+10, null);
		g.drawImage(SingleDoor, 360, 40, 300,SCHEIGHT/2+10, null);
		g.drawImage(SingleDoor, 680, 40, 300,SCHEIGHT/2+10, null);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(SCWIDTH/2-SCWIDTH/2/2-150, SCHEIGHT/2+SCHEIGHT/2/2-50, 800, 400);
		g.setColor(Color.BLACK);
		g.fillRect(0,SCHEIGHT/2+40,SCWIDTH, 15);
	}
	public void keyPressed(KeyEvent e) {
		
		key[e.getKeyCode()] = true;
		MultipleKeys.add(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		
		key[e.getKeyCode()] = false;
		for(int x =0; x<MultipleKeys.size(); x++)
		{
			if(MultipleKeys.get(x) == e.getKeyCode())
			{
				MultipleKeys.remove(x);
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void update(Graphics G) {
		paint(G);
	}

	public static void pause(long r) {
		try {
			Thread.sleep(r);
		} catch (Exception e) {
			out.println(" sleep error " + e);
		}
	}

}
