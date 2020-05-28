package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OfferRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewOfferRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int confId = Integer.parseInt(request.getParameter("confId"));
        OfferRequest offerRequest = LogicFacade.getOfferRequest(confId);
        String offerRequestStatus = offerRequest.getCarport().getConfStatus();

        try {
            int pageFunction = Integer.parseInt(request.getParameter("pageFunction"));

            if (pageFunction == 1) { //Update status function
                if (offerRequest.getCarport().setConfStatus(request.getParameter("offerRequestStatus"))) {
                    offerRequestStatus = offerRequest.getCarport().getConfStatus();
                    request.setAttribute("success", "Status opdateret!");
                    request.setAttribute("offerRequestStatus", offerRequestStatus);
                } else {
                    request.setAttribute("error", "Der skete en fejl: 1");
                }
            }

            if (pageFunction == 2) { //Update profit function
                try {
                    request.setAttribute("suggestedSalesPriceProfit", (offerRequest.profit(Integer.parseInt(request.getParameter("suggestedSalesPrice")))));
                } catch (Exception ex) {
                    System.out.println(ex);
                    request.setAttribute("error", "Der skete en fejl! 2");
                }
            }
        } catch (Exception ex) {
        }

        offerRequest = LogicFacade.getOfferRequest(confId);
        request.setAttribute("offerRequestStatusList", LogicFacade.getOfferRequestStatusTypes());
        request.setAttribute("offerRequestStatus", offerRequestStatus);
        request.setAttribute("offerRequest", offerRequest);
        request.setAttribute("confId", confId);
        request.setAttribute("svg",offerRequest.getBlueprint().getBlueprintSVG());
        return "offerrequestpage";
    }
}

