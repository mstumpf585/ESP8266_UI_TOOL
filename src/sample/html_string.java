package sample;

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

        return "<!DOCTYPE html>/n <html lang=\"en\">/n <head>\n"
                + "<meta charset=\"utf-8\"> \n"
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n";
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
