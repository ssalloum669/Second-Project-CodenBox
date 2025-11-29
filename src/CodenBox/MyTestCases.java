package CodenBox;
import java.time.Duration;
import java.util.List;
import java.util.Random;

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

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

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
    @Test
    public void StaticDropDown() {
    	WebElement SelectButton=driver.findElement(By.id("dropdown-class-example"));
    	List<WebElement>MySelection=SelectButton.findElements(By.tagName("option"));
    	Select MySelector=new Select(SelectButton);
    	int MyRandomSelection=rand.nextInt(1,MySelection.size());
    	MySelector.selectByIndex(MyRandomSelection);
    	
    	
    }
    
    
    
    
    
    
    
    
    
     @AfterTest
    public void AutomationClose() {

    }
}


















