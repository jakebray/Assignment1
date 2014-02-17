===============================================================================
Design of BenchmarkClient:

- store start time
- spawn 8 client threads
  > each client thread makes 10 connections to the server
  > each connection sends a string message to the server and reads a string
    back multiple times
- wait for all the client threads to finish
- store total time = (current - start)
- print Total Time

===============================================================================
Outputs:

SimpleServer
Total time: 2145ms

MTServer
Total time: 757ms

===============================================================================
Reasoning for better performance:

The SimpleServer is only capable of serving one client at any given time, so it
is not able to accept new connections until the previous client has finished.

The MTServer starts a new thread each time a client connects, which allows it
to immediately wait for the next client to try to connect. This allows the
server to accept and work with multiple clients at the same time, which leads
to the more efficient total time.
