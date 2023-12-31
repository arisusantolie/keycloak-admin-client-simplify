package org.keycloak.admin.client.simplify.reprensetation.realm;

public class EmailRepresentation {

    private String host;
    private Integer port;
    private String from;
    private String fromDisplayName;
    private String replyToDisplayName;
    private String replyTo;
    private String envelopeFrom;
    private Boolean ssl;
    private Boolean starttls;
    private Boolean auth;
    private String user;
    private String password;

    public EmailRepresentation() {
    }

    public EmailRepresentation(String host, Integer port, String from, String fromDisplayName, String replyToDisplayName, String replyTo, String envelopeFrom, Boolean ssl, Boolean starttls, Boolean auth, String user, String password) {
        this.host = host;
        this.port = port;
        this.from = from;
        this.fromDisplayName = fromDisplayName;
        this.replyToDisplayName = replyToDisplayName;
        this.replyTo = replyTo;
        this.envelopeFrom = envelopeFrom;
        this.ssl = ssl;
        this.starttls = starttls;
        this.auth = auth;
        this.user = user;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromDisplayName() {
        return fromDisplayName;
    }

    public void setFromDisplayName(String fromDisplayName) {
        this.fromDisplayName = fromDisplayName;
    }

    public String getReplyToDisplayName() {
        return replyToDisplayName;
    }

    public void setReplyToDisplayName(String replyToDisplayName) {
        this.replyToDisplayName = replyToDisplayName;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getEnvelopeFrom() {
        return envelopeFrom;
    }

    public void setEnvelopeFrom(String envelopeFrom) {
        this.envelopeFrom = envelopeFrom;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public Boolean getStarttls() {
        return starttls;
    }

    public void setStarttls(Boolean starttls) {
        this.starttls = starttls;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
