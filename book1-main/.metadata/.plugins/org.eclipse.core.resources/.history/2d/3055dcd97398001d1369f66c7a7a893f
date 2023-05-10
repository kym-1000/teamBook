function gologin(event) {
			alert("로그인이 필요합니다!");
		}
		
		/* function stopCart(event) {
			alert("장바구니에 상품을 담았습니다!");
			location.reload();
		} */
		
		/* function goCart(event) {
			alert("장바구니로 이동합니다!");
		} */ 
		
		function count(type)  {
			 
			  const resultElement = document.getElementById('book_cnt');
			  
			  let number = resultElement.innerText;
			  
			  if(type === 'plus') {
			    number = parseInt(number) + 1;
			  }else if(type === 'minus')  {
			    if(number > 1){
			      number = parseInt(number) - 1;
			    }
			  }
			  
			  resultElement.innerText = number;
			}
		
		document.getElementById('Cart_btn').addEventListener('click',()=>{
		    const mem_num = document.getElementById('mem_num').value;
		    const book_num = document.getElementById('book_num').value;
		    const book_cnt = document.getElementById('book_cnt').innerText;

		        let bookDate ={
		            mem_num : mem_num,
		            book_num : book_num,
		            book_cnt : book_cnt,
		        };
		       
		        console.log(bookDate);
		        putDataToServer(bookDate).then(result =>{
		            if(result > 0){
		                alert('장바구니에 담겼습니다!');
		            }
		            
		        });
		});
		
		async function putDataToServer(bookDate){
		    try{
		        const url = '/cart/cartadd';
		        const config = {
		            method : 'put',
		            headers : {
		                'content-type':'application/json; charset=utf-8'
		            },
		            body:JSON.stringify(bookDate)
		        };
		        const resp = await fetch(url, config);
		        const result = await resp.text(); 
		        return result;
		    }catch(error){
		        console.log(error);
		    }
		}
		
		
		// 바로구매
		document.getElementById('Purchase_btn').addEventListener('click',()=>{
		    const mem_num = document.getElementById('mem_num').value;
		    const book_num = document.getElementById('book_num').value;
		    const book_cnt = document.getElementById('book_cnt').innerText;

		        let bookDate ={
		            mem_num : mem_num,
		            book_num : book_num,
		            book_cnt : book_cnt,
		        };
		       
		        console.log(bookDate);
		        putDataToServer(bookDate).then(result =>{
		            if(result > 0){
		                alert('장바구니로 이동합니다');
		            }
					
					location.href = '/cart/cartdetail?mem_num='+mem_num;
					// Location.replace('/cart/cartdetail'+mem_num);
		            
		        });
		});
		
		async function putDataToServer(bookDate){
		    try{
		        const url = '/cart/directCartadd';
		        const config = {
		            method : 'put',
		            headers : {
		                'content-type':'application/json; charset=utf-8'
		            },
		            body:JSON.stringify(bookDate)
		        };
		        const resp = await fetch(url, config);
		        const result = await resp.text(); 
		        return result;
		    }catch(error){
		        console.log(error);
		    }
		}