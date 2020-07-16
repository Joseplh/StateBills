import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
//Developed by Joseph Maxwell for 
//consolidating the components into a single main and then attempting to download, compile and upload the database.
//
public class Main {
	//The SQL Server JDBC Driver is in 
	//C:\Program Files\Microsoft JDBC Driver 6.0 for SQL Server\sqljdbc_6.0\enu\auth\x64
	private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  
	//The JDBC connection URL which allows for Windows authentication is defined below.
	private static final String jdbcURL = "jdbc:sqlserver://localhost;databasename=TestingDB;integratedSecurity=true;";
	//To make Windows authenticaion work we have to set the path to sqljdbc_auth.dll at the command line
	public static void main(String[] args) {
		//Stage 1: Download the daily .csv file
		//Downloader();
		//System.out.print(currentDate());
		
		//Stage 2: push new data to database
		//CSVBuilder("inputFile.csv");
		insertSQL();
		

	}
	public static void Downloader() {
		try (BufferedInputStream in = new BufferedInputStream(new URL("https://nebraskalegislature.gov/bills/search_by_date.php?SessionDay="+currentDate()+"&print=csv").openStream());
			FileOutputStream fileOutputStream = new FileOutputStream("download.csv")) {
		    byte dataBuffer[] = new byte[1024];
		    int bytesRead;
		    System.out.println("Downloading...");
		    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
		        fileOutputStream.write(dataBuffer, 0, bytesRead);
		    }
		} catch (IOException e) {
		    // handle exception
		}
	}
	public static String currentDate() {
		return "2020";
	}
	public static void insertSQL() {
		System.out.println("Program started");
	    try
	    {
	       Class.forName(jdbcDriver).newInstance();
	       System.out.println("JDBC driver loaded");
	    }
	    catch (Exception err)
	    {
	       System.err.println("Error loading JDBC driver");
	       err.printStackTrace(System.err);
	       System.exit(0);
	    }
	    
	    Connection databaseConnection= null;
	    try
	    {
	      //Connect to the database
	      databaseConnection = DriverManager.getConnection(jdbcURL);
	      System.out.println("Connected to the database");
	    }
	    catch (SQLException err)
	    {
	       System.err.println("Error connecting to the database");
	       err.printStackTrace(System.err);
	       System.exit(0);
	    }
	    
	    try
	    {
	      //declare the statement object
	      Statement sqlStatement = databaseConnection.createStatement();
	 
	      //Build the command string
	      String commandString="insert into people values";
	      commandString+="('Joseph','Maxwell','6467 Pierce St.',1000.57)";

	      //print the command string to the screen
	      System.out.println("\nCommand string:");
	      System.out.println(commandString);
	      
	      //execute the command using the execute method
	      sqlStatement.execute(commandString);
	      
	      System.out.println("Closing database connection");

	      //close the database connection
	      databaseConnection.close();
	    }
	    catch (SQLException err)
	    {
	       System.err.println("SQL Error");
	       err.printStackTrace(System.err);
	       System.exit(0);
	    }
	    System.out.println("Program finished");
	}
	public static void CSVBuilder(String CSVFile) {//this method takes in a .csv file and parses through the data within
		//It is specifically designed for the nebraska state legislature .csv file and currently only prints the contents.
		//load .csv file into memory
		try {
			File file = new File(CSVFile);
		
			BufferedReader br;
		
			br = new BufferedReader(new FileReader(file));
		
			//read .csv file and parse into objBill list
			String fileLine = br.readLine();//initialized with first line which is only the titles, usless data
			while(((fileLine) = br.readLine()) != null){//looping through file line by line as a single string
				boolean ignoreComma = false;
				String doc = "";
				String intro = "";
				String stat = "";
				String desc = "";
				String IDst = "";//temporary holder for ID as it is a string
				int ID = -1;
				System.out.println(fileLine);
				int stage = 0;
				for(int x = 0; x < fileLine.length(); x++) {
					switch(stage) {
						case 0://parse for doc string
							switch(fileLine.charAt(x)) {
								case '"'://used to determine if comma in string
									if(ignoreComma)
										ignoreComma = false;
									else
										ignoreComma = true;
									break;
								case ',':
									if(ignoreComma)
										doc += ',';
									else
										stage = 1;
									break;
								default:
									doc += fileLine.charAt(x);									
							}
							break;
						case 1://parse for intro string
							switch(fileLine.charAt(x)) {
							case '"'://used to determine if comma in string
								if(ignoreComma)
									ignoreComma = false;
								else
									ignoreComma = true;
								break;
							case ',':
								if(ignoreComma)
									intro += 'c';
								else
									stage = 2;
								break;
							default:
								intro += fileLine.charAt(x);									
						}
							break;
						case 2://parse for stat string
							switch(fileLine.charAt(x)) {
								case '"'://used to determine if comma in string
									if(ignoreComma)
										ignoreComma = false;
									else
										ignoreComma = true;
									break;
								case ',':
									if(ignoreComma)
										stat += 'c';
									else
										stage = 3;
									break;
								default:
									stat += fileLine.charAt(x);									
							}
							break;
						case 3://parse for desc string
							switch(fileLine.charAt(x)) {
								case '"'://used to determine if comma in string
									if(ignoreComma)
										ignoreComma = false;
									else
										ignoreComma = true;
									break;
								case ',':
									if(ignoreComma)
										desc += 'c';
									else
										stage = 4;
									break;
								default:
									desc += fileLine.charAt(x);									
							}
							break;
						case 4://parse for IDst as a string
							switch(fileLine.charAt(x)) {
								case '"'://used to determine if comma in string
									if(ignoreComma)
										ignoreComma = false;
									else
										ignoreComma = true;
									break;
								case ',':
									if(ignoreComma)
										IDst += 'c';
									else
										stage = 5;
									break;
								default:
									IDst += fileLine.charAt(x);									
							}
							break;
						default:
							System.out.println("Should not Happen 0x001");
					}
				}
				ID = Integer.parseInt(IDst);
				System.out.println(doc+", "+intro+", "+stat+", "+desc+", "+ID);
				/*This section takes the parsed information and inserts to database.*/
				
				
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
