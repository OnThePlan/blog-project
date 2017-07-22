
//파일 추가 버튼
        function addRow(obj){
        	var str = $(obj).parent().parent().html();
        	str = "<tr>"+str+"</tr>";
        	$(obj).parent().parent().parent().append(str);
        }
  
      //파일 삭제 버튼
        function remove_Row(obj){
        	$(obj).parent("td").parent("tr").remove();  
        }
        
        
$(document).ready(function(){
	var host = window.location.host;
	var url = window.location.href;
	var url_arr = url.split("/");
	var default_ulr = "http://" + host + "/manager/" + url_arr[4] + "/"; 
	
	var flag = "";
	var idx = $("#IDX").val();
	//project list 등록페이지 이동
	$("#add_page").click(function(){
		submit_page("AddPage");
	});
	
	//project file list 등록페이지 이동
	$("#add_filePage").click(function(){
		submit_page("AddFilePage");
	});
	
	//목록으로 가기
	$("#list_btn").click(function(){
		submit_page("List");
	});
	
	//파일 목록으로 가기
	$("#filelist_btn").click(function(){
		submit_page("FileList");
		});
	
	//input 데이터 formcheck & insert(등록)
	$("#add_btn").click(function(){
		$(".non_pass").each(function(){
			form_chek(this);
		});
		submit_page("Add");
	});
	
	//input 데이터 formcheck & insert(파일 등록)
	$("#addfile_btn").click(function(){
		$(".non_pass").each(function(){
			form_chek(this);
		});
		submit_page("AddFile");
	});
	
	//수정페이지로 가기
	$("#update_page_btn").click(function(){
		$(".non_pass").each(function(){
			form_chek(this);
		});
		submit_page("UpdatePage", idx);
	});
	
	//input 데이터 formcheck & update(수정) 
$("#update_btn").click(function(){
		$(".non_pass").each(function(){
			form_chek(this);
		});
		submit_page("Update", idx);
	});
	
	//delete
	$("#del_btn").click(function(){
		submit_page("Delete", idx);
	});
	
	//file delete
	$("#delFile_btn").click(function(){
		alert();
		submit_page("FileDelete");
	});
	
	function form_chek(obj){
		if($(obj).val() == ""){
			flag = "n";
			alert($(this).attr("placeholder") + "을(를) 입력해주세요.");
			$(this).focus();
			return false;
		}
	}
	
	function submit_page(type){
		if(flag == ""){
			var comSubmit = new ComSubmit("frm");
			var str = "/manager/" + url_arr[4] + "/" +url_arr[4] + type +".do";
	        comSubmit.setUrl(str);
	        comSubmit.submit();
		}
	}
	
	
});



