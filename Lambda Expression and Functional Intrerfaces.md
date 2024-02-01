
## Benefits of Lambda Expression

1. To enable functional programming in java
2. Write more readable, maintainable & concise code.
3. To use APIs very easily & effectively
4. To enable parallel processing

## How to Write Lambda Expression

Lambda expression is **anonymous function**. It is not having **name**, **modifiers** and neither any **return type**.

Examples-1: 

Now lets write normal function and will convert into a lambda expression:
```
public void m1() {
 SOP("Hello")
}

```

As lambda expression can't have any name, modifiers and return type. then the above expression will convert into below

```
 () {
 SOP("Hello")
}
```

Then the Lambda expression will be 

```
()->{SOP("Hello")}

```

Examples-2: Sum of 2 integer values

```
public void m1(int a, int b) {
sop(a+b);
}

```

Then the Lambda expression will be
```
(int a, int b) -> {sop(a+b);}

```

Example-3: Length of the String

```
public void m1(String s) {
return s.length();
}

```

Then the Lambda expression will be

```
(String s)->{return s.lenght();}
```

**RULE-1:** If Lambda expression body **contains only one statement**, then the **curly braces** will become **optional**.

Example 4: 

```
public void m1() {
sop("Hello");
}

#After lambda expression

()->{sop("hello");}

# Again transformation as per above statement

()->sop("Hello");
```


**RULE-2:** If compiler can guess automatically the **type of the parameters** based on context, then we can remove the type also in Lambda expression

Example-5:

```
public void add(int a, int b) {
sop(a+b);
}

#After lambda expression

(int a, int b)-> {sop(a+b);}

# Again transformation as per above statement
(a, b)->sop(a+b);

```

**RULE-3:** If lambda expression return something, then also no need to mention.
**RULE-4:** If lambda expression contains only 1 input value, then the parenthesis also optional. 

Example-6:

```
public void m1(String s) {
return s.lenght();
}

# After Lambda expression

(String s)->{return s.length();}

# After transformation again as per above statement

(s)-> s.length();

# After transformation again as per above statement

s->s.length();
```


## Functional Interface

If interface contain only one abstract method then we called that interface as Functional Interface.
 1. It's a **Single Abstract Method**. 
 2. We can use this functional interface to invoke lambda expression.
 3. It can have multiple default and static methods but only one abstract method.
 4. We can use @FunctionalInterface annotation to declare functional interface 

**Example:**
Runnable : contains only run() method.
Callable: contains only call() method.
ActionListener: contains only actionPerformed().
Comparable: contains only compareTo() method.

```
interface Action {

# It is the only one abstract method here
public void m1();

default void m2() {
}

public static void m3(){

}

}

# using @FunctionalInterface

@FunctionalInterface
interface Action {

# It is the only one abstract method here
public void m1();

default void m2() {
}

public static void m3(){

}

}


```


**Invalid Example**

```

# Function Interface should contain only one abstract method. Hence below examples are  invalid functional interface.

@FunctionalInterface
interface Action {

public void  m1();

public void m2();
}

**Compile Time Error:** unexpected @FunctionalInterface annotation multiple non-overriding abstract methods found in Interface 

# This is also invalid

@FunctionalInterface
interface Action {

}

**Compile Time Error:** unexpected @FunctionalInterface annotation no abstract methods found in Interface

```


## Functional Interface wrt Inheritance

**CASE-1:** If a child interface extends a functional interface and child interface doesn't contain any abstract methods, then child interface will also become functional interface.

```
@FunctionalInterface
interafce Action {
public void m1();
}

// This interface is also @FunctionalInterface
interface MovieAction extends Action {

}
```

**CASE-2** If a child interface extends Functional Interface and child contains same method defined in Functional interface, then child interface will also become Functional Interface

```
@FunctionalInterface
interafce Action {
public void m1();
}

// This interface is also @FunctionalInterface
interface MovieAction extends Action {
public void m1();
}

```

**CASE-3** If a child interface extends a functional interface and child interface also contain different abstract methods, then we will get **Compile Time Error**.

```
@FunctionalInterface
interafce Action {
public void m1();
}

// Compile time error
interface MovieAction extends Action {
public void m2();
}

```


### Invoking Lambda Expression By Using Functional Interface

**Example-1**

Without Lambda Expression

```
@FunctionalInterface
interface Address {
public void m1();
}

class EmployeeAdress implements Address {

public void m1(){
sop("Hello m1 method");
}

}

class Test {

public void main(String[] args){

Address addr = new EmployeeAddress();
addr.m1();
}
}

```


With Lambda Expression

```
@FunctionalInterface
interface Address {
public void m1();
}

class Test {

public void main(String[] args){

Address addr = ()->sop("Hello m1 method");,
addr.m1();
}


```

**Example-2** 

Without Lambda Expression

```
@FunctionalInterface
interface Address {
public void m1(int a, int b);
}

class EmployeeAdress implements Address {

public void m1(int a, int b){
sop("The Sum "+ (a+b));
}

}

class Test {

public void main(String[] args){

Address addr = new EmployeeAddress();
addr.m1(10, 20);
}
}

```


With Lambda Expression
```
@FunctionalInterface
interface Address {
public void m1();
}

class Test {

public void main(String[] args){

Address addr = (a, b)->sop("The Sum "+ (a+b));,
addr.m1(10, 20);
}

```


**Example-3**

Without Lambda Expression

```
@FunctionalInterface
interface Address {
public void getLength(String s);
}

class EmployeeAdress implements Address {

public void getLength(String s){
return s.length();
}

}

class Test {

public void main(String[] args){

Address addr = new EmployeeAddress();
sop(addr.getLength("India"));
}
}
```

With Lambda Expression

```
@FunctionalInterface
interface Address {
public void getLength(String s);
}

}

class Test {

public void main(String[] args){

Address addr = s-> s.lenght();
sop(addr.getLength("India"));
}
}


```


**Example-4**

Lambda expression on pre-defined Functional Interface. Let's see how we can implement Runnable interface.

Without Lambda Expression

```
class MyRunnable implements Runnable {

public void run() {

for (int i=0; i<10; i++) {
sop("Child Thread")
}
}
}

class ThreadDemo {

public static void main (String args[]) {
Runnable r = new MyRunnable();
Thread t = new Thread(r);
t.start();

for(int i=0; i<10; i++) {
sop("Main Thread")
}

}
}

```


With Lambda Expression

```
class ThreadDemo {

public static void main(String args[]) {

Runnable r = ()->{
   for(int i=0; i<10; i++) {
   sop("Child Thread")
   }
}

Thread t = new Thread(r);
t.start();
for(int i=0; i<10; i++) {
   sop("Main Thread")
   }

}

}

```

### Summary For Functional Interface
