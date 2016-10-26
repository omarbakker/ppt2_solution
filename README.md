CPEN 221 / Fall 2016
Programming Proficiency Test
=========

October 26, 2016

## General Instructions

+ There are two questions that you need to complete.
+ You have 128 minutes (2h 8m) to complete the tasks.
+ You will start at 5:12 p.m. and finish by 7:20 p.m.
+ We will start cloning repositories at **7:25 p.m.** so you should have committed all your work to Github by that time (see submission instructions below).
+ Take your time to read the questions.
+ Skeleton code can be obtained by cloning this repository. Add JUnit to your build path in Eclipse.
+ Best of luck!

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for your.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _I would recommend that you get your Git and Github workflow set up at the start._

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person in completing the examination.
+ You did not aid any other person in the class in completing their examination.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.

> Violations of this honour code will be treated as a case of academic misconduct and will dealt with under UBC policies governing such issues. A consequence of this may be to nullify this exam for everyone that submits work for grading!

## Question 1: The Beacons of Gondor

> The skeleton source code for this question is in the package `beaconsOfGondor`. You have to implement the methods `getGoodLocations` in the class `LocateMinasTirith`.

In a different universe, on a planet called Middle Earth, the Queen of Gondor wants to find the a suitable location for her capital city.

There are many cities in the kingdom, and they are connected by the Numenorian Roads. These roads do not obey the physical laws of our universe. So, if a road exists between cities A and B, and a road exists between cities C and D, then it takes the same amount of time to get to A from B (or vice versa) as it would take to go from C to D (or vice versa).

The Queen would however like to select the capital city, let us call this city MT. Let X be the city that takes the longest time to travel to from MT. The Queen wants to minimize the time it takes to reach X. In some sense, the Queen wants a **central** location.

To make the requirement more precise, let us start with _N_ cities, _X[0], ..., X[N-1]_. Suppose we selected city _X[i]_ as the capital then let _t(X[i])_ be the maximum time it takes to travel from _X[i]_ to any of the other cities. The goal is to select _X[i]_ such that _t(X[i]) <= t(X[j])_ for all _j_ in _0 .. N-1_.

It is possible that more than one city meets this requirement so we want to identify the set of such cities. Then the Queen can use other criteria to locate the capital.

You are provided the road network information as a (potentially long) string, `roadNetwork`, and the number of cities, `n`. For `0 <= i < n` and `0 <= j < n`, the character at position `n*i+j` in the string tells us if there is a road from city _X[i]_ to city _X[j]_. There is a `1` in that position if there is a road and a `0` otherwise. You may assume that there is always a road from _X[i]_ to itself and that `n*i+i` is always a `1`.

You want to use this information and determine the set of potential locations for the capital. You are to return a set of integers that contains the indices of the cities that are suitable.

**The preconditions for the method you have to implement are stated in the skeleton source code.**

### Examples

+ `roadNetwork = "1"` and `n=1`.
	+ Returns: a set with 0.
+ `roadNetwork = "1111"` and `n=2`
	+ Returns: a set with 0 and 1.
+ `roadNetwork = "111111111"` and `n=3`
	+ Returns: a set with 0, 1, and 2.
+ `roadNetwork = "111110101"` and `n=3`
	+ Returns: a set with 0.
	+ One can reach all cities in one step from City 0, but we would need two steps to go from City 1 to City 2 or from City 2 to City 1. The maximum travel time from City 0 to every part of the kingdom is only 1 step, whereas the maximum travel time from the other cities is 2 steps.
+ `roadNetwork = "1101 1111 0111 1111".replaceAll("\\s","")` and `n=4`
	+ Returns: a set with 1 and 3.
	+ One can reach every city in one step from Cities 1 and 3. From City 0, one can reach City 2 in two steps (either via City 1 or City 3), and the same is true for City 2 (in terms of reaching City 0).
+ `roadNetwork = "11100 11100 11111 00111 00111".replaceAll("\\s","")` and `n=5`
	+ Returns: a set with 2.
	+ One can reach every other city in one step from City 2.
+ `roadNetwork = "10101 01110 11110 01111 10011".replaceAll("\\s","")` and `n=5`
	+ Returns: a set with 0, 1, 2, 3 and 4.
	+ The maximum travel time from every city is 2 steps. So all cities are equally "central".

## Go Ahead, Make That a Fibonacci Number

> The skeleton source code for this question is in the package `fibonacciTransform`. You have to implement the methods `isPossible_onlyOneDoubling` and `isPossible` in the class `FibTransform`.

You are given an integer `n` and you want to determine if it is possible to transform `n` to a Fibonacci number in at most `m` steps, where `m` is also a given bound. At each step, you can:
* add 1 to the number at hand (addition step),
* or multiply it by 2 (doubling step).

Implement two methods:

1. The first method, `isPossible_onlyOneDoubling`, where you check if `n` can be transformed into a Fibonacci number using *at most* one doubling step and any number of addition steps. The number of steps permitted is at most `m`. The doubling does not have to be the first or last step (see the examples). **If you complete only this method correctly then you will receive partial credit of 50% for this question.**

2. The second method, `isPossible`, generalizes the earlier method to permit any number of `+ 1` or `* 2` operations as long as the total number of operations is no more than `m`.

See the skeleton code for preconditions for these methods. We are only interested in Fibonacci numbers that can be represented using the Java types `Integer` or `int`.

For this implementation, we will consider the Fibonacci sequence to be 0, 1, 1, 2, 3, 5, 8, 13, 21, ...

### Examples

+ `n` = 10, `m` = 3
	+ One can obtain 21 as follows: `(10 * 2)+1`.
	+ Both `isPossible_onlyOneDoubling(10, 3)` and `isPossible(10,3)` should return `true`.
+ `n` = 22, `m` = 3
	+ One can obtain 89 as follows: `((22*2)*2)+1`
	+ `isPossible_onlyOneDoubling(22, 3)` should return `false` and `isPossible(22, 3)` should return `true`.
+ `n` = 6, `m` = 2
	+ We can obtain 8 as: `(6+1)+1`.
	+ Both `isPossible_onlyOneDoubling(6, 2)` and `isPossible(6, 2)` should return `true`.
+ `n` = 8, `m` = 10
	+ 8 is already a Fibonacci number. No transformation steps are needed.
	+ Both `isPossible_onlyOneDoubling(8,10)` and `isPossible(8,10)` should return `true`.
+ `n` = 0, `m` = 0
	+ 0 is already a Fibonacci number for our purposes. No transformation steps are needed.
	+ Both `isPossible_onlyOneDoubling(0, 0)` and `isPossible(0, 0)` should return `true`.
+ `n` = 20, `m` = 0
	+ 20 is not a Fibonacci number. We cannot transform it into a Fibonacci number in 0 steps.
	+ Both `isPossible_onlyOneDoubling(0, 0)` and `isPossible(0, 0)` should return `false`.
+ `n` = 24, `m` = 6.
	+ 24 can be transformed to 55: `((((24+1)+1)+1)*2)+1`.
	+ Both `isPossible_onlyOneDoubling(24, 6)` and `isPossible(24, 6)` should return `true`.
+ `n` = 1000, `m` = 18.
	+ 1000 can be transformed to 514229 in 18 steps with more than one doubling.
	+ `isPossible_onlyOneDoubling(1000, 18)` should return `false` and `isPossible(1000, 18)` should return `true`.

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.
+ **You will receive no credit if any part of your submission fails to compile.** Make sure that you only use standard Java libraries (your import statements should only use libraries that begin with `java.`; for example `import java.util.Set` is fine).

## Answers to FAQs

#### Can I consult Java documentation and other Internet-based sources?

Yes, you can. The point of this test is not to demonstrate mastery over syntax but that you can solve a problem in a reasonable amount of time with reasonable resources.

*If you find useful information online outside the official Java documentation and the course material, you must cite the source. You should do so by adding comments in your source code.*

Naturally you are expected to adhere to all of the course and UBC policies on academic integrity.

#### Isn't two hours too short to produce working implementations?

The questions are straightforward, and these are not very different from what one might sometimes encounter on a job interview (for example). The difference is that you get less time during an interview (10-15 minutes) with no access to additional resources. So the time allotted is reasonable in that regard and I am expecting that most of you will be clear this bar. And you will have to keep working until you clear this bar. The goal is that it is possible to say, at a minimal level, what everyone who completes this course can achieve.

#### Why am I not guaranteed full credit if my implementation passes all the provided tests?

It is easy to develop an implementation that passes the provided tests and not much else. A good-faith implementation that passes all the provided tests is very likely to pass other tests too.
