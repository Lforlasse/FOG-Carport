package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OfferRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateNewProfit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int confId = Integer.parseInt(request.getParameter("confId"));
        OfferRequest offerRequest = LogicFacade.getOfferRequest(confId);
        request.setAttribute("offerRequest", offerRequest);
        request.setAttribute("confId", confId);
        request.setAttribute("newProfit", (offerRequest.profit(Integer.parseInt(request.getParameter("salesPrice")))));
        return "offerrequestpage";
    }
}
