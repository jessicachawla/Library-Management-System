# Library-Management-System
Library Management System
Project Overview
The Library Management System is a Java-based application designed to manage the operations of a
library. It provides functionality for both librarians and library members to interact with the library's
catalogue of books and member information. This README document outlines the project, how it is
implemented, its features and functions, and how different system components are related.
Classes
- Lib: Represents the library and contains methods for managing books and members.
- Book: Represents a book and includes methods for borrowing and returning books.
- Mem: Represents a library member and manages their borrowed books and fines.
- LibraryPortal: The main application class is the entry point for librarians and members to
interact with the system.
Assumptions:
- Each copy is given a different book ID.
- If a book is removed, its book ID is never occupied by a new book.
- The book ID has been auto incremented in the code in the Lib class while adding the book(s) or
copies.
- Member ID is assumed to be the phone number.
- The fine is calculated only when the book is returned and not before that.
- The input data type is assumed to be correct.
Features and Functions
Librarian Functions
- Register a member.
    - Librarians can add new members to the library system by providing their name, phone
number, roll number, and age.
- Remove a member.
    - Librarians can remove members from the library system by specifying their phone number.
- Add a Book
    - Librarians can add new books to the library catalogue by providing the book's title, author,
and the number of copies to add.
- Remove a Book
    - Librarians can remove a book from the library catalogue, provided it is currently available
(not borrowed).
- View All Members with Their Books and Fines
    - Librarians can view a list of all members along with the books they have borrowed and any
fines they owe.
- View All Books
    - Librarians can view a list of all books in the library catalogue, including their titles, authors,
and availability status.
Member Functions
- List Available Books
    - Members can view a list of all available books in the library catalogue.
- List My Books
    - Members can see a list of books they have borrowed.
- Issue a Book
    - Members can borrow books from the library catalogue, provided they have no fines and
haven't reached the borrowing limit.
- Return a Book
    - Members can return books they have borrowed, and the system calculates fines for late
returns.
- Pay Fine
    - Members can pay the fines they owe to the library.
Relationships
- Lib: Manages books and members and handles book and member-related operations.
- Book: Represents individual books, records availability, and manages borrowing and returning.
- Mem: Represents library members and tracks their borrowed books, and fines.
- LibraryPortal: Provides an interface for librarians and members to access the system's features.
The relationships between these classes enable the Library Management System to function
cohesively, allowing librarians to manage the library's resources and members to borrow and return
books while tracking fines.
