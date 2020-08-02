




<!-- PROJECT LOGO -->
<br />
<p align="center">
<img src="https://img.icons8.com/plasticine/400/000000/currency-exchange.png" width="200" height="200"/>
  <h3 align="center">BadiliPesa</h3>

  <p align="center">
    On stop for everything currency conversion!
</p>
<p align="center">Ben Ruwel</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [BDD](#bdd)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project

This is an Android app that gives up-to date info about currency conversion rates. The app allows users to convert currencies using precise data provided by Currency Exchange API by NoCodeAPI.


### Built With
This is program is wholely written in Java and built with
* [Oracle Java 11.8](https://www.oracle.com/java/)
* [Gradle 6.5](https://gradle.org/)
* [Andoid Studio](https://developer.android.com/studio)
* [Espresso 3.2.0](https://developer.android.com/training/testing/espresso)
* [Robolectric 4.2.1](http://robolectric.org/)
* [JUnit 4.12](https://junit.org/junit4/)



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

In order to build this app locally, first make sure you have all the programs listed in [Built with](#built-with). Some can be added as dependencies, please check with the build tool you wish to use.o

### Installation

1. Clone the repo
    ```sh
    $ git clone https://github.com/benruwel/BadiliPesa.git
    ```

2.  Enable gradle to import all the dependencies automatically


## Usage

This app wil require that you have Java and Android setup properly in order to run. Follow this [guide](https://developer.android.com/guide) if this is your first Android app.

To build the project, open your preffered terminal and run the following command:
  ```sh
    $ gradle build
  ```
After the build process is complete, you will have to make a tough decision :) , you can run the App on your Android phone or use in-built Emulator. Both options will be in the drop down menu in the app toolkit on the right of your Android Studio. Use this [guide](https://developer.android.com/training/basics/firstapp/running-app) for more info.

## BDD

* App launches with the Login page being as the main activity, user is enters their username and clicks 'Login' button.

* User is redirected to the currencies activity which displays a welcome text with their username and a recycle list with the supported currencies and their conversion rates to based on the US Dollar by default.

* User clicks the 'Convert' button, they are redirected to the converter activity where they enter the currency wiht amount they want to convert and the currency to be converted to.


## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

My email  - ruwelmwangi@gmail.com

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [Icons8](https://icons8.com/icons)
* [Postman](https://www.postman.com/)
