package CodenBox;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
    WebDriver driver = new ChromeDriver();
	String Website="https://codenboxautomationlab.com/practice/";
    Random rand=new Random();
    
    @BeforeTest
    public void AutomationSetup() {
      driver.get(Website);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
   }
    
    @Test(enabled=false)
    public void RadioButton() {
    	WebElement DivRadio=driver.findElement(By.id("radio-btn-example"));
    	List<WebElement>AllRadioButtons=DivRadio.findElements(By.tagName("input"));
    	int MyRandomInput=rand.nextInt(AllRadioButtons.size());
    	AllRadioButtons.get(MyRandomInput).click();	
    	boolean ActualResult= AllRadioButtons.get(MyRandomInput).isSelected();
        boolean ExpectedResult=true;    	
    	Assert.assertEquals(ActualResult, ExpectedResult,"this is the Expected Result");
    	
    }
    
    @Test(enabled=false)
    public void DynamicDropDown() throws InterruptedException {
    	WebElement DropDown=driver.findElement(By.id("autocomplete"));
    	String[]Region= {"Jordan","United","Germany"};
    	int MyRandomRegion=rand.nextInt(Region.length);
    	DropDown.sendKeys(Region[MyRandomRegion]);
    	Thread.sleep(3000);
    	DropDown.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
    	 

    }
    @Test(enabled=false)
    public void StaticDropDown() {
    	WebElement SelectButton=driver.findElement(By.id("dropdown-class-example"));
    	List<WebElement>MySelection=SelectButton.findElements(By.tagName("option"));
    	Select MySelector=new Select(SelectButton);
    	int MyRandomSelection=rand.nextInt(1,MySelection.size());
    	MySelector.selectByIndex(MyRandomSelection);	
    }
  @Test(enabled=false)
  public void CheckBoxEx() {
	 
	  WebElement DivCheck=driver.findElement(By.id("checkbox-example"));
	  List<WebElement> AllCheckButtons=DivCheck.findElements(By.tagName("input"));
	 System.out.println(AllCheckButtons.size());
		   for(int i=0;i<AllCheckButtons.size();i++) {
			//Press option1 and option3
			   if(i==0) {
				   continue;
			   }	
			   AllCheckButtons.get(i).click();	
			// boolean ExpectedResult=true;  
	  //   	boolean ActualResult=AllCheckButtons.get(i).isSelected();
	  //   	Assert.assertEquals(ActualResult, ExpectedResult);
			   
			   
		   }  
  }
    
  @Test(enabled=false)
  public void SwitchWindow() {
	  WebElement PressWindow=driver.findElement(By.id("openwindow"));
	  PressWindow.click();
	 Set<String> Handels=driver.getWindowHandles();
	 List<String> AllTabs=new ArrayList<>(Handels);
	 driver.switchTo().window(AllTabs.get(1));
	 WebElement Blog=driver.findElement(By.xpath("//*[@id=\"menu-item-9947\"]/a"));
	 Blog.click();
	  System.out.println(driver.getTitle());
	  driver.switchTo().window(AllTabs.get(0));
	  CheckBoxEx();
		 driver.switchTo().window(AllTabs.get(1));
driver.findElement(By.xpath("//*//*[@id=\"menu-item-9680\"]/a")).click();
	  
  }
  @Test(enabled=false)
  public void OpenTab() throws InterruptedException {
	  WebElement PressTab=driver.findElement(By.id("opentab"));
	  PressTab.click();
	  Set<String> Handels=driver.getWindowHandles();
		 List<String> AllTabs=new ArrayList<>(Handels);
		 driver.switchTo().window(AllTabs.get(1));
	//	 Thread.sleep(2000);
	//	  System.out.println(driver.getTitle());
	//  System.out.println(driver.getCurrentUrl());
	//  Assert.assertEquals(driver.getTitle(), "Codenbox AutomationLab - YouTube");
	//  Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/@CodenboxAutomationLab");
	  
  }
    
  @Test(enabled=false)
  public void AlertExample() {
	  WebElement NameTab=driver.findElement(By.id("name"));
	  NameTab.sendKeys("Salloum");
	  WebElement AlertButton=driver.findElement(By.id("alertbtn"));
	  AlertButton.click();
		 driver.switchTo().alert().accept();
	  WebElement ConfirmButton=driver.findElement(By.id("confirmbtn"));
	  ConfirmButton.click();
	//  driver.switchTo().alert().accept();
	//  driver.switchTo().alert().dismiss();
	 // String TheExpectedResult="Hello Salloum, share this practice page who love to learn automation";

//	 Assert.assertEquals(driver.switchTo().alert().getText(), TheExpectedResult);
	  
	  
  }
  
 @Test(enabled=false)
 public void WebTable () {
	 WebElement DivTable=driver.findElement(By.id("product"));
	 List<WebElement> Table =DivTable.findElements(By.tagName("tr"));
//	 // I want to print one row, skip the next, then print another row, and so on
// for (int i=0;i<Table.size();i=i+2) {
//	 System.out.println(Table.get(i).getText()); 	 
//}
	 // if i  want to print the column 
// for(int i=1;i<Table.size();i++) {
//	 Table.get(i).findElements(By.tagName("td")).get(0).getText();
// System.out.println( Table.get(i).findElements(By.tagName("td")).get(0).getText());
// }
 System.out.println(Table.get(0).findElements(By.tagName("th")).get(2).getText());
 
	 }
 
 
 @Test(enabled=false)
 public void ElementDisplay() throws InterruptedException {
	 WebElement HideBox=driver.findElement(By.id("hide-textbox"));
	 HideBox.click(); 
	 WebElement DisplayBox=driver.findElement(By.id("displayed-text")); 
	 //Hide Box
	boolean ActualResult= DisplayBox.isDisplayed();
    boolean ExpectedResult=false;
	 Assert.assertEquals(ActualResult, ExpectedResult);
	 //Show Box
	 WebElement ShowBox=driver.findElement(By.id("show-textbox"));
	 ShowBox.click();
	 boolean ActualResult2=DisplayBox.isDisplayed();
	 boolean ExpectedResult2=true;
     Assert.assertEquals(ActualResult2, ExpectedResult2);
 }
  
  @Test (enabled=false)
  public void  MouseHover() throws InterruptedException {
	 WebElement MouseButton=driver.findElement(By.id("mousehover"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0, 2000)");
	 Actions MyAction=new Actions(driver);
	 MyAction.moveToElement(MouseButton).build().perform();
	  WebElement Selection=driver.findElement(By.linkText("Top"));
	  Thread.sleep(3000);
	  Selection.click();
	  WebElement SelectionTwo=driver.findElement(By.linkText("Reload"));
	  Thread.sleep(3000);
	  SelectionTwo.click();  
	  
  }
  @Test(enabled=false)
  public void EnableAndDisable() throws InterruptedException {
	WebElement DisableButton=driver.findElement(By.id("disabled-button"));
	DisableButton.click();
	  WebElement FieldInput=driver.findElement(By.id("enabled-example-input"));
	 boolean ExpectedResult=false;
	boolean ActualResult= FieldInput.isEnabled();
    Assert.assertEquals(ActualResult, ExpectedResult);
    Thread.sleep(3000);
	WebElement EnableButton=driver.findElement(By.id("enabled-button"));
	EnableButton.click();
	 boolean ExpectedResult2=true;
	boolean ActualResult2= FieldInput.isEnabled();
	 Assert.assertEquals(ActualResult2, ExpectedResult2);
	 FieldInput.sendKeys("salloum salman");
  }
  
  @Test (enabled=false)
  public void CalendarExample() throws InterruptedException {
	 WebElement OpenCalendar=driver.findElement(By.linkText("Booking Calendar"));
	 OpenCalendar.click();
	 // to move from tab to another and handle the other tab 
	 Set<String> Handels=driver.getWindowHandles();
	 List<String> AllTabs=new ArrayList<>(Handels);
	 Thread.sleep(3000);
	 driver.switchTo().window(AllTabs.get(1));
	 List<WebElement> availableDates =driver.findElements(By.cssSelector("td.date_available"));
      System.out.println(availableDates.size());
      for (int i = 0; i < availableDates.size(); i++) {
	   availableDates = driver.findElements(By.cssSelector("td.date_available"));
        availableDates.get(i).click();  
      }	 	 
  }
      
     @Test
     public void IFrameExample() throws InterruptedException {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollTo(0, 2300)");
   driver.switchTo().frame("courses-iframe");
 WebElement Content= driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu"));
 Content.click();
	 driver.navigate().to("https://codenboxautomationlab.com/practice/");
    	 
    	 
    	 
     }
    	 
    	 
 
  
    
     @AfterTest
    public void AutomationClose() {

    }
}


















