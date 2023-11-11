package ru.imagnifi.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.imagnifi.NoSuchDistrictException;

import ru.imagnifi.model.District;
import ru.imagnifi.model.impl.DistrictImpl;
import ru.imagnifi.model.impl.DistrictModelImpl;

import ru.imagnifi.service.persistence.DistrictPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author imagnifi
 * @see DistrictPersistence
 * @see DistrictUtil
 * @generated
 */
public class DistrictPersistenceImpl extends BasePersistenceImpl<District>
    implements DistrictPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DistrictUtil} to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DistrictImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            DistrictModelImpl.UUID_COLUMN_BITMASK |
            DistrictModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "district.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "district.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(district.uuid IS NULL OR district.uuid = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
            new String[] { String.class.getName() },
            DistrictModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "district.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "district.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(district.name IS NULL OR district.name = '')";
    private static final String _SQL_SELECT_DISTRICT = "SELECT district FROM District district";
    private static final String _SQL_SELECT_DISTRICT_WHERE = "SELECT district FROM District district WHERE ";
    private static final String _SQL_COUNT_DISTRICT = "SELECT COUNT(district) FROM District district";
    private static final String _SQL_COUNT_DISTRICT_WHERE = "SELECT COUNT(district) FROM District district WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "district.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No District exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No District exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DistrictPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "number"
            });
    private static District _nullDistrict = new DistrictImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<District> toCacheModel() {
                return _nullDistrictCacheModel;
            }
        };

    private static CacheModel<District> _nullDistrictCacheModel = new CacheModel<District>() {
            @Override
            public District toEntityModel() {
                return _nullDistrict;
            }
        };

    public DistrictPersistenceImpl() {
        setModelClass(District.class);
    }

    /**
     * Returns all the districts where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the districts where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @return the range of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the districts where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<District> list = (List<District>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (District district : list) {
                if (!Validator.equals(uuid, district.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_DISTRICT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DistrictModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<District>(list);
                } else {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first district in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching district
     * @throws ru.imagnifi.NoSuchDistrictException if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByUuid_First(uuid, orderByComparator);

        if (district != null) {
            return district;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDistrictException(msg.toString());
    }

    /**
     * Returns the first district in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching district, or <code>null</code> if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<District> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last district in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching district
     * @throws ru.imagnifi.NoSuchDistrictException if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByUuid_Last(uuid, orderByComparator);

        if (district != null) {
            return district;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDistrictException(msg.toString());
    }

    /**
     * Returns the last district in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching district, or <code>null</code> if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<District> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the districts before and after the current district in the ordered set where uuid = &#63;.
     *
     * @param districtId the primary key of the current district
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next district
     * @throws ru.imagnifi.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District[] findByUuid_PrevAndNext(long districtId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        Session session = null;

        try {
            session = openSession();

            District[] array = new DistrictImpl[3];

            array[0] = getByUuid_PrevAndNext(session, district, uuid,
                    orderByComparator, true);

            array[1] = district;

            array[2] = getByUuid_PrevAndNext(session, district, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected District getByUuid_PrevAndNext(Session session,
        District district, String uuid, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DISTRICT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(DistrictModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(district);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<District> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the districts where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (District district : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(district);
        }
    }

    /**
     * Returns the number of districts where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DISTRICT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the districts where name = &#63;.
     *
     * @param name the name
     * @return the matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByName(String name) throws SystemException {
        return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the districts where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @return the range of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
    }

    /**
     * Returns an ordered range of all the districts where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findByName(String name, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name, start, end, orderByComparator };
        }

        List<District> list = (List<District>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (District district : list) {
                if (!Validator.equals(name, district.getName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_DISTRICT_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DistrictModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                if (!pagination) {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<District>(list);
                } else {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first district in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching district
     * @throws ru.imagnifi.NoSuchDistrictException if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByName_First(String name,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByName_First(name, orderByComparator);

        if (district != null) {
            return district;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDistrictException(msg.toString());
    }

    /**
     * Returns the first district in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching district, or <code>null</code> if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByName_First(String name,
        OrderByComparator orderByComparator) throws SystemException {
        List<District> list = findByName(name, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last district in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching district
     * @throws ru.imagnifi.NoSuchDistrictException if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByName_Last(String name,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByName_Last(name, orderByComparator);

        if (district != null) {
            return district;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDistrictException(msg.toString());
    }

    /**
     * Returns the last district in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching district, or <code>null</code> if a matching district could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByName_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(name);

        if (count == 0) {
            return null;
        }

        List<District> list = findByName(name, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the districts before and after the current district in the ordered set where name = &#63;.
     *
     * @param districtId the primary key of the current district
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next district
     * @throws ru.imagnifi.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District[] findByName_PrevAndNext(long districtId, String name,
        OrderByComparator orderByComparator)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        Session session = null;

        try {
            session = openSession();

            District[] array = new DistrictImpl[3];

            array[0] = getByName_PrevAndNext(session, district, name,
                    orderByComparator, true);

            array[1] = district;

            array[2] = getByName_PrevAndNext(session, district, name,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected District getByName_PrevAndNext(Session session,
        District district, String name, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DISTRICT_WHERE);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_NAME_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_NAME_3);
        } else {
            bindName = true;

            query.append(_FINDER_COLUMN_NAME_NAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(DistrictModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindName) {
            qPos.add(name);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(district);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<District> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the districts where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByName(String name) throws SystemException {
        for (District district : findByName(name, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(district);
        }
    }

    /**
     * Returns the number of districts where name = &#63;.
     *
     * @param name the name
     * @return the number of matching districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DISTRICT_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the district in the entity cache if it is enabled.
     *
     * @param district the district
     */
    @Override
    public void cacheResult(District district) {
        EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictImpl.class, district.getPrimaryKey(), district);

        district.resetOriginalValues();
    }

    /**
     * Caches the districts in the entity cache if it is enabled.
     *
     * @param districts the districts
     */
    @Override
    public void cacheResult(List<District> districts) {
        for (District district : districts) {
            if (EntityCacheUtil.getResult(
                        DistrictModelImpl.ENTITY_CACHE_ENABLED,
                        DistrictImpl.class, district.getPrimaryKey()) == null) {
                cacheResult(district);
            } else {
                district.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all districts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DistrictImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DistrictImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the district.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(District district) {
        EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictImpl.class, district.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<District> districts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (District district : districts) {
            EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                DistrictImpl.class, district.getPrimaryKey());
        }
    }

    /**
     * Creates a new district with the primary key. Does not add the district to the database.
     *
     * @param districtId the primary key for the new district
     * @return the new district
     */
    @Override
    public District create(long districtId) {
        District district = new DistrictImpl();

        district.setNew(true);
        district.setPrimaryKey(districtId);

        String uuid = PortalUUIDUtil.generate();

        district.setUuid(uuid);

        return district;
    }

    /**
     * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param districtId the primary key of the district
     * @return the district that was removed
     * @throws ru.imagnifi.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District remove(long districtId)
        throws NoSuchDistrictException, SystemException {
        return remove((Serializable) districtId);
    }

    /**
     * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the district
     * @return the district that was removed
     * @throws ru.imagnifi.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District remove(Serializable primaryKey)
        throws NoSuchDistrictException, SystemException {
        Session session = null;

        try {
            session = openSession();

            District district = (District) session.get(DistrictImpl.class,
                    primaryKey);

            if (district == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDistrictException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(district);
        } catch (NoSuchDistrictException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected District removeImpl(District district) throws SystemException {
        district = toUnwrappedModel(district);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(district)) {
                district = (District) session.get(DistrictImpl.class,
                        district.getPrimaryKeyObj());
            }

            if (district != null) {
                session.delete(district);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (district != null) {
            clearCache(district);
        }

        return district;
    }

    @Override
    public District updateImpl(ru.imagnifi.model.District district)
        throws SystemException {
        district = toUnwrappedModel(district);

        boolean isNew = district.isNew();

        DistrictModelImpl districtModelImpl = (DistrictModelImpl) district;

        if (Validator.isNull(district.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            district.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (district.isNew()) {
                session.save(district);

                district.setNew(false);
            } else {
                session.merge(district);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DistrictModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((districtModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { districtModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { districtModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((districtModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { districtModelImpl.getOriginalName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { districtModelImpl.getName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
            DistrictImpl.class, district.getPrimaryKey(), district);

        return district;
    }

    protected District toUnwrappedModel(District district) {
        if (district instanceof DistrictImpl) {
            return district;
        }

        DistrictImpl districtImpl = new DistrictImpl();

        districtImpl.setNew(district.isNew());
        districtImpl.setPrimaryKey(district.getPrimaryKey());

        districtImpl.setUuid(district.getUuid());
        districtImpl.setDistrictId(district.getDistrictId());
        districtImpl.setName(district.getName());
        districtImpl.setNumber(district.getNumber());
        districtImpl.setStatus(district.isStatus());

        return districtImpl;
    }

    /**
     * Returns the district with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the district
     * @return the district
     * @throws ru.imagnifi.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByPrimaryKey(primaryKey);

        if (district == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDistrictException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return district;
    }

    /**
     * Returns the district with the primary key or throws a {@link ru.imagnifi.NoSuchDistrictException} if it could not be found.
     *
     * @param districtId the primary key of the district
     * @return the district
     * @throws ru.imagnifi.NoSuchDistrictException if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District findByPrimaryKey(long districtId)
        throws NoSuchDistrictException, SystemException {
        return findByPrimaryKey((Serializable) districtId);
    }

    /**
     * Returns the district with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the district
     * @return the district, or <code>null</code> if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        District district = (District) EntityCacheUtil.getResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                DistrictImpl.class, primaryKey);

        if (district == _nullDistrict) {
            return null;
        }

        if (district == null) {
            Session session = null;

            try {
                session = openSession();

                district = (District) session.get(DistrictImpl.class, primaryKey);

                if (district != null) {
                    cacheResult(district);
                } else {
                    EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                        DistrictImpl.class, primaryKey, _nullDistrict);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
                    DistrictImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return district;
    }

    /**
     * Returns the district with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param districtId the primary key of the district
     * @return the district, or <code>null</code> if a district with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public District fetchByPrimaryKey(long districtId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) districtId);
    }

    /**
     * Returns all the districts.
     *
     * @return the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the districts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @return the range of districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the districts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of districts
     * @param end the upper bound of the range of districts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<District> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<District> list = (List<District>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DISTRICT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DISTRICT;

                if (pagination) {
                    sql = sql.concat(DistrictModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<District>(list);
                } else {
                    list = (List<District>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the districts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (District district : findAll()) {
            remove(district);
        }
    }

    /**
     * Returns the number of districts.
     *
     * @return the number of districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_DISTRICT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the district persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.imagnifi.model.District")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<District>> listenersList = new ArrayList<ModelListener<District>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<District>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DistrictImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
