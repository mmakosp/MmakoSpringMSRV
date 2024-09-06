package com.mmako.spring;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/helloService")
@Api(value = "MSRV", description = "MSRV task")
public class HelloController {

    private final ServiceProfile serviceProfile;
    private final ApplicationConfiguration applicationConfiguration;

    @Autowired
    public HelloController(ServiceProfile serviceProfile,
                           ApplicationConfiguration applicationConfiguration) {
        this.serviceProfile = serviceProfile;
        this.applicationConfiguration = applicationConfiguration;
    }

    @GetMapping("/getHello")
    @ApiOperation(value = "success message", response = String.class)
    public String hello() {
        return applicationConfiguration.successMessage();
    }

    @GetMapping("/serviceUser")
    @ApiOperation(value = "service user", response = ServiceUser.class)
    public ServiceUser serviceUser() {
        return serviceProfile.serviceUser();
    }

    @PostMapping("/postHello")
    @ApiOperation(value = "serviceUser post hello", response = ServiceUser.class)
    public ServiceUser postHello(@RequestBody ServiceUser serviceUser) {
        return serviceUser;
    }
}
