package micronaut.validation.annotation.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.validator.Validator;
import micronaut.validation.annotation.configuration.MyConfig;

import javax.validation.Valid;

@Controller
public class ConfigController {
    private MyConfig  config;
    private Validator validator;

    public ConfigController(@Valid MyConfig config, Validator validator) {
        this.config    = config;
        this.validator = validator;
    }

    @Get("/count")
    public String getCount() {
        return "Config value : " + config.getCount() + "\nViolations count : " + validator.validate(config).size();
    }
}
