import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App<Sql2o> {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    //String connectionString = "jdbc:postgresql://ec2-34-230-110-100.compute-1.amazonaws.com:5432/damc10c69i49hq"; //!
    //Sql2o sql2o = new Sql2o(connectionString, "ybfymeaptjosmq", "fd95b40d72d77f62fdd69798183155c729ab86294c5bb2853aefffcc58e011d6"); //!

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");


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
            new Squad(squad, squadCause);
            model.put("squad",squad);
            model.put("cause", squadCause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> foundHero = Hero.getAll();
            ArrayList<Squad> allSquads = Squad.getAll();
            model.put("heroes",foundHero);
            model.put("squads", allSquads);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "allheroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (request, response) -> {
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String heroAbility = request.queryParams("heroAbility");
            String heroWeakness = request.queryParams("heroWeakness");
            int selectedSquadId = Integer.parseInt(request.queryParams("selected-squad"));
            Squad selectedSquad = Squad.findById(selectedSquadId);
            String squadName = selectedSquad.getName();
            new Hero(name, age, heroAbility, heroWeakness, squadName);
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