package ke.co.safaricom;

import models.squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sql2o.*;

public class Main {
    public static <Squad> void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.hbs";

        get("/", (req,res)->{
            Map<String,Object> model = new HashMap<String, Object>();
             model.put("template", "templates/home.hbs");
             return new ModelAndView(model,layout);
         }, new HandlebarsTemplateEngine());


        get("/squads/new", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squad-form.hbs");
            return new ModelAndView(model,layout);
          },new HandlebarsTemplateEngine());



        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            String weakness = request.queryParams("weakness");
            Squad newSquad = (Squad) new squad(name, cause, weakness);
            model.put("template", "templates/squad-success.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());


    }}


