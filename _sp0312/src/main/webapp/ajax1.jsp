<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>TODOLIST</h1>
	<input id="todoInput" type="text" placeholder="할 일을 적어주세요">
	<button id="addButton">Add</button>
	<ul id="todoList">

	</ul>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$(function() {
			$.ajax({
				url : 'GetTodos',	//GetTodos servlet에 요청을 보냄
				method : 'get',
				success : function(data) {	//요청 성공 시
					addItem(data);			// 데이터를 addItem에 저장
				}
			});
		});
		function addItem(data) {	//addItem 정의
			const list = $('#todoList');	//list = ul태그
			const item = $('<li></li>').text(data);	//item = li태그를 생성하고 받은 데이터를 텍스트로 설정 
			const removeButton = $('<button></button>').text('remove');	//삭제버튼을 생성하고 텍스트를 remove로 설정
			removeButton.click(function() {	//삭제버튼 클릭 시
				$.ajax({
					url : 'RemoveTodo',	//RemoveTodo servlet에 요청을 보냄
					method : 'post',	
					data : {text : data},	//전달 될 데이터 : 사용자가 입력한 데이터
					success : function() {	// 서버에서 항목이 삭제됐을 시
						item.remove();	//화면에서 li태그(item) 삭제
					}
				});
			});
			//ul태그(list)에 li태그(item)를 넣고 li태그에 removeButton을 추가
			item.append(removeButton); 
			list.append(item);
		}
	</script>
</body>
</html>