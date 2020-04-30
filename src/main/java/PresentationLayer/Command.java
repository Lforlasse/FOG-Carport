package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("index", new Index());
        commands.put("configurator", new Configurator());
        commands.put("tools", new Tools());
        commands.put("offerRequest", new OfferRequest());
        commands.put("offerRequestsOverview", new OfferRequestsOverview());
        commands.put("viewOfferRequest", new ViewOfferRequest());
        commands.put("calculateNewProfit", new CalculateNewProfit());
    }

    static Command from(HttpServletRequest request) {
        String targetName = request.getParameter("target");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand());   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;

}
