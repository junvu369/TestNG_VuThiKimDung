package com.junvu;

import com.junvu.common.BaseTest;
import com.junvu.common.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BT2_AddCategory extends BaseTest {

    WebDriver driver;

    //Xác nhận đã vào đúng Category Page
    @Test
    public void testCategoryPage() throws InterruptedException {
        createDriver();
        loginCSM();
        driver.findElement(By.xpath(Locators.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.menuCategory)).click();
    }

    //Tạo 1 category mới
    @Test
    public void testCreateCategory() throws InterruptedException {
        createDriver();
        loginCSM();
        testCategoryPage();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.buttonCreateCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.textBoxName)).sendKeys("Giỏ quà bánh Tết");

        driver.findElement(By.xpath(Locators.dropListParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.parentCategorySearch)).sendKeys("giỏ bánh kẹo");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='parent_id']/following-sibling::div//descendant::span)[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators.textBoxOrderNumber)).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators.dropListType)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='digital']/following-sibling::div//a)[1]")).click();

        driver.findElement(By.xpath(Locators.bannerImage)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("Cosy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='Cosy.png') and (@data-value=2601)]")).click();
        driver.findElement(By.xpath(Locators.bannerImageAddFile)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators.iconImage)).click();
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("hoa tuyết mai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='hoa tuyết mai.png') and (@data-value=2618)]")).click();
        driver.findElement(By.xpath(Locators.iconImageAddFile)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators.metaTitleTextbox)).sendKeys("ABC");

        driver.findElement(By.xpath(Locators.metaDescription)).sendKeys("This is test");
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators.dropListFilteringAttributes)).click();
        driver.findElement(By.xpath("//ul[@role='presentation']/descendant::a[@id='bs-select-3-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.dropListFilteringAttributes)).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Locators.saveButton)).click();

    }

    //Kiểm tra lại category vừa add
    @Test
    public void testCreatedCategory() throws InterruptedException {
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText());
    }

}



