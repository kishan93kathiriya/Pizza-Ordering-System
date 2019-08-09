# Pizza-Ordering-System
Programming challenege for Aquent in Spring and Rest

## Assumptions Made:
- Input file in text format and stored locally in /src/main/resources folder
- Input data coming in as row string data
- Time in EDT
- Storing the output in a txt file in the same /src/main/resources folder
- Added a testcase I thought should be enough to test this project

## Design Logic
- Created a controller and services folders for business logic, model for the data coming in to handle it properly
- Services package includes the basic functions to read/write/sort the data as expected.
- Used a Comparator for the model in order to sort the data as required.
- http://localhost:8081/sortPizzaOrders should call the rest service to read the data then sort it in a way expected and then write it to a text file specified
