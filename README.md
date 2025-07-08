# Fawry Quantum Bookstore

## Overview
This project is a simple bookstore system implemented in Java, following object-oriented design principles. It adding books, removing outdated books, and purchasing a certain book. The project is structured as a Maven project for easy dependency management and future expandability.

## Project Structure
```
quantumbookstore/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/fawry/bookstore/
│               ├── Main.java
│               ├── models/
│               │   ├── Inventory.java
│               │   ├── Shop.java
│               │   ├── Books/Book.java
│               │   ├── Books/Finite.java
│               │   ├── Books/Shippable.java
│               │   ├── Books/Mailable.java
│               │   ├── Books/PurchasableBook.java
│               │   └── Books/Types/
│               │       ├── DemoBook.java
│               │       ├── EBook.java
│               │       └── PaperBook.java
│               └── services/
│                   ├── MailService.java
│                   └── ShippingService.java
└── target/
```

## Setup Instructions
1. **Clone the repository**
   ```sh
   git clone https://github.com/yousefwmorsy/fawry-quantum-bookstore
   ```
2. **Build the project using Maven**
   ```sh
   mvn clean compile
   ```
3. **Run the program**
   ```sh
   mvn exec:java
   ```


## Class Hierarchy & Design

### Book Hierarchy
- **Book (abstract)**: Base class for all books. Contains common fields (`ISBN`, `title`, `year`).
- **PurchasableBook (abstract)**: Extends `Book`, and adds data members and methods for setting price
- **Finite (interface)**: Declares methods for book quantity
- **Mailable (interface)**: Declares methods for fetching relevant mailing data (`filetype`)
- **Shippable (interface)**: Declares methods for fetching relevant shipping data (currently not implemented, but could be implemented later to add weight for example)
- **DemoBook**: Extends `Book` with no extra functionality
- **PaperBook**: Extends `PurchasableBook`, implements `Shippable` & `Finite`, provides methods for managing quantity
- **EBook**: Extends `PurchasableBook`, implements `Mailable`, provides methods for setting filetype

### Inventory
- **Inventory**: Holds a list of `Book` objects. Supports adding books, removing outdated books, printing the inventory contents and finding a certain book to be purchased.

### Shop
- **Shop**: Contains the inventory, it is used to manage the inventory and manage purchases.


### Services
- **MailService**: Service for handling mailing ebooks.
- **ShippingService**: Service for handling shipping paper books.


### Main
- **Main**: provides a user-friendly interface to operate the shop.
