import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	//The first thing we do is set up the variables we have declared in the xml file which will be used in this class.
	@SuppressWarnings("rawtypes")
	@FXML private TableView<Hospital> table = new TableView();

	@SuppressWarnings("rawtypes")
	@FXML private ObservableList data;

	@FXML private Button dbn = new Button();
	@FXML private Button col = new Button();
	@FXML private Button res = new Button();
	
	@FXML private TextArea Results = new TextArea();
	@FXML private TextField input = new TextField();
	@FXML private TextField search = new TextField();
	
	//These are the table column variables which will be used in many of this classes methods.
	static TableColumn<Hospital, String> col1 = new TableColumn<Hospital, String>("Provider_ID");
	static TableColumn<Hospital, String> col2 = new TableColumn<Hospital, String>("Hospital_Name");
    static TableColumn<Hospital, String> col3 = new TableColumn<Hospital, String>("City");
    static TableColumn<Hospital, String> col4 = new TableColumn<Hospital, String>("State");
    static TableColumn<Hospital, String> col5 = new TableColumn<Hospital, String>("County");
    static TableColumn<Hospital, String> col6 = new TableColumn<Hospital, String>("Address");
    static TableColumn<Hospital, String> col7 = new TableColumn<Hospital, String>("Phone");
    static TableColumn<Hospital, String> col8 = new TableColumn<Hospital, String>("Type");
    static TableColumn<Hospital, String> col9 = new TableColumn<Hospital, String>("Ownership");
    static TableColumn<Hospital, String> col10 = new TableColumn<Hospital, String>("ES");    
    static TableColumn<Hospital, String> col11 = new TableColumn<Hospital, String>("EHR");
    static TableColumn<Hospital, String> col12 = new TableColumn<Hospital, String>("OR");
    static TableColumn<Hospital, String> col13 = new TableColumn<Hospital, String>("MNC");
    static TableColumn<Hospital, String> col14 = new TableColumn<Hospital, String>("RNC");
    static TableColumn<Hospital, String> col15 = new TableColumn<Hospital, String>("SCNC");
    static TableColumn<Hospital, String> col16 = new TableColumn<Hospital, String>("PENC");
    static TableColumn<Hospital, String> col17 = new TableColumn<Hospital, String>("ECNC");
    static TableColumn<Hospital, String> col18 = new TableColumn<Hospital, String>("TCNC");
    static TableColumn<Hospital, String> col19 = new TableColumn<Hospital, String>("EMINC");
    
    //Here we set three event handlers, one for each button
	public void ButtonClick() {
		//Select columns button event handler
		col.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
				table.getColumns().clear();
				String inp = input.getText();
		        setCol(inp);
		    }
		});
		//Select data button event handler
		dbn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	String se = search.getText();
		        searchFor(se);
		    }
		});
		//Reset button event handler
		res.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		        reset();
		    }
		});
	}

	//This serves as both the action called by a press to the reset button,
	// as well as the tool used by the initializer to fill up the table when the
	// application is opened
	@SuppressWarnings("unchecked")
	public void reset() {
		table.getItems().clear();
		table.getColumns().clear();
        getCol();
		table.getColumns().addAll(col1, col2, col3, 
				col4, col5, col6, col7, col8, col9, col10, col11, 
				col12, col13, col14, col15, col16, col17, col18, col19);
	}
	
	public SampleController() {
		
	}
	//This initializes the table.
	public void initialize() {
		Results.setEditable(false);
		reset();
	}
	
	//This method checks what property of the Hospital object is being measured, and
	// then returns the rows which match the value specified. With the exception of the overall rating property (OR)
	// the only comparison operator which is recognized is the equals operator. Because of this the specified criteria
	// must be given in the form "<field> = <value>" with the value being case sensitive. One cannot perform searches
	// on multiple field values by entering multiple conditions in the search box. They must be entered one after the other
	// with the computer performing subsequent searches on the cells left by the previous search until the table is refreshed by
	// pressing the "Select Column" button with no input in its text box.
	public void searchFor(String se) {
		String PID = "Provider ID = ";
		String PI_D = "Provider_ID = ";
		String ID;
		String a;
		int x = PID.length();
		int i;
		if(se.contains(PID) || se.contains(PI_D)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {
					a = entry.getProvider_ID();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String HIN = "Hospital Name = ";
		String HI_N = "Hospital_Name = ";
		x = HIN.length();
		if(se.contains(HIN) || se.contains(HI_N)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getHospital_Name();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String City = "City = ";
		x = City.length();
		if(se.contains(City)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {
					a = entry.getCity();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String State = "State = ";
		x = State.length();
		if(se.contains(State)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getState();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String county = "County = ";
		x = county.length();
		if(se.contains(county)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getCounty();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String add = "Address = ";
		x = add.length();
		if(se.contains(add)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {
					a = entry.getAddress();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String phone = "Phone = ";
		x = phone.length();
		if(se.contains(phone)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {
					a = entry.getPhone();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String Type = "Type = ";
		x = Type.length();
		if(se.contains(Type)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getType();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String own = "Ownership = ";
		x = own.length();
		if(se.contains(own)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getOwnership();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String es = "ES = ";
		x = es.length();
		if(se.contains(es)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getES();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String ehr = "EHR = ";
		x = ehr.length();
		if(se.contains(ehr)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {
					a = entry.getEHR();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String OR = "OR = ";
		x = OR.length();
		if(se.contains(OR)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getOR();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String ORL = "OR < ";
		x = ORL.length();
		if(se.contains(ORL)) {
			ID = se.substring(x);
			int ORLN = Integer.parseInt(ID);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {					
					a = entry.getOR();
					int an = Integer.parseInt(a);

					if(an < ORLN) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;

				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}			
			}
		}
		String ORG = "OR > ";
		x = ORG.length();
		if(se.contains(ORG)) {
			ID = se.substring(x);
			int ORLG = Integer.parseInt(ID);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {					
					a = entry.getOR();
					int an = Integer.parseInt(a);

					if(an > ORLG) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;

				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}			
			}
		}
		String MNC = "MNC = ";
		x = MNC.length();
		if(se.contains(MNC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getMNC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String RNC = "RNC = ";
		x = RNC.length();
		if(se.contains(RNC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getRNC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String SCNC = "SCNC = ";
		x = SCNC.length();
		if(se.contains(SCNC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getSCNC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}			}
		}
		String PENC = "PENC = ";
		x = PENC.length();
		if(se.contains(PENC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getPENC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
				a = null;
			}
		}
		String ECNC = "ECNC = ";
		x = ECNC.length();
		if(se.contains(ECNC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getECNC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String TCNC = "TCNC = ";
		x = TCNC.length();
		if(se.contains(TCNC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try {
					a = entry.getTCNC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
		String EMINC = "EMINC = ";
		x = EMINC.length();
		if(se.contains(EMINC)) {
			ID = se.substring(x);
			i = 0;
			while(i < table.getItems().size()) {
				Hospital entry = (Hospital) table.getItems().get(i);
				try { 
					a = entry.getEMINC();
					if(a.equals(ID)) {
						i = i + 1;
					} else {
						table.getItems().remove(entry);
					}
					a = null;
				} catch(NumberFormatException e) {
					table.getItems().remove(entry);
				} catch(NullPointerException e) {
					table.getItems().remove(entry);
				}
			}
		}
	}	
	
	//This method applies the predefined columns to our table and formats them properly. It is used in the
	// reset function to re-apply all columns after the table has been cleared.
	public void getCol() {
		table.setEditable(true);
		        
        col1.setMinWidth(100);
        col1.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("Provider_ID"));
         
        col2.setMinWidth(150);
        col2.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("Hospital_Name"));
        
        col3.setMinWidth(100);
        col3.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("City"));
        
        col4.setMinWidth(100);
        col4.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("State"));
         
        col5.setMinWidth(100);
        col5.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("County"));
        
        col6.setMinWidth(100);
        col6.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("Address"));
       
        col7.setMinWidth(100);
        col7.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("Phone"));
        
        col8.setMinWidth(100);
        col8.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("Type"));
        
        col9.setMinWidth(100);
        col9.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("Ownership"));
        
        col10.setMinWidth(100);
        col10.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("ES"));

        col11.setMinWidth(100);
        col11.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("EHR"));        
        
        col12.setMinWidth(100);
        col12.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("OR"));
        
        col13.setMinWidth(100);
        col13.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("MNC"));
        
        col14.setMinWidth(100);
        col14.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("RNC"));
        
        col15.setMinWidth(100);
        col15.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("SCNC"));
        
        col16.setMinWidth(100);
        col16.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("PENC"));
        
        col17.setMinWidth(100);
        col17.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("ECNC"));
        
        col18.setMinWidth(100);
        col18.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("TCNC"));

        col19.setMinWidth(100);
        col19.setCellValueFactory(
                new PropertyValueFactory<Hospital, String>("EMINC"));
        DB_Connect.getResults();
        data = DB_Connect.returnData();
        table.setItems(data);
	}
	
	//This method is called by a press to the "Select Columns" button. It checks each
	// column name to see if it has been placed in the buttons text box and adds them
	// if it has been.
	@SuppressWarnings("unchecked")
	public void setCol(String inp) {
        if(inp.contains("Provider ID") || inp.contains("Provider_ID")) {
			table.getColumns().addAll(col1);
		} if(inp.contains("Hospital Name") || inp.contains("Hospital_Name")) {
			table.getColumns().addAll(col2);
		} if(inp.contains("City")) {
			table.getColumns().addAll(col3);
		} if(inp.contains("State")) {
			table.getColumns().addAll(col4);
		} if(inp.contains("County")) {
			table.getColumns().addAll(col5);
		} if(inp.contains("Address")) {
			table.getColumns().addAll(col6);
		} if(inp.contains("Phone")) {
			table.getColumns().addAll(col7);
		} if(inp.contains("Type")) {
			table.getColumns().addAll(col8);
		} if(inp.contains("Ownership")) {
			table.getColumns().addAll(col9);
		} if(inp.contains("ES")) {
			table.getColumns().addAll(col10);
		} if(inp.contains("EHR")) {
			table.getColumns().addAll(col11);
		} if(inp.contains("OR")) {
			table.getColumns().addAll(col12);
		} if(inp.contains("MNC")) {
			table.getColumns().addAll(col13);
		} if(inp.contains("RNC")) {
			table.getColumns().addAll(col14);
		} if(inp.contains("SCNC")) {
			table.getColumns().addAll(col15);
		} if(inp.contains("PENC")) {
			table.getColumns().addAll(col16);
		} if(inp.contains("ECNC")) {
			table.getColumns().addAll(col17);
		} if(inp.contains("TCNC")) {
			table.getColumns().addAll(col18);
		} if(inp.contains("EMINC")) {
			table.getColumns().addAll(col19);
		} 
	}
}
