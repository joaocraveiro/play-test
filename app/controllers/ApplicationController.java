package controllers;

import modules.neo4j.Neo4jConfig;
import nodes.UserNode;
import play.mvc.*;
import views.html.index;

import javax.inject.Inject;

public class ApplicationController extends Controller {

    Neo4jConfig neo4j;

    @Inject
    public ApplicationController(Neo4jConfig neo4j) {
        this.neo4j = neo4j;
    }

    public Result index(){
        return ok(index.render());
    }

    public Result getIndex() {
        System.out.println("Performing GET index");
        try {
            UserNode userNode = neo4j.getSession().load(UserNode.class, 1l);
            System.out.println("Neo4j loaded entity " + userNode.entityId);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ok(index.render());
    }

    public Result postIndex() {
        System.out.println("Performing POST index");
        try {
            UserNode userNode = neo4j.getSession().load(UserNode.class, 1l);
            System.out.println("Neo4j loaded entity " + userNode.entityId);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ok(index.render());
    }

}

