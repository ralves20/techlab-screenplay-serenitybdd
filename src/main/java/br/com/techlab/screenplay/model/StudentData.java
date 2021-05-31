package br.com.techlab.screenplay.model;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class StudentData {
    public static final Map<String, String> DEFAULT_VALID_DATA = ImmutableMap.<String, String>builder()
            .put("name", "José").put("lastName", "da Silva").put("email", "zehdasilva@mailinator.com")
            .put("mobileNumber", "1990008888").put("birthDate", "25 Mar 2021").put("subjects", "Computer Science")
            .put("gender", "Male").put("address", "rua longe pra caramba, 500").put("hobby", "Sports")
            .put("state", "Haryana").put("city", "Panipat").build();
}
