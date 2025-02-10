package com.junvu;

import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCSM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class BT3_EditAndDeleteCategory extends BaseTest {

    @Test(priority = 1, description = "Kiểm tra việc tạo một category mới thành công")
    public void testCreateCategory() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Click vào button Add New Category
        driver.findElement(By.xpath(LocatorsCSM.buttonCreateCategory)).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.headerAddNewCategory)).isDisplayed(), "Không hiển thị đúng trang Thêm mới Category");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.headerAddNewCategory)).getText(), "Category Information", "Giá trị header trang Add New Category không đúng.");

        //Thêm mới Category
        driver.findElement(By.xpath(LocatorsCSM.textBoxName)).sendKeys("Giỏ quà bánh Tết");
        driver.findElement(By.xpath(LocatorsCSM.dropListParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.parentCategorySearch)).sendKeys("Gio qua Tet");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Gio qua Tet 1']")).click();
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
        Thread.sleep(3000);

        //Kiểm tra xem đã add Category thành công hay chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.addSuccessMessage)).getText().contains("inserted successfully"), "Category chưa được add mới thành công");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Kiểm tra lại category vừa add đã chính xác chưa")
    public void testCreatedCategory() throws InterruptedException {

        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Kiểm tra lại category vừa add đã chính xác chưa
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText().equals("Giỏ quà bánh Tết"), "Tên Category vừa được tạo chưa hiển thị đúng");
    }

    @Test(priority = 3, description = "Kiểm tra xem user đã vào đến trang Edit Category hay chưa")
    public void editCategoryPage() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Search tên Category vừa mới add thành công
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Click vào icon Edit
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.buttonEditCategory)).isDisplayed(), "Button Edit không hiển thị");
        driver.findElement(By.xpath(LocatorsCSM.buttonEditCategory)).click();

        //Kiểm tra xem user đã vào đúng trang Edit Category hay chưa
        softAssert.assertEquals(driver.findElement(By.xpath("//h5[contains(normalize-space(),'Category Information')]")).getText(), "Category Information", "Tiêu đề trang Edit Category không đúng.");
        Assert.assertTrue(driver.findElement(By.xpath("//li/a[contains(@href,'lang=en')]")).isDisplayed(), "Không hiển thị Edit theo ngôn ngữ Tiếng Anh");
        softAssert.assertAll();
    }

    //Kiểm tra xem user đã edit thành công Category hay chưa
    @Test(priority = 4, description = "Kiểm tra xem user đã edit thành công Category hay chưa")
    public void editCategory() throws InterruptedException {
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Search tên Category vừa mới add thành công
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Click vào icon Edit
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.buttonEditCategory)).click();

        //Thay đổi thông tin bên trong Category
        driver.findElement(By.xpath(LocatorsCSM.textBoxName)).clear();
        driver.findElement(By.xpath(LocatorsCSM.textBoxName)).sendKeys("Giỏ quà bánh Tết 12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.textBoxOrderNumber)).clear();
        driver.findElement(By.xpath(LocatorsCSM.textBoxOrderNumber)).sendKeys("78910");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(LocatorsCSM.saveButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(LocatorsCSM.saveButton)).click();

        //Kiểm tra xem đã Edit Category thành công hay chưa
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.editSuccessMessage)).getText().contains("updated successfully"), "Category chưa được edit thành công");
    }

    //Kiểm tra lại Category sau khi edit
    @Test(priority = 5, description = "Kiểm tra lại Category sau khi edit xem đã lưu chính xác hay chưa")
    public void categoryAfterEdit() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Search tên Category vừa mới edit thành công
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết 12345");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Click vào icon Edit
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.buttonEditCategory)).click();

        //Kiểm tra lại các field đã edit phía trên và so sánh
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.textBoxName)).getAttribute("value"), "Giỏ quà bánh Tết 12345", "Trường Name sau khi edit chưa hiển thị đúng.");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.textBoxOrderNumber)).getAttribute("value"), "78910", "Trường Ordering Number sau khi edit chưa hiển thị đúng.");
        softAssert.assertAll();
    }

    @Test(priority = 6, description = "Kiểm tra việc xóa Category vừa mới edit")
    public void deleteCategory() throws InterruptedException {
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Search tên Category vừa mới edit thành công
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết 12345");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Click vào icon Delete và xác nhận
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.buttonDeleteCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/a[@id='delete-link']")).click();
        //Kiểm tra đã xóa Category thành công
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.deleteSuccessMessage)).getText().contains("deleted successfully"), "Category chưa được xóa thành công");
    }

    @Test(priority = 7, description = "Kiểm tra lại Category đã được xóa thành công ở màn Danh sách Category")
    public void checkDeletedCategory() throws InterruptedException {
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.menuCategory)).click();
        Thread.sleep(1000);

        //Search tên Category vừa mới xóa thành công
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết 12345");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Kiểm tra kết quả hiển thị ở màn hình Danh sách (Không có kết quả hiển thị)
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='Nothing found']")).getText().contains("Nothing found"), "Category chưa được xóa thành công.");
    }
}