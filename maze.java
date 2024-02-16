package swingdemo;
import java.util.ArrayList;
import java.awt.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class maze  extends JFrame{
	static int[][] maz={
	{1,1,1,1,1,1,1,1,1,1,1,1,1},
	{1,0,1,0,1,0,1,0,0,0,0,0,1}, 
	{1,0,1,0,0,0,1,0,1,1,1,0,1}, 
	{1,0,1,1,1,1,1,0,0,0,0,0,1}, 
    {1,0,0,1,0,0,0,0,1,1,1,0,1}, 
    {1,0,1,0,1,1,1,0,1,0,0,0,1}, 
    {1,0,1,0,1,0,0,0,1,1,1,0,1}, 
    {1,0,1,0,1,1,1,0,1,0,1,0,1}, 
    {1,0,0,0,0,0,0,0,0,0,1,9,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1}

	};
	public static  List<Integer> path = new ArrayList<>();
	   public  maze() {
	        setTitle("Maze Solver");
	        setSize(640, 720);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	    @Override
	    public void paint(Graphics g) {
	        g.translate(50, 50);
	        for (int i = 0; i < maz.length; i++) {
	            for (int j = 0; j < maz[0].length; j++) {
	                Color color;
	                switch (maz[i][j]) {
	                    case 1:
	                        color = Color.BLACK;
	                        break;
	                    case 9:
	                        color = Color.RED;
	                        break;
	                    default:
	                        color = Color.WHITE;
	                        break;
	                }
	                g.setColor(color);
	                g.fillRect(30 * j, 30 * i, 30, 30); 
	                g.setColor(Color.red);
	                g.drawRect(30 * j, 30 * i, 30, 30);// Fixed the y-coordinate to use 'i' instead of '1'
	               
	            }
	        }
	        for(int k=0;k<path.size();k=k+2) {
	        	int x=path.get(k);
	        	int y=path.get(k+1);
	        	System.out.println(x+","+y);
	        	g.setColor(Color.green);
	        	g.fillRect(30 * y, 30 * x, 30, 30); 
	        	
	        }
	        
	    }
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            maze mazeSolver = new maze();
	            mazeSolver.setVisible(true);
	        });
	        DepthFirst.searchPath(maz,1,1,path);
	     
	        
	    }
	   
	    public class DepthFirst {
	    	 
	        public static boolean searchPath(int[][] maz, int x, int y, List<Integer> path) {
	        	if(x>=maz.length||y>=maz[0].length) {
	        		return false;
	        	}
	            if (maz[x][y] == 9) {
	               
	                return true;
	            }
	            
	            if (maz[x][y] == 0) {
	                maz[x][y] = 2;
	                int dx=-1;
	                int dy=0;
	                if(searchPath(maz,x+dx,y+dy,path)) {
	                	path.add(x);
		                path.add(y);
		                return true;
	                }
	                dx=1;
	                dy=0;
	                if(searchPath(maz,x+dx,y+dy,path)) {
	                	path.add(x);
		                path.add(y);
		                return true;
	                }
	                dx=0;
	                dy=-1;
	                if(searchPath(maz,x+dx,y+dy,path)) {
	                	path.add(x);
		                path.add(y);
		                return true;
	                }
	                dx=0;
	                dy=1;
	                if(searchPath(maz,x+dx,y+dy,path)) {
	                	path.add(x);
		                path.add(y);
		                return true;
	                }
	            }
	            return false;
	        }

}
}
