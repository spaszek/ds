package pl.spaszek.ds.domain.provider.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ApiInfo {

    public static final String C_API_KEY = "api_key";

    @Column(name = C_API_KEY)
    private String apiKey;

}
