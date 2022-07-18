import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Database_Implimentation {

	
    // Database credentials
    final static String HOSTNAME = "INSERT SQL SERVER HERE";
    final static String DBNAME = "Insert Database Name Here";
    final static String USERNAME = "Insert SQL Server Username Here";
    final static String PASSWORD = "Insert SQL Server Password Here";

    // Database connection string
    final static String URL = String.format("Insert Database Connection URL Here",
            HOSTNAME, DBNAME, USERNAME, PASSWORD);

    // User input prompt//
    final static String PROMPT = 
            "\nPlease select one of the options below: \n" +
            "1) Insert new team; \n" + 
            "2) Insert new client and associate them to their team(s); \n" +
            "3) Insert new volunteer and associate them with their team(s); \n" + 
            "4) Insert number of hours a volunteer worked for a team; \n" +
            "5) Insert new employee and associate them with their team(s); \n" + 
            "6) Insert an expense made by an employee; \n" +
            "7) Insert new organization and associate them with their team(s); \n" +
            "8) Insert new donor and enter their donations; \n" +
            "9) Insert new organization and enter their donations; \n" + 
            "10) Display the name and phone number of the doctor of a client; \n" +
            "11) Display the total expenses for each employee; \n" +
            "12) Display the volunteers that are on a team that support a client; \n" +
            "13) Display the names and contact info of clients that \n" + 
            "    are supported by teams sponsored by organizations with\n" +
            "    names that start with letters between B and K;\n" +
            "14) Display the name and total donation amount for all donors; \n" +
            "15) Display all teams founded before  a date; \n" +
            "16) Increase all employees salary by 10% that more than one team report to \n" +
            "17) Delete clients that don't have health insurance and have\n" +
            "    and importance level for transportation that is <5; \n" + 
            "18) Enter new teams from specified .txt file; \n" +
            "19) Send names and mailing addresses of people on the mialing list\n" +
            "    to a specified .txt file; \n" +
            "20) Exit";

    public static void main(String[] args) throws SQLException, FileNotFoundException {


        final Scanner sc = new Scanner(System.in); // Scanner is used to collect the user input
        String option = ""; // Initialize user option selection as nothing
        while (!option.equals("20")) { // Ask user for options until option 3 is selected
            System.out.println(PROMPT); // Print the available options
            option = sc.next(); // Read in the user option selection
            
            //Initialize variables for User Input
   
            String S1, S2, S3, S4, S5, S6, S7, S8, S9;
            String S10, S11, S12, S13, S14, S15, S16, S17, S18;
            
            int I1, I2, I3;
            
            long L1, L2;
                                 
            
            switch (option) { // Switch between different options
                case "1": //Insert new team
                    // Collect the new team data from the user
                    System.out.println("Team Name:");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of Team Name

                    System.out.println("Team Type:");
                    S2 = sc.nextLine(); // Read in user input of Team Type

                    System.out.println("Formation Date (YYYY-MM-DD):");
                    S3 = sc.nextLine(); // Read in user input of Formation Date
                                        
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    
                    String Query1 = "EXECUTE Query1 " +
                    						"@Name = '" + S1 + "', " +
                    						"@Type = '" + S2 + "', " +
                    						"@Date = '" + S3 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query1)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }

                    break;
                    
                case "2": //Insert new client and associate them to their team(s)
                    // Collect the new data from the user
                    System.out.println("Client Social Security Number:");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Client Social Security

                    System.out.println("Client Name:");
                    sc.nextLine(); 
                    S1 = sc.nextLine(); // Read in user input of Client Name (white-spaces allowed).

                    System.out.println("Client Date of Birth (YYYY-MM-DD):");
                    S2 = sc.nextLine(); // Read in user input of Clients Birthday
                                        
                    System.out.println("Client Race:");
                    S3 = sc.nextLine(); // Read in user input of Client's Race
                    
                    System.out.println("Client Gender:");
                    S4 = sc.nextLine(); // Read in user input of Client's Gender
                    
                    System.out.println("Client Profession:");
                    S5 = sc.nextLine(); // Read in user input of Client's profession
                    
                    System.out.println("Client Mailing Address:");
                    S6 = sc.nextLine(); // Read in user input of Client's mailing address
                    
                    System.out.println("Client Email:");
                    S7 = sc.nextLine(); // Read in user input of Clients Email
                    
                    System.out.println("Client's Home Phone Number (Enter NA if none):");
                    S8 = sc.nextLine(); // Read in user input of Client's home phone number
                    
                    System.out.println("Client's Work Phone Number (Enter NA if none):");
                    S9 = sc.nextLine(); // Read in user input of Client's work phone number
                    
                    System.out.println("Client's Cell Phone Number (Enter NA if none):");
                    S10 = sc.nextLine(); // Read in user input of Client's cell phone number
                    
                    System.out.println("On Mailing List? (Yes or No):");
                    S11 = sc.nextLine(); // Read in user input of mailing list status
                    
                    System.out.println("Client's Doctor's Name:");
                    S12 = sc.nextLine(); // Read in user input of Client's Doctor's name
                    
                    System.out.println("Client's Doctor's Number:");
                    S13 = sc.nextLine(); // Read in user input of Client's Doctor's number
                    
                    System.out.println("Client's Attorney Name:");
                    S14 = sc.nextLine(); // Read in user input of Client's Attorney's name
                    
                    System.out.println("Client's Attorney Number:");
                    S15 = sc.nextLine(); // Read in user input of Client's Attorney's number
                    
                    System.out.println("Client's Assignment Date (YYYY-MM-DD):");
                    S16 = sc.nextLine(); // Read in user input of Client's assignment date
                    
                    System.out.println("Connecting to the database...");
                	// Get a database connection and prepare a query statement
                
                	String Query2a = "EXECUTE Query2a " +
                						"@SS = " + I1 + ", " + "@Name = '" + S1 + "', " +
                						"@DoB = '" + S2 + "', " + "@Race = '" + S3 + "', " +
                                		"@Gender = '" + S4 + "', " + "@Prof = '" + S5 + "', " +
                                        "@MAdd = '" + S6 + "', " + "@Email = '" + S7 + "', " +
                                        "@Home = '" + S8 + "', " + "@Work = '" + S9 + "', " +
                                        "@Cell = '" + S10 + "', " + "@Mail = '" + S11 + "', " +
                                        "@DName = '" + S12 + "', " + "@DNum = '" + S13 + "', " +
                                        "@AName = '" + S14 + "', " + "@ANum = '" + S15 + "', " +
                                        "@Date = '" + S16 + "'; ";
                	
                	try (final Connection connection = DriverManager.getConnection(URL)) {
                		try (final PreparedStatement statement = connection.prepareStatement(Query2a)) { 
                    	
                			System.out.println("Dispatching the query...");
                        
                			// Execute the populated query
                			final int rows_inserted = statement.executeUpdate();
                			System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                		}
                	}
                	System.out.println("How many teams are the client associated with?");
                    I3 = sc.nextInt();
                    sc.nextLine();
                    
                    for(int n = 0; n < I3; n++) {
                    	System.out.println("Team Name:");
                    	S17 = sc.nextLine(); // Read in user input of team name
                    
                    	System.out.println("Active Status (Yes or No):");
                    	S18 = sc.nextLine(); // Read in user input of active team status
                    
                    	System.out.println("Connecting to the database...");
                    	// Get a database connection and prepare a query statement
                    
                    	String Query2b = "EXECUTE Query2b " +
                    						"@SS = " + I1 + ", " + "@TName = '" + S17 + "', " +
                    						"@Active = '" + S18 + "';";
                    	
                    	System.out.print(Query2b);
                    	try (final Connection connection = DriverManager.getConnection(URL)) {
                    		try (final PreparedStatement statement = connection.prepareStatement(Query2b)) { 
                        	
                    			System.out.println("Dispatching the query...");
                            
                    			// Actually execute the populated query
                    			final int rows_inserted = statement.executeUpdate();
                    			System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                    		}
                    	}
                    }
                    
                    break;
                    
                case "3": // Insert new volunteer and associate them with their team(s)
                    // Collect the new data from the user
                    System.out.println("Volunteer Social Security Number:");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Volunteer Social Security

                    System.out.println("Volunteer Name:");
                    sc.nextLine(); 
                    S1 = sc.nextLine(); // Read in user input of Volunteer Name (white-spaces allowed).
                    
                    System.out.println("Volunteer Date of Birth (YYYY-MM-DD):");
                    S2 = sc.nextLine(); // Read in user input of Volunteer's Birthday
                                        
                    System.out.println("Volunteer Race:");
                    S3 = sc.nextLine(); // Read in user input of Volunteer's Race
                    
                    System.out.println("Volunteer Gender:");
                    S4 = sc.nextLine(); // Read in user input of Volunteer's Gender
                    
                    System.out.println("Volunteer Profession:");
                    S5 = sc.nextLine(); // Read in user input of Volunteer's profession
                    
                    System.out.println("Volunteer Mailing Address:");
                    S6 = sc.nextLine(); // Read in user input of Volunteer's mailing address
                    
                    System.out.println("Volunteer Email:");
                    S7 = sc.nextLine(); // Read in user input of Volunteers Email
                    
                    System.out.println("Volunteer's Home Phone Number (Enter NA if none):");
                    S8 = sc.nextLine(); // Read in user input of Volunteer's home phone number
                    
                    System.out.println("Volunteer's Work Phone Number (Enter NA if none):");
                    S9 = sc.nextLine(); // Read in user input of Volunteer's work phone number
                    
                    System.out.println("Volunteer's Cell Phone Number (Enter NA if none):");
                    S10 = sc.nextLine(); // Read in user input of Volunteer's cell phone number
                    
                    System.out.println("On Mailing List? (Yes or No):");
                    S11 = sc.nextLine(); // Read in user input of mailing list status
                    
                    System.out.println("Volunteer's Join Date (YYYY-MM-DD):");
                    S12 = sc.nextLine(); // Read in user input of Volunteer's assignment date
                    
                    System.out.println("Volunteer's Most Recent Training Course Date (YYYY-MM-DD):");
                    S13 = sc.nextLine(); // Read in user input of Volunteer's assignment date
                    
                    System.out.println("Volunteer's Most Recent Training Course Location:");
                    S14 = sc.nextLine(); // Read in user input of Volunteer's assignment date
                    
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    
                    String Query3a = "EXECUTE Query3a " +
                    						"@SS = " + I1 + ", " + "@Name = '" + S1 + "', " +
                    						"@DoB = '" + S2 + "'," + "@Race = '" + S3 + "'," +
                                    		"@Gender = '" + S4 + "'," + "@Prof = '" + S5 + "'," +
                                            "@MAdd = '" + S6 + "'," + "@Email = '" + S7 + "'," +
                                            "@Home = '" + S8 + "'," + "@Work = '" + S9 + "'," +
                                            "@Cell = '" + S10 + "'," + "@Mail = '" + S11 + "'," +
                                            "@Join = '" + S12 + "'," + "@CourseD = '" + S13 + "'," +
                                            "@CourseL = '" + S14 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query3a)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    System.out.println("How many teams are the client associated with?");
                    I2 = sc.nextInt();
                    sc.nextLine();
                    
                    for(int n = 0; n < I2; n++) {
                    	System.out.println("Team Name:");
                    	S15 = sc.nextLine(); // Read in user input of team name
                    
                    	System.out.println("Active Status (Yes or No):");
                    	S16 = sc.nextLine(); // Read in user input of active team status
                    
                    	System.out.println("Connecting to the database...");
                    	// Get a database connection and prepare a query statement
                    
                    	String Query3b = "EXECUTE Query3b " +
                    						"@SS = " + I1 + ", " + "@TName = '" + S15 + "'," +
                                            "@Active = '" + S16 + "';";
                    
                    	try (final Connection connection = DriverManager.getConnection(URL)) {
                        	try (final PreparedStatement statement = connection.prepareStatement(Query3b)) { 
                        	
                            	System.out.println("Dispatching the query...");
                            
                            	// Actually execute the populated query
                            	final int rows_inserted = statement.executeUpdate();
                            	System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        	}
                    	}
                    }
                    break;
                  
                case "4": // Insert number of hours a volunteer worked for a team
                    // Collect the new data from the user
                    System.out.println("Volunteer Social Security Number:");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Volunteer Social Security

                    System.out.println("Team Name:");
                    sc.nextLine(); 
                    S1 = sc.nextLine(); // Read in user input of Team Name.
                    
                    System.out.println("Month:");
                    S2 = sc.nextLine(); // Read in user input of Month 
                                        
                    System.out.println("Hours Worked:");
                    S3 = sc.nextLine(); // Read in user input of Hours Worked
                    
                    
                    String Query4 = "EXECUTE Query4 " +
                    						"@SS = " + I1 + ", " + "@Name = '" + S1 + "', " +
                    						"@Month = '" + S2 + "'," + "@Hrs = '" + S3 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query4)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }

                    break;
                
                case "5": // Insert new employee and associate them with their team(s) 
                    // Collect the new data from the user
                    System.out.println("Employee Social Security Number:");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Employee's Social Security

                    System.out.println("Employee Name:");
                    sc.nextLine(); 
                    S1 = sc.nextLine(); // Read in user input of Employee's Name (white-spaces allowed).
                    
                    System.out.println("Employee Date of Birth (YYYY-MM-DD):");
                    S2 = sc.nextLine(); // Read in user input of Employee's Birthday
                                        
                    System.out.println("Employee Race:");
                    S3 = sc.nextLine(); // Read in user input of Employee's Race
                    
                    System.out.println("Employee Gender:");
                    S4 = sc.nextLine(); // Read in user input of Employee's Gender
                    
                    System.out.println("Employee Profession:");
                    S5 = sc.nextLine(); // Read in user input of Employee's profession
                    
                    System.out.println("Employee Mailing Address:");
                    S6 = sc.nextLine(); // Read in user input of Employee's mailing address
                    
                    System.out.println("Employee Email:");
                    S7 = sc.nextLine(); // Read in user input of Employee's Email
                    
                    System.out.println("Employee's Home Phone Number (Enter NA if none):");
                    S8 = sc.nextLine(); // Read in user input of Employee's home phone number
                    
                    System.out.println("Employee's Work Phone Number (Enter NA if none):");
                    S9 = sc.nextLine(); // Read in user input of Employee's work phone number
                    
                    System.out.println("Employee's Cell Phone Number (Enter NA if none):");
                    S10 = sc.nextLine(); // Read in user input of Employee's cell phone number
                    
                    System.out.println("On Mailing List? (Yes or No):");
                    S11 = sc.nextLine(); // Read in user input of mailing list status
                    
                    System.out.println("Employee's Salary:");
                    I2 = sc.nextInt(); // Read in user input of Employee's salary
                    
                    System.out.println("Employee's Marriage Status:");
                    sc.nextLine();
                    S12 = sc.nextLine(); // Read in user input of Employee's marriage status
                    
                    System.out.println("Employee's Hire Date (YYYY-MM-DD):");
                    S13 = sc.nextLine(); // Read in user input of Employee's hire date
                                       
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    
                    String Query5a = "EXECUTE Query5a " +
                    						"@SS = " + I1 + ", " + "@Name = '" + S1 + "', " +
                    						"@DoB = '" + S2 + "'," + "@Race = '" + S3 + "'," +
                                    		"@Gender = '" + S4 + "'," + "@Prof = '" + S5 + "'," +
                                            "@MAdd = '" + S6 + "'," + "@Email = '" + S7 + "'," +
                                            "@Home = '" + S8 + "'," + "@Work = '" + S9 + "'," +
                                            "@Cell = '" + S10 + "'," + "@Mail = '" + S11 + "'," +
                                            "@Sal = " + I2 + "," + "@Mar = '" + S12 + "'," +
                                            "@HDate = '" + S13 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query5a)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }

                    System.out.println("How many teams are the employee associated with?");
                    I3 = sc.nextInt();
                    sc.nextLine();
                    
                    for(int n = 0; n < I3; n++) {
                    	System.out.println("Team's Report Date (YYYY-MM-DD):");
                    	S14 = sc.nextLine(); // Read in user input of team's report date
                    
                    	System.out.println("Team Name:");
                    	S15 = sc.nextLine(); // Read in user input of team name
                    
                    	System.out.println("Report Description:");
                    	S16 = sc.nextLine(); // Read in user input of report description
                    
                    	System.out.println("Connecting to the database...");
                    	// Get a database connection and prepare a query statement
                    
                    	String Query5b = "EXECUTE Query5b " +
                    						"@SS = " + I1 + ", " + "@Rdate = '" + S14 + "'," +
                                            "@TName = '" + S15 + "'," + "@RDes = '" + S16 + "';";
                    
                    	try (final Connection connection = DriverManager.getConnection(URL)) {
                    		try (final PreparedStatement statement = connection.prepareStatement(Query5b)) { 
                        	
                    			System.out.println("Dispatching the query...");
                            
                    			// Actually execute the populated query
                    			final int rows_inserted = statement.executeUpdate();
                    			System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                    		}
                    	}
                    }
                    break;  
                    
                   
                case "6": // Insert an expense made by an employee
                    // Collect the new data from the user
                    System.out.println("Employee Social Security Number:");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Employee's Social Security

                    System.out.println("Expense Date (YYYY-MM-DD):");
                    sc.nextLine(); 
                    S1 = sc.nextLine(); // Read in user input of Expense date.
                    
                    System.out.println("Expense Amount:");
                    I2 = sc.nextInt(); // Read in user input of Expense amount 
                                        
                    System.out.println("Expense Description:");
                    sc.nextLine();
                    S2 = sc.nextLine(); // Read in user input of expense description
                    
                    
                    String Query6 = "EXECUTE Query6 " +
                    						"@SS = " + I1 + ", " + "@Date = '" + S1 + "', " +
                    						"@Amount = '" + I2 + "'," + "@Des = '" + S2 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query6)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }

                    break;
                 
                case "7": // Insert new organization and associate them with their team(s)
                    // Collect the new data from the user
                    System.out.println("Organization Name:");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of organization name

                    System.out.println("Mailing Address");
                    S2 = sc.nextLine(); // Read in user input of organization's mailing address.
                    
                    System.out.println("Phone Number:");
                    S3 = sc.nextLine(); // Read in user input of organization phone number
                                        
                    System.out.println("Contact Person:");
                    S4 = sc.nextLine(); // Read in user input of organization contact person
                    
                    System.out.println("Organization Type:");                   
                    S5 = sc.nextLine(); // Read in the user input of organization type

                    System.out.println("Size:"); 
                    I1 = sc.nextInt(); // Read in user input of organization size
                    
                    System.out.println("Website:");
                    sc.nextLine(); 
                    S6 = sc.nextLine(); // Read in user input of organization website
                    
                    System.out.println("Religious Affiliation (Enter NA if none):");
                    S7 = sc.nextLine(); // Read in user input of organizations religious affiliation
                    
                    System.out.println("Anonymous (Yes or No):");
                    S8 = sc.nextLine(); // Read in user input of anonymous status
                    
                    String Query7a = "EXECUTE Query7a " +
                    						"@OName = '" + S1 + "', " + "@Mail = '" + S2 + "', " +
                    						"@Phone = '" + S3 + "', " + "@Cont = '" + S4 + "', " +
                    						"@Type = '" + S5 + "', " + "@Size = " + I1 + "," +
                    						"@Web = '" + S6 + "', " + "@Aff = '" + S7 + "', " +
                    						"@Anon = '" + S8 + "';";
                    
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query7a)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("How many teams does the organization sponsor?");
                    I2 = sc.nextInt();
                    sc.nextLine();
                    
                    for(int n = 0; n < I2; n++) {
                    	System.out.println("Team Name:");
                    	S9 = sc.nextLine(); // Read in user input of team name
                    
                    	String Query7b = "EXECUTE Query7b " +
                    						"@OName = '" + S1 + "', " + "@TName = '" + S9 + "';";
                    
                    
                    	try (final Connection connection = DriverManager.getConnection(URL)) {
                    		try (final PreparedStatement statement = connection.prepareStatement(Query7b)) { 
                        	
                    			System.out.println("Dispatching the query...");
                            
                    			// Actually execute the populated query
                    			final int rows_inserted = statement.executeUpdate();
                    			System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                    		}
                    	}
                    }

                    break;  
                   
                case "8": // Insert new donor and enter their donations
                    // Collect the new data from the user
                    System.out.println("Donor Social Security Number:");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Donor's Social Security

                    System.out.println("Donor Name:");
                    sc.nextLine(); 
                    S1 = sc.nextLine(); // Read in user input of Donor's Name (white-spaces allowed).
                    
                    System.out.println("Donor Date of Birth (YYYY-MM-DD):");
                    S2 = sc.nextLine(); // Read in user input of Donor's Birthday
                                        
                    System.out.println("Donor Race:");
                    S3 = sc.nextLine(); // Read in user input of Donor's Race
                    
                    System.out.println("Donor Gender:");
                    S4 = sc.nextLine(); // Read in user input of Donor's Gender
                    
                    System.out.println("Donor Profession:");
                    S5 = sc.nextLine(); // Read in user input of Donor's profession
                    
                    System.out.println("Donor Mailing Address:");
                    S6 = sc.nextLine(); // Read in user input of Donor's mailing address
                    
                    System.out.println("Donor Email:");
                    S7 = sc.nextLine(); // Read in user input of Donor's Email
                    
                    System.out.println("Donor's Home Phone Number (Enter NA if none):");
                    S8 = sc.nextLine(); // Read in user input of Donor's home phone number
                    
                    System.out.println("Donor's Work Phone Number (Enter NA if none):");
                    S9 = sc.nextLine(); // Read in user input of Donor's work phone number
                    
                    System.out.println("Donor's Cell Phone Number (Enter NA if none):");
                    S10 = sc.nextLine(); // Read in user input of Donor's cell phone number
                    
                    System.out.println("On Mailing List? (Yes or No):");
                    S11 = sc.nextLine(); // Read in user input of mailing list status
                    
                    System.out.println("Is Anonymous (Yes or No):");
                    S12 = sc.nextLine(); // Read in user input of Donor's anonymous status
                    
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    
                    String Query8a = "EXECUTE Query8a " +
                    						"@SS = " + I1 + ", " + "@Name = '" + S1 + "', " +
                    						"@DoB = '" + S2 + "'," + "@Race = '" + S3 + "'," +
                                    		"@Gender = '" + S4 + "'," + "@Prof = '" + S5 + "'," +
                                            "@MAdd = '" + S6 + "'," + "@Email = '" + S7 + "'," +
                                            "@Home = '" + S8 + "'," + "@Work = '" + S9 + "'," +
                                            "@Cell = '" + S10 + "'," + "@Mail = '" + S11 + "'," +
                                            "@Anon = '" + S12 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query8a)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("How many donations did the donor make?");
                    I3 = sc.nextInt();
                    sc.nextLine();
                    
                    for(int n = 0; n < I3; n++) {
                    	System.out.println("Donation Date:");
                    	S13 = sc.nextLine(); // Read in user input of Donor's donation date
                    
                    	System.out.println("Donation Amount:");
                    	I2 = sc.nextInt(); // Read in user input of Donor's donation amount
                    
                    	System.out.println("Donation Type:");
                    	sc.nextLine();
                    	S14 = sc.nextLine(); // Read in user input of Donor's donation type
                    
                    	System.out.println("Campaign Name (NA if none):");
                    	S15 = sc.nextLine(); // Read in user input of campaign name
                    
                    	System.out.println("Check Number (Enter 0 if none):");
                    	L1 = sc.nextLong(); // Read in user input of check number
                    
                    	System.out.println("Card Number (Enter 0 if none):");
                    	L2 = sc.nextLong(); // Read in user input of card number
                    
                    	System.out.println("Card Type (Enter 0 if none):");
                    	sc.nextLine();
                    	S16 = sc.nextLine(); // Read in user input of card type
                    
                    	System.out.println("Experiation Date (MM/YYYY):");
                    	S17 = sc.nextLine(); // Read in user input of card expiration date
                    
                    	System.out.println("Connecting to the database...");
                    	// Get a database connection and prepare a query statement
                    
                    	String Query8b = "EXECUTE Query8b " +
                    						"@SS = " + I1 + ", " + "@Date = '" + S13 + "'," +
                                            "@Amount = " + I2 + "," + "@Type = '" + S14 + "'," +
                                            "@CName = '" + S15 + "'," + "@CkNum = " + L1 + "," +
                                            "@CNum = '" + L2 + "'," + "@CType = '" + S16 + "'," +
                                            "@EDate = '" + S17 + "';";
                    
                    	try (final Connection connection = DriverManager.getConnection(URL)) {
                    		try (final PreparedStatement statement = connection.prepareStatement(Query8b)) { 
                        	
                    			System.out.println("Dispatching the query...");
                            
                    			// Actually execute the populated query
                    			final int rows_inserted = statement.executeUpdate();
                    			System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                    		}
                    	}
                    }
                    break;      


                case "9": // Insert new organization and enter their donations
                    // Collect the new data from the user
                    System.out.println("Organization Name:");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of Organization name

                    System.out.println("Mailing Address");
                    S2 = sc.nextLine(); // Read in user input of Organization mailing address.
                    
                    System.out.println("Phone Number:");
                    S3 = sc.nextLine(); // Read in user input of organization phone number 
                                        
                    System.out.println("Contact Person:");
                    S4 = sc.nextLine(); // Read in user input of organization contact person
                    
                    System.out.println("Organization Type:");                   
                    S5 = sc.nextLine(); // Read in the user input of organization type

                    System.out.println("Size:"); 
                    I1 = sc.nextInt(); // Read in user input of organization size.
                    
                    System.out.println("Website:");
                    sc.nextLine(); 
                    S6 = sc.nextLine(); // Read in user input of organization website
                    
                    System.out.println("Religious Affiliation (Enter NA if none):");
                    S7 = sc.nextLine(); // Read in user input of organization religious affiliation
                    
                    System.out.println("Anonymous (Yes or No):");
                    S8 = sc.nextLine(); // Read in user input of anonymous status
                   
                    System.out.println("Connecting to the database...");
                    // Get a database connection and prepare a query statement
                    
                    String Query9a = "EXECUTE Query9a " +
                    						"@OName = '" + S1 + "', " + "@Mail = '" + S2 + "', " +
                    						"@Phone = '" + S3 + "', " + "@Cont = '" + S4 + "', " +
                                    		"@Type = '" + S5 + "', " + "@Size = " + I1 + ", " +
                                            "@Web = '" + S6 + "', " + "@Aff = '" + S7 + "', " +
                                            "@Anon = '" + S8 + "';";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query9a)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            // Actually execute the populated query
                            final int rows_inserted = statement.executeUpdate();
                            System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                        }
                    }
                    
                    System.out.println("How many donations did the organization make?");
                    I3 = sc.nextInt();
                    sc.nextLine();
                    
                    for(int n = 0; n < I3; n++) {
                    	System.out.println("Donation Date:");
                    	S9 = sc.nextLine(); // Read in user input of Organization's donation date
                    
                    	System.out.println("Donation Amount:");
                    	I2 = sc.nextInt(); // Read in user input of Organization's donation amount
                    
                    	System.out.println("Donation Type:");
                    	sc.nextLine();
                    	S10 = sc.nextLine(); // Read in user input of Organization's donation type
                    
                    	System.out.println("Campaign Name:");
                    	S11 = sc.nextLine(); // Read in user input of campaign name
                    
                    	System.out.println("Check Number (Enter 0 if none):");
                    	L1 = sc.nextLong(); // Read in user input of check number
                    
                    	System.out.println("Card Number (Enter 0 if none):");
                    	L2 = sc.nextLong(); // Read in user input of card number
                    
                    	System.out.println("Card Type (Enter NA if none):");
                    	sc.nextLine();
                    	S12 = sc.nextLine(); // Read in user input of card type
                    
                    	System.out.println("Experiation Date (MM/YYYY):");
                    	S13 = sc.nextLine(); // Read in user input of card expiration date
                    
                    	System.out.println("Connecting to the database...");
                    	// Get a database connection and prepare a query statement
                    
                    	String Query9b = "EXECUTE Query9b " +
                    						"@OName = '" + S1 + "'," + "@Date = '" + S9 + "'," +
                                            "@Amount = " + I2 + "," + "@DType = '" + S10 + "'," +
                                            "@CName = '" + S11 + "'," + "@CkNum = " + L1 + "," +
                                            "@CNum = " + L2 + "," + "@CType = '" + S12 + "'," +
                                            "@EDate = '" + S13 + "';";
                    
                    	try (final Connection connection = DriverManager.getConnection(URL)) {
                    		try (final PreparedStatement statement = connection.prepareStatement(Query9b)) { 
                        	
                    			System.out.println("Dispatching the query...");
                            
                    			// Actually execute the populated query
                    			final int rows_inserted = statement.executeUpdate();
                    			System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                    		}
                    	}
                    }
                    break;
                    
                case "10": // Display the name and phone number of the doctor of a client
                	// Collect the new data from the user
                    System.out.println("Client Social Security Number (No -'s):");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Volunteer Social Security

                	String Query10 = "EXECUTE Query10 @SS =" + I1 + ";";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query10)) {

                                System.out.println("Doctor Name | Doctor Number");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    System.out.println(String.format("%s | %s  ",
                                        resultSet.getString(1),
                                        resultSet.getString(2)));
                                }
                        }
                    }
                    break;
                    
                case "11": // Display the name and phone number of the doctor of a client
                	// Collect the new data from the user
                    System.out.println("Start Date (YYYY-MM-DD):");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of range start state

                    System.out.println("End Date (YYYY-MM-DD):");                  
                    S2 = sc.nextLine(); // Read in the user input of range end date

                	String Query11 = "EXECUTE Query11 @Start = '" + S1 + "'," +
                					"@End = '" + S2 + "';";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query11)) {

                                System.out.println("Social Security | Total Expense Amount");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    System.out.println(String.format("%s | %s  ",
                                        resultSet.getString(1),
                                        resultSet.getString(2)));
                                }
                        }
                    }
                    break;
                    
                
                case "12": // Display the volunteers that are on a team that support a client
                	// Collect the new data from the user
                    System.out.println("Client Social Security(No -'s):");
                    sc.nextLine();                    
                    I1 = sc.nextInt(); // Read in the user input of Client Social Security

                	String Query12 = "EXECUTE Query12 @Client = '" + I1 + "';";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query12)) {

                                System.out.println("Social Security | Name");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    System.out.println(String.format("%s | %s  ",
                                        resultSet.getString(1),
                                        resultSet.getString(2)));
                                }
                        }
                    }
                    break;
                    
                case "13": // Display the names and contact info of clients that are supported by teams sponsored 
							// by organizations with names that start with letters between B and K

                	// Collect the new data from the user
                    

                	String Query13 = "EXECUTE Query13 ";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query13)) {

                                System.out.println("Name | Address | Email | Home | Work | Cell");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    System.out.println(String.format("%s | %s | %s | %s | %s | %s ",
                                        resultSet.getString(2),
                                        resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getString(6),
                                        resultSet.getString(7)));
                                }
                        }
                    }
                    break;
                 
                    
                case "14": // Display the name and total donation amount for all donors
                	// Collect the new data from the user
                    

                	String Query14 = "EXECUTE Query14 ";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query14)) {

                                System.out.println("Name | Total Donations | Anonymous?");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    System.out.println(String.format("%s | %s | %s",
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3)));
                                }
                        }
                    }
                    break;
                    
                case "15": // Display all teams founded before a date
                	// Collect the new data from the user
                    System.out.println("Date (YYYY-MM-DD):");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of Date

                	String Query15 = "EXECUTE Query15 @Date = '" + S1 + "';";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query15)) {

                                System.out.println("Team Name");

                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    System.out.println(String.format("%s  ",
                                        resultSet.getString(1)));
                                }
                        }
                    }
                    break;
                    
                    
                case "16": // Increase all employees salary by 10% that more than one team report to 
                    String Query16 = "EXECUTE Query16;";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query16)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            statement.executeUpdate();
                            
                        }
                    }

                    break; 
                
                case "17": // Delete clients that don't have health insurance and have
							// and importance level for transportation that is <5

                    String Query17 = "EXECUTE Query17;";
                    
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        try (final PreparedStatement statement = connection.prepareStatement(Query17)) { 
                        	
                            System.out.println("Dispatching the query...");
                            
                            statement.executeUpdate();
                        }
                    }

                    break;    
                
                case "18": // Enter new teams from specified .txt file
                	// Collect the new data from the user
                    System.out.println("File Name (ex. file.txt):");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of file name
                    try {                        			
              	      File inputFile = new File(S1);
              	      Scanner ReadFile = new Scanner(inputFile);
              	      while (ReadFile.hasNextLine()) {
              	        String TeamInfo = ReadFile.nextLine();
              	        String delims = "[,]";
              	        String[] Info = TeamInfo.split(delims);
              	        S1 = Info[0];
              	        S2 = Info[1];
              	        S3 = Info[2];
              	        String Query18 = "EXECUTE Query18 @Name = '" + S1 + "', " +
              	        					"@Type = '" + S2 + "', " + "@Date = '" + S3 + "';";
              	        System.out.print(Query18);
              	        try (final Connection connection = DriverManager.getConnection(URL)) {
                          try (final PreparedStatement statement = connection.prepareStatement(Query18)) { 
                          	
                              System.out.println("Dispatching the query...");
                              
                              // Actually execute the populated query
                              final int rows_inserted = statement.executeUpdate();
                              System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
                          }
              	        }
                          
              	      }
              	    ReadFile.close();  
              	      
              	    } catch (FileNotFoundException e) {
              	      System.out.println("An error occurred.");
              	      e.printStackTrace();
              	    }
                    
                    

                    break;    
                    
                case "19": // Send names and mailing addresses of people on the mialing list
							// to a specified .txt file

                	// Collect the new data from the user
                    System.out.println("File Name (ex. file.txt):");
                    sc.nextLine();                    
                    S1 = sc.nextLine(); // Read in the user input of file name

                	String Query19 = "EXECUTE Query19;";
                	
                	System.out.println("Connecting to the database...");
                    // Get the database connection, create statement and execute it right away, as no user input need be collected
                    try (final Connection connection = DriverManager.getConnection(URL)) {
                        System.out.println("Dispatching the query...");
                        try (
                            final Statement statement = connection.createStatement();
                            final ResultSet resultSet = statement.executeQuery(Query19)) {

                                System.out.println("Team Name");

                                FileOutputStream FOS = new FileOutputStream(S1);
                                PrintWriter PW = new PrintWriter(FOS);
                                // Unpack the tuples returned by the database and print them out to the user
                                while (resultSet.next()) {
                                    PW.println(String.format("%s %s ",
                                        resultSet.getString(1), 
                                        resultSet.getString(2)));
                                }
                                PW.close();
                        }
                    }
                    break;
                    
                case "20": // Exit
                	System.out.println("Leaving Program.....See Yuh!");
                    break;
                default: // Unrecognized option, re-prompt the user for the correct one
                    System.out.println(String.format(
                        "Unrecognized option: %s\n" + 
                        "Please try again!", 
                        option));
                    break;
            }
        }

        sc.close(); // Close the scanner before exiting the application
    }
}