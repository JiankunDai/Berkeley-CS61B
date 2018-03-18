public class starfield {

	public static String imageToDraw = "./images/starfield.jpg";

	public static void draw() {
		StdDraw.setScale(-100, 100);

		StdDraw.clear();

		StdDraw.picture(0, 0, imageToDraw);

		StdDraw.show();
		StdDraw.pause(2000);

	}

	public static void main(String[] args) {
	    draw();
	}
} 