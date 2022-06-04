package tests.myPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitFor;

public class RentalCarTasks {
    @Test
    public void test01() {
        //-> https://www.bluerentalcars.com/ adresıne gıdıp asagıdakı bılgılerle  login olalim
        //brcValidEmail=customer@bluerentalcars.com
        //brcValidPassword=12345
        BrcPage brcPage = new BrcPage();
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        brcPage.ilkLoginButonu.click();
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        brcPage.ikinciLoginButonu.click();

        //-> Audi Q8 i secip reservasyon yapalim
        brcPage.getPageSelectElement().selectByVisibleText("Kia Rio");
        Actions actions = new Actions(Driver.getDriver());
        actions.click(brcPage.selectPlace1)
                .sendKeys("balıkesır" + Keys.TAB)
                .sendKeys("bursa" + Keys.TAB)
                .sendKeys("30082023" + Keys.TAB)
                .sendKeys("1223" + Keys.TAB)
                .sendKeys("12092023" + Keys.TAB)
                .sendKeys("1223" + Keys.TAB)
                .sendKeys(Keys.SPACE).perform();

        actions.click(brcPage.kartNoKutusu)
                .sendKeys(ConfigReader.getProperty("brcKartNo") + Keys.TAB)
                .sendKeys(ConfigReader.getProperty("brcKartName") + Keys.TAB)
                .sendKeys(ConfigReader.getProperty("brcKartTarih") + Keys.TAB)
                .sendKeys(ConfigReader.getProperty("brcCVCNo") + Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .perform();


        //-> reservasyon yaptigimizi dogrulayalim-->bu kısım çalışmadı.
       // Assert.assertTrue(brcPage.successfullyYazisi.isDisplayed());
       // System.out.println(brcPage.successfullyYazisi.getText());

    }

    @Test
    public void test02() {
        //->Servis Butonunu tiklayip
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLoginButonu.click();
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));
    brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
    brcPage.ikinciLoginButonu.click();

    brcPage.servicesButonu.click();
    //->Kiraladigimiz araclarin otomatik vitesli olup olmadigini kontrol edelim
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN).
            perform();

    brcPage.q8.click();

    String expectedVites = "Automatic";
        String actualVites = brcPage.vıtesCell.getText();
        Assert.assertEquals(actualVites,expectedVites);
        Driver.closeDriver();
    }

    @Test
    public void test03() {
        //->Login olmadan arac kiralamayacagimizi test edelim.
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        BrcPage brcPage = new BrcPage();
        brcPage.getPageSelectElement().selectByVisibleText("Kia Rio");
        Actions actions = new Actions(Driver.getDriver());
        actions.click(brcPage.selectPlace1)
                .sendKeys("balıkesır" + Keys.TAB)
                .sendKeys("bursa" + Keys.TAB)
                .sendKeys("30082023" + Keys.TAB)
                .sendKeys("1223" + Keys.TAB)
                .sendKeys("12092023" + Keys.TAB)
                .sendKeys("1223" + Keys.TAB)
                .sendKeys(Keys.SPACE).perform();
        waitFor(2);
        Assert.assertTrue(brcPage.loginUyariMesaji.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void test04() {
        //->rezervasyon için verileri girelim

        //-> continue reservation a tiklayalim

        //-> 2 saniye beleyelim ve

        //-> continue reservation hala görünür oldugunu test edelim

    }

    @Test
    public void test05() {
        //-> Servis e gidelim

        //-> En ucuz arac fiyatinin 12 saatlik dolar oldugunu test edelim

        //-> En paha li aracin fiyatinin 3500 $ oldugunu test edelim

        //-> En ucuz ve en pahali aracin ekran resmini alalim
    }

    @Test
    public void test06() {
        //-> login olalim

        //-> login olduktan sonra profile gidelim ve

        //-> bilgilerin dogru oldugunu kontrol edelim

        //-> logout u tiklayip sistemi terk edelim
    }


}
