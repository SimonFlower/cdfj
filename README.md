# Software project description

| <!--              -->    | <!-- -->    |
|--------------------------|-------------|
| Project Name:            | cdfj |
| Main developer(s):       | Jane Exton and Simon Flower  |
| Main user(s):            | Jane Exton and Simon Flower |
| Computer language(s):    | Java |
| Development environment: | Netbeans |
| Build Tool:              | Maven |
| Source Control:          | Git |
| BGS team:                | Geomagnetism |

A pure Java library to read and write NASA CDF data files. The source code for the
library is available from GITHub, here: https://github.com/autoplot/cdfj

## Description

Reader and writer for NASA CDF data files. Unlike previous libraries this is pure
Java code and does not need any native shared libraries to work. The code has no
external dependencies, either at compile or run time.


## Modifications made to the code

A few changes have to be made to the source code comments to prevent
Javadoc errors from terminating the build process.

### Tests ###

Test code was written to investigate how the pure Java CDF library works,
since no example code is provided with the library. The functions used
in the test make use of all aspects of the CDF library needed for the
BGS Intermagnet CDF library code

### Leap Seconds ###

New code was introduced in gov.nasa.gsfc.spdf.cdfj.TimeUtil to access a
local file that contains details of leap seconds. However this code could
not be made to replicate the leap second behaviour of the CDF JNI library,
and so has been left in as commented out code.

In the original source code the leap second data is embedded in the code, with 
a commented out section of code showing how to access the leap second table at 
https://hpiers.obspm.fr/eoppc/bul/bulc/UTC-TAI.history. The new code uses the
embedded leap second table unless the environment variable or system property
CDF_LEAPSECONDSTABLE is set, in which case the code attempts to load data from 
the file specified in the variable/property. The file is in
the standard CDF format for leap seconds and can be obtained from here:
https://cdf.gsfc.nasa.gov/html/CDFLeapSeconds.txt

A leap second file has been added to the library and is copied to the location
specified by $CDF_LEAPSECONDSTABLE if the file does not already exist.

