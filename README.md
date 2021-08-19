# Software project description

|                          |         |
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

## Description

Reader and writer for NASA CDF data files. Unlike previous libraries this is pure
Java code and does not need any native shared libraries to work. The code has no
external dependencies, either at compile or run time.


## Modifications made to the code

A few changes have to be made to the source code comments to prevent
Javadoc errors from terminating the build process.

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


## Using java keystore and trust store with Maven ##

Maven now requires all artifact repositories to be accessed with https.
This in turn needs a suitably configured keystore and truststore.
A keystore and trust store have been included in this project, in the folder
".m2".

The locations and passwords for these stores need to be passed to Maven
as Java system properties. This is dealt with in the project's "pom.xml"
under the "properties-maven-plugin". A number of properties are set which
are needed to configure the Java VM to use the truststore and keystore.
The properties require to environment variables to be set to function
correctly:
- $TRUSTSTORE_PWD - the passphrase for the trust store file
- $KEYSTORE_PWD - the passphrase for the key store file

For GitLab CI these variables must be set in the CI/CD section of
the project's settings. When running from NetBeans or manually from a
command line, the variables must be set before starting Netbeans or running
Maven.


## How to install the compiled product ##

The GitLab CI automatically copies the library to the Geomag Artifactory server.
Instructions are given below for doing this manually. In either case you will need to
set two environment variables in order to allow you to upload files to 
Artifactory:
- $MAVEN_REPO_USER - the username to log in to Artifactory with
- $MAVEN_REPO_PASS - the password to log in to Artifactory with

For GitLab CI these variables must be set in the CI/CD section of
the project's settings. When running from NetBeans or manually from a
command line, the variables must be set before starting Netbeans or running
Maven.

Once these environment variables are set, you can run the Maven deploy
manually as follows: From the bottom level project directory give the 
command 'mvn deploy'. This will compile the code and then install it to 
Artifactory, from where other projects can include it as a dependency. 
You can find the library under:

    libs-release-local  : gov/nasa/gsfc/spdf/cdfj/3.8
    libs-snapshot-local : gov/nasa/gsfc/spdf/cdfj/3.8

NOTE that the deployment to Artifactory may fail if the library has already
been uploaded. In this instance you will need to log in to Artifactory using
a web browser and delete all related files before re-trying the deployment.
