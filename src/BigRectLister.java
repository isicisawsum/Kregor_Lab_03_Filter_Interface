import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Object> rects = new ArrayList<>();
        BigRectangleFilter bigRect = new BigRectangleFilter();

        rects.add(new Rectangle(10,12)); //perimeter greater
        rects.add(new Rectangle(5,10)); //perimeter greater
        rects.add(new Rectangle(2,4)); //perimeter lesser
        rects.add(new Rectangle(3,2)); //perimeter lesser
        rects.add(new Rectangle(1,4)); //perimeter lesser
        rects.add(new Rectangle(13,14)); //perimeter greater
        rects.add(new Rectangle(6,5)); //perimeter greater
        rects.add(new Rectangle(23,10)); //perimeter greater
        rects.add(new Rectangle(3,3)); //perimeter lesser
        rects.add(new Rectangle(1,2)); //perimeter lesser

        for(Object rect:rects){
            if(bigRect.accept(rect)){
                System.out.println("Big rectangle detected: " + rect);
            }
        }
    }
}
