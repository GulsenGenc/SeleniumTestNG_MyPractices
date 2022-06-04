package tests.canHocaTaskler;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Guru99Page;
import utilities.ConfigReader;
import utilities.Driver;

public class TestNGtask01 {
    /*
    http://demo.guru99.com/test/drag_drop.html url e git
    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
    Perfect butonun goruntulendigini dogrulayin
     */

    @Test
    public void test00() {
        Actions actions=new Actions(Driver.getDriver());
        Guru99Page guru=new Guru99Page();
        //   http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));

        //DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        actions.dragAndDrop(guru.bankButonu,guru.DSaccountBolumu).perform();
        // CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(guru.salesButonu, guru.CSaccountButonu).perform();
        //DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(guru.besBınButonuBır,guru.DSamountBolumu).perform();
        // CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(guru.besBınButonuIkı, guru.CSamountBolumu).perform();
        //Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(guru.perfectYazısı.isDisplayed());

    }


}
