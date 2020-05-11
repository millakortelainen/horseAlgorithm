# Implementation document

## Overview of the overall implementation

The application ended up altering from the project specification. I didn't implement the rider's experience parameter or riding lesson as intended. I'm quite happy how the code turned out. The unit test coverage is also pretty good. The functionality of the application is not as good as I would like it to be.

## Project structure

Application is divided into three separate packages. Packages are domain, util and ui for their respective areas. The main class of the application is not in any package and it starts first when the application is turned on. Main class's purpose is to start the user interface of the application, create instances of classes and give those instances to ui class.

The domain package contains seven classes. Horse and Rider classes are the most significant classes of the package because they represent horses and riders that the application processes. Only thing that seperates horses and riders is that riders have a favoriteHorses array. That is why classes are subclasses of Node class. Also SkillLevel and Type classes are related to Horse and Rider classes. They represent the skill level and type of each entity. SkillLevel and Type classes are quite a mess because they handle at the same time the values of each type and skill level and the specific horse's or rider's type and skill level.

Classes Stack and Pair are also in the domain package. Pair class represents the edges between Horse and Rider nodes. It has weight as a parameter called score. Stack is a data structure handling the riders in Gale Shapley algorithm. It has quite few features as methods. It can add a value to stack, poll a value from stack, check if the stack is empty and for testing I did also a method that tells the size of the stack. Adding and polling works from the last value of the stack. This kind of hybrid stack with three functionalities was enough for Gale Shapley algorithm so I did not make more features to it.

In the ui-package is one class, the UI-class. This class runs the text user interface of the program in the command line. UI-class's method star() is first run when the application is launched.

The main functionalities of the applications are in the util-package. In total package contains eight classes. Three of them are factory classes. These factory classes, called HorseFactory, RiderFactory and PairFactory, handle the creating entities of horses, riders and pairs. Horse and rider factories can make one to multiple random riders and horses automatically. The pair factory only pairs all given horses and riders together. I think that the PairFactory is not named in the best manner.

Besides factory classes there are MatchCalculator classes which contain the two main algorithms of the application, the Gale Shapley algorith and the brute force algorithm. ScoreCalculator calculates the score of the given pair using the given rules. RandomGenerator generates random values for application to use. Mostly these values are used in factory classes. Therefore I decided to use the remainder of System.nanoTime() and not to make any specific random number generator for the application. Simply it was not in the main functionalities of the application and random numbers are used mostly generating objects that application uses.

The FavoriteHorseHandler class handles the favorite horse array of the rider. The Tester class contains the performance tests for the application.

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
`fhh.setFavoritesToRider(p);`.
It calls setFavoritesToRider method from FavoriteHorseHandler class. All the class's methods contains loops. Those loops are single loops so time complexity of the setFavoritesToRider method's time complexity is O(n). In conclusion the time complexity of calculateAllScores method in MatchCalculator class is O(m*n^2). 

In conclusion the time and space complexity of the application is O(m*n^2).

## Comparative performance and complexity analysis
When comparing time complexity of Gale Shapley algorithm and so called brute force algorithm which pairs all the horses with all the riders. If we compare the time complexity we kan see that all pairing algorithm has much larger time complecity with the coefficient m. This is seen in the performance tests. The brute force algorithm stops working in 10 000 horss and riders each and the Gale Shapley algorithm still can give pairs to all riders. 

In charts we can also conclude that pairing all the horses and riders is much slower than Gale Shapley algorithm. 

The result is expected. Pairing all the horses and the riders takes n*m iterations becaus that is how many pairs one can make from n amount of horses and m amount of riders. The Gale Shapley algorithm does not go through all the possible pairings but in fact pairs riders with optimal horse. This needs approximately n amount of iterations where n is amount of riders. Only in the worst case where rider can't get horse from her favorite horses list we need to go through the free horse list and couple more iterations are added to time complexity. This makes Gale Shapley much more faster and intuitively one may think that it assigns horses to smaller audience which is in this case the riders only.

## Possible flaws and improvements
Actually the performance tests are not very accurate in terms of application real use case. In real use case first all the riders and horses must be paired before using the Gale Shapley algorithm. This is not the test case in the performance tests. Performance test does not pair the horses and riders before using the Gale Shapley algorithm. This mean that it does not make "happy couples" as mentioned in Gale Shapley Wikipedia page.

## Sources
TODO
