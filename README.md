# Kotlin example for FastReport Cloud SDK

## Overview

This example shows how to generate a PDF file using the [ FastReport Cloud ](https://fastreport.cloud/en/) service

## How to build an example
_______________________________________
### Connecting the FastReport Cloud SDK

You must connect [ FastReports Cloud Java SDK ](https://github.com/FastReports/FastReport-Cloud-Java) for working with this example

#### Installation

Tools:

1. [Java 1.8+](https://www.oracle.com/java/technologies/javase-downloads.html)
2. [Maven](https://maven.apache.org/download.cgi)/[Gradle](https://gradle.org/releases/)

To install the API client library to your local Maven repository, simply execute:

*You should complete these steps in the folder with the downloaded project*
```
git clone https://github.com/FastReports/FastReport-Cloud-Java.git 
cd FastReport-Cloud-Java
mvn clean install
```
#### Maven users
Add this dependency to your project's POM:

```kotlin
<dependency>
  <groupId>cloud.fastreport.sdk</groupId>
  <artifactId>fastreport-cloud-sdk</artifactId>
  <version>2021.2.13</version>
  <scope>compile</scope>
</dependency>
````
#### Gradle users
Add this dependency to your project's build file:
```kotlin
compile ("cloud.fastreport.sdk:fastreport-cloud-sdk:2021.2.13")
```
______________________________

### Change the API key
To work with the service you need an API key. You can get it from the owners of the service, or generate it yourself in the control panel.
Then you should change the `apiKey` constant in the source code of the example in the `App.kt` file.
______________________________

### Execution

Launch `App.kt` and run in IDE,then your IDE will convert the `Box.frx` file to `PDF`
_____________


## Documentation

- [FastReport Cloud Java SDK documentation](https://github.com/FastReports/FastReport-Cloud-Java/blob/main/README.md)
- [REST API](https://fastreport.cloud/en/docs/guides/rest_api)
- [FastReport documentation](https://fastreport.cloud/en/docs/index)

## Support

Contact us with any questions using our [website](https://www.fast-report.com/en/support/) or [GitHub issues](https://github.com/FastReports/FastReport-Cloud/issues).

## Useful links
[ FastReports Cloud Java SDK ](https://github.com/FastReports/FastReport-Cloud-Java)

[FastReport Cloud home site](https://fastreport.cloud/en/)

[FastReport Designer Community Edition](https://github.com/FastReports/FastReport/releases)
































































