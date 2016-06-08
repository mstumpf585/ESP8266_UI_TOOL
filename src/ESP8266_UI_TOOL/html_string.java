package ESP8266_UI_TOOL;

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
                + "void loop()\n"
                + "{\n"
                + "// Check if a client has connected\n"
                + "WiFiClient client = server.available();\n"
                + "if (!client) {\n"
                + "return;\n"
                + "}\n"

                + "// Read the first line of the request\n"
                + "String req = client.readStringUntil('\r');\n"
                + "Serial.println(req);\n"
                + "client.flush();\n"

                + "// Match the request\n"
                + "int val = -1;                                // We'll use 'val' to keep track of both the\n"
                + "// request type (read/set) and value if set.\n"
                + "if (req.indexOf(\"/GPIO1/off\") != -1)\n"
                + "digitalWrite(GPIO1, 0);                      // Will write gpio1 low\n"
                + "else if (req.indexOf(\"/GPIO1/on\") != -1)\n"
                + "digitalWrite(GPIO1, 1);                      // Will write gpio1 high\n"
                + "else if (req.indexOf(\"/GPIO2/off\") != -1)\n"
                + "digitalWrite(GPIO2, 0);\n"
                + "else if (req.indexOf(\"/GPIO2/on\") != -1)\n"
                + "digitalWrite(GPIO2, 1);\n"

                + "// Otherwise request will be invalid. We'll say as much in HTML\n"
                + "client.flush();\n"

                + "// web response\n"
                + "String s = \"HTTP/1.1 200 OK\\r\\n\";\n"
                + "s += \"Content-Type: text/html\\r\\n\\r\\n\";\n"
                + "s += \"<!DOCTYPE HTML>\\r\\n<html>\\r\\n\";\n"

                + "// If we're setting the LED, print out a message saying we did\n"
                + "if (val >= 0)\n"
                + "{"
                + "s += \"Some Shit wentt down \";\n"
                + "}\n"
                + "else\n"
                + "{\n"
                + "s += \"Invalid Request.<br> Try /led/1, /led/0, or /read.\";\n"
                + "}\n"
                + "*/\n"


                + "// Send the response to the client\n"
                + "client.println(s);\n"
                + "client.println(header + css_start + css_html + css_gButton + css_end + body_start + div_start + fwd + back + div_end + body_end + html_end);\n"
                + "delay(1);\n"
                + "Serial.println(\"Client disonnected\");\n"

                + "// The client will actually be disconnected\n"
                + "// when the function returns and 'client' object is detroyed\n"
                + "}\n";
    }

    protected String variable_description_gen(String description, String author, String icon) {

     return   "<!-- leave blank till I figure that shit out-->\n"
                + "<meta name=\"description\" content=\""+ description +"\">\n"
                + "<meta name=\"author\" content= \""+ author +"\">\n"
                + "<link rel=\"icon\" href=\""+ icon +"\">\n"
                + "<title></title>\n";
    }

    protected String bootstrap_gen(){

        return "<!-- Bootstrap core CSS -->"
                +"<link href=\"dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                +"<!-- Custom styles for this template -->\n"
                +"<link href=\"dist/css/Robo.css\" rel=\"stylesheet\">\n"
                +"<link href=\"dist/css/acm_small.css\" rel=\"stylesheet\" media = \"min-width: 600px)\">\n"
                +"<script src=\"assets/js/ie-emulation-modes-warning.js\"></script>\"\n";
    }

    protected String discription_gen(){
        //TODO put acctual html here
        return "idk";
    }

    protected String Selection_gen(){
        //TODO put html here
        return "idk";
    }

    protected void Various_gen(){

        //TODO well I guess just open another UI here
    }
}
