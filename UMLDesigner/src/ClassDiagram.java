import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ClassDiagram {
	
	public Rectangle createClassDiagram(int numberOfFields)
	{
		Rectangle r = new Rectangle();
		
		if(numberOfFields == 1)
		{
			r.setX(200);
			r.setY(50);
			r.setWidth(200);
			r.setHeight(50);
			r.setArcWidth(20);
			r.setArcHeight(20);
			r.setFill(Color.TRANSPARENT);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(4);
		}
		
		if(numberOfFields == 2)
		{	
			r.setX(200);
			r.setY(100);
			r.setWidth(200);
			r.setHeight(100);
			r.setArcWidth(20);
			r.setArcHeight(20);
			r.setFill(Color.TRANSPARENT);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(4);
		}
		
		if(numberOfFields == 3)
		{	
			r.setX(200);
			r.setY(200);
			r.setWidth(200);
			r.setHeight(100);
			r.setArcWidth(20);
			r.setArcHeight(20);
			r.setFill(Color.TRANSPARENT);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(4);
		}
		
		if(numberOfFields == 4)
		{	
			r.setX(200);
			r.setY(300);
			r.setWidth(200);
			r.setHeight(100);
			r.setArcWidth(20);
			r.setArcHeight(20);
			r.setFill(Color.TRANSPARENT);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(4);
		}
		
		return r; 
	}
}
