
# Week 3 report


  ## What have you done this week?

I started implementing (the Gale-Shapley algorithm)[https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm]. This led me to change the generic type of Pair-object as a typed object and creation of rider's favorite horses. 
    
 ## How has the project progressed?

Unfortunately my time was very limited this week and the project itself progressed little but I didn't have time to make any tests for it. Core functionalities are progressing because I started implementing the main algorithm that I will use in the program.

## What did you learn this week / today?

I learned how implementing algorithm is not as easy as just reading the description and implementing it. There is some desicions to make when one is applying the algorithm. I had little pondering which data structures to use so that they are fast and easy enough to implement. Making the Gale-Shapley algorithm led me to switch the Pair-data structure and create the id number for horses and riders because the graph is easier to handle with these parameters. I found it enlightening to noticing that applying an algorithm makes an snowball effect and creates small little problems to the development.

I found out that I can't avoid all the slow stuff. The time complexity of the Gale-Shapley algorithm is O(n^2) and even before using the algorithm I have to pair all the horses to all the riders once. This function also has O(n^2) complexity. Even if the overall time complexity doesn't increase I feel uncomfortable pairing all horses to all riders because this feels slow.

##  What has been inclear or problematic? 
Everything is going well.

## What next?
Rider's favorite list needs fixing. Now it lists same horses. I should finish the Gale-Shapley algorithm. After I finish these I start making the experience variable for rider which I didn't start this week.
## Hours used

Past week I have worked total 5 hours with this project.
