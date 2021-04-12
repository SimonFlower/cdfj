# Software project description

|  |  |
| ------------------------ | ------- |
| Project Name:            | cdfj |
| Main developer(s):       | Jane Exton and Simon Flower  |
| Main user(s):            | Jane Exton and Simon Flower |
| Computer language(s):    | Java |
| Development environment: | Netbeans |
| Build Tool:              | Maven |
| Source Control:          | Git |
| BGS team:                | Geomagnetism |

A pure Java library to read and write NASA CDF data files. The source code for the
library is available from NASA, here:

General downloads page: https://cdf.gsfc.nasa.gov/html/sw_and_docs.html

Download version 3.8: https://spdf.gsfc.nasa.gov/pub/software/cdf/dist/cdf38_0/
(select the file cdf38_0-dist-cdfj_src.tar.gz

Note that a few changes has to be made to the source code comments to prevent
Javadoc errors from terminating the build process.

## Description
Reader and writer for NASA CDF data files. Unlike previous libraries this is pure
Java code and does not need any native shared libraries to work. The code has no
external dependencies, either at compile or run time.


## How to install the compiled product

From the bottom level project directory give the command 'mvn deploy'. This will compile 
the code and then install it to the BGS Artifactory server, from where other projects 
can include it as a dependency. You can find the library under:

    libs-release-local  : gov/nasa/gsfc/spdf/cdfj/3.8
    libs-snapshot-local : gov/nasa/gsfc/spdf/cdfj/3.8
