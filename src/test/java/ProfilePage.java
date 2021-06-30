import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'user-account__name')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link count-me legouser__menu-item " +
            "legouser__menu-item_action_exit legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_mail')]")
    private WebElement mailBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account__name')]")));
        String userName = userMenu.getText();
        return userName; }


    public void entryMenu() {
        userMenu.click();
    }


    public void userMail() {
        mailBtn.click();
    }


    public void userLogout() {
        logoutBtn.click();
    }
}
