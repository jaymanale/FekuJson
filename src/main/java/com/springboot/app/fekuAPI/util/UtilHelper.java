package com.springboot.app.fekuAPI.util;

import com.github.javafaker.Faker;

public class UtilHelper {

    public static final Faker FAKER = Faker.instance();
    public static Faker faker() {return FAKER;}
}
