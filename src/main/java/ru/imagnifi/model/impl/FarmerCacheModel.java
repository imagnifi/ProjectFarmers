package ru.imagnifi.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.imagnifi.model.Farmer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Farmer in entity cache.
 *
 * @author imagnifi
 * @see Farmer
 * @generated
 */
public class FarmerCacheModel implements CacheModel<Farmer>, Externalizable {
    public long farmerId;
    public String organization;
    public String orgForm;
    public long inn;
    public long kpp;
    public long ogrn;
    public long districtNumber;
    public long registrationDate;
    public boolean archiveStatus;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{farmerId=");
        sb.append(farmerId);
        sb.append(", organization=");
        sb.append(organization);
        sb.append(", orgForm=");
        sb.append(orgForm);
        sb.append(", inn=");
        sb.append(inn);
        sb.append(", kpp=");
        sb.append(kpp);
        sb.append(", ogrn=");
        sb.append(ogrn);
        sb.append(", districtNumber=");
        sb.append(districtNumber);
        sb.append(", registrationDate=");
        sb.append(registrationDate);
        sb.append(", archiveStatus=");
        sb.append(archiveStatus);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Farmer toEntityModel() {
        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setFarmerId(farmerId);

        if (organization == null) {
            farmerImpl.setOrganization(StringPool.BLANK);
        } else {
            farmerImpl.setOrganization(organization);
        }

        if (orgForm == null) {
            farmerImpl.setOrgForm(StringPool.BLANK);
        } else {
            farmerImpl.setOrgForm(orgForm);
        }

        farmerImpl.setInn(inn);
        farmerImpl.setKpp(kpp);
        farmerImpl.setOgrn(ogrn);
        farmerImpl.setDistrictNumber(districtNumber);

        if (registrationDate == Long.MIN_VALUE) {
            farmerImpl.setRegistrationDate(null);
        } else {
            farmerImpl.setRegistrationDate(new Date(registrationDate));
        }

        farmerImpl.setArchiveStatus(archiveStatus);

        farmerImpl.resetOriginalValues();

        return farmerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        farmerId = objectInput.readLong();
        organization = objectInput.readUTF();
        orgForm = objectInput.readUTF();
        inn = objectInput.readLong();
        kpp = objectInput.readLong();
        ogrn = objectInput.readLong();
        districtNumber = objectInput.readLong();
        registrationDate = objectInput.readLong();
        archiveStatus = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(farmerId);

        if (organization == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(organization);
        }

        if (orgForm == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(orgForm);
        }

        objectOutput.writeLong(inn);
        objectOutput.writeLong(kpp);
        objectOutput.writeLong(ogrn);
        objectOutput.writeLong(districtNumber);
        objectOutput.writeLong(registrationDate);
        objectOutput.writeBoolean(archiveStatus);
    }
}
