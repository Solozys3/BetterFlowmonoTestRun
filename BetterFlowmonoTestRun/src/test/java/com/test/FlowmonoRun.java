package com.test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlowmonoRun extends BaseClass {
	 WebDriver driver;
	 WebDriverWait wait;
	@Test
	 public void TestURL() throws InterruptedException {
        WebElement popUpImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flowz-popup-announcement\"]/div[1]/img")));
        popUpImage.click();
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys("solomon.sunday@reventtechnologies.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("Solomonsunday@3");
        driver.findElement(By.className("login-btn")).click();
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[contains(text(),'Sign Document')]")).click(); // Sign document
        driver.findElement(By.xpath("//p[contains(text(),'Sign With Others')]")).click();  // Sign With Others
        wait.until(ExpectedConditions.urlContains("/document/e/setup?signType=multiple"));
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/button")).click();  // Add New Documents
        driver.findElement(By.xpath("//p[contains(text(),'Upload from computer')]"));  // Upload Document

        // Upload the file
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\Solomon Sunday\\Downloads\\Flowmono-Flowmono-nestle.pdf");
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-webapp/section/main/div/div/div/app-document-setup/app-editor-document-setup/div[1]/main/form/div/app-manage-recipient-subject/section/form/div/div[2]/div[1]/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[2]/div"))).click();  // div.mat-select-arrow-wrapper
        //WebElement dropdownArrow = wait.until(ExpectedConditions.elementToBeClickable(By.className("mat-select-value"))).click();
       // if (dropdownArrow.isDisplayed() && dropdownArrow.isEnabled()) {
      //      dropdownArrow.click();
      //  }
		        
        // Wait for the 'General' option and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option//span[contains(text(), 'Technology')]"))).click();
		Thread.sleep(500);

        driver.findElement(By.id("mat-input-5")).sendKeys("realsolo03@yopmail.com");
        driver.findElement(By.id("mat-input-6")).sendKeys("Solomon");
        driver.findElement(By.id("mat-input-7")).sendKeys("Sunday");
        driver.findElement(By.xpath("//*[@id=\"mat-select-4\"]/div/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-3\"]/span")).click();
        driver.findElement(By.className("flwmn-btn-primary")).click();
        Thread.sleep(10000);
        
        WebElement control = driver.findElement(By.xpath("//*[@id=\"editor-controls-toolbar\"]/div[3]/div/div/div[2]/div[1]/div/div/app-svg/svg"));
        WebElement documentContainer = driver.findElement(By.cssSelector(".document-container"));
        
        // Get the dimensions and location of the scrollable container
        Dimension containerSize = documentContainer.getSize();
        Point containerLocation = documentContainer.getLocation();
        
     // Generate random x and y coordinates within the container boundaries
        Random random = new Random();
        int randomX = containerLocation.getX() + random.nextInt(containerSize.getWidth());
        int randomY = containerLocation.getY() + random.nextInt(containerSize.getHeight());
        
		Actions action = new Actions(driver);
		action.clickAndHold(control)
        .moveByOffset(randomX - control.getLocation().getX(), randomY - control.getLocation().getY())
        .release()
        .build()
        .perform();
    }
}
