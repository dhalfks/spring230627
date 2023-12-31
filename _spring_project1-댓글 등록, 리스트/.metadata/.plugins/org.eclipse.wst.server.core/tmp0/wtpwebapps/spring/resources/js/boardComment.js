async function postCommentToServer(cmtData){
    try{
        const url = '/comment/post';
        const config = {
            method:"post",
            headers: {
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();  //isOK
        return result;
    }catch(err){
        console.log(err);
    }
}

document.getElementById('cmtPostBtn').addEventListener('click',()=>{
    const cmtText = document.getElementById('cmtText').value;
    console.log(cmtText);
    if(cmtText=="" || cmtText==null){
        alert("댓글을 입력해주세요");
        document.getElementById('cmtText').focus();
        return false;
    }else{
        let cmtData = {
            bno : bnoVal,
            writer : document.getElementById('cmtWriter').innerText,
            content : cmtText
        };
        console.log(cmtData);
        postCommentToServer(cmtData).then(result =>{
            //isOk 확인 데이터
            if(result > 0){
                alert("댓글 등록 성공~!!");
                getCommentList(cmtData.bno);
            }
        })
    }
})

async function spreadCommentFromServer(bno){
    console.log(bno);
    try{
        const resp = await fetch('/comment/'+bno);
        const result = await resp.json();
        return result;
    }catch(err){
        console.log(err);
    }
}

function getCommentList(bno){
    spreadCommentFromServer(bno).then(result => {
        console.log(result);
        const ul = document.getElementById('cmtListArea');
        if(result.length > 0){
            ul.innerHTML = "";
            for(let cvo of result){
                let li = `<li data-cno="${cvo.cno}"><div>`;
                li +=`<div>${cvo.writer}</div>`;
                li +=`<input type="text" id="cmtTextMod" value="${cvo.content}"></div>`
                li +=`<span>${cvo.mod_date}</span>`;
                li +=`<button type="button" class="modBtn">%</button>`;
                li +=`<button type="button" class="delBtn">x</button></li>`;
                ul.innerHTML+=li;
            }
            
        }else{
            let li =`<li>Comment List Empty</li>`;
            ul.innerHTML+=li;
        }
    })
}