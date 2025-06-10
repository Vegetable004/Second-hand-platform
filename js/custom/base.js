$(document).ready(function () {

	function getRealPath(){
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol + "//" + localObj.host + "/"+ contextPath;
		return basePath ;
	}

	$(":checkbox:first").click(function () {
		var checked = $(this).prop("checked");
		$(":checkbox").prop("checked", checked);
	});

	$("#selectAllButton").click(function () {
		var checked = $(this).prop("checked");
		$("input[name='itemIds']").prop("checked", checked);
	});

	$("tbody :checkbox").click(function () {
		var isAllSelected = $(":checkbox:first").prop("checked");
		var selected = $(this).prop("checked");
		if (!selected && isAllSelected) {
			$(":checkbox:first").prop("checked", false);
		} else {
			isAllSelected = true;
			$("tbody :checkbox").each(function () {
				if (!$(this).prop("checked")) {
					isAllSelected = false;
					return false;
				}
			});
			$(":checkbox:first").prop("checked", isAllSelected);
		}
	});

	$("#deleteUserButton").on('click',function(){
		var basePath=getRealPath();
		var idArr = [];
		if($("input[name='itemIds']").length>0){
			$("input[name='itemIds']").each(function(){
				if($(this).is(':checked')){
					idArr.push($(this).val());
				}
			});
		}
		if(idArr.length<=0){
			alert('请至少选择一项');
			return;
		}
		$.ajax({
			url:basePath+'/admin/deleteUser',
			type:'POST',
			data:{"ids":idArr},
			dataType:'json',
			success:function(json){
				if(json){
					alert(json.msg);
					location.reload();
				}
			},
			error:function(){
				alert('请求超时或系统出错!');
			}
		});
	});


	$("#deleteGoodsButton").on('click',function(){
		var basePath=getRealPath();
		var idArr = [];
		if($("input[name='itemIds']").length>0){
			$("input[name='itemIds']").each(function(){
				if($(this).is(':checked')){
					idArr.push($(this).val());
				}
			});
		}
		if(idArr.length<=0){
			alert('请至少选择一项');
			return;
		}
		$.ajax({
			url:basePath+'/admin/deleteGoods',
			type:'POST',
			data:{"ids":idArr},
			dataType:'json',
			success:function(json){
				if(json){
					alert(json.msg);
					location.reload();
				}
			},
			error:function(){
				alert('请求超时或系统出错!');
			}
		});
	});


	$("#deleteOrdersButton").on('click',function(){
		var basePath=getRealPath();
		var idArr = [];
		if($("input[name='itemIds']").length>0){
			$("input[name='itemIds']").each(function(){
				if($(this).is(':checked')){
					idArr.push($(this).val());
				}
			});
		}
		if(idArr.length<=0){
			alert('请至少选择一项');
			return;
		}
		$.ajax({
			url:basePath+'/admin/deleteOrders',//有弊端，后期完善
			type:'POST',
			data:{"ids":idArr},
			dataType:'json',
			success:function(json){
				if(json){
					alert(json.msg);
					location.reload();
				}
			},
			error:function(){
				alert('请求超时或系统出错!');
			}
		});
	});


});



