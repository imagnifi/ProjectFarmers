package ru.imagnifi.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Farmer}.
 * </p>
 *
 * @author imagnifi
 * @see Farmer
 * @generated
 */
public class FarmerWrapper implements Farmer, ModelWrapper<Farmer> {
    private Farmer _farmer;

    public FarmerWrapper(Farmer farmer) {
        _farmer = farmer;
    }

    @Override
    public Class<?> getModelClass() {
        return Farmer.class;
    }

    @Override
    public String getModelClassName() {
        return Farmer.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("farmerId", getFarmerId());
        attributes.put("organization", getOrganization());
        attributes.put("orgForm", getOrgForm());
        attributes.put("inn", getInn());
        attributes.put("kpp", getKpp());
        attributes.put("ogrn", getOgrn());
        attributes.put("districtNumber", getDistrictNumber());
        attributes.put("registrationDate", getRegistrationDate());
        attributes.put("archiveStatus", getArchiveStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long farmerId = (Long) attributes.get("farmerId");

        if (farmerId != null) {
            setFarmerId(farmerId);
        }

        String organization = (String) attributes.get("organization");

        if (organization != null) {
            setOrganization(organization);
        }

        String orgForm = (String) attributes.get("orgForm");

        if (orgForm != null) {
            setOrgForm(orgForm);
        }

        Long inn = (Long) attributes.get("inn");

        if (inn != null) {
            setInn(inn);
        }

        Long kpp = (Long) attributes.get("kpp");

        if (kpp != null) {
            setKpp(kpp);
        }

        Long ogrn = (Long) attributes.get("ogrn");

        if (ogrn != null) {
            setOgrn(ogrn);
        }

        Long districtNumber = (Long) attributes.get("districtNumber");

        if (districtNumber != null) {
            setDistrictNumber(districtNumber);
        }

        Date registrationDate = (Date) attributes.get("registrationDate");

        if (registrationDate != null) {
            setRegistrationDate(registrationDate);
        }

        Boolean archiveStatus = (Boolean) attributes.get("archiveStatus");

        if (archiveStatus != null) {
            setArchiveStatus(archiveStatus);
        }
    }

    /**
    * Returns the primary key of this farmer.
    *
    * @return the primary key of this farmer
    */
    @Override
    public long getPrimaryKey() {
        return _farmer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this farmer.
    *
    * @param primaryKey the primary key of this farmer
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _farmer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the farmer ID of this farmer.
    *
    * @return the farmer ID of this farmer
    */
    @Override
    public long getFarmerId() {
        return _farmer.getFarmerId();
    }

    /**
    * Sets the farmer ID of this farmer.
    *
    * @param farmerId the farmer ID of this farmer
    */
    @Override
    public void setFarmerId(long farmerId) {
        _farmer.setFarmerId(farmerId);
    }

    /**
    * Returns the organization of this farmer.
    *
    * @return the organization of this farmer
    */
    @Override
    public java.lang.String getOrganization() {
        return _farmer.getOrganization();
    }

    /**
    * Sets the organization of this farmer.
    *
    * @param organization the organization of this farmer
    */
    @Override
    public void setOrganization(java.lang.String organization) {
        _farmer.setOrganization(organization);
    }

    /**
    * Returns the org form of this farmer.
    *
    * @return the org form of this farmer
    */
    @Override
    public java.lang.String getOrgForm() {
        return _farmer.getOrgForm();
    }

    /**
    * Sets the org form of this farmer.
    *
    * @param orgForm the org form of this farmer
    */
    @Override
    public void setOrgForm(java.lang.String orgForm) {
        _farmer.setOrgForm(orgForm);
    }

    /**
    * Returns the inn of this farmer.
    *
    * @return the inn of this farmer
    */
    @Override
    public long getInn() {
        return _farmer.getInn();
    }

    /**
    * Sets the inn of this farmer.
    *
    * @param inn the inn of this farmer
    */
    @Override
    public void setInn(long inn) {
        _farmer.setInn(inn);
    }

    /**
    * Returns the kpp of this farmer.
    *
    * @return the kpp of this farmer
    */
    @Override
    public long getKpp() {
        return _farmer.getKpp();
    }

    /**
    * Sets the kpp of this farmer.
    *
    * @param kpp the kpp of this farmer
    */
    @Override
    public void setKpp(long kpp) {
        _farmer.setKpp(kpp);
    }

    /**
    * Returns the ogrn of this farmer.
    *
    * @return the ogrn of this farmer
    */
    @Override
    public long getOgrn() {
        return _farmer.getOgrn();
    }

    /**
    * Sets the ogrn of this farmer.
    *
    * @param ogrn the ogrn of this farmer
    */
    @Override
    public void setOgrn(long ogrn) {
        _farmer.setOgrn(ogrn);
    }

    /**
    * Returns the district number of this farmer.
    *
    * @return the district number of this farmer
    */
    @Override
    public long getDistrictNumber() {
        return _farmer.getDistrictNumber();
    }

    /**
    * Sets the district number of this farmer.
    *
    * @param districtNumber the district number of this farmer
    */
    @Override
    public void setDistrictNumber(long districtNumber) {
        _farmer.setDistrictNumber(districtNumber);
    }

    /**
    * Returns the registration date of this farmer.
    *
    * @return the registration date of this farmer
    */
    @Override
    public java.util.Date getRegistrationDate() {
        return _farmer.getRegistrationDate();
    }

    /**
    * Sets the registration date of this farmer.
    *
    * @param registrationDate the registration date of this farmer
    */
    @Override
    public void setRegistrationDate(java.util.Date registrationDate) {
        _farmer.setRegistrationDate(registrationDate);
    }

    /**
    * Returns the archive status of this farmer.
    *
    * @return the archive status of this farmer
    */
    @Override
    public boolean getArchiveStatus() {
        return _farmer.getArchiveStatus();
    }

    /**
    * Returns <code>true</code> if this farmer is archive status.
    *
    * @return <code>true</code> if this farmer is archive status; <code>false</code> otherwise
    */
    @Override
    public boolean isArchiveStatus() {
        return _farmer.isArchiveStatus();
    }

    /**
    * Sets whether this farmer is archive status.
    *
    * @param archiveStatus the archive status of this farmer
    */
    @Override
    public void setArchiveStatus(boolean archiveStatus) {
        _farmer.setArchiveStatus(archiveStatus);
    }

    @Override
    public boolean isNew() {
        return _farmer.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _farmer.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _farmer.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _farmer.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _farmer.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _farmer.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _farmer.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _farmer.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _farmer.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _farmer.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _farmer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FarmerWrapper((Farmer) _farmer.clone());
    }

    @Override
    public int compareTo(ru.imagnifi.model.Farmer farmer) {
        return _farmer.compareTo(farmer);
    }

    @Override
    public int hashCode() {
        return _farmer.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.imagnifi.model.Farmer> toCacheModel() {
        return _farmer.toCacheModel();
    }

    @Override
    public ru.imagnifi.model.Farmer toEscapedModel() {
        return new FarmerWrapper(_farmer.toEscapedModel());
    }

    @Override
    public ru.imagnifi.model.Farmer toUnescapedModel() {
        return new FarmerWrapper(_farmer.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _farmer.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _farmer.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmer.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerWrapper)) {
            return false;
        }

        FarmerWrapper farmerWrapper = (FarmerWrapper) obj;

        if (Validator.equals(_farmer, farmerWrapper._farmer)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Farmer getWrappedFarmer() {
        return _farmer;
    }

    @Override
    public Farmer getWrappedModel() {
        return _farmer;
    }

    @Override
    public void resetOriginalValues() {
        _farmer.resetOriginalValues();
    }
}
