package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
// click on the ‘Sign In’ link
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
//Verify the text ‘Welcome Back!’
        verifyTextWithAssert("Welcome Back!",((By.xpath("//h1[contains(text(),'Welcome Back!')]"))),"Text is displayed");

    }


@Test
public void verifyTheErrorMessage(){
// click on the ‘Sign In’ link
   clickOnElement((By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")));
// Enter invalid username
    sendTextToElement((By.id("user[email]")),"xyz123@gmail.com");
// Enter invalid password
    sendTextToElement((By.id("user[password]")),"abc");
// Click on Login button
    clickOnElement((By.xpath("//input[@type='submit']")));
// Verify the error message ‘Invalid email or password.
    verifyTextWithAssert("Invalid email or password.",((By.xpath("//li[contains(text(),'Invalid email or password.')]"))),"text is displayed");
}
@After
    public void teRDown(){
closeBrowser();
}
}
