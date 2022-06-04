package tests.elifHocaPractice;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Q2_DependsOn {

       /*
    birbirine bagimli testler olusturun..
    .beforClass olusturup setUp ayarlarini yapin..
      birbirine bagimli testler olusturarak;
          ilk once facebook a gidin
          sonra facebook a bagimli olarak google a gidin,
          daha sonra google a bagimli olarak amazon a gidin
    driver i kapatin
 */

    @Test
    public void facebookTest() {
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
    }

    @Test(dependsOnMethods = "facebookTest")
    public void googleTest() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }

    @Test(dependsOnMethods = "googleTest")
    public void amazonTest() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.closeDriver();
    }
}
