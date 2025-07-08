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

## Demo
### Adding Paper Book
![image](https://github.com/user-attachments/assets/a1d4e9f6-5662-46de-a7ee-8429d8297e1c)

### Adding EBook
![image](https://github.com/user-attachments/assets/ec8b9ef0-c2eb-4131-923d-27ffa7775e7a)

### Adding Demo Book
![image](https://github.com/user-attachments/assets/f70c42b5-3a4c-4c4d-aa85-6e7fe0463aa0)

### Purchasing, Book does not exist
![image](https://github.com/user-attachments/assets/a7ad3a9c-a63a-4256-a46a-f7aa9280646c)

### Purchasing Paper Book
![image](https://github.com/user-attachments/assets/303f3c7f-143c-48dd-9c77-a805bc719e07)

### Purchasing More Than Available Quantity
![image](https://github.com/user-attachments/assets/a380e784-2565-453a-b950-7c248a138c36)

### Purchasing EBook
![image](https://github.com/user-attachments/assets/b1b9db5a-6347-4893-baab-6de9bea5a2d2)

### Purchasing Demo Book
![image](https://github.com/user-attachments/assets/cebd5590-a188-4547-9b2f-3f2a55466c3f)

### Deleting Outdated Books
![image](https://github.com/user-attachments/assets/21ab9c7f-459b-46ba-8a2a-be7d5074b219)




