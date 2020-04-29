package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Configurator extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.setAttribute("materials", LogicFacade.carportMaterials());
        request.setAttribute("widthLimits", LogicFacade.widthLimits());
        request.setAttribute("lengthLimits", LogicFacade.lengthLimits());
        request.setAttribute("heightLimits", LogicFacade.heightLimits());
        request.setAttribute("roofAngleLimits", LogicFacade.roofAngleLimits());
        request.setAttribute("roofMaterials", LogicFacade.roofMaterials());
        return "configuratorpage";
    }
}
