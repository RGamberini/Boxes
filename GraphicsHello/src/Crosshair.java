import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Mouse;

public class Crosshair {
		
	public void Draw() {
		int Mousex = Mouse.getX();
		int Mousey = Mouse.getY();
		
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2d(Mousex - 2, Mousey + 5);
		GL11.glVertex2d(Mousex + 2, Mousey + 5);
		GL11.glVertex2d(Mousex + 2, Mousey - 5);
		GL11.glVertex2d(Mousex - 2, Mousey - 5);
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2i(Mousex - 5, Mousey + 2);
		GL11.glVertex2i(Mousex + 5, Mousey + 2);
		GL11.glVertex2i(Mousex + 5, Mousey - 2);
		GL11.glVertex2i(Mousex - 5, Mousey - 2);
		GL11.glEnd();
		
	}

}
