/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import org.testng.annotations.Test;

/**
 *
 * @author umesh
 */
public class TC001 extends BaseTest{
    
    @Test
    public void tc001() {
        TestListener.getTest().log(Status.INFO,"This is first statement in the test case");
        log.info("Logger statement");
    }
}