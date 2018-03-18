class NBody {

	public static double readRadius(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlants(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double radius = in.readDouble();

		Planet[] planets = new Planet[N];
		int i = 0;

		while(i != 0) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();

			planets[i] = new Planet(xP, yP, xV, yV, m, img);
			i++;
		}

		return planets;
	}


	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
	
		double radius = readRadius(filename);
		Planet[] planets = readPlants(filename);

		public static String imageToDraw = "images/starfield.jpg";

		StdDraw.setScale(-100, 100);
		StdDraw.clear();
		StdDraw.picture(0, 0, "./images/starfield.jpg");
        StdDraw.show();
		StdDraw.pause(2000);

		for (Planet p : planets) {
			p.draw();
		}

		
	}

}

