FROM openjdk:8-jre-alpine
MAINTAINER yaweiw@microsoft.com
RUN apk add --update bash && rm -rf /var/cache/apk/*

ARG PACKAGE_NAME
ENV JAVA_PACKAGE ${PACKAGE_NAME}

COPY target/${PACKAGE_NAME} /spring-cloud/lib/
COPY run.sh /spring-cloud/bin/run.sh
RUN chmod +x /spring-cloud/bin/run.sh

CMD ["/spring-cloud/bin/run.sh"]

EXPOSE 8888