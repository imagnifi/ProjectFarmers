package ru.imagnifi.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author imagnifi
 * @generated
 */
public class DistrictSoap implements Serializable {
    private String _uuid;
    private long _districtId;
    private String _name;
    private int _number;
    private boolean _status;

    public DistrictSoap() {
    }

    public static DistrictSoap toSoapModel(District model) {
        DistrictSoap soapModel = new DistrictSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setDistrictId(model.getDistrictId());
        soapModel.setName(model.getName());
        soapModel.setNumber(model.getNumber());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static DistrictSoap[] toSoapModels(District[] models) {
        DistrictSoap[] soapModels = new DistrictSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DistrictSoap[][] toSoapModels(District[][] models) {
        DistrictSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DistrictSoap[models.length][models[0].length];
        } else {
            soapModels = new DistrictSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DistrictSoap[] toSoapModels(List<District> models) {
        List<DistrictSoap> soapModels = new ArrayList<DistrictSoap>(models.size());

        for (District model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DistrictSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _districtId;
    }

    public void setPrimaryKey(long pk) {
        setDistrictId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getDistrictId() {
        return _districtId;
    }

    public void setDistrictId(long districtId) {
        _districtId = districtId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getNumber() {
        return _number;
    }

    public void setNumber(int number) {
        _number = number;
    }

    public boolean getStatus() {
        return _status;
    }

    public boolean isStatus() {
        return _status;
    }

    public void setStatus(boolean status) {
        _status = status;
    }
}
