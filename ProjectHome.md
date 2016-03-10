The objective of the framework is to make the automation tester feel ease while automating the scripts using selenium webdriver and TestNG. The framework generates report using ReportNG with screen shots for each action perfromed and the screen shot is linked in the report correspondingly. This framework works basically on page object pattern.

The following controls are defined in framework
```
1. Button
2. TextField
3. TextArea
4. CheckBox
5. SelectBox
6. Link
7. Label
8. DateControl
9. RadioButton
```
Refer the java doc for the functionality defined for each controls

Do the following steps to start automating.
```
1. Have a custom test plan which extends TestPlan
2. Have your custom web page extending WebPage
3. Create a package named properties and cre a property file in that package
4. Add this property file name in testNG as a parameter with name dataFile
5. create a text file 'ReportData.txt' in src package.
6. This property file will be loaded and those values will be available in the variable name "properties" in your custom 
TestPlan, this variable is defined and loaded in TestPlan

```


You can check out the project from https://componentframework.googlecode.com/svn/trunk/

for more details of checkout refer https://code.google.com/p/componentframework/source/checkout

you can use the property file for storing config values, expected results, Label and etc

Now the framework is ready. you can start automating the scripts.


A sample test plan will be like
```

import java.io.IOException;
import org.testng.annotations.Test;
import testPlan.TestPlan;

public class FirstTestPlan extends TestPlan{
	
	@Test
	public void test() throws IOException{
		YahooPage yahooPage=new YahooPage ();
		yahooPage.userName.type("xx");
		yahooPage.password.type("yy");
		yahooPage.submit.click();
	}

}
```

A sample webpage will be like
```
import org.openqa.selenium.By;
import pages.WebPage;
import controls.Button;
import controls.TextField;


public class YahooPage extends WebPage {
	
  public static String Page_URL="http://www.yahoomail.com";
  public TextField userName=new TextField("id=username","User Name Text field");
  public TextField password=new TextField("id=passwd","password text field");
  public Button submit=new Button("id=.save","submit button");

	public YahooPage(){
		super(Page_URL);
	}
}
```
```
The constructor for controls take two arguments 

1. identifier for the control identified in selenium IDE or similar tools 
2. The description for the text field 
```
This description appears in the report when this control is triggered. Report will be generated in test-output folder parallel to src folder and report will opened in the default browser.

easy isn't it?
```
Additional Features
-------------------
1. Mention whether you want screenshot or not in a parameter 'screenshotRequired' in testNG xml
2. Mention the no. of times you want to rerun the failed testcases in the parameter 'retryCount' in TestNG.xml
3. To run the test cases in IE and Chrome, download the driver exe and mention their respective paths as 
parameters 'IEDriverPath','ChromeDriverPath' in testNG xml.
4. Mention the name of the properties file in the parameter "dataFile". Now the constants like error messages, 
labels and success messages in the project can be placed in this property file and can be used in test cases like 
properties.getProperty("args") for verification purpose.
5. Apart from Assert verification points, this framework provides 'verify' verification points. 
The verification points available are 'verifyEquals','verifyTrue','verifyFalse'
```
If you face any problem, get in touch with me to get resolved.