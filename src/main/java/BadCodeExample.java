import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;

public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {

        String searchTerm = "SELENIUM";

        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.google.com");
        WebElement searchField = webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        sleep(2000);
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Search results count: " + searchResults.size());
        System.out.println();


        for(WebElement element: searchResults){
            String elementText = element.getText();
            System.out.println(elementText);
            System.out.println();
            if(elementText.toLowerCase().contains(searchTerm.toLowerCase())){
                System.out.println(searchTerm + " was found");
                System.out.println("=====================================================================");
                System.out.println();
            }
            else{
                System.out.println(searchTerm + " was not found");
                System.out.println("=====================================================================");
                System.out.println();
            }
        }
    }

}
