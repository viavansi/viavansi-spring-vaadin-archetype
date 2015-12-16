package ${package}.service;

import ${package}.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class ApplicationClientDetailsService implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        BaseClientDetails clientDetails;

        // TODO: load client details form database
        switch (clientId) {
            case "clientapp":
                clientDetails = new BaseClientDetails(clientId, ResourceServerConfiguration.REST_RESOURCE_ID, "read,write", "password, refresh_token", "REST_CLIENT");
                clientDetails.setClientSecret("123456");
                break;
            default:
                throw new NoSuchClientException("No client with requested id: " + clientId);
        }

        return clientDetails;
    }
}
