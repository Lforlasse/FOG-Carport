package FunctionLayer;

public class BlueprintComposer {

    String blueprintSVG;

    public BlueprintComposer(Blueprint blueprint) {
        setBlueprintSVG(composer(blueprint));
    }

    private String composer(Blueprint blueprint) {
        String SVG = "<?xml version=\"1.0\" ?>\n" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                "\n" +
                blueprint.getCanvasBack() + "\n" +
                blueprint.getMarkerHead() + "\n" +
                blueprint.getMarkerX() + "\n" +
                blueprint.getMarkerY() + "\n" +
                blueprint.getCanvasFront() + "\n" +
                blueprint.getCanvasText() + "\n" +
                composeRem(blueprint) + "\n\n" +
                composeStolpe(blueprint) + "\n\n" +
                composeSper(blueprint) + "\n\n" +
                composeStern(blueprint) + "\n\n" +
                "    </svg>\n" +
                "</svg>";

        return SVG;
    }

    private String composeRem(Blueprint blueprint) {

        String collector = "";

        for (int i = 0; i < blueprint.getRem().size(); i++) {
            collector += blueprint.getRem().get(i) + "\n";
        }
        return collector;

    }

    private String composeStolpe(Blueprint blueprint) {

        String collector = "";

        for (int i = 0; i < blueprint.getStolpe().size(); i++) {
            collector += blueprint.getStolpe().get(i) + "\n";
        }
        return collector;
    }

    private String composeSper(Blueprint blueprint) {

        String collector = "";

        for (int i = 0; i < blueprint.getSper().size(); i++) {
            collector += blueprint.getSper().get(i) + "\n";
        }
        return collector;
    }

    private String composeStern(Blueprint blueprint) {

        String collector = "";

        for (int i = 0; i < blueprint.getSper().size(); i++) {
            collector += blueprint.getSper().get(i) + "\n";
        }
        return collector;
    }

    //GETTER & SETTER
    public String getBlueprintSVG() {
        return blueprintSVG;
    }

    public void setBlueprintSVG(String blueprintSVG) {
        this.blueprintSVG = blueprintSVG;
    }
}
