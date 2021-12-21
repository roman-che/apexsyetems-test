<h2 align="center">Test automation project for <a href="https://www.apexsystems.com/">Apex syetems</a> website</h1>

### Technology stack
<p  align="center">
<img width="5%" title="IntelliJ IDEA" src="img/logo/IDEA-logo.svg">
<img width="5%" title="Java" src="img/logo/java-logo.svg">
<img width="5%" title="Selenide" src="img/logo/selenide-logo.svg">
<img width="5%" title="Selenoid" src="img/logo/selenoid-logo.svg">
<img width="5%" title="Gradle" src="img/logo/gradle-logo.svg ">
<img width="5%" title="JUnit5" src="img/logo/junit5-logo.svg">
<img width="5%" title="Allure Report" src="img/logo/allure-Report-logo.svg">
<img width="5%" title="Allure TestOps" src="img/logo/allure-ee-logo.svg">
<img width="5%" title="Github" src="img/logo/git-logo.svg">
<img width="5%" title="Jenkins" src="img/logo/jenkins-logo.svg">
<img width="5%" title="Jira" src="img/logo/jira-logo.svg">
<img width="5%" title="Telegram" src="img/logo/Telegram.svg">
</p>

### The list of testsm grouped by tags

<details>
<summary>website - page tests:</summary>

+ Menu has at least one toggler element
+ The footer of "What we do" page contains specified text
+ Page title contains specified text
+ Skipped (disabled) test for further development

</details>

<details>
<summary>website - console tests:</summary>

+ Console log contains no errors
+ Console log contains no warnings

</details>

___

## Run tests from terminal locally

### Running tests with declared remote properties:

```bash
gradle clean test
```
### Running tests in parametrized build:

```bash
gradle clean
test
-Dtag=${tag}
-Denvironment=${ENVIRONMENT}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView=${BROWSER_MOBILE}
-DURL=${REMOTE_DRIVER_URL}
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

<details>
<summary>Parameters description</summary>

+ tag — the list of tests, grouped by a tag parameter
+ environment — environment that runs the build (`prod` — production (defalut value) or `dev` — staging for development)
+ browser — browser to run tests in (`chrome` by default, `opera`, `firefox`, `safari`)
+ browserVersion — version off the selected browser (`91.0` by default)
+ URL — address of build running remote browser server (`selenoid.autotests.cloud` by default)
+ videoStorage — address of video storage server (`selenoid.autotests.cloud/video/` by default)
+ threads — number of threads to run the tests (`5` by default)
</details>

