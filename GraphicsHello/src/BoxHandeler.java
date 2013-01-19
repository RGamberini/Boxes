import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class BoxHandeler {
	List<Box> BoxList = new ArrayList<Box>();
	public void NewBox(int indexX, int indexY, int[] Color) {
		BoxList.add(new Box(0 + 50 * indexX,50 + 50 * indexY,50,50,50, Color));
	}
	
	public void InitWorld() {
		for (int i = 0, b = 0; i < 16; i++) {
			double NewY = 50 + 50 * b;
			int[] Color = {255,255,255};
			if (NewY < 450 ) {
				Color = new int[]{127,127,131};
			}
			
			else {
				Color = new int[]{87,59,12};
			}
			
			NewBox(i, b, Color);
			if (i == 15 && b != 9) {
				i = -1;
				b++;
			}
		}
	}
	
	public void DrawWorld() {
		for (Box o: BoxList) {
		    o.Draw();
		}
	}
	
	public void Click(double inpx, double inpy) {
		List<Integer> ToDelete = new ArrayList<Integer>();
		for (Box o: BoxList) {
			if (o.Hit(inpx, inpy)) {
				ToDelete.add(BoxList.indexOf(o));
			}
		}
		for (Integer num: ToDelete) {
			if (num.intValue() < BoxList.size()) {
				BoxList.remove(num.intValue());
			}
		}
	}
	
	public void RightClick(int inpx, int inpy) {
		NewBox(inpx, inpy, new int[]{87,59,12});
	}
	
	public boolean CheckCollision(double inpx, double inpy) {
		for (Box o: BoxList) {
			if (o.Hit(inpx, inpy)) {
				//System.out.println("No intersect" + BoxList.indexOf(o));
				return  true;
			}
		}
		return false;
		
	}

}
