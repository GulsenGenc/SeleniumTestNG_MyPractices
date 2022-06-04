package tests.elifHocaPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Q4_Alert_DependsOn {
    @Test
    public void test01() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2. CLICK ME of JavaScript Alert e tıklayın
        Driver.getDriver().findElement(By.id("button1")).click();
        // 3. pop up text i alın
        String alertYazı = Driver.getDriver().switchTo().alert().getText();
        // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
        String expectedYazı = "I am an alert box!";
        Assert.assertEquals(alertYazı, expectedYazı);
        // 5. pop up i kabul edin
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
        Driver.getDriver().findElement(By.xpath("//span[@id='button4']")).click();
        // 3.  pop up text i alın
        Alert alert=Driver.getDriver().switchTo().alert();
        String yazı= alert.getText();
        // 4. Mesajın "Press a button!" olduğunu doğrulayın
        String expectedYazı="Press a button!";
       Assert.assertEquals(yazı,expectedYazı);
        // 6. pop up i iptal edin,
        alert.dismiss();

        // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
        String actualYazı=Driver.getDriver().findElement(By.xpath("//p[@id='confirm-alert-text']")).getText();
        String expectedYazıı="You pressed Cancel!";
        Assert.assertEquals(actualYazı,expectedYazıı);
        // 8. alert1'e göre dependsOnMethods kullanın


    }
       /*





 */
}
