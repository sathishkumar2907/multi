package com.ex;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;





//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppiumParallelExecution implements Runnable {
	
	
    Dimension size;
    String port;
    String udid;
   
    public AppiumParallelExecution(String portNumber, String udid) {
        this.port = portNumber;
        this.udid = udid;
    }
   
    RemoteWebDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
   
   
    private void openAppAndPerformSomeActions() throws MalformedURLException {
    	try{
    		
    	System.out.println(Thread.currentThread().getName());
        capabilities.setCapability("deviceName", "SM-J200G");
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("platformName", "Android");
     // capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
     // capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        
        File file=new File("D:\\sathish_eclipse_workspace\\MultipleDevicesAppium\\appk_new\\app-debug.apk");
      	capabilities.setCapability("app",file.getAbsolutePath());
    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        
          driver = new RemoteWebDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
 
          try { 
          
          By sign_up = By.id("com.tvisha.hoopshe:id/signup_button2");
  		  By username = By.id("com.tvisha.hoopshe:id/name");
  		  By password=By.id("com.tvisha.hoopshe:id/password");
  		  By login_Btn_path=By.id("com.tvisha.hoopshe:id/signup_button2");
  		  
  		  size=driver.manage().window().getSize();
  		  System.out.println(size);
  		 
  		  WebElement sign=driver.findElement(sign_up);
  		  sign.click();
  		  
  		  WebElement user_name=driver.findElement(username);
  		  user_name.sendKeys("sravani@tvisha.in");
  		  
  		  WebElement pass_word=driver.findElement(password);
  		  pass_word.sendKeys("123456");
  		   
  		 // driver.navigate().back();
  		  
  		  WebElement login_btn=driver.findElement(login_Btn_path);
  		  
  		  System.out.println("login button clicking");
  		  login_btn.click();
          
  		  Thread.sleep(1000);
  		  
  		    
  	   By feeds_path=By.id("com.tvisha.hoopshe:id/tab_feeds");
  	   By events_path=By.id("com.tvisha.hoopshe:id/tab_events");
  	   By friends_path=By.id("com.tvisha.hoopshe:id/tab_friends");
  	   By profile_path=By.id("com.tvisha.hoopshe:id/tab_profile");
  	  
  	   WebElement feeds_field=driver.findElement(feeds_path);
  	   feeds_field.click();
  	  // driver.navigate().back();
  	   
  	   WebElement events_field=driver.findElement(events_path);
  	   events_field.click();
  	  // driver.navigate().back();
  	   
  	   WebElement friends_field=driver.findElement(friends_path);
  	   friends_field.click();
  	   driver.navigate().back();
  	   
  	   WebElement  profile_field=driver.findElement(profile_path);
  	   profile_field.click();
  	   driver.navigate().back();
  	   
  	   
  		  
  	 WebElement more_function=driver.findElement(By.id("com.tvisha.hoopshe:id/ic_more"));
  	 more_function.click();
  		   
  	 WebElement log_out=driver.findElement(By.name("Logout"));
  	 log_out.click();
  		
     } catch (InterruptedException e) {
            e.printStackTrace();
     }
       
  //  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    
      //  hamburgerIcon.click();
      //  hello.click();
    
    }
    
//    public void test_case_1(){
//    	
//    	  try{
//    		  By sign_up = By.id("com.tvisha.hoopshe:id/signup_button2");
//    		  By username = By.id("com.tvisha.hoopshe:id/name");
//    		  By password=By.id("com.tvisha.hoopshe:id/password");
//    		  By login_Btn_path=By.id("com.tvisha.hoopshe:id/signup_button2");
//    		  
//    		  size=driver.manage().window().getSize();
//    		  System.out.println(size);
//    		
//    		  WebElement sign=driver.findElement(sign_up);
//    		  System.out.println("clicking");
//    		  sign.click();
//    		  
//    		  WebElement user_name=driver.findElement(username);
//    		  user_name.sendKeys("sravani@tvisha.in");
//    		  
//    		  WebElement pass_word=driver.findElement(password);
//    		  pass_word.sendKeys("123456");
//    		   
//    		  driver.navigate().back();
//    		  
//    		 // ((RemoteWebDriver) driver).getKeyboard().sendKeys(Keys.ENTER);
//    		 //  Thread.sleep(500);
//    		  
//    		  WebElement login_btn=driver.findElement(login_Btn_path);
//    		  System.out.println("login button clicking");
//    		  login_btn.click();
//    		  
//    		  }catch(Exception e){
//    			  e.printStackTrace();
//    		    } 
//    	        }
      
    
    
    public static void main(String args[]) throws InterruptedException {
     
     // Runnable r1 = new AppiumParallelExecution("4723", "92011639ac06c34b"); //device id of first mobile device
      //Runnable r2 = new AppiumParallelExecution("4723", "TA8900EEFU"); //device id of second mobile device
      //Runnable r2 = new AppiumParallelExecution("4723", "ZX1B34W9BQ"); //device id of second mobile device
    	Runnable r1 = new AppiumParallelExecution("5000", "emulator-5554"); //device id of first mobile device
        //Runnable r2 = new AppiumParallelExecution("4723", "emulator-5554"); //device id of second mobile device
      Runnable r3 = new AppiumParallelExecution("4723", "emulator-5556"); //device id of third mobile device
        
       //Runnable r3=new AppiumParallelExecution("5001","emulator-5552");
        
        new Thread(r1).start();
      //  new Thread(r2).start();
       new Thread(r3).start();
      //new Thread(r3).start();
        
       
        
        Thread.sleep(500);
        }

     @Override
      public void run() {
        try {
			openAppAndPerformSomeActions();
			quite();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
       // test_case_1();
    }
    
	  public void quite(){
		 driver.quit();
	  }
	
}
