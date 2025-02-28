//package com.common.custom;

//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.env.Environment;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.springframework.test.util.AssertionErrors.assertNotNull;
//
//
//@SpringBootTest
//@ActiveProfiles("default")
//public class ApplicationPropertiesTest {
//
//    @Autowired
//    private Environment env;
//
//    @Test
//    public void testMongoDbUri() {
//        String mongoUri = env.getProperty("spring.data.mongodb.uri");
//        assertNotNull(mongoUri, "A propriedade spring.data.mongodb.uri não foi carregada.");
//        System.out.println("MongoDB URI: " + mongoUri);
//    }
//}

