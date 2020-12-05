# Spring

# To create a new spring project in eclipse :
Open eclipse IDE :
1) Fie-> new > project -> maven -> maven project.
2) To initialiaze the project : select the arch type or quickstart -> Group ID : "com.ayushi"(any name it will create your package name) , ArtifactID is your project name -> Clikc Finish
3) The new project will be created with the maven dependencies which are fetched from remote to your local reprository, when you hover on the name of the dependency 
it will show you the path, where the dependency is lying on your local machine.(.m2 folder is hidden by default , so to see that folder run the command "ls -a" in terminal or click on "show hidden files" checkbox).
4) To download the spring libraries in your project :
Add this dependency in pom.xml file :
```
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
```

As soon as you save : spring dependencies will be downloaded.

# To download spring jar files in  a java project :
1) Goto -> https://repo.spring.io/release/org/springframework/spring/ find the latest version after scrolling down click on the latest release version and download Release-dist.zip file
2) extract the folder and open the lib directory, copy all the jar files.
3) Right click on the project and create new folder with name lib 
4) paste all the jar files in lib folder 
5) Right click on the project again and click on properties
6) Click on java build path 
4) In the Libraries tab click on Add Jar
5) Go to lib folder in your project and select all the jar files and add
6) Click on Apply and Close. 

# Connecting Tomcat with Eclipse
1) If you are not able to see the servers tab in the console window :
	1.1) click on window tab -> SHow View -> Other -> Server -> Click on servers
	1.2) Now you will able to see the server tab in the console window
2) Click on link in  the servers tab
3) Click on Apache 
4) Select Tomcat v0.9, as this is the tomcat version installed in my system
5) To browse the path of tomcat : C/Program Files/ Apache Software Foundation/Tomcat
6) add the path till Tomcat.
7) Click on OK.


# Inversion of Control :
The approach of outsourcing the construction and management of objects

# Spring Container :
### Primary functions 
 1) Create and Manage objects(Inversion of Control)
 2) Inject object's dependencies(dependency injection)
 
### *Configuring Spring Container*
 1) XML configuration file(legacy, but most legacy apps still use this)
 2) Java Annotations(modern)
 3) Java Source Code(modern)
 
What is a Spring Bean?

	A "Spring Bean" is simply a Java object.
	When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".

Spring Beans are created from normal Java classes .... just like Java objects.
 
### Spring Development Process
 1) Configure your spring beans
 2) Create a spring Container
 3) Retrieve Beans from spring container
 
*Configure your spring beans :*
applicationContext.xml
```
<bean id="myCoach"
	class="com.ayushi.spring.BaseballCoach"
</bean>
```
Spring Container is generically known as ApplicationContext
Specialized implementations are :
 1) ClassPathXmlApplicationContext
 2) AnnotationConfigApplicationContext
 3) GenericWebApplicationContext
 4) others...

Using ClassPathXmlApplicationContext:
```
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
```
Retrieve bean from spring container :
```
Coach theCoach = context.getBean("myCoach", Coach.class);
```
**Syntax: context.getBean(beanId, interfaceName that BaseballCoach class implements)**
 
# Dependency Injection :

**Injection Types** 
There are many types of injection with Spring
The 2 most common are :
	1) Constructor Injection
	2) Setter Injection
Autowiring

## Development Process - Constructor Injection
1. Deﬁne the dependency interface and class
2. Create a constructor in your class for injections
3. Conﬁgure the dependency injection in Spring conﬁg ﬁle

Step 1: Define the dependency interface and class
File: FortuneService.java
```
public interface FortuneService { 
	public String getFortune(); 
}
```

File: HappyFortuneService.java
```
public class HappyFortuneService implements FortuneService {
	public String getFortune() { 
		return "Today is your lucky day!"; 
	}
}
```

Step 2: Create a constructor in your class for injections
```
public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService; 
	}
	... 
} 
```
Step 3: Configure the dependency injection in Spring config file
 ```
 <bean id="myFortuneService"  
	class="com.luv2code.springdemo.HappyFortuneService">
 </bean>      
 
 <bean  id="myCoach" 
	class="com.luv2code.springdemo.BaseballCoach">
		<constructor-arg ref="myFortuneService" />
</bean>
```
## Development Process - Setter Injection
1. Create setter method(s) in your class for injections
2. Conﬁgure the dependency injection in Spring conﬁg ﬁle

Step1: Create setter method(s) in your class for injections
File : CricketCoach.java
```
public class CricketCoach implements Coach { 

	private FortuneService fortuneService; 
	public CricketCoach() { } 
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService; 
	}  ... 
} 
```
Step 2: Configure the dependency injection in Spring config file
 File: applicationContext.xml
 ```
 <bean id="myFortuneService"  
	class="com.luv2code.springdemo.HappyFortuneService"> 
 </bean> 
 <bean id="myCricketCoach" 
	class="com.luv2code.springdemo.CricketCoach">
	<property name="fortuneService" ref="myFortuneService" /> 
 </bean>
```
### Injecting Literal Values

Development Process
1. Create setter method(s) in your class for injections
2. Conﬁgure the injection in Spring conﬁg ﬁle

Step1: Create setter method(s) in your class for injections
File:  CricketCoach.java
```
public class CricketCoach implements Coach { 
	private String emailAddress; 
	private String team; 
	
	public void setEmailAddress(String emailAddress) ...
	public void setTeam(String team) ... 
	... 
} 
```
Step 2: Configure the injection in Spring config file
```
    <bean id="myCricketCoach" 
		class="com.luv2code.springdemo.CricketCoach">
		<property name="fortuneService" ref="myFortuneService" />
		<property name="emailAddress" value="thebestcoach@luv2code.com" />
		<property name="team" value="Sunrisers Hyderabad" />
	</bean> 
```

### Injecting literal values from properties file

Development Process
1. Create Properties File
2. Load Properties File in Spring conﬁg ﬁle
3. Reference values from Properties File

Step 1: Create Properties File
File : sport.properties
foo.email=myeasycoach@luv2code.com
foo.team=Royal Challengers Bangalore

Step 2: Load Properties file in Spring config file
File: applicationContext.xml
```
<context:property-placeholder location="classpath:sport.properties"/> 
```
Step 3: Reference Values from Properties File
File: applicationContext.xml
```
<bean id="myCricketCoach" 
	class="com.luv2code.springdemo.CricketCoach"> 
	… 
	<property name="emailAddress" value="${foo.email}" />
    <property name="team" value="${foo.team}" /> 
</bean> 
```
# Spring MVC

### Dependency Injection 
It is a design pattern, that is used to implement Inversion Of Control(IOC), and helps in achieving loose coupling.

### Inversion of control 
https://dzone.com/articles/spring-framework-basics-what-is-inversion-of-contr

**Approach-1**
Have a look at the following implementation of ComplexAlgorithmImpl:
```
public class ComplexAlgorithmImpl {
    BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
    //...
}
```
One of the numerous things that ComplexAlgorithmImpl does is sorting. It creates an instance of BubbleSortAlgorithm directly within its code.

***Approach-2***
Now, look at this implementation for a change:
```
public interface SortAlgorithm {
    public int[] sort(int[] numbers){}
}

@Component
public class ComplexAlgorithmImpl {

    @AutoWired
    private SortAlgorithm sortAlgorithm;
    //...
}
```
ComplexAlgorithmImpl here makes use of the SortAlgorithm interface. It also provides a constructor or a setter method where you can set the SortAlgorithminstance into it. The user tells ComplexAlgorithmImpl, which sort algorithm to make use of.

Comparing Approach-1 and Approach-2
Approach-1
ComplexAlgorithmImpl can only use BubbleSortAlgorithm; it is tightly coupled.
If we need to change ComplexAlgorithmImpl to use quicksort, the relevant code needs to be changed entirely.
The control over the BubbleSortAlgorithm dependency is with the ComplexAlgorithmImpl class.
Approach-2
ComplexAlgorithmImpl is open to using any implementation of SortAlgorithm, it is loosely coupled.
We only need to change the parameter we pass to the constructor or setter of ComplexAlgorithmImpl.
The control over the SortAlgorithm dependency is with the user of ComplexAlgorithmImpl.
Inversion Of Control At Play!
In Approach-1, ComplexAlgorithmImpl is tied to a specific sort algorithm.
In Approach-2, it says: give me any sort algorithm and I will work with it.

This is **Inversion of Control***.



    
    
    




