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

                <!-- Row 1 -->
                <form action="FrontController" method="POST">
                    <div class="form-row mb-3">
                        <div class="input-group col">
                            <input type="hidden" name="pageFunction" value="getAllOfferRequests">
                            <button type="submit" class="btn btn-secondary w-100" name="target"
                                    value="offerRequestsOverview">Se alle anmodninger
                            </button>
                        </div>
                        <div class="input-group col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="confId">Offer Request ID</label>
                                </span>
                            </div>
                            <input type="number" class="form-control text-right h-100 border-secondary"
                                   placeholder="" name="confId" id="confId"
                                   value="">
                            <div class="input-group-append bg-white rounded">
                                <button type="submit" class="btn btn-outline-secondary" name="target"
                                        value="viewOfferRequest">Søg
                                </button>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- Row 2 -->
                <form action="FrontController" method="POST">
                    <div class="form-row">
                        <div class="input-group col">
                            <button type="submit" class="btn btn-secondary w-100" name="pageFunction"
                                    value="getNewOfferRequests">Se nye anmodninger
                            </button>
                        </div>
                        <div class="input-group col">
                            <button type="submit" class="btn btn-secondary w-100" name="pageFunction"
                                    value="getActiveOfferRequests">Se anmodninger i behandling
                            </button>
                        </div>
                        <div class="input-group col">
                            <button type="submit" class="btn btn-secondary w-100" name="pageFunction"
                                    value="getClosedOfferRequests">Se afsluttede anmodninger
                            </button>
                        </div>
                    </div>
                    <input type="hidden" name="target" value="offerRequestsOverview">
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html" %>