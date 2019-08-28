import javafx.beans.property.SimpleStringProperty;

//This class defines the Hospital object which will be used as the format for the
// the data entries in out table.
public class Hospital {
 
		//These are the properties of the Hospital object, with each one corresponding to a different
		// column in the table.
        private final SimpleStringProperty Provider_ID;
        private final SimpleStringProperty Hospital_Name;
        private final SimpleStringProperty Address;
        private final SimpleStringProperty City;
        private final SimpleStringProperty State;
        private final SimpleStringProperty County;
        private final SimpleStringProperty Phone;
        private final SimpleStringProperty Type;
        private final SimpleStringProperty Zip;
        private final SimpleStringProperty Ownership;
        private final SimpleStringProperty ES;
        private final SimpleStringProperty EHR;
        private final SimpleStringProperty OR;
        private final SimpleStringProperty MNC;
        private final SimpleStringProperty SCNC;
        private final SimpleStringProperty RNC;
        private final SimpleStringProperty PENC;
        private final SimpleStringProperty ECNC;
        private final SimpleStringProperty TCNC;
        private final SimpleStringProperty EMINC;
        
        //This assigns the column values for each data entry appropriately upon initializing it.
        Hospital(String[] arg) {
            this.Provider_ID = new SimpleStringProperty(arg[0]);
            this.Hospital_Name = new SimpleStringProperty(arg[1]);
            this.Address = new SimpleStringProperty(arg[2]);
            this.City = new SimpleStringProperty(arg[3]);
            this.State = new SimpleStringProperty(arg[4]);
            this.Zip = new SimpleStringProperty(arg[5]);
            this.County = new SimpleStringProperty(arg[6]);
            this.Phone = new SimpleStringProperty(arg[7]);
            this.Type = new SimpleStringProperty(arg[8]);
            this.Ownership = new SimpleStringProperty(arg[9]);
            this.ES = new SimpleStringProperty(arg[10]);
            this.EHR = new SimpleStringProperty(arg[11]);
            this.OR = new SimpleStringProperty(arg[12]);
            this.MNC = new SimpleStringProperty(arg[13]);
            this.SCNC = new SimpleStringProperty(arg[14]);
            this.RNC = new SimpleStringProperty(arg[15]);
            this.PENC = new SimpleStringProperty(arg[16]);
            this.ECNC = new SimpleStringProperty(arg[17]);
            this.TCNC = new SimpleStringProperty(arg[18]);
            this.EMINC = new SimpleStringProperty(arg[19]);
        }
        
        //Each property of the object is assigned two corresponding methods: get<field>() which
        // returns the value of said field when called, and set<field>(String <value>) which assigns 
        // the given value to the field. 
        public String getProvider_ID() {
            return Provider_ID.get();
        }
 
        public void setProvider_ID(String fName) {
            Provider_ID.set(fName);
        }
 
        public String getHospital_Name() {
            return Hospital_Name.get();
        }
 
        public void setHospital_Name(String fName) {
            Hospital_Name.set(fName);
        }
 
        public String getAddress() {
            return Address.get();
        }
 
        public void setAddress(String fName) {
            Address.set(fName);
        }

		public String getCity() {
			return City.get();
		}

		public String getState() {
			return State.get();
		}

		public String getCounty() {
			return County.get();
		}

		public String getPhone() {
			return Phone.get();
		}
		
		public String getOwnership() {
			return Ownership.get();
		}

		public String getES() {
			return ES.get();
		}

		public String getType() {
			return Type.get();
		}

		public String getEHR() {
			return EHR.get();
		}

		public String getMNC() {
			return MNC.get();
		}

		public String getSCNC() {
			return SCNC.get();
		}
		public String getOR() {
			return OR.get();
		}

		public String getPENC() {
			return PENC.get();
		}
		
		public String getRNC() {
			return RNC.get();
		}
		public String getECNC() {
			return ECNC.get();
		}

		public String getTCNC() {
			return TCNC.get();
		}

		public String getEMINC() {
			return EMINC.get();
		}

		public String getZip() {
			return Zip.get();
		}
    }
