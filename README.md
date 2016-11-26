## Description

This is a simple fire click-and-drag fire simulator built in Java using the [StdDraw](http://introcs.cs.princeton.edu/15inout) class for graphics. Simulates how a fire spreads from specific locations on a 40 x 40 grid. 

## Getting Started


###Installation
- Navigate to *src* folder `cd src`
- Compile using *javac* `javac Init.java`

###Running
- In order to run use *java* to run *Init* class `java Init {args}`
    - Example with default arguments `java Init -ws .9 -wd 45 -dl .5`
- Opens graphics window with grid
- Click and drag on specific cells in order to start fire
- When complete will print 'Total Percent Burned' in command line

###Command Line Arguments (Optional)
- `-h` help
- `-ws` windSpeed(0 - 1)	default: .9
- `-wd` windDirection(degrees)	default: 45
- `-dl` drynessLevel(0 - 1)	default: .5