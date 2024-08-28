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
public class DashboardPage {

    private WebDriver driver;
    private GlobalHeader headerComponent;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        headerComponent = PageFactory.initElements(this.driver, GlobalHeader.class);
    }

    public GlobalHeader getHeaderComponent() {
        return headerComponent;
    }

}
