package ESP8266_UI_TOOL;

import java.io.IOException;

/**
 *   Author: Michael Stumpf
 *   Edit Date: 5/17/2016
 *
 *   c string generator for ESP8266 experiment
 *
 *   functions:
 *      overhead_gen()
 *          1. generates default html overhead for webpages
 *      variable_description_gen()
 *
 *      TODO add more discriptions here
 *
 */

class html_string {

    protected String overhead_gen() {

        /**
         * This function prints the code nessacarry to create a basic server on the
         * ESP8266 board. The html building blocks are away to help users make use of
         * printing boring html code in the c code.
         */

        return "#include <ESP8266WiFi.h>\n\n"
                + "////////////////\n"
                + "WiFi Definitions\n"
                + "////////////////\n"
                + "const char WiFiAPPSK{} = \"password\";\n\n"

                + "/////////////////////\n"
                + "// Pin Definitions //\n"
                + "/////////////////////\n"
                + "const int GPIO1 = 0;\n"
                + "const int GPIO2 = 2;\n\n"

                + "/////////////////////\n"
                + "// Web stuff       //\n"
                + "//////////////////// \n"
                + "// html building blocks \n"
                + "String header = \"<html><head></head></html>\";\n"
                + "String body_start = \"<body style='background-color: yellow;'>\";\n"
                + "String div_start = \"<div>\";\n"
                + "String div_end = \"</div>\";\n"
                + "String body_end = \"</body>\";\n"
                + "String html_end = \"</html>\";\n\n"

                + "//css legos\n"
                + "String css_start = \"<style>\";\n"
                + "String css_html = \"html{font-family: sans-serif;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%; width: 500px; height: 500px;}\";\n"
                + "String css_gButton = \".button1 {background-color: #4CAF50; font-size: 550%;}\";\n"
                + "String css_end = \"</style>\";\n\n"

                + "WiFiServer server(80);\n";

    }

    protected String spark_fun_void_loop() {

        return "// void loop was takin from sparkfun code\n"
                + "void loop()"
                + "{\n"
                + "   // Check if a client has connected\n"
                + "   WiFiClient client = server.available();\n"
                + "   if (!client) {\n"
                + "   return;\n"
                + "}\n"

                + "// Read the first line of the request\n"
                + "String req = client.readStringUntil('\\r');\n"
                + "Serial.println(req);\n"
                + "client.flush();\n"

                + "// Match the request\n"
                + "int val = -1;                                // We'll use 'val' to keep track of both the\n"
                + "                                             // request type (read/set) and value if set.\n"
                + "if (req.indexOf(\"/GPIO1/off\") != -1)\n"
                + "digitalWrite(GPIO1, 0);                      // Will write gpio1 low\n"
                + "else if (req.indexOf(\"/GPIO1/on\") != -1)\n"
                + "digitalWrite(GPIO1, 1);                      // Will write gpio1 high\n"
                + "else if (req.indexOf(\"/GPIO2/off\") != -1)\n"
                + "digitalWrite(GPIO2, 0);\n"
                + "else if (req.indexOf(\"/GPIO2/on\") != -1)\n"
                + "digitalWrite(GPIO2, 1);\n"

                + "// Otherwise request will be invalid. We'll say as much in HTML\n"
                + "client.flush();\n\n"

                + "// web response\n"
                + "String s = \"HTTP/1.1 200 OK\\r\\n\";\n"
                + "s += \"Content-Type: text/html\\r\\n\\r\\n\";\n"
                + "s += \"<!DOCTYPE HTML>\\r\\n<html>\\r\\n\";\n\n";


    }

    protected String variable_description_gen(String description, String author) {

     return "s+= \"<meta name=\"description\" content=\""+ description +"\">\";\n"
             + "s+= \"<meta name=\"author\" content= \""+ author +"\">\";\n";
    }

    protected String wrap_up_gen(){

        return "// put logic here\n\n"

                + "// Send the response to the client\n"
                + "client.println(s);\n"
                + "client.println(header + css_start + css_html + css_end + body_start + div_start + div_end + body_end + html_end);\n"
                + "delay(1);\n"
                + "Serial.println(\"Client disonnected\");\n"

                + "// The client will actually be disconnected\n"
                + "// when the function returns and 'client' object is detroyed\n"
                + "}\n";
    }

    protected String bootstrap_gen(){

        return "<!-- Bootstrap core CSS -->"
                +"<link href=\"dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                +"<!-- Custom styles for this template -->\n"
                +"<link href=\"dist/css/Robo.css\" rel=\"stylesheet\">\n"
                +"<link href=\"dist/css/acm_small.css\" rel=\"stylesheet\" media = \"min-width: 600px)\">\n"
                +"<script src=\"assets/js/ie-emulation-modes-warning.js\"></script>\"\n";
    }

    protected String wifi_gen(){
        //TODO put html here
        return   "void setupWiFi() {\n"

                    + "WiFi.mode(WIFI_AP);\n\n"

                    + "   // Do a little work to get a unique-ish name. Append the"
                    + "   // last two bytes of the MAC (HEX'd) to \"Thing-\":\n"
                    + "   uint8_t mac[WL_MAC_ADDR_LENGTH];\n"
                    + "   WiFi.softAPmacAddress(mac);\n"
                    + "   String macID = String(mac[WL_MAC_ADDR_LENGTH - 2], HEX) +\n"
                    + "      String(mac[WL_MAC_ADDR_LENGTH - 1], HEX);\n"
                    + "   macID.toUpperCase();\n"
                    + "   String AP_NameString = \"ESP8266 network \" + macID;\n\n"

                    + "   char AP_NameChar[AP_NameString.length() + 1];\n"
                    + "   memset(AP_NameChar, 0, AP_NameString.length() + 1);\n\n"

                    + "  for (int i=0; i<AP_NameString.length(); i++)\n"
                    + "    AP_NameChar[i] = AP_NameString.charAt(i);\n\n"

                    + "  WiFi.softAP(AP_NameChar, WiFiAPPSK);\n"
                    + "}"

                    + "void initHardware() {\n"
                    + "   Serial.begin(115200);\n"
                    + "   pinMode(GPIO1, OUTPUT);\n"
                    + "   pinMode(GPIO2, OUTPUT);\n"
                    + "   digitalWrite(GPIO1, LOW);\n"
                    + "}\n\n"

                    + "void setup(){\n"
                    + "   initHardware();\n"
                    + "   setupWiFi();\n"
                    + "   server.begin();\n"
                    + "} \n";
    }

}
