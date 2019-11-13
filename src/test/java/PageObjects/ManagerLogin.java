package PageObjects;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ManagerLogin extends Base {

 public WebDriver driver;
public ManagerLogin(WebDriver rdriver){
driver=rdriver;
    PageFactory.initElements(driver,this);
}
@FindBy( name ="uid")
    WebElement textUserName;
@FindBy(name ="password")
    WebElement textPassword;
@FindBy(name= "btnLogin")
    WebElement btnLogin;






    public void setUserName(String uname)
    {
        textUserName.clear();
        textUserName.sendKeys(uname);

    }

    public void setPassword(String pwd)
    {
        textPassword.clear();
        textPassword.sendKeys(pwd);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }



}
