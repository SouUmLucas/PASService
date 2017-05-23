package main;

import javax.xml.ws.Endpoint;
import sei.*;
import sib.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String bindingURI = "http://127.0.0.1:9876/passervice";
        IPASServiceSEI service = new PASServiceImpl();
        Endpoint.publish(bindingURI, service);
        System.out.println("Server started at: " + bindingURI);
    }
}
