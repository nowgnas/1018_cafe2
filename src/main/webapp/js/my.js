$(document).ready(() => {
    $("#loginBtn").click(() => {
        let id = $("#loginId").val();
        let pw = $("#loginPw").val();

        $.post("login.shop", {id, pw}, (data) => {
            let obj = JSON.parse(data);
            if (obj.name) {
                data = obj.name + "<input type='button' value='logout' id='logoutBtn' class='btn btn-primary'>";
                $.cookie("logined", data);
                $("#msgDiv").html(data);
            } else {
                alert(obj.msg);
                location.reload();
            }
        })
    })

    $("#memberInsertBtn").click(() => {
        let name = $("#name").val();
        let id = $("#id").val();
        let pw = $("#pw").val();

        $.post("../memberInsert.shop", {name, id, pw}, (data) => {
            alert(data);
            window.close();
        })
    })
})