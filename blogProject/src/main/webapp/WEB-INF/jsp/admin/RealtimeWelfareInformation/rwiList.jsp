<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link rel="stylesheet" href="/css/admin.css" type="text/css" media="screen" charset="utf-8"/>

<%@ include file="/WEB-INF/include/include-header.jspf"%>
 <script>
	    $(document).ready(function(){
	    	fn_selectBoardList(1);
		});
	
		function fn_selectBoardList(pageNo){ // 데이터 페이지 불러오기
			/* var page_row = 15*pageNo;
	  		var page_index = page_row -14; */
			var comAjax = new ComAjax();
			comAjax.setUrl("<c:url value='/admin/rwi/rwiTb.do' />");		//통신할 URL
	       comAjax.setCallback("createTable");			//callback 함수 지정
	       /*     comAjax.addParam("PAGE_INDEX",page_index);
	        comAjax.addParam("PAGE_ROW", page_row); */
	        comAjax.ajax();
		}
		
		function createTable(data){
			var total = data.list.length;
	        var body = $("table>tbody");
	        body.empty();
	        
	        if(total == 0){
	            var str = "<tr>" + 
	                            "<td colspan='5'>조회된 결과가 없습니다.</td>" + 
	                        "</tr>";
	            body.append(str);
	        }
	        else{
	            var str = "";
	            $.each(data.list, function(key, value){
	                str += "<tr>" + 
	                            "<td>" +
	                            	"<a href='#this'  name='detail_btn' id='cnt_title'>" +  value.rwi_title +"</a>"+
	                            	"<input type='hidden' id='IDX' value="+value.rwi_no+">"+
	                            "</td>" + 
	                            "<td id='cnt'>" + value.rwi_cnt + "</td>" +
	                            "<td>" + value.NAME + "</td>" +
	                            "<td>" + value.create_date + "</td>" +
	                            "<td>" + value.update_date + "</td>" +
	                        "</tr>";
	            });
	            body.append(str);
	        }
		}
		
		
		$(document).ready(function() {
			$("a[name='detail_btn']").on("click", function(e) { //상세보기
				e.preventDefault();
				fn_projectDetail($(this));
			});
		});

		function fn_projectDetail(obj) {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/admin/rwi/rwiDetailPage.do' />");
			comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
			comSubmit.submit();
		}
    </script>
    
     <script type="text/javascript">
        $(document).ready(function(){
            $("#add_page").on("click", function(e){ //등록 버튼
                e.preventDefault();
                namager_add();
            }); 
             
        });
         
        function namager_add(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/admin/rwi/rwiAddPage.do' />");
            comSubmit.submit();
        }
         
    </script> 
	<style>
		.w3-theme-d1 {color:#fff !important; background-color:#57707d !important}
	</style>
</head>
<body class="w3-content w3-light-gray" style="max-width:100%">
	<%@ include file="/WEB-INF/include/include-navi.jspf"%>
	<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

		<div class="w3-main" style="margin-left:250px;">
		<div id="body">
			<div id="myTop" class="w3-container w3-top w3-blue-gray w3-large">
			  <p><i class="fa fa-bars w3-button w3-blue-gray w3-hide-large w3-xlarge" onclick="w3_open()"></i>
			  <span class="w3-cell-middle"  id="title" style="text-align:center;">실시간 정보 </span>
			  <span id="myIntro" class="w3-hide">실시간 정보 </span></p>
			</div>
			
			<header class="w3-container " style="padding-top:30px ;">
			  <h1 id="h1">&nbsp;</h1>
			</header>
			
			<button id="add_page" class="w3-button w3-circle w3-blue-gray w3-right w3-card-2"  style="position:fixed; top:13%; right:1%;">+</button>
			<div class="w3-container " style="padding:2%;">
				<table class="w3-table w3-striped w3-bordered w3-border">
				  	 <colgroup>
			            <col width="20%"/>
			            <col width="30%"/>  
			            <col width="20%"/>
			            <col width="15%"/>
			            <col width="15%"/>
			          </colgroup>
					  <thead class="w3-theme-d1">
					  	<tr>
						  	<th >제목</th>
						  	<th>내용</th>
						  	<th>등록자</th>
						  	<th>등록일</th>
						  	<th>수정일</th>
					  	</tr>
					  </thead>
					  
					  <tbody>
					  
					  </tbody>
			  </table>
		  </div>
	  </div>
	 <%--  <%@ include file="/WEB-INF/include/include-footer.jspf" %>  --%>
	</div>  
	
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<div id="PAGE_NAVI" class="w3-bar w3-margin-top" style="margin-top:5vw;"></div>
    	<input type="hidden" id="PAGE_INDEX" name="PAGE_INDEX"/>
</body>
</html>