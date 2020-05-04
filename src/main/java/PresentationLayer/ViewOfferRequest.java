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
        String offerRequestStatus = LogicFacade.getOfferRequestStatus(confId);
        request.setAttribute("offerRequestStatusList", LogicFacade.getOfferRequestStatusTypes());
        request.setAttribute("offerRequestStatus", offerRequestStatus);
        request.setAttribute("offerRequest", offerRequest);
        request.setAttribute("confId", confId);


        try {
            int test = Integer.parseInt(request.getParameter("pageFunction"));

            //Update profit function
            try {
                request.setAttribute("newProfit", (offerRequest.profit(Integer.parseInt(request.getParameter("salesPrice")))));
            } catch (Exception ex) {
            }

            //Update status function
            try {
                if (!(LogicFacade.updateOfferRequestStatus(confId, request.getParameter("offerRequestStatus")))) {
                    request.setAttribute("error", "Der skete en fejl!");
                } else {
                    offerRequestStatus = LogicFacade.getOfferRequestStatus(confId);
                    request.setAttribute("success", "Status opdateret!");
                    request.setAttribute("offerRequestStatus", offerRequestStatus);
                }
            } catch (Exception ex) {
            }
        } catch (Exception ex) {
        }
        return "offerrequestpage";
    }
}

