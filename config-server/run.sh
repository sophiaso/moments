#!/bin/sh

#java -jar /spring-cloud/lib/config-server-0.0.1-SNAPSHOT.jar
log()
{
    echo "$1"
}

log "Run java package $JAVA_PACKAGE"

java -jar /spring-cloud/lib/$JAVA_PACKAGE