<%--
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
--%>

<%@ include file="/site_browser/init.jsp" %>

<%
String emptyResultsMessage = GetterUtil.getString(request.getAttribute("liferay-site:site-browser:emptyResultsMessage"));
String eventName = GetterUtil.getString(request.getAttribute("liferay-site:site-browser:eventName"));
List<Group> groups = (List<Group>)request.getAttribute("liferay-site:site-browser:groups");
int groupsCount = GetterUtil.getInteger(request.getAttribute("liferay-site:site-browser:groupsCount"));
long[] selectedGroupIds = GetterUtil.getLongValues(request.getAttribute("liferay-site:site-browser:selectedGroupIds"));
boolean showSearch = GetterUtil.getBoolean(request.getAttribute("liferay-site:site-browser:showSearch"));
%>

<clay:management-toolbar
	clearResultsURL="<%= siteBrowserDisplayContext.getClearResultsURL() %>"
	filterDropdownItems="<%= siteBrowserDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= groupsCount %>"
	searchActionURL="<%= siteBrowserDisplayContext.getSearchActionURL() %>"
	selectable="<%= false %>"
	showSearch="<%= showSearch %>"
	sortingOrder="<%= siteBrowserDisplayContext.getOrderByType() %>"
	sortingURL="<%= siteBrowserDisplayContext.getSortingURL() %>"
	viewTypeItems="<%= siteBrowserDisplayContext.getViewTypeItems() %>"
/>

<aui:form action="<%= siteBrowserDisplayContext.getPortletURL() %>" cssClass="container-fluid-1280" method="post" name="selectGroupFm">
	<liferay-ui:search-container
		emptyResultsMessage="<%= emptyResultsMessage %>"
		iteratorURL="<%= siteBrowserDisplayContext.getPortletURL() %>"
		total="<%= groupsCount %>"
	>
		<liferay-ui:search-container-results
			results="<%= groups %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.Group"
			escapedModel="<%= true %>"
			keyProperty="groupId"
			modelVar="group"
			rowIdProperty="friendlyURL"
			rowVar="row"
		>

			<%
			Map<String, Object> data = new HashMap<String, Object>();

			data.put("groupdescriptivename", group.getDescriptiveName(locale));
			data.put("groupid", group.getGroupId());
			data.put("grouptype", LanguageUtil.get(request, group.getTypeLabel()));
			data.put("url", group.getDisplayURL(themeDisplay));
			data.put("uuid", group.getUuid());
			%>

			<c:choose>
				<c:when test='<%= Objects.equals(siteBrowserDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-icon
						icon="sites"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<c:choose>
								<c:when test="<%= ArrayUtil.contains(selectedGroupIds, group.getGroupId()) %>">
									<span class="text-muted">
										<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
									</span>
								</c:when>
								<c:otherwise>
									<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
										<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
									</aui:a>
								</c:otherwise>
							</c:choose>
						</h5>

						<h6 class="text-default">
							<span><%= LanguageUtil.get(request, group.getScopeLabel(themeDisplay)) %></span>
						</h6>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(siteBrowserDisplayContext.getDisplayStyle(), "icon") %>'>

					<%
					row.setCssClass("entry-card lfr-asset-item " + row.getCssClass());

					Map<String, Object> linkData = new HashMap<String, Object>();

					linkData.put("prevent-selection", true);
					%>

					<liferay-ui:search-container-column-text>
						<div <%= !ArrayUtil.contains(selectedGroupIds, group.getGroupId()) ? "role='button'" : StringPool.BLANK %>>
							<c:choose>
								<c:when test="<%= Validator.isNotNull(group.getLogoURL(themeDisplay, false)) %>">
									<liferay-frontend:vertical-card
										cssClass='<%= ArrayUtil.contains(selectedGroupIds, group.getGroupId()) ? "text-muted" : "selector-button" %>'
										data="<%= data %>"
										imageUrl="<%= group.getLogoURL(themeDisplay, false) %>"
										resultRow="<%= row %>"
										rowChecker="<%= searchContainer.getRowChecker() %>"
										showCheckbox="<%= false %>"
										title="<%= group.getDescriptiveName(locale) %>"
									/>
								</c:when>
								<c:otherwise>
									<liferay-frontend:icon-vertical-card
										cssClass='<%= ArrayUtil.contains(selectedGroupIds, group.getGroupId()) ? "text-muted" : "selector-button" %>'
										data="<%= data %>"
										icon="sites"
										resultRow="<%= row %>"
										rowChecker="<%= searchContainer.getRowChecker() %>"
										showCheckbox="<%= false %>"
										title="<%= group.getDescriptiveName(locale) %>"
									/>
								</c:otherwise>
							</c:choose>
						</div>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(siteBrowserDisplayContext.getDisplayStyle(), "list") %>'>
					<liferay-ui:search-container-column-text
						name="name"
						truncate="<%= true %>"
					>
						<c:choose>
							<c:when test="<%= ArrayUtil.contains(selectedGroupIds, group.getGroupId()) %>">
								<span class="text-muted">
									<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
								</span>
							</c:when>
							<c:otherwise>
								<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
									<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
								</aui:a>
							</c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="type"
						value="<%= LanguageUtil.get(request, group.getScopeLabel(themeDisplay)) %>"
					/>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= siteBrowserDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	Liferay.Util.selectEntityHandler('#<portlet:namespace />selectGroupFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>