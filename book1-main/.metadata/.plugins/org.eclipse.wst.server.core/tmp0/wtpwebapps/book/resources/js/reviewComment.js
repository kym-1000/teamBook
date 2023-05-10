async function postReviewToServer(revData){
    try{
        const url = '/review/post';
        const config = {
            method : 'post',
            headers : {
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(revData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text(); 
        return result;
    }catch(error){
        console.log(error);
    }
}

document.getElementById('revPostBtn').addEventListener('click',()=>{
    const reviewContents = document.getElementById('reviewContents').value;
    console.log(reviewContents);
    if(reviewContents==null || reviewContents==''){
        alert("리뷰를 입력해주세요.");
        document.getElementById('reviewContents').focus();
        return false;
    } 
       
        let value = document.querySelector('input[name="review_rating"]:checked').value;
        console.log(value);

        let revData ={
            review_book_num : revVal,
            review_rating : document.querySelector('input[name="review_rating"]:checked').value,
            review_mem_id : document.getElementById('revWriter').innerText,
            review_content : reviewContents
        };
       
        console.log(revData);
        postReviewToServer(revData).then(result =>{
            if(result > 0){
                alert('리뷰 등록 성공~!!');
                document.getElementById("reviewContents").value='';
            }
            getReviewList(revData.review_book_num);
            console.log('abcd'+revData.review_book_num)
            document.getElementById("reviewContents").value='';
        });
});

function getReviewList(book_num){
    console.log('1234'+book_num);
    spreadReviewFromServer(book_num).then(result =>{
        console.log('나와라'+book_num);
        console.log('리절트'+result);
        const ul = document.getElementById('cmtListArea');
        if(result.length > 0){
            ul.innerHTML = "";
            let star="";
            for(let rev of result){
                switch(rev.review_rating){
                    case 1: star="★☆☆☆☆";
                    break;
                    case 2: star="★★☆☆☆";
                    break;
                    case 3: star="★★★☆☆";
                    break;
                    case 4: star="★★★★☆";
                    break;
                    case 5: star="★★★★★";
                    break;
                }
                
                let li = `<div style='color:rgb(228 7 173 / 99%);'>${star}</div>`
                    li += `<span class="input-group-text">${rev.review_mem_id}</span>`
                    li += `<textarea class="col-auto form-control" readonly>${rev.review_content}</textarea>`
                ul.innerHTML += li;
                
            }

        }else{
            let li = `<li>이 책의 첫 리뷰어가 되어주세요.</li>`;
            ul.innerHTML += li;
           
        }
    })
}

async function spreadReviewFromServer(book_num){
    console.log('cv'+book_num);
    try{
        const resp = await fetch('/review/'+book_num);
        const result = await resp.json();
        return result;
    }catch(error){
        console.log(error);
    }
}