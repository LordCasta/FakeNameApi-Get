package com.fakename.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetNameTask implements Task {

    private final String genero;

    private final String localidad;

    public GetNameTask(String genero,String localidad) {
        this.genero = genero;
        this.localidad = localidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(localidad+genero).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("accept", "application/json")
                                .log().all()
                )
        );
    }

    public static Performable conElApi(String localidad, String genero) {
        return instrumented(GetNameTask.class, localidad,genero);
    }

}
