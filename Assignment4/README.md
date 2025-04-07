// Reggie Brown
// 07/04/25
// reggie.brown@dcmail.ca
// https://github.com/ReggieBot/cosc1200/tree/main/Assignment4
// Professor Tauhid
// Durham College COSC1200 (Object Oriented Programming 1)
// ----------DESCRIPTION----------
// This program is modelled after a library categorization system. It utilitized different OOP principles 
// including method overriding, inheritance, and abstract classes. It provides a way to borrow and return books 
// while keeping inventory. It implements different data structures in order to efficiently accomplish this
// including stacks, queues, and linked lists.

// NOTE
// Due to Java not supporting Multiple Inheritance, a seperate interface was created.
// The BorrowableBook class needs to inherit from both FictionBook & NonFictionBook. 
// To get around this problem, a seperate Interface class "Borrowable" was created.
// Class BorrowableBook now extends "Book", and implements "Borrowable"

// NOTE
// The BorrowableBook class uses 'composition' by holding a 'reference' to an actual instance of Book (such as FictionBook or nonFictionBook). This allows BorrowableBook to implement methods like getBookType() or displayInfo() to the underlying book. 



// -----------REFERENCES-----------
// https://stackoverflow.com/questions/94361/when-do-you-use-javas-override-annotation-and-why
// https://www.digitalocean.com/community/tutorials/composition-in-java-example
// https://en.wikipedia.org/wiki/Composition_over_inheritance
https://www.w3schools.com/java/ref_keyword_instanceof.asp