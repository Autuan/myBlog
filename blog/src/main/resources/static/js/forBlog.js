// ------------------------- 搜索模块 -------------------------
function search() {
    var query = $("#searchKey").val();
    var page = $("#page").val()
    if ( page == null ) {
        page = 1;
    }
    location = "/search?q="+query+"&page="+page;
}

$(function () {
    // 回车提交
    $("#searchKey").keyup(function (e) {
        if(e.which == 13) {
            search();
        }
    });
    // 按钮点击
    $("#searchBegin").click(function () {
        search();
    });
});

// ------------------------- 搜索模块 over -------------------------
// ------------------------- 模态框 -------------------------
// ------------------------- 模态框 over -------------------------