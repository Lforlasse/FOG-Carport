<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.html" %>

<!-- NAVBAR -->
<div class="container">
    <nav class="navbar navbar-light bg-light shadow-sm border-left border-right">
        <form  class="form-inline" role="form" name="index" action="FrontController" method="POST">
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
                Carport mål
            </div>
            <div class="card-body">
                <form>
                    <div class="form-row mb-3">
                        <div class="col px-0">
                            <label for="lengthRange">Længde</label>
                            <c:set var="lengthLimitMin" value="${requestScope.lengthLimits[0]}"/>
                            <c:set var="lengthLimitMax" value="${requestScope.lengthLimits[1]}"/>
                        </div>
                        <div class="col">

                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="cm"
                                   id="lengthInput" min="${lengthLimitMin}" max="${lengthLimitMax}" oninput="lengthRange.value=lengthInput.value">
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" id="lengthRange" value="0"
                                   min="${lengthLimitMin}" max="${lengthLimitMax}" oninput="lengthInput.value=lengthRange.value">
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
                                   placeholder="cm"
                                   id="widthInput" min="${widthLimitMin}" max="${widthLimitMax}" oninput="widthRange.value=widthInput.value">
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" id="widthRange" value="0"
                                   min="${widthLimitMin}" max="${widthLimitMax}" oninput="widthInput.value=widthRange.value">
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
                                   placeholder="cm"
                                   id="heightInput" min="${heightLimitMin}" max="${heightLimitMax}" oninput="heightRange.value=heightInput.value">
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" id="heightRange" value="0"
                                   min="${heightLimitMin}" max="${heightLimitMax}" oninput="heightInput.value=heightRange.value">
                        </div>
                    </div>
                    <div class="form-row mb-5">
                        <div class="col px-0">
                            Materiale
                        </div>
                        <select class="custom-select col-10 border-secondary">
                            <c:forEach items="${requestScope.materials}" var="material" >
                                <option value="${material}">${material}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>

                    <div class="form-row mb-3">
                        <div class="col px-0 form-inline">
                            Tagrejsning
                            <div class="custom-control custom-checkbox ml-auto">
                                <input type="checkbox" class="custom-control-input" id="roofCheck" name="roofCheck"
                                       onclick="toggleElement('roofInput', 'roofCheck','enable');
                                                toggleElement('roofRange', 'roofCheck','enable');
                                                toggleElement('roofMaterial', 'roofCheck','enable');">
                                <label class="custom-control-label" for="roofCheck"></label>
                                <c:set var="roofAngleMin" value="${requestScope.roofAngleLimits[0]}"/>
                                <c:set var="roofAngleMax" value="${requestScope.roofAngleLimits[1]}"/>
                            </div>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control text-right px-0 h-100 border-secondary"
                                   placeholder="grader &deg"
                                   id="roofInput" min="${roofAngleMin}" max="${roofAngleMax}" oninput="roofRange.value=roofInput.value" disabled>
                        </div>
                        <div class="col-8 border border-secondary rounded">
                            <input type="range" class="custom-range h-100" id="roofRange" value="0"
                                   min="${roofAngleMin}" max="${roofAngleMax}" oninput="roofInput.value=roofRange.value" disabled>
                        </div>
                    </div>
                    <div class="form-row mb-4">
                        <div class="col px-0">
                            Materiale
                        </div>
                        <select class="custom-select col-10 border-secondary" id="roofMaterial" disabled>
                            <c:forEach items="${requestScope.roofMaterials}" var="material" >
                                <option value="${material}">${material}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <a href="#" class="btn btn-secondary float-right">Bekræft</a>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.html" %>