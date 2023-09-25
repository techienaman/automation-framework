package com.vinsguru.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinsguru.test.vendorportal.VendorPortalTest;
import org.bouncycastle.util.encoders.UTF8;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil {
    static ObjectMapper mapper=new ObjectMapper();


    public static VendorPortalTest getTestData(String path){
       try{
           InputStream stream=ResourceLoader.getResource(path);
           return mapper.readValue(stream,VendorPortalTest.class);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
