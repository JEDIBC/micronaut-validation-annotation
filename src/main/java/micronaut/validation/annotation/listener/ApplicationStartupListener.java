package micronaut.validation.annotation.listener;

import io.micronaut.runtime.event.ApplicationStartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.validation.validator.Validator;
import micronaut.validation.annotation.configuration.MyConfig;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;

@Singleton
public class ApplicationStartupListener {

    private MyConfig  config;
    private Validator validator;

    @Inject
    public ApplicationStartupListener(@Valid MyConfig config, Validator validator) {
        this.config    = config;
        this.validator = validator;
    }

    @EventListener
    public void onApplicationStartup(ApplicationStartupEvent event) {
        System.out.println("Config value : " + config.getCount());
        System.out.println("Violations count : " + validator.validate(config).size());
    }
}
