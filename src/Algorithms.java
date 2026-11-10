
/***
 * This class implements several alghoritms
 */

public class Algorithms {
    /**
     * Determines the closes pair of points . Brute-force solution is used
     *
     * @param points  inout points
     * @param indices output array
     */
    public static void closestPairOfPoints(Point[] points, int[] indices) {
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double d = points[i].distance(points[j]);
                if (d < minDistance) {
                    minDistance = d;
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
    }

    /**
     * Determine weather a point has turned left of right using the determinant
     * @param p0 , p1 , p2
     * @return -1 if right , 0 if on the line , and 1 if left
     *
     */
    public static int turnDirection(Point p0 , Point p1, Point p2)
    {
        double D = (p0.getX()*p1.getY() + p1.getX()*p2.getY() + p2.getX()*p0.getY())-(p1.getX()*p0.getY() + p2.getX()*p1.getY()+p0.getX()*p2.getY());
        return (int)Math.signum(D);
    }

    /**
     * Determines if given point is in some polygon of the set
     * @param an array of polygons
     * @param p point given
     * @return index in array of polygons
     */

    public static int isPointInSet(Polygon[] polArray, Point p) {
        for (int i = 0; i < polArray.length; i++) {
            if (polArray[i]!= null && polArray[i].isPointInPolygon(p))
                return i;
        }
        return -1;
    }
}