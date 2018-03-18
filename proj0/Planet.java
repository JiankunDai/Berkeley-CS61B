class Planet{

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
					double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double rSquared = (dx * dx) + (dy * dy);
		return Math.sqrt(rSquared);
	}

	public double calcForceExertedBy(Planet p){
	//	static final double G = 6.67e-11;
		double G = 6.67 * Math.pow(10, -11);
		double r = calcDistance(p);
	//	double force = (G * this.mass * p.mass) / this.calcDistance(p);
		double force = (G * this.mass * p.mass) / (r * r);
		return force;  
	}

	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - this.xxPos;
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		double forceX = force * dx / r;
		return forceX;
	}

	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - this.yyPos;
		double r = calcDistance(p);
        double force = calcForceExertedBy(p);
		double ForceY = force * dy / r;
		return ForceY;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netforceX = 0;
		for (Planet p : allPlanets) {
			if (p.equals(this)) {
				continue;
			} else {
				netforceX += this.calcForceExertedByX(p); 
			}
		}
		return netforceX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netforceY = 0;
		for (Planet p : allPlanets) {
			if (p.equals(this)) {
				continue;
			} else {
				netforceY += this.calcForceExertedByY(p); 
			}
		}
		return netforceY;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;

		this.xxVel += dt * aX;
		this.yyVel += dt * aY;

		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;

	}

	public void draw() {
		String filename = "./images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, filename);
	}
}

