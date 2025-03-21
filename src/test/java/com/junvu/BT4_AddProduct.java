package com.junvu;

import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCSM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BT4_AddProduct extends BaseTest {

    //Log in thành công
    @Test(priority = 1, description = "Kiểm tra Log in thành công")
    public void testLoginSuccess() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();
        Thread.sleep(2000);
    }

    //Click vào Product và chọn Add New Product
    @Test(priority = 2, description = "Kiểm tra User đã vào được màn Add New Product hay chưa")
    public void testAddNewProduct() throws InterruptedException {
        //Log in
        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();
        Thread.sleep(2000);
        //Click vào Product và chọn Add New Product
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.addNewProduct)).click();
        Thread.sleep(2000);
        //Kiểm tra xem đã vào đúng trang Add New Product chưa
        Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).getText(), "Add New Product", "The header is not matched.");
    }

    //Tiến hành Add New Product và chọn đúng Category đã add ở BT3
    @Test
    public void TestAddNewProduct() throws InterruptedException, AWTException {
        //1. Log in
        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCSM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCSM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCSM.buttonLogin)).click();
        Thread.sleep(2000);

        //2. Click vào Product và chọn Add New Product
        driver.findElement(By.xpath(LocatorsCSM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCSM.addNewProduct)).click();
        Thread.sleep(2000);

        //3. Add New Product

        //3.1. Khởi tạo các elements
        WebElement ele_ProductName = driver.findElement(By.xpath(LocatorsCSM.productNamefield));
        WebElement ele_Category = driver.findElement(By.xpath(LocatorsCSM.productCategory));
        WebElement ele_CategorySearchBox = driver.findElement(By.xpath(LocatorsCSM.productCategoryTextBox));
        WebElement ele_Brand = driver.findElement(By.xpath(LocatorsCSM.brandDropList));
        WebElement ele_Unit = driver.findElement(By.xpath(LocatorsCSM.unitField));
        WebElement ele_Weight = driver.findElement(By.xpath(LocatorsCSM.weightField));
        WebElement ele_MinimumPurchaseQty = driver.findElement(By.xpath(LocatorsCSM.minQuantityPur));
        WebElement ele_Tags = driver.findElement(By.xpath(LocatorsCSM.productTags));
        WebElement ele_Barcode = driver.findElement(By.xpath(LocatorsCSM.productBarcode));
        WebElement ele_GalleryImages = driver.findElement(By.xpath(LocatorsCSM.productGalleryImages));
        WebElement ele_ThumbnailImage = driver.findElement(By.xpath(LocatorsCSM.productThumnailImage));
        WebElement ele_ProductVariationHeader = driver.findElement(By.xpath(LocatorsCSM.productVariationHeader));
        WebElement ele_ColorEnableButton = driver.findElement(By.xpath(LocatorsCSM.productColorsEnableButton));
        WebElement ele_ColorDropList = driver.findElement(By.xpath(LocatorsCSM.productColors));
        WebElement ele_SelectColor1 = driver.findElement(By.xpath(LocatorsCSM.productColor_1));
        WebElement ele_SelectColor3 = driver.findElement(By.xpath(LocatorsCSM.productColor_3));
        WebElement ele_Attributes = driver.findElement(By.xpath(LocatorsCSM.productAttributes));
        WebElement ele_Attributes_Size = driver.findElement(By.xpath(LocatorsCSM.productAtributes_Size));
        WebElement ele_ProductPriceAndStockHeader = driver.findElement(By.xpath(LocatorsCSM.productPriceandStockheader));
        WebElement ele_UnitPrice = driver.findElement(By.xpath(LocatorsCSM.productPriceField));
        WebElement ele_DiscountDateRange = driver.findElement(By.xpath(LocatorsCSM.productDiscountDateRange));
        WebElement ele_DiscountDateRangeSelectButton = driver.findElement(By.xpath(LocatorsCSM.productDiscountDateSelectButton));
        WebElement ele_DiscountDropList = driver.findElement(By.xpath(LocatorsCSM.productDiscountDropList));
        WebElement ele_Discount = driver.findElement(By.xpath(LocatorsCSM.productDiscountField));
        WebElement ele_Quantity = driver.findElement(By.xpath(LocatorsCSM.productQuantityField));
        WebElement ele_SKU = driver.findElement(By.xpath(LocatorsCSM.productSKU));
        WebElement ele_ProductDescriptionHeader = driver.findElement(By.xpath(LocatorsCSM.productDescriptionheader));
        WebElement ele_ProductDescription = driver.findElement(By.xpath(LocatorsCSM.productDescription));
        WebElement ele_SEOMetaTagsheader = driver.findElement(By.xpath(LocatorsCSM.productSEOMetaTagsheader));
        WebElement ele_SaveAndPublishButton = driver.findElement(By.xpath(LocatorsCSM.productSaveAndPublishButton));
        WebElement ele_AddNewProductSuccess = driver.findElement(By.xpath(LocatorsCSM.addProductSuccessMessage));

        //3.2.1. Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);
        //3.2.2. Tạo đối tượng của Robot class
        Robot robot = new Robot();

        //3.3. Dùng Action và Robot Class để thao tác tạo mới product

        //Điền vào trường Product name
        action.sendKeys(ele_ProductName, "Giỏ quà Tết Cosy Kinh Đô").perform();

        //Chọn Category là Category đã tạo ở BT3
        action.click(ele_Category).perform();
        Thread.sleep(1000);
        action.sendKeys(ele_CategorySearchBox, "Gio qua Tet 1").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[@class='text']"))).perform();
        Thread.sleep(1000);

        //Chọn Brand
        action.click(ele_Brand).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//a[@id='bs-select-2-1']"))).perform();
        Thread.sleep(1000);

        //Điền vào trường Unit
        ele_Unit.click();
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(1000);

        //Điền vào trường Weight
        ele_Weight.clear();
        ele_Weight.click();
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);

        Thread.sleep(1000);

        //Điền vào trường Minimum Purchase Qty
        ele_MinimumPurchaseQty.clear();
        ele_MinimumPurchaseQty.click();
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);

        Thread.sleep(1000);

        //Điền vào trường Tags
        action.sendKeys(ele_Tags, "Bánh kẹo").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        //Thêm ảnh vào sản phẩm
        action.click(ele_GalleryImages).perform();
        action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search your files']")), "Cosy").perform();
        action.click(driver.findElement(By.xpath("(//div[@id='aiz-select-file']/child::div/div[@class='aiz-file-box-wrap'])[1]"))).perform();
        action.click(driver.findElement(By.xpath("//button[normalize-space()='Add Files']"))).perform();
        Thread.sleep(1000);

        action.click(ele_ThumbnailImage).perform();
        action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search your files']")), "Hoa tuyết mai").perform();
        action.click(driver.findElement(By.xpath("//div[@id='aiz-select-file']/child::div/div[@class='aiz-file-box-wrap']"))).perform();
        action.click(driver.findElement(By.xpath("//button[normalize-space()='Add Files']"))).perform();
        Thread.sleep(1000);

        //Di chuyển đến header Product Variation
        action.moveToElement(ele_ProductVariationHeader).perform();
        Thread.sleep(1000);

        //Chọn Màu
        action.click(ele_ColorEnableButton).perform();
        Thread.sleep(1000);
        action.click(ele_ColorDropList).perform();
        action.click(ele_SelectColor1).perform();
        action.click(ele_SelectColor3).perform();
        action.click(ele_ProductVariationHeader).perform();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.productColors)).getText(), "2 items selected1111", "Số lượng màu được chọn bị sai.");

        //Chọn Attribute => Size
        action.click(ele_Attributes).perform();
        action.click(driver.findElement(By.xpath("(//div[@id='bs-select-5']/ul[@role='presentation']/li)[1]")));
        action.click(ele_ProductVariationHeader).perform();
        //Chọn Size cụ thể bên trong Attribute
        action.click(ele_Attributes_Size).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//a[@id='bs-select-20-0']"))).perform();
        action.click(ele_ProductPriceAndStockHeader).perform();

        //Điền thông tin vào trường Unit price
        ele_UnitPrice.clear();
        ele_UnitPrice.click();

        robot.keyPress(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_5);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);
        Thread.sleep(1000);

        //Chọn Discount Date Range
        action.click(ele_DiscountDateRange).perform();
        action.click(driver.findElement(By.xpath("//div[@class='drp-calendar left']/child::div//td[@data-title='r3c5']"))).perform();
        action.click(driver.findElement(By.xpath("//div[@class='drp-calendar right']/child::div//td[@data-title='r4c3']"))).perform();
        Thread.sleep(1000);
        action.click(ele_DiscountDateRangeSelectButton);
        Thread.sleep(1000);

        //Điền Discount
        ele_Discount.click();
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);
        Thread.sleep(1000);

        //Chọn loại discount
        action.click(ele_DiscountDropList).perform();
        action.click(driver.findElement(By.xpath("//a[@id='bs-select-6-1']"))).perform();
        Thread.sleep(1000);

        //Di chuyển đến header Product Description
        action.moveToElement(ele_ProductDescriptionHeader).perform();
        action.sendKeys(ele_ProductDescription, "Giỏ quà Tết này bao gồm 5 loại bánh kẹo nhập khẩu của hãng Kinh Đô. ").perform();
        Thread.sleep(1000);

        //Di chuyển đến header SEO Meta Tags
        action.moveToElement(ele_SEOMetaTagsheader).perform();
        Thread.sleep(1000);

        //Click vào button Save&publish
        action.click(ele_SaveAndPublishButton);
        Thread.sleep(1000);

        //Kiểm tra xem sản phẩm tạo mới thành công hay chưa
        Assert.assertEquals(ele_AddNewProductSuccess, "Product has been inserted successfully", "Sản phẩm chưa được tạo mới thành công.");

        Thread.sleep(1000);
        //Kiểm tra xem sản phẩm tạo mới đúng tên chưa
        Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='All products']")).getText(), "All Products", "Tiêu đề trang chưa đúng. ");
        action.sendKeys(driver.findElement(By.xpath("//input[@id='search']"))).sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-muted text-truncate-2']")).getText(), "Giỏ quà Tết Cosy Kinh Đô", "Tên sản phẩm vừa tạo chưa hiển thị đúng.");
    }
}
