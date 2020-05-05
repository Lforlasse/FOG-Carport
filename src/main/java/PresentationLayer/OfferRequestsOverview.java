package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class OfferRequestsOverview extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        List<Carport> carportList = LogicFacade.getAllOfferRequests();
        List<Carport> offerRequestsList = new ArrayList<>();

        if (request.getParameter("pageFunction").equals("getNewOfferRequests")) {
            for (Carport carport : carportList) {
                if (carport.getConfStatus().equals("Ny")) {
                    offerRequestsList.add(carport);
                }
            }
        }
        if (request.getParameter("pageFunction").equals("getAllOfferRequests")) {
                    offerRequestsList = carportList;
        }
        if (request.getParameter("pageFunction").equals("getActiveOfferRequests")) {
            for (Carport carport : carportList) {
                if (carport.getConfStatus().equals("Behandles")) {
                    offerRequestsList.add(carport);
                }
            }
        }
        if (request.getParameter("pageFunction").equals("getClosedOfferRequests")) {
            for (Carport carport : carportList) {
                if (carport.getConfStatus().equals("Afsluttet")) {
                    offerRequestsList.add(carport);
                }
            }
        }

        request.setAttribute("offerRequestsList", offerRequestsList);

        return "requestoverviewpage";
    }
}
