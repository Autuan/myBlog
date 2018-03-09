jQuery.extend({
    alertWindow:function(e,n){var e=e,r;n===undefined?r="#00a8b7":r=n;
        if($("body").find(".alertWindow1").length===0){
            var i='<div class="alertWindow1" style="width: 100%;height: 100%; background:rgba(0,0,0,0.5);position: fixed; left:0px; top: 0px; z-index: 9999;"><div  style="width: 360px; height: 170px;background: #FFF;margin: 300px auto;border: 2px solid #CFCFCF;">'+'<div  style="width: inherit;height: 20px;">'+'<div class="alertWindowCloseButton1" style="float: right; width: 10px; height: 30px;margin-right:5px;font-family:\'microsoft yahei\';color:'+r+';cursor: pointer;"></div>'+"</div>"+'<div id="successImg" class="alertWindowTitle" style="margin-top:10px;text-align:center;font-family:\'Verdana, Geneva, Arial, Helvetica, sans-serif\';font-size: 18px;font-weight: normal;color: '+r+';">'+"</div>"+'<div class="alertWindowContent" style="width:360px;height: 40px;text-align:center;font-size: 18px;color: #7F7F7F;margin-top:10px;">'+e+"</div>"+"</div>"+"</div>";
            $("body").append(i);
            var s=$(".alertWindow1");
            //2秒后自动关闭窗口
            setTimeout(function(){s.hide()},1000);
        }
        else {$(".alertWindowContent").text(e),$(".alertWindow1").show(),setTimeout(function(){$(".alertWindow1").hide()},1000);}
    }
})