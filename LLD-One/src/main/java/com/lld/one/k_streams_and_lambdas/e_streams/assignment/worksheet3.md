# 🧾 Java Streams – Interview Worksheet (No Hints)

> **Constraints**
>
> * ❌ No loops
> * ❌ No external mutable state
> * ✅ Use Java Streams only
> * ✅ Code should be production-readable

---

## Q1. Even Squares

Given a list of integers, return a list containing the **square of even numbers only**.

```java
Input: [1, 2, 3, 4, 5]
Output: [4, 16]
```

---

## Q2. Filter & Transform Strings

Given a list of strings, convert them to **uppercase** and return only those with **length greater than 3**.

```java
Input: ["java", "go", "spring", "api"]
Output: ["JAVA", "SPRING"]
```

---

## Q3. Active User Emails

You are given a list of users:

```java
class User {
    String name;
    String email;
    boolean active;
}
```

Return a list of **emails of active users**.

---

## Q4. Word Frequency

Given a list of words, return a map containing **each word and its frequency**.

```java
Input: ["apple", "banana", "apple"]
Output: {apple=2, banana=1}
```

---

## Q5. Employees per Department

Given a list of employees:

```java
class Employee {
    String name;
    String dept;
}
```

Return a map of **department → number of employees**.

---

## Q6. Highest Paid Employee by Department

Given a list of employees:

```java
class Employee {
    String name;
    String dept;
    double salary;
}
```

Return a map of **department → highest paid employee**.

⚠️ Do not return `Optional` in the final map.

---

## Q7. Youngest Person in Each City

Given:

```java
class Person {
    String city;
    int age;
}
```

Return a map of **city → youngest person**.

---

## Q8. Split Even and Odd Numbers

Given a list of integers, split them into two groups:

* even numbers
* odd numbers

Return the result as a map.

---

## Q9. Pass or Fail Students

Given:

```java
class Student {
    String name;
    int marks;
}
```

Split students into **pass** and **fail** groups based on marks ≥ 40.

---

## Q10. Flatten Nested Lists

Given a list of lists of integers, return a **single flattened list**.

---

## Q11. Unique Characters

Given a list of words, return a list of **distinct characters** across all words.

```java
Input: ["java", "stream"]
Output: [j, a, v, s, t, r, e, m]
```

---

## Q12. Extract All Order Items

Given:

```java
class Order {
    List<Item> items;
}

class Item {
    String name;
}
```

Return a list of **all item names** from all orders.

---

## Q13. Word Length Mapping

Given a list of words, return a map of:

```java
word → length
```

⚠️ Handle duplicate words safely.

---

## Q14. Employee Salary Mapping

Given a list of employees, return a map:

```java
name → salary
```

If duplicate names exist, keep the **higher salary**.

---

## Q15. Character Frequency

Given a string, return a map containing **frequency of each character**.

---

## Q16. Sum of Squares

Given an integer array, return the **sum of squares** of all elements.

---

## Q17. Average Salary

Given a list of employees, calculate the **average salary**.

---

## Q18. Maximum Element

Given an integer array, return the **maximum element**.

---

## Q19. First Non-Repeating Character

Given a string, return the **first non-repeating character**.

```java
Input: "aabbcddee"
Output: 'c'
```

---

## Q20. Second Highest Number

Given a list of integers, return the **second highest number**.

---

## 🧠 How Interviewers Evaluate This

They check:

* Correct stream selection
* Clean collector usage
* No unnecessary `.stream()` chains
* Proper handling of edge cases
* Readability over cleverness

---