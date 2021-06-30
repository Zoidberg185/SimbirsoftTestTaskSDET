import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessagePage {

    public WebDriver driver;
    public SendMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindBy(className = "composeYabbles")
    private WebElement recipientMessage;

    @FindBy(className = "ComposeSubject-TextField")
    private WebElement subjectMessage;

    @FindBy(className = "cke_wysiwyg_div")
    private WebElement bodyMessage;


    @FindBy(className = "ComposeControlPanelButton")
    private WebElement sendMessageBtn;


    public void inputRecipientMail(String mail) {
        recipientMessage.sendKeys(mail);
    }


    public void inputSubjectMessage(String subject) {
        subjectMessage.sendKeys(subject);
    }


    public void inputBodyMessage(String body) {
        bodyMessage.sendKeys(body);
    }


    public void clickSendMessageBtn() {
        sendMessageBtn.click();
    }
}
