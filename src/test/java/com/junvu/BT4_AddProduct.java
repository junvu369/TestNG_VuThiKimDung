package com.junvu;

import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCSM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BT4_AddProduct extends BaseTest {
    @Test(priority = 1, description = "Kiểm tra Log in thành công")
    public void testLoginSuccess() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://cms.anhtester.com/login");

        //Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.headerLogin)).isDisplayed(), "Header trang Login không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.headerLogin)).getText(), "Welcome to Active eCommerce CMS", "Giá trị header không đúng.");

        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Kiểm tra xem đã vào được trang Dashboard hay chưa - Log in thành công hay chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.menuDashboard)).isDisplayed(), "Menu Dashboard không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.menuDashboard)).getText(), "Dashboard", "Giá trị Menu Dashboard không đúng.");
        softAssert.assertAll();
    }


}
