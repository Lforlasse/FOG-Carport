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
        <c:if test="${requestScope.actionSuccess}">
            <div class="alert alert-success" role="alert">
                Tak for din forespørgsel!
                <br>
                Inden for 5 hverdage vil du blive tilsendt et tilbud pr. email.
                <br>
                <br>
                Anmodnings ID: ${requestScope.offerRequestID}
            </div>
        </c:if>

        <!-- CONTENT -->
        <form role="form" name="configFormula" action="FrontController" method="POST">
            <div class="card mb-4">
                <div class="card-header">
                    Carport konfiguration
                </div>
                <div class="card-body">
                    <div class="form-row mb-3">
                        <div class="col px-0">
                            <label for="lengthRange">Længde</label>
                            <c:set var="lengthLimitMin" value="${requestScope.lengthLimits[0]}"/>
                            <c:set var="lengthLimitMax" value="${requestScope.lengthLimits[1]}"/>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" name="lengthInput" id="lengthInput"
                                   min="${lengthLimitMin}" max="${lengthLimitMax}"
                                   oninput="lengthRange.value=lengthInput.value">
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" value="0"
                                   id="lengthRange"
                                   min="${lengthLimitMin}" max="${lengthLimitMax}"
                                   oninput="lengthInput.value=lengthRange.value">
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col px-0">
                            <label for="widthRange">Bredde</label>
                            <c:set var="widthLimitMin" value="${requestScope.widthLimits[0]}"/>
                            <c:set var="widthLimitMax" value="${requestScope.widthLimits[1]}"/>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" name="widthInput" id="widthInput"
                                   min="${widthLimitMin}" max="${widthLimitMax}"
                                   oninput="widthRange.value=widthInput.value">
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" value="0"
                                   id="widthRange"
                                   min="${widthLimitMin}" max="${widthLimitMax}"
                                   oninput="widthInput.value=widthRange.value">
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col px-0">
                            <label for="heightRange">Højde</label>
                            <c:set var="heightLimitMin" value="${requestScope.heightLimits[0]}"/>
                            <c:set var="heightLimitMax" value="${requestScope.heightLimits[1]}"/>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm" name="heightInput" id="heightInput"
                                   min="${heightLimitMin}" max="${heightLimitMax}"
                                   oninput="heightRange.value=heightInput.value">
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" value="0"
                                   name="heightRange" id="heightRange"
                                   min="${heightLimitMin}" max="${heightLimitMax}"
                                   oninput="heightInput.value=heightRange.value">
                        </div>
                    </div>
                    <div class="form-row mb-5">
                        <div class="col px-0">
                            Materiale
                        </div>
                        <select class="custom-select col-10 border-secondary"
                                name="confMaterial" id="confMaterial">
                            <c:forEach items="${requestScope.materials}" var="material">
                                <option value="${material}">${material}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>

                    <div class="form-row mb-3">
                        <div class="col px-0 form-inline">
                            Tagrejsning
                            <div class="custom-control custom-checkbox ml-auto">
                                <input type="checkbox" class="custom-control-input"
                                       name="roofCheck" id="roofCheck"
                                       onclick="toggleElement('roofInput', 'roofCheck','enable');
                                                toggleElement('roofRange', 'roofCheck','enable');">
                                <label class="custom-control-label" for="roofCheck"></label>
                                <c:set var="roofAngleMin" value="${requestScope.roofAngleLimits[0]}"/>
                                <c:set var="roofAngleMax" value="${requestScope.roofAngleLimits[1]}"/>
                            </div>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="grader &deg" name="roofInput" id="roofInput"
                                   min="${roofAngleMin}" max="${roofAngleMax}" oninput="roofRange.value=roofInput.value"
                                   disabled>
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" value="0"
                                   id="roofRange"
                                   min="${roofAngleMin}" max="${roofAngleMax}" oninput="roofInput.value=roofRange.value"
                                   disabled>
                        </div>
                    </div>
                    <div class="form-row mb-4">
                        <div class="col px-0">
                            Materiale
                        </div>
                        <select class="custom-select col-10 border-secondary"
                                name="roofMaterial" id="roofMaterial">
                            <c:forEach items="${requestScope.roofMaterials}" var="material">
                                <option value="${material}">${material}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header">
                    Kontakt information
                </div>
                <div class="card-body">
                    <div class="form-row mb-3">
                        <div class="col px-0">
                            <label for="foreNameInput">Navn</label>
                        </div>
                        <div class="col-5">
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="fornavn" name="foreNameInput" id="foreNameInput"
                                   min="0" max="600" oninput="" required>
                        </div>
                        <div class="col-5">
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="efternavn" name="surNameInput" id="surNameInput"
                                   min="0" max="600" oninput="" required>
                        </div>
                    </div>
                    <div class="form-row mb-3">

                        <div class="col px-0">
                            <label for="emailInput">Kontakt</label>
                        </div>
                        <div class="col-7">
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="email" name="emailInput" id="emailInput"
                                   min="0" max="600" oninput="" required>
                        </div>
                        <div class="col-3">
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="telefon" name="phoneInput" id="phoneInput"
                                   min="0" max="600" oninput="" required>
                        </div>
                    </div>
                    <div class="form-row mb-3">

                        <div class="col px-0">
                            <label for="lengthRange">Adresse</label>
                        </div>
                        <div class="col-3">
                            <input type="text" class="form-control text-right h-100 border-secondary"
                                   placeholder="postnummer" name="postalInput" id="postalInput"
                                   min="0" max="600" oninput="" required>
                        </div>
                    </div>
                    <input type="hidden" name="target" value="offerRequest">
                    <button type="submit" class="btn btn-secondary float-right" value="submit">Anmod tilbud</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@include file="../includes/footer.html" %>