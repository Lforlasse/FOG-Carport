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
                "<!-- CanvasBack -->" + "\n" +
                blueprint.getCanvasBack() + "\n\n" +
                "<!-- MarkerHead -->" + "\n" +
                blueprint.getMarkerHead() + "\n\n" +
                "<!-- MarkerX -->" + "\n" +
                blueprint.getMarkerX() + "\n\n" +
                "<!-- MarkerY -->" + "\n" +
                blueprint.getMarkerY() + "\n\n" +
                "<!-- CanvasText -->" + "\n" +
                blueprint.getCanvasText() + "\n\n" +
                "<!-- CanvasFront -->" + "\n" +
                blueprint.getCanvasFront() + "\n\n" +
                "<!-- CanvasFill -->" + "\n" +
                blueprint.getCanvasFill() + "\n\n" +
                "<!-- Rem -->" + "\n" +
                composeRem(blueprint) + "\n" +
                "<!-- Stolpe -->" + "\n" +
                composeStolpe(blueprint) + "\n" +
                "<!-- Sper -->" + "\n" +
                composeSper(blueprint) + "\n" +
                "<!-- Stern -->" + "\n" +
                composeStern(blueprint) + "\n" +
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
