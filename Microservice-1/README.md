# Spring-Cloud-Sleuth-Tracing-Demo
Spring Cloud Sleuth Tracing Demo


In this example , I have tried to demostrate the capability of Spring Cloud Sleuth library which is a wrapper around Tracing library named "Brave"

The code implementation has open feign client calling the other running rest service. 

It also has filter implementation for HttpResponse including the response header field "X-TRACKING-ID". File Reference SleuthTraceFilter.java

The current context's tracing ID can be easily obtained using - MDC.get("X-B3-TraceId")

https://docs.spring.io/spring-cloud-sleuth/docs/current-SNAPSHOT/reference/html/
