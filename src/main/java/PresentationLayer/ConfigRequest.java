package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int lengthInput;
        try {
            lengthInput = Integer.parseInt(request.getParameter("lengthInput"));
        } catch (Exception e) {
            lengthInput = 0;
        }
        if (lengthInput < LogicFacade.lengthLimits().get(0)) {
            lengthInput = LogicFacade.lengthLimits().get(0);
        } else if (lengthInput > LogicFacade.lengthLimits().get(1)) {
            lengthInput = LogicFacade.lengthLimits().get(1);
        }

        int widthInput;
        try {
            widthInput = Integer.parseInt(request.getParameter("widthInput"));
        } catch (Exception e) {
            widthInput = 0;
        }
        if (widthInput < LogicFacade.widthLimits().get(0)) {
            widthInput = LogicFacade.widthLimits().get(0);
        } else if (widthInput > LogicFacade.widthLimits().get(1)) {
            widthInput = LogicFacade.widthLimits().get(1);
        }

        int heightInput;
        try {
            heightInput = Integer.parseInt(request.getParameter("heightInput"));
        } catch (Exception e) {
            heightInput = 0;
        }
        if (heightInput < LogicFacade.heightLimits().get(0)) {
            heightInput = LogicFacade.heightLimits().get(0);
        } else if (heightInput > LogicFacade.heightLimits().get(1)) {
            heightInput = LogicFacade.heightLimits().get(1);
        }
        String configMaterial = request.getParameter("configMaterial");

        String roofCheck = request.getParameter("roofCheck");
        int roofInput = 0;
        try {
            if (roofCheck.equals("on")) {
                try {
                    roofInput = Integer.parseInt(request.getParameter("roofInput"));
                } catch (Exception e) {
                }
                if (roofInput < LogicFacade.roofAngleLimits().get(0)) {
                    roofInput = LogicFacade.roofAngleLimits().get(0);
                } else if (roofInput > LogicFacade.roofAngleLimits().get(1)) {
                    roofInput = LogicFacade.roofAngleLimits().get(1);
                }
            }
        } catch (Exception e) {
            //roofCheck is not checked and therefore the requestParameter doesn't exist.
        }
        String roofMaterial = request.getParameter("roofMaterial");

        String name = request.getParameter("surNameInput") + ", " + request.getParameter("foreNameInput");
        String email = request.getParameter("emailInput");
        String phone = request.getParameter("phoneInput");
        String postcode = request.getParameter("postcodeInput");

        try {
            request.setAttribute("configRequestID", LogicFacade.submitConfigRequest(
                    lengthInput, widthInput, heightInput, configMaterial,
                    roofInput, roofMaterial,
                    name, email, phone, postcode));
            request.setAttribute("actionSuccess", true);
        } catch (Exception e) {
            request.setAttribute("error", "Something went wrong!");
            System.out.println(e);
        }
        request.setAttribute("materials", LogicFacade.carportMaterials());
        request.setAttribute("widthLimits", LogicFacade.widthLimits());
        request.setAttribute("lengthLimits", LogicFacade.lengthLimits());
        request.setAttribute("heightLimits", LogicFacade.heightLimits());
        request.setAttribute("roofAngleLimits", LogicFacade.roofAngleLimits());
        request.setAttribute("roofMaterials", LogicFacade.roofMaterials());
        return "configuratorpage";
    }
}
