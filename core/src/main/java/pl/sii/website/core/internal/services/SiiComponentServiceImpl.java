package pl.sii.website.core.internal.services;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import pl.sii.website.core.services.SiiComponentService;

@Component(service = SiiComponentService.class, immediate = true)
@Designate(ocd = SiiComponentServiceImpl.SiiComponentServiceConfig.class)
public class SiiComponentServiceImpl implements SiiComponentService {

    private String configEntry;

    public String getConfigEntry() {
        return configEntry;
    }

    @Activate
    protected void activate(SiiComponentServiceConfig config) {
        this.configEntry = config.configEntry();
    }

    @Override
    public String execute(ResourceResolver resolver) {
        return null;
    }

    @ObjectClassDefinition(name = "Sii Component Configuration")
    public @interface SiiComponentServiceConfig {

        @AttributeDefinition(name = "Content Entry",
                defaultValue = {"local"})
        String configEntry();

    }
}
