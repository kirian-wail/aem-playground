package pl.sii.website.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exadel.aem.toolkit.api.annotations.editconfig.ActionConstants;
import com.exadel.aem.toolkit.api.annotations.editconfig.EditConfig;
import com.exadel.aem.toolkit.api.annotations.main.AemComponent;
import com.exadel.aem.toolkit.api.annotations.main.Dialog;
import com.exadel.aem.toolkit.api.annotations.widgets.DialogField;
import com.exadel.aem.toolkit.api.annotations.widgets.PathField;
import com.exadel.aem.toolkit.api.annotations.widgets.TextField;

import lombok.Getter;
import pl.sii.website.core.services.SiiComponentService;

/**
 * The Class SiiComponent.
 *
 * @author Jaroslav Rassadin
 */
@Model(
		adaptables = Resource.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@AemComponent(
		path = "siicomponent2",
		title = "Global Sii Component - Version 2",
		componentGroup = "Sii Official Website - Content")
@Dialog(
		width = 600,
		height = 800,
		helpPath = "https://acme.com/docs")
@EditConfig(
		actions = { ActionConstants.EDIT, ActionConstants.DELETE, ActionConstants.COPYMOVE, ActionConstants.INSERT })
public class SiiComponent {

	private static final Logger LOG = LoggerFactory.getLogger(SiiComponent.class);

	@Getter
	@ValueMapValue
	@TextField
	@DialogField(
			label = "Text",
			description = "The text to display on the component.")
	private String text;

	@Getter
	@ValueMapValue
	@PathField(
			rootPath = "/content")
	@DialogField(
			label = "Link",
			description = "Link to a content page, external URL or page anchor.")
	private String link;

	@Getter
	@ValueMapValue
	@TextField
	@DialogField(
			label = "ID",
			description = "HTML ID attribute to apply to the component.",
			validation = "html-unique-id-validator")
	private String id;

	@SlingObject
	private ResourceResolver resourceResolver;

	@OSGiService
	private SiiComponentService siiComponentService;

	@Getter
	private String path;

	@Getter
	private String path2;

	/**
	 * Initialize the model.
	 */
	@PostConstruct
	public void initialize() {
		try {
			this.path = this.siiComponentService.execute(this.resourceResolver);
			this.path2 = this.siiComponentService.execute();

		} catch (final Exception ex) {
			LOG.error("An error has occurred while initializing the model.", ex);
		}
	}

}
