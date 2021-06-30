import io.qameta.allure.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Tests {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MailPage mailPage;
    public static SendMessagePage sendMessagePage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(ConfProperties.getProperty("pathtochrome"));
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new RemoteWebDriver(new URL(ConfProperties.getProperty("gridurl")), options);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        mailPage = new MailPage(driver);
        sendMessagePage = new SendMessagePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    @Description(value = "Checking the correctness of the username")
    public void test1() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("username"), user);
        profilePage.entryMenu();
        profilePage.userMail();
        profilePage.entryMenu();
        profilePage.userLogout();
    }

    @Test
    @Description("Checking the amount of test messages in the email")
    public void test2() {
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        mailPage.composeMessage();
        sendMessagePage.inputRecipientMail(ConfProperties.getProperty("login"));
        sendMessagePage.inputSubjectMessage(ConfProperties.getProperty("subject1"));
        sendMessagePage.inputBodyMessage(ConfProperties.getProperty("infotext") + mailPage.backRepetitionsMessages(ConfProperties.getProperty("subject2")) + ".");
        Assert.assertEquals(3, mailPage.backRepetitionsMessages(ConfProperties.getProperty("subject2")));
        sendMessagePage.clickSendMessageBtn();
    }

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();
    }
}
