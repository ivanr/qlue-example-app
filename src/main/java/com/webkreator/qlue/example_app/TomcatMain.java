package com.webkreator.qlue.example_app;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.tomcat.util.scan.Constants;

/**
 * Run a web application (determined using the given home directory)
 * using Tomcat on the given IP address and port.
 */
public class TomcatMain {

    public static void main(String[] args) throws Exception {
        // Handle command line options
        Options options = new Options();
        options.addOption("h", "home", true, "application home path");
        options.addOption("I", "ip", true, "IP address");
        options.addOption("P", "port", true, "port");

        CommandLineParser parser = new PosixParser();
        CommandLine commandLine = null;

        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException pe) {
            System.err.println("Failed to parse command line: "
                    + pe.getMessage());
            System.exit(1);
        }

        String home = new File("./web").getAbsolutePath();

        if (commandLine.hasOption("home")) {
            home = commandLine.getOptionValue("home");
            home = new File(home).getAbsolutePath();
        }

        Integer port = 8080;
        if (commandLine.hasOption("port")) {
            port = Integer.parseInt(commandLine.getOptionValue("port"));
        }

        String hostname = null;
        if (commandLine.hasOption("ip")) {
            hostname = commandLine.getOptionValue("ip");
        }

        Tomcat tomcat = new Tomcat();

        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));

        if (hostname != null) {
            tomcat.setHostname(hostname);
        }

        // Disable StandardJarScanFilter.
        System.setProperty(Constants.SKIP_JARS_PROPERTY, "*");

        tomcat.setPort(port);
        tomcat.getConnector();
        tomcat.addWebapp("", home);

        if ((port == 443)||(port == 8443)) {
            String keystoreFile = home + "/WEB-INF/dev-keystore";
            String keystorePass = "changeit";

            tomcat.getConnector().setScheme("https");
            tomcat.getConnector().setSecure(true);
            tomcat.getConnector().setProperty("SSLEnabled", "true");
            tomcat.getConnector().setProperty("keystoreFile", keystoreFile);
            tomcat.getConnector().setProperty("keystorePass", keystorePass);
        }

        tomcat.start();
        tomcat.getServer().await();
    }
}