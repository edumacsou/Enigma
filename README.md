# Object Oriented Enigma

<details><summary><h2 Style="display:inline"> 1. What is this repository?</h2></summary>
<p>
&nbsp;&nbsp;&nbsp;&nbsp; This repository is a digital version of an electromechanical dispositive, made with the purpose of learning about cipher and developing programing skills.<br/>
&nbsp;&nbsp;&nbsp;&nbsp; Using the concepts of object-oriented programming, it was possible to transcript the logic of an electromechanical device into a code, where all the parts were represented into a class with attributes and methods. <br/>
&nbsp;&nbsp;&nbsp;&nbsp; The methods represent the functions of each part, and are encapsulated to be seen only for parts that are connected to each other in the real machine.

---
</p> </details>

<details><summary><h2 Style="display:inline"> 2. What is the enigma machine?</h2></summary>
<p>
&nbsp;&nbsp;&nbsp;&nbsp; The Enigma machine is an encryption device developed and used in the early to mid 20th century to protect commercial, diplomatic and military communication.

---
</p> </details>

<details><summary><h2 Style="display:inline"> 3. How to run the enigma?</h2></summary>
<p>
1. To use this application you need Oracle JDK 8u261 or above (you can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html))

2. Clone this repository to your computer and unzip it. The files will be in a path like this:
    ````
    C:\Users\my_name\Documents\Enigma-Machine
    ````

3. Access this folder in your terminal (Unix users) or CMD (Windows users), using this command:
    ````
    cd "C:\Users\my_name\Documents\Enigma-Machine"
    ```` 

4. Compile and Run the code using the following commands:
   ````
   javac src/EnigmaOOP.java

   java src.EnigmaOOP
   ````  

5. To run the automatic test use these commands:
    ````
    javac test/EncryptDecryptTest.java

    java test.EncryptDecryptTest
    ````

---
</p> </details>

<details><summary><h2 Style="display:inline"> 4. How to use it?</h2></summary>
<p>
&nbsp;&nbsp;&nbsp;&nbsp; After running EnigmaOOP, the terminal will ask for a number relative to a rotor file. This number must be between 1 and 5. After this, a letter will set the initial position of the rotor. This process will be repeated for 2 more times until all the 3 rotors are set. 
Save these settings, you'll need them later to decrypt your message.<br>

&nbsp;&nbsp;&nbsp;&nbsp; Write your message, assuming that all the special characters, spaces, and numbers will be deleted and all the letters will be uppercased. You can use multiple lines. The program will stop receiving words when the word "CAMBIO" be written.<br>

&nbsp;&nbsp;&nbsp;&nbsp; The program will print a code like this: FTWGMOTJIADKNAIHDYEAHVOA on your console. This is your encrypted message. It can be decrypted by setting a new machine with the same initial conditions and the word "CAMBIO" at the end of the message.

---
</p> </details>

<details><summary><h2 Style="display:inline"> 5. Concepts used</h2></summary>
<p>
- Object Oriented Programing
  - Abstraction
  - Encapsulation
  - Inheritance
  - Polymorphism
- Packaging
- Data structures

---
</p> </details>


