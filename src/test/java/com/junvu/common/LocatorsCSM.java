package com.junvu.common;

public class LocatorsCSM {
    public static String headerLogin = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[@type='submit']";
    public static String menuDashboard = "//span[normalize-space()='Dashboard']";
    public static String menuProduct = "//ul[@id='main-menu']/descendant::span[normalize-space()='Products']";
    public static String menuCategory = "//ul[@id='main-menu']/descendant::a[@href='https://cms.anhtester.com/admin/categories']";
    public static String headerCategory = "//h1[normalize-space()='All categories']";
    public static String buttonCreateCategory = "//a[@href='https://cms.anhtester.com/admin/categories/create']";
    public static String headerAddNewCategory = "//h5[normalize-space()='Category Information']";
    public static String textBoxName = "//input[@id='name']";
    public static String dropListParentCategory = "//select[@name='parent_id']/following-sibling::button";
    public static String parentCategorySearch = "//select[@name='parent_id']/following-sibling::div//input";
    public static String textBoxOrderNumber = "//div/input[@id='order_level']";
    public static String dropListType = "//select[@name='digital']/following-sibling::button";
    public static String bannerImage = "(//div/label[@for='signinSrEmail']/following-sibling::div//div[normalize-space()='Browse'])[1]";
    public static String bannerImageAddFile = "//div//button[normalize-space()='Add Files']";
    public static String iconImage = "(//div/label[@for='signinSrEmail']/following-sibling::div//div[normalize-space()='Browse'])[3]";
    public static String iconImageAddFile = "//div//button[normalize-space()='Add Files']";
    public static String metaTitleTextbox = "//div/label[normalize-space()='Meta Title']/following-sibling::div/input";
    public static String metaDescription = "//div/textarea[@name='meta_description']";
    public static String dropListFilteringAttributes = "//select[@name='filtering_attributes[]']/following-sibling::button";
    public static String saveButton = "//div/button[@type='submit']";
    public static String addSuccessMessage = "//span[normalize-space()='Category has been inserted successfully']";
    public static String buttonEditCategory = "(//a[contains(@href,'https://cms.anhtester.com/admin/categories/edit/')])[1]";
    public static String editSuccessMessage = "//div/span[normalize-space()='Category has been updated successfully']";
    public static String buttonDeleteCategory = "(//a[contains(@data-href,'https://cms.anhtester.com/admin/categories/destroy/')])[1]";
    public static String deleteSuccessMessage = "//div/span[normalize-space()='Category has been deleted successfully']";
}
