package pages;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReactPage {
    public ReactPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo']")
  public List< WebElement> urunlerList;

    @FindBy(xpath = "//button[@class='sc-124al1g-0 jCsgpZ']")
    public List<WebElement> addToCardList;

    @FindBy(xpath = "//p[@class='sc-124al1g-6 ljgnQL']")
    public List<WebElement> urunFıyatlarıList;

    @FindBy(xpath = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement xButonu;

    @FindBy(xpath = "//div[@class='sc-1h98xa9-2 fGgnoG']")
    public WebElement sepetButonu;

    @FindBy(xpath = "//p[@class='sc-1h98xa9-9 jzywDV']")
    public WebElement sepettekıUrunToplamFıyatı;

    @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement chekout;
}
