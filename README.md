# webflux-stream-demo
A very simple demo to show how to consume a stream of events via a HTTP POST request with Spring webflux.

## Go
Start the Spring boot server. Then you can run the Node.js script to publish some messages, it will echo the content to
the conole and once the connection is ended return the number of messages processed to the caller.

Spring webflux is very flexible. You can provide events either as individual JSON objects, or in a JSON array or any
 combination thereof.
