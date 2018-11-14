package io.testproject.tests;

import io.testproject.examples.sdk.tests.BasicTest;
import io.testproject.examples.sdk.tests.ExtendedTest;
import io.testproject.examples.sdk.tests.ProxyTest;
import io.testproject.java.sdk.v2.Runner;

public class Tests {

    public static void runTest(Runner runner) throws Exception {
        BasicTest test = new BasicTest();
        test.name = "John Smith";
        test.password = "12345";
        test.country = "United States";
        test.address = "5000 Highway 7 East";
        test.email = "john.smith@tertproject.io";
        test.phone = "+1 (905) 515-2000";

        // Run action
        runner.run(test);
    }

    public static void runExtendedTest(Runner runner) throws Exception {
        ExtendedTest test = new ExtendedTest();
        test.name = "John Smith";
        test.password = "12345";
        test.country = "United States";
        test.address = "5000 Highway 7 East";
        test.email = "john.smith@tertproject.io";
        test.phone = "+1 (905) 515-2000";

        // Run action
        runner.run(test);
    }

    public static void runProxyTest(Runner runner) throws Exception {
        // Create test
        ProxyTest test = new ProxyTest();
        test.name = "John Smith";
        test.password = "12345";
        test.country = "United States";
        test.address = "5000 Highway 7 East";
        test.email = "john.smith@tertproject.io";

        // Run test
        runner.run(test);
    }
}
