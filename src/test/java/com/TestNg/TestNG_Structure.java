package com.TestNg;

public class TestNG_Structure {/* TestNG is a framework inspired from j-unit, Having new functionalities makes more powerful
	                       and easy to use, Separate compile time test code from runtime configuration.
	                       
	                       Structure
	                      1.Single Annotation:       ->Dependency version 7.6.1
	                       @BeforeSuite
	                       @BeforeTest
	                       @BeforeClass
	                       @BeforeMethod
	                       @Test
	                       subMethod
	                       @AfterMethod
	                       @AfterClass
	                       @AfterTest
	                       @AfterSuite
	                    
	                      2.Ignore Test(Enable/Exclude)
	                      >>@Test@Ignore
	                      >>@Test(enabled=false)
	                       
	                      3.Priority based Test 
	                      >>If no Priority is mentioned or given==0 priority is taken as default.
	                      >>If 2 methods have same priority, priority is taken based on ASCII value.
	                      >> Priority is from(-value to +value) >>EG.(-1,0,1).
	                      
	                      4.Group Test
	                      >>A group is a set of methods [@Test(groups="groupName")]
	                      >> .XML
	                          <suite name="Suite">
	                  <test thread-count="5" name="Test">
	                   <groups>                       --------> for group Testing 
	      				<run>
	       				 <include name="Harish"/> -> group Name(included)
	       				 <exclude name="HP"/>-----------------> group Name(excluded)
	       				</run>
	       				 </groups>
	       				<classes>
	       				 <class name="TestNg.TestNg">
	      				 </class>
	    				</classes>
	   					</test> <!-- Test -->
	 				  </suite> <!-- Suite -->
	 				  
	 				    (4.1 Groups of Groups)
	 				     >>@Test(groups="groupName")
	 				  <suite name="Suite">
  						<test thread-count="5" name="Test">
    						<groups>
      						<define name ="both">
      						<include name="Harish"/>  
      						<include name="HP"/>
     						</define>
     							<run>
     							<include name ="both"/>
     							</run>
    						</groups>
      						<classes>
      						<class name="TestNg.TestNg">
      							</class>
    							</classes>
  								</test> <!-- Test -->
								</suite> <!-- Suite -->
	 				  (4.2 Method Testing)
	 				  >>>[method testing (include,exclude)]
	
					<suite name ="Suite">
	 				<test thread-count="5" name="Test">
	 				<classes>
	 				<class name= "packagename.classname">
	 				<methods>                       -------> 
	 				<exclude name = "method name"/>
	 				</methods>
	 				</class>
	 				</classes>
	 				</test>
	 				</suite> 
	 				 
	                 5. dependsOnMethods
	                 >>@Test(dependsOnMethods="methodName")
	                 
	                 6.IncovationCount
	                 >>@Test(invocationCount=1)---> number of times to be executed.......
	                 
	                 7. Exception 
	                 >> @Test(expectedExceptions=NullpointerException.class)
	                 >> Only If the given exception is correct the test case will pass or else it fails.
	                 
	                 7.timeOut
	                 >> @Test(timeOut=1000)
	                 >> The given second in timeout is fixed.
	                 
	                 8.dependOnGroups
	                 >> @Test(dependOnGroups="groupName")
	                 
	                 9. Parameterized test
	                 >> Single Paramaterized 
	          public class ParametersData {
@Test	
@Parameters("colour")
public void colourName(String colour) {
	System.out.println("fav color:" + colour);
	
}
@Test
@Parameters("Likeyou")
public void like(String Likeyou) {
	System.out.println("likable"+ Likeyou);
}
}
-----------------------------------------
<suite name="Suite">
  <test thread-count="5" name="Test">
  <parameter name="colour" value="Blue"/>
  <parameter name="Likeyou" value="yes"/>
    <classes>
      <class name="com.testNG.ParametersData"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
----------------------------------------------------------------------------------------

>> Multiparameterized 
public class ParametersData {
@Test	
@Parameters({"colour","Pet"})
public void colourName(String colour,String Pet) {
	System.out.println(colour +"="+ Pet);
	
}
---------------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test">
  <parameter name="colour" value="White"/>
  <parameter name="Pet" value="Lab"/>
    <classes>
      <class name="com.testNG.ParametersData"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

      ================
>>DataProvider

public class ParametersData {
	@DataProvider(name="HeyLove")
public Object[][] data(){
	return new Object[][] {{"Puvi","24"},{"Lucky","1"},{"deepak","23"},{"priyo","18"}};
}
	@Test(dataProvider = "HeyLove")
	public void nameAge(String name,String age) {
		System.out.println(name+"="+ age);
	}
}
----------------------------------------------------------------------------
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
      <class name="com.testNG.ParametersData"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
output:
=======
Puvi=24
Lucky=1
deepak=23
priyo=18      
    
    RetryAnalyzer
==============
public class iretry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count =0;
		int limit=4;
		if(count<limit) {
			count++;
			return true;
		}
		return false;
	}
}
-----------------------------------------------------

public class Reanalysis {
	@Test(retryAnalyzer = iretry.class)
public void method() {
	System.out.println("puvi");
	Assert.assertEquals("puvi", "puvi");//actual,expected
}
}
output:
puvi
PASSED: method
                            */


}
