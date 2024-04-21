package Infath_DataBase;

import com.shaft.db.DatabaseActions;
import com.shaft.driver.SHAFT;

public class Prep_DataBase {

    private SHAFT.DB dbDriver;
    public String DataBase_Name = "Outsystems_Eservices"; //sa//
    public String DataBase_Server = "172.20.24.8";
    public String DataBase_Port = "3433";
    public String DataBase_UserName = "sa";
    public String DataBase_Password = "abc@1234";
//    public String DataBase_Driver = "com.mysql.cj.jdbc.Driver";
//    public String DataBase_URL = "jdbc:mysql://localhost:3306/infath";

    //**************************************//Construct the database driver and connect to the database
//    public Prep_DataBase(SHAFT.DB dbDriver) {
//        this.dbDriver = dbDriver;
//    }


    //Function to connect to Prep_DataBase Using SHAFT Engine framework
     public String getFromDB(){
        SHAFT.DB dbDriver;
        dbDriver = new SHAFT.DB(DatabaseActions.DatabaseType.SQL_SERVER,
                DataBase_Server, DataBase_Port, DataBase_Name, DataBase_UserName, DataBase_Password);

                dbDriver.executeSelectQuery("select * from OSUSR_D5W_INHERITANCE_REQUEST2 inh\n" +
                        "join OSUSR_D5W_INHERITANCE_REQUEST_SUMMARY2 s on s.inheritance_id = inh.id\n" +
                        "where inh.unique_id = 'be96e605-5865-4cdc-93b8-3a5bd6d028e6'");
        return dbDriver.getColumn("ERP_REQUEST_ID");
    }




//    public String Connect_To_DB() {
//
//        return String.valueOf(dbDriver = new SHAFT.DB(DatabaseActions.DatabaseType.SQL_SERVER,
//                DataBase_Server, DataBase_Port, DataBase_Name, DataBase_UserName, DataBase_Password));
//    }


//    // Function to Execute the SQL statement or execute query using the specified parameters
//    public String Execute_SQL_Statement(String SQL_Statement){
//        //return the execution query result into a variable
//        dbDriver.executeSelectQuery(SQL_Statement);
//        return dbDriver.getColumn("ERP_REQUEST_ID");
//    }

}
