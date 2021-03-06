/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.push.notifications.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.liferay.push.notifications.model.PushNotificationsDevice;
import com.liferay.push.notifications.model.PushNotificationsDeviceModel;
import com.liferay.push.notifications.model.PushNotificationsDeviceSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PushNotificationsDevice service. Represents a row in the &quot;PushNotificationsDevice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PushNotificationsDeviceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PushNotificationsDeviceImpl}.
 * </p>
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceImpl
 * @see PushNotificationsDevice
 * @see PushNotificationsDeviceModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PushNotificationsDeviceModelImpl extends BaseModelImpl<PushNotificationsDevice>
	implements PushNotificationsDeviceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a push notifications device model instance should use the {@link PushNotificationsDevice} interface instead.
	 */
	public static final String TABLE_NAME = "PushNotificationsDevice";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pushNotificationsDeviceId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "platform", Types.VARCHAR },
			{ "token", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("pushNotificationsDeviceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("platform", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("token", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table PushNotificationsDevice (pushNotificationsDeviceId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,platform VARCHAR(75) null,token STRING null)";
	public static final String TABLE_SQL_DROP = "drop table PushNotificationsDevice";
	public static final String ORDER_BY_JPQL = " ORDER BY pushNotificationsDevice.pushNotificationsDeviceId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PushNotificationsDevice.pushNotificationsDeviceId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.push.notifications.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.push.notifications.model.PushNotificationsDevice"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.push.notifications.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.push.notifications.model.PushNotificationsDevice"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.push.notifications.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.push.notifications.model.PushNotificationsDevice"),
			true);
	public static final long PLATFORM_COLUMN_BITMASK = 1L;
	public static final long TOKEN_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long PUSHNOTIFICATIONSDEVICEID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PushNotificationsDevice toModel(
		PushNotificationsDeviceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PushNotificationsDevice model = new PushNotificationsDeviceImpl();

		model.setPushNotificationsDeviceId(soapModel.getPushNotificationsDeviceId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setPlatform(soapModel.getPlatform());
		model.setToken(soapModel.getToken());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PushNotificationsDevice> toModels(
		PushNotificationsDeviceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PushNotificationsDevice> models = new ArrayList<PushNotificationsDevice>(soapModels.length);

		for (PushNotificationsDeviceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.push.notifications.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.push.notifications.model.PushNotificationsDevice"));

	public PushNotificationsDeviceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _pushNotificationsDeviceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPushNotificationsDeviceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pushNotificationsDeviceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PushNotificationsDevice.class;
	}

	@Override
	public String getModelClassName() {
		return PushNotificationsDevice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pushNotificationsDeviceId",
			getPushNotificationsDeviceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("platform", getPlatform());
		attributes.put("token", getToken());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pushNotificationsDeviceId = (Long)attributes.get(
				"pushNotificationsDeviceId");

		if (pushNotificationsDeviceId != null) {
			setPushNotificationsDeviceId(pushNotificationsDeviceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}
	}

	@JSON
	@Override
	public long getPushNotificationsDeviceId() {
		return _pushNotificationsDeviceId;
	}

	@Override
	public void setPushNotificationsDeviceId(long pushNotificationsDeviceId) {
		_pushNotificationsDeviceId = pushNotificationsDeviceId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getPlatform() {
		if (_platform == null) {
			return "";
		}
		else {
			return _platform;
		}
	}

	@Override
	public void setPlatform(String platform) {
		_columnBitmask |= PLATFORM_COLUMN_BITMASK;

		if (_originalPlatform == null) {
			_originalPlatform = _platform;
		}

		_platform = platform;
	}

	public String getOriginalPlatform() {
		return GetterUtil.getString(_originalPlatform);
	}

	@JSON
	@Override
	public String getToken() {
		if (_token == null) {
			return "";
		}
		else {
			return _token;
		}
	}

	@Override
	public void setToken(String token) {
		_columnBitmask |= TOKEN_COLUMN_BITMASK;

		if (_originalToken == null) {
			_originalToken = _token;
		}

		_token = token;
	}

	public String getOriginalToken() {
		return GetterUtil.getString(_originalToken);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PushNotificationsDevice.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PushNotificationsDevice toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PushNotificationsDevice)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PushNotificationsDeviceImpl pushNotificationsDeviceImpl = new PushNotificationsDeviceImpl();

		pushNotificationsDeviceImpl.setPushNotificationsDeviceId(getPushNotificationsDeviceId());
		pushNotificationsDeviceImpl.setCompanyId(getCompanyId());
		pushNotificationsDeviceImpl.setUserId(getUserId());
		pushNotificationsDeviceImpl.setCreateDate(getCreateDate());
		pushNotificationsDeviceImpl.setPlatform(getPlatform());
		pushNotificationsDeviceImpl.setToken(getToken());

		pushNotificationsDeviceImpl.resetOriginalValues();

		return pushNotificationsDeviceImpl;
	}

	@Override
	public int compareTo(PushNotificationsDevice pushNotificationsDevice) {
		long primaryKey = pushNotificationsDevice.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PushNotificationsDevice)) {
			return false;
		}

		PushNotificationsDevice pushNotificationsDevice = (PushNotificationsDevice)obj;

		long primaryKey = pushNotificationsDevice.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PushNotificationsDeviceModelImpl pushNotificationsDeviceModelImpl = this;

		pushNotificationsDeviceModelImpl._originalUserId = pushNotificationsDeviceModelImpl._userId;

		pushNotificationsDeviceModelImpl._setOriginalUserId = false;

		pushNotificationsDeviceModelImpl._originalPlatform = pushNotificationsDeviceModelImpl._platform;

		pushNotificationsDeviceModelImpl._originalToken = pushNotificationsDeviceModelImpl._token;

		pushNotificationsDeviceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PushNotificationsDevice> toCacheModel() {
		PushNotificationsDeviceCacheModel pushNotificationsDeviceCacheModel = new PushNotificationsDeviceCacheModel();

		pushNotificationsDeviceCacheModel.pushNotificationsDeviceId = getPushNotificationsDeviceId();

		pushNotificationsDeviceCacheModel.companyId = getCompanyId();

		pushNotificationsDeviceCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			pushNotificationsDeviceCacheModel.createDate = createDate.getTime();
		}
		else {
			pushNotificationsDeviceCacheModel.createDate = Long.MIN_VALUE;
		}

		pushNotificationsDeviceCacheModel.platform = getPlatform();

		String platform = pushNotificationsDeviceCacheModel.platform;

		if ((platform != null) && (platform.length() == 0)) {
			pushNotificationsDeviceCacheModel.platform = null;
		}

		pushNotificationsDeviceCacheModel.token = getToken();

		String token = pushNotificationsDeviceCacheModel.token;

		if ((token != null) && (token.length() == 0)) {
			pushNotificationsDeviceCacheModel.token = null;
		}

		return pushNotificationsDeviceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{pushNotificationsDeviceId=");
		sb.append(getPushNotificationsDeviceId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", platform=");
		sb.append(getPlatform());
		sb.append(", token=");
		sb.append(getToken());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.push.notifications.model.PushNotificationsDevice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pushNotificationsDeviceId</column-name><column-value><![CDATA[");
		sb.append(getPushNotificationsDeviceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>platform</column-name><column-value><![CDATA[");
		sb.append(getPlatform());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>token</column-name><column-value><![CDATA[");
		sb.append(getToken());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PushNotificationsDevice.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PushNotificationsDevice.class, ModelWrapper.class
		};
	private long _pushNotificationsDeviceId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private String _platform;
	private String _originalPlatform;
	private String _token;
	private String _originalToken;
	private long _columnBitmask;
	private PushNotificationsDevice _escapedModel;
}