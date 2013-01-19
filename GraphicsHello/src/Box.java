import org.lwjgl.opengl.GL11;
public class Box {
	double TopLength, RightLength, BottomLength, LeftLength;
	double x, y;
	int[] color;
	
	public Box() {
		TopLength =  0; RightLength = 0; BottomLength = 0; LeftLength = 0;
		x = 0; y = 0;
	}
	public Box(double inpx, double inpy, double inpTopLength, double inpRightLength, double inpLeftLength, int[] inpcolor) {
		TopLength = inpTopLength; RightLength = inpRightLength; LeftLength = inpLeftLength;
		x = inpx; y = inpy;
		color = inpcolor;
		
	}
	public void Draw(){
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(color[0] / 255f, color[1] / 255f, color[2] / 255f);
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x + TopLength, y);
		GL11.glVertex2d(x + TopLength, y - RightLength);
		GL11.glVertex2d(x, y - LeftLength);
		GL11.glEnd();
		
	}
	
	public boolean Hit(double inpx, double inpy) {
		double minx = x;
		double maxx = x + TopLength;
		double miny = y - LeftLength;
		double maxy = y;
		if (inpx > minx && inpx < maxx && inpy > miny && inpy < maxy) {
			return true;
		}
		else {
			return false;
		}
	}
		
}
