package tech.donau;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Values;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/books")
public class BookResource {
    @Inject
    Driver driver;

    @GET
    @Produces(APPLICATION_JSON)
    public String test() {
        driver.session().writeTransaction(it -> {
            it.run("CREATE (f:Fruit {name: $name}) RETURN f", Values.parameters("name", "parasha")).consume();
            return it;
        });
    };
}
