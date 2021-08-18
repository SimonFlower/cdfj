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

## Modifications made to the code

A few changes have to be made to the source code comments to prevent
Javadoc errors from terminating the build process.

New code has been introduced in gov.nasa.gsfc.spdf.cdfj.TimeUtil to access a
local file that contains details of leap seconds. In the original source code
the leap second data is embedded in the code, with a commented out section of
code showing how to access the leap second table at 
https://hpiers.obspm.fr/eoppc/bul/bulc/UTC-TAI.history. The new code uses the
embedded leap second table unless the environment variable or system property
CDF_LEAPSECONDSTABLE is set, in which case the code attempts to load data from 
the file specified in the variable/property. The file is in
the standard CDF format for leap seconds and can be obtained from here:

https://cdf.gsfc.nasa.gov/html/CDFLeapSeconds.txt


A leap second file has been added to the library and is copied to the location
specified by $CDF_LEAPSECONDSTABLE if the file does not already exist.

## Description
Reader and writer for NASA CDF data files. Unlike previous libraries this is pure
Java code and does not need any native shared libraries to work. The code has no
external dependencies, either at compile or run time.

## Using java keystore and trust store with maven
maven now requires all artifact repositories to be accessed with https
this in turn needs a suitably configured keystore and truststore,
the locations and passwords for these need to be passed as maven command line options
or via the environment variable MAVEN_OPTS
A keystore and trust store are included in this project. 
The .gilab-ci file contains the maven options required and the passwords can be found
in this projects GitLab CI/CD Variables 


## How to install the compiled product

From the bottom level project directory give the command 'mvn deploy'. This will compile 
the code and then install it to the BGS Artifactory server, from where other projects 
can include it as a dependency. You can find the library under:

    libs-release-local  : gov/nasa/gsfc/spdf/cdfj/3.8
    libs-snapshot-local : gov/nasa/gsfc/spdf/cdfj/3.8
