let index = {
    init: function () {
        // jQuery 사용
        $("#btn-save").on("click", () => {
            this.save(); // save함수 이벤트로 호출
        });

},
    save: function () {
        let data = {
                    username: $("#username").val(),
                    password: $("#password").val(),
                    email: $("#email").val()
                };

       // ajax 호출시 default가 비동기 호출이다.
       // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청을 한다.
       // ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌.
        $.ajax({
            //회원가입 수행 요청
            type:"POST",
            url:"/auth/joinProc",
            data: JSON.stringify(data), // http body데이터
            contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지 (MIME)
            dataType: "json" // 요청을 서버로해서 응답이 왔을 때, 기본적으로 모든 것이 문자열 (생긴게 json이라면 javascript 오브젝트로 변경해줌)

        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
//            console.log(resp);
            location.href="/";
        }).fail(function(error){
            alert(JSON.stirngfy(error));
        });//ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

        },
    }

index.init();