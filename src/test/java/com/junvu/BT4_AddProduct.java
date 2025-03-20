package com.junvu;

import com.junvu.common.BaseTest;
import com.junvu.common.LocatorsCSM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.BlockingDeque;

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
    public void TestAddNewProduct() throws InterruptedException {
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

        //Add New Product

        //Khởi tạo các elements
        WebElement ele_ProductName = driver.findElement(By.xpath(LocatorsCSM.productNamefield));
        WebElement ele_Category = driver.findElement(By.xpath(LocatorsCSM.productCategory));
        WebElement ele_CategorySearchBox = driver.findElement(By.xpath(LocatorsCSM.productCategoryTextBox));
        WebElement ele_ChooseCategory = driver.findElement(By.xpath("//span[normalize-space()='Gio qua Tet 1']"));
        WebElement ele_Brand = driver.findElement(By.xpath(LocatorsCSM.brandDropList));
        WebElement ele_ChooseBrand = driver.findElement(By.xpath("//a[@id='bs-select-2-1']//span[@class='text'][normalize-space()='MiuMiu']"));
        WebElement ele_Unit = driver.findElement(By.xpath(LocatorsCSM.unitField));
        WebElement ele_Weight = driver.findElement(By.xpath(LocatorsCSM.weightField));
        WebElement ele_MinimumPurchaseQty = driver.findElement(By.xpath(LocatorsCSM.minQuantityPur));
        WebElement ele_Tags= driver.findElement(By.xpath(LocatorsCSM.productTags));
        WebElement ele_Barcode = driver.findElement(By.xpath(LocatorsCSM.productBarcode));
        WebElement ele_GalleryImages = driver.findElement(By.xpath(LocatorsCSM.productGalleryImages));
        WebElement ele_ThumbnailImage = driver.findElement(By.xpath(LocatorsCSM.productThumnailImage));
        WebElement ele_ImageSearchBox = driver.findElement(By.xpath(LocatorsCSM.productImageSearchBox));
        WebElement ele_ImageSelectButton = driver.findElement(By.xpath(LocatorsCSM.productImageSelectButton));
        WebElement ele_ProductVariationHeader = driver.findElement(By.xpath(LocatorsCSM.productVariationHeader));
        WebElement ele_ColorEnableButton = driver.findElement(By.xpath(LocatorsCSM.productColorsEnableButton));
        WebElement ele_ColorDropList = driver.findElement(By.xpath(LocatorsCSM.productColors));
        WebElement ele_SelectColor1 = driver.findElement(By.xpath(LocatorsCSM.productColor_1));
        WebElement ele_SelectColor3 = driver.findElement(By.xpath(LocatorsCSM.productColor_3));
        //ĐANG Ở ĐÂY




        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

    }
}
