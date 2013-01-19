import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Mouse;

public class Player {
	double x = 128; double y = 493 + 200;
	double[][] Sides = {{x - 35, y + 35}, {x + 35, y + 35},{x + 35, y - 35}, {x - 35, y - 35}};
	double[] velocity = {0, 0};
	double[] Color = {84,49,194};
	public void Draw( ) {
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3d(Color[0] / 255f, Color[1] / 255f, Color[2] / 255f);
		GL11.glVertex2d(x - 35, y + 35);
		GL11.glVertex2d(x + 35, y + 35);
		GL11.glVertex2d(x + 35, y - 35);
		GL11.glVertex2d(x - 35, y - 35);
		GL11.glEnd();
	}
	
	public void Run(BoxHandeler Boxhandeler){
		velocity[1] += -.1; // Gravity mother fucker
		if (velocity[1] < 0) {
			//System.out.println("LESS THEN ZERO");
			if (Boxhandeler.CheckCollision(x + velocity[0], y - 35 + velocity[1])) {
				velocity[1] = 0;
			}
		}
		
		else if (velocity[1] > 0) {
			if (Boxhandeler.CheckCollision(x + velocity[0], y + 35 + velocity[1])) {
				velocity[1] = 0;
			}
		}
		if (velocity[0] > 0) { 
			if (velocity[0] != 0 && velocity[0] < .1) {
				velocity[0] += -.2;
			}
			if (Boxhandeler.CheckCollision(x + 35 + velocity[0], y + velocity[1])) {
				velocity[0] = 0;
			}
		}
		
		else if (velocity[0] < 0) {
			if (velocity[0] != 0 && velocity[0] > -.1) {
				velocity[0] += .2;
			}
			if (Boxhandeler.CheckCollision(x - 35 + velocity[0], y + velocity[1])) {
				velocity[0] = 0;
			}
		}
		
		//if (Boxhandeler.CheckCollision(x + velocity[0], y - 35 + velocity[1])) {
			//velocity[1] = 0;
			//velocity[0] = 0;
		//}
		//System.out.println("HIT!");
		x += velocity[0];
		y += velocity[1];
	}
	
	public void Jump() {
		velocity[1] += 5;
	}
	
	public void Move(String Direction) {
		switch (Direction) {
			case "Up":	velocity[1] += 5;
			break;
							
			case "Right": velocity[0] += 1.5;
			break;
			
			case "Left": velocity[0] -= 1.5;
			break;
			
		}
	}

}
