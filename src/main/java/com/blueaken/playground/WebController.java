package com.blueaken.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by win10 on 2017/8/13.
 */
@RestController
public class WebController {

    private final Logger log = Logger.getLogger(this.getClass().toString());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){

        ServiceInstance instance = client.getLocalServiceInstance();

        log.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        return "Hello World !";
    }

}
