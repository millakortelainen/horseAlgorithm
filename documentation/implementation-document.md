# Implementation document

## Project structure

Appilcation is divided into three seperate packages. Packages are domain, util and ui for respective areas. The main class of the application is not in any package and it runs first when the application is turned on. Main class's purpose is to start the user interface of the application.

In the ui-package there are class "ui" for the user interface of the application. User interface is a text interface and it works on the command line. The ui class creates instances of other classes that hold the functionality of the application. These kind of instances are made mostly from classes of the util-package. 

There are eight classes in the util-package. Classes of the util-package can be divided in three different categories. First is factory classes of horses, riders and pairs. These three classes automates the creation of the horses, riders and pairs which are used as a parameters of the application's algorithm. Specially factory classes of horses and riders creates horses and riders from the pool of ready made names and values so the user doesn't have to make them. Second type of classes is the calculator class. This class is called "MatchCalculator" and it contains the core algorithms of the application. Third and the last type is the performance testing class called "Tester". This class contains performance tests of the application and can be run from the user interface.

In a domain-package are the descriptiond of the rider, horse and the pair. These are the objects that algorithm in the MatchCalculator-class uses in it's calculations.

## Implemented time and space complexities (big-O complexity analysis of (pseudo)code)
ScoreCalculator class contains O(n) time code because it is mostly if statements. Factory classes are O(n) complexity, because they contain methods that creates multiple riders and horses in a for loop which loops over all the given riders or horses. RandomGenerator class methods works in O(n) time because the methods only contains mathematical procedures. Although I'm not that sure what is the complexity of the System.nanoTime() function. 

Estimating the MatchCalculator's main methods i.e. gsAlgorithmForPairing is little tricky for me. The while-loop which processes the riders defines the complexity of the method.
```
while(!freeRiders.isEmpty()){
..
}
```
The problem here is the freeRider stack where values are added back once removed, so the amount of n is flexible. I would estimate that complexity of that while loop is O(n) anyways. I'm not sure that what n is here. Inside the while loop is also a for loop. Complexity of that loop is O(n).
```
while(!freeRiders.isEmpty()){
..
for(int i = 0; i<horseRider.length;i++){
    ...
    }
}
```
Because the two loops are nested my time complexity approximation of gsAlgorithmForPairing-method is O(n^2). 

Second important method of MatchCalculator class is calculateAllScores method. First there is for loop wich goes through all the pairs in the list. The pairs here are all the riders paired with the all the horses. Therefore the for loop goes through n*m values where n=number of horses and m=number of riders. Also inside the method is calls for other classes. two first are quite straight forward setter and ScoreCalculator call which I already covered. Method that I have not covered is
```
fhh.setFavoritesToRider(p);.
```
It calls setFavoritesToRider method from FavoriteHorseHandler class. All the class's methods contains loops. Those loops are single loops so time complexity of the setFavoritesToRider method's time complexity is O(n). In conclusion the time complexity of calculateAllScores method in MatchCalculator class is O(m*n^2). 

## Comparative performance and complexity analysis
When comparing time complexity of Gale Shapley algorithm and so called brute force algorithm which pairs all the horses with all the riders. If we compare the time complexity we kan see that all pairing algorithm has much larger time complecity with the coefficient m. This is seen in the performance tests. The brute force algorithm stops working in 10 000 horss and riders each and the Gale Shapley algorithm still can give pairs to all riders. 

In charts we can also conclude that pairing all the horses and riders is much slower than Gale Shapley algorithm. 

The result is expected. Pairing all the horses and the riders takes n*m iterations becaus that is how many pairs one can make from n amount of horses and m amount of riders. The Gale Shapley algorithm does not go through all the possible pairings but in fact pairs riders with optimal horse. This needs approximately n amount of iterations where n is amount of riders. Only in the worst case where rider can't get horse from her favorite horses list we need to go through the free horse list and couple more iterations are added to time complexity. This makes Gale Shapley much more faster and intuitively one may think that it assigns horses to smaller audience which is in this case the riders only.

## Possible flaws and improvements
Actually the performance tests are not very accurate in terms of application real use case. In real use case first all the riders and horses must be paired before using the Gale Shapley algorithm. This is not the test case in the performance tests. Performance test does not pair the horses and riders before using the Gale Shapley algorithm. This mean that it does not make "happy couples" as mentioned in Gale Shapley Wikipeida page.

## Sources
TODO
