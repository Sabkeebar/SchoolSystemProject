package miu.edu.ApiGateWayservice.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import miu.edu.ApiGateWayservice.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class GetWayFilter extends AbstractGatewayFilterFactory <AbstractGatewayFilterFactory.NameConfig> {
@Autowired
Validator validator;
@Autowired
JwtUtil jwtUtil;

@Override
public GatewayFilter apply(NameConfig config) {
//    return (exchange, chain) -> {
//        // Retrieve the required information from the token (e.g., user ID) and add it as a header
//        String userId = "your-user-id"; // Replace with actual user ID
//        exchange.getRequest().mutate().headers(headers -> headers.add("X-User-Id", userId));
//        return chain.filter(exchange);
//    };
//}
    return ((exchange, chain) -> {
        if (validator.isSecured.test(exchange.getRequest())) {
            //header contains token or not
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("missing authorization header");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
            }
            try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                jwtUtil.validateToken(authHeader);

            } catch (Exception e) {
                System.out.println("invalid access...!");
                throw new RuntimeException("un authorized access to application");
            }
            Claims claims = jwtUtil.getAllClaimsFromToken(authHeader);
            exchange.getRequest().mutate().headers(header-> header.add("claims", claims.toString()));
        }
        return chain.filter(exchange);
    });

}

}

