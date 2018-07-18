package com.epam.ta.MyPages;

import com.epam.ta.pages.AbstractPage;
import com.epam.ta.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CreateNewGistPage extends AbstractPage {

    private static final int TIMEOUT_SECONDS = 5;
    private final String BASE_URL = "https://gist.github.com";
    private final Logger logger = LogManager.getRootLogger();


    @FindBy(xpath = "//*[@class='HeaderNavlink']")     //заменен
    private WebElement buttonCreateNew;

    @FindBy(xpath = "//a[contains(text(), 'New gist')]")
    private WebElement linkNewGist;

    @FindBy(name = "gist[description]")
    private WebElement textDescription;

    @FindBy(name = "gist[contents][][name]")
    private WebElement textFileName;

    @FindBy(className = "form-control filename js-gist-filename js-blob-filename")
    private WebElement textContent;

    @FindBy(xpath = "//pre[@class = ' CodeMirror-line ']/span")
    private WebElement textInput;

    @FindBy(xpath = "//div[@class= 'CodeMirror-code']")
    private WebElement text;

    @FindBy(xpath = "//a[@class='tooltipped tooltipped-s css-truncate']")
    private WebElement gistName;

    @FindBy(className = "btn btn-sm btn-danger")
    private WebElement deleteGistBtn;

    @FindBy(name = "gist[public]")
    private WebElement btnCreatePublic;

    @FindBy(xpath= "//button[@class='btn btn-sm btn-danger']")
    private WebElement deleteButton;

    @FindBy(xpath= "//strong[@class='css-truncate-target']")
    private WebElement lastGistLink;

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public CreateNewGistPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public String createNewGist(String gistDescription, String gistFileName,String gistText)
    {
        String gistFileNameText = gistFileName + Utils.getRandomString(6);
        textDescription.sendKeys(gistDescription);
        textFileName.sendKeys(gistFileNameText);
        driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        text.sendKeys(gistText);
        driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        btnCreatePublic.click();
        return gistFileNameText;
    }

    public String getCurrentGistName()
    {
        driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return gistName.getText();

    }
    public String deleteGist(){
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return lastGistLink.getText();
    }
}
