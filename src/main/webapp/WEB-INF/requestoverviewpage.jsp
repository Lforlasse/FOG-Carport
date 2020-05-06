<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.html" %>

<!-- NAVBAR -->
<%@include file="../includes/navbar.html" %>

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
                <div class="overflow-auto mb">
                    <form action="FrontController" method="POST">
                        <table class="table table-bordered table-sm table-hover text-nowrap mb-0" id="offerRequestsTable">
                            <thead>
                            <tr>
                                <th scope="col">Request ID</th>
                                <th scope="col" onclick="sortTable(0, 'offerRequestsTable')">Status</th>
                                <th scope="col" onclick="sortTable(1, 'offerRequestsTable')">Kunde</th>
                                <th scope="col" onclick="sortTable(2, 'offerRequestsTable')">Oprettet</th>
                                <th scope="col" onclick="sortTable(3, 'offerRequestsTable')">Ændret.</th>
                                <th scope="col"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="offerRequest" items="${requestScope.offerRequestsList}">
                                <tr>
                                    <form action="FrontController" method="POST">
                                        <th scope="row">#${offerRequest.confId}</th>
                                        <td>${offerRequest.confStatus}</td>
                                        <td>${offerRequest.custName}</td>
                                        <td>${offerRequest.CREATED_DATE}</td>
                                        <td>${offerRequest.changedDate}</td>
                                        <td>
                                            <input type="hidden" name="target" value="viewOfferRequest">
                                            <input type="hidden" name="confId" value="${offerRequest.confId}">
                                            <button type="submit" class="btn btn-sm btn-secondary w-100 px-0 py-1"
                                                    value="submit">
                                                Åben
                                            </button>
                                        </td>
                                    </form>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html" %>