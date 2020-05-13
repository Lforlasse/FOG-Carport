package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.Component;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tools extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        if (request.getParameter("pageFunction").equals("getComponentData")) {
            int compId = Integer.parseInt(request.getParameter("compId"));
            try {
                request.setAttribute("component", LogicFacade.getComponent(compId));
            } catch (Exception ex) {
                request.setAttribute("error", "Der skete en fejl!");
            }

            request.setAttribute("compId", compId);
        }
        return "toolspage";
    }
}
