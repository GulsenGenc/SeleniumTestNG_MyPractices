package tests.elifHocaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.*;

public class Q3_SoftAssert {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high with soft Assert
     *     T2 : Verify item prices are sorted from low to high with hard Assert
    // Verify item prices are sorted from low to high with hard Assert

     */

    @Test
    public void loginTest() {
        // * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");
        //  * Enter the user name  as standard_user
        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        // * Enter the password as   secret_sauce
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // * Click on login button
        Driver.getDriver().findElement(By.id("login-button")).click();
    }

    @Test
    public void softAssertTesti() throws InterruptedException {
        //  *     T1 : Choose price low to high with soft Assert
        Select select =new Select(Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']")));
        select.selectByVisibleText("Price (low to high)");

        String expected = "PRICE (LOW TO HIGH)";
        //String actual = select.getFirstSelectedOption().getText();
        String actual2 = Driver.getDriver().findElement(By.className("active_option")).getText();
        SoftAssert softAssert=new SoftAssert();
      //  softAssert.assertEquals(actual,expected);
        softAssert.assertEquals(actual2,expected);
        softAssert.assertAll();
    }

    @Test
    public void hardAssertTesti() {
         //*     T2 : Verify item prices are sorted from low to high with hard Assert
        // Verify item prices are sorted from low to high with hard Assert
        List<WebElement> urunLIst=Driver.getDriver().findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<Double> urunF??yatDouble=new ArrayList<>();
        for (WebElement w:urunLIst
             ) {
            String f??yatStr=w.getText().substring(1);
            urunF??yatDouble.add(Double.valueOf(f??yatStr));
        }
        ArrayList<Double> kontrolList=new ArrayList<>(urunF??yatDouble);
        Collections.sort(kontrolList);
        Assert.assertEquals(urunF??yatDouble,kontrolList);
        Driver.closeDriver();
    }
}
