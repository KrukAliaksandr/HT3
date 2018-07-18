package com.epam.ta.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";

	@FindBy(xpath = "//*[@class='HeaderNavlink']")     //заменен
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;

	@FindBy(xpath = "//a[contains(text(), 'New gist')]")  // добавлен для теста Test2
	private WebElement linkNewGist;

	@FindBy (className = "form-control header-search-input jump-to-field js-jump-to-field js-site-search-focus")
	private WebElement SearchRequestInput;

	@FindBy (xpath = "//ul[@class = 'filter-list small']/li/a[@class='filter-list small']")
	private WebElement RequeestFilter;

	@FindBy (xpath = "//div[@class='d-table-cell col-2 text-gray pt-2']")
	private WebElement LanguageMarker;

	@FindBy (xpath = "//a[@class='v-align-middle']")
	private WebElement SearchResultLink;

	@FindBy (xpath = "//nav[@class='reponav js-repo-nav js-sidenav-container-pjax container']")
	private WebElement navBarUserRepo;

	@FindBy(name = "q")
	private WebElement search;              //добавлен элемент для поиска

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnCreateNewRepositoryButton()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
	}
	public void clickOnCreateNewGistButton()
	{
		buttonCreateNew.click();
		linkNewGist.click();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

	public void sendRequest(String request){
		search.clear();
		search.sendKeys(request);
		search.submit();
	}
}
