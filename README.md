# ChatAppPureJava/JAVA WEB SERVER
## -January 22 2026 1:52 am 
  Decided to code a web server for a chat app using pure java. We'll see how it goes...

## - January 29 2026 03:05 am
  Don't know if i'll try to implement web sockets for the chat app. Most likely the server is going to host my portfolio site.
  Current functionalities: request parsing, URI (route) parsing, ability to serve static html files along with stylesheets.
  I'm handling the routing of the uri such that i keep the the key value pair <Route, RouteHandler> in a Map, the RouteHandlers are Functional interfaces of custom type Controller.
  
