# SQATestSelenium

## Requirements
1. **Java** installed on the system
2. Java added to the path
3. **JDK**
4. **Maven** installed to the system and added to the path in environment variables
5. An IDE like **IntelliJ** or **Eclipse**
6. **Allure** installed and added to the environment variables
7. Project cloned into your PC

## How to run the project
1. Open the code in any of the IDE you have
2. Install the plugins required such as the Cucumber for Java plugin (File > settings > Plugins > Search for **"Cucumber for Java"**)
3. On the terminal run the following commands **"mvn clean"** and **"mvn install"**
5. Go to the runner file
6. Right-click on the file and click on Run **'Test Runner'**
7. To generate the allure report, on the terminal run the following commands **"mvn allure:report"**
8. To view the generated allure report in the browser, run the following command **"mvn allure:serve"**

## Test Cases covered
Following are the test cases covered in the project
1. **Login with valid credentials**
2. **Login with invalid credentials**
3. **Add products to the cart**
4. **Remove the product from the cart**
5. **Filter products**
6. **Go to the cart and checkout**
7. **Complete the checkout flow**
8. **Logout the user**

## How to run the above test cases
You can run the above test cases individually by replacing the value of tags in the **Test Runner** file
1. @successfulLogin
2. @failedLogin
3. @addToCart
4. @removeFromCart
5. @filterItems
6. @checkoutCart
7. @completeCheckout
8. @logout

## Tutorial to run the project and generate report
https://app.screencast.com/5x3abJk1UTLzW