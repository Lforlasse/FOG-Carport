<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="includes/header.html" %>

<!-- NAVBAR -->
<%@include file="includes/navbarindex.html" %>

<!-- BODY -->
<div class="container">
    <div class="container border border-top-0 px-4 pt-4 shadow-sm">

        <!-- ALERTS -->
        <%@include file="includes/error.html" %>

        <!-- CONTENT -->
        <div class="jumbotron jumbotron-fluid p-4 border rounded mb-4">
            <div class="container">
                <h1 class="display-4 text-center">Carport konfigurator</h1><br>
                <p class="lead text-center">Forneden kan du vælge imellem at konfigurere din egen personlige
                    carport, eller vælge fra en af de eksisterende designs fra kataloget.</p>
            </div>
        </div>
        <div class="row row-cols-1 row-cols-md-2">
            <div class="col mb-4">
                <div class="card" style="background-color: #174b87">
                    <form class="form-inline" role="form" name="configurator" action="FrontController" method="POST">
                        <button class="btn bg-transparent border-0 bg-white p-0 m-0 w-100" type="submit" value="submit"
                                id="configuratorBtn">
                            <br>
                            <br>
                            <span class="text-center text-white h1">KONFIGURATOR</span>
                            <input type="hidden" name="target" value="configurator">
                            <br>
                            <br>
                            <br>
                        </button>
                    </form>
                </div>
            </div>
            <div class="col mb-4">
                <div class="card" style="background-color: #174b87">
                    <form class="form-inline" role="form" name="tools" action="FrontController" method="POST">
                        <button class="btn bg-transparent border-0 bg-white p-0 m-0 w-100" type="submit" value="submit"
                                id="toolsBtn">
                            <br>
                            <br>
                            <span class="text-center text-white h1">VÆRKTØJ</span>
                            <input type="hidden" name="target" value="tools">
                            <br>
                            <br>
                            <br>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.html" %>