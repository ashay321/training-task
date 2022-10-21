package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void twoPlusTwoEqualFour() {
        UserController cont = new UserController();
        assertEquals(4, cont.addFunc(2, 2));
    }

    @Test
    void checkGetMappingOfUsers() {
        UserController cont = new UserController();
        ResponseEntity res = cont.getUsers();

        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void checkPostMappingOfUsers() {
        UserController cont = new UserController();

        User user = new User("Ashay", "wan", "dfad", "asdfad", "odsafjoidajd");

        ResponseEntity res =  cont.createUser(user);

        assertEquals(res.getStatusCode(), HttpStatus.OK);
        assertEquals(res.getBody(), user);
    }


    @Test
    void checkPutMappingOfUsers() {
        int idToBeUpdated = 0;

        UserController cont = new UserController();

        try {
            User user = new User("Ashay", "wan", "dfad", "asdfad", "odsafjoidajd");
            ResponseEntity res = cont.deleteTask(idToBeUpdated);


            assertEquals(res.getStatusCode(), HttpStatus.OK);
            assertEquals(cont.getUsersData().containsKey(idToBeUpdated), true);
            assertEquals(cont.getUsersData().get(idToBeUpdated), res.getBody());
        } catch (Exception e) {
            assertEquals(e.getMessage(), "ID does not exist");
        }

    }

    @Test
    void checkDeleteMappingOfUsers() {
        int idToBeDeleted = 0;

        UserController cont = new UserController();

        try {
            ResponseEntity res = cont.deleteTask(idToBeDeleted);

            assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
            assertEquals(cont.getUsersData().containsKey(idToBeDeleted), false);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "ID does not exist");
        }

    }


}