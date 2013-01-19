import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import java.lang.Math;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;

public class NewGraphics {
	
	public void HandelInput(Player Player1) {
		int[] validinput = {Keyboard.KEY_W, Keyboard.KEY_D, Keyboard.KEY_A};
		
		boolean[] oldinput = {false, true, true};
		
		String[] response = {"Up", "Right", "Left"};
		
		for (int i = 0; i < validinput.length; i++) {
			boolean isdown = Keyboard.isKeyDown(validinput[i]);
			if (isdown) {
				Player1.Move(response[i]);
			}
			
		}
	}
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,1000));
			Display.create();
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 0, 1000, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			Cursor emptyCursor = new Cursor(1, 1, 0, 0, 1, BufferUtils.createIntBuffer(1), null);
			Mouse.setNativeCursor(emptyCursor);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		Player Player1 = new Player();
		Crosshair Crosshair = new Crosshair();
		BoxHandeler Boxhandeler = new BoxHandeler();
		Boxhandeler.InitWorld();
		// init OpenGL here
		boolean oldkeyDown = false;
		
		while (!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			Display.setTitle("X: : " + Player1.velocity[0] + " Y: " + Player1.velocity[1]);
			GL11.glColor3f(87/255f,59/255f,12/255f);
			Boxhandeler.DrawWorld();
			HandelInput(Player1);
			Player1.Run(Boxhandeler);
			Player1.Draw();
			//I'm thinking drawing the cursor and other hud elements last would be the good idea
			GL11.glColor3f(115/255f,185/255f,1f);
			Crosshair.Draw();
			//INPUT TIME
			boolean leftButtonDown = Mouse.isButtonDown(0); // is left mouse button down.
			if (leftButtonDown) {
				Boxhandeler.Click(Mouse.getX(), Mouse.getY());
				//System.out.println("Click!");
			}
			
			boolean rightButtonDown = Mouse.isButtonDown(1); // is right mouse button down.
			if (rightButtonDown) {
				Boxhandeler.RightClick((int) Math.round(Mouse.getX() / 50), (int) Math.round(Mouse.getY() / 50));
				System.out.println("Click!");
			}
			
			
			boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_X);
			if (keyDown && keyDown != oldkeyDown) {
				Player1.Jump();
				System.out.println("UP!");
			}
			oldkeyDown = keyDown;
			
			
			// render OpenGL here
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		NewGraphics displayExample = new NewGraphics();
		displayExample.start();
	}
}