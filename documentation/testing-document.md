
# Testing document
    
## What has been tested and how

The application is unit tested by JUnit.

![jacocoTestRepoort](documentation/img/3.png "Jacoco test report")

The performance of the application is tested in the class called "Tester.java". The performance tests use Java function System.nanotime() to conclude the duration of opertaion of the algorithms. The Gale-Shapley algorithm is tested 50 times with parameters of 10, 100, 1 000, 10 000 and 100 000 pairs of horses and riders. Then the average of these runs is calculated to determine the performance of the algorithm.

## What types of input were used

The input for the Gale-Shapely algorithm is generated using the HorseFactory and RiderFactory classes. With these classes n riders and horses are generated and then given to the algorithm for processing.

## How can the tests be repeated

When the application is build with command line command "gradle build" then the unit tests of the application can be executed from the command line with command "gradle test".

The performance test of the application can be repeated by starting the application from the command line with command "gradle run". Then after providing the amount of horses and riders from the user interface can be selected the option "5". This command runs the performance tests. 

## Results of empirical testing presented in graphical form
    
