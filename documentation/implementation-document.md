# Implementation document

## Project structure

Appilcation is divided into three seperate packages. Packages are domain, util and ui for respective areas. The main class of the application is not in any package and it runs first when the application is turned on. Main class's purpose is to start the user interface of the application.

In the ui-package there are class "ui" for the user interface of the application. User interface is a text interface and it works on the command line. The ui class creates instances of other classes that hold the functionality of the application. These kind of instances are made mostly from classes of the util-package. 

There are eight classes in the util-package. Classes of the util-package can be divided in three different categories. First is factory classes of horses, riders and pairs. These three classes automates the creation of the horses, riders and pairs which are used as a parameters of the application's algorithm. Specially factory classes of horses and riders creates horses and riders from the pool of ready made names and values so the user doesn't have to make them. Second type of classes is the calculator class. This class is called "MatchCalculator" and it contains the core algorithms of the application. Third and the last type is the performance testing class called "Tester". This class contains performance tests of the application and can be run from the user interface.

In a domain-package are the descriptiond of the rider, horse and the pair. These are the objects that algorithm in the MatchCalculator-class uses in it's calculations.

## Implemented time and space complexities (big-O complexity analysis of (pseudo)code)
ScoreCalculator class contains O(n) time code because it is mostly if statements. Factory classes are O(n) complexity, because they contain methods that creates multiple riders and horses in a for loop which loops over all the given riders or horses. RandomGenerator class methods works in O(n) time because the methods only contains mathematical procedures. Although I'm not that sure what is the complexity of the System.nanoTime() function. 

In the MatchCalculator class the most slowest methods are the projects two core algorithms, gsAlgortihmFoPairing and calculateAllScores. Time complexity for gsAlgorithmForPairing is n*3§

## Comparative performance and complexity analysis if applicable
TODO

## Possible flaws and improvements
TODO

## Sources
TODO
