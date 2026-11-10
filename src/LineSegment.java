import java.awt.*;

/**
 * This class represents a line segment given by end points;
 * end points might be equal.
 */
public class LineSegment extends GeometricObject
{

    //begin and end are the end points of line segment; no guaranties on order
    private Point begin;
    private Point end;

    /**
     * Instantiates a LineSegment object with endpoints (0, 0) and (1, 1).
     */
    public LineSegment()
    {
        begin = new Point(0, 0);
        end = new Point(1, 1);
    }

    /**
     * Instantiates a LineSegment object with endpoints b and e.
     */
    public LineSegment(Point b, Point e)
    {
        begin = b;
        end = e;
    }

    /**
     * Draws this line segment.
     *
     * @param g graphic context
     */
    @Override
    public void draw(Graphics g)
    {
        //line segment is drawn by using its boundary color, not its interior
        //color (width of line=0)

        g.setColor(getBoundaryColor());
        g.drawLine((int)begin.getX(), (int)begin.getY(),
                (int)end.getX(), (int)end.getY());
    }

    /**
     * Returns the "begin" point of this line segment.
     *
     * @return the "begin" point of this line segment
     */
    public Point getBegin()
    {
        return begin;
    }

    /**
     * Sets the "begin" point of this line segment.
     *
     * @param b new "begin" point
     */
    public void setBegin(Point b)
    {
        begin = b;
    }

    /**
     * Returns the "end" point of this line segment.
     *
     * @return the "end" point of this line segment
     */
    public Point getEnd()
    {
        return end;
    }

    /**
     * Sets the "end" point of this line segment.
     *
     * @param e new "end" point
     */
    public void setEnd(Point e)
    {
        end = e;
    }

    /**
     * Determines the greatest x.
     *
     * @return the greatest x
     */
    public double greatestX()
    {
        return begin.getX() > end.getX() ? begin.getX() : end.getX();
    }

    /**
     * Determines the greatest y.
     *
     * @return the greatest y
     */
    public double greatestY()
    {
        return begin.getY() > end.getY() ? begin.getY() : end.getY();
    }

    /**
     * Determines the smallest x.
     *
     * @return the smallest x
     */
    public double smallestX()
    {
        return begin.getX() < end.getX() ? begin.getX() : end.getX();
    }

    /**
     * Determines the smallest y.
     *
     * @return the smallest y
     */
    public double smallestY()
    {
        return begin.getY() < end.getY() ? begin.getY() : end.getY();
    }

    /**
     * Constructs a String description of this line segment.
     *
     * @return String containing a description of this line segment
     */
    @Override
    public String toString()
    {
        String str = "LINE_SEGMENT " + super.toString() + "\n";
        str += begin + "\n" + end;

        return str;
    }

    /**
     * Translates this line segment by given vector.
     *
     * @param v given vector
     */
    public void translate(Vector v)
    {
        begin.translate(v);
        end.translate(v);
    }


    /***
     * Is horizontal method and Is Vertical Method
     */

    public boolean isVertical()
    {
        return this.begin.getX() ==  this.end.getX();
    }

    public boolean isHorizontal()
    {
        return this.begin.getY()== this.end.getY();
    }

    /**
     * Length() Method
     * @param None
     * Goal : returns the total lenghts of the segment
     */

    public double length()
    {
        return this.end.distance(this.begin);
    }
    /**
     * get supportingLine()
     * @param : none
     * Goal :  Return the line that goes thru those points (the entire thign rather than the segment )
     *
     * */
    public Line getSupportingLine(){
        return new Line(this.begin, this.end) ;
    }

    /**
     * Determine if this line segment intersects any given line segment
     *
     * @param ls Line Segment
     * @return true if intersectipn is not empty , false otherwise
     */

    public boolean intersect (LineSegment ls)
    {
        //For both line segments get the supporting lines and check the position of the other ends of the other line against it
        Line l1 = this.getSupportingLine();
        Point p1 =this.getBegin();
        Point p2 = this.getEnd();

        Line l2 = ls.getSupportingLine();
        Point p3 = ls.getBegin();
        Point p4 = ls.getEnd();

        int pos1 = l2.pointRelativePosition(p1);
        int pos2 = l2.pointRelativePosition(p2);
        int pos3 = l1.pointRelativePosition(p3);
        int pos4 = l1.pointRelativePosition(p4);

        // 1. General crossing case (opposite sides)
        if (((pos1 > 0 && pos2 < 0) || (pos1 < 0 && pos2 > 0)) &&
                ((pos3 > 0 && pos4 < 0) || (pos3 < 0 && pos4 > 0))) {
            return true;
        }

        // If all points lie on the same line
        if (pos1 == 0 && pos2 == 0 && pos3 == 0 && pos4 == 0) {
            boolean xOverlap = Math.max(Math.min(p1.getX(), p2.getX()), Math.min(p3.getX(), p4.getX()))
                    <= Math.min(Math.max(p1.getX(), p2.getX()), Math.max(p3.getX(), p4.getX()));

            boolean yOverlap = Math.max(Math.min(p1.getY(), p2.getY()), Math.min(p3.getY(), p4.getY()))
                    <= Math.min(Math.max(p1.getY(), p2.getY()), Math.max(p3.getY(), p4.getY()));

            return xOverlap && yOverlap;
        }

        return false;



    }



}
