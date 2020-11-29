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

To download pring jar files to eclipse project : 
Goto -> https://repo.spring.io/release/org/springframework/spring/
find the latest version after scrolling down click on the latest release version and download Release-dist.zip file

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



    
    
    




