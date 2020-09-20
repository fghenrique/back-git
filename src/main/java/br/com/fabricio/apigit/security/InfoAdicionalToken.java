package br.com.fabricio.apigit.security;

import br.com.fabricio.apigit.models.Usuarios;
import br.com.fabricio.apigit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UsuariosService usrService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<String, Object>();

        Usuarios usuario = usrService.findByLogin(authentication.getName());
        info.put("name", usuario.getNome());
        info.put("login", usuario.getLogin());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
