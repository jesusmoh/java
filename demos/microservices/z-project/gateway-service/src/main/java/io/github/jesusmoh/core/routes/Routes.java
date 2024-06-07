package io.github.jesusmoh.core.routes;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import lombok.Data;

@Component
@Data
public class Routes {

        @Value("${z.product.service.url}")
        private String zProductServiceUrl;

        @Value("${z.product.service.path}")
        private String zProductServicePath;

        @Value("${z.order.service.url}")
        private String zOrderServiceUrl;

        @Value("${z.order.service.path}")
        private String zOrderServicePath;

        @Value("${z.inventory.service.url}")
        private String zInventoryServiceUrl;

        @Value("${z.inventory.service.path}")
        private String zInventoryServicePath;

        @Bean
        public RouterFunction<ServerResponse> fallbackRoute() {
                return route("fallbackRoute")
                                .GET("/fallbackRoute",
                                                request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
                                                                .body("Service Unavailable, please try again later"))
                                .build();
        }

        @Bean
        public RouterFunction<ServerResponse> routerFunctionProduct() {
                return GatewayRouterFunctions.route("product_service")
                                .route(RequestPredicates.path(zProductServicePath),
                                                HandlerFunctions.http(zProductServiceUrl))
                                .filter(circuitBreaker("productServiceCircuitBreaker",
                                                URI.create("forward:/fallbackRoute")))
                                .build();
        }

        @Bean
        public RouterFunction<ServerResponse> routerFunctionOrder() {
                return GatewayRouterFunctions.route("order_service")
                                .route(RequestPredicates.path(zOrderServicePath),
                                                HandlerFunctions.http(zOrderServiceUrl))
                                .filter(circuitBreaker("orderServiceCircuitBreaker",
                                                URI.create("forward:/fallbackRoute")))
                                .build();
        }

        @Bean
        public RouterFunction<ServerResponse> routerFunctionInventory() {
                return GatewayRouterFunctions.route("inventory_service")
                                .route(RequestPredicates.path(zInventoryServicePath),
                                                HandlerFunctions.http(zInventoryServiceUrl))
                                .filter(circuitBreaker("inventoryServiceCircuitBreaker",
                                                URI.create("forward:/fallbackRoute")))
                                .build();
        }

}
