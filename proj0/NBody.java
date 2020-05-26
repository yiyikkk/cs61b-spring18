public class NBody {
    /**
     * read the radius of the universe in that file.
     */
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();
    }

    /**
     * return an array of Planets corresponding to the planets in the file.
     */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        in.readDouble();
        Planet[] ps = new Planet[n];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return ps;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] ps = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
//        StdDraw.picture(0, 0, "images/starfield.jpg");

        //draw
        double t = 0;
        while (t <= T) {
            double[] xforce = new double[ps.length];
            double[] yforce = new double[ps.length];
            for (int i = 0; i < ps.length; i++) {
                xforce[i] = ps[i].calcNetForceExertedByX(ps);
                yforce[i] = ps[i].calcNetForceExertedByY(ps);
            }

            for (int i = 0; i < ps.length; i++) {
                ps[i].update(dt, xforce[i], yforce[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : ps) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            t += dt;
        }

        //print the universe
        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                    ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
        }
    }
}
