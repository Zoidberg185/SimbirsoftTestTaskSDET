import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage {

    public WebDriver driver;
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindAll(@FindBy(className = "mail-MessageSnippet-Item_subject"))
    private List<WebElement> subjects;


    @FindBy(className = "mail-ComposeButton")
    private WebElement composeBtn;


    public long backRepetitionsMessages(String subject) {
        return subjects.stream().filter(x -> x.getText().equals(subject)).count();
    }

    public void composeMessage() {
        composeBtn.click();
    }
}
