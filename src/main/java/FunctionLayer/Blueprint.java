package FunctionLayer;

import java.util.ArrayList;

public class Blueprint {

    private String canvasFront;
    private String canvasBack;
    private ArrayList<String> Stolpe;
    private String Rem;
    private String Sper;
    private String Legte;
    private String Stern;
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

    public String getRem() {
        return Rem;
    }

    public void setRem(String rem) {
        Rem = rem;
    }

    public String getSper() {
        return Sper;
    }

    public void setSper(String sper) {
        Sper = sper;
    }

    public String getLegte() {
        return Legte;
    }

    public void setLegte(String legte) {
        Legte = legte;
    }

    public String getStern() {
        return Stern;
    }

    public void setStern(String stern) {
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
