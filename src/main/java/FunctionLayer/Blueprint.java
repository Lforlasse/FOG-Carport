package FunctionLayer;

import java.util.ArrayList;

public class Blueprint {

    private String canvasFront;
    private String canvasBack;
    private String canvasText;
    private String canvasFill;
    private ArrayList<String> stolpe;
    private ArrayList<String> rem;
    private ArrayList<String> sper;
    private ArrayList<String> legte;
    private ArrayList<String> stern;
    private String markerHead;
    private String markerX;
    private String markerY;
    private String blueprintSVG;

    public Blueprint() {

    }//Blueprint

    public String composeSVG() {

        String SVG = "<?xml version=\"1.0\" ?>\n" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                "\n" +
                "<!-- CanvasBack -->" + "\n" +
                canvasBack + "\n\n" +
                "<!-- MarkerHead -->" + "\n" +
                markerHead + "\n\n" +
                "<!-- MarkerX -->" + "\n" +
                markerX + "\n\n" +
                "<!-- MarkerY -->" + "\n" +
                markerY + "\n\n" +
                "<!-- CanvasText -->" + "\n" +
                canvasText + "\n\n" +
                "<!-- CanvasFront -->" + "\n" +
                canvasFront + "\n\n" +
                "<!-- CanvasFill -->" + "\n" +
                canvasFill + "\n\n" +
                "<!-- Stolpe -->" + "\n" +
                composeStolpe() + "\n" +
                "<!-- Rem -->" + "\n" +
                composeRem() + "\n" +
                "<!-- Sper -->" + "\n" +
                composeSper() + "\n" +
                "<!-- Stern -->" + "\n" +
                 composeStern() + "\n" +
                "<!-- Legte -->" + "\n" +
                composeLegte() + "\n" +
                "    </svg>\n" +
                "</svg>";

        return SVG;

    }

        private String composeRem(){

            String collector = "";

            for (int i = 0; i < rem.size(); i++) {
                collector += rem.get(i) + "\n";
            }
            return collector;

        }//

        private String composeStolpe (){

            String collector = "";

            for (int i = 0; i < stolpe.size(); i++) {
                collector += stolpe.get(i) + "\n";
            }
            return collector;
        }

        private String composeSper (){

            String collector = "";

            for (int i = 0; i < sper.size(); i++) {
                collector += sper.get(i) + "\n";
            }
            return collector;
        }

        private String composeStern (){

            String collector = "";

            for (int i = 0; i < stern.size(); i++) {
                collector += stern.get(i) + "\n";
            }
            return collector;
        }

        private String composeLegte(){

            String collector = "";
            for (int i = 0; i < legte.size(); i++){
                collector += legte.get(i) + "\n";
            }
            return collector;
        }


    //GETTER & SETTER
    public String getCanvasFront() {
        return canvasFront;
    }

    public void setCanvasFront(String canvasFront) {
        this.canvasFront = canvasFront;
    }

    public String getCanvasBack() {
        return canvasBack;
    }

    public void setCanvasBack(String canvasBack) {
        this.canvasBack = canvasBack;
    }

    public String getCanvasFill() {
        return canvasFill;
    }

    public void setCanvasFill(String canvasFill) {
        this.canvasFill = canvasFill;
    }

    public String getCanvasText() {
        return canvasText;
    }

    public void setCanvasText(String canvasText) {
        this.canvasText = canvasText;
    }

    public ArrayList<String> getStolpe() {
        return stolpe;
    }

    public void setStolpe(ArrayList<String> stolpe) {
        this.stolpe = stolpe;
    }

    public ArrayList<String> getRem() {
        return rem;
    }

    public void setRem(ArrayList<String> rem) {
        this.rem = rem;
    }

    public ArrayList<String> getSper() {
        return sper;
    }

    public void setSper(ArrayList<String> sper) {
        this.sper = sper;
    }

    public ArrayList<String> getLegte() {
        return legte;
    }

    public void setLegte(ArrayList<String> legte) {
        this.legte = legte;
    }

    public ArrayList<String> getStern() {
        return stern;
    }

    public void setStern(ArrayList<String> stern) {
        this.stern = stern;
    }

    public String getMarkerHead() {
        return markerHead;
    }

    public void setMarkerHead(String markerHead) {
        this.markerHead = markerHead;
    }

    public String getMarkerX() {
        return markerX;
    }

    public void setMarkerX(String markerX) {
        this.markerX = markerX;
    }

    public String getMarkerY() {
        return markerY;
    }

    public void setMarkerY(String markerY) {
        this.markerY = markerY;
    }

    public String getBlueprintSVG() {
        return blueprintSVG;
    }

    public void setBlueprintSVG(String blueprintSVG) {
        this.blueprintSVG = blueprintSVG;
    }
}//class
