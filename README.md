## Trading System
---------------------------------------------------------------------------
Saisriram Gunturu, Jinkun Lin, Yuanming Chai
sriramg@bu.edu,jchai23@bu.edu, jkunlin@bu.edu
UML
<img width="973" alt="Screenshot 2024-01-04 at 10 56 12 AM" src="https://github.com/Saisriram2003/trading-system/assets/40213936/c9a4c3f5-c739-45c9-a62a-2343535f6ab2">


## Files
---------------------------------------------------------------------------
AddStockPage: Page which allows you to add stocks
BuyStockPage: Page which allows you to buy stocks
Customer: Class that maintains customers extends Users
CustomerMainPage: Main page for Customers
CustomerService: Concrete service interface for Customers and DB
CustomerServiceInterface: Abstract service interface for Customers and DB
Database: Main DB class that maintains all DB functionality
DepositPage: Page where Customers can deposit money
EditProfilePage: Users can edit their profile
Main: Entrance to application
MainPage: Main page of the application
Manager: Class that maintains Manager extends User
ManagerMainPage:Main page for Manager
ManagerService: Concrete service interface for Manager and DB
ManagerServiceInterface: Abstract service interface for Managers and DB
ManageStocksPage: Manager Page for managing stocks
ManageUsersPage: Manager page for managing users
Market: Class that maintains Market
ProfilePage: Page that shows profile for Customer
SellStockPage: Page that shows sell stock information
Stock: Class that maintains stock information
StockPage: Page that shows Stock information
User: Main User class that is extended by Customers and Managers
UserLoginPage: Login page for Users
UserOwnedStocksPage: Page that shows User owned stocks
UserPage: Page that lets Manager view User
UserRegister: Page for registering users
WithdrawPage: Page for withdrawing cash for user
## Notes
---------------------------------------------------------------------------
Design:
Our program is designed to support customers and a unique manager to perform
trading operations. We choose to use a SQL database with the pre-constructed
schema to set up the persistent data storage for user data and stock
information. We also create GUI interfaces to support users' interactions with
our program. The GUI is connected with our Java backend classes and methods
that are used to perform and execute the operations. We implemented separate
service layers for the manager and customers. This design decouples the
functionality of a unique stock market manager and customers, making sure each
separate role can only access the operations that only belong to the role’s
responsibilities. The manager will interact with the database (add/modify
stocks/customers) with methods from ManagerService class and each customer will
interact with methods (trade stocks/deposit/withdraw) from CustomerService
class. We also implemented the singleton pattern for the manager account
creation and the database so we are only using the same manager account every
time the user logs in as manager and every user is accessing the same only
database. We also implemented abstraction, encapsulation, and polymorphism in
our structure creating interfaces for the service layer and user superclass for
the manager and customers. Our program is scalable because of the separation of
the user layer, service layer, and database layer which makes it easy to add
additional features to each layer.

## Files
---------------------------------------------------------------------------
AddStockPage: Page which allows you to add stocks
BuyStockPage: Page which allows you to buy stocks
Customer: Class that maintains customers extends Users
CustomerMainPage: Main page for Customers
CustomerService: Concrete service interface for Customers and DB
CustomerServiceInterface: Abstract service interface for Customers and DB
Database: Main DB class that maintains all DB functionality
DepositPage: Page where Customers can deposit money
EditProfilePage: Users can edit their profile
Main: Entrance to application
MainPage: Main page of the application
Manager: Class that maintains Manager extends User
ManagerMainPage:Main page for Manager
ManagerService: Concrete service interface for Manager and DB
ManagerServiceInterface: Abstract service interface for Managers and DB
ManageStocksPage: Manager Page for managing stocks
ManageUsersPage: Manager page for managing users
Market: Class that maintains Market
ProfilePage: Page that shows profile for Customer
SellStockPage: Page that shows sell stock information
Stock: Class that maintains stock information
StockPage: Page that shows Stock information
User: Main User class that is extended by Customers and Managers
UserLoginPage: Login page for Users
UserOwnedStocksPage: Page that shows User owned stocks
UserPage: Page that lets Manager view User
UserRegister: Page for registering users
WithdrawPage: Page for withdrawing cash for user

## Notes
---------------------------------------------------------------------------
Design:
Our program is designed to support customers and a unique manager to perform
trading operations. We choose to use a SQL database with the pre-constructed
schema to set up the persistent data storage for user data and stock
information. We also create GUI interfaces to support users' interactions with
our program. The GUI is connected with our Java backend classes and methods
that are used to perform and execute the operations. We implemented separate
service layers for the manager and customers. This design decouples the
functionality of a unique stock market manager and customers, making sure each
separate role can only access the operations that only belong to the role’s
responsibilities. The manager will interact with the database (add/modify
stocks/customers) with methods from ManagerService class and each customer will
interact with methods (trade stocks/deposit/withdraw) from CustomerService
class. We also implemented the singleton pattern for the manager account
creation and the database so we are only using the same manager account every
time the user logs in as manager and every user is accessing the same only
database. We also implemented abstraction, encapsulation, and polymorphism in
our structure creating interfaces for the service layer and user superclass for
the manager and customers. Our program is scalable because of the separation of
the user layer, service layer, and database layer which makes it easy to add
additional features to each layer.
## How to compile and run
---------------------------------------------------------------------------
javac Main.java
java BeginGame
