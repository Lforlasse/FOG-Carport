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
                Værktøj
            </div>
            <div class="card-body">
                <form action="FrontController" method="POST">
                    <input type="hidden" name="target" value="offerRequestsOverview">
                    <button type="submit" class="btn btn-secondary w-100" value="submit">Anmodningsoversigt</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html"%>