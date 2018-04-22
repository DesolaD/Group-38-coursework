import java.util.ArrayList;

import javafx.collections.FXCollections;

public class Databases {
	private final ArrayList<Robot> items;
	
	public Databases(){
		items = new ArrayList<Robot>(FXCollections.observableArrayList());
	}

	public void addRobot(Robot item) {
		items.add(item);
	}
	
    public ArrayList<Robot> itemsProperty() {
    	return items;
    }
}
