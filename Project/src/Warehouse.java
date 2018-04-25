
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Warehouse implements Initializable {

	@FXML private Slider heightSlider;
	@FXML private Slider widthSlider;
	@FXML private GridPane grid = new GridPane();
	@FXML private RowConstraints row = new RowConstraints();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public Rectangle makeRectangle(int width, int height, Color color){
		Rectangle block = new Rectangle(width, height, color);
		return block;
	}
	
	@FXML
	public void sliderClickHeight(MouseEvent event){
		System.out.println(grid.getChildren());
		while(grid.getRowConstraints().size() > 0){
	        grid.getRowConstraints().remove(0);
	        //grid.getChildren().remove(0);
	    }
		
		/*while(grid.getChildren().size() > 1){
			grid.getChildren().remove(0);
	    }*/

		//System.out.println(grid.getChildren());
		
        for (int i = 0; i <= heightSlider.getValue()-1; i++) {
            RowConstraints x = new RowConstraints();
            x.setPrefHeight(30.0);
            x.setMinHeight(10.0);
            grid.getRowConstraints().add(x);
        }
        
        /*for (int i = 0; i <= heightSlider.getValue()-1;i++){
        	for (int j = 0; i <= widthSlider.getValue()-1;i++){
        		grid.add(new StackPane(), i, j);
        	}
        }*/

	}
	@FXML
	public void sliderClickWidth(MouseEvent event){
		
		while(grid.getColumnConstraints().size() > 0){
	        grid.getColumnConstraints().remove(0);
	        //grid.getChildren().clear();
	    }
		
		
        for (int i = 0; i <= widthSlider.getValue()-1; i++) {
            ColumnConstraints x = new ColumnConstraints();
            x.setPrefWidth(82.0);
            grid.getColumnConstraints().add(x);
        }
        
        /*for (int i = 0; i <= heightSlider.getValue()-1;i++){
        	for (int j = 0; i <= widthSlider.getValue()-1;i++){
        		grid.add(new StackPane(), i, j);
        	}
        }*/

	}
	
	
	
	@FXML
	public void addChild(MouseEvent e){
		
		double x = 0;
		double y = 0;
		
		Node source = (Node)e.getSource();
		
		int col = GridPane.getColumnIndex(source);
		int row = GridPane.getRowIndex(source);
		
		grid.add(makeRectangle(30, 30, Color.RED), col, row);
		
		
		
		
	}
	
}
