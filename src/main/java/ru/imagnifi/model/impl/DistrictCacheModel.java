package ru.imagnifi.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.imagnifi.model.District;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing District in entity cache.
 *
 * @author imagnifi
 * @see District
 * @generated
 */
public class DistrictCacheModel implements CacheModel<District>, Externalizable {
    public String uuid;
    public long districtId;
    public String name;
    public int number;
    public boolean status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", districtId=");
        sb.append(districtId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", number=");
        sb.append(number);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public District toEntityModel() {
        DistrictImpl districtImpl = new DistrictImpl();

        if (uuid == null) {
            districtImpl.setUuid(StringPool.BLANK);
        } else {
            districtImpl.setUuid(uuid);
        }

        districtImpl.setDistrictId(districtId);

        if (name == null) {
            districtImpl.setName(StringPool.BLANK);
        } else {
            districtImpl.setName(name);
        }

        districtImpl.setNumber(number);
        districtImpl.setStatus(status);

        districtImpl.resetOriginalValues();

        return districtImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        districtId = objectInput.readLong();
        name = objectInput.readUTF();
        number = objectInput.readInt();
        status = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(districtId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeInt(number);
        objectOutput.writeBoolean(status);
    }
}
