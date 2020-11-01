package com.example.user.mymap;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Sd on 25.02.2017.
 */

public class ResponcesService {
    private String version;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponcesService() {
    }

    /**
     *
     * @param version
     */
    public ResponcesService(String version) {
        super();
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
