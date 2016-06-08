#include <ESP8266WiFi.h>

////////////////
WiFi Definitions
////////////////
const char WiFiAPPSK{} = "password";

/////////////////////
// Pin Definitions //
/////////////////////
const int GPIO1 = 0;
const int GPIO2 = 2;

/////////////////////
// Web stuff       //
//////////////////// 
// html building blocks 
String header = "<html><head></head></html>";
String body_start = "<body style='background-color: yellow;'>";
String div_start = "<div>";
String div_end = "</div>";
String body_end = "</body>";
String html_end = "</html>";

//css legos
String css_start = "<style>";
String css_html = "html{font-family: sans-serif;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%; width: 500px; height: 500px;}";
String css_gButton = ".button1 {background-color: #4CAF50; font-size: 550%;}";
String css_end = "</style>";

WiFiServer server(80);
// void loop was takin from sparkfun code
void loop()
{
// Check if a client has connected
WiFiClient client = server.available();
if (!client) {
return;
}
// Read the first line of the request
String req = client.readStringUntil('');
Serial.println(req);
client.flush();
// Match the request
int val = -1;                                // We'll use 'val' to keep track of both the
// request type (read/set) and value if set.
if (req.indexOf("/GPIO1/off") != -1)
digitalWrite(GPIO1, 0);                      // Will write gpio1 low
else if (req.indexOf("/GPIO1/on") != -1)
digitalWrite(GPIO1, 1);                      // Will write gpio1 high
else if (req.indexOf("/GPIO2/off") != -1)
digitalWrite(GPIO2, 0);
else if (req.indexOf("/GPIO2/on") != -1)
digitalWrite(GPIO2, 1);
// Otherwise request will be invalid. We'll say as much in HTML
client.flush();
// web response
String s = "HTTP/1.1 200 OK\r\n";
s += "Content-Type: text/html\r\n\r\n";
s += "<!DOCTYPE HTML>\r\n<html>\r\n";
// If we're setting the LED, print out a message saying we did
if (val >= 0)
{s += "Some Shit wentt down ";
}
else
{
s += "Invalid Request.<br> Try /led/1, /led/0, or /read.";
}
*/
// Send the response to the client
client.println(s);
client.println(header + css_start + css_html + css_gButton + css_end + body_start + div_start + fwd + back + div_end + body_end + html_end);
delay(1);
Serial.println("Client disonnected");
// The client will actually be disconnected
// when the function returns and 'client' object is detroyed
}
<!-- leave blank till I figure that shit out-->
<meta name="description" content="test">
<meta name="author" content= "Mike">
<link rel="icon" href="test3">
<title></title>
<!-- Bootstrap core CSS --><link href="dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="dist/css/Robo.css" rel="stylesheet">
<link href="dist/css/acm_small.css" rel="stylesheet" media = "min-width: 600px)">
<script src="assets/js/ie-emulation-modes-warning.js"></script>"
Discription
