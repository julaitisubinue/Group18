package com.library.pages;

import com.library.utils.BrowserUtilities;
import com.library.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksManagePage {
    public BooksManagePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='Books']")
    private WebElement booksTab;

    @FindBy(xpath = "//div[@id='tbl_books_paginate']//a[.=5]")
    private WebElement page5;

    @FindBy(xpath = "//div[@id='tbl_books_paginate']//a[.=5]/..")
    private WebElement page5Verify;

    public void clickBooksTab(){
        BrowserUtilities.waitClickOnElement(booksTab);
    }

    public void clickPage(){
        BrowserUtilities.scrollTo(page5);
        BrowserUtilities.waitClickOnElement(page5);
    }

    public void clickPage(int pageNumber){
        String xpath = "//div[@id='tbl_books_paginate']//a[.="+(pageNumber+"")+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        BrowserUtilities.scrollTo(element);
        BrowserUtilities.waitClickOnElement(element);
    }

    public boolean page5Verify(){
        BrowserUtilities.wait(1);
        String str = page5Verify.getAttribute("class");
        return str.contains("active");
    }


}
