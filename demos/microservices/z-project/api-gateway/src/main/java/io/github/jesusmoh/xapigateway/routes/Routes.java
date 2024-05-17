package io.github.jesusmoh.xapigateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionProduct() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/products"),
                        HandlerFunctions.http("http://lenovopc-local:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionOrder() {
        return GatewayRouterFunctions.route("orders_service").route(RequestPredicates.path("/api/orders"),
                HandlerFunctions.http("http://lenovopc-local:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionInventoy() {
        return GatewayRouterFunctions.route("inventory_service").route(RequestPredicates.path("/api/inventory"),
                HandlerFunctions.http("http://lenovopc-local:8083"))
                .build();
    }
}
