# Project specification

The horse algorithm is an algorithm that matches riders and horses together. Matching is made by following parameters

* skill level

Every horse and rider has a skill level between 1 - 5. Every rider can be matched with a horse that has higher or equal skill level than the rider.

* height

Horse's and rider's height difference should be less than 20 cm.

* type of lesson

Riding lesson's type can be either jumping, dressage or children's lesson. Different horses are good for different types of lessons.

* experience

Riders gather experience points when they participate in the lesson. Experience points are defined by how well the riding went. Quality of the riding lesson is dependent of two values. First value is how good the matching was and the second value is how well the horse behaved. The latter value is based on horse's behaving number which is a probability of horse's bad day.


Initially the problem is same as the stable marriage problem. Although there is no true randomness between chosing the favourite partners. 

## What data structures and algorithms will you be using?

Horses and riders will be defined as classes. The relation between horses and riders is structured as a directed weigthed graph where verticies are horses and riders and edges represent three favourite partners for horses and riders. 

## What problem are you solving and why did you chose these specific data structures and algorithms?

## What is the program input and how will it be used?

## Expected time and space complexities of the program (big-O notations)

## Source

* [Stable Marriage Problem, Wikipedia, Read: 14.3.2020](https://en.wikipedia.org/wiki/Stable_marriage_problem)