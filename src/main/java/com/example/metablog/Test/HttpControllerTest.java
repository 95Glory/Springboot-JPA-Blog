package com.example.metablog.Test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)

// 사용자가 요청 -> 응답(Data)

@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpController Test :";

    // 인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다.
    //http://localhost:8080/http/get(select)
    @GetMapping("/http/get")
    public String getTest(Member m){//id=1&username=ssar&password=1234&Email=ssar@nate.com

        return "get 요청: "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }

    //http://localhost:8080/http/post(insert)
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){

        return "post 요청: "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }

    //http://localhost:8080/http/put(update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){

        return "put 요청: "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }

    //http://localhost:8080/http/delete(delete)
    @DeleteMapping("/http/delete")
    public String deleteTest(){

        return "delete 요청";
    }
}
