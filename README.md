# Generics_Assignment

Design a new collection type named **"Box"** which contains **3 partitions**. The 3 partitions are named top, middle, bottom.
A Box can hold objects of the same type. It's not possible to put objects of different types in the same box. e.g. you cannot put a Book and a Ball in the same Box. Box of Books will contain books only.
The box can contain less than 3 items.
The Box offers the following features
### Put Object
----------
I should be able to put an object in any of the 3 partitions
### Get Object
----------
I should be able to get an object from any of the 3 partitions
### Remove Object
----------
I should be able to remove an object from any of the 3 partitions
### Sort
----
I should be able to sort the objects in the box based on certain parameters
e.g. I should be able to sort the box of books by a number of pages
For simplicity assume the sorting is done in ascending order.
e.g. If a Box of books is sorted then the top will have the book with a minimum number of pages
### Iterate
--------
I should be able to iterate over all the items in the Box.
The Box collection should work for Book and Ball items by default, but it should be possible for anyone to introduce a new item type and use Box to store the new item type. All the features should work on the new Item Type.
Assume the following for Book and Ball
Book(name: String, author: String, numberOfPages: Int)
Ball(color: String, radius: Double)
## Important
### Language Kotlin
### Write Tests
### Follow TDD
### Preferably use Kotest as a test framework
### Do not use any library or existing collections
