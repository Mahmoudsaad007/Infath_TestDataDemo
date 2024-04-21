import Infath_DataBase.Prep_DataBase;
import com.shaft.db.DatabaseActions;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Access_DataBase {

//    @BeforeClass
//    public void BeforeClass() {
////        SHAFT.DB dbDriver = new SHAFT.DB(prepDataBase.Connect_To_DB());
//        Prep_DataBase prepDataBase = new Prep_DataBase();
//
//    }

    @Description("this test is to connect to DB and Excute Query")
    @Test(priority = 1, description = "Connect to DB and Excute Query and get Result")
    public void connectToDBAndExecuteQuery() {
        Prep_DataBase prepDataBase = new Prep_DataBase();
        String  ConnectStatus = String.valueOf(prepDataBase.getFromDB());
        Validations.assertThat().object(ConnectStatus).isNotNull().withCustomReportMessage("Connection Status is"
                        + ConnectStatus)
                .perform();
}


//    @Description("this test is to connect to DB and Excute Query")
//    @Test(priority = 1, description = "Connect to DB and Excute Query and get Result")
//    public void connectToDBAndExecuteQuery() {
//        String ConnectStatus = String.valueOf(prepDataBase.Connect_To_DB());
//        Validations.assertThat().object(ConnectStatus).isNotNull().withCustomReportMessage("Connection Status is" + ConnectStatus)
//                .perform();
//
//        String Connect_Result = prepDataBase.Execute_SQL_Statement("select * from OSUSR_D5W_INHERITANCE_REQUEST2 inh\\n\" +\n" +
//                "\"join OSUSR_D5W_INHERITANCE_REQUEST_SUMMARY2 s on s.inheritance_id = inh.id\\n\" +\n" +
//                "\"where inh.unique_id = 'be96e605-5865-4cdc-93b8-3a5bd6d028e6'");
////        System.out.println(Connect_Result);
//        Validations.assertThat().object(Connect_Result).isNotNull().withCustomReportMessage("Connection Result is" + Connect_Result)
//                .perform();
//    }


}
