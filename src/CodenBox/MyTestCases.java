package CodenBox;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
			   if(i==1) {
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
  
  
    
    
     @AfterTest
    public void AutomationClose() {

    }
}


















