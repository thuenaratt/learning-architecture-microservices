package co.ecommerce.order;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/nacos/config")
@RefreshScope
@RequiredArgsConstructor
public class NacosConfigController {

    private final NacosConfigProps nacosConfigProps;
    private final JwtAuthenticationConverter jwtAuthenticationConverter;

//    @Value("${service.name}")
//    private String serviceName;
//
//    @Value("${service.info}")
//    private String serviceInfo;
//
//    @Value("${service.version}")
//    private String serviceVersion;

    @GetMapping
    public Map<String, Object> getConfig() {
        return Map.of(
                "serviceName", nacosConfigProps.getName(),
                "serviceBasicInfo", nacosConfigProps.getBasicInfo(),
                "serviceVersion", nacosConfigProps.getVersion()

        );
    }

    @GetMapping("/secured")
    public Map<String, Object> getSecuredConfig(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "serviceName", nacosConfigProps.getName(),
                "serviceBasicInfo", nacosConfigProps.getBasicInfo(),
                "serviceVersion", nacosConfigProps.getVersion(),
                "accessToken", jwt.getTokenValue()


        );
    }
}
