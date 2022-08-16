let index = {
    init: function () {
        // jQuery 사용
        $("#btn-save").on("click", () => {
            this.save(); // save함수 이벤트로 호출
        });

        $("#btn-delete").on("click", () => {
                    this.deleteByid(); // save함수 이벤트로 호출
                });
        $("#btn-update").on("click", () => {
                            this.update(); // save함수 이벤트로 호출
                        });

},
    save: function () {
        let data = {
                    title: $("#title").val(),
                    content: $("#content").val(),
                };

        $.ajax({
            type:"POST",
            url:"/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지 (MIME)
            dataType: "json"
        }).done(function(resp){
            alert("글쓰기가 완료되었습니다.");
            location.href="/";
        }).fail(function(error){
            alert(JSON.stirngfy(error));
        });
        },

    deleteByid: function () {
        let id = $("#id").text();
        console.log(id);

        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
            dataType: "json",
        }).done(function (res) {
            alert("삭제가 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },
    update: function() {
            let id = $("#id").val();

            let data = {
                        title: $("#title").val(),
                        content: $("#content").val(),
                    };

            $.ajax({
                type:"PUT",
                url:"/api/board/"+id,
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지 (MIME)
                dataType: "json"
            }).done(function(resp){
                alert("글 수정이 완료되었습니다.");
                location.href="/";
            }).fail(function(error){
                alert(JSON.stirngfy(error));
            });
            },
    }

index.init();