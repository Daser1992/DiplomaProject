
const btnDelete = document.querySelectorAll(".delete-user-btn");

btnDelete.forEach(function (event){
    event.addEventListener("click", () =>{
        const userId = event.getAttribute("data-id");
        fetch("delete_user?userId=" + userId, {method: "post"}).then(res =>{
            if (res.status === 200){
                console.log("Ok");
            }
        })
    })
})