# Streams 

## What is a `Stream` ?
1. A wrapper
2. on data source 
3. for doing operations on items inside data sources. 
4. **Examples of data sources : (arrays,list,maps,set,collections,files,console,port)**

## How to Create `Stream` ?
We have 4 different ways to create `Stream` 
### Way 1 : arrays to stream
```java
public class StreamCreation{
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5};
        Stream<Integer> stream = Stream.of(nums);
    }
}
```
### Way 2: items to stream
```java
public class StreamCreation{
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
    }
}
```
### Way 3: Collections to stream

```java
import java.util.ArrayList;

public class StreamCreation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream(); 
    }
}
```

### Way 4: Use Builder to create stream

```java
import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        Stream.Builder<Integer > streamBuilder = Stream.builder();
        streamBuilder.accept(1);
        streamBuilder.accept(2);
        streamBuilder.accept(3);
        streamBuilder.accept(4);
        Stream<Integer> stream = streamBuilder.build();
    }
}
```

## Operations on Streams? 
### Filter 
_**Purpose:  To filter out desired content from datasource.**_

### Map

### Reduce 


