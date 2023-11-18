package ru.imagnifi.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author imagnifi
 * @generated
 */
public class FarmerSoap implements Serializable {
    private long _farmerId;
    private String _organization;
    private String _orgForm;
    private long _inn;
    private long _kpp;
    private long _ogrn;
    private long _districtNumber;
    private Date _registrationDate;
    private boolean _archiveStatus;

    public FarmerSoap() {
    }

    public static FarmerSoap toSoapModel(Farmer model) {
        FarmerSoap soapModel = new FarmerSoap();

        soapModel.setFarmerId(model.getFarmerId());
        soapModel.setOrganization(model.getOrganization());
        soapModel.setOrgForm(model.getOrgForm());
        soapModel.setInn(model.getInn());
        soapModel.setKpp(model.getKpp());
        soapModel.setOgrn(model.getOgrn());
        soapModel.setDistrictNumber(model.getDistrictNumber());
        soapModel.setRegistrationDate(model.getRegistrationDate());
        soapModel.setArchiveStatus(model.getArchiveStatus());

        return soapModel;
    }

    public static FarmerSoap[] toSoapModels(Farmer[] models) {
        FarmerSoap[] soapModels = new FarmerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FarmerSoap[][] toSoapModels(Farmer[][] models) {
        FarmerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FarmerSoap[models.length][models[0].length];
        } else {
            soapModels = new FarmerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FarmerSoap[] toSoapModels(List<Farmer> models) {
        List<FarmerSoap> soapModels = new ArrayList<FarmerSoap>(models.size());

        for (Farmer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FarmerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _farmerId;
    }

    public void setPrimaryKey(long pk) {
        setFarmerId(pk);
    }

    public long getFarmerId() {
        return _farmerId;
    }

    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;
    }

    public String getOrganization() {
        return _organization;
    }

    public void setOrganization(String organization) {
        _organization = organization;
    }

    public String getOrgForm() {
        return _orgForm;
    }

    public void setOrgForm(String orgForm) {
        _orgForm = orgForm;
    }

    public long getInn() {
        return _inn;
    }

    public void setInn(long inn) {
        _inn = inn;
    }

    public long getKpp() {
        return _kpp;
    }

    public void setKpp(long kpp) {
        _kpp = kpp;
    }

    public long getOgrn() {
        return _ogrn;
    }

    public void setOgrn(long ogrn) {
        _ogrn = ogrn;
    }

    public long getDistrictNumber() {
        return _districtNumber;
    }

    public void setDistrictNumber(long districtNumber) {
        _districtNumber = districtNumber;
    }

    public Date getRegistrationDate() {
        return _registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        _registrationDate = registrationDate;
    }

    public boolean getArchiveStatus() {
        return _archiveStatus;
    }

    public boolean isArchiveStatus() {
        return _archiveStatus;
    }

    public void setArchiveStatus(boolean archiveStatus) {
        _archiveStatus = archiveStatus;
    }
}
