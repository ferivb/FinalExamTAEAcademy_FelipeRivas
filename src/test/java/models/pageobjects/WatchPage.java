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

    /**
     * Validates if the second carousel is not empty.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean secondCarouselIsNotEmpty(){
        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(starsLogo));
        List<WebElement> secondCarousel = carouselList.get(1).findElements(By.cssSelector("li"));
        return secondCarousel.stream()
                .allMatch(element -> element.getText().length() > 0);
    }

    /**
     * Click on a given card.
     *
     * @param index of card to click
     * @author Felipe.Rivas
     */
    public void clickOnCardByIndex(int index){
        List<WebElement> firstCarousel = carouselList.get(0).findElements(By.cssSelector("li"));
        clickOn(firstCarousel.get(index));
    }

    /**
     * Validates if the carousel has the X button.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean carouselCardHasCloseButton(){
        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(popUpSearchBar));
        return cardCloseButton.isDisplayed();
    }

    /**
     * Closes the card.
     *
     * @author Felipe.Rivas
     */
    public void closeCard(){
        clickOn(cardCloseButton);
    }

    /**
     * Goes back home
     *
     * @author Felipe.Rivas
     */
    public HomePage goBackHome(){
        DriverManager.getDriver().navigate().back();
        return new HomePage();
    }
}
