package PresentationLayer;

import FunctionLayer.Component;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tools extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        try {
            if (request.getParameter("pageFunction").equals("getComponentData")) {
                int compId = Integer.parseInt(request.getParameter("compId"));
                try {
                    Component component = LogicFacade.getComponent(compId);
                    request.setAttribute("component", component);
                    if (component.getCompDesc().equals("Ingen komponent fundet")) {
                        request.setAttribute("error", "Ingen komponent fundet, komponent ID: '" + compId + "'");
                    }
                } catch (Exception ex) {
                    request.setAttribute("error", "Der skete en fejl!");
                }

                request.setAttribute("compId", compId);
            }

            if (request.getParameter("pageFunction").equals("updateComponentData")) {
                int compId = Integer.parseInt(request.getParameter("compId"));
                int newSalesPrice = Integer.parseInt(request.getParameter("newSalesPrice"));
                if (LogicFacade.updateComponentSalesPrice(compId, newSalesPrice)) {
                    //String message = "Salgspris opdateret, komponent ID: '" + compId + "'";
                    //request.setAttribute("success", message);
                }
            }

            if (request.getParameter("pageFunction").equals("newComponent")) {
                request.setAttribute("newComponent", "NOT NULL");
            }

            if (request.getParameter("pageFunction").equals("insertNewComponent")) {
                String compDesc = request.getParameter("newComponentDesc");
                String compMaterial = request.getParameter("newComponentMaterial");
                if (LogicFacade.getMaterialByName(compMaterial).equals("")) {
                    if (!(LogicFacade.insertNewMaterial(compMaterial))) {
                        request.setAttribute("error","DER SKETE EN FEJL!");
                    }
                }

                int compHeight = Integer.parseInt(request.getParameter("newComponentHeight"));
                int compWidth = Integer.parseInt(request.getParameter("newComponentWidth"));
                int compLength = Integer.parseInt(request.getParameter("newComponentLength"));
                int compVendorPrice = Integer.parseInt(request.getParameter("newComponentVendorPrice"));
                int compSalesPrice = Integer.parseInt(request.getParameter("newComponentSalesPrice"));

                if (LogicFacade.insertNewComponent(compDesc, compMaterial, compHeight, compWidth, compLength,
                        compVendorPrice, compSalesPrice)) {
                    request.setAttribute("success","Ny komponent oprettet!");
                } else {
                    request.setAttribute("error","DER SKETE EN FEJL!");
                }
            }
        } catch (Exception ex) {
        }
        request.setAttribute("completeCompList", LogicFacade.getAllComponents());
        return "toolspage";
    }
}
