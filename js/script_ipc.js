$(function(){
	var no = $('#no');
	no.on('blur',function(){
		var id = $("#id").val();
		if(no.val()==0){
			$("#span").text("编号必须大于0");
			$("#submit").attr("disabled",true);
			return;
		}else{
			$("#span").text("");
		}
			

		$.ajax({     
			url:'checkNo.action',     
			type:'post',  
			data:{'id':id,'no':no.val(),},
			async : false,  
			success:function(data){ 
				if(data=="success"){
					$("#submit").attr("disabled",false);
				}else{
					$("#span").text("编号已经存在");
					$("#submit").attr("disabled",true);
				}
			},
		});  
	});
});
