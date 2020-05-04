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
            <form class="form-inline" role="form" name="tools" action="FrontController" method="POST">
                <input type="hidden" name="target" value="tools">
                <button type="submit" class="btn btn-outline-secondary" value="submit">Værktøj</button>
            </form>
        </div>
    </nav>
</div>

<!-- BODY -->
<div class="container">
    <div class="container border border-top-0 px-4 pt-4 shadow-sm">

        <!-- ALERTS -->
        <%@include file="../includes/error.html" %>
        <%@include file="../includes/success.html" %>

        <!-- CONTENT -->
        <form action="FrontController" method="POST">
            <div class="alert alert-dark px-3">
                <div class="input-group">

                    <div class="input-group-prepend">
                        <span class="input-group-text border-secondary">#${requestScope.confId}</span>
                        <span class="input-group-text border-secondary bg-white">Status</span>
                    </div>
                    <select class="form-control custom-select border-secondary" name="offerRequestStatus">
                        <c:forEach var="statusList" items="${requestScope.offerRequestStatusList}">
                            <option
                                    <c:choose>
                                        <c:when test="${requestScope.offerRequestStatus.equals(statusList)}">
                                            selected
                                        </c:when>
                                    </c:choose>
                            >${statusList}</option>
                        </c:forEach>
                    </select>
                    <div class="input-group-append bg-white rounded">
                        <input type="hidden" name="target" value="viewOfferRequest">
                        <input type="hidden" name="confId" value="${requestScope.confId}">
                        <input type="hidden" name="pageFunction" value="0">
                        <button type="submit" class="btn btn-outline-secondary" value="submit">Opdater</button>
                    </div>
                </div>
            </div>
        </form>

        <div class="card mb-4">
            <div class="card-header">
                Konfiguration
            </div>
            <div class="card-body">
                <form>
                    <!-- row 1 -->
                    <div class="form-row mb-3">
                        <div class="input-group input-group-sm col-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary"><label
                                        for="length">Længde</label></span>
                            </div>
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" id="length"
                                   value="${requestScope.offerRequest.carport.confLength} cm" readonly>
                        </div>
                        <div class="input-group input-group-sm col-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary"><label for="width">Bredde</label></span>
                            </div>
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" id="width"
                                   value="${requestScope.offerRequest.carport.confWidth} cm" readonly>
                        </div>
                        <div class="input-group input-group-sm col-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary"><label for="height">Højde</label></span>
                            </div>
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" id="height"
                                   value="${requestScope.offerRequest.carport.confHeight} cm" readonly>
                        </div>
                    </div>
                    <!-- row 2 -->
                    <div class="form-row mb-3">
                        <div class="input-group input-group-sm col-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary"><label for="material">Materiale</label></span>
                            </div>
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" id="material"
                                   min="0" max="600" oninput="lengthRange.value=lengthInput.value" readonly>
                        </div>
                        <div class="input-group input-group-sm col-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary"><label for="roof1">roof1</label></span>
                            </div>
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" id="roof1"
                                   min="0" max="600" oninput="lengthRange.value=lengthInput.value" readonly>
                        </div>
                        <div class="input-group input-group-sm col-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary"><label for="roof2">roof2</label></span>
                            </div>
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" id="roof2"
                                   min="0" max="600" oninput="lengthRange.value=lengthInput.value" readonly>
                        </div>
                    </div><!--
                    <input type="hidden" name="target" value="prefab">
                    <button type="submit" class="btn btn-secondary float-right" value="submit">Gem</button>
                    -->
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Prisudregner
            </div>
            <div class="card-body">
                <form action="FrontController" method="POST">
                    <div class="form-row mb-3">
                        <div class="col-1 px-0">
                            <label for="length">Indkøb</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="vendorPrice" value="${requestScope.offerRequest.vendorPrice} kr" readonly>
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col-1 px-0">
                            <label for="width">Estimeret Salg</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="salesPriceReadonly" value="${requestScope.offerRequest.salesPrice} kr" readonly>
                        </div>
                        <div class="col-1 px-0">
                            <label for="width">Profit</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="profitReadonly"
                                   value="${requestScope.offerRequest.profit(requestScope.offerRequest.salesPrice)} kr"
                                   readonly>
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col-1 px-0">
                            <label for="salesPrice">Foreslå salgspris</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="number"
                                   name="salesPrice" id="salesPrice" value="">
                        </div>
                        <div class="col-1 px-0">
                            <label for="profitNew">Profit</label>
                        </div>
                        <div class="col mr-3">
                            <c:choose>
                                <c:when test="${requestScope.newProfit != null}">
                                    <c:set var="profitNew" value="${requestScope.newProfit}"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="profitNew" value=""/>
                                </c:otherwise>
                            </c:choose>
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="profitNew" value="${profitNew}" readonly>
                        </div>
                    </div>
                    <input type="hidden" name="target" value="viewOfferRequest">
                    <input type="hidden" name="confId" value="${requestScope.confId}">
                    <button type="submit" class="btn btn-secondary float-right" value="submit">Udregn</button>
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Stykliste
            </div>
            <div class="card-body">
                <div class="overflow-auto mb-3">
                    <table class="table table-bordered table-sm table-hover text-nowrap mb-0">
                        <thead>
                        <tr>
                            <th scope="col">Vare nr.</th>
                            <th scope="col">Beskrivelse</th>
                            <th scope="col">Materiale</th>
                            <th scope="col">Længde</th>
                            <th scope="col">Antal</th>
                            <th scope="col">Beskrivelse</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="compList" value="${requestScope.offerRequest.compList}"/>
                        <c:forEach var="compItem" items="${compList}">
                            <tr>
                                <th scope="col">${compItem.key.compId}</th>
                                <td scope="col">${compItem.key.compDesc}</td>
                                <td scope="col">${compItem.key.material}</td>
                                <td scope="col">${compItem.key.compLength}</td>
                                <td scope="col">${compItem.value}</td>
                                <td scope="col">INCOMING</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="overflow-auto">
                    <table class="table table-bordered table-sm table-hover text-nowrap mb-0">
                        <thead>
                        <tr>
                            <th scope="col">Vare nr.</th>
                            <th scope="col">Beskrivelse</th>
                            <th scope="col">Enhed</th>
                            <th scope="col">Antal</th>
                            <th scope="col">Beskrivelse</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="partList" value="${requestScope.offerRequest.partList}"/>
                        <c:forEach var="partItem" items="${partList}">
                            <tr>
                                <th scope="col">${partItem.key.partId}</th>
                                <td scope="col">${partItem.key.partDesc}</td>
                                <td scope="col">${partItem.key.itemType}</td>
                                <td scope="col">${partItem.value}</td>
                                <td scope="col">INCOMING</td>
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