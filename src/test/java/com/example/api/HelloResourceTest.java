package com.example.api;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloResourceTest extends Mockito {

    @InjectMocks
    HelloResource helloResource = new HelloResource();

    @Test
    void testGetPersonsWithRoleSuccess(){
        String response = "[\n" +
                "  {\n" +
                "    \"name\": \"Ada\",\n" +
                "    \"role\": \"foo\",\n" +
                "    \"id\": \"1a382809-b7c0-3f68-ae12-dd15677c5497\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Kevin\",\n" +
                "    \"role\": \"foo\",\n" +
                "    \"id\": \"f1cd318e-412b-3f72-a6e5-f377a9544ff7\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Stanley\",\n" +
                "    \"role\": \"foo\",\n" +
                "    \"id\": \"b34c7c6f-be78-3382-9bd9-496c54e5eeeb\"\n" +
                "  }\n" +
                "]";
        String role = "foo";

        assertEquals(response, helloResource.getPersonsWithRole(role).getEntity().toString());
        assertEquals(200, helloResource.getPersonsWithRole(role).getStatus());
    }

    @Test
    void testGetPersonsWithRoleNotFound(){
        String role = "fo";
        assertEquals(404, helloResource.getPersonsWithRole(role).getStatus());
    }

    @Test
    void testGetUserFromIdSuccess(){
        String id = DataStore.getInstance().getPersonRole("foo").get(0).getId();
        String response ="{\n" +
                "  \"name\": \"Ada\",\n" +
                "  \"role\": \"foo\",\n" +
                "  \"id\": \"1a382809-b7c0-3f68-ae12-dd15677c5497\"\n" +
                "}";

        assertEquals(200, helloResource.getUserFromId(id).getStatus());
        assertEquals(response, helloResource.getUserFromId(id).getEntity().toString());
    }

    @Test
    void testGetUserFromIdNotFound(){
        assertEquals(404,helloResource.getUserFromId("t").getStatus());
    }

    @Test
    void postUserSuccess(){
        String user ="{ \"name\" : \"Ada\", \"role\" : \"oh\" }";
        assertEquals(200, helloResource.postUser(user).getStatus());
    }

}
