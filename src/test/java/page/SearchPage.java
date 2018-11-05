package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class SearchPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement searchField;

    @FindBy(xpath = "//ul[contains(@class, 'search-results__list')]/li[contains(@class, 'occluded')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//header[contains(@class, 'container-with-shadow')]")
    private WebElement searchBar;

    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("search")
                && webDriver.getTitle().contains("LinkedIn")
                && isSearchBarDisplayed();
    }

    public int getNumberOfSearchResults(){
        return searchResults.size();
    }

    public boolean isSearchBarDisplayed(){
        return searchBar.isDisplayed();
    }

    public boolean isSearchTermPresent(String searchTerm){
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        for(WebElement element: searchResults){
            jse.executeScript("window.scrollBy(0,250)", "");
            String elementText = element.getText();
            if(!elementText.toLowerCase().contains(searchTerm.toLowerCase())){
                return false;
            }
        }
        return true;
    }



}