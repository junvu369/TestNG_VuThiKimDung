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

import java.awt.*;
import java.awt.event.KeyEvent;

public class BT4_AddCategoryToProduct extends BaseTest {
    //0. Khai báo softAssert
    SoftAssert softAssert = new SoftAssert();

    @Test()
    public void testCreateCategorytoProduct() throws InterruptedException, AWTException {
        driver.get("https://cms.anhtester.com/login");

        //Khai báo elements Log in
        WebElement ele_inputEmail = driver.findElement(By.xpath(LocatorsCSM.inputEmail));
        WebElement ele_inputPassWord = driver.findElement(By.xpath(LocatorsCSM.inputPassword));
        WebElement ele_buttonLogin = driver.findElement(By.xpath(LocatorsCSM.buttonLogin));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);
        //Tạo đối tượng của Robot class
        Robot robot = new Robot();

        //1 Log in
        ele_inputEmail.clear();
        action.sendKeys(ele_inputEmail, "admin@example.com").perform();
        Thread.sleep(1000);
        ele_inputPassWord.clear();
        action.sendKeys(ele_inputPassWord, "123456").perform();
        action.click(ele_buttonLogin).perform();

        //2 Tạo Category mới
        //Khai báo elements Category_1
        WebElement ele_menuProduct = driver.findElement(By.xpath(LocatorsCSM.menuProduct));
        WebElement ele_menuCategory = driver.findElement(By.xpath(LocatorsCSM.menuCategory));

        //2.1 Click vào Menu Product và chọn Menu Category
        Thread.sleep(1000);
        action.click(ele_menuProduct).perform();
        Thread.sleep(1000);
        action.click(ele_menuCategory).perform();
        Thread.sleep(1000);

        //Khai báo elements Category_2
        WebElement ele_buttonCreateCategory = driver.findElement(By.xpath(LocatorsCSM.buttonCreateCategory));

        //2.2 Click vào button Add New Category
        action.click(ele_buttonCreateCategory).perform();
        Thread.sleep(1000);

        //Khai báo elements Category_3
        WebElement ele_headerAddNewCategory = driver.findElement(By.xpath(LocatorsCSM.headerAddNewCategory));

        //2.2.1 Kiểm tra header trang Add New Category
        Assert.assertTrue(ele_headerAddNewCategory.isDisplayed(), "Không hiển thị đúng trang Thêm mới Category");
        softAssert.assertEquals(ele_headerAddNewCategory.getText(), "Category Information", "Giá trị header trang Add New Category không đúng.");

        //Khai báo elements Category_3
        WebElement ele_CategoryNameTextbox = driver.findElement(By.xpath(LocatorsCSM.textBoxCategoryName));
        WebElement ele_ParentCategoryDropList = driver.findElement(By.xpath(LocatorsCSM.dropListParentCategory));
        WebElement ele_OrderingNumberfield = driver.findElement(By.xpath(LocatorsCSM.textBoxOrderNumber));
        WebElement ele_CategoryTypeDroplist = driver.findElement(By.xpath(LocatorsCSM.dropListCategoryType));
        WebElement ele_BannerImage = driver.findElement(By.xpath(LocatorsCSM.bannerImage));
        WebElement ele_IconImage = driver.findElement(By.xpath(LocatorsCSM.iconImage));
        WebElement ele_MetaTitle = driver.findElement(By.xpath(LocatorsCSM.metaTitleTextbox));
        WebElement ele_MetaDescription = driver.findElement(By.xpath(LocatorsCSM.metaDescription));
        WebElement ele_FilteringAttributes = driver.findElement(By.xpath(LocatorsCSM.dropListFilteringAttributes));
        WebElement ele_CategorySaveButton = driver.findElement(By.xpath(LocatorsCSM.CategorysaveButton));

        //2.3. Thêm mới Category
        //Điền vào Category Name
        action.sendKeys(ele_CategoryNameTextbox, "Giỏ quà bánh Tết").perform();
        //Chọn Parent Category
        action.click(ele_ParentCategoryDropList).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath("//select[@name='parent_id']/following-sibling::div//input")), "Gio qua Tet").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[normalize-space()='Gio qua Tet 1']"))).perform();
        //Điền vào trường Ordering Number
        Thread.sleep(1000);
        action.sendKeys(ele_OrderingNumberfield, "123456").perform();
        //Chọn Type
        Thread.sleep(1000);
        action.click(ele_CategoryTypeDroplist).perform();
        action.click(driver.findElement(By.xpath("(//select[@name='digital']/following-sibling::div//a)[1]"))).perform();
        Thread.sleep(1000);
        //Thêm ảnh Banner Image
        action.click(ele_BannerImage).perform();
        Thread.sleep(2000);
        action.sendKeys(driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")), "Cosy").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//div[(@title='Cosy.png') and (@data-value=2601)]"))).perform();
        action.click(driver.findElement(By.xpath(LocatorsCSM.bannerImageAddFile))).perform();
        Thread.sleep(1000);
        //Thêm ảnh Icon Image
        action.click(ele_IconImage).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")), "hoa tuyết mai").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//div[(@title='hoa tuyết mai.png') and (@data-value=2618)]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath(LocatorsCSM.iconImageAddFile))).perform();
        Thread.sleep(1000);
        //Điền vào trường Meta Title
        action.sendKeys(ele_MetaTitle, "ABC").perform();
        //Điền vào trường Meta Description
        action.sendKeys(ele_MetaDescription, "This is test").perform();
        Thread.sleep(1000);
        //Chọn Attributes
        action.click(ele_FilteringAttributes).perform();
        action.click(driver.findElement(By.xpath("//ul[@role='presentation']/descendant::a[@id='bs-select-3-0']"))).perform();
        Thread.sleep(1000);
        action.click(ele_FilteringAttributes).perform();
        Thread.sleep(2000);
        //Click vào Save Button
        action.click(ele_CategorySaveButton).perform();
        Thread.sleep(3000);

        //Kiểm tra xem đã add Category thành công hay chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCSM.addSuccessMessage)).getText().contains("inserted successfully"), "Category chưa được add mới thành công");

        //Kiểm tra lại category vừa add đã chính xác chưa
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText().equals("Giỏ quà bánh Tết"), "Tên Category vừa được tạo chưa hiển thị đúng");

        //3. Tạo mới Product và chọn Category mới tạo phía trên
        //Khai báo elements Product_1
        WebElement ele_addNewProduct = driver.findElement(By.xpath(LocatorsCSM.addNewProduct));

        //Click vào button Add New Product
        action.click(driver.findElement(By.xpath(LocatorsCSM.addNewProduct))).perform();
        Thread.sleep(2000);

        //Khai báo elements Product_2
        WebElement ele_ProductName = driver.findElement(By.xpath(LocatorsCSM.productNamefield));
        WebElement ele_Category = driver.findElement(By.xpath(LocatorsCSM.productCategory));
        WebElement ele_CategorySearchBox = driver.findElement(By.xpath(LocatorsCSM.productCategoryTextBox));
        WebElement ele_Brand = driver.findElement(By.xpath(LocatorsCSM.brandDropList));
        WebElement ele_Unit = driver.findElement(By.xpath(LocatorsCSM.unitField));
        WebElement ele_Weight = driver.findElement(By.xpath(LocatorsCSM.weightField));
        WebElement ele_MinimumPurchaseQty = driver.findElement(By.xpath(LocatorsCSM.minQuantityPur));
        WebElement ele_Tags = driver.findElement(By.xpath(LocatorsCSM.productTags));
        WebElement ele_Barcode = driver.findElement(By.xpath(LocatorsCSM.productBarcode));
        WebElement ele_productImageHeader = driver.findElement(By.xpath(LocatorsCSM.productImageHeader));
        WebElement ele_GalleryImages = driver.findElement(By.xpath(LocatorsCSM.productGalleryImages));
        WebElement ele_ThumbnailImage = driver.findElement(By.xpath(LocatorsCSM.productThumnailImage));
        WebElement ele_productVideoHeader = driver.findElement(By.xpath(LocatorsCSM.productVideoHeader));
        WebElement ele_ProductVariationHeader = driver.findElement(By.xpath(LocatorsCSM.productVariationHeader));
        WebElement ele_ColorEnableButton = driver.findElement(By.xpath(LocatorsCSM.productColorsEnableButton));
        WebElement ele_ColorDropList = driver.findElement(By.xpath(LocatorsCSM.productColors));
        WebElement ele_Attributes = driver.findElement(By.xpath(LocatorsCSM.productAttributes));
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

        //Điền vào trường Product name
        action.sendKeys(ele_ProductName, "Giỏ quà Tết Cosy Kinh Đô").perform();
        Thread.sleep(1000);

        //Chọn Category là Category đã tạo ở trên
        action.click(ele_Category).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//div[@id='bs-select-1']//li/a[@id='bs-select-1-162']"))).perform();
        Thread.sleep(1000);

        //Chọn Brand
        action.click(ele_Brand).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//a[@id='bs-select-2-1']"))).perform();
        Thread.sleep(1000);

        //Điền vào trường Unit
        ele_Unit.click();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(1000);

        //Điền vào trường Weight
        ele_Weight.clear();
        action.sendKeys(ele_Weight, "1").perform();
        Thread.sleep(1000);

        //Điền vào trường Minimum Purchase Qty
        ele_MinimumPurchaseQty.clear();
        action.sendKeys(ele_MinimumPurchaseQty, "100").perform();
        Thread.sleep(1000);

        //Điền vào trường Tags
        action.sendKeys(ele_Tags, "Bánh kẹo").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        //Di chuyển đến header Product Video
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele_productVideoHeader);
        Thread.sleep(1000);

        //Thêm ảnh vào sản phẩm
        action.click(ele_GalleryImages).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search your files']")), "Cosy").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("(//div[@id='aiz-select-file']/child::div/div[@class='aiz-file-box-wrap'])[1]"))).perform();
        action.click(driver.findElement(By.xpath("//button[normalize-space()='Add Files']"))).perform();
        Thread.sleep(1000);

        action.click(ele_ThumbnailImage).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search your files']")), "Hoa tuyết mai").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//div[@id='aiz-select-file']/child::div/div[@class='aiz-file-box-wrap']"))).perform();
        action.click(driver.findElement(By.xpath("//button[normalize-space()='Add Files']"))).perform();
        Thread.sleep(1000);

        //Di chuyển đến header Product Price+Stock
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", ele_ProductPriceAndStockHeader);
        Thread.sleep(1000);

        //Chọn Màu
        action.click(ele_ColorEnableButton).perform();
        Thread.sleep(1000);
        action.click(ele_ColorDropList).perform();
        action.click(driver.findElement(By.xpath("(//div[@id='bs-select-4']//ul[@role='presentation']/li)[1]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("(//div[@id='bs-select-4']//ul[@role='presentation']/li)[3]"))).perform();
        action.click(ele_ProductVariationHeader).perform();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCSM.productColors)).getText(), "2 items selected", "Số lượng màu được chọn bị sai.");

        //Chọn Attribute => Size
        action.click(ele_Attributes).perform();
        action.click(driver.findElement(By.xpath("(//div[@id='bs-select-5']/ul[@role='presentation']/li)[1]")));
        action.click(ele_ProductVariationHeader).perform();
        Thread.sleep(1000);
        //Chọn Size cụ thể bên trong Attribute
        action.click(driver.findElement(By.xpath("//div[@id='customer_choice_options']//div[@class='col-md-8']//button"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[normalize-space()='22']"))).perform();
        action.click(ele_ProductVariationHeader).perform();
        Thread.sleep(1000);

        //Điền thông tin vào trường Unit price
        ele_UnitPrice.clear();
        action.sendKeys(ele_UnitPrice, "250000").perform();
        Thread.sleep(1000);

        //Chọn Discount Date Range
        action.click(ele_DiscountDateRange).perform();
        action.click(driver.findElement(By.xpath("//div[@class='drp-calendar left']/child::div//td[@data-title='r3c5']"))).perform();
        action.click(driver.findElement(By.xpath("//div[@class='drp-calendar right']/child::div//td[@data-title='r4c3']"))).perform();
        Thread.sleep(1000);
        action.click(ele_DiscountDateRangeSelectButton).perform();
        Thread.sleep(1000);

        //Điền Discount
        ele_Discount.clear();
        action.sendKeys(ele_Discount, "10").perform();
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
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("arguments[0].scrollIntoView(true);", ele_SEOMetaTagsheader);
        Thread.sleep(1000);

        //Click vào button Save&publish
        action.click(ele_SaveAndPublishButton).perform();
        Thread.sleep(3000);

        //Kiểm tra xem sản phẩm tạo mới thành công hay chưa
        Assert.assertEquals(driver.findElement(By.xpath("//span[@data-notify='message']")).getText(), "Product has been inserted successfully", "Sản phẩm chưa được tạo mới thành công.");

        Thread.sleep(1000);
        //Kiểm tra xem sản phẩm tạo mới đúng tên chưa => Get text kết quả trường Name ở dòng đầu tiên
        softAssert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='All products']")).getText(), "All products", "Tiêu đề trang chưa đúng. ");
        action.sendKeys(driver.findElement(By.xpath("//input[@id='search']"))).sendKeys("Giỏ quà Tết Cosy Kinh Đô").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("(//form[@id='sort_products']/child::div//tbody//span)[2]")).getText().equals("Giỏ quà Tết Cosy Kinh Đô"), "Tên sản phẩm vừa tạo chưa hiển thị đúng.");
        softAssert.assertAll();
    }
}

