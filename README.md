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
as Java system properties. When running Maven under GitLab, this is dealt
with using the $MAVEN_TLS_OPTS variable, which contains command line
arguments for Maven. These command line arguments reference two variables
which contain passphrases to open the keystore and truststore files:
- $TRUSTSTORE_PWD - the passphrase for the trust store file
- $KEYSTORE_PWD - the passphrase for the key store file
These variables should be created in the CI/CD section of the project's 
settings on GitLab.

When running the project under Netbeans, the IDE should automatically
import the needed certificates for you. When prompted by a dialog, select
the option to allow Netbeans to download certificates (Netbeans 8 shows
a dialog for each certificate that needs to be downloaded).


## How to install the compiled product ##

The GitLab CI automatically copies the library to the Geomag Artifactory server.
To use this CI, you will need to set two variables which the CI requires:
- $MAVEN_REPO_USER - the username to log in to Artifactory with
- $MAVEN_REPO_PASS - the password to log in to Artifactory with

These variables must be set in the CI/CD section of the project's settings
on GitLab. 

The preferred method to deploy the project to Artifactory is to use GitLab
If you need to deploy the project from your own computer, you will need
a command line session where Maven is available on the path and the current
directory is set to the root directory of this project. From this shell
type:

```
mvn $MAVEN_CLI_OPTS $MAVEN_OPTS $MAVEN_TLS_OPTS package deploy
```

Where the values of $MAVEN_CLI_OPTS, $MAVEN_OPTS and $MAVEN_TLS_OPTS
are taken from the variables in the .gitlab-ci.yml file (with any $variables
in the .gitlab-ci.yml variables subsituted by their values as found in the
GitLab CI/CD settings).

Once the library has been deployed to Artifactory other projects can include it 
as a dependency. You can find the library under:

    libs-release-local  : gov/nasa/gsfc/spdf/cdfj/3.8
    libs-snapshot-local : gov/nasa/gsfc/spdf/cdfj/3.8

NOTE that the deployment to Artifactory may fail if the library has already
been uploaded. In this instance you will need to log in to Artifactory using
a web browser and delete all related files before re-trying the deployment.
