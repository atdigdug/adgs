package com.mavin.egifting.utils;

import java.net.URL;

import org.junit.Test;

public class S3UtilsTest {

    @Test
    public void getPreSignedURL() throws Exception {
        URL url = S3Utils.getPreSignedURL("mavin-egifting", "test");
        System.out.println(url.toString());
    }

    @Test
    public void uploadObject() throws Exception {
        URL url = S3Utils.getPreSignedURL("mavin-egifting", "test");
        S3Utils.uploadObject(url);
    }

    @Test
    public void test() {
        System.out.println(Status.ACTIVE.toString().equalsIgnoreCase("deactivated"));
    }

}