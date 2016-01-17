# JayWire Spark Demo

I use this small application to demonstrate how to solve common DI scenarios with JayWire.
There are two branches *master*, and *steps*. The former is the outline of the software,
without the various parts bound together, and the latter is the 'solution' with JayWire.

The application has 3 simple pages, which need to be renedered using the appropriate services.
To run the application do:

```bash
mvn exec:java
```

This will start Spark on port *4567*, with a static page to reach the 3 other pages.
