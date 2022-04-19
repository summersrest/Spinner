# NiceSpinner2AndroidX
NiceSpinner修改为AndroidX版本
原库地址：https://github.com/arcadefire/nice-spinner
## **1、导入**
 1.引入jitpack
 ```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2.添加
```java
implementation 'com.github.summersrest:PictureShow:v1.0.1'
```
## **2、使用**
### **1、加载List<String>**
```xml
<com.sum.nicespinner.NiceSpinner
    android:id="@+id/nice_spinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```
  
```java
List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
spinner.attachDataSource(dataset);
spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
    @Override
    public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
    }
});
```
  
### **2、xml中引用固定数组**
```xml
<com.sum.nicespinner.NiceSpinner
    android:id="@+id/nice_spinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:entries="@array/courses"/>
``` 
strings.xml：
```xml
<string-array name="courses">
    <item>English</item>
    <item>Chinese</item>
    <item>Math</item>
</string-array>
``` 
  
```java
spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
    @Override
    public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
    }
});
```
  
### **3、自定义List<T>**
```xml
<com.sum.nicespinner.NiceSpinner
    android:id="@+id/nice_spinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

```java
class Person {
    private String name;
    private String surname;
 
    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
 
    String getName() {
        return name;
    }
 
    String getSurname() {
        return surname;
    }
 
    @Override
    public String toString() {
        return name + " " + surname;
    }
}
```

```java
List<Person> people = new ArrayList<>();
 
people.add(new Person("Tony", "Stark"));
people.add(new Person("Steve", "Rogers"));
people.add(new Person("Bruce", "Banner"));
 
SpinnerTextFormatter textFormatter = new SpinnerTextFormatter<Person>() {
    @Override
    public Spannable format(Person person) {
        return new SpannableString(person.getName() + " " + person.getSurname());
    }
};
 
spinner.setSpinnerTextFormatter(textFormatter);
spinner.setSelectedTextFormatter(textFormatter);
spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
    @Override
    public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
        Person person = (Person) parent.getSelectedItem();
        Toast.makeText(MainActivity.this, "Selected: " + person.toString(), Toast.LENGTH_SHORT).show();
    }
});
spinner.attachDataSource(people);
```
 
