function toggleElement(div, box, type) {
    if (type == "enable") {
        if (document.getElementById(box).checked) {
            document.getElementById(div).removeAttribute("disabled");
        } else {
            document.getElementById(div).setAttribute("disabled", "");
        }
    }

    if (type == "show") {
        if (document.getElementById(box).checked) {
            document.getElementById(div).style.display = "block";
        } else {
            document.getElementById(div).style.display = "none";
        }
    }
}