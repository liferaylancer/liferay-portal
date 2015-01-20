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

package com.liferay.portlet.dynamicdatamapping.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.LocalizedModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the DDMTemplate service. Represents a row in the &quot;DDMTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMTemplateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMTemplateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMTemplate
 * @see com.liferay.portlet.dynamicdatamapping.model.impl.DDMTemplateImpl
 * @see com.liferay.portlet.dynamicdatamapping.model.impl.DDMTemplateModelImpl
 * @generated
 */
@ProviderType
public interface DDMTemplateModel extends AttachedModel, BaseModel<DDMTemplate>,
	LocalizedModel, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a d d m template model instance should use the {@link DDMTemplate} interface instead.
	 */

	/**
	 * Returns the primary key of this d d m template.
	 *
	 * @return the primary key of this d d m template
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this d d m template.
	 *
	 * @param primaryKey the primary key of this d d m template
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this d d m template.
	 *
	 * @return the uuid of this d d m template
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this d d m template.
	 *
	 * @param uuid the uuid of this d d m template
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the template ID of this d d m template.
	 *
	 * @return the template ID of this d d m template
	 */
	public long getTemplateId();

	/**
	 * Sets the template ID of this d d m template.
	 *
	 * @param templateId the template ID of this d d m template
	 */
	public void setTemplateId(long templateId);

	/**
	 * Returns the group ID of this d d m template.
	 *
	 * @return the group ID of this d d m template
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this d d m template.
	 *
	 * @param groupId the group ID of this d d m template
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this d d m template.
	 *
	 * @return the company ID of this d d m template
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this d d m template.
	 *
	 * @param companyId the company ID of this d d m template
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this d d m template.
	 *
	 * @return the user ID of this d d m template
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this d d m template.
	 *
	 * @param userId the user ID of this d d m template
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this d d m template.
	 *
	 * @return the user uuid of this d d m template
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this d d m template.
	 *
	 * @param userUuid the user uuid of this d d m template
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this d d m template.
	 *
	 * @return the user name of this d d m template
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this d d m template.
	 *
	 * @param userName the user name of this d d m template
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this d d m template.
	 *
	 * @return the create date of this d d m template
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this d d m template.
	 *
	 * @param createDate the create date of this d d m template
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this d d m template.
	 *
	 * @return the modified date of this d d m template
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this d d m template.
	 *
	 * @param modifiedDate the modified date of this d d m template
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this d d m template.
	 *
	 * @return the fully qualified class name of this d d m template
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this d d m template.
	 *
	 * @return the class name ID of this d d m template
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this d d m template.
	 *
	 * @param classNameId the class name ID of this d d m template
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this d d m template.
	 *
	 * @return the class p k of this d d m template
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this d d m template.
	 *
	 * @param classPK the class p k of this d d m template
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the source class name ID of this d d m template.
	 *
	 * @return the source class name ID of this d d m template
	 */
	public long getSourceClassNameId();

	/**
	 * Sets the source class name ID of this d d m template.
	 *
	 * @param sourceClassNameId the source class name ID of this d d m template
	 */
	public void setSourceClassNameId(long sourceClassNameId);

	/**
	 * Returns the template key of this d d m template.
	 *
	 * @return the template key of this d d m template
	 */
	public String getTemplateKey();

	/**
	 * Sets the template key of this d d m template.
	 *
	 * @param templateKey the template key of this d d m template
	 */
	public void setTemplateKey(String templateKey);

	/**
	 * Returns the version of this d d m template.
	 *
	 * @return the version of this d d m template
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this d d m template.
	 *
	 * @param version the version of this d d m template
	 */
	public void setVersion(String version);

	/**
	 * Returns the name of this d d m template.
	 *
	 * @return the name of this d d m template
	 */
	public String getName();

	/**
	 * Returns the localized name of this d d m template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this d d m template
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this d d m template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this d d m template. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this d d m template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this d d m template
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this d d m template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this d d m template
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this d d m template.
	 *
	 * @return the locales and localized names of this d d m template
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this d d m template.
	 *
	 * @param name the name of this d d m template
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this d d m template in the language.
	 *
	 * @param name the localized name of this d d m template
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this d d m template in the language, and sets the default locale.
	 *
	 * @param name the localized name of this d d m template
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this d d m template from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this d d m template
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this d d m template from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this d d m template
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the description of this d d m template.
	 *
	 * @return the description of this d d m template
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this d d m template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this d d m template
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this d d m template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this d d m template. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this d d m template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this d d m template
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this d d m template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this d d m template
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this d d m template.
	 *
	 * @return the locales and localized descriptions of this d d m template
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this d d m template.
	 *
	 * @param description the description of this d d m template
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this d d m template in the language.
	 *
	 * @param description the localized description of this d d m template
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this d d m template in the language, and sets the default locale.
	 *
	 * @param description the localized description of this d d m template
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this d d m template from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this d d m template
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this d d m template from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this d d m template
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the type of this d d m template.
	 *
	 * @return the type of this d d m template
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this d d m template.
	 *
	 * @param type the type of this d d m template
	 */
	public void setType(String type);

	/**
	 * Returns the mode of this d d m template.
	 *
	 * @return the mode of this d d m template
	 */
	@AutoEscape
	public String getMode();

	/**
	 * Sets the mode of this d d m template.
	 *
	 * @param mode the mode of this d d m template
	 */
	public void setMode(String mode);

	/**
	 * Returns the language of this d d m template.
	 *
	 * @return the language of this d d m template
	 */
	@AutoEscape
	public String getLanguage();

	/**
	 * Sets the language of this d d m template.
	 *
	 * @param language the language of this d d m template
	 */
	public void setLanguage(String language);

	/**
	 * Returns the script of this d d m template.
	 *
	 * @return the script of this d d m template
	 */
	@AutoEscape
	public String getScript();

	/**
	 * Sets the script of this d d m template.
	 *
	 * @param script the script of this d d m template
	 */
	public void setScript(String script);

	/**
	 * Returns the cacheable of this d d m template.
	 *
	 * @return the cacheable of this d d m template
	 */
	public boolean getCacheable();

	/**
	 * Returns <code>true</code> if this d d m template is cacheable.
	 *
	 * @return <code>true</code> if this d d m template is cacheable; <code>false</code> otherwise
	 */
	public boolean isCacheable();

	/**
	 * Sets whether this d d m template is cacheable.
	 *
	 * @param cacheable the cacheable of this d d m template
	 */
	public void setCacheable(boolean cacheable);

	/**
	 * Returns the small image of this d d m template.
	 *
	 * @return the small image of this d d m template
	 */
	public boolean getSmallImage();

	/**
	 * Returns <code>true</code> if this d d m template is small image.
	 *
	 * @return <code>true</code> if this d d m template is small image; <code>false</code> otherwise
	 */
	public boolean isSmallImage();

	/**
	 * Sets whether this d d m template is small image.
	 *
	 * @param smallImage the small image of this d d m template
	 */
	public void setSmallImage(boolean smallImage);

	/**
	 * Returns the small image ID of this d d m template.
	 *
	 * @return the small image ID of this d d m template
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image ID of this d d m template.
	 *
	 * @param smallImageId the small image ID of this d d m template
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Returns the small image u r l of this d d m template.
	 *
	 * @return the small image u r l of this d d m template
	 */
	@AutoEscape
	public String getSmallImageURL();

	/**
	 * Sets the small image u r l of this d d m template.
	 *
	 * @param smallImageURL the small image u r l of this d d m template
	 */
	public void setSmallImageURL(String smallImageURL);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.portlet.dynamicdatamapping.model.DDMTemplate ddmTemplate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.portlet.dynamicdatamapping.model.DDMTemplate> toCacheModel();

	@Override
	public com.liferay.portlet.dynamicdatamapping.model.DDMTemplate toEscapedModel();

	@Override
	public com.liferay.portlet.dynamicdatamapping.model.DDMTemplate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}