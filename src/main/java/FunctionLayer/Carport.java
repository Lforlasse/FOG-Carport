package FunctionLayer;

import DBAccess.ConfigurationMapper;

import java.util.Date;

public class Carport {
    private int confId;
    private String custName;
    private int custPhone;
    private String custEmail;
    private int custPostal;
    private int confLength;
    private int confWidth;
    private int confHeight;
    private String confMat;
    private Roof roof;
    private boolean carSpace;
    private String confStatus;
    private final Date CREATED_DATE;
    private Date changedDate;

    public Carport(int confId, String custName, int custPhone, String custEmail, int custPostal,
                   int confLength, int confWidth, int confHeight, String confMat, int inclination, String roofMaterial) {
        this.confId = confId;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
        this.custPostal = custPostal;
        this.confLength = confLength;
        this.confWidth = confWidth;
        this.confHeight = confHeight;
        this.confMat = confMat;
        this.roof = new Roof(inclination, roofMaterial, confWidth);
        this.carSpace = checkCarSpace();

        this.confStatus = ConfigurationMapper.getConfigStatus(confId);
        this.CREATED_DATE = ConfigurationMapper.getCreatedDate(confId);
        this.changedDate = ConfigurationMapper.getChangedDate(confId);

    }//Carport

    private boolean checkCarSpace() {
        boolean result = true;

        if (this.confLength < 1) { //Hent tal fra DB
            result = false;
        }
        if (this.confWidth < 1) { //Hent tal fra DB
            result = false;
        }
        if (this.confHeight < 1) { //Hent tal fra DB
            result = false;
        }
        return result;
    }//checkCarSpace

    //Getter & Setter
    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(int custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public int getCustPostal() {
        return custPostal;
    }

    public void setCustPostal(int custPostal) {
        this.custPostal = custPostal;
    }

    public int getConfLength() {
        return confLength;
    }

    public void setConfLength(int confLength) {
        this.confLength = confLength;
    }

    public int getConfWidth() {
        return confWidth;
    }

    public void setConfWidth(int confWidth) {
        this.confWidth = confWidth;
    }

    public int getConfHeight() {
        return confHeight;
    }

    public void setConfHeight(int confHeight) {
        this.confHeight = confHeight;
    }

    public String getConfMat() {
        return confMat;
    }

    public void setConfMat(String confMat) {
        this.confMat = confMat;
    }

    public Roof getRoof() {
        return roof;
    }

    public boolean isCarSpace() {
        return carSpace;
    }

    public void setCarSpace(boolean carSpace) {
        this.carSpace = carSpace;
    }

    public String getConfStatus() {
        return confStatus;
    }

    public boolean setConfStatus(String confStatus) {
        if (ConfigurationMapper.setConfigStatus(this.confId, confStatus)) {
            this.confStatus = confStatus;
            return true;
        }
        return false;
    }

    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        if (ConfigurationMapper.setChangedDate(confId, changedDate)) {
            this.changedDate = changedDate;
        }
    }
}//class