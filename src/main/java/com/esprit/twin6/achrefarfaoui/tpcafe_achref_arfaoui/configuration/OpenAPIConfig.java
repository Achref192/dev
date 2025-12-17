package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class OpenAPIConfig {
    @Bean
    public OpenAPI cafeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("☕ TP Café API - Developed  by Achref Arfaoui")
                        .description("""
                                <b>Documentation de l'API du projet TPCafé</b><br>
                                Cette API permet de gérer les entités suivantes :
                                <ul>
                                  <li>👤 Clients</li>
                                  <li>📦 Commandes & Détails</li>
                                  <li>🍰 Articles & Promotions</li>
                                  <li>📍 Adresses & Cartes de fidélité</li>
                                </ul>
                                <hr>
                                <i>Développée Par Arfaoui Achref</i>
                                """)
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Achref Arfaoui")
                                .email("achref.arfaoui@esprit.tn")
                                .url("https://www.linkedin.com/in/achref-arfaoui-124b21290")
                        )
                        .license(new License()
                                .name("Projet universitaire ESPLIT - 2025")
                                .url("https://esprit.tn/")
                        )
                )
                .servers(List.of(
                        new Server().url("http://localhost:8089/TPAchref").description("Serveur local"),
                        new Server().url("https://api.tpcafe-achref.tn").description("Serveur distant (prod)")
                ))
                .externalDocs(new ExternalDocumentation()
                        .description("My github Account")
                        .url("https://github.com/Achref192")
                );
    }
}
