This is a Java Project to develop a CAS/graphing program for calculus

Guide to syntax for entering one line functions
all functions are assumed to start with f(x) = ...
x is the independent variable, regardless of situation, although it may be representative of any function when graphed

A function is considered a series of elements added together.
To write the function, each element should be seperated from the next by a ";" which takes the place of a +
	ex. [f(x) = ]x^2;x;1
	any empty element ("; ;") will be considered the constant 0
To put two or more functions in parentheses, just write them in parentheses and use ; to split up functions
	ex. [f(x) =](x;e^x);1 --> (x+e^x)+1
To multiply two or more functions, mark them in parentheses, and then indicate a "*" after the first paren
	ex. [f(x) =](*x;e^x);1 --> (xe^x)+1
	ex. [f(x) =](*(x;e^x);2) --> (x+e^x)*2
To divide two or more functions, mark them in parentheses, and then indicate a "/"
	ex. [f(x) =](/x;2;sin(x)) --> x/2/sin(x) or x/2sin(x)
	on a side note, it will divide the first by the second, then that result by the third, etc.
As of right now, trig, log, functions will always be evaluated as func(x) and are written without (x)
	ex. [f(x) =](*sin;tan) --> sin(x)*tan(x)
	ex. [f(x) =](*sin(4x);tan(4x)) --> ERROR
log functions can have any integer number base, written as log[base];
	ex. [f(x) =]log4; --> log base 4 (x) 
