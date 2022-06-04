package tests.canHocaTaskler;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestNGtask02 {
    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
// 7.Checkout'a tıklayın


    @Test
    public void test01() throws InterruptedException {
        ReactPage react = new ReactPage();

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reactUrl"));

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        for (int i = 1; i <= 16; i++) {
            System.out.println(i + ". ürün->" + react.urunlerList.get(i - 1).getText());
        }

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> urunIsımleriList = new ArrayList<>();
        for (WebElement w : react.urunlerList
        ) {
            urunIsımleriList.add(w.getText());
        }

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        Faker faker = new Faker();
        List<Integer> randomSecılenIndexler = new ArrayList<>();
        double toplam = 0;
        for (int i = 0; i < 5; i++) {
            int randomIndex = faker.random().nextInt(react.urunlerList.size());
            if (!randomSecılenIndexler.contains(randomIndex)) {
                randomSecılenIndexler.add(randomIndex);
                react.addToCardList.get(randomIndex).click();
                Thread.sleep(2000);
                react.xButonu.click();
                String secılenUrunFıyatıString = react.urunFıyatlarıList.get(randomIndex).getText();
                double secılenUrunFıyatıDouble = Double.parseDouble(secılenUrunFıyatıString.substring(1));
                toplam += secılenUrunFıyatıDouble;
                System.out.println("urun adı :" + urunIsımleriList.get(randomIndex));
                System.out.println("urun fıyatı :" + secılenUrunFıyatıDouble);

            } else {
                i--;
            }
        }
        System.out.println("secılen bes urun fıyat toplamı :" + toplam);

        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        react.sepetButonu.click();
        Thread.sleep(2000);
        String sepettekıUrunFıyatStrıng = react.sepettekıUrunToplamFıyatı.getText();
        double sepettekıUrunFıyatDouble = Double.parseDouble(sepettekıUrunFıyatStrıng.substring(2));
        Assert.assertEquals((int) sepettekıUrunFıyatDouble, (int) toplam);

        // 7.Checkout'a tıklayın
        react.chekout.click();
        Driver.getDriver().switchTo().alert().accept();

        Driver.closeDriver();
    }
}
