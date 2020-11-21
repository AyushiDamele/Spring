# Spring

# To create a new spring project in eclipse :
Open eclipse IDE :
1) Fie-> new > project -> maven -> maven project.
2) To initialiaze the project : select the arch type or quickstart -> Group ID : "com.ayushi"(any name it will create your package name) , ArtifactID is your project name -> Clikc Finish
3) The new project will be created with the maven dependencies which are fetched from remote to your local reprository, when you hover on the name of the dependency 
it will show you the path, where the dependency is lying on your local machine.(.m2 folder is hidden by default , so to see that folder run the command "ls -a" in terminal or click on "show hidden files" checkbox).
4) To download the spring libraries in your project :
Add this dependency in pom.xml file :
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>

As soon as you save : spring dependencies will be downloaded.


