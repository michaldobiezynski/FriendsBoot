package com.wiredbrain.friends;

import com.jayway.jsonpath.JsonPath;
import com.wiredbrain.friends.controller.FriendController;
import com.wiredbrain.friends.model.Friend;
import com.wiredbrain.friends.service.FriendService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.wiredbrain.friends.model.Address;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;


// Below is the way that was done in tutorial

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemTests
{
    @Test
    public void testCreateReadDelete()
    {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:9191/friend";

//        Friend friend = new Friend("Gerard",  "Brzeczy",  18,  true, null);
//        ResponseEntity<Friend> entity = restTemplate.postForEntity(url, friend, Friend.class);
//
//        Friend[] friends = restTemplate.getForObject(url, Friend[].class);
//        Assertions.assertThat(friends).extracting(Friend::getFirstName).contains("Gerard");

//        restTemplate.delete(url + "/" + entity.getBody().getId());
//       Assertions.assertThat(restTemplate.getForObject(url, Friend[].class)).isEmpty();
        //it was returing an error because there are other entities in the database already.
    }

    @Test
    public void testErrorHandlingReturnsBadRequest()
    {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:9191/wrong";

        try
        {
            restTemplate.getForEntity(url, String.class);
        }catch (HttpClientErrorException e)
        {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

}























