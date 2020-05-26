public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * constructor with params
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /**
     * constructor by copying params of other planet p
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * calculate the distance between 2 planets
     */
    public double calcDistance(Planet p) {
        double dx = Math.abs(p.xxPos - this.xxPos);
        double dy = Math.abs(p.yyPos - this.yyPos);
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculate force exerted on this p by the param p.
     */
    public double calcForceExertedBy(Planet p) {
        return (6.67e-11 * p.mass * this.mass) / (this.calcDistance(p) * this.calcDistance(p));
    }

    /**
     * Calculate force in the x direction exerted on this p by the param p.
     */
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        return (this.calcForceExertedBy(p) * dx) / this.calcDistance(p);
    }

    /**
     * Calculate force in the y direction exerted on this p by the param p.
     */
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        return (this.calcForceExertedBy(p) * dy) / this.calcDistance(p);
    }

    /**
     * calculate the net X force exerted by all planets in that array upon the current Planet
     */
    public double calcNetForceExertedByX(Planet[] ps) {
        double netFx = 0;
        for (Planet p : ps) {
            if (!this.equals(p)) {
                netFx = netFx + this.calcForceExertedByX(p);
            }
        }
        return netFx;
    }

    /**
     * calculate the net Y force exerted by all planets in that array upon the current Planet
     */
    public double calcNetForceExertedByY(Planet[] allp) {
        double netFy = 0;
        for (Planet p : allp) {
            if (!this.equals(p)) {
                netFy = netFy + this.calcForceExertedByY(p);
            }
        }
        return netFy;
    }

    /**
     * update the velocity and position of p.
     */
    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    /**
     * draw
     */
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}


