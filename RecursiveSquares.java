/*
 * Program: RecursiveSquares
 * 
 * Description: Describe what your program does. 
 *
 * @author Temesgen
 *
 ***********************************************************
 * Adapted from: https://willrosenbaum.com/teaching/2021s-cosc-112/labs/02-recursive-graphics/
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RecursiveSquares extends JPanel {
    
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768;
    public static final Color MAMMOTH_PURPLE = new Color(63, 31, 105);
    public static final Color SPRING_LEAF_LIGHT = new Color(147, 210, 143);

    public static final double SQUARE_RATIO = 2.2;
    public static final int DEFAULT_DEPTH = 2;

    @SuppressWarnings("unused")
	private static int maxDepth;

    
    public RecursiveSquares(){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }
    
    private void drawFigure (Graphics g, int cx, int cy, int size, int depth) {
    	
    	g.setColor(SPRING_LEAF_LIGHT);
    	g.fillRect(cx - size / 2, cy - size / 2, size, size);

    	g.setColor(Color.BLACK);
    	g.drawRect(cx - size / 2, cy - size / 2, size, size);
    }


    // Draw a square in the upper-left corner -- 
    // the figure is centered at (cx, cy), size is the size of the inner square,
    // and depth is the current recursion depth
    private void drawULFigure (Graphics g, int cx, int cy, int size, int depth) {
    	drawFigure(g, cx, cy, size, depth);
//    	
    	if(depth == 0) {
    		return;
    	}else {
    		depth--;
    		drawULFigure(g, cx - size / 2, cy - size / 2, size/ 2, depth);
    		drawURFigure(g, cx + size / 2, cy - size / 2, size/ 2, depth);
    		drawLRFigure(g, cx - size / 2, cy + size / 2, size/ 2, depth);
    		drawLLFigure(g, cx + size / 2, cy + size / 2, size/ 2, depth);
    		
    	}
    }

    // Draw the figure in the upper-right corner (you should add to this description)
    private void drawURFigure (Graphics g, int cx, int cy, int size, int depth) {
    	drawFigure(g, cx, cy, size, depth);
    	
    	if(depth == 0) {
    		return;
    	}else {
    		depth--;
    		drawULFigure(g, cx - size / 2, cy - size / 2, size/ 2, depth);
    		drawURFigure(g, cx + size / 2, cy - size / 2, size/ 2, depth);
    		drawLRFigure(g, cx - size / 2, cy + size / 2, size/ 2, depth);
    		drawLLFigure(g, cx + size / 2, cy + size / 2, size/ 2, depth);
    	}	
    	
    }

    // Draw the figure in the lower left corner (you should add to this description)
    private void drawLLFigure (Graphics g, int cx, int cy, int size, int depth) {
    	drawFigure(g, cx, cy, size, depth);
    	
    	if(depth == 0) {
    		return;
    	}else {
    		depth--;
    		drawULFigure(g, cx - size / 2, cy - size / 2, size/ 2, depth);
    		drawURFigure(g, cx + size / 2, cy - size / 2, size/ 2, depth);
    		drawLRFigure(g, cx + size / 2, cy + size / 2, size/ 2, depth);
    		drawLLFigure(g, cx - size / 2, cy + size / 2, size/ 2, depth);
    		
    	}
    }

    // Draw the figure in the lower right (you should add to this description)
    private void drawLRFigure (Graphics g, int cx, int cy, int size, int depth) {
    	drawFigure(g, cx, cy, size, depth);
    	
    	if(depth == 0) {
    		return;
    	}else {
    		depth--;
    		drawULFigure(g, cx - size / 2, cy - size / 2, size/ 2, depth);
    		drawURFigure(g, cx + size / 2, cy - size / 2, size/ 2, depth);
    		drawLRFigure(g, cx - size / 2, cy + size / 2, size/ 2, depth);
    		drawLLFigure(g, cx + size / 2, cy + size / 2, size/ 2, depth);
    		
    	}
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

	// make the background
        g.setColor(MAMMOTH_PURPLE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

    // IF YOU WANT TO RESIZE YOUR IMAGE, YOU CAN
    // DIVIDE ALL THESE INPUTS BY TWO TO SCALE IT DOWN.
	// draw the upper left figure
	drawULFigure(g, 200, 200, 200, maxDepth);

	// draw the upper right figure
	drawURFigure(g, 580, 200, 200, maxDepth);

	// draw the lower left figure
	drawLLFigure(g, 200, 580, 200, maxDepth);

	// draw the lower right figure
	drawLRFigure(g, 580, 580, 200, maxDepth);
    }
    
    public static void main(String args[]){
	// set default recursion depth
	maxDepth = DEFAULT_DEPTH;
	
	// if an argument is passed, use that value as recursion depth
	if (args.length > 0) {
	    maxDepth = Integer.parseInt(args[0]);
	}
	
        JFrame frame = new JFrame("Recursive Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RecursiveSquares());
        frame.pack();
        frame.setVisible(true);
    }
}
