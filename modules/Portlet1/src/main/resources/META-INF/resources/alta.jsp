<%@ include file="/init.jsp"%>

<portlet:actionURL var="homeUrl" name="homeRedirect" />
<portlet:actionURL var="altaUrl" name="create" />
<!-- altaCliente es el metodo del Portlet -->


<aui:container>
	<aui:row>
		<aui:col lg="12" md="12" sm="12" xs="12">
			<h2>
				<aui:button cssClass="btn btn-info" type="button"
					icon="icon-chevron-left" href="${homeUrl}" />
				<liferay-ui:message key="portletvass.alta.title" />
			</h2>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:form action="${altaUrl}" name="<portlet:namespace />create"
			enctype="multipart/form-data" cssClass="maxWidth form">
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
									style="background-image: url(<%=request.getContextPath()%>/images/avatar.png);">
								</div>
							</div>
						</div>
					</aui:fieldset>
				</aui:col>
				<aui:col lg="8" md="8" sm="12" xs="12">
					<aui:fieldset label="portletvass.alta.personalInfo">
						<aui:input name="nombre" type="text"
							label="portletvass.alta.nombre" />
						<aui:input name="apellidos" type="text"
							label="portletvass.alta.apellidos" />
						<aui:input name="nif" type="text" label="portletvass.alta.nif" />
						<aui:input name="email" type="email" label="portletvass.alta.mail" />
						<aui:input name="descripcion" type="textarea"
							label="portletvass.alta.descripcion" />
					</aui:fieldset>
				</aui:col>
			</aui:row>

			<aui:button-row>
				<aui:button type="submit" value="portletvass.alta.guardar"></aui:button>
				<a href="${volver}"> <aui:button type="cancel"
						value="portletvass.alta.cancel"></aui:button>
				</a>
			</aui:button-row>
		</aui:form>
	</aui:row>

</aui:container>