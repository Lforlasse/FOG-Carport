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
        <%@include file="../includes/success.html" %>

        <!-- CONTENT -->
        <form action="FrontController" method="POST">
            <div class="alert alert-dark px-3">
                <div class="input-group">

                    <div class="input-group-prepend">
                        <span class="input-group-text border-secondary">#${requestScope.offerRequest.confId}</span>
                        <span class="input-group-text border-secondary">Status</span>
                    </div>
                    <select class="form-control custom-select border-secondary" name="offerRequestStatus">
                        <c:forEach var="statusList" items="${requestScope.offerRequestStatusList}">
                            <option
                                    <c:choose>
                                        <c:when test="${requestScope.offerRequest.carport.confStatus.equals(statusList)}">
                                            selected
                                        </c:when>
                                    </c:choose>
                            >${statusList}</option>
                        </c:forEach>
                    </select>
                    <div class="input-group-append bg-white rounded">
                        <span class="input-group-text border-secondary">Oprettet:&nbsp;<b>${requestScope.offerRequest.carport.CREATED_DATE}</b></span>
                        <span class="input-group-text border-secondary border-right-0">Ændret:&nbsp;<b>${requestScope.offerRequest.carport.changedDate}</b></span>

                        <input type="hidden" name="target" value="viewOfferRequest">
                        <input type="hidden" name="confId" value="${requestScope.offerRequest.confId}">
                        <input type="hidden" name="pageFunction" value="1">
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
                        <div class="col-2">
                            Struktur
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="length">Længde</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="cm" id="length"
                                   value="${requestScope.offerRequest.carport.confLength} cm" readonly>
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="width">Bredde</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="cm" id="width"
                                   value="${requestScope.offerRequest.carport.confWidth} cm" readonly>
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="height">Højde</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="cm" id="height"
                                   value="${requestScope.offerRequest.carport.confHeight} cm" readonly>
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="material">Materiale</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="cm" id="material"
                                   value="${requestScope.offerRequest.carport.confMat}" readonly>
                        </div>
                    </div>
                    <!-- row 2 -->
                    <div class="form-row">
                        <div class="col-2">
                            Tag
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="roofAngle">Tagvinkel</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="cm" id="roofAngle"
                                   value="${requestScope.offerRequest.carport.roof.inclination}" readonly>
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="roofMaterial">Materiale</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="cm" id="roofMaterial"
                                   value="${requestScope.offerRequest.carport.roof.material}" readonly>
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
                    <!-- Row 1 -->
                    <div class="form-row mb-3">
                        <div class="col-2">
                            Leverance
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="vendorPrice">Kostpris</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="kr." id="vendorPrice"
                                   value="${requestScope.offerRequest.vendorPrice} kr." readonly>
                        </div>
                    </div>
                    <!-- Row 2 -->
                    <div class="form-row mb-3">
                        <div class="col-2">
                            Estimeret Salg
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="salesPrice">Salgspris</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="kr." id="salesPrice"
                                   value="${requestScope.offerRequest.salesPrice} kr." readonly>
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="salesPriceProfit">Profit</label>
                                </span>
                            </div>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="kr." id="salesPriceProfit"
                                   value="${requestScope.offerRequest.profit(requestScope.offerRequest.salesPrice)} kr."
                                   readonly>
                        </div>
                    </div>

                    <!-- Row 3 -->
                    <div class="form-row mb-3">
                        <div class="col-2">
                            Forslået Salg
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="suggestedSalesPrice">Ny pris</label>
                                </span>
                            </div>
                            <input type="number" class="form-control text-right h-100 border-secondary"
                                   placeholder="" name="suggestedSalesPrice" id="suggestedSalesPrice"
                                   value="">
                        </div>
                        <div class="input-group input-group-sm col">
                            <div class="input-group-prepend">
                                <span class="input-group-text border-secondary">
                                    <label class="m-0" for="suggestedSalesPriceProfit">Profit</label>
                                </span>
                            </div>
                            <c:choose>
                                <c:when test="${requestScope.suggestedSalesPriceProfit != null}">
                                    <c:set var="suggestedSalesPriceProfit"
                                           value="${requestScope.suggestedSalesPriceProfit}"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="suggestedSalesPriceProfit" value="N/A"/>
                                </c:otherwise>
                            </c:choose>
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="kr." id="suggestedSalesPriceProfit"
                                   value="${suggestedSalesPriceProfit} kr." readonly>
                        </div>
                    </div>
                    <input type="hidden" name="target" value="viewOfferRequest">
                    <input type="hidden" name="confId" value="${requestScope.offerRequest.confId}">
                    <input type="hidden" name="pageFunction" value="2">
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
                            <th scope="col">Type</th>
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
                                <td>${compItem.key.compDesc}</td>
                                <td>${compItem.key.material}</td>
                                <td>${compItem.key.compLength}</td>
                                <td>${compItem.value}</td>
                                <td>${compItem.key.compInfo}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="overflow-auto mb-3">
                    <table class="table table-bordered table-sm table-hover text-nowrap mb-0">
                        <thead>
                        <tr>
                            <th scope="col">Vare nr.</th>
                            <th scope="col">Type</th>
                            <th scope="col">Højde</th>
                            <th scope="col">Bredde</th>
                            <th scope="col">Antal</th>
                            <th scope="col">Beskrivelse</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="roofUnitList" value="${requestScope.offerRequest.roofUnitList}"/>
                        <c:forEach var="roofUnit" items="${roofUnitList}">
                            <tr>
                                <th scope="col">${roofUnit.key.unitId}</th>
                                <td>${roofUnit.key.unitDesc}</td>
                                <td>${roofUnit.key.unitLength}</td>
                                <td>${roofUnit.key.unitWidth}</td>
                                <td>${roofUnit.value}</td>
                                <td>${roofUnit.key.unitInfo}</td>
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
                            <th scope="col">Type</th>
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
                                <td>${partItem.key.partDesc}</td>
                                <td>${partItem.key.itemType}</td>
                                <td>${partItem.value}</td>
                                <td>${partItem.key.partInfo}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Plantegning
            </div>
            <div class="card-body">
                ${requestScope.svg}
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html" %>