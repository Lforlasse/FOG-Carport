<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.html" %>

<!-- NAVBAR -->
<div class="container">
    <nav class="navbar navbar-light bg-light shadow-sm border-left border-right">
        <form class="form-inline" role="form" name="index" action="FrontController" method="POST">
            <input type="hidden" name="target" value="index">
            <button class="px-0 mx-0 border-0" style="width: 40px;">
                <img src="img/fog_logo_2015.jpg" class="img-fluid rounded" alt="Responsive image">
            </button>
        </form>
        <div class="d-inline-flex">
            <form class="form-inline" role="form" name="configurator" action="FrontController" method="POST">
                <input type="hidden" name="target" value="configurator">
                <button type="submit" class="btn btn-outline-secondary mr-2" value="submit">Konfigurator</button>
            </form>
            <form class="form-inline" role="form" name="prefab" action="FrontController" method="POST">
                <input type="hidden" name="target" value="prefab">
                <button type="submit" class="btn btn-outline-secondary" value="submit">Prefab</button>
            </form>
        </div>
    </nav>
</div>

<!-- BODY -->
<div class="container">
    <div class="container border border-top-0 px-4 pt-4 shadow-sm">

        <!-- ALERTS -->
        <%@include file="../includes/error.html" %>

        <!-- CONTENT -->
        <div class="card mb-4">
            <div class="card-header">
                Anmodningsoversigt
            </div>
            <div class="card-body">
                <table class="table table-bordered table-sm table-hover table-">
                    <thead>
                    <tr>
                        <th scope="col">Request ID</th>
                        <th scope="col">Status</th>
                        <th scope="col">Kunde</th>
                        <th scope="col">Telefon</th>
                        <th scope="col">Postnr.</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="offerRequest" items="${requestScope.offerRequestsList}">
                        <tr>
                            <form action="FrontController" method="POST">
                                <th scope="row">#${offerRequest.confId}</th>
                                <td>MISSING INFO</td>
                                <td>${offerRequest.custName}</td>
                                <td>${offerRequest.custPhone}</td>
                                <td>${offerRequest.custPostal}</td>
                                <td>
                                    <input type="hidden" name="target" value="viewOfferRequest">
                                    <input type="hidden" name="confId" value="${offerRequest.confId}">
                                    <button type="submit" class="btn btn-sm btn-secondary w-100 px-0 py-1" value="submit">
                                        Åben
                                    </button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html" %>