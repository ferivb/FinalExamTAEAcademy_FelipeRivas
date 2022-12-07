package models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.web.config.diver.DriverManager;

import java.util.List;

public class WatchPage extends BasePage{

    @FindBy(css = ".Nav__Primary__Icon__STARPlus")
    private WebElement starsLogo;

    @FindBy(css = "ul.Carousel__Inner:first-of-type")
    private List<WebElement> carouselList;

    @FindBy(id = "WatchProvider__Search")
    private WebElement popUpSearchBar;

    @FindBy(className = "lightbox__closebtn")
    private WebElement cardCloseButton;

    public boolean secondCarouselIsNotEmpty(){
        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(starsLogo));
        List<WebElement> secondCarousel = carouselList.get(1).findElements(By.cssSelector("li"));
        return secondCarousel.stream()
                .allMatch(element -> element.getText().length() > 0);
    }

    public void clickOnCardByIndex(int index){
        List<WebElement> firstCarousel = carouselList.get(0).findElements(By.cssSelector("li"));
        clickOn(firstCarousel.get(index));
    }

    public boolean carouselCardHasCloseButton(){
        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(popUpSearchBar));
        return cardCloseButton.isDisplayed();
    }
}
