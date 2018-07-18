package com.epam.ta.MyPages;

import com.epam.ta.pages.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchRequestPage extends AbstractPage {

    private final String BASE_URL = "https://github.com/search";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(name = "q")
    private WebElement search;

    @FindBy (xpath = "//div[@class='d-table-cell col-2 text-gray pt-2']")
    private WebElement LanguageMarker;

    @FindBy (xpath = "//a[@class='v-align-middle']")
    private WebElement SearchResultLink;

    @FindBy (id = "js-repo-pjax-container")
    private WebElement navBarUserRepo;

    @FindBy (xpath = "//div[@class='TableObject-item TableObject-item--primary position-relative']/input")
    private WebElement navRequestInput;

    @FindBy (xpath ="//div[@class='border rounded-1 p-3 mb-3']/ul/li/a" )
    private WebElement LanguageJava;

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public SearchRequestPage(WebDriver driver) {
        super(driver);
            PageFactory.initElements(this.driver, this);
    }

    public void getJavaOnly(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LanguageJava.click();
    }

public String getLanguageMarkerText(){
    System.out.println(LanguageMarker.getText());
        return LanguageMarker.getText();

}
public boolean ClickFirstResultLink(){
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    SearchResultLink.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return navBarUserRepo.isDisplayed();
}

}
