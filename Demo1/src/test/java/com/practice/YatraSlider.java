package com.practice;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.client.model.geojson.Point;

public class YatraSlider {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		
			System.setProperty("webdriver.gecko.driver","D:\\new selenium\\geckodriver.exe");
		    FirefoxDriver driver =new FirefoxDriver();
		    driver.manage().window().maximize();
		    
		    driver.get("https://flight.yatra.com/air-search-ui/dom2/trigger?type=R&viewName=normal&flexi=0&noOfSegments=2&origin=PNQ&originCountry=IN&destination=HYD&destinationCountry=IN&flight_depart_date=14/05/2018&arrivalDate=21/05/2018&ADT=1&CHD=0&INF=0&class=Economy&source=fresco-home&version=1.1");
		    
		WebElement Slider= driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/aside/div/div[4]/div[2]/div/rzslider/span[4]"));
		WebElement value=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/aside/div/div[4]/div[2]/div/rzslider/span[8]"));
		org.openqa.selenium.Point p;
		Actions act = new Actions(driver);
		int val=Integer.parseInt(value.getText().replace("Rs. ", "").replaceAll(",", ""));
		System.out.println(val);
				
				if(val<10000)
				{
					System.out.println("slider correct - if");
				}
				else
				{
					while(!(val<10000 ))
							{
								//p = Slider.getLocation();
								act.dragAndDropBy(Slider, -2,	0).perform();;
								Thread.sleep(2000);
								val=Integer.parseInt(value.getText().replace("Rs. ", "").replaceAll(",", ""));
								
								
							}
				}
				
				
				/*if(value.getText().matches("Rs. 1,22,286"))
		{
			System.out.println("slider correct - if");
		}
		else
		{
			while(!(value.getText().matches("Rs. 1,22,286")))
					{
						p = Slider.getLocation();
						act.dragAndDropBy(Slider, -1,	0).perform();;
						Thread.sleep(4000);
						
						
					}
		}
		
		
*/		
}

}
