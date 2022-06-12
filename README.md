## Shopping Cart System

- A checkout system for a shop which only sells apples and oranges.
- Apples cost 60p and oranges cost 25p.
- The checkout system which takes a list of items scanned at the till and outputs the total cost
 - The list of items are submitted as a text file, which is found in the following path:
```
src/main/resources/basket.txt
```
- The system is currently configured with two promotional offers:
 - buy one, get one free on Apples
 - 3 for the price of 2 on Oranges

### Running the application

- Clone the repository
- Configure the basket.txt file with the desired items
- Open a terminal in the project directory and enter the following command:
```
sbt run
```

### Running the tests
- Open a terminal in the project directory and enter the following command:
```
sbt test
```

