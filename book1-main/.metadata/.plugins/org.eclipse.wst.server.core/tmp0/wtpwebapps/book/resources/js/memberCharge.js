


function charge(){
    let mem_cash = document.getElementById('mem_cash').value;
    let mem_id = document.getElementById('mem_id').value;
    console.log("js mem_cash 테스트 : "+mem_cash);
    console.log("js mem_id 테스트 : "+mem_id);
    $.ajax({
        url:'/mem/charge2', //Controller에서 요청 받을 주소
        type:'post', //POST 방식으로 전달
        data:{
        		mem_cash:mem_cash,
        		mem_id:mem_id
        		},
        success:function(cashNow2){ //컨트롤러에서 넘어온 isOK값을 받는다 
            console.log("컨트롤러에서 건너온 cash : "+cash); //결과값 : [object XMLDocument]
            //document.getElementById('cash').value = isOk;
        },
        error:function(request,status,error){
        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }	

    });
    };