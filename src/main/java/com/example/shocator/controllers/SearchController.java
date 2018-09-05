package com.example.shocator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Controller
public class SearchController {

    static String title = "Shocator";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", title);
        return "index";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchResults(@RequestParam(value = "phrase") String phrase, Model model) {
        String message = "You searched for '" + phrase + ".'";

        model.addAttribute("message", message);
        model.addAttribute("title", title);

        return "search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String processSearch(@RequestParam String phrase, Model model) {

        String urlTemplate = "http://www.omdbapi.com/?apikey=111c0be2&t=";
        String aURL = urlTemplate + phrase;
        String response = null;

        try {
            URL url = new URL(aURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /**

        // Connect to the URL using java's native library
        URL url = new URL(aURL);
        URLConnection request = url.openConnection();
        request.connect();
        /*
        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
        */

        return "redirect:" + aURL;
    }

}
