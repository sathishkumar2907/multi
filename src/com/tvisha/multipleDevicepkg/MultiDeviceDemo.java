package com.tvisha.multipleDevicepkg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiDeviceDemo {
	public WebDriver driver;
	public WebDriverWait wait;
	Dimension size;

	
	@Parameters({"deviceName_","UDID_","platformVersion_","URL_"})
	//String deviceName_,String UDID_,String platformVersion_,String URL_
	@BeforeMethod(alwaysRun=true)
	public void setUp(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException{
		try{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName",deviceName_);
		capabilities.setCapability("UDID",UDID_);
		capabilities.setCapability("platformVersion",platformVersion_);
		capabilities.setCapability("platformName", "Android");
		
	    File file=new File("D:\\sathish_eclipse_workspace\\MultipleDevicesAppium\\apk\\app-debug.apk");
		capabilities.setCapability("app",file.getAbsolutePath());
		driver=new RemoteWebDriver(new URL("http://"+URL_),capabilities);
		
		//====================getSession ID============================================================
		SessionId seesion=((RemoteWebDriver)driver).getSessionId();
		System.out.println("Session ID :"+seesion.toString());
	
		  }catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
//	public void set() throws MalformedURLException{
//		
//		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setCapability("deviceName", "");
//		cap.setCapability("UDID", "");
//		cap.setCapability("platformVersion", "");
//		cap.setCapability("platformName", "");
//		
//		File file=new File("");
//		cap.setCapability("app",file.getAbsolutePath());
//		
//		driver=new RemoteWebDriver(new URL("http://192.168.2.51:4723/wd/hub"),cap);
//		
//		
//	}
	
	
	
//	@Parameters({"deviceName1_","UDID1_","platformVersion1_","URL1_"})
//	@BeforeMethod(alwaysRun=true)
//	public void setUp1(String deviceName1_,String UDID1_,String platformVersion1_,String URL1_) throws MalformedURLException{
//		try{
//		DesiredCapabilities capabilities=new DesiredCapabilities();
//		capabilities.setCapability("deviceName",deviceName1_);
//		capabilities.setCapability("UDID",UDID1_);
//		capabilities.setCapability("platformVersion",platformVersion1_);
//		capabilities.setCapability("platformName", "Android");
//		
//		
//		File file=new File("D:\\sathish_eclipse_workspace\\MultipleDevicesAppium\\apk\\app-debug.apk");
//		capabilities.setCapability("app",file.getAbsolutePath());
//		driver=new RemoteWebDriver(new URL("http://"+URL1_),capabilities);
//		
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	
//	}
//	
//	private void click() {
//driver.findElement(By.id("")).click();
//	}
	
	
	 @Test(priority=0)
	  public void Test() throws InterruptedException{
		 
		  try{
		  By sign_up = By.id("com.tvisha.hoopshe:id/signup_button2");
		  By username = By.id("com.tvisha.hoopshe:id/name");
		  By password=By.id("com.tvisha.hoopshe:id/password");
		  By login_Btn_path=By.id("com.tvisha.hoopshe:id/signup_button2");
		  
		  size=driver.manage().window().getSize();
		  System.out.println(size);
		
		  WebElement sign=driver.findElement(sign_up);
		  System.out.println("clicking");
		  sign.click();
		  
		  WebElement user_name=driver.findElement(username);
		  user_name.sendKeys("sravani@tvisha.in");
		  
		  WebElement pass_word=driver.findElement(password);
		  pass_word.sendKeys("123456");
		   
		  driver.navigate().back();
		  
		 // ((RemoteWebDriver) driver).getKeyboard().sendKeys(Keys.ENTER);
		//  Thread.sleep(500);
		  
		  WebElement login_btn=driver.findElement(login_Btn_path);
		  System.out.println("login button clicking");
		  login_btn.click();
		  
		  }catch(Exception e){
			  e.printStackTrace();
		    } 
		  }
	      
	  @Test(priority=1)
	   public void home_Page(){
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
		
	  }
	   
	   @Test(priority=2)
	      public void center_Add_Button() throws InterruptedException{
		  By product_path=By.id("com.tvisha.hoopshe:id/tab_product");
		  By service_path=By.id("com.tvisha.hoopshe:id/tab_service");
		  By event_path=By.id("com.tvisha.hoopshe:id/tab_event");
		
		  By center_add_Btn=By.id("com.tvisha.hoopshe:id/tab_createProduct");
		  
		  WebElement  center_add_btn_field=driver.findElement(center_add_Btn);
		  center_add_btn_field.click();
		   
//		  WebElement  service_field=driver.findElement(service_path);
//		  service_field.click();
		  
//		  WebElement  event_field=driver.findElement(event_path);
//		  event_field.click();

//		  WebElement status_field=driver.findElement(status_path);
//		  status_field.click();
		  
//		  WebElement  media_field=driver.findElement(media_path);
//		  media_field.click();
		  
		  WebElement  product_field=driver.findElement(product_path);
		  product_field.click();
		  
		  WebElement dropdown = driver.findElement(By.id("com.tvisha.hoopshe:id/category"));
		  dropdown.click();
		
		  driver.findElement(By.name("Clothing")).click();
		  
		  WebElement sub_category = driver.findElement(By.id("com.tvisha.hoopshe:id/sub_category"));
		  sub_category.click();
		  
		  driver.findElement(By.name("Sarees")).click();
		  try{
		  
		  WebElement title = driver.findElement(By.id("com.tvisha.hoopshe:id/title"));
		  title.sendKeys("Upendra_Title");
		  driver.navigate().back();
		  Thread.sleep(500);
		  
		 // driver.execute('mobile:scroll', {direction: 'down'});
		  
		 // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		  WebElement element = driver.findElement(By.className("android.widget.ScrollView"));
//		    Actions actions = new Actions(driver);
		  
		   // actions.moveToElement(element);
		    // actions.click();
		 //   actions.perform();
//		  JavascriptExecutor js = (JavascriptExecutor) driver;
//	      HashMap<String, String> scrollObject = new HashMap<String, String>();
//	      scrollObject.put("direction", "down");
//	      js.executeScript("mobile: scroll", scrollObject);
//		  
		    WebElement desc = driver.findElement(By.id("com.tvisha.hoopshe:id/description"));
		    desc.sendKeys("good title");
		    driver.navigate().back();
		  //  driver.navigate().back();
		  
		    WebElement location = driver.findElement(By.id("com.tvisha.hoopshe:id/address"));
		    location.sendKeys("Hyderaabd, Telangana, India");
		    selectOptionWithIndex(10);
		    driver.navigate().back();
		    
		  try{
		  WebElement product_submit = driver.findElement(By.id("com.tvisha.hoopshe:id/submit"));
		  System.out.println("product submit button is clicking=======");
		  product_submit.click();
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		 // driver.navigate().back();
		  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		   Thread.sleep(1000);
	      }

//	   @Test(priority=3)
//	   public void test_case3(){
//		   By status_path=By.id("com.tvisha.hoopshe:id/tab_status");
//		   By media_path=By.id("com.tvisha.hoopshe:id/tab_media");
//		   By status_data_path=By.id("com.tvisha.hoopshe:id/status");
//		   By status_public_radioBtn_path=By.id("com.tvisha.hoopshe:id/status");
//		   By status_friends_radioBtn_path=By.id("com.tvisha.hoopshe:id/publish_to_friends");
//		   By status_followers_radioBtn_path=By.id("com.tvisha.hoopshe:id/publish_to_followers");
//		   By status_submitBtn_path=By.id("com.tvisha.hoopshe:id/submit");
//		   By status_upload_path=By.id("com.tvisha.hoopshe:id/selecte_file");
//		   By media_submitBtn_path=By.id("com.tvisha.hoopshe:id/submit");
//		   
//		   
//		   //==========Media paths======
//		   By media_upload_image_path=By.id("com.tvisha.hoopshe:id/media_img");
//		   By media_title_path=By.id("com.tvisha.hoopshe:id/title");
//		   By media_Description_path=By.id("com.tvisha.hoopshe:id/description");
//		   //=============================
//		   
//		      WebElement status_field=driver.findElement(status_path);
//			  status_field.click();
//			  
//		      WebElement status_title_field=driver.findElement(status_data_path);
//		      status_title_field.sendKeys("hoping the best");
//		      driver.navigate().back();
//		      
//		      WebElement status_upload_field=driver.findElement(status_upload_path);
//		      status_upload_field.click();
//		      
//		      driver.findElement(By.id("com.android.documentsui:id/icon_mime")).click();
//		      
//		      WebElement status_friends_radioBtn_field=driver.findElement(status_friends_radioBtn_path);
//		      status_friends_radioBtn_field.click();
//		      
//		      WebElement status_followers_radioBtn_field=driver.findElement(status_followers_radioBtn_path);
//		      status_followers_radioBtn_field.click();
//		      
////		      WebElement status_public_radioBtn_field=driver.findElement(status_public_radioBtn_path);
////		      status_public_radioBtn_field.click();
//		      
//		      WebElement status_submitBtn_field=driver.findElement(status_submitBtn_path);
//		      status_submitBtn_field.click();
//		      
//		      //mediaaa =============================================
//			  WebElement  media_field=driver.findElement(media_path);
//			  
//			  media_field.click();
//			  
//			  WebElement media_upload_image_field=driver.findElement(media_upload_image_path);
//			  media_upload_image_field.click();
//			  
//			  driver.findElement(By.id("com.android.documentsui:id/icon_mime")).click();
//			  //((TouchAction) driver).tap(driver.findElement(By.id("com.android.documentsui:id/icon_mime"))); 
//			
//			  WebElement media_title_field=driver.findElement(media_title_path);
//			  media_title_field.sendKeys(" mediaa Title");
//		      driver.navigate().back();
//		      
//		      WebElement media_Desc_field=driver.findElement(media_Description_path);
//		      media_Desc_field.sendKeys("media the best");
//		      driver.navigate().back();
//			  
//		      WebElement media_friends_radioBtn_field=driver.findElement(status_friends_radioBtn_path);
//		      media_friends_radioBtn_field.click();
//		   
//		      WebElement  media_submit_field=driver.findElement(media_submitBtn_path);
//		      media_submit_field.click();
//		      
//	        }
	   
	        @Test(priority=4)
	        public void test_case4(){
		    By ex1=By.id("");
		    By ex2=By.id("");
		    By ex3=By.id("");
		    By ex4=By.id("");
		   
		    WebElement ex_1=driver.findElement(By.id(""));
		    WebElement ex_2=driver.findElement(By.id(""));
		    WebElement ex_3=driver.findElement(By.id(""));
		    WebElement ex_4=driver.findElement(By.id(""));
		    WebElement ex_5=driver.findElement(By.id(""));
		}
	   
	   @Test(priority=5)
	   public void log_out(){
		   
		   WebElement more_function=driver.findElement(By.id("com.tvisha.hoopshe:id/ic_more"));
		   more_function.click();
		   
		   WebElement log_out=driver.findElement(By.name("Logout"));
		   log_out.click();
		   
	   }
	   
	   public void selectOptionWithIndex(int indexToSelect){
		    	try {
				WebElement autoOptions = driver.findElement(By.id("com.tvisha.hoopshe:id/address"));
				wait.until(ExpectedConditions.visibilityOf(autoOptions));

				List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("com.tvisha.hoopshe:id/address"));
			        if(indexToSelect<=optionsToSelect.size()) {
			        	System.out.println("Trying to select based on index: "+indexToSelect);
			           optionsToSelect.get(indexToSelect).click();
			        }
			} 		
			catch (NoSuchElementException e) {
				System.out.println(e.getStackTrace());
			}
			catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	   
	  @AfterTest
	  public void quite(){
		 driver.quit();
	  }
	
	
	
	
	
	
	

}
