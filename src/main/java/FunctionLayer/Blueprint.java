package FunctionLayer;

import java.util.ArrayList;

public class Blueprint {

    private String canvasFront;
    private String canvasBack;
    private ArrayList<String> Stolpe;
    private ArrayList<String> Rem;
    private ArrayList<String> Sper;
    private ArrayList<String> Legte;
    private ArrayList<String> Stern;
    private String MarkerX;
    private String MarkerY;

    public Blueprint() {
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

    public ArrayList<String> getStolpe() {
        return Stolpe;
    }

    public void setStolpe(ArrayList<String> stolpe) {
        Stolpe = stolpe;
    }

    public ArrayList<String> getRem() {
        return Rem;
    }

    public void setRem(ArrayList<String> rem) {
        Rem = rem;
    }

    public ArrayList<String> getSper() {
        return Sper;
    }

    public void setSper(ArrayList<String> sper) {
        Sper = sper;
    }

    public ArrayList<String> getLegte() {
        return Legte;
    }

    public void setLegte(ArrayList<String> legte) {
        Legte = legte;
    }

    public ArrayList<String> getStern() {
        return Stern;
    }

    public void setStern(ArrayList<String> stern) {
        Stern = stern;
    }

    public String getMarkerX() {
        return MarkerX;
    }

    public void setMarkerX(String markerX) {
        MarkerX = markerX;
    }

    public String getMarkerY() {
        return MarkerY;
    }

    public void setMarkerY(String markerY) {
        MarkerY = markerY;
    }
}
