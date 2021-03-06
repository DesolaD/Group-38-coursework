import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Reader read;

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("WarehouseGrid.fxml"));
			loader.setController(new Warehouse());
			final Parent root = loader.load();

			final Scene scene = new Scene(root);
			primaryStage.setTitle("Warehouse Simulator");
			primaryStage.setScene(scene);
		    primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RobotDatabase(){
		
	}
}
