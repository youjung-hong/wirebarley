package com.wirebarley.currency;

import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiController {
  @GetMapping("/api/currency")
  public HttpEntity<JSONObject> getCurrency() {
    String url = "http://apilayer.net/api/live?access_key=56815509ca152c427efcecdd496cee27&currencies=KRW,JPY,PHP&source=USD&format=1";
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

    HttpEntity<?> entity = new HttpEntity<>(headers);

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.exchange(
        url,
        HttpMethod.GET,
        entity,
        JSONObject.class);
  };
}
