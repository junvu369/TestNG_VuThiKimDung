package com.junvu;

import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCSM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class BT2_AddCategory extends BaseTest {

    @Test(priority = 1, description = "Kiểm tra Log in thành công")
    public void testLoginCSM() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();
    }

    @Test(priority = 2, description = "Kiểm tra xem user đã vào đến trang Category hay chưa")
    public void testCategoryPage() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
    }

    @Test(priority = 3, description = "Kiểm tra việc tạo một category mới thành công")
    public void testCreateCategory() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCSM.buttonCreateCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.textBoxName)).sendKeys("Giỏ quà bánh Tết");

        driver.findElement(By.xpath(LocatorsCSM.dropListParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.parentCategorySearch)).sendKeys("aka");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='parent_id']/following-sibling::div//descendant::span)[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCSM.textBoxOrderNumber)).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCSM.dropListType)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='digital']/following-sibling::div//a)[1]")).click();

        driver.findElement(By.xpath(LocatorsCSM.bannerImage)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("Cosy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='Cosy.png') and (@data-value=2601)]")).click();
        driver.findElement(By.xpath(LocatorsCSM.bannerImageAddFile)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCSM.iconImage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("hoa tuyết mai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='hoa tuyết mai.png') and (@data-value=2618)]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.iconImageAddFile)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCSM.metaTitleTextbox)).sendKeys("ABC");

        driver.findElement(By.xpath(LocatorsCSM.metaDescription)).sendKeys("This is test");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCSM.dropListFilteringAttributes)).click();
        driver.findElement(By.xpath("//ul[@role='presentation']/descendant::a[@id='bs-select-3-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.dropListFilteringAttributes)).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCSM.saveButton)).click();
    }

    @Test(priority = 4, description = "Kiểm tra lại category vừa add đã chính xác chưa")
    public void testCreatedCategory() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();

        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        if ((driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText()).equals("Giỏ quà bánh Tết")) {
            System.out.println("Tạo mới category thành công");
        } else {
            System.out.println("Category chưa được tạo thành công");

        }
    }
}



