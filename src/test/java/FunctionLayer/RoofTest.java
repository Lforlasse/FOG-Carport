package FunctionLayer;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoofTest {


    @Test
    public void TestcalcSideC() {
        int inclination = 18;
        int width = 360;

        double dWidth = width/2;
        double dInclination = 90-inclination;
        double dCornerC = Math.toRadians(90);
        dCornerC = Math.sin(dCornerC);

        dInclination = Math.toRadians(dInclination);
        dInclination = Math.sin(dInclination);

        dWidth /= dInclination * dCornerC;

        int res = toIntHelper(dWidth);

        assertEquals(189,res);
    }//TestcalcSideC

    //test af minimum inclination
    @Test
    public void TestMincalcSideC() {
        int inclination = 10;
        int width = 360;

        double dWidth = width/2;
        double dInclination = 90-inclination;
        double dCornerC = Math.toRadians(90);
        dCornerC = Math.sin(dCornerC);

        dInclination = Math.toRadians(dInclination);
        dInclination = Math.sin(dInclination);

        dWidth /= dInclination * dCornerC;

        int res = toIntHelper(dWidth);

        assertEquals(183,res);
    }//TestMincalcSideC

    //test af maksimum inclination
    @Test
    public void TestMaxcalcSideC() {
        int inclination = 20;
        int width = 360;

        double dWidth = width/2;
        double dInclination = 90-inclination;
        double dCornerC = Math.toRadians(90);
        dCornerC = Math.sin(dCornerC);

        dInclination = Math.toRadians(dInclination);
        dInclination = Math.sin(dInclination);

        dWidth /= dInclination * dCornerC;

        int res = toIntHelper(dWidth);

        assertEquals(192,res);
    }//TestMincalcSideC

    @Test
    public void TestcalcRoofHeight() {
        int sideA = 360;
        int sideC = 189;

        double dSideA = sideA/2;
        double dSideC = sideC;

        dSideA = Math.pow(dSideA,2);
        dSideC = Math.pow(dSideC,2);
        dSideC -= dSideA;
        double dSideB = Math.sqrt(dSideC);

        int res = toIntHelper(dSideB);
        assertEquals(58,res);
    }//TestcalcRoofHeight

    //test af minimum sideC
    @Test
    public void TestMincalcRoofHeight() {
        int sideA = 360;
        int sideC = 183;

        double dSideA = sideA/2;
        double dSideC = sideC;

        dSideA = Math.pow(dSideA,2);
        dSideC = Math.pow(dSideC,2);
        dSideC -= dSideA;
        double dSideB = Math.sqrt(dSideC);

        int res = toIntHelper(dSideB);
        assertEquals(33,res);
    }//TestMincalcRoofHeight

    //test af maksimal sideC
    @Test
    public void TestMaxcalcRoofHeight() {
        int sideA = 360;
        int sideC = 192;

        double dSideA = sideA/2;
        double dSideC = sideC;

        dSideA = Math.pow(dSideA,2);
        dSideC = Math.pow(dSideC,2);
        dSideC -= dSideA;
        double dSideB = Math.sqrt(dSideC);

        int res = toIntHelper(dSideB);
        assertEquals(67,res);
    }//TestMaxcalcRoofHeight

    public int toIntHelper(double d){

        d = Math.round(d);
        String s = ""+d;
        s = s.substring(0,s.length()-2);
        int i = Integer.parseInt(s);

        return i;
    }//TesttoIntHelper

    //test med nedrunding
    @Test
    public void TestDowntoInt(){
        double d = 5.4555; //testnumber
        d = Math.round(d);
        String s = ""+d;
        s = s.substring(0,s.length()-2);
        int i = Integer.parseInt(s);
        assertEquals(5,i);
    }//TesttoInt

    //test med oprunding
    @Test
    public void TestUptoInt(){
        double d = 5.6555; //testnumber
        d = Math.round(d);
        String s = ""+d;
        s = s.substring(0,s.length()-2);
        int i = Integer.parseInt(s);
        assertEquals(6,i);
    }//TesttoInt

}
