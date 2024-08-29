/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author umesh
 */
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public GlobalHeader getGlobalHeader() {
        return new GlobalHeader(this.driver);
    }

    public GlobalFooter getGlobalFooter() {
        return new GlobalFooter(this.driver);
    }

    public GlobalMenu getGlobalMenu() {
        return new GlobalMenu(this.driver);
    }
}
