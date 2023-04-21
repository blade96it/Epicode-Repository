let header = document.querySelector(".header");
let getStarted = document.querySelector("#getStarted");


window.addEventListener("scroll", () => {
    if (window.scrollY >= 440) {
        header.style.background = "#fff";
        getStarted.style.background = "#1a8917";
    } else {
        header.style.background = "#ffc017";
        getStarted.style.background = "black";
    }
})