package com.example.demo.utils;

import org.junit.Test;

import java.util.UUID;

public class idUtils {

        public static String getId(){
            Integer orderId=UUID.randomUUID().toString().hashCode();
            orderId = orderId < 0 ? -orderId : orderId;
            return orderId.toString();
        }
    }


