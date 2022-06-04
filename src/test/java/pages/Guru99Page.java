package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99Page {
    public Guru99Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='button button-orange'])[5]")
    public WebElement bankButonu;

    @FindBy(xpath = "//*[@id='bank']")
    public WebElement DSaccountBolumu;

    @FindBy(xpath = "(//a[@class='button button-orange'])[6]")
    public WebElement salesButonu;

    @FindBy(xpath = "//*[@id='loan']")
    public WebElement CSaccountButonu;

    @FindBy(xpath = "//*[@id='amt7']")
    public WebElement DSamountBolumu;

    @FindBy(xpath = "(//a[@class='button button-orange'])[4]")
    public WebElement besBınButonuBır;

    @FindBy(xpath = "//*[@id='amt8']")
    public WebElement CSamountBolumu;

    @FindBy(xpath = "(//a[@class='button button-orange'])[2]")
    public WebElement besBınButonuIkı;

    @FindBy(xpath = "//a[@class='button button-green']")
    public WebElement perfectYazısı;


}
