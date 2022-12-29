<!-- 正则验证 start-->
/**
 * 判空
 *
 * @param obj
 * @returns {boolean}
 */
function isNull(obj) {
    if (obj == null || obj == undefined || obj.trim() == "") {
        return true;
    }
    return false;
}

/**
 * 参数长度验证
 *
 * @param obj
 * @param length
 * @returns {boolean}
 */
function validLength(obj, length) {
    if (obj.trim().length < length) {
        return true;
    }
    return false;
}

/**
 * 用户名称验证 4到16位（字母，数字，下划线，减号）
 *
 * @param userName
 * @returns {boolean}
 */
function validUserName(userName) {
    var pattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if (pattern.test(userName.trim())) {
        return (true);
    } else {
        return (false);
    }
}

function validcapacity(capacity) {

    if (Number(capacity)+1>1) {
        return (true);
    } else {
        return (false);
    }
}
/**
 * 用户密码验证 最少6位，最多20位字母或数字的组合
 *
 * @param password
 * @returns {boolean}
 */
function validPassword(password) {
    var pattern = /^[a-zA-Z0-9]{6,20}$/;
    if (pattern.test(password.trim())) {
        return (true);
    } else {
        return (false);
    }
}

<!-- 正则验证 end-->

function test(page){

alert(page+10)



}

function getactivities(page){
$(".title").html("title")

    $(".price").html("description")
    $(".price discount").hide()
    // $(".pic-1").attr("src","dist/img/img-10.png");


    $(".likes").css("color","aqua")
    $(".books").css("color","aqua")
    var turl="http://127.0.0.1:8125/view";
    $.ajax({
        type: "GET",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url:turl,
        //url:"http://127.0.0.1:8125/login?identity=${user.name}&pwd=${user.name}",
        // url: "users/login",
        contentType: "application/json; charset=utf-8",
        // params: JSON.stringify(data),
        // data:data,
        // data:JSON.stringify(data),
        // params:data,
        // params:{"identity": userName, "pwd": password},
        success: function (result) {

$(".title").each(function (index,element){
    $(element).html(result.data[page*8+index].head)

})
            $(".product-trend-label").each(function (index,element){
                $(element).html(result.data[page*8+index].content)

            })
           // $(".likes").attr("color","red")
            $(".likes").each(function (index,element){
                $(element).html(result.data[page*8+index].likeCount)

            })
            $(".cardcontent").each(function (index,element){

                $(element).html("起始时间："+result.data[page*8+index].startTime+'<br>'+"结束时间："+result.data[page*8+index].endTime)

            })
            $(".books").each(function (index,element){
                $(element).html(result.data[page*8+index].bookCount+"/"+result.data[page*8+index].capacity)

            })
            $(".activityid").each(function (index,element){
                $(element).html(result.data[page*8+index].activityId)
            })
            $(".anotheractivityid").each(function (index,element){
                $(element).html(result.data[page*8+index].activityId)
            })

            $(".activityidusetothumb").each(function (index,element){
                $(element).text(result.data[page*8+index].activityId)
            })
            $(".activitycapacity").each(function (index,element){
                $(element).html(result.data[page*8+index].capacity)
            })
            $(".activityidbooknum").each(function (index,element){
                $(element).html(result.data[page*8+index].bookCount)
            })

            return result;
        },
        error: function () {

            $('.alert-danger').css("display", "none");
            showErrorInfo("网络错误，请检查您的网络连接！");
            setTimeout(function (){
                $('.alert-danger').css("display", "none");
            },1000)
            return;
        }
    });

}function getparticipants (actiid,booknum){
    var data = Number(actiid)

    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "http://127.0.0.1:8125/getUsers",
        //url:"http://127.0.0.1:8125/login?identity=${user.name}&pwd=${user.name}",
        // url: "users/login",
        contentType: "application/json; charset=utf-8",
        // params: JSON.stringify(data),
        //data:data,
        data: JSON.stringify(data),
        // params:data,
        // params:{"identity": userName, "pwd": password},
        success: function (result) {
            $(".participants").each(function (index,element){

                if(index<booknum){

                    $(element).find(".bookeduserid").text(result.data[index].userId)
                        // $(element).find(".img-circle").attr("src",result[index].avatarUrl)
                    $(element).click(function (){
                        setCookie("participant",$(this).find(".bookeduserid").text())
                        window.location.href = "/bookeduserinformation.html";

                    })
                }


            })

        },error: function () {
            // $('.alert-info').css("display", "none");
            showErrorInfo("网络异常，获取参与者信息失败，请重试");
            setTimeout(function (){
                $('.alert-danger').css("display", "none");
            },1000)
            return;
        }

    })

}
function participantacti(activid){
    var userid=getCookie("token");
    var data = {"activityId":activid,"userId":userid}
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "http://127.0.0.1:8125/date",
        //url:"http://127.0.0.1:8125/login?identity=${user.name}&pwd=${user.name}",
        // url: "users/login",
        contentType: "application/json; charset=utf-8",
        // params: JSON.stringify(data),
        //data:data,
        data: JSON.stringify(data),
        // params:data,
        // params:{"identity": userName, "pwd": password},
        success: function (result) {

            showtips("预约成功，请按时参与")
            setTimeout(function (){
                $('.alert-info').css("display", "none");
            },1000)
        },error: function () {
            // $('.alert-info').css("display", "none");
            showErrorInfo("网络异常，请重试");
            setTimeout(function (){
                $('.alert-danger').css("display", "none");
            },1000)
            return;
        }

    })

}


function thumbupactivity(activid){



    // alert(JSON.stringify(activid).substring(1,activid.length+1))
    var data = Number(activid);
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "http://127.0.0.1:8125/addLike",
        //url:"http://127.0.0.1:8125/login?identity=${user.name}&pwd=${user.name}",
        // url: "users/login",
        contentType: "application/json; charset=utf-8",
        // params: JSON.stringify(data),
        //data:data,
        data: JSON.stringify(data),
        // params:data,
        // params:{"identity": userName, "pwd": password},
        success: function (result) {

            showtips("点赞成功！")
            setTimeout(function (){
                $('.alert-info').css("display", "none");
            },1000)
        },error: function () {
            // $('.alert-info').css("display", "none");
            showErrorInfo("网络异常，请重试");
            setTimeout(function (){
                $('.alert-danger').css("display", "none");
            },1000)
            return;
        }

    })

}

function submitnewacti(){



    var head = $("#newactivityhead").val();
    var content = $("#newactivitycontent").val();
    var capacity = $("#newactivitycapacity").val();
    var starttime = $("#newactivitystarttime").val();
    var endtime = $("#newactivityendtime").val();
    var type = $("#newactivitytype").val();
    if (isNull(head)) {
        showtips("请输入活动标题!");

         return;
    }if (isNull(content)) {
        showtips("请输入活动内容!");
         return;
    }if (isNull(capacity)) {
        showtips("请输入最大参与人数!");
        return;
    }if (isNull(starttime)) {
        showtips("请输入活动开始时间!");
         return;
    }if (isNull(endtime)) {
        showtips("请输入活动结束时间!");
         return;
    }if (!validcapacity(capacity)) {
        showtips("请输入正确的人数!");
         return;
    }

var creatorid=getCookie("token")

    console.log(creatorid)
    var data = {"head": head, "content": content,"startTime":starttime,"endTime" :endtime,"capacity":capacity,"creatorId": creatorid}
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "http://127.0.0.1:8125/addActivity",
        //url:"http://127.0.0.1:8125/login?identity=${user.name}&pwd=${user.name}",
        // url: "users/login",
        contentType: "application/json; charset=utf-8",
        // params: JSON.stringify(data),
        //data:data,
        data: JSON.stringify(data),
        // params:data,
        // params:{"identity": userName, "pwd": password},
        success: function (result) {

            window.location.href = "/cardlist.html";
        },error: function () {
            // $('.alert-info').css("display", "none");
            showtips("网络异常，请重试");
            setTimeout(function (){
                $('.alert-info').css("display", "none");
            },1000)
            return;
        }

    })




    // $("#close").trigger("click")
}
function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    if (isNull(userName)) {
        showErrorInfo("请输入用户名!");
        return;
    }
    if (!validUserName(userName)) {
        showErrorInfo("请输入正确的用户名!");
        return;
    }
    if (isNull(password)) {
        showErrorInfo("请输入密码!");
        return;
    }
    if (!validPassword(password)) {
        showErrorInfo("请输入正确的密码!");
        return;
    }

    var data = {"identity": userName, "pwd": password}
    console.log(data);
    var turl="http://127.0.0.1:8125/login?identity="+userName+"&pwd="+password;
    console.log(turl);
   // var data = {"userName": userName, "password": password}
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
       url:"http://127.0.0.1:8125/login",
        //url:"http://127.0.0.1:8125/login?identity=${user.name}&pwd=${user.name}",
       // url: "users/login",
        contentType: "application/json; charset=utf-8",
       // params: JSON.stringify(data),
        //data:data,
        data:JSON.stringify(data),
       // params:data,
       // params:{"identity": userName, "pwd": password},
        success: function (result) {
            if (result.flag) {

                if(result.data=="data"){console.log(result)}
                $('.alert-danger').css("display", "none");
                setCookie("token", result.data.uesrId);
                window.location.href = "/cardlist.html";
            }
            ;
            if (result.resultCode == 500) {
                showErrorInfo("登陆失败!请检查账号和密码！");
                return;
            }
        },
        error: function () {
            $('.alert-danger').css("display", "none");
            showErrorInfo("网络异常，请重试");
            setTimeout(function (){
                $('.alert-danger').css("display", "none");
            },1000)
            return;
        }
    });
}

function register() {
    console.log("hello")
    var userName = $("#userName").val();
    var password = $("#password").val();
    var identity=$("#identity").val();
    var sex;
    if ($("#mant").prop('checked')){
        sex = "男"
    }else{
        sex = "女"
    }
    if (isNull(userName)) {
        showErrorInfo("请输入用户名!");
        return;
    }
    if (!validUserName(userName)) {
        showErrorInfo("请输入正确的用户名!");
        return;
    }
    if (isNull(password)) {
        showErrorInfo("请输入密码!");
        return;
    }
    if (!validPassword(password)) {
        showErrorInfo("请输入正确的密码!");
        return;
    }

    var data = {"identity": identity, "userPwd": password, "sex": sex,"userName":userName}
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url:"http://127.0.0.1:8125/register",
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify(data),
        success: function (result) {
            if (result.flag) {
                $('.alert-danger').css("display", "none");
                setCookie("token", result.data.uesrId);
                window.location.href = "/cardlist.html";
            }
            ;
            if (result.resultCode == 500) {
                showErrorInfo("登陆失败!请检查账号和密码！");
                return;
            }
        },
        error: function () {
            $('.alert-danger').css("display", "none");
            showErrorInfo("网络异常，请重试");
            setTimeout(function (){
                $('.alert-danger').css("display", "none");
            },1000)
            return;
        }
    });
}

<!-- cookie操作 start-->

/**
 * 写入cookie
 *
 * @param name
 * @param value
 */
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";

}

/**
 * 读取cookie
 * @param name
 * @returns {null}
 */
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

/**
 * 删除cookie
 * @param name
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

/**
 * 检查cookie
 */
function checkCookie() {
    if (getCookie("token") == null) {
        swal("未登录", {
            icon: "error",
        });
        window.location.href = "login.html";
    }
}

/**
 * 检查cookie
 */
function checkResultCode(code) {
    if (code == 402) {
        window.location.href = "login.html";
    }
}

<!-- cookie操作 end-->

function showErrorInfo(info) {
    $('.alert-danger').css("display", "block");
    $('.alert-danger').html(info);
}
function showtips(info) {
    $('.alert-info').css("display", "block");
    $('.alert-info').html(info);
}

/**
 * 获取jqGrid选中的一条记录
 * @returns {*}
 */
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        swal("请选择一条记录", {
            icon: "error",
        });
        return;
    }
    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length > 1) {
        swal("只能选择一条记录", {
            icon: "error",
        });
        return;
    }
    return selectedIDs[0];
}

/**
 * 获取jqGrid选中的多条记录
 * @returns {*}
 */
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        swal("请选择一条记录", {
            icon: "error",
        });
        return;
    }
    return grid.getGridParam("selarrrow");
}