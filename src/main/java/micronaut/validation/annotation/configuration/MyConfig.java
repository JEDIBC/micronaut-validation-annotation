package micronaut.validation.annotation.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.Introspected;

@ConfigurationProperties("my.config")
@Introspected
public class MyConfig extends AbstractConfiguration {
}
