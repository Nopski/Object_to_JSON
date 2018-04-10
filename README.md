# Object_to_JSON
This example how convert object to JSON. The first example is using "library" of
google which called Gson. In maven just wrote this 
```
<dependency>
   <groupId>com.google.code.gson</groupId>
   <artifactId>gson</artifactId>
   <version>2.2.2</version>
</dependency>
```
And then work with this example:
```java
List<BS747> list = new ArrayList<BS747>();
for(int i=0; i<1; i++) {
    list.add(b);
}
Gson gson = new Gson();
Type type = new TypeToken<List<BS747>>(){}.getType();
String json = gson.toJson(list, type);
```
The next example is using Reflection API. This API is encluded in Java. 

For this I used Fields and Modifier classes. 
Example:
```java
Field field = myClass.getClass().getDeclaredField("name");
field.setAccessible(true);
field.getModifiers()//from class Modifier
```
