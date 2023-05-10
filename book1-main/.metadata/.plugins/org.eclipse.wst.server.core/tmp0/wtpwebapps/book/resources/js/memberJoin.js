
	function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
	
	function checkId(){
        var mem_id = document.getElementById('mem_id').value; //id값이 "id"인 입력란의 값을 저장
		console.log(mem_id);
        $.ajax({
            url:'/mem/idCheck', //Controller에서 요청 받을 주소
            type:'post', //POST 방식으로 전달
            data:{mem_id:mem_id},
            success:function(isOk){ //컨트롤러에서 넘어온 isOK값을 받는다 
                if(isOk == 'id_ok'){ //ok이면 가입 가능
                    $('.id_ok').css("display","inline-block"); 
                    $('.id_duplicate').css("display", "none");
					$('.id_null').css("display", "none");
                }else if(isOk =='id_null'){//input이 null값임. 입력 요청
					$('.id_ok').css("display","none"); 
                    $('.id_duplicate').css("display", "none");
					$('.id_null').css("display", "inline-block");
				} 
				else { //중복일 경우
                    $('.id_ok').css("display", "none");
                    $('.id_duplicate').css("display","inline-block");
					$('.id_null').css("display", "none");
                    // alert("아이디를 다시 입력해주세요");
                    $('#mem_id').val('');
                }
            },
			error:function(request,status,error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}	

        });
        };
        
        
        
    
    
        
	function checkPw(){
	 var mem_pw = document.getElementById('mem_pw').value; //pw값이 "pw"인 입력란의 값을 저장
	console.log("js mem_pw 출력 : "+mem_pw);
	$.ajax({
		url:'/mem/pwCheck', //Controller에서 요청 받을 주소
		type:'post', //POST 방식으로 전달
		data:{mem_pw:mem_pw},
		success:function(isOk){ //컨트롤러에서 넘어온 isOK값을 받는다 
			if(isOk == 'pw_ok'){ //ok이면 가입 가능
				$('.pw_ok').css("display","inline-block"); 
				$('.pw_rewrite').css("display", "none"); //정규식 어긋나면
				$('.pw_null').css("display", "none");
			}else if(isOk =='pw_null'){//input이 null값임. 입력 요청
				$('.pw_ok').css("display","none"); 
				$('.pw_rewrite').css("display", "none");
				$('.pw_null').css("display", "inline-block");
			} 
			else { //중복일 경우
				$('.pw_ok').css("display", "none");
				$('.pw_rewrite').css("display","inline-block");
				$('.pw_null').css("display", "none");
				// alert("아이디를 다시 입력해주세요");
				$('#mem_pw').val('');
			}
		},
		error:function(request,status,error){
		console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}	

	});
	};	
	
	function checkPwRe(){
	var mem_pwRe = document.getElementById('mem_pwRe').value; 
	console.log(mem_pwRe);
	$.ajax({
		url:'/mem/pwCheckRe', //Controller에서 요청 받을 주소
		type:'post', //POST 방식으로 전달
		data:{mem_pwRe:mem_pwRe},
		success:function(isOk){ //컨트롤러에서 넘어온 isOK값을 받는다 
			if(isOk == 'pwRe_ok'){ //ok이면 가입 가능
				$('.pwRe_ok').css("display","inline-block"); 
				$('.pwRe_rewrite').css("display", "none"); //정규식 어긋나면
				$('.pwRe_null').css("display", "none");
			}else if(isOk =='pwRe_null'){//input이 null값임. 입력 요청
				$('.pwRe_ok').css("display","none"); 
				$('.pwRe_rewrite').css("display", "none");
				$('.pwRe_null').css("display", "inline-block");
			} 
			else { //중복일 경우
				$('.pwRe_ok').css("display", "none");
				$('.pwRe_rewrite').css("display","inline-block");
				$('.pwRe_null').css("display", "none");
				// alert("아이디를 다시 입력해주세요");
				$('#mem_pwRe').val('');
			}
		},
		error:function(request,status,error){
		console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}	

	});
	};	
	
	function checkCellNum(){
        var mem_cell_num = document.getElementById('mem_cell_num').value; //id값이 "id"인 입력란의 값을 저장
		console.log(mem_cell_num);
        $.ajax({
            url:'/mem/cellNumCheck', //Controller에서 요청 받을 주소
            type:'post', //POST 방식으로 전달
            data:{mem_cell_num:mem_cell_num},
            success:function(isOk){ //컨트롤러에서 넘어온 isOK값을 받는다 
                if(isOk == 'cellNum_ok'){ //ok이면 가입 가능
                    $('.cellNum_ok').css("display","inline-block"); 
                    $('.cellNum_duplicate').css("display", "none");
					$('.cellNum_null').css("display", "none");
                }else if(isOk =='cellNum_null'){//input이 null값임. 입력 요청
					$('.cellNum_ok').css("display","none"); 
                    $('.cellNum_duplicate').css("display", "none");
					$('.cellNum_null').css("display", "inline-block");
				}
				else { //중복일 경우
                    $('.cellNum_ok').css("display", "none");
                    $('.cellNum_duplicate').css("display","inline-block");
					$('.cellNum_null').css("display", "none");
                    // alert("아이디를 다시 입력해주세요");
                    $('#mem_cell_num').val('');
                }
            },
			error:function(request,status,error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}	

        });
        };
