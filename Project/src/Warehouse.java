
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Warehouse implements Initializable {

	private int blockHeight = 301/9;
	private int blockWidth = 290/9;
	
	@FXML private Slider heightSlider;
	@FXML private Slider widthSlider;
	@FXML private GridPane grid = new GridPane();
	@FXML private RowConstraints rowConstraint = new RowConstraints();
	@FXML private ColumnConstraints columnConstraint = new ColumnConstraints();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public Rectangle makeRectangle(int width, int height, Color color){
		Rectangle block = new Rectangle(height,width, color);
		System.out.println(grid.getPrefHeight() + " " + grid.getPrefWidth());
		return block;
	}
	
	@FXML
	public void addChild(MouseEvent e){
		Node source = (Node)e.getSource();
		
		int col = GridPane.getColumnIndex(source);
		int row = GridPane.getRowIndex(source);
		
		grid.add(makeRectangle(blockHeight, blockWidth, Color.RED), col, row);
		
	}
	
	@FXML
	public void sliderClickHeight(MouseEvent event){
		while(grid.getRowConstraints().size() > 0){
	        grid.getRowConstraints().remove(0);
	    }
		
		while(grid.getChildren().size() > 1){
			String x = grid.getChildren().toString().substring(1,6);
			if(x.equals("Group")){
				grid.getChildren().remove(1);
				}else{
				grid.getChildren().remove(0);
				}
	    }
		
        for (int i = 0; i <= heightSlider.getValue()-1; i++) {
        	rowConstraint.setPrefHeight(30.0);
        	rowConstraint.setMinHeight(10.0);
            grid.getRowConstraints().add(rowConstraint);
        }
        
        
        for (int i = 0; i <= heightSlider.getValue()-1;i++){
        	for (int j = 0; j <= widthSlider.getValue()-1;j++){
        		StackPane x = new StackPane();
        		grid.add(x, i, j);
        		GridPane.setRowIndex(x, i);
        	    GridPane.setColumnIndex(x, j);
        	    x.setOnMouseClicked(event1 -> addChild(event1));;

        	}
        }
	}
	@FXML
	public void sliderClickWidth(MouseEvent event){
		
		while(grid.getColumnConstraints().size() > 0){
	        grid.getColumnConstraints().remove(0);
	    }
		
		while(grid.getChildren().size() > 1){
			String x = grid.getChildren().toString().substring(1,6);
			if(x.equals("Group")){
				grid.getChildren().remove(1);
				}else{
				grid.getChildren().remove(0);
				}
	    }
		
        for (int i = 0; i <= widthSlider.getValue()-1; i++) {
        	//columnConstraint = new ColumnConstraints();
        	columnConstraint.setPrefWidth(82.0);
            grid.getColumnConstraints().add(columnConstraint);
        }
        
        for (int i = 0; i <= heightSlider.getValue()-1;i++){
        	for (int j = 0; j <= widthSlider.getValue()-1;j++){
        		StackPane x = new StackPane();
        		grid.add(x, i, j);
        		GridPane.setRowIndex(x, i);
        	    GridPane.setColumnIndex(x, j);
        		x.setOnMouseClicked(event1 -> addChild(event1));

        	}
        }
    	blockHeight = (int) (301/heightSlider.getValue() -1);
    	blockWidth = (int) (290/widthSlider.getValue() -1);

	}
	
}
