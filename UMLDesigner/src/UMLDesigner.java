import java.util.ArrayList;
import java.util.List;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class UMLDesigner extends Application
{
	@Override
	public void start(Stage arg) throws Exception
	{
		Pane pane = new Pane();
		Stage stage = new Stage();
		Scene scene = new Scene(pane);
		List<Rectangle> selectedRectangles = new ArrayList<>();
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		// Set Stage boundaries to visible bounds of the main screen
		stage.setX(primaryScreenBounds.getMinX());
		stage.setY(primaryScreenBounds.getMinY());
		stage.setWidth(primaryScreenBounds.getWidth());
		stage.setHeight(primaryScreenBounds.getHeight());
		stage.setTitle("UML Designer");
		stage.setScene(scene);
		
		// Create the vbox to hold all of the buttons
		VBox toolBar = createToolbar(primaryScreenBounds);

		Button create1 = new Button("Create Class Diagram(1)");
		Button create2 = new Button("Create Class Diagram(2)");
		Button create3 = new Button("Create Class Diagram(3)");
		Button create4 = new Button("Create Class Diagram(4)");
		Button remove = new Button("Remove Class Diagram");
		
		ClassDiagram classDiagram = new ClassDiagram();
		
		// Button event handling
		create1.setOnAction((event) ->
		{
			List<Rectangle> addedRectangles = new ArrayList<>();
			Rectangle r1 = classDiagram.createClassDiagram(1);
			addedRectangles.add(r1);
			setRectangleEvents(selectedRectangles, addedRectangles);
			pane.getChildren().add(r1);
		});
		
		create2.setOnAction((event) -> 
		{
			List<Rectangle> addedRectangles = new ArrayList<>();
			Rectangle r1 = classDiagram.createClassDiagram(1);
			addedRectangles.add(r1);
			pane.getChildren().add(r1);
			Rectangle r2 = classDiagram.createClassDiagram(2);
			addedRectangles.add(r2);
			setRectangleEvents(selectedRectangles, addedRectangles);
			pane.getChildren().add(r2);
		});
		
		create3.setOnAction((event) -> 
		{
			List<Rectangle> addedRectangles = new ArrayList<>();
			Rectangle r1 = classDiagram.createClassDiagram(1);
			addedRectangles.add(r1);
			pane.getChildren().add(r1);
			Rectangle r2 = classDiagram.createClassDiagram(2);
			addedRectangles.add(r2);
			pane.getChildren().add(r2);
			Rectangle r3 = classDiagram.createClassDiagram(3);
			addedRectangles.add(r3);
			setRectangleEvents(selectedRectangles, addedRectangles);
			pane.getChildren().add(r3);
		});
		
		create4.setOnAction((event) -> 
		{
			List<Rectangle> addedRectangles = new ArrayList<>();
			Rectangle r1 = classDiagram.createClassDiagram(1);
			addedRectangles.add(r1);
			pane.getChildren().add(r1);
			Rectangle r2 = classDiagram.createClassDiagram(2);
			addedRectangles.add(r2);
			pane.getChildren().add(r2);
			Rectangle r3 = classDiagram.createClassDiagram(3);
			addedRectangles.add(r3);
			pane.getChildren().add(r3);
			Rectangle r4 = classDiagram.createClassDiagram(4);
			addedRectangles.add(r4);
			setRectangleEvents(selectedRectangles, addedRectangles);
			pane.getChildren().add(r4);
		});
		
		remove.setOnAction((event) -> 
		{
			for(Rectangle rectangle : selectedRectangles)
			{
					if(rectangle.getStroke() == Color.RED)
					{
						pane.getChildren().remove(rectangle);
					}
				}
		});
		
		// Add the buttons to the toolbar
		toolBar.getChildren().add(create1);
		toolBar.getChildren().add(create2);
		toolBar.getChildren().add(create3);
		toolBar.getChildren().add(create4);
		toolBar.getChildren().add(remove);
		
		// Add the toolbar to the pane
		pane.getChildren().add(toolBar);
		
		stage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

	public VBox createToolbar(Rectangle2D primaryScreenBounds)
	{
		VBox toolbar = new VBox(8);
		toolbar.setPrefWidth(primaryScreenBounds.getWidth() / 12);
		toolbar.setPrefHeight(primaryScreenBounds.getHeight() / 2);
		toolbar.setLayoutX(20);
		toolbar.setLayoutY(50);
		toolbar.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));
        toolbar.setBorder(new Border(new BorderStroke(Color.NAVY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        toolbar.setAlignment(Pos.TOP_CENTER);
        
        return toolbar;
	}
	
	public void setRectangleEvents(List<Rectangle> selectedRectangles, List<Rectangle> addedRectangles)
	{	
		for(Rectangle rect : addedRectangles)
		{
				// Handles highlighting and unhighlighting
				rect.setOnMouseClicked((event) -> 
				{
					if(rect.getStroke() == Color.RED)
					{
						for(Rectangle added : addedRectangles)
						{
								selectedRectangles.clear();
								added.setStroke(Color.BLACK);
								added.setStrokeWidth(4);
						}
					}
					else
					{
						for(Rectangle added : addedRectangles)
						{
							added.setStroke(Color.RED);
							added.setStrokeWidth(4);
							selectedRectangles.add(added);
						}
					}
				});
		}
		
	}
}
