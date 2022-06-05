package tests.canHocaTaskler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class TestNGtask03 {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
*/

    @Test
    public void test01() throws InterruptedException {
        //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        Driver.getDriver().get("http://tutorialsninja.com/demo/index.php?route=common/home");

        // ~ click on Phones & PDAs
        Driver.getDriver().findElement(By.xpath("//a[text()='Phones & PDAs']")).click();

        // ~ get the brandName of phones
        List<WebElement> tumUrunListesi = Driver.getDriver().findElements(By.xpath("//h4"));
        tumUrunListesi.stream().forEach(t -> System.out.println(t.getText()));//lambada ile her bır eleman yazdırıldı.

        // ~ click on add to button for all elements
        List<WebElement> addToCartButtonları = Driver.getDriver().findElements(By.xpath("//*[text()='Add to Cart']"));
        for (WebElement w : addToCartButtonları
        ) {
            w.click();  //her bir 'Add to Cart' butonuna click yapıldı.
        }
        Thread.sleep(3000);

        //   ~ click on black total added cart button
        Driver.getDriver().findElement(By.xpath("(//button[@data-toggle='dropdown'])[2]")).click();

        //   ~ get the names of list from the cart
        List<String> sepettekıUrunListesi = new ArrayList<>();  //Sepetteki urunler bır liste atandı asagida for içinde
        for (int i = 1; i <= 3; i++) {
            System.out.println("sepetteki " + i + ". ürün :" + Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[2]")).getText());

            sepettekıUrunListesi.add(Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[2]")).getText());
        }

        //~ compare the names from displaying list and cart list
        List<String> urunListesi = new ArrayList<>();//tum urun lıstesı strıng olarak lıste atandı
        for (WebElement w : tumUrunListesi
        ) {
            urunListesi.add(w.getText());
        }
        System.out.println("urun listesi:"+urunListesi);
        System.out.println("sepettekı urun Listesi :"+sepettekıUrunListesi);
        Assert.assertTrue(urunListesi.containsAll(sepettekıUrunListesi));

        Driver.closeDriver();
    }
}
