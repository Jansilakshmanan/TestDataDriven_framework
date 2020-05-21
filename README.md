# TestDataDriven_framework

This project has different methods to read data from excel sheet and retrieve data using Data Provider which is used in TDD framework.

* Getexceldataintoobjectarray -->This java file reads data from excel into an object array and pass the parameters to test method using 
                                     Data Provider
                                     
* Getexceldataintohashmaps --> This java file reads data from excel into a hashmap (key:value pair) and pass the hashmap to test method using 
                                     Data Provider     
                                     
  Advantages of using Hashmaps with TestNG Dataprovider in Data Driven Testing:
     * parameters need not be passed to the test method
          This is especially useful when the excel data has many columns(say 50 colns),we cannot pass 50 parameters to the test method
     * values can be retrieved as key,value pairs
     * Additional data that need not be from the excel can also be manually added in hashmaps whenever needed,
       whereas in object array,array size cannot be altered                                   
                                     
