$(function(){
	
	var pass1 = $('#password1'),
		pass2 = $('#password2'),
		pass = $('#password'),
		form = $('#main form'),
		msg = $("#msg"),
		arrow = $('#main .arrow');

	if(msg.val()!=""){
		alert(msg.val());
	}
	

	$('#main .row input').val('');


	form.on('submit',function(e){
		

		if($('#main .row.success').length == $('#main .row').length){
			pass.val($.md5(pass.val()));
			pass1.val($.md5(pass1.val()));
			pass2.val($.md5(pass2.val()));
		}
		else{
			alert("请把内容填完整");

			e.preventDefault();
			
		}
	});


	pass.on('blur',function(){
		var adminId = $("#id").val();
		var password = $.md5(pass.val());

		$.ajax({     
		    url:'check.action',     
		    type:'post',  
		    data:{'id':adminId,'password':password,},
		    async : false,
		    success:function(data){ 
		      if(data=="success"){
		    	  pass.parent()
		    	  .removeClass('error')
		    	  .addClass('success');
		      }else
		    	  pass.parent()
		    	  .removeClass('success')
		    	  .addClass('error');
		    }  
		});  
	});


	pass1.complexify({minimumChars:6, strengthScaleFactor:0.7}, function(valid, complexity){
		
		if(valid){
			pass2.removeAttr('disabled');
			
			pass1.parent()
					.removeClass('error')
					.addClass('success');
		}
		else{
			pass2.attr('disabled','true');
			
			pass1.parent()
					.removeClass('success')
					.addClass('error');
		}
		
		var calculated = (complexity/100)*268 - 134;
		var prop = 'rotate('+(calculated)+'deg)';
		

		arrow.css({
			'-moz-transform':prop,
			'-webkit-transform':prop,
			'-o-transform':prop,
			'-ms-transform':prop,
			'transform':prop
		});
	});
	

	pass2.on('keydown input',function(){
		

		if(pass2.val() == pass1.val()){
			
			pass2.parent()
					.removeClass('error')
					.addClass('success');
		}
		else{
			pass2.parent()
					.removeClass('success')
					.addClass('error');
		} 
	});
	
});
