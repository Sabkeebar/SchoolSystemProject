package miu.edu.ApiGateWayservice.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component

public class Validator {
    public static final List<String> apiEndPoint = List.of(
            "/login",
            "/api/**"

    );
    public Predicate<ServerHttpRequest> isSecured =request->apiEndPoint.stream()
            .noneMatch(uri->request.getURI().getPath().contains(uri));
}
