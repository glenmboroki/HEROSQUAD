import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        int port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> foundSquad = Squad.getAll();
            model.put("squads",foundSquad);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "allsquads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfListToFind = Integer.parseInt(request.params("id"));
            Squad foundSquad = Squad.findById(idOfListToFind);
            Hero foundHero = Hero.findById(idOfListToFind);
            model.put("squad",foundSquad);
            model.put("hero", foundHero);
            return new ModelAndView(model, "stats.hbs");
        }, new HandlebarsTemplateEngine());

        // new Squads
        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squad = request.queryParams("squad");
            String squadCause = request.queryParams("squadCause");
            model.put("squad",squad);
            model.put("cause", squadCause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // Heroes form
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> foundHero = Hero.getAll();
            ArrayList<Squad> allSquads = Squad.getAll();
            model.put("heroes",foundHero);
            model.put("squads", allSquads);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());
        // All Heroes
        get("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "allheroes.hbs");
        }, new HandlebarsTemplateEngine());

        // hero Id update
        get("/heroes/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        // New Heroes form
        post("/heroes/new", (request, response) -> {
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String heroAbility = request.queryParams("heroAbility");
            String heroWeakness = request.queryParams("heroWeakness");
            int selectedSquadId = Integer.parseInt(request.queryParams("selected-squad"));
//            ArrayList<Squad> allSquads = Squad.getAll();
            Squad selectedSquad = Squad.findById(selectedSquadId);
            String squadName = selectedSquad.getName();
            new Hero(name, age, heroAbility, heroWeakness, squadName);
//            model.put("name", name);
//            model.put("age", age);
//            model.put("heroAbility", heroAbility);
//            model.put("heroWeakness", heroWeakness);
//            model.put("allSquads", allSquads);
//            model.put("squadName", squadName);
//            model.put("newHero", newHero);
//
            System.out.println(name);
            System.out.println(age);
            System.out.println(heroAbility);
            System.out.println(selectedSquad);
            System.out.println(heroWeakness);
            System.out.println(name);

            response.redirect("/" );
            return null ;
        }, new HandlebarsTemplateEngine());

    }
}
//local host