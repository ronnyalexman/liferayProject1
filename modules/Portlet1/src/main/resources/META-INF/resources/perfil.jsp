<%@page import="java.util.HashMap"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL var="llistaUrl" name="readRedirect" />
<portlet:actionURL var="homeUrl" name="homeRedirect" />
<portlet:actionURL var="updateUrl" name="update" />
<!-- altaCliente es el metodo del Portlet -->

<jsp:useBean id="modal" class="java.util.HashMap" scope="request" />
<c:set target="${modal}" property="toggle" value="modal" />
<c:set target="${modal}" property="target" value="#popUp" />

<aui:container>
	<aui:row>
		<aui:col lg="12" md="12" sm="12" xs="12">
			<h2>
				<aui:button cssClass="btn btn-info" type="button"
					icon="icon-chevron-left" href="${llistaUrl}" />
				<liferay-ui:message key="portletvass.perfil.title" />
			</h2>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:form action="${updateUrl}" name="update"
			enctype="multipart/form-data" cssClass="maxWidth">
			<aui:row>
				<aui:col lg="4" md="4" sm="12" xs="12">
					<aui:fieldset label="portletvass.alta.pic" cssClass="pictureField">
						<div class="avatar-upload">
							<div class="avatar-edit">
								<input type="file" id="imageUpload" accept=".png, .jpg, .jpeg"
									name="<portlet:namespace />imagen" /> <label for="imageUpload"></label>
							</div>
							<div class="avatar-preview">
								<div id="imagePreview"
									style="background-image: url(${cliente.imagen});"></div>
								<aui:input name="update_img" type="hidden" value="false" />
							</div>
						</div>
						<aui:button-row>
							<c:set target="${modal}" property="email"
								value="${cliente.email}" />
							
							<aui:button type="button" value="portletvass.perfil.sendEmail"
								cssClass="btn btn-primary" data="${modal}"></aui:button>
							<aui:button type="button" cssClass="btn btn-danger"
								value="portletvass.perfil.borrar" href="${homeUrl}"></aui:button>
						</aui:button-row>
					</aui:fieldset>
				</aui:col>
				<aui:col lg="8" md="8" sm="12" xs="12">
					<aui:fieldset label="portletvass.alta.personalInfo">
						<aui:input name="nombre" type="text"
							label="portletvass.alta.nombre" value="${cliente.nombre}" />

						<aui:input name="apellidos" type="text"
							label="portletvass.alta.apellidos" value="${cliente.apellidos}" />

						<aui:input name="readOnly" type="text"
							label="portletvass.alta.nif" value="${cliente.nif}"
							disabled="true" />

						<aui:input name="nif" type="hidden" value="${cliente.nif}"
							readOnly="true" />

						<aui:input name="email" type="email" label="portletvass.alta.mail"
							value="${cliente.email}" />

						<aui:input name="descripcion" type="textarea"
							label="portletvass.alta.descripcion"
							value="${cliente.descripcion}" />
					</aui:fieldset>
				</aui:col>
			</aui:row>

			<aui:button-row>
				<aui:button type="submit" value="portletvass.perfil.actualizar"></aui:button>
				<aui:button type="button" cssClass="btn btn-danger"
					value="portletvass.perfil.cancel" href="${homeUrl}"></aui:button>
			</aui:button-row>
		</aui:form>
	</aui:row>
</aui:container>
<%@ include file="/jsp/modal/contactProfile.jsp"%>