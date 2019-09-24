package perlin;

public class Point2D {
double x;
double y;
	public Point2D(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public static double dotProduct(Point2D a, Point2D b){
		return a.x*b.x+a.y*b.y;
	}

}
