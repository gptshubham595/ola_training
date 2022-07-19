package com.olacabs.social.controller;

import com.olacabs.social.model.PostRequestData;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = {"application/json"})
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/about")
    public String about() {
        return "About User";
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public String save(@RequestBody PostRequestData data) {
        //PostRequestData data is a JSON object containing username and description
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.writeValueAsString(data);
//        }
//        catch (JsonGenerationException | JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        return "Saved";
    }
}
