function init() {
    setInterval("changeImg()", 3000);
    time = setInterval("showAd()", 3000);
}
var i = 0;
function changeImg() {
    var masterGraph = document.getElementById("masterGraph");
    masterGraph.src="./img/" + (((++i) % 3) + 1) + ".jpg";
}

function showAd() {
    var adImg1 = document.getElementById("adImg");
    adImg1.style.display = "block";
    clearInterval(time);
    time = setInterval("hiddenAd()",3000);

}
function hiddenAd() {
    var adImg = document.getElementById("adImg");
    adImg.style.display = "none";
    clearInterval(time);
}
