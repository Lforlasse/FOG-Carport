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

        <!-- CONTENT -->
        <div class="card mb-4">

            <div class="card-header">
                #${requestScope.confId}
            </div>
            <div class="card-body">
                <form>
                    <div class="form-row mb-3">
                        <div class="col-1 px-0">
                            <label for="length">Længde</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="carportLength" value="${requestScope.offerRequest.carport.confLength} cm"
                                   readonly>
                        </div>
                        <div class="col-1 px-0">
                            <label for="width">Bredde</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="carportWidth" value="${requestScope.offerRequest.carport.confWidth} cm"
                                   readonly>
                        </div>
                        <div class="col-1 px-0">
                            <label for="height">Højde</label>
                        </div>
                        <div class="col">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="carportHeight" value="${requestScope.offerRequest.carport.confHeight} cm"
                                   readonly>
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col-1 px-0">
                            <label for="length">Materiale</label>
                        </div>
                        <div class="col mr-3">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm"
                                   id="length" min="0" max="600" oninput="lengthRange.value=lengthInput.value">
                        </div>
                        <div class="col-1 px-0">
                            <label for="width">Bredde</label>
                        </div>
                        <div class="col mr-3">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm"
                                   id="width" min="0" max="600" oninput="lengthRange.value=lengthInput.value">
                        </div>
                        <div class="col-1 px-0">
                            <label for="height">Højde</label>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm"
                                   id="height" min="0" max="600" oninput="lengthRange.value=lengthInput.value">
                        </div>
                    </div>
                    <input type="hidden" name="target" value="prefab">
                    <button type="submit" class="btn btn-secondary float-right" value="submit">Gem</button>
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Prisudregner
            </div>
            <div class="card-body">
                <form>
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
                            <label for="width">Foreslå salgspris</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="number"
                                   id="salesPrice" value="">
                        </div>
                        <div class="col-1 px-0">
                            <label for="width">Profit</label>
                        </div>
                        <div class="col mr-3">
                            <input class="form-control text-right px-0 h-100 border-secondary" type="text"
                                   id="profitNew" value="">
                        </div>
                    </div>
                    <input type="hidden" name="target" value="prefab">
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