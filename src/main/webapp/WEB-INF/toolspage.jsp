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
                            <button type="submit" class="btn btn-outline-secondary w-100" name="pageFunction"
                                    value="getNewOfferRequests">Se nye anmodninger
                            </button>
                        </div>
                        <div class="input-group col">
                            <button type="submit" class="btn btn-outline-secondary w-100" name="pageFunction"
                                    value="getActiveOfferRequests">Se anmodninger i behandling
                            </button>
                        </div>
                        <div class="input-group col">
                            <button type="submit" class="btn btn-outline-secondary w-100" name="pageFunction"
                                    value="getClosedOfferRequests">Se afsluttede anmodninger
                            </button>
                        </div>
                    </div>
                    <input type="hidden" name="target" value="offerRequestsOverview">
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Komponent værktøj
            </div>
            <form action="FrontController" method="POST">
                <div class="card-body">

                    <!-- Row 1 -->
                    <div class="form-row">
                        <div class="input-group col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="compId">Komponent</label>
                                </span>
                            </div>
                            <input type="number" class="form-control text-right h-100 w-100 border-secondary"
                                   placeholder="id" name="compId" id="compId"
                                   value="${requestScope.component.compId}">
                            <div class="input-group-append bg-white rounded">
                                <button type="submit" class="btn btn-outline-secondary" name="pageFunction"
                                        value="getComponentData">Redigér
                                </button>
                            </div>
                        </div>
                        <div class="input-group col">
                            <button type="submit" class="btn btn-secondary w-100" name="pageFunction"
                                    value="newComponent">Ny komponent
                            </button>
                        </div>
                    </div>
                </div>

                <c:if test="${requestScope.component != null}">
                    <!-- JSTL START: IF STATEMENT TO SHOW ONLY IF component-attribute is NOT NULL -->
                    <div class="card-body border-top">
                        <!-- Row 2 -->
                        <div class="form-row mb-3">
                            <div class="input-group col-2">
                                Komponent
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="componentType">Type</label>
                                </span>
                                </div>
                                <input type="text" class="form-control text-right h-100 border-secondary"
                                       placeholder="" name="componentType" id="componentType"
                                       value="${requestScope.component.compDesc}" READONLY>
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="componentMaterial">Materiale</label>
                                </span>
                                </div>
                                <input type="text" class="form-control text-right h-100 border-secondary"
                                       placeholder="" name="componentMaterial" id="componentMaterial"
                                       value="${requestScope.component.material}" READONLY>
                            </div>
                        </div>

                        <!-- Row 3 -->
                        <div class="form-row mb-3">
                            <div class="input-group col-2">
                                Salg
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="currentSalesPrice">Pris</label>
                                </span>
                                </div>
                                <input type="text" class="form-control text-right h-100 border-secondary"
                                       placeholder="" name="currentSalesPrice" id="currentSalesPrice"
                                       value="${requestScope.component.salesPrice} kr." READONLY>
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newSalesPrice">Ny pris</label>
                                </span>
                                </div>
                                <input type="number" class="form-control text-right h-100 border-secondary"
                                       placeholder="" name="newSalesPrice" id="newSalesPrice"
                                       value="">
                            </div>
                        </div>

                        <!-- Row 4 -->
                        <div class="form-row mb-3 float-right">
                            <div class="input-group col">
                                <button type="submit" class="btn btn-secondary" name="pageFunction"
                                        value="updateComponentData">Opdater
                                </button>
                            </div>
                        </div>
                        <!-- JSTL END: IF STATEMENT -->
                    </div>
                </c:if>

                <c:if test="${requestScope.newComponent != null}">
                    <!-- JSTL START: IF STATEMENT TO SHOW ONLY IF newComponent-attribute is NOT NULL -->
                    <div class="card-body border-top">
                        <!-- Row 2 -->
                        <div class="form-row mb-3">
                            <div class="input-group col-2">
                                Komponent
                            </div>
                            <div class="input-g roup col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentDesc">Type</label>
                                </span>
                                </div>
                                <input type="text" class="form-control text-right h-100 border-secondary"
                                       placeholder="" name="newComponentDesc" id="newComponentDesc"
                                       value="">
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentMaterial">Materiale</label>
                                </span>
                                </div>
                                <input type="text" class="form-control text-right h-100 border-secondary"
                                       placeholder="" name="newComponentMaterial" id="newComponentMaterial"
                                       value="">
                            </div>
                        </div>

                        <!-- Row 3 -->
                        <div class="form-row mb-3">
                            <div class="input-group col-2">
                                Mål
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentHeight">Højde</label>
                                </span>
                                </div>
                                <input type="number" class="form-control text-right h-100 border-secondary"
                                       placeholder="cm" name="newComponentHeight" id="newComponentHeight"
                                       value="">
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentWidth">Bredde</label>
                                </span>
                                </div>
                                <input type="number" class="form-control text-right h-100 border-secondary"
                                       placeholder="cm" name="newComponentWidth" id="newComponentWidth"
                                       value="">
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentLength">Længde</label>
                                </span>
                                </div>
                                <input type="number" class="form-control text-right h-100 border-secondary"
                                       placeholder="cm" name="newComponentLength" id="newComponentLength"
                                       value="">
                            </div>
                        </div>

                        <!-- Row 4 -->
                        <div class="form-row mb-3">
                            <div class="input-group col-2">
                                Salg
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentVendorPrice">Indkøbspris</label>
                                </span>
                                </div>
                                <input type="text" class="form-control text-right h-100 border-secondary"
                                       placeholder="kr." name="newComponentVendorPrice"
                                       id="newComponentVendorPrice"
                                       value="">
                            </div>
                            <div class="input-group col">
                                <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="newComponentSalesPrice">Salgspris</label>
                                </span>
                                </div>
                                <input type="number" class="form-control text-right h-100 border-secondary"
                                       placeholder="kr." name="newComponentSalesPrice"
                                       id="newComponentSalesPrice"
                                       value="">
                            </div>
                        </div>

                        <!-- Row 5 -->
                        <div class="form-row mb-3 float-right">
                            <div class="input-group col">
                                <button type="submit" class="btn btn-secondary" name="pageFunction"
                                        value="insertNewComponent">Indsæt
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- JSTL END: IF STATEMENT -->
                </c:if>
                <input type="hidden" name="target" value="tools">
            </form>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Komponent oversigt
            </div>
            <div class="card-body">
                <div class="overflow-auto mb-3">
                    <table class="table table-bordered table-sm table-hover text-nowrap mb-0">
                        <thead>
                        <tr>
                            <th scope="col">Vare nr.</th>
                            <th scope="col">Type</th>
                            <th scope="col">Materiale</th>
                            <th scope="col">Længde</th>
                            <th scope="col">Indkøb</th>
                            <th scope="col">Salg</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="completeCompList" value="${requestScope.completeCompList}"/>
                        <c:forEach var="compItem" items="${completeCompList}">
                            <tr>
                                <th scope="col">${compItem.compId}</th>
                                <td>${compItem.compDesc}</td>
                                <td>${compItem.material}</td>
                                <td>${compItem.compLength} cm</td>
                                <td>${compItem.vendorPrice} kr.</td>
                                <td>${compItem.salesPrice} kr.</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html" %>