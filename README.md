twitter-server-template
=======================

Quick-start
-----------

To generate the project jar :

    $ sbt assembly

Then, to start the BasicServer exemple :

    $ java -jar target/myserver-assembly-0.1.0.jar

To check that the server is running :

    $ curl localhost:8888
    hello

The admin page is located at :

    http://localhost:8080/admin


For more information and documentation about twitter-server :

    http://twitter.github.io/twitter-server/
