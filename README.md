# Quotely

This *Command Line Interface* generates a random quote. It calls [Forismatic API](https://www.forismatic.com/en/api/) and outputs the returned quote to *stdout*.

### Run Tests

```
gradle test
```

It should be successful.

```
> Task :quotely-app:test

QuotelyTest > testGenerateQuote(Lang) > [1] en STANDARD_ERROR
    Very little is needed to make a happy life; it is all within yourself, in your way of thinking.  

QuotelyTest > testGenerateQuote(Lang) > [2] ru STANDARD_ERROR
    Одно полустишие, услышав которое становятся спокойными, лучше тысячи стихов, составленных из бесполезных слов.

BUILD SUCCESSFUL in 3s
```

### Run application

#### English
```
gradle run --args="en"
```
> Kind words can be short and easy to speak but their echoes are truly endless. 

#### Russian
```
gradle run --args="ru"
```
> К черту все! Берись и делай!


### TODO

- Logging & Metrics
- Dependency Injection
- Ahead-Of-Time compilation