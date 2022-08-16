package com.example.metablog.Test;

import com.example.metablog.model.RoleType;
import com.example.metablog.model.User;
import com.example.metablog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다!";
        }
        return "삭제완료 id : "+id;
    }



    // http://localhost:8080/dummy/user/1
    // save 함수는 id를 전달하지 않으면 insert를 해주고
    // save 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
    // save 함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 한다.
    // email,password
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateuser(@PathVariable int id, @RequestBody User requestUser){
        System.out.println("id : "+id);
        System.out.println("pw : "+requestUser.getPassword());
        System.out.println("email : "+requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        //userRepository.save(user);
        return null;
    }

    //http://localhost:8080/dummy/users
    @GetMapping("/dummy/users")
    public List<User> list(){

        return userRepository.findAll();
    }


    // http://localhost:8080/dummy/user
    // 한 페이지당 2건에 데이터를 리턴받겠다
    @GetMapping("/dummy/user")
    public Page<User> pagelist(@PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
       Page<User> pagingUser = userRepository.findAll(pageable);

       List<User> users = pagingUser.getContent();
       return pagingUser;
    }


    //http://localhost:8080/dummy/user/(요청)
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // user/4(없는데이터)를 찾으면 내가 데이터베이스에서 못찾으면 user가 null
        // 그럼 null이 리턴이 되니 프로그램에 문제가 된다
        // 그래서 Optional로 user객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return한다.
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id:"+id);
            }
        });
        // 요청 : 웹 브라우저
        // user 객체=자바 오브젝트
        // 변환(웹브라우저가 이해할 수 있는 데이터) -> json(Gson 라이브러리)
        // 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson라이브러리를 호출해서
        // User 오브젝트를 json으로 변환해서 브라우저에 던져줌
        return user;
    }

    //http://localhost:8080/http//dummy/join(요청)
    //http의 body에 username,password,email 데이터를 가지고(요청)
    @PostMapping("/dummy/join")
    public String join(User user){
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
