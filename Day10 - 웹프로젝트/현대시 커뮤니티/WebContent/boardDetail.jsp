<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
var getReplyList=function(){
	$.ajax({
		url: 'getReplyList',
		type: 'get',
		data: {
			bseq: $('#bseq').val()
		},
		dataType: 'json',
		success:function(response){
			replyTable(response);
		}
	});
};



var addReply=function(){
	$.ajax({
		url: 'addReply',
		type: 'get',
		data: {
			bseq: $('#bseq').val(),
			rcontent: $('#reply').val(),
			rlevel: 0
			},
		dataType: 'json',
		success:function(response){
			$('#reply').val('');
			replyTable(response);
			}
	});	
};

var replyTable = function(response){
	console.log(response);
	$('#replytable').empty();
	var output='';
	$.each(response, function(index) {
		output+="<tr><td id='"+response[index].rseq+"'>";
		for(var i=0; i<response[index].rlevel; i++){
			output+="&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		output+="ㄴRe:  "+response[index].rcontent+"	ID: "+response[index].ruser+"&nbsp;<button id='MoreReply"+response[index].rseq+"' onclick='addMoreReply("+response[index].rseq+")'>추가댓글</button>";
		output+="<textarea align='center' id='replytable2"+response[index].rseq+"' style='width:400px; display:none;'></textarea>";
		output+="<input type='hidden' id='rlevel' value='"+response[index].rlevel+"'/>";
		output+="<input type='hidden' id='rstep' value='"+response[index].rstep+"'/>";
		output+="<input type='hidden' id='bseq' value='"+response[index].bseq+"'/>";
		if(response[index].ruser==$('#id').val()){
			output+="&nbsp;&nbsp;<button id='updateReply'>댓글수정</button>&nbsp;<button id='deleteReply'>댓글삭제</button>"
		}
		output+="</td></tr>";
    });
	$('#replytable').html(output);
};

var addMoreReply = function(rseq){
	console.log("addMoreReply");
	$('#MoreReply'+rseq).css('display', 'none');
	$('#'+rseq+' #replytable2'+rseq).css('display', 'block');
	$('#'+rseq).append("<button id='addReply' onclick='addReply2("+rseq+")'>댓글 입력</button>");
}


 var addReply2 = function(rseq){
	console.log("addReply2");
	if($('#'+rseq+' #rlevel').val()==3){
		alert('더 이상 댓글을 입력하실 수 없습니다.');
		$('#replytable2'+rseq).val('');
		return;
	}
	$.ajax({
		url: 'addReply2',
		type: 'get',
		data:{
			rcontent: $('#replytable2'+rseq).val(),
			rlevel: $('#'+rseq+' #rlevel').val(),
			rstep: $('#'+rseq+' #rstep').val(),
			bseq: $('#'+rseq+' #bseq').val()
		},
		dataType: 'json',
		success:function(response){
			replyTable(response);
		}
	});
}; 

$(document).ready(function(){
	
	getReplyList();
	
	$('#addReply').click(function(){
			console.log("댓글 입력");
			addReply();
	});
	
	$('#addBoard').click(function(){
		console.log("새글쓰기 클릭");
		location.href='addBoard.jsp';
	});
	
	$('#updateBoard').click(function(){
		location.href='updateBoard?bseq='+${board.bseq};
	});
	
	$('#deleteBoard').click(function(){
		var flag=confirm("정말 삭제하시겠습니까?");
		if(flag){
		location.href='deleteBoard?bseq='+${board.bseq};
		}
	});
	
	var id=${id};
	var buser=$('#buser').text();
	
	if(id==buser){
		$('#updateBoard').attr('disabled', false);
		$('#deleteBoard').attr('disabled', false);
	}
	

});
</script>
</head>

<body>
	<center>
		<h3>글 상세</h3>
		<h3>${id }님 로그인 환영합니다...... Log-out</h3>
		<hr>
		<input id="id" type="hidden" value="${id }" />
		<input id="bseq" type="hidden" value="${board.bseq }" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>제목</td>
				<td align="left" id="btitle">${board.btitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td align="left" id="buser">${board.buser }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td align="left" id="bcontent">${board.bcontent }</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td align="left" id="bdate">${board.bdate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td align="left" id="bcnt">${board.bcnt }</td>
			</tr>
		</table>
		<button id="addBoard">글쓰기</button>
		&nbsp;&nbsp;&nbsp;
		<button id="updateBoard" disabled="disabled">수정</button>
		&nbsp;&nbsp;&nbsp;
		<button id="deleteBoard" disabled="disabled">삭제</button>
		&nbsp;&nbsp;&nbsp; <a href="getBoardList">목록</a>
		<div>
			<br />
			<table align="center" id="replytable" style="width: 770px"></table>
		</div>
		<br />
		<div align="center">
			<input type="text" id="reply" name="reply" style="width: 700px" />
			<button id="addReply">댓글 입력</button>
		</div>
	</center>
	<hr>

</body>
</html>










