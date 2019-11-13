package TestCases;

import BaseClass.Base;
import PageObjects.ManagerLogin;
import Util.XLUtil;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;



public class TC_LoginTestDDT_002 extends Base {

public void loginTest(String user,String password){

    logger.info("*************Starting TC_LoginTest_001*************");

    driver.get(properties.getProperty("url"));
    ManagerLogin lp = new ManagerLogin(driver);
    logger.info("*****LOGIN TEST******");
    lp.setUserName(user);
    lp.setPassword(password);
    lp.clickLogin();

    logger.info("****Title Test****");
    String exp_title = "Guru99 Bank Manager HomePage";
    String act_title = driver.getTitle();
    System.out.println(act_title);

    if ( exp_title.equals(act_title) ) {
        Assert.assertTrue(true);
    }
    else {

       // takeScreenShot(driver,"LoginTest");
        Assert.assertTrue(false);

    }


}
@DataProvider(name ="loginTest")
public Object[][] getData( ) throws IOException {

    String path =System.getProperty("user.dir")+"TestData/LoginData.xlsx";
    int rowcount = XLUtil.getRowCount(path,"Sheet1");
    int colcount = XLUtil.getCellCount(path,"Sheet1",1);

    String logindata [][]= new String[rowcount][colcount];

    for ( int i =1;i<=rowcount;i++ ){
        for(int j = 0;j<colcount;j++){
            logindata[i-1][j]=XLUtil.getCellData(path,"Sheet1",i,j);

        }
    }
return logindata;


}



}
