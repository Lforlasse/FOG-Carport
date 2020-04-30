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
        request.setAttribute("offerRequest", LogicFacade.getOfferRequest(confId));
        request.setAttribute("confId", confId);
        return "offerrequestpage";
    }
}
