===============================================================================
Design of BenchmarkClient:

- store start time
- make 1000 connections (using threads)
  > each connection sends fixed line to server and reads uppercase line back
- store end time
- print Total Time = (end - start)
- print Average Time = (end - start) / 1000

===============================================================================
Outputs (for 1000 connections):

SimpleServer
Total time: 1311ms
Average time per client: 1.311ms


MTServer
Total time: 1171ms
Average time per client: 1.171ms

===============================================================================
Reasoning for better performance:

The SimpleServer is only capable of serving one client at any given time, so it
is not able to accept new connections until the previous client has finished.

The MTServer starts a new thread each time a client connects, which allows it
to immediately wait for the next client to try to connect. This allows the
server to accept and work with multiple clients at the same time, which leads
to the more efficient times.