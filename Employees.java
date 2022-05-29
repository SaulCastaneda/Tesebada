package TESEBADA;

public class Employees {
   private String EmpID;
   private String FirstName;
   private String LastName;
   private String Title;
   private String Division;
   private String Build;
   private String Room;
   
   public Employees() {
	   this.Build="";
	   this.Division="";
	   this.EmpID="";
	   this.FirstName="";
	   this.LastName="";
	   this.Room="";
	   this.Title="";
	   
   }
   
   public String getEmpID() {
	return EmpID;
}

public void setEmpID(String empID) {
	EmpID = empID;
}

public String getFirstName() {
	return FirstName;
}

public void setFirstName(String firstName) {
	FirstName = firstName;
}

public String getLastName() {
	return LastName;
}

public void setLastName(String lastName) {
	LastName = lastName;
}

public String getDivision() {
	return Division;
}

public void setDivision(String division) {
	Division = division;
}

public String getBuild() {
	return Build;
}

public void setBuild(String build) {
	Build = build;
}

public String getRoom() {
	return Room;
}

public void setRoom(String room) {
	Room = room;
}

public String getTitle() {
	return Title;
}

public Employees(String EmpID, String FirstName, String LastName, String Title, String Division, String Build , String Room){
    this.EmpID=EmpID;
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.Title=Title;
    this.Division=Division;
    this.Build=Build;
    this.Room=Room;
   }
   
}
