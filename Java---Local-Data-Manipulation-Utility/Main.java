import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application{
	//We set up the variables we have declared in the xml file which will be used in this class.
	@FXML private final HBox hb = new HBox();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//loads Sample.fxml into the stage method
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
			//parent is the top of the ui tree. Could have been, BorderPane,HBox....
			Parent root = loader.load();
			Scene scene = new Scene(root,980,430);
			
			//Using CSS to style the components
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Here we create a SampleController object and use getController to get our current instance
			SampleController controller = loader.getController();
			
			//This determines that the first scene will start on the ButtonClick() method, and then activates it. 
			controller.ButtonClick();
	        primaryStage.setScene(scene);
			primaryStage.show();
					    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
