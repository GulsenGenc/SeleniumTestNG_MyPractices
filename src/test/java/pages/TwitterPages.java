package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TwitterPages {
    public TwitterPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-testid='signupButton']")
    public WebElement ePostaIleKaydolButonu;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement isimKutusu;

    @FindBy(xpath = "//span[text()='E-posta kullan']")
    public WebElement ePostaKullanButonu;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-mk0yit r-1f1sjgu'])[2]")
    public WebElement ePostaKutusu;

    @FindBy(xpath = "(//div[@dir='auto'])[10]")
    public WebElement ileriButonu;
}
