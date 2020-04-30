package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OfferRequestsOverview extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.setAttribute("offerRequestsList", LogicFacade.getAllOfferRequests());
        return "requestoverviewpage";
    }
}
