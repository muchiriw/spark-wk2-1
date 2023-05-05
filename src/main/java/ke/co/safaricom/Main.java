package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        staticFileLocation(folder:"/public"));
        get("/", (req,res) -> {
             Map<String, String> payLoad = new HashMap<>();
             return new ModelAndView(payLoad,viewName:"home.hbs");
         }; new HandlebarsTemplateEngine());


        get("/", (req,res) -> {
            return ModelAndView(new HashMap<>(), viewName:"home.hbs");
        }, new HandlebarsTemplateEngine());

        });

    }
}