package poker.app.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import domain.GameRuleDomainModel;
import enums.eGame;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import poker.app.MainApp;
import pokerBase.Rule;
import logic.GameRuleBLL;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController implements Initializable {

    // Reference to the main application
    private MainApp mainApp;
    
    @FXML
    private MenuBar mb;
    @FXML
    private Menu mnuGame;
    
    @FXML
    private ToggleGroup tglGames;
    
    @FXML
    private RadioMenuItem Omaha = new RadioMenuItem();
    
    @FXML
    private RadioMenuItem Texas = new RadioMenuItem();
    
    // Five Card Draw
    @FXML
    private RadioMenuItem FCD = new RadioMenuItem();
    
    // Seven Card Draw
    @FXML
    private RadioMenuItem SCD = new RadioMenuItem();
    
    @FXML
    private RadioMenuItem oneJoker = new RadioMenuItem();
    
    @FXML
    private RadioMenuItem twoJoker = new RadioMenuItem();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Menu m = new Menu();
		m.setText("Rule Menu");
		ToggleGroup tg = new ToggleGroup();
		
		for(GameRuleDomainModel gr : GameRuleBLL.getRules()) {
			RadioMenuItem menItem = new RadioMenuItem();
			menItem.setText(gr.getRULENAME());
			menItem.setToggleGroup(tg);
			
			if (gr.getDEFAULTGAME() == 1) {
				menItem.setSelected(true);
			}
			
			m.getItems().add(menItem);
			
		}
		mb.getMenus().add(m);
		
/*		CheckMenuItem item1 = new CheckMenuItem("5 card stud");
        item1.selectedProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
               mainApp.setiGameType(1);              
            }            
          });
		
		
		mnuGame.getItems().add(item1);
		
		
		
		CheckMenuItem item2 = new CheckMenuItem("5 card draw");
        item2.selectedProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
               mainApp.setiGameType(2);              
            }            
          });
		
		
		mnuGame.getItems().add(item2);*/
		
		
	}
    
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
    	Omaha.setToggleGroup(tglGames);
    	Texas.setToggleGroup(tglGames);
    	FCD.setToggleGroup(tglGames);
		Omaha.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("omaha toggled");
                PokerTableController.setRle(new Rule(eGame.Omaha));
            }
        });
		Texas.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("texas toggled");
                PokerTableController.setRle(new Rule(eGame.TexasHoldEm));
            }
        });
		
		FCD.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("fcd toggled");
                PokerTableController.setRle(new Rule(eGame.FiveStud));
            }
        });
    	
		SCD.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("scd toggled");
                PokerTableController.setRle(new Rule(eGame.SevenDraw));
            }
        });
		
		oneJoker.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("one joker toggled");
                PokerTableController.setRle(new Rule(eGame.FiveStudOneJoker));
            }
        });
		
		twoJoker.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("two joker toggled");
                PokerTableController.setRle(new Rule(eGame.FiveStudTwoJoker));
            }
        });
		
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Author: Bert Gibbons");

        alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
    }
    
    public ToggleGroup getTglGames() {
		return tglGames;
	}


	public void setTglGames(ToggleGroup tglGames) {
		this.tglGames = tglGames;
	}




}