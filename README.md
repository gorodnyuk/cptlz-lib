Независящая от фреймворков библиотека для преобразования значений указанных строковых полей в те же значения, у того же
объекта, но с большой буквы.

**Использование**

```text
Person person = new Person("andrey", "some-address");
CapitalizeUtils.capitalize(person, "name");  
```

В примере выше указано только поле `name`. На выходе получится:

```text
person.name -> "Andrey"  
person.address -> "some-address" // не с большой буквы, тк поле не было указано в параметрах метода `capitalize`
```
