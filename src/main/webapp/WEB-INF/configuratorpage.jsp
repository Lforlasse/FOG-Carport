<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">

    <title>Hello, world!</title>
</head>

<body>
<!-- NAVBAR -->
<div class="container">
    <nav class="navbar navbar-light bg-light shadow-sm border-left border-right">
        <form class="form-inline">
            <button class="btn btn-outline-secondary active" type="button">Konfigurator</button>
            <button class="btn btn-outline-secondary ml-2" type="button">Prefab</button>
        </form>
    </nav>
</div>

<!-- BODY -->
<div class="container">
    <div class="container border border-top-0 pt-4 pb-4">

        <!-- ALERTS -->
        <c:if test="${requestScope.error!= null}">-
            <div class="alert alert-danger" role="alert">
                Error: ${requestScope.error}
            </div>
        </c:if>-

        <!-- CONTENT -->
        <div class="container-fluid">
            <div class="card mb-4">
                <div class="card-header">
                    Carport mål
                </div>
                <div class="card-body">
                    <form>
                        <label for="lengthSelect">Længde i centimeter</label>
                        <select class="form-control mb-3" id="lengthSelect">
                            <option>Default select</option>
                        </select>
                        <label for="lengthSelect">Længde i centimeter</label>
                        <select class="form-control mb-3" id="widthSelect">
                            <option>Default select</option>
                        </select>
                        <label for="heightSelect">Længde i centimeter</label>
                        <select class="form-control mb-3" id="heightSelect">
                            <option>Default select</option>
                        </select>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    Carport mål
                </div>
                <div class="card-body">
                    <form>
                        <label for="lengthRange">Længde i centimeter</label>
                        <input type="range" class="custom-range mb-3" min="0" max="5" step="0.5" id="lengthRange">
                        <label for="widthRange">Bredde i centimeter</label>
                        <input type="range" class="custom-range mb-3" min="0" max="5" step="0.5" id="widthRange">
                        <label for="heightRange">Højde i centimeter</label>
                        <input type="range" class="custom-range mb-3" min="0" max="5" step="0.5" id="heightRange">
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>

</html>