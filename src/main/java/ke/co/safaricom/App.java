package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String[] powersAdd = request.queryMap().toMap().get("power");
            ArrayList<String> powers = new ArrayList<String>();
            for (int i = 0; i < powersAdd.length; i++) {
                powers.add(powersAdd[i]);
            }
            model.put("powers", powers);

            String[] weaknessAdd = request.queryMap().toMap().get("weakness");
            ArrayList<String> weaknesses = new ArrayList<String>();
            for (String s : weaknessAdd) {
                weaknesses.add(s);
            }
            model.put("weaknesses", weaknesses);

            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            int squadId = Integer.parseInt(request.queryParams("squadId"));
            Hero hero = new Hero(name, age, powers, weaknesses, squadId);
            model.put("hero", hero);
            return new ModelAndView(model, "successHero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            for (Hero hero : heroes) {
                int heroFindId = hero.getId();
                Squad squad = Squad.findById(heroFindId);
                model.put("squad", squad);
            }
            return new ModelAndView(model, "heroesList.hbs");
        }, new HandlebarsTemplateEngine());


        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params("id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            int squadId = foundHero.getId();
            Squad squad = Squad.findById(squadId);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("squad", squad);
            model.put("hero", foundHero);
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroesList.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String cause = request.queryParams("cause");
            Squad squad = new Squad(maxSize, name, cause);
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);

            return new ModelAndView(model, "squadList.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params("squadId"));
            Hero heroes = Hero.findById(squadId);
            Squad squads = Squad.findById(squadId);
            model.put("squad", squads);
            model.put("heroes", heroes);
            return new ModelAndView(model, "squadList.hbs");
        }, new HandlebarsTemplateEngine());


    }}
