package com.fakename.stepDefinitions;

import com.fakename.tasks.GetNameTask;
import io.cucumber.java.es.*;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.fakename.constants.Constants.URL_Base;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateGetNameStepDefinitions {

    private static final String  restAPIUrl = URL_Base;

    @Cuando("Envio peticion al api con el genero {string} localidad {string}")
    public void envioPeticionAlEndpointConElNameId( String genero, String localidad) {
        // Write code here that turns the phrase above into concrete actions
        Actor user  = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));

        user.attemptsTo(
                GetNameTask.conElApi(localidad,genero)

        );
    }
    @Entonces("Valido el codigo de respuesta {string}")
    public void validoElCodigoDeRespuesta(String codigo) {
        // Write code here that turns the phrase above into concrete actions
        Actor user = Actor.named("user");

        String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());
        user.should(
                seeThat("El codigo de respuesta es ",res->codeRest,equalTo(codigo))
        );
    }

}
