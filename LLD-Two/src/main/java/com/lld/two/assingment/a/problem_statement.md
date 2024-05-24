# Based on SingleTon Design Pattern 
## Requirement 
```java
class A
{
}
class B extends A
{
}
// 1st time calling. 
A a1 = A.getObject();
B b1 = B.getObject();
//2nd time calling should throw exception. 
A a2 = A.getObject(); 
B b2 = B.getObject(); 
```

* Only one object of class A
* Only one object of class B
* If try to create more that one object of any of these classes then I should get an exception 