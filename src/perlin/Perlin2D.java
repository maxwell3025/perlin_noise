package perlin;

public class Perlin2D {
	public static double CalcPerlin2D(Point2D[][] edges, double x, double y) {
		double xdif = Math.IEEEremainder(x, 1);
		double ydif = Math.IEEEremainder(y, 1);
		return PerlinModule2D(edges[(int) Math.floor(x)][(int) Math.floor(y)],
				edges[(int) Math.floor(x)][(int) Math.ceil(y)], edges[(int) Math.ceil(x)][(int) Math.floor(y)],
				edges[(int) Math.ceil(x)][(int) Math.ceil(y)], xdif, ydif);
	}

	public static Point2D[][] randomArray(int width, int height, double amplitude) {
		Point2D[][] output = new Point2D[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				double randomangle = Math.random() * Math.PI;
				Point2D temp = new Point2D( Math.sin(randomangle) * amplitude,
											Math.cos(randomangle) * amplitude);
				output[x][y]=temp;
			}
		}
		return output;
	}

	public static double PerlinModule2D(Point2D oo, Point2D oi, Point2D io, Point2D ii, double x, double y) {
		Point2D aa = new Point2D(x, y);
		Point2D ab = new Point2D(x, 1 - y);
		Point2D ba = new Point2D(1 - x, y);
		Point2D bb = new Point2D(1 - x, 1 - y);
		double cc = Point2D.dotProduct(aa, oo);
		double cd = Point2D.dotProduct(ab, oi);
		double dc = Point2D.dotProduct(ba, io);
		double dd = Point2D.dotProduct(bb, ii);
		double output = interpolate(interpolate(cc, cd, x), interpolate(dc, dd, x), y);
		return output;

	}

	public static double lerp(double start, double end, double intfactor) {
		return start * (1 - intfactor) + end * intfactor;
	}

	public static double interpolate(double start, double end, double intfactor) {
		return lerp(start, end, intfactor);
	}

}
