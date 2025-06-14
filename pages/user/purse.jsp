<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的钱包</title>
	<link rel="icon" href="<%=basePath%>img/logo.jpg" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/userhome.css" />
<link rel="stylesheet" href="<%=basePath%>css/user.css" />


<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>
	<div class="pre-2" id="big_img">
		<img
			src="http://findfun.oss-cn-shanghai.aliyuncs.com/images/head_loading.gif"
			class="jcrop-preview jcrop_preview_s">
	</div>
	<div id="cover" style="min-height: 639px;">
		<div id="user_area">
			<div id="home_header">
				<a href="<%=basePath%>goods/homeGoods">
					<h1 class="logo"></h1>
				</a> 
				<a href="<%=basePath%>goods/homeGoods">
                 <img src="<%=basePath%>img/home_header.png"  style="margin-left: 20px;" >
          		 </a>
				<a href="<%=basePath%>user/home">
					<div class="home"></div>
				</a>
			</div>

			<div id="user_nav">
				<div class="user_info">
					<div class="head_img">
						<img src="<%=basePath%>img/photo.jpg">
					</div>
					<div class="big_headimg">
						<img src="">
					</div>
					<span class="name">${cur_user.username}</span>
					<hr>

				   <a class="btn" style="width: 98%;background-color: rgb(79, 190, 246);color:rgba(255, 255, 255, 1);" href="<%=basePath%>user/myPurse">我的钱包：￥${myPurse.balance}</a>
                <input type="hidden" value="${myPurse.recharge}" id="recharge"/>
                <input type="hidden" value="${myPurse.withdrawals}" id="withdrawals"/>
               <span class="btn" data-toggle="modal" data-target="#myModal" style="width: 98%; background-color: rgb(79, 190, 246); color: rgba(255, 255, 255, 1); margin-top: 0.5cm;">我的信用积分：${cur_user.power}</span>

				</div>
				<div class="home_nav">
					<ul>
						<a href="<%=basePath%>orders/myOrders">
							<li class="notice">
								<div></div> <span>订单中心</span> <strong></strong>
						</li>
						</a>
						<a href="<%=basePath%>user/allFocus">
							<li class="fri">
								<div></div> <span>关注列表</span> <strong></strong>
						</li>
						</a>
						<a href="<%=basePath%>goods/publishGoods">
							<li class="store">
								<div></div> <span>发布物品</span> <strong></strong>
						</li>
						</a>
						<a href="<%=basePath%>user/allGoods">
							<li class="second">
								<div></div> <span>我的闲置</span> <strong></strong>
						</li>
						</a>
						<a href="<%=basePath%>user/basic">
							<li class="set">
								<div></div> <span>个人设置</span> <strong></strong>
						</li>
						</a>
					</ul>
				</div>
			</div>

			<div id="user_content">

				<div class="share">


					<h1 style="text-align: center">我的钱包</h1>
					<hr />
					<div class="share_content">
						<div class="story">
							<form id="myUpAndDwon" class="form-horizontal" role="form" action="<%=basePath%>user/updatePurse" >
								<div class="form-group">
									<div class="col-sm-12">
                					
									</div>
									<label for="firstname" class="col-sm-2 control-label">余额：</label>
									<div class="col-sm-10">
										<input type="text" name="balance" class="form-control" disabled="disabled" style="border:0px;background:rgba(0, 0, 0, 0); " value="${myPurse.balance}" >
									</div>
									<label for="firstname" class="col-sm-2 control-label" >充值：</label>
									<div class="col-sm-10">
										<input name="recharge" type="number" class="form-control recharge" style="border:0px;background:rgba(0, 0, 0, 0); " value="${myPurse.recharge}" data-toggle="tooltip"  title="请输入整数金额！"/>

									</div>
									<label for="firstname" class="col-sm-2 control-label" >提现：</label>
									<div class="col-sm-10">
										<input name="withdrawals" type="number" class="form-control withdrawals" style="border:0px;background:rgba(0, 0, 0, 0); " value="${myPurse.withdrawals}" data-toggle="tooltip"  title="请输入整数金额！"/>
								
									</div>
								</div>
								<hr />
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-8">

										 <c:if test="${myPurse.state==null}">
										 <a  onclick="upAnddown(1)" class="btn btn-danger">立即充值</a>
										 <a  onclick="upAnddown(2)" class="btn btn-danger">立即提现</a>
										 </c:if>
										 
										 <c:if test="${myPurse.state==0}">
										 <c:if test="${myPurse.recharge!=null}">
										 <a   class="btn btn-danger">【申请提现中】,待管理员审核！</a>
										 </c:if>
										 <c:if test="${myPurse.withdrawals!=null}">
										 <a   class="btn btn-danger">【申请充值中】,待管理员审核！</a>
										 </c:if>
										 </c:if>
										 
										  <c:if test="${myPurse.state==1 or myPurse.state==2}">
										 <a   class="btn btn-danger btn_mypurse">请点击查看审核结果！</a>
										 </c:if>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
$(".btn_mypurse").on('click',function(){
		
		if(1${myPurse.state}!=1){
			var state=1${myPurse.state}

				if(state==10){
					alert("您的申请,还【未审核】！")
				}
				if(state==11){
					alert("您的申请，已审核【不通过】，请联系管理员！")
				}
				if(state==12){
					alert("您的申请，已审核【通过】~")
				}
				if(state==11||state==12){

					var id=${myPurse.id};
					$.ajax({
						url:'<%=basePath%>admin/updatePurseState',
						type:'GET',
						data:{id:id},
						dataType:'json'
						});
						location.reload();
					}
		}
	});
</script>
<script type="text/javascript">

	function upAnddown(num){
		var reg=/^[1-9]\d*$|^0$/;  
		if(num==1){
			var Recharge=$(" input[ name='recharge' ] ").val();
			if(Recharge==null || Recharge==""){
				alert("请输入您要充值的金额！")
			}else if(reg.test(Recharge)!=true){
				alert("您输入的金额格式有误，请重新输入！")
			}else{
				$(".withdrawals").val("");

		        $("#myUpAndDwon").submit();
				alert("申请充值成功，等待管理员审核~")
			}
			
		}
		if(num==2){
			var withdrawals=$(" input[ name='withdrawals' ] ").val();
			if(withdrawals==null || withdrawals==""){
				alert("请输入您要提现的金额！")
			}else if(reg.test(withdrawals)!=true){
				alert("您输入的金额格式有误，请重新输入！")
			}else if(withdrawals>${myPurse.balance}){
				alert("您输入的金额太大，请重新输入！")
			}else{
			$(".Recharge").val("");

	        $("#myUpAndDwon").submit();
	        alert("申请提现成功，等待管理员审核~")
			}
		}
	
	}
</script>
</html>