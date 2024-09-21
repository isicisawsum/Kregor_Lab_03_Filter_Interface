import java.awt.Rectangle;
public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        Rectangle r = (Rectangle) x;
        if (((r.width * 2) + (r.height * 2)) > 10){
            return true;
        }
        else {
            return false;
        }
    }

}
